package DuAn2.Controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import DuAn2.Common.Common;
import DuAn2.Model.GiaoDien;
import DuAn2.Model.LichSuDangNhap;
import DuAn2.Model.TaiKhoan;
import DuAn2.Services.GiaoDienService;
import DuAn2.Services.ITaikhoanServices;
import DuAn2.Services.LichSuDangNhapService;

@Controller
@Transactional
public class DangNhapController {

	@Autowired
	ITaikhoanServices dangnhapservice;

	@Autowired
	LichSuDangNhapService lichSuDangNhapService;

	@Autowired
	GiaoDienService giaoDienService;

	int checklogin = 0;

	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "dangnhap";
	}

	@RequestMapping("/dangnhap")
	public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		if (checklogin == 1) {
			model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
			checklogin = 0;
		}
		// get tên tổ chức
		session = request.getSession();
		GiaoDien giaoDien = new GiaoDien();
		giaoDien = ((List<GiaoDien>) giaoDienService.findAll()).get(0);
		session.setAttribute("tenToChuc", giaoDien.getTenToChuc());
		session.setAttribute("diaChi", giaoDien.getDiaChi());
		session.setAttribute("soDienThoai", giaoDien.getSoDienThoai());
		// TODO Auto-generated method stub
		return "login";
	}

	@RequestMapping("/actionlogin")
	public String actiondangnhap(ModelMap model, HttpServletRequest httpServletRequest, HttpServletResponse response,
			@RequestParam("username") String tendangnhap, @RequestParam("password") String matkhau) {
		matkhau = Common.encode(matkhau);
		List<TaiKhoan> l = dangnhapservice.findUser(tendangnhap, matkhau);

		if (l.isEmpty()) {
			checklogin = 1;
			return "redirect:/dangnhap";
		} else {
			HttpSession session = httpServletRequest.getSession();
			saveLichSuDangNhap(tendangnhap);
			session.setAttribute("nguoidung", tendangnhap);
			session.setAttribute("chucvu", l.get(0).getChucVu().getMaChucVu() + "");// 1 giam doc 2 nhan vien
			return "redirect:/dptp";
		}
	}

	public void saveLichSuDangNhap(String tendangnhap) {
		LichSuDangNhap lsdn = new LichSuDangNhap();
		Date date = new Date(System.currentTimeMillis());
		lsdn.setTaiKhoanDangNhap(tendangnhap);
		lsdn.setNgayDangNhap(date);
		lsdn.setGioDangNhap(date);
		lichSuDangNhapService.save(lsdn);
	}

	@RequestMapping("/dangxuat")
	public String dangxuat() {
		return "redirect:/dangnhap";
	}

	@RequestMapping("/doimatkhau")
	public String doimatkhau(HttpServletRequest httpServletRequest, ModelMap model,
			@ModelAttribute("taikhoan") TaiKhoan taikhoan) {
		HttpSession session = httpServletRequest.getSession();
		TaiKhoan gettaikhoan = dangnhapservice.findById(session.getAttribute("nguoidung").toString()).get();
		model.addAttribute("gettaikhoan", gettaikhoan);
		model.addAttribute("changeURL", "doimatkhau");
		model.addAttribute("titlepage", "Đổi mật khẩu");
		return "doimatkhau";
	}

	@RequestMapping("/actiondoimatkhau")
	public String actiondoimatkhau(HttpServletRequest httpServletRequest, ModelMap model,
			@ModelAttribute("taikhoan") TaiKhoan taikhoan) {
		String matkhaucu = httpServletRequest.getParameter("matkhaucu");
		String matkhaumoi = httpServletRequest.getParameter("matkhaumoi");
		matkhaucu = Common.encode(matkhaucu);
		matkhaumoi = Common.encode(matkhaumoi);
		taikhoan.setMatKhau(Common.encode(taikhoan.getMatKhau()));
		model.addAttribute("titlepage", "Đổi mật khẩu");
		HttpSession session = httpServletRequest.getSession();
		TaiKhoan gettaikhoan = dangnhapservice.findById(session.getAttribute("nguoidung").toString()).get();
		if (!matkhaucu.equals(gettaikhoan.getMatKhau())) {
			model.addAttribute("messageloi", "Mật khẩu cũ không chính xác");
			taikhoan.setMatKhau("");
			return "doimatkhau";
		} else if (!matkhaumoi.equals(taikhoan.getMatKhau())) {
			model.addAttribute("messageloi", "Xác nhận lại mật khẩu mới không chính xác");
			taikhoan.setMatKhau("");
			return "doimatkhau";
		} else if (matkhaumoi.length() < 9) {
			taikhoan.setMatKhau("");
			model.addAttribute("messageloi", "Mật khẩu phải từ 8 kí tự trở lên");
			return "doimatkhau";
		} else {
			dangnhapservice.save(taikhoan);
			model.addAttribute("message", "Đổi mật khẩu thành công");
			taikhoan.setMatKhau("");
			return "doimatkhau";
		}
	}

}
