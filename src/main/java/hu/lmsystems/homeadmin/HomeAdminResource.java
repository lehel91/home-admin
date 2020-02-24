package hu.lmsystems.homeadmin;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeAdminResource {

	@GetMapping("/")
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
	
	@GetMapping("/roles")
	public String userRoles(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
		
		model.addAllAttributes(authorities);
		return "user-informations";
	}
}
