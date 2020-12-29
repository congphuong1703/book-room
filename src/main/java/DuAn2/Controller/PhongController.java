package DuAn2.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import DuAn2.Model.LoaiPhong;
import DuAn2.Model.Phong;
import DuAn2.Services.ILoaiphongSercives;
import DuAn2.Services.QuanLyPhongService;

@Controller
@Transactional
public class PhongController {
	@Autowired
	QuanLyPhongService quanlyphongService;

	@Autowired
	ILoaiphongSercives iLoaiphongSercives;

	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "quanlyphong";
	}

	@ModelAttribute(name = "listLoaiPhong")
	public List<LoaiPhong> listLoaiPhong() {
		return (List<LoaiPhong>) iLoaiphongSercives.findAll();
	}

	@RequestMapping("/quanlyphong")
	public String HienThiTrangIndex(ModelMap model, @ModelAttribute("phong") Phong phong) {
		activemenu(model);
		List<Phong> l = (List<Phong>) quanlyphongService.findAllOrderByMaDesc();
		model.addAttribute("lPhongs", phantrangdsdv(vitrihientai, l));
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l, model));
		model.addAttribute("titlepage", "Danh sách phòng");
		vitrihientai = 1;
		return "qlp";
	}

	@RequestMapping("/addqlp")
	public String addqlp(ModelMap model, @ModelAttribute("phong") Phong phong) {

		// cai dat. tat ca duoi deu show tren cai dat --------------------
		model.addAttribute("chamshowcd", ".show");
		// show quan ly tai khoan
		model.addAttribute("chamshowqltk", null);
		model.addAttribute("activedstk", null);
		model.addAttribute("activettk", null);

		// quan ly loai phong
		model.addAttribute("chamshowqllp", null);
		model.addAttribute("activedslp", null);
		model.addAttribute("activetlp", null);

		// quan ly phong
		model.addAttribute("chamshowqlp", ".show");
		model.addAttribute("activedsp", null);
		model.addAttribute("activetp", "active");

		model.addAttribute("titlepage", "Thêm phòng mới");
		return "addqlp"; // Tên trang index
	}

	@RequestMapping("/timqlp")
	public String timqlp(ModelMap model, @ModelAttribute("phong") Phong phong, HttpServletRequest httpServletRequest) {
		activemenu(model);

		List<Phong> ltim;
		ltim = (List<Phong>) quanlyphongService.TimMaPhong(Integer.parseInt(httpServletRequest.getParameter("data")));
		model.addAttribute("data", httpServletRequest.getParameter("data"));
		vitrihientai = 1;
		model.addAttribute("lPhongs", phantrangphongtim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim, model));
		model.addAttribute("titlepage", "Danh sách phòng");
		if (!ltim.isEmpty()) {
			model.addAttribute("danhsachtim", 1);
		}
		model.addAttribute("danhsach", 0);
		return "qlp";
	}

	@RequestMapping("/actionaddqlp")
	public String actionaddqlp(ModelMap model, @Validated @ModelAttribute("phong") Phong phong, BindingResult errors,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		// cai dat. tat ca duoi deu show tren cai dat --------------------
		model.addAttribute("chamshowcd", ".show");
		// show quan ly tai khoan
		model.addAttribute("chamshowqltk", null);
		model.addAttribute("activedstk", null);
		model.addAttribute("activettk", null);

		// quan ly loai phong
		model.addAttribute("chamshowqllp", null);
		model.addAttribute("activedslp", null);
		model.addAttribute("activetlp", null);

		// quan ly phong
		model.addAttribute("chamshowqlp", ".show");
		model.addAttribute("activedsp", null);
		model.addAttribute("activetp", "active");

		if (errors.hasErrors() || file.getSize() == 0) {
			if (file.getSize() == 0) {
				model.addAttribute("errorimg", "- Vui lòng chọn hình ảnh");
			}
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("titlepage", "Danh sách dịch vụ");
			return addqlp(model, phong);
		} else {

			// nếu mở rộng không phải jpg và không phải png thì chạy else
			if (!file.getOriginalFilename().endsWith(".jpg") && !file.getOriginalFilename().endsWith(".png")
					&& !file.getOriginalFilename().endsWith(".PNG") && !file.getOriginalFilename().endsWith(".JPG")
					&& !file.getOriginalFilename().endsWith(".jpeg") && !file.getOriginalFilename().endsWith(".JPEG")) {
				model.addAttribute("errorimg", "- Chỉ cho phép định dạng ảnh png, jpg, jpeg.");
				return addqlp(model, phong);
			} else {
				long nanotime = System.nanoTime();
				String url = null;
				if (file.getOriginalFilename().endsWith(".jpg") || file.getOriginalFilename().endsWith(".JPG")) {
					url = request.getServletContext().getRealPath("/hinh/phong/") + nanotime + ".jpg";
					phong.setHinhAnh(nanotime + ".jpg");
				}
				if (file.getOriginalFilename().endsWith(".png") || file.getOriginalFilename().endsWith(".PNG")) {
					url = request.getServletContext().getRealPath("/hinh/phong/") + nanotime + ".png";
					phong.setHinhAnh(nanotime + ".png");
				}
				
				if (file.getOriginalFilename().endsWith(".jpeg") || file.getOriginalFilename().endsWith(".JPEG")) {
					url = request.getServletContext().getRealPath("/hinh/phong/") + nanotime + ".jpeg";
					phong.setHinhAnh(nanotime + ".jpeg");
				}

				File convFile = new File(url);

				try {

					file.transferTo(convFile);

				} catch (IllegalStateException | IOException e) {
					System.out.println(e);
					model.addAttribute("errorimg", "- Lỗi ảnh");
				}

				model.addAttribute("message", " Thêm thành công");
				phong.setTrangThai(0);
				quanlyphongService.save(phong);
				model.addAttribute("phong", new Phong());
				return addqlp(model, phong);
			}
		}

	}

	@RequestMapping("/actionsuaqlp")
	public String actionsuaqlp(ModelMap model, @Validated @ModelAttribute("phong") Phong phong, BindingResult errors,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		activemenu(model);
		if (errors.hasErrors() || file.getSize() == 0) {
			if (file.getSize() == 0) {
				model.addAttribute("errorimg", "- Vui lòng chọn hình ảnh");
			}
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("titlepage", "Danh sách dịch vụ");
			return HienThiTrangIndex(model, phong);
		} else {

			// nếu mở rộng không phải jpg và không phải png thì chạy else
			if (!file.getOriginalFilename().endsWith(".jpg") && !file.getOriginalFilename().endsWith(".png")
					&& !file.getOriginalFilename().endsWith(".PNG") && !file.getOriginalFilename().endsWith(".JPG")) {
				model.addAttribute("errorimg", "- Chỉ cho phép định dạng ảnh png và jpg");

				return HienThiTrangIndex(model, phong);
			} else {
				long nanotime = System.nanoTime();
				String url = null;
				if (file.getOriginalFilename().endsWith(".jpg") || file.getOriginalFilename().endsWith(".JPG")) {
					url = request.getServletContext().getRealPath("/hinh/phong/") + nanotime + ".jpg";
					phong.setHinhAnh(nanotime + ".jpg");
				}
				if (file.getOriginalFilename().endsWith(".png") || file.getOriginalFilename().endsWith(".PNG")) {
					url = request.getServletContext().getRealPath("/hinh/phong/") + nanotime + ".png";
					phong.setHinhAnh(nanotime + ".png");
				}

				File convFile = new File(url);

				try {

					file.transferTo(convFile);

				} catch (IllegalStateException | IOException e) {
					System.out.println(e);
					model.addAttribute("errorimg", "- Lỗi ảnh");
				}

				model.addAttribute("message", " Đã sửa thành công");

				quanlyphongService.save(phong);
				return HienThiTrangIndex(model, phong);
			}
		}
	}

	@RequestMapping("/deletephong")
	public String delete(ModelMap model, @ModelAttribute("phong") Phong phong, @RequestParam("maphong") int maPhong) {
		activemenu(model);
		phong.setMaPhong(maPhong);
		quanlyphongService.delete(phong);

		List<Phong> l = (List<Phong>) quanlyphongService.findAllOrderByMaDesc();

		if (vitrihientai == 1) {
			model.addAttribute("lPhongs", phantrangdsdv(vitrihientai, l));
		} else if (phantrangdsdv(vitrihientai, l).isEmpty()) {
			model.addAttribute("lPhongs", phantrangdsdv(vitrihientai - 1, l));
			vitrihientai--;
		} else {
			model.addAttribute("lPhongs", phantrangdsdv(vitrihientai, l));
		}

		model.addAttribute("message", "Đã xóa thành công");
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l, model));
		return HienThiTrangIndex(model, phong);
	}

	// PHAN TRANG
	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
	int vitrihientai = 1;

	public List<Phong> phantrangdsdv(int vitrihientai, List<Phong> danhsach) {
		List<Phong> l = danhsach;
		List<Phong> lreturn = new ArrayList<>();
		// lay ra 10 item
		for (int i = (vitrihientai - 1) * 5; i < (vitrihientai) * 5; i++) {
			try {
				lreturn.add(l.get(i));
			} catch (Exception e) {
				break;
			}
		}
		;
		return lreturn;
	}

	// số lượng button bấm chuyển trang
	public List<Integer> listSoLuongTrang(List<Phong> danhsach, ModelMap model) {
		List<Integer> lreturn = new ArrayList<>();
		double temp = Double.parseDouble(danhsach.size() + "") / 5.0;
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
		if (danhsach.isEmpty()) {
			lreturn.clear();
		}
		model.addAttribute("danhsach", danhsach.size()); // để ẩn thanh button trang khi danh sách trống
		model.addAttribute("trangdau", 1);
		model.addAttribute("trangcuoi", tempfor);
		model.addAttribute("vitrihientai", vitrihientai);
		return lreturn;
	}

	// khi chọn button thì chạy cái này. lấy page xuất danh sách
	@RequestMapping("/qlppage")
	public String qlppage(ModelMap model, @RequestParam("page") int page, @ModelAttribute("phong") Phong phong) {
		activemenu(model);
		List<Phong> l = (List<Phong>) quanlyphongService.findAllOrderByMaDesc();
		model.addAttribute("titlepage", "Danh sách phòng");
		vitrihientai = page;

		model.addAttribute("lPhongs", phantrangdsdv(vitrihientai, l));
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l, model));

		model.addAttribute("vitrihientai", vitrihientai);
		return "qlp";

	}

	// phan trang tim
	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu

	public List<Phong> phantrangphongtim(int vitrihientai, List<Phong> danhsach) {
		List<Phong> l = danhsach;
		List<Phong> lreturn = new ArrayList<>();
		// lay ra 10 item
		for (int i = (vitrihientai - 1) * 5; i < (vitrihientai) * 5; i++) {
			try {
				lreturn.add(l.get(i));
			} catch (Exception e) {
				break;
			}
		}
		;
		return lreturn;
	}

	// số lượng button bấm chuyển trang
	public List<Integer> listSoLuongTrangtim(List<Phong> danhsach, ModelMap model) {
		List<Integer> lreturn = new ArrayList<>();
		double temp = Double.parseDouble(danhsach.size() + "") / 5.0;
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
		if (danhsach.isEmpty()) {
			lreturn.clear();
		}

		model.addAttribute("trangdau", 1);
		model.addAttribute("trangcuoi", tempfor);
		model.addAttribute("vitrihientai", vitrihientai);
		return lreturn;
	}

	// khi chọn button thì chạy cái này. lấy page xuất danh sách
	@RequestMapping("/qlppagetim")
	public String qlppagetim(ModelMap model, @RequestParam("page") int page, @ModelAttribute("phong") Phong phong,
			HttpServletRequest httpServletRequest) {
		activemenu(model);
		model.addAttribute("titlepage", "Danh sách phòng");
		vitrihientai = page;
		String data = httpServletRequest.getParameter("data");
		List<Phong> ltim;
		ltim = (List<Phong>) quanlyphongService.TimMaPhong(Integer.parseInt(data));
		model.addAttribute("data", data);
		model.addAttribute("lPhongs", phantrangphongtim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim, model));
		model.addAttribute("vitrihientai", vitrihientai);
		model.addAttribute("danhsachtim", 1);
		model.addAttribute("danhsach", 0);
		return "qlp";

	}

	@ModelAttribute("itemloaiphong")

	public List<LoaiPhong> itemloaiphong() {
		List<LoaiPhong> l = (List<LoaiPhong>) iLoaiphongSercives.findAll();
		return l;
	}

	private void activemenu(ModelMap model) {

		// cai dat. tat ca duoi deu show tren cai dat --------------------
		model.addAttribute("chamshowcd", ".show");
		// show quan ly tai khoan
		model.addAttribute("chamshowqltk", null);
		model.addAttribute("activedstk", null);
		model.addAttribute("activettk", null);

		// quan ly loai phong
		model.addAttribute("chamshowqllp", null);
		model.addAttribute("activedslp", null);
		model.addAttribute("activetlp", null);

		// quan ly phong
		model.addAttribute("chamshowqlp", ".show");
		model.addAttribute("activedsp", "active");
		model.addAttribute("activetp", null);

		// dich vu
		model.addAttribute("chamshowdv", null);
		model.addAttribute("activedv", null);
		model.addAttribute("activetdv", null);
	}

}
