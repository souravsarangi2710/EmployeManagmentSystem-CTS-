package com.cts.Controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.Entities.Login;
import com.cts.Services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	/*	redirecting to the first page	*/
	@GetMapping("/")
    public String root() {
        return "home";
    }
	
	/*	redirecting to the user registration page	*/
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new Login());
	     
	    return "signup-form";
	}
	
	/*	user registration data saved to databases	*/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") Login user) {
        loginService.save(user);
        return "redirect:/login";
    }
	
	/*	redirecting to the user registration page	*/
	@PostMapping("/process-register")
	public String processRegister(Login user) {
//	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	    String encodedPassword = passwordEncoder.encode(user.getPassword());
//	    user.setPassword(encodedPassword);
	     
	    loginService.save(user);
	     
	    return "register-success";
	}
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new Login());
		return mav;
	}

	/*	redirecting to the user login page	*/
	@PostMapping("/login")
	public String login(@ModelAttribute("user") Login user) {

		Login oauthUser = loginService.login(user.getUsername(), user.getPassword());
		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser)) {
			return "redirect:/list";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/";
	}

}
