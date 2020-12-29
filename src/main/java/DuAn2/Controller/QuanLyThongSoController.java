package DuAn2.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import DuAn2.Model.GiaoDien;
import DuAn2.Model.ThongSoTheoGio;
import DuAn2.Services.GiaoDienService;
import DuAn2.Services.ThongSoTheoGioService;

@Controller
public class QuanLyThongSoController {

	@Autowired
	ThongSoTheoGioService thongSoTheoGioService;

	@Autowired
	GiaoDienService giaoDienService;

	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "qlts";
	}

	@GetMapping("/qlts")
	public String qlts(ModelMap model, ThongSoTheoGio thongSoTheoGio, GiaoDien giaoDien) {
		List<ThongSoTheoGio> lst = (List<ThongSoTheoGio>) thongSoTheoGioService.findAll();
		thongSoTheoGio = lst.get(0);
		List<GiaoDien> lstGiaoDien = (List<GiaoDien>) giaoDienService.findAll();
		giaoDien = lstGiaoDien.get(0);
		model.addAttribute("titlepage", "Cài đặt nâng cao");
		model.addAttribute("thongSoTheoGio", thongSoTheoGio);
		model.addAttribute("giaoDien", giaoDien);
		activemenu(model);
		return "qlts";
	}

	@PostMapping("/updatets")
	public String updatets(ModelMap model, ThongSoTheoGio thongSoTheoGio, GiaoDien giaoDien) {
		thongSoTheoGioService.save(thongSoTheoGio);
		model.addAttribute("message", "Cập nhật thành công");
		activemenu(model);
		return qlts(model, thongSoTheoGio, giaoDien);
	}

	@PostMapping("/updategiaodien")
	public String updategiaodien(ModelMap model, HttpServletRequest request, ThongSoTheoGio thongSoTheoGio,
			GiaoDien giaoDien) {
		HttpSession session = request.getSession();
		giaoDien.setMaGiaoDien(1);
		giaoDienService.save(giaoDien);
		model.addAttribute("message", "Cập nhật thành công");
		activemenu(model);
		session.setAttribute("tenToChuc", giaoDien.getTenToChuc());
		session.setAttribute("diaChi", giaoDien.getDiaChi());
		session.setAttribute("soDienThoai", giaoDien.getSoDienThoai());
		return qlts(model, thongSoTheoGio, giaoDien);
	}

	private void activemenu(ModelMap model) {
		model.addAttribute("chamshowcd", ".show");
		model.addAttribute("activets", "active");
	}
}
