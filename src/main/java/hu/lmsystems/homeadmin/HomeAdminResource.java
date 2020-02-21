package hu.lmsystems.homeadmin;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAdminResource {

	@RequestMapping("/")
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		model.addAttribute("name", currentPrincipalName);
		return "welcome";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return("<h1>Welcome Admin</h1>");
	}
	
	@GetMapping("/user") 
	public String user() {	
		return("<h1>Welcome User</h1>");
	}
}
