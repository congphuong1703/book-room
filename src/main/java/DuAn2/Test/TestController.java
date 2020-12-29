package DuAn2.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import DuAn2.Services.Ilsdtp;

@Controller
public class TestController {

	@Autowired
	Ilsdtp ilsdtp;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		return "test";
	}
}
