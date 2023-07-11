package Domanog.code.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Domanog.code.model.User;
import Domanog.code.model.repositoryUser.UserRepository;
import Domanog.code.service.UserService;
import Domanog.code.web.dto.UserRegisterDto;

@Controller
@RequestMapping("/register")
public class UserRegisterController {

	@Autowired
	UserRepository userRepo;
	
private UserService userService;
	
	public UserRegisterController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegisterDto userRegisterDto() {
		return new UserRegisterDto();
	}
	
	@GetMapping
	public String displayRegisterFrom() {
		return "register";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegisterDto registerDto) {
				userService.save(registerDto);
				return "redirect:/register?success";
		
	}
	
}