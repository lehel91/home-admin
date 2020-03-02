package hu.lmsystems.homeadmin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.lmsystems.homeadmin.model.HomeAdminUserDetails;
import hu.lmsystems.homeadmin.service.ProductService;

@Controller
public class HomeAdminResource {

	private static final Logger logger = LoggerFactory.getLogger(HomeAdminResource.class);

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		HomeAdminUserDetails userObject = (HomeAdminUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
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

	@GetMapping("/shopping-list")
	public String shoppingList() {
		return "shopping-list";
	}

	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}

	@RequestMapping(value="shopping-list/search", method = RequestMethod.GET)
	@ResponseBody
	public List<String> search(HttpServletRequest request) {
		
		List<String> searchedProducts = productService.search(request.getParameter("term"));
		
		logger.info("***search term***: " + request.getParameter("term"));
		logger.info(searchedProducts.toString());
		
		return searchedProducts;
	}
}
