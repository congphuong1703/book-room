package DuAn2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	SecurityInterceptor securityInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		// đăng kí chạy securityInterceptor cho tất cả trang khi chạy các trang web. trừ trang dangnhap
		registry.addInterceptor(securityInterceptor).excludePathPatterns("/dangnhap").excludePathPatterns("/actionlogin").excludePathPatterns("/css/style.css").excludePathPatterns("/vendor/jquery/jquery.min.js").excludePathPatterns("/js/index.js");
	
		//ah cmt cái login r đây
		// chỉ khi vào trang home mới chạy interceptor
		registry.addInterceptor(securityInterceptor).addPathPatterns("/home");
	}
}
