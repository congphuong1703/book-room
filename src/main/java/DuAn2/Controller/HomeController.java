package DuAn2.Controller;

import DuAn2.Dto.BookingDTO;
import DuAn2.Event.OnBookingSuccessEvent;
import DuAn2.Model.DatPhong;
import DuAn2.Model.Phong;
import DuAn2.Model.TraPhong;
import DuAn2.Services.ITraPhong;
import DuAn2.Services.IttkhService;
import DuAn2.Services.QuanLyPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private QuanLyPhongService quanLyPhongService;


	@Autowired
	private ITraPhong iTraPhong;

	@Autowired
	private IttkhService ittkhService;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@RequestMapping({"/", "/home"})
	public String index(ModelMap model) {
		return "home";
	}


	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "dptp";
	}

	@GetMapping("/search-available")
	public String searchAvailable(@RequestParam("checkInDate") String checkInDate,
	                              @RequestParam("typeRoom") String typeRoom,
	                              @RequestParam("maxPrice") double maxPrice,
	                              Model model) {

		List<Phong> phongs = quanLyPhongService.findAllByGiaPhongLessThanAndLoaiPhongTenLoaiPhong(maxPrice, typeRoom);
		List<Phong> availbleRooms = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Phong phong : phongs) {
			if (ittkhService.findAllByPhongMaPhongOrderByNgayDatDesc(phong.getMaPhong()).isEmpty()) {

				availbleRooms.add(phong);
			} else {
				boolean checkDate = true;

				for (DatPhong datPhong : ittkhService.findAllByPhongMaPhongOrderByNgayDatDesc(phong.getMaPhong())) {

					TraPhong traPhong = iTraPhong.getByDatPhongMaDatPhong(datPhong.getMaDatPhong());
					if (traPhong == null) {

						continue;
					} else if ((simpleDateFormat.format(datPhong.getNgayDat()).compareTo(checkInDate) < 1 && simpleDateFormat.format(traPhong.getNgayTra()).compareTo(checkInDate) > -1)) {

						checkDate = false;
						break;
					}
				}
				if (checkDate)
					availbleRooms.add(phong);
			}
		}

		model.addAttribute("listRoom", availbleRooms);
		return "room";
	}


	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String bookingRoom(@Valid @ModelAttribute("bookingDTO") BookingDTO bookingDTO, Model model, WebRequest request) throws ParseException {
		Phong phong = quanLyPhongService.getByMaPhong(bookingDTO.getRoomCode());
		if (phong == null) {
			if (!quanLyPhongService.findAllByLoaiPhongTenLoaiPhong(bookingDTO.getRoomType()).isEmpty()) {
				List<Phong> phongs = quanLyPhongService.findAllByLoaiPhongTenLoaiPhong(bookingDTO.getRoomType());
				for (Phong p : phongs) {
					if (ittkhService.findAllByPhongMaPhongOrderByNgayDatDesc(p.getMaPhong()).isEmpty()) {
						phong = p;
						break;
					} else {

						if (checkDate(p, bookingDTO.getCheckInDate(), bookingDTO.getCheckOutDate())) {
							phong = p;
							break;
						}

					}
				}
			} else {
				model.addAttribute("error", "Out of room");
				return "booking";
			}
		} else {
			if (!ittkhService.findAllByPhongMaPhongOrderByNgayDatDesc(phong.getMaPhong()).isEmpty()) {

				if (!checkDate(phong, bookingDTO.getCheckInDate(), bookingDTO.getCheckOutDate())) {
					model.addAttribute("error", "Room has been reserved");
					return "booking";
				}

			}
		}

		if (phong == null) {
			model.addAttribute("error", "Out of room");
			return "booking";
		}

		if (bookingDTO.getCheckInDate().compareToIgnoreCase(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) < 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			//ở đây viết đúng nó hiện số chuẩn :v
			System.out.println(bookingDTO.getCheckInDate());
			model.addAttribute("error", "Check in date can greater or equal today");
			return "booking";
		}


		if (bookingDTO.getCheckInDate().compareTo(bookingDTO.getCheckOutDate()) > -1) {
			model.addAttribute("error", "Check in date can't greater check out date");
			return "booking";
		}

		java.sql.Date sqlDate = java.sql.Date.valueOf(String.valueOf(bookingDTO.getCheckInDate()));
		java.sql.Date sqlDate1 = java.sql.Date.valueOf(String.valueOf(bookingDTO.getCheckOutDate()));

		DatPhong datPhong = new DatPhong((int) (ittkhService.countfindAll() + 1),
			   bookingDTO.getName(),
			   bookingDTO.getPhoneNumber(),
			   phong,
			   sqlDate);

		TraPhong traPhong = new TraPhong(iTraPhong.findAll().size() + 1,
			   datPhong,
			   sqlDate1,
			   phong.getGiaPhong());

		ittkhService.save(datPhong);
		iTraPhong.save(traPhong);

		try {
			String appUrl = request.getContextPath();
			eventPublisher.publishEvent(new OnBookingSuccessEvent(bookingDTO, appUrl, phong));
		} catch (Exception re) {
			re.printStackTrace();
		}
		model.addAttribute("error", "Successful reservation");
		return "booking";
	}

	private boolean checkDate(Phong phong, String checkInDate, String checkOutDate) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		boolean checkDate = true;

		for (DatPhong datPhong : ittkhService.findAllByPhongMaPhongOrderByNgayDatDesc(phong.getMaPhong())) {

			TraPhong traPhong = iTraPhong.getByDatPhongMaDatPhong(datPhong.getMaDatPhong());
			if (traPhong != null)
				if ((simpleDateFormat.format(datPhong.getNgayDat()).compareTo(checkInDate) < 1 && simpleDateFormat.format(traPhong.getNgayTra()).compareTo(checkInDate) > -1) ||
					   (simpleDateFormat.format(datPhong.getNgayDat()).compareTo(checkOutDate) < 1 && simpleDateFormat.format(traPhong.getNgayTra()).compareTo(checkOutDate) > -1) ||
					   (simpleDateFormat.format(datPhong.getNgayDat()).compareTo(checkOutDate) < 1 && simpleDateFormat.format(traPhong.getNgayTra()).compareTo(checkInDate) > -1)) {

					checkDate = false;
					break;
				}
		}
		return checkDate;
	}
}
