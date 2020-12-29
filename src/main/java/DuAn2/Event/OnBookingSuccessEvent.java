package DuAn2.Event;

import DuAn2.Dto.BookingDTO;
import DuAn2.Model.Phong;
import org.springframework.context.ApplicationEvent;

public class OnBookingSuccessEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private String appUrl;
	private BookingDTO bookingDTO;
	private Phong phong;

	public OnBookingSuccessEvent(BookingDTO bookingDTO,String appUrl,Phong phong) {
		super(bookingDTO);
		this.appUrl = appUrl;
		this.bookingDTO = bookingDTO;
		this.phong = phong;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public BookingDTO getBookingDTO() {
		return bookingDTO;
	}

	public void setBookingDTO(BookingDTO bookingDTO) {
		this.bookingDTO = bookingDTO;
	}
}
