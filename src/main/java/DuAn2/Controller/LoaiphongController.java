package DuAn2.Controller;

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

import DuAn2.Model.LoaiPhong;

import DuAn2.Services.ILoaiphongSercives;

@Controller
@Transactional
public class LoaiphongController {
	
	@Autowired
	ILoaiphongSercives iLoaiphongServices;
	
	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "qllp";
	}
	
	@RequestMapping("/qllp")
	public String listlp(ModelMap model, @ModelAttribute("loaiphong") LoaiPhong loaiphong) {
		activemenu(model);
		List<LoaiPhong> llp = (List<LoaiPhong>) iLoaiphongServices.findAll();// lấy list
		model.addAttribute("titlepage", "Danh sách loại phòng"); // tiêu đề cho trang

		model.addAttribute("lLoaiphongs", phantranglp(vitrihientai, llp)); // hiện danh sách đã phân trang 10 item 1
																			// trang
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(llp, model));// số lượng các button chọn trang
		vitrihientai = 1;

		return "qllp"; // Tên trang index
	}

	@RequestMapping("/timdsqllp")
	public String timdslp(ModelMap model, @ModelAttribute("loaiphong") LoaiPhong loaiphong,
			HttpServletRequest httpServletRequest) {
		activemenu(model);
		
		List<LoaiPhong> ltim;
		String data = httpServletRequest.getParameter("data");
		Integer dataint = null;
		try {
			dataint = Integer.parseInt(data);
		} catch (Exception x) {
			dataint = null;
		}
		ltim = (List<LoaiPhong>) iLoaiphongServices.ListFindtdnOrName(dataint, data);
		model.addAttribute("data", data);
		
		vitrihientai = 1;
		model.addAttribute("danhsach", 0);
		if (!ltim.isEmpty()) {
			model.addAttribute("danhsachtim", 1);
		}

		model.addAttribute("lLoaiphongs", phantranglptim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim, model));
		model.addAttribute("titlepage", "Danh sách loại phòng");
		return "qllp";
	}

	@RequestMapping("/addlp")
	public String addlp(ModelMap model, @ModelAttribute("loaiphong") LoaiPhong loaiphong) {
		// cai dat. tat ca duoi deu show tren cai dat --------------------
		model.addAttribute("chamshowcd", ".show");
		// show quan ly tai khoan
		model.addAttribute("chamshowqltk", null);
		model.addAttribute("activedstk", null);
		model.addAttribute("activettk", null);

		// quan ly loai phong
		model.addAttribute("chamshowqllp", ".show");
		model.addAttribute("activedslp", null);
		model.addAttribute("activetlp", "active");

		model.addAttribute("loaiphong", loaiphong);
		model.addAttribute("titlepage", "Thêm mới loại phòng");
		return "addlp"; // Tên trang index
	}

	@RequestMapping("/actionaddlp")
	public String actionaddlp(ModelMap model, @Validated @ModelAttribute("loaiphong") LoaiPhong loaiphong,
			BindingResult errors) {
		// cai dat. tat ca duoi deu show tren cai dat --------------------
		model.addAttribute("chamshowcd", ".show");
		// show quan ly tai khoan
		model.addAttribute("chamshowqltk", null);
		model.addAttribute("activedstk", null);
		model.addAttribute("activettk", null);

		// quan ly loai phong
		model.addAttribute("chamshowqllp", ".show");
		model.addAttribute("activedslp", null);
		model.addAttribute("activetlp", "active");

		if (errors.hasErrors()) {
			model.addAttribute("titlepage", "Thêm mới loại phòng");
			model.addAttribute("errors", errors.getAllErrors());
			return "addlp";
		} else {
			model.addAttribute("titlepage", "Thêm mới loại phòng");
			model.addAttribute("message", " Thêm mới thành công");
			iLoaiphongServices.save(loaiphong);
			model.addAttribute("loaiphong", new LoaiPhong());
			return "addlp";
		}
	}

	@RequestMapping("/editlp")
	public String edit(ModelMap model, @Validated @ModelAttribute("loaiphong") LoaiPhong loaiphong,
			BindingResult errors) {
		activemenu(model);
		if (errors.hasErrors()) {
			model.addAttribute("titlepage", "Thêm mới loại phòng");
			model.addAttribute("errors", errors.getAllErrors());
			return listlp(model, loaiphong);
		} else {
			model.addAttribute("titlepage", "Thêm mới loại phòng");
			model.addAttribute("message", " Sửa thành công");
			iLoaiphongServices.save(loaiphong);// nếu trùng id thì không thêm mà thành sửa.
			return listlp(model, loaiphong); // sửa xong chạy lại trang hiển thị book
		}
	}

	@RequestMapping("/deletelp")
	public String delete(ModelMap model, @ModelAttribute("loaiphong") LoaiPhong loaiphong,
			@RequestParam("maLoaiPhong") Integer maLoaiPhong) {
		activemenu(model);
		loaiphong.setMaLoaiPhong(maLoaiPhong); // Set id vào book
		iLoaiphongServices.delete(loaiphong);// Xóa theo id vì thế set id vào

		List<LoaiPhong> l = (List<LoaiPhong>) iLoaiphongServices.findAll();

		if (vitrihientai == 1) {
			model.addAttribute("lLoaiphongs", phantranglp(vitrihientai, l));
		} else if (phantranglp(vitrihientai, l).isEmpty()) {
			model.addAttribute("lLoaiphongs", phantranglp(vitrihientai - 1, l));
			vitrihientai--;
		} else {
			model.addAttribute("lLoaiphongs", phantranglp(vitrihientai, l));
		}

		model.addAttribute("message", "Đã xóa thành công");
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l, model));
		
		
		return listlp(model, loaiphong); // xóa xong chạy lại trang hiển thị book
	}

	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
	int vitrihientai = 1;

	public List<LoaiPhong> phantranglp(int vitrihientai, List<LoaiPhong> danhsach) {
		List<LoaiPhong> l = danhsach;
		List<LoaiPhong> lreturn = new ArrayList<>();
		// lay ra 10 item
		for (int i = (vitrihientai - 1) * 10; i < (vitrihientai) * 10; i++) {
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
	public List<Integer> listSoLuongTrang(List<LoaiPhong> danhsach, ModelMap model) {
		List<Integer> lreturn = new ArrayList<>();
		double temp = Double.parseDouble(danhsach.size() + "") / 10.0;
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
	@RequestMapping("/lppage")
	public String lppage(ModelMap model, @RequestParam("page") int page,
			@ModelAttribute("loaiphong") LoaiPhong loaiphong) {
		List<LoaiPhong> l = (List<LoaiPhong>) iLoaiphongServices.findAll();
		activemenu(model);
		vitrihientai = page;

		model.addAttribute("vitrihientai", vitrihientai);

		model.addAttribute("titlepage", "Danh sách loại phòng"); // tiêu đề cho trang
		model.addAttribute("lLoaiphongs", phantranglp(vitrihientai, l)); // hiện danh sách đã phân trang 10 item 1 trang
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l, model));// số lượng các button chọn trang
		return "qllp";

	}

	// phan trang tim
	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu

	public List<LoaiPhong> phantranglptim(int vitrihientai, List<LoaiPhong> danhsach) {
		List<LoaiPhong> l = danhsach;
		List<LoaiPhong> lreturn = new ArrayList<>();
		// lay ra 10 item
		for (int i = (vitrihientai - 1) * 10; i < (vitrihientai) * 10; i++) {
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
	public List<Integer> listSoLuongTrangtim(List<LoaiPhong> danhsach, ModelMap model) {
		List<Integer> lreturn = new ArrayList<>();
		double temp = Double.parseDouble(danhsach.size() + "") / 10.0;
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
	@RequestMapping("/lppagetim")
	public String lppagetim(ModelMap model,HttpServletRequest httpServletRequest, @RequestParam("page") int page,
			@ModelAttribute("loaiphong") LoaiPhong loaiphong) {
		activemenu(model);
		model.addAttribute("titlepage", "Danh sách loại phòng");
		vitrihientai = page;

		List<LoaiPhong> ltim;
		String data = httpServletRequest.getParameter("data");
		Integer dataint = null;
		try {
			dataint = Integer.parseInt(data);
		} catch (Exception x) {
			dataint = null;
		}
		ltim = (List<LoaiPhong>) iLoaiphongServices.ListFindtdnOrName(dataint, data);
		model.addAttribute("data", data);
		
		model.addAttribute("lLoaiphongs", phantranglptim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim, model));
		model.addAttribute("vitrihientai", vitrihientai);
		model.addAttribute("danhsachtim", 1);
		model.addAttribute("danhsach", 0);
		return "qllp";

	}

	private void activemenu(ModelMap model) {

		// cai dat. tat ca duoi deu show tren cai dat --------------------
		model.addAttribute("chamshowcd", ".show");
		// show quan ly tai khoan
		model.addAttribute("chamshowqltk", null);
		model.addAttribute("activedstk", null);
		model.addAttribute("activettk", null);

		// quan ly loai phong
		model.addAttribute("chamshowqllp", ".show");
		model.addAttribute("activedslp", "active");
		model.addAttribute("activetlp", null);

		// quan ly phong
		model.addAttribute("chamshowqlp", null);
		model.addAttribute("activedsp", null);
		model.addAttribute("activetp", null);

		// dich vu
		model.addAttribute("chamshowdv", null);
		model.addAttribute("activedv", null);
		model.addAttribute("activetdv", null);
	}

}
