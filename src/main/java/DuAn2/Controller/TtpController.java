package DuAn2.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.Phong;
import DuAn2.Services.Ittp;
import DuAn2.Services.QuanLyPhongService;

@Controller
public class TtpController {

	@Autowired
	Ittp ittp;
	
	@Autowired
	QuanLyPhongService quanlyphongService;

	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "ttp";
	}
	
	@RequestMapping("/ttp")
	public String ttp(ModelMap model) {
		PageRequest pageable = PageRequest.of(0, 5);
		List<Phong> l = (List<Phong>) ittp.findAllOrderByMaDesc(pageable);
		activemenu(model);
		vitrihientai = 1;

		model.addAttribute("lPhongs", l);
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(Double.parseDouble(ittp.countFindAll() + ""), model));
		model.addAttribute("titlepage", "Thông tin phòng");
		return "ttp";
	}

	@RequestMapping("/timttp")
	public String timttp(ModelMap model, @ModelAttribute("phong") Phong phong, HttpServletRequest httpServletRequest) {
		activemenu(model);
		PageRequest pageable = PageRequest.of(0, 5);
		String data = httpServletRequest.getParameter("data");
		List<Phong> ltim;
		ltim = (List<Phong>) quanlyphongService.TimMaPhong(Integer.parseInt(data), pageable);
		model.addAttribute("data", data);
		
		vitrihientai = 1;
		model.addAttribute("lPhongs", ltim);
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(quanlyphongService.countTimMaPhong(Integer.parseInt(data)), model));
		model.addAttribute("titlepage", "Thông tin phòng");
		if (!ltim.isEmpty()) {
			model.addAttribute("danhsachtim", 1);
		}
		model.addAttribute("danhsach", 0);
		return "ttp";
	}

	// PHAN TRANG
	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
	int vitrihientai = 1;

	// số lượng button bấm chuyển trang
	public List<Integer> listSoLuongTrang(Double count, ModelMap model) {
		List<Integer> lreturn = new ArrayList<>();
		double temp = Double.parseDouble(count + "") / 5.0;
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
	@RequestMapping("/ttppage")
	public String ttppage(ModelMap model, @RequestParam("page") int page, @ModelAttribute("phong") Phong phong) {
		activemenu(model);
		PageRequest pageable = PageRequest.of(page - 1, 5);
		List<Phong> l = (List<Phong>) ittp.findAllOrderByMaDesc(pageable);
		model.addAttribute("titlepage", "Thông tin phòng");
		vitrihientai = page;

		model.addAttribute("lPhongs", l);
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(Double.parseDouble(ittp.countFindAll() + ""), model));

		model.addAttribute("vitrihientai", vitrihientai);
		return "ttp";

	}

	// số lượng button bấm chuyển trang
	public List<Integer> listSoLuongTrangtim(Double count, ModelMap model) {
		List<Integer> lreturn = new ArrayList<>();
		double temp = Double.parseDouble(count + "") / 5.0;
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
	@RequestMapping("/ttppagetim")
	public String ttppagetim(ModelMap model, @RequestParam("page") int page, @ModelAttribute("phong") Phong phong, HttpServletRequest httpServletRequest) {
		activemenu(model);

		model.addAttribute("titlepage", "Thông tin phòng");
		vitrihientai = page;

		String data = httpServletRequest.getParameter("data");
		PageRequest pageable = PageRequest.of(page - 1, 5);
		List<Phong> ltim;
		ltim = (List<Phong>) quanlyphongService.TimMaPhong(Integer.parseInt(data), pageable);
		model.addAttribute("data", data);
		
		model.addAttribute("lPhongs", ltim);
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(quanlyphongService.countTimMaPhong(Integer.parseInt(data)), model));
		model.addAttribute("vitrihientai", vitrihientai);
		model.addAttribute("danhsachtim", 1);
		model.addAttribute("danhsach", 0);
		return "ttp";

	}

	private void activemenu(ModelMap model) {

		// tim kiem thong tin
		model.addAttribute("chamshowtktt", ".show");
		model.addAttribute("activettkh", null);
		model.addAttribute("activettp", "active");

	}
}
