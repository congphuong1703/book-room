package DuAn2.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class SendMailConfiguration {

	@Bean(name = "mailSender")
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		Properties mailProperties = new Properties();

		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		javaMailSender.setProtocol("smtp");
		javaMailSender.setUsername("congphuong.jav62@gmail.com");
		javaMailSender.setPassword("Conghpuong1a");
		javaMailSender.setDefaultEncoding("UTF-8");

		mailProperties.put("mail.smtp.auth", "true");
		mailProperties.put("mail.smtp.starttls.enable", "true");
		mailProperties.put("mail.smtp.debug", "true");
		mailProperties.setProperty("mail.smtp.allow8bitmime", "true");
		mailProperties.setProperty("mail.smtps.allow8bitmime", "true");

		javaMailSender.setJavaMailProperties(mailProperties);
		return javaMailSender;
	}
}
