package DuAn2.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping({"", "home"})
public class HomePageController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		//modelMap.put("featuredProducts", roomsServices.findFeatured(true, 2));
		//modelMap.put("latestProduts", roomsServices.latest(3));
		return "home";
	}
	
}
