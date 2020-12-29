package DuAn2.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.DatPhong;
import DuAn2.Model.Phong;
import DuAn2.Services.Ilsdtp;
import DuAn2.Services.Ittp;

@Controller
@Transactional
public class HomeStayController {

	@Autowired
	Ilsdtp ilsdtp;
	
	@Autowired
	Ittp ittp;

	@GetMapping("/homestay")
	public String homestay(ModelMap model, @RequestParam("maPhong") Integer maPhong,
			@RequestParam("soPhong") Integer soPhong) {
		List<DatPhong> danhsach = ilsdtp.listHomestayByMaPhong(maPhong);
		model.addAttribute("titlepage", "Homestay");
		model.addAttribute("danhsach", danhsach);
		model.addAttribute("maPhong", maPhong);
		model.addAttribute("soPhong", soPhong);
		return "homestay/homestay";
	}

	@GetMapping("/addhomestay")
	public String addhomestay(ModelMap model, @RequestParam("maPhong") Integer maPhong,
			@RequestParam("soPhong") Integer soPhong, DatPhong datphong) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		datphong = new DatPhong();
		
		model.addAttribute("maPhong", maPhong);
		model.addAttribute("soPhong", soPhong);
		model.addAttribute("datphong", datphong);
		model.addAttribute("ngayhientai", dateFormat.format(cal.getTime()));
		model.addAttribute("giohientai", timeFormat.format(cal.getTime()));
		model.addAttribute("titlepage", "Thêm khách homestay");
		return "homestay/addhomestay";
	}

	@PostMapping("/actionaddhomestay")
	public String actionaddhomestay(ModelMap model, @RequestParam("maPhong") Integer maPhong,
			@RequestParam("soPhong") Integer soPhong,@ModelAttribute("datphong") DatPhong datphong) {
		// lưu thông tin khách đã đặt
				ilsdtp.save(datphong);
		
		Phong p = ittp.findById(datphong.getPhong().getMaPhong()).get();
		// set trạng thái bằng 2 để phân biệt đang thuê kiểu homestay
		p.setTrangThai(2);
		// đếm và update tổng số khách đã đặt 
		Integer countHomestay = ittp.countHomestayByMaPhong(maPhong);
		p.setCountHomestay(countHomestay);
		ittp.save(p);
		model.addAttribute("message", "Thêm thành công");
		return homestay(model, maPhong, soPhong);
	}

	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "homestay";
	}

	@ModelAttribute(name = "activedptp")
	public String activedptp() {
		return "active";
	}
}
