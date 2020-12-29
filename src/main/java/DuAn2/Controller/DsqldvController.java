package DuAn2.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.DichVu;
import DuAn2.Services.DsqldvService;

@Controller
public class DsqldvController {
	@Autowired
	DsqldvService dsqldvService;

	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "dsqldv";
	}

	@RequestMapping("/dsqldv")
	public String ViewListDsqldv(ModelMap model, @ModelAttribute("dichvu") DichVu dichvu) {
		activemenu(model);
		vitrihientai = 1;
		List<DichVu> l = (List<DichVu>) dsqldvService.findAllNotType3();
		model.addAttribute("titlepage", "Danh sách dịch vụ"); // tiêu đề cho trang

		model.addAttribute("lqldv", phantrangdsdv(vitrihientai, l)); // hiện danh sách đã phân trang 10 item 1 trang
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l, model));// số lượng các button chọn trang

		return "dsqldv";
	}

	@RequestMapping("/timdsqldv")
	public String timdsqldv(ModelMap model, @ModelAttribute("dichvu") DichVu dichvu,
			HttpServletRequest httpServletRequest) {
		String data2 = httpServletRequest.getParameter("data");
		model.addAttribute("data", data2);
		List<DichVu> ltim;
		if (data2.isEmpty()) {
			ltim = (List<DichVu>) dsqldvService.findAllNotType3();
		} else {

			try {
				int data1 = Integer.parseInt(data2);
				ltim = (List<DichVu>) dsqldvService.timldsdv(data1, data2);
			} catch (Exception e) {
				int data1 = 0;
				ltim = (List<DichVu>) dsqldvService.timldsdv(data1, data2);
			}
		}
		activemenu(model);
		vitrihientai = 1;
		model.addAttribute("danhsach", 0);
		if (!ltim.isEmpty()) {
			model.addAttribute("danhsachtim", 1);
		}
		model.addAttribute("lqldv", phantrangdsdvtim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim, model));
		model.addAttribute("titlepage", "Danh sách dịch vụ");
		return "dsqldv";
	}

	@RequestMapping("/deleteqldv")
	public String deleteqldv(ModelMap model, @ModelAttribute("dichvu") DichVu dichvu, @RequestParam("id") int id) {
		activemenu(model);
		model.addAttribute("titlepage", "Danh sách dịch vụ");
		DichVu dv = new DichVu();
		dv.setMaDichVu(id);
		dsqldvService.delete(dv);
		List<DichVu> l = (List<DichVu>) dsqldvService.findAllNotType3();

		if (vitrihientai == 1) {
			model.addAttribute("lqldv", phantrangdsdv(vitrihientai, l));
		} else if (phantrangdsdv(vitrihientai, l).isEmpty()) {
			model.addAttribute("lqldv", phantrangdsdv(vitrihientai - 1, l));
			vitrihientai--;
		} else {
			model.addAttribute("lqldv", phantrangdsdv(vitrihientai, l));
		}

		model.addAttribute("message", "Đã xóa thành công");
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l, model));
		return dsqldvpage(model, vitrihientai, dichvu);
	}

	@RequestMapping("/actionsuadsqldv")
	public String actionsuadsqldv(ModelMap model, @Validated @ModelAttribute("dichvu") DichVu dichvu,
			BindingResult errors) {
		activemenu(model);
		if (errors.hasErrors()) {
			model.addAttribute("errors", errors.getAllErrors());
			return ViewListDsqldv(model, dichvu);
		} else {

			dsqldvService.save(dichvu);
			model.addAttribute("message", "Đã sửa thành công");
			return ViewListDsqldv(model, dichvu);
		}
	}

	@RequestMapping("/themdsqldv")
	public String themdsqldv(ModelMap model, @ModelAttribute("dichvu") DichVu dichvu) {

		// cai dat. tat ca duoi deu show tren cai dat --------------------
		model.addAttribute("chamshowcd", ".show");

		// dich vu
		model.addAttribute("chamshowdv", ".show");
		model.addAttribute("activedv", null);
		model.addAttribute("activetdv", "active");

		model.addAttribute("dichvu", dichvu);
		model.addAttribute("titlepage", "Thêm dịch vụ mới");
		return "themdsqldv";
	}

	@RequestMapping("/actionthemdsqldv")
	public String actionthemdsqldv(ModelMap model, @Validated @ModelAttribute("dichvu") DichVu dichvu,
			BindingResult errors) {
		// cai dat. tat ca duoi deu show tren cai dat --------------------
		model.addAttribute("chamshowcd", ".show");

		// dich vu
		model.addAttribute("chamshowdv", ".show");
		model.addAttribute("activedv", null);
		model.addAttribute("activetdv", "active");

		if (errors.hasErrors()) {
			model.addAttribute("errors", errors.getAllErrors());
			model.addAttribute("titlepage", "Danh sách dịch vụ");
			return "themdsqldv";
		} else {
			dsqldvService.save(dichvu);
			model.addAttribute("dichvu", new DichVu());
			model.addAttribute("titlepage", "Danh sách dịch vụ");
			model.addAttribute("message", "Thêm thành công");

			return "themdsqldv";
		}
	}

	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
	int vitrihientai = 1;

	public List<DichVu> phantrangdsdv(int vitrihientai, List<DichVu> danhsach) {
		List<DichVu> l = danhsach;
		List<DichVu> lreturn = new ArrayList<>();
//lay ra 10 item
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
	public List<Integer> listSoLuongTrang(List<DichVu> danhsach, ModelMap model) {
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

//-------------
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
	@RequestMapping("/dsqldvpage")
	public String dsqldvpage(ModelMap model, @RequestParam("page") int page, @ModelAttribute("dichvu") DichVu dichvu) {
		activemenu(model);
		List<DichVu> l = (List<DichVu>) dsqldvService.findAllNotType3();
		model.addAttribute("titlepage", "Danh sách dịch vụ");
		vitrihientai = page;

		model.addAttribute("lqldv", phantrangdsdv(vitrihientai, l));
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l, model));
		model.addAttribute("vitrihientai", vitrihientai);
		return "dsqldv";

	}

	// phan trang tim
	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu

	public List<DichVu> phantrangdsdvtim(int vitrihientai, List<DichVu> danhsach) {
		List<DichVu> l = danhsach;
		List<DichVu> lreturn = new ArrayList<>();
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
	public List<Integer> listSoLuongTrangtim(List<DichVu> danhsach, ModelMap model) {
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
	@RequestMapping("/dsqldvpagetim")
	public String dsqldvpagetim(ModelMap model, @RequestParam("page") int page, @ModelAttribute("dichvu") DichVu dichvu,
			HttpServletRequest httpServletRequest) {
		activemenu(model);
		model.addAttribute("titlepage", "Danh sách dịch vụ");
		vitrihientai = page;

		String data2 = httpServletRequest.getParameter("data");
		model.addAttribute("data", data2);
		List<DichVu> ltim;
		if (data2.isEmpty()) {
			ltim = (List<DichVu>) dsqldvService.findAllNotType3();
		} else {

			try {
				int data1 = Integer.parseInt(data2);
				ltim = (List<DichVu>) dsqldvService.timldsdv(data1, data2);
			} catch (Exception e) {
				int data1 = 0;
				ltim = (List<DichVu>) dsqldvService.timldsdv(data1, data2);
			}
		}

		model.addAttribute("lqldv", phantrangdsdvtim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim, model));
		model.addAttribute("vitrihientai", vitrihientai);
		model.addAttribute("danhsachtim", 1);
		model.addAttribute("danhsach", 0);
		return "dsqldv";

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
		model.addAttribute("chamshowqlp", null);
		model.addAttribute("activedsp", null);
		model.addAttribute("activetp", null);

		// dich vu
		model.addAttribute("chamshowdv", ".show");
		model.addAttribute("activedsdv", "active");
		model.addAttribute("activetdv", null);
	}

}
