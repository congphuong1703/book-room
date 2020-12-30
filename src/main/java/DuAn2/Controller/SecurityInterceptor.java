package DuAn2.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import DuAn2.Services.ITaikhoanServices;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	ITaikhoanServices itaikhoan;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		   throws Exception {
		HttpSession session = request.getSession();

//		if (session.getAttribute("nguoidung") == null) {
//			response.sendRedirect(request.getContextPath() + "/dangnhap");
//			return false;
//		}
		if (session.getAttribute("nguoidung") == null) {
			if (request.getServletPath().equalsIgnoreCase( "/qltk") || request.getServletPath().equalsIgnoreCase("/addtk")
				   || request.getServletPath().equalsIgnoreCase("/addqlp" )|| request.getServletPath().equalsIgnoreCase("/qlp")
				   || request.getServletPath().equalsIgnoreCase("/addlp") || request.getServletPath().equalsIgnoreCase("/dsqldv")
				   || request.getServletPath().equalsIgnoreCase( "/qllp") || request.getServletPath().equalsIgnoreCase("/themdsqldv")
				   || request.getServletPath().equalsIgnoreCase("/dptp")){
				response.sendRedirect(request.getContextPath() + "/dangnhap");
				return false;
			}
		}

		if (session.getAttribute("chucvu") != null) {
			if (session.getAttribute("chucvu").equals("1")) {
				session.setAttribute("ancaidai", "hien");
			} else {
				session.setAttribute("ancaidai", null);

			}
		}

		return true;
	}

	// chay sau khi chạy xong action. sau view
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();

		if (session.getAttribute("chucvu") != null) {
			if (modelAndView.getViewName() == "qltk" || modelAndView.getViewName() == "addtk"
				   || modelAndView.getViewName() == "addqlp" || modelAndView.getViewName() == "qlp"
				   || modelAndView.getViewName() == "addlp" || modelAndView.getViewName() == "dsqldv"
				   || modelAndView.getViewName() == "qllp" || modelAndView.getViewName() == "themdsqldv"
				   || modelAndView.getViewName() == "dptp") {
				if (!session.getAttribute("chucvu").equals("1")) {
					modelAndView.clear();
					modelAndView.setViewName("stop");
				}
			}
		}
		super.postHandle(request, response, handler, modelAndView);
	}

}
