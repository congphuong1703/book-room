package DuAn2.user;

import DuAn2.Dto.BookingDTO;
import DuAn2.Model.Phong;
import DuAn2.Services.QuanLyPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping({"/"})
public class PageController {


	@Autowired
	private QuanLyPhongService quanLyPhongService;

	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String flowers() {
		return "about";
	}

	@RequestMapping(value = "service", method = RequestMethod.GET)
	public String service() {
		return "service";
	}

	@RequestMapping(value = "blog", method = RequestMethod.GET)
	public String blog() {
		return "blog";
	}

	@RequestMapping(value = "blog-single", method = RequestMethod.GET)
	public String blog_single() {
		return "blog-single";
	}

	@RequestMapping(value = "room", method = RequestMethod.GET)
	public String room(@Param("roomType") String roomType, Model model) {
		List<Phong> phongs;
		if (roomType == null || roomType.equalsIgnoreCase("Homestay"))
			phongs = quanLyPhongService.findAll();
		else
			phongs = quanLyPhongService.findAllByLoaiPhongTenLoaiPhong(roomType);
		model.addAttribute("listRoom", phongs);

		return "room";
	}

	@RequestMapping(value = "room-single", method = RequestMethod.GET)
	public String room_single() {
		return "room-single";
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}

	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public String booking(@Param("roomCode") Integer roomCode, Model model) {

		BookingDTO bookingDTO = new BookingDTO();
		Phong phong = new Phong();
		if (roomCode != null) {
			phong = quanLyPhongService.getByMaPhong(roomCode);

			bookingDTO.setRoomCode(roomCode);
			bookingDTO.setRoomType(phong.getLoaiPhong().getTenLoaiPhong());
			model.addAttribute("show", true);

		}
		model.addAttribute("roomCode", phong.getMaPhong());
		model.addAttribute("roomNumber", phong.getSoPhong());
		model.addAttribute("bookingDTO", bookingDTO);
		return "booking";
	}

	@RequestMapping(value = "listroom", method = RequestMethod.GET)
	public String listroom() {
		return "listroom";
	}
}
