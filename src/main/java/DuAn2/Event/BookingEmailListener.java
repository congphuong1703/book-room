package DuAn2.Event;

import DuAn2.Dto.BookingDTO;
import DuAn2.Model.Phong;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookingEmailListener implements ApplicationListener<OnBookingSuccessEvent> {
	@Override
	public void onApplicationEvent(OnBookingSuccessEvent onBookingSuccessEvent) {
		this.confirmBooking(onBookingSuccessEvent);
	}
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Configuration configuration;


	private void confirmBooking(OnBookingSuccessEvent event) {
		BookingDTO bookingDTO = event.getBookingDTO();
		Phong phong = event.getPhong();

		String recipient = bookingDTO.getEmail();
		String subject = "Booking Successful";

		Map<String, Object> model = new HashMap<>();
		model.put("name", bookingDTO.getName());
		model.put("phoneNumber", bookingDTO.getPhoneNumber());
		model.put("email", bookingDTO.getEmail());
		model.put("checkInDate", bookingDTO.getCheckInDate());
		model.put("checkOutDate", bookingDTO.getCheckOutDate());
		model.put("roomCode", phong.getMaPhong());
		model.put("roomNumber", phong.getSoPhong());
		model.put("roomPrice", phong.getGiaPhong());

		MimeMessage email = this.sendEmail("booking.txt", model, recipient, subject);
		mailSender.send(email);
	}

	public MimeMessage sendEmail(String temp, Map<String,Object> model, String recipient, String subject) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		StringBuffer content = new StringBuffer();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "utf-8");

			Template template = configuration.getTemplate(temp);
			content.append(FreeMarkerTemplateUtils.processTemplateIntoString(template, model));

			helper.setText(content.toString(), true);
			helper.setTo(recipient);
			helper.setSubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mimeMessage;
	}

}
