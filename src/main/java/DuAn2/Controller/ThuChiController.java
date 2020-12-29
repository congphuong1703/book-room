package DuAn2.Controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.ThuChi;
import DuAn2.Services.ThuChiService;

@Controller
@Transactional
public class ThuChiController {

	Double tongTienThu = 0D;
	Double tongTienChi = 0D;
	
	@Autowired
	ThuChiService thuChiService;
	
	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "thuchi";
	}
	
	private void activemenu(ModelMap model) {
		// active trên menu
		model.addAttribute("activethuchi", "active");

	}
	
	public void checkTongTienNull(Double tongTienThu, Double tongTienChi) {
		if (tongTienThu == null) {
			this.tongTienThu = 0D;
		}
		if (tongTienChi == null) {
			this.tongTienChi = 0D;
		}
	}
	@GetMapping("/thuchi")
	public String thuchi(ModelMap model) {
		vitrihientai = 1;
		PageRequest pageable = PageRequest.of(0, 10);
		List<ThuChi> l = thuChiService.getThuChi(pageable);
		tongTienThu = thuChiService.getTongThu();
		tongTienChi = thuChiService.getTongChi();
		checkTongTienNull(tongTienThu, tongTienChi);
		
		model.addAttribute("tongTienThu", tongTienThu);
		model.addAttribute("tongTienChi", tongTienChi);
		
		model.addAttribute("titlepage", "Danh sách thu chi");
		activemenu(model);
		model.addAttribute("l", l);
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(thuChiService.countThuChi(), model));
		return "thuchi/danhsachthuchi";
	}
	
	@GetMapping("/timthuchi")
	public String timthuchi(ModelMap model, @RequestParam("tungay") String tungay, @RequestParam("denngay") String denngay) throws ParseException {
		PageRequest pageable = PageRequest.of(0, 10);
		List<ThuChi> ltim;
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		ltim = thuChiService.getTimThuChi(new Date(fm.parse(tungay).getTime()), new Date(fm.parse(denngay).getTime()), pageable);
		model.addAttribute("tungay", tungay);
		model.addAttribute("denngay", denngay);
		Date d1 = new Date(fm.parse(tungay).getTime());
		Date d2 = new Date(fm.parse(denngay).getTime());
		tongTienThu = thuChiService.getTongThuTim(d1, d2);
		tongTienChi = thuChiService.getTongChiTim(d1, d2);
		checkTongTienNull(tongTienThu, tongTienChi);
		
		model.addAttribute("tongTienThu", tongTienThu);
		model.addAttribute("tongTienChi", tongTienChi);
		vitrihientai = 1;
		model.addAttribute("titlepage", "Danh sách thu chi");
		activemenu(model);
		
		model.addAttribute("l", ltim);
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(thuChiService.countThuChiTim(d1, d2), model));
		model.addAttribute("danhsachtim", 1);
		model.addAttribute("danhsach", 0);
		return "thuchi/danhsachthuchi";
	}
	
	@GetMapping("/themthuchi")
	public String themthuchi(ModelMap model) {
		ThuChi thuchi = new ThuChi();
		model.addAttribute("thuchi", thuchi);
		model.addAttribute("titlepage", "Thêm mới thu chi");
		activemenu(model);
		return "thuchi/themthuchi";
	}
	
	@PostMapping("/themthuchipost")
	public String themthuchipost(ModelMap model,HttpServletRequest httpServletRequest, @ModelAttribute("thuchi") ThuChi thuchi) {
		HttpSession session = httpServletRequest.getSession();
		String nguoiDung = session.getAttribute("nguoidung").toString();
		java.util.Date dateutil = new java.util.Date();
		Date date = new Date(dateutil.getTime());
		thuchi.setGioChi(dateutil);
		thuchi.setNgayChi(date);
		thuchi.setTenDangNhap(nguoiDung);
		thuChiService.save(thuchi);
		model.addAttribute("message", "Thêm thành công");
		return themthuchi(model);
	}
	
	@GetMapping("/actionxoathuchi")
	public String themthuchi(ModelMap model, HttpServletRequest request, @RequestParam("maThuChi") Integer maThuChi) {
		HttpSession session = request.getSession();
		if (session.getAttribute("chucvu").equals("1")) {
			thuChiService.deleteById(maThuChi);
			model.addAttribute("message", "Xóa thành công");
		}
		return thuchi(model);
	}
	
	int vitrihientai = 1;
	// số lượng button bấm chuyển trang
		public List<Integer> listSoLuongTrang(Double count, ModelMap model) {
			List<Integer> lreturn = new ArrayList<>();
			double temp = Double.parseDouble(count + "") / 10.0;
			int tempfor = (int) Math.ceil(temp);
			int a = 3;
			int b = 3;

			if (vitrihientai == 1) {
				a = 0;
				b = 6;
			}
			if (vitrihientai == 2) {
				a = 1;
				b = 5;
			}
			if (vitrihientai == 3) {
				a = 2;
				b = 4;
			}
			if (vitrihientai == 4) {
				a = 3;
				b = 3;
			}

			if (vitrihientai == tempfor) {
				a = 6;
				b = 0;
			}
			if (vitrihientai == (tempfor - 1)) {
				a = 5;
				b = 1;
			}
			if (vitrihientai == (tempfor - 2)) {
				a = 4;
				b = 2;
			}
			if (vitrihientai == (tempfor - 3)) {
				a = 3;
				b = 3;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor) {
				a = 0;
				b = 0;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 1) {
				a = 0;
				b = 1;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 2) {
				a = 0;
				b = 2;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 3) {
				a = 0;
				b = 3;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 4) {
				a = 0;
				b = 4;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 5) {
				a = 0;
				b = 5;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 6) {
				a = 0;
				b = 6;
			}

			// -------------
			if (vitrihientai == 2 && vitrihientai == tempfor) {
				a = 1;
				b = 0;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 1) {
				a = 1;
				b = 1;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 2) {
				a = 1;
				b = 2;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 3) {
				a = 1;
				b = 3;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 4) {
				a = 1;
				b = 4;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 5) {
				a = 1;
				b = 5;
			}
			// -------------
			if (vitrihientai == 3 && vitrihientai == tempfor) {
				a = 2;
				b = 0;
			}
			if (vitrihientai == 3 && vitrihientai == tempfor - 1) {
				a = 2;
				b = 1;
			}
			if (vitrihientai == 3 && vitrihientai == tempfor - 2) {
				a = 2;
				b = 2;
			}
			if (vitrihientai == 3 && vitrihientai == tempfor - 3) {
				a = 2;
				b = 3;
			}
			if (vitrihientai == 3 && vitrihientai == tempfor - 4) {
				a = 2;
				b = 4;
			}
			// -------------
			if (vitrihientai == 4 && vitrihientai == tempfor) {
				a = 3;
				b = 0;
			}
			if (vitrihientai == 4 && vitrihientai == tempfor - 1) {
				a = 3;
				b = 1;
			}
			if (vitrihientai == 4 && vitrihientai == tempfor - 2) {
				a = 3;
				b = 2;
			}
			if (vitrihientai == 4 && vitrihientai == tempfor - 3) {
				a = 3;
				b = 3;
			}
			// -------------
			if (vitrihientai == 5 && vitrihientai == tempfor) {
				a = 4;
				b = 0;
			}
			if (vitrihientai == 5 && vitrihientai == tempfor - 1) {
				a = 4;
				b = 1;
			}
			if (vitrihientai == 5 && vitrihientai == tempfor - 2) {
				a = 4;
				b = 2;
			}
			if (vitrihientai == 5 && vitrihientai == tempfor - 3) {
				a = 4;
				b = 3;
			}
			// -------------
			if (vitrihientai == 6 && vitrihientai == tempfor) {
				a = 5;
				b = 0;
			}
			if (vitrihientai == 6 && vitrihientai == tempfor - 1) {
				a = 5;
				b = 1;
			}
			if (vitrihientai == 6 && vitrihientai == tempfor - 2) {
				a = 5;
				b = 2;
			}
			if (vitrihientai == 6 && vitrihientai == tempfor - 3) {
				a = 5;
				b = 3;
			}

			for (int i = vitrihientai - a; i <= vitrihientai + b; i++) {
				lreturn.add(i);
			}
			if (count.intValue() == 0) {
				lreturn.clear();
			}
			model.addAttribute("danhsach", count.intValue()); // để ẩn thanh button trang khi danh sách trống
			model.addAttribute("trangdau", 1);
			model.addAttribute("trangcuoi", tempfor);
			model.addAttribute("vitrihientai", vitrihientai);
			return lreturn;
		}
		
		// khi chọn button thì chạy cái này. lấy page xuất danh sách
		@RequestMapping("/thuchipage")
		public String thuchipage(ModelMap model, @RequestParam("page") int page) {
			activemenu(model);
			PageRequest pageable = PageRequest.of(page - 1, 10);
			List<ThuChi> l = thuChiService.getThuChi(pageable);
			
			tongTienThu = thuChiService.getTongThu();
			tongTienChi = thuChiService.getTongChi();
			checkTongTienNull(tongTienThu, tongTienChi);
			
			model.addAttribute("tongTienThu", tongTienThu);
			model.addAttribute("tongTienChi", tongTienChi);
			model.addAttribute("titlepage", "Danh sách thu chi");
			vitrihientai = page;

			model.addAttribute("l", l);
			model.addAttribute("listSoLuongTrang", listSoLuongTrang(thuChiService.countThuChi(), model));

			model.addAttribute("vitrihientai", vitrihientai);
			return "thuchi/danhsachthuchi";

		}
		
		// số lượng button bấm chuyển trang
		public List<Integer> listSoLuongTrangtim(Double count, ModelMap model) {
			List<Integer> lreturn = new ArrayList<>();
			double temp = Double.parseDouble(count + "") / 10.0;
			int tempfor = (int) Math.ceil(temp);
			int a = 3;
			int b = 3;

			if (vitrihientai == 1) {
				a = 0;
				b = 6;
			}
			if (vitrihientai == 2) {
				a = 1;
				b = 5;
			}
			if (vitrihientai == 3) {
				a = 2;
				b = 4;
			}
			if (vitrihientai == 4) {
				a = 3;
				b = 3;
			}

			if (vitrihientai == tempfor) {
				a = 6;
				b = 0;
			}
			if (vitrihientai == (tempfor - 1)) {
				a = 5;
				b = 1;
			}
			if (vitrihientai == (tempfor - 2)) {
				a = 4;
				b = 2;
			}
			if (vitrihientai == (tempfor - 3)) {
				a = 3;
				b = 3;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor) {
				a = 0;
				b = 0;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 1) {
				a = 0;
				b = 1;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 2) {
				a = 0;
				b = 2;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 3) {
				a = 0;
				b = 3;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 4) {
				a = 0;
				b = 4;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 5) {
				a = 0;
				b = 5;
			}
			if (vitrihientai == 1 && vitrihientai == tempfor - 6) {
				a = 0;
				b = 6;
			}

			// -------------
			if (vitrihientai == 2 && vitrihientai == tempfor) {
				a = 1;
				b = 0;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 1) {
				a = 1;
				b = 1;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 2) {
				a = 1;
				b = 2;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 3) {
				a = 1;
				b = 3;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 4) {
				a = 1;
				b = 4;
			}
			if (vitrihientai == 2 && vitrihientai == tempfor - 5) {
				a = 1;
				b = 5;
			}
			// -------------
			if (vitrihientai == 3 && vitrihientai == tempfor) {
				a = 2;
				b = 0;
			}
			if (vitrihientai == 3 && vitrihientai == tempfor - 1) {
				a = 2;
				b = 1;
			}
			if (vitrihientai == 3 && vitrihientai == tempfor - 2) {
				a = 2;
				b = 2;
			}
			if (vitrihientai == 3 && vitrihientai == tempfor - 3) {
				a = 2;
				b = 3;
			}
			if (vitrihientai == 3 && vitrihientai == tempfor - 4) {
				a = 2;
				b = 4;
			}
			// -------------
			if (vitrihientai == 4 && vitrihientai == tempfor) {
				a = 3;
				b = 0;
			}
			if (vitrihientai == 4 && vitrihientai == tempfor - 1) {
				a = 3;
				b = 1;
			}
			if (vitrihientai == 4 && vitrihientai == tempfor - 2) {
				a = 3;
				b = 2;
			}
			if (vitrihientai == 4 && vitrihientai == tempfor - 3) {
				a = 3;
				b = 3;
			}
			// -------------
			if (vitrihientai == 5 && vitrihientai == tempfor) {
				a = 4;
				b = 0;
			}
			if (vitrihientai == 5 && vitrihientai == tempfor - 1) {
				a = 4;
				b = 1;
			}
			if (vitrihientai == 5 && vitrihientai == tempfor - 2) {
				a = 4;
				b = 2;
			}
			if (vitrihientai == 5 && vitrihientai == tempfor - 3) {
				a = 4;
				b = 3;
			}
			// -------------
			if (vitrihientai == 6 && vitrihientai == tempfor) {
				a = 5;
				b = 0;
			}
			if (vitrihientai == 6 && vitrihientai == tempfor - 1) {
				a = 5;
				b = 1;
			}
			if (vitrihientai == 6 && vitrihientai == tempfor - 2) {
				a = 5;
				b = 2;
			}
			if (vitrihientai == 6 && vitrihientai == tempfor - 3) {
				a = 5;
				b = 3;
			}

			for (int i = vitrihientai - a; i <= vitrihientai + b; i++) {
				lreturn.add(i);
			}
			if (count.intValue() == 0) {
				lreturn.clear();
			}

			model.addAttribute("trangdau", 1);
			model.addAttribute("trangcuoi", tempfor);
			model.addAttribute("vitrihientai", vitrihientai);
			return lreturn;
		}
		
		// khi chọn button thì chạy cái này. lấy page xuất danh sách
		@RequestMapping("/thuchipagetim")
		public String thuchipagetim(ModelMap model, @RequestParam("page") int page,@RequestParam("tungay") String tungay, @RequestParam("denngay") String denngay) throws ParseException {
			activemenu(model);
			model.addAttribute("titlepage", "Danh sách thu chi");
			vitrihientai = page;
			
			PageRequest pageable = PageRequest.of(page - 1, 10);
			List<ThuChi> ltim;
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			Date d1 = new Date(fm.parse(tungay).getTime());
			Date d2 = new Date(fm.parse(denngay).getTime());
			ltim = thuChiService.getTimThuChi(d1, d2, pageable);
			
			model.addAttribute("tungay", tungay);
			model.addAttribute("denngay", denngay);
			
			tongTienThu = thuChiService.getTongThuTim(d1, d2);
			tongTienChi = thuChiService.getTongChiTim(d1, d2);
			checkTongTienNull(tongTienThu, tongTienChi);
			
			model.addAttribute("tongTienThu", tongTienThu);
			model.addAttribute("tongTienChi", tongTienChi);
			model.addAttribute("l", ltim);
			model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(thuChiService.countThuChiTim(d1, d2), model));
			model.addAttribute("vitrihientai", vitrihientai);
			model.addAttribute("danhsachtim", 1);
			model.addAttribute("danhsach", 0);
			return "thuchi/danhsachthuchi";

		}
		
}
