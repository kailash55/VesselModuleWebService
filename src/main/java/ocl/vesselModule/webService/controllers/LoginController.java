package ocl.vesselModule.webService.controllers;

import ocl.vesselModule.webService.buisnessLogic.UserService;
import ocl.vesselModule.webService.dto.LoginDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public boolean login(@RequestBody LoginDTO loginDto)
	{
		return userService.isUserExist(loginDto);
	}
}
