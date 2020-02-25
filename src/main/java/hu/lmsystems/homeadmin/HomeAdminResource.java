package hu.lmsystems.homeadmin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hu.lmsystems.homeadmin.model.HomeAdminUserDetails;

@Controller
public class HomeAdminResource {

	private static final Logger logger = LoggerFactory.getLogger(HomeAdminResource.class);

	@Autowired
	MessageSource messageSource;

	@GetMapping("/")
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		HomeAdminUserDetails userObject = (HomeAdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String currentPrincipalName = authentication.getName();
		
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();		
		List<String> permissions = new ArrayList<>();

		for (GrantedAuthority authority : authorities) {
			permissions.add(authority.getAuthority());
		}
		
		model.addAttribute("userName", currentPrincipalName);
		model.addAttribute("firstName", userObject.getFirstName());
		model.addAttribute("permissions", permissions);

		return "welcome";

	}

	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}

	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}
}
