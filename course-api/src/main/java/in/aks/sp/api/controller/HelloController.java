package in.aks.sp.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aks")
public class HelloController {
	
	@GetMapping("/hello")
	public String helloCourseAPI()
	{
		
		return "Welcome to Hello course API..";
	}

}
