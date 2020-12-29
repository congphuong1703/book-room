package DuAn2.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.DatPhong;
import DuAn2.Model.DichVu;
import DuAn2.Model.DonDichVu;
import DuAn2.Services.DsqldvService;
import DuAn2.Services.Idv;
import DuAn2.Services.Ilsdtp;
import DuAn2.Services.QuanLyPhongService;

@Controller
public class DvController {

	@Autowired
	Idv idv;
	
	@Autowired
	Ilsdtp ilsdtp;
	
	@Autowired
	QuanLyPhongService quanlyphongservice;

	@Autowired
	DsqldvService dsqldvService;

	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "pddv";
	}

	@GetMapping("/homestaydv")
	public String homestaydv(ModelMap model, @RequestParam("maPhong") Integer maPhong,
			@RequestParam("soPhong") Integer soPhong) {
		List<DatPhong> danhsach = ilsdtp.listHomestayByMaPhong(maPhong);
		model.addAttribute("titlepage", "Đặt dịch vụ");
		model.addAttribute("danhsach", danhsach);
		model.addAttribute("maPhong", maPhong);
		model.addAttribute("soPhong", soPhong);
		return "dichvu/listhomestaydv";
	}

	@RequestMapping("/pddv")
	public String pddv(ModelMap model) {
		activemenu(model);
		List<DatPhong> l = ilsdtp.timtrangthai();
		List<DatPhong> lloc = new ArrayList<>();
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getTraPhongs().isEmpty())
				lloc.add(l.get(i));
		}
		model.addAttribute("l", lloc);

		List<Integer> ltang = new ArrayList<>();
		// kiem tra da ton tai chua
		for (int i = 0; i < l.size(); i++) {
			if (!ltang.contains(l.get(i).getPhong().getTang())) {
				ltang.add(l.get(i).getPhong().getTang());
			}
		}

		if (lloc.isEmpty()) {

			model.addAttribute("message", "Tất cả phòng đều trống");
		}
		model.addAttribute("ltang", ltang);

		model.addAttribute("titlepage", "Chọn phòng đặt dịch vụ");
		return "pddv";
	}

	Integer chuyenhuongtrang = 3;
	Integer madatphong = null;
	Integer sophongtemp = null;

	@RequestMapping("/dv")
	public String dv(ModelMap model, @RequestParam("madatphong") int madatphong, @RequestParam("sophong") int sophong) {
		activemenu(model);
		chuyenhuongtrang = 3;
		this.madatphong = madatphong;
		sophongtemp = sophong;
		getlistdsdadat(model);
		model.addAttribute("width", "100%");
		model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
		return "dv";
	}

	@RequestMapping(value = "/actionloaidichvu", params = "anuong")
	public String anuong(ModelMap model, @ModelAttribute("donDichVu") DonDichVu donDichVu) {
		activemenu(model);
		chuyenhuongtrang = 0;
		model.addAttribute("madatphong", madatphong);
		model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
		getlistdsdadat(model);
		return "dv.jsp?view=dichvu/anuong";
	}

	@RequestMapping(value = "/actionloaidichvu", params = "giatui")
	public String giatui(ModelMap model, @ModelAttribute("donDichVu") DonDichVu donDichVu) {
		activemenu(model);
		chuyenhuongtrang = 1;
		model.addAttribute("madatphong", madatphong);
		model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
		getlistdsdadat(model);
		return "dv.jsp?view=dichvu/giatui";
	}

	@RequestMapping(value = "/actionloaidichvu", params = "thugian")
	public String thugian(ModelMap model, @ModelAttribute("donDichVu") DonDichVu donDichVu) {
		activemenu(model);
		chuyenhuongtrang = 2;
		model.addAttribute("maDatPhong", madatphong);
		model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
		getlistdsdadat(model);
		return "dv.jsp?view=dichvu/thugian";
	}

	@RequestMapping(value = "/actionloaidichvu", params = "khac")
	public String dichVuKhac(ModelMap model) {
		activemenu(model);
		chuyenhuongtrang = 4;
		model.addAttribute("madatphong", madatphong);
		model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
		getlistdsdadat(model);
		return "dv.jsp?view=dichvu/dichvukhac";
	}

	@RequestMapping("/actionanuong")
	public String actionanuong(ModelMap model, @ModelAttribute("donDichVu") DonDichVu donDichVu,
			HttpServletRequest httpServletRequest) {
		activemenu(model);
		Date date = new Date();
		model.addAttribute("madatphong", madatphong);
		if (donDichVu.getSoLuong() == 0) {
			model.addAttribute("message", "Số lượng không hợp lệ");
			getlistdsdadat(model);
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			return "dv.jsp?view=dichvu/anuong";
		} else {
			HttpSession session = httpServletRequest.getSession();
			String nguoiDung = session.getAttribute("nguoidung").toString();
			donDichVu.setTenDangNhap(nguoiDung);
			donDichVu.setNgayDat(date);
			donDichVu.setGioDat(date);
			idv.save(donDichVu);
			model.addAttribute("message", "Thêm thành công");
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			getlistdsdadat(model);
			model.addAttribute("donDichVu", new DonDichVu());
			return "dv.jsp?view=dichvu/anuong";
		}
	}

	@RequestMapping("/actiongiatui")
	public String actiongiatui(ModelMap model, @ModelAttribute("donDichVu") DonDichVu donDichVu,
			HttpServletRequest httpServletRequest) {
		activemenu(model);
		model.addAttribute("madatphong", madatphong);
		Date date = new Date();
		if (donDichVu.getSoLuong() == 0) {
			model.addAttribute("message", "Số lượng không hợp lệ");
			getlistdsdadat(model);
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			return "dv.jsp?view=dichvu/giatui";
		} else {
			HttpSession session = httpServletRequest.getSession();
			String nguoiDung = session.getAttribute("nguoidung").toString();
			donDichVu.setTenDangNhap(nguoiDung);
			donDichVu.setNgayDat(date);
			donDichVu.setGioDat(date);
			idv.save(donDichVu);
			model.addAttribute("message", "Thêm thành công");
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			getlistdsdadat(model);
			model.addAttribute("donDichVu", new DonDichVu());
			return "dv.jsp?view=dichvu/giatui";
		}
	}

	@RequestMapping("/actionthugian")
	public String actionthugian(ModelMap model, @ModelAttribute("donDichVu") DonDichVu donDichVu,
			HttpServletRequest httpServletRequest) {
		activemenu(model);
		model.addAttribute("madatphong", madatphong);
		Date date = new Date();
		if (donDichVu.getSoLuong() == 0) {
			model.addAttribute("message", "Số lượng không hợp lệ");
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			getlistdsdadat(model);
			return "dv.jsp?view=dichvu/thugian";
		} else {
			HttpSession session = httpServletRequest.getSession();
			String nguoiDung = session.getAttribute("nguoidung").toString();
			donDichVu.setTenDangNhap(nguoiDung);
			donDichVu.setNgayDat(date);
			donDichVu.setGioDat(date);
			idv.save(donDichVu);
			model.addAttribute("message", "Thêm thành công");
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			getlistdsdadat(model);
			model.addAttribute("donDichVu", new DonDichVu());
			return "dv.jsp?view=dichvu/thugian";
		}
	}

	@RequestMapping("/actiondichvukhac")
	public String actionanuong(ModelMap model, HttpServletRequest httpServletRequest,
			@RequestParam(name = "maDatPhong") Integer maDatPhong,
			@RequestParam(name = "tenDichVu") String tenDichVu,
			@RequestParam(name = "thongTinThem") String thongTinThem,
			@RequestParam(name = "giaDichVu") Double giaDichVu) {
		activemenu(model);
		
		// thêm dịch vụ trước
		DichVu dv = new DichVu();
		dv.setTenDichVu(tenDichVu);
		dv.setLoaiDichVu(3);
		dv.setGiaDichVu(giaDichVu);
		dsqldvService.save(dv);
		// get id dich vu vua them
		Integer maDV = dsqldvService.getLastIdDv();
		
		DonDichVu donDichVu = new DonDichVu();
		Date date = new Date();
		HttpSession session = httpServletRequest.getSession();
		String nguoiDung = session.getAttribute("nguoidung").toString();
		donDichVu.setTenDangNhap(nguoiDung);
		donDichVu.setNgayDat(date);
		donDichVu.setGioDat(date);
		donDichVu.setSoLuong(1);
		donDichVu.setThongTinThem(thongTinThem);
		
		DichVu dichVu = new DichVu();
		dichVu.setMaDichVu(maDV);
		donDichVu.setDichVu(dichVu);
		
		DatPhong datPhong = new DatPhong();
		datPhong.setMaDatPhong(maDatPhong);
		donDichVu.setDatPhong(datPhong);
		idv.save(donDichVu);
		
		model.addAttribute("message", "Thêm thành công");
		model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
		getlistdsdadat(model);
		model.addAttribute("madatphong", maDatPhong);
		return "dv.jsp?view=dichvu/dichvukhac";
	}

	@RequestMapping("/deletedvdd")
	public String deletedvdd(ModelMap model, @ModelAttribute("donDichVu") DonDichVu donDichVu,
			@RequestParam("id") int id) {
		activemenu(model);
		if (chuyenhuongtrang == 3) {
			model.addAttribute("width", "100%");
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
		}
		donDichVu.setMaDonDichVu(id);
		idv.delete(donDichVu);
		model.addAttribute("message", "Xóa thành công");
		model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
		model.addAttribute("madatphong", madatphong);
		getlistdsdadat(model);
		if (chuyenhuongtrang == 0) {
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			return "dv.jsp?view=dichvu/anuong";
		} else if (chuyenhuongtrang == 1) {
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			return "dv.jsp?view=dichvu/giatui";
		} else if (chuyenhuongtrang == 2) {
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			return "dv.jsp?view=dichvu/thugian";
		} else if (chuyenhuongtrang == 4) {
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			return "dv.jsp?view=dichvu/dichvukhac";
		} else {
			model.addAttribute("titlepage", "Đặt dịch vụ cho phòng " + sophongtemp);
			return "dv";
		}

	}

	public double getDonGia(int madichvu) {
		DichVu dv = dsqldvService.findById(madichvu).get();
		return dv.getGiaDichVu();
	}

	@ModelAttribute("ltendichvugiatui")
	public List<DichVu> ltendichvugiatui() {
		List<DichVu> ltendichvugiatui = dsqldvService.selectgiatui();
		return ltendichvugiatui;
	}

	@ModelAttribute("ltendichvuthugian")
	public List<DichVu> ltendichvuthugian() {
		List<DichVu> ltendichvuthugian = dsqldvService.selectthugian();
		return ltendichvuthugian;
	}

	@ModelAttribute("ltendichvuanuong")
	public List<DichVu> ltendichvuanuong() {
		List<DichVu> ltendichvuanuong = dsqldvService.selectanuong();
		return ltendichvuanuong;
	}

	public void getlistdsdadat(ModelMap model) {
		List<DonDichVu> l = idv.datdichvu(madatphong);
		model.addAttribute("l", l);
		double sum = 0;
		for (int i = 0; i < l.size(); i++) {
			sum += l.get(i).getSoLuong() * l.get(i).getDichVu().getGiaDichVu();
		}
		model.addAttribute("sum", sum);
	}

	private void activemenu(ModelMap model) {
		// active trên menu model.addAttribute("activedptp",null);
		model.addAttribute("activedv", "active");
	}

}
