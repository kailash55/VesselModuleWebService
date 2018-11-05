package ocl.vesselModule.webService.controllers;

import java.util.List;

import javax.validation.Valid;

import ocl.vesselModule.webService.buisnessLogic.UserService;
import ocl.vesselModule.webService.dto.UserDTO;

import ocl.vesselModule.webService.validators.UserDTO_Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
	// fields
	@Autowired
	UserService userService;

	private UserDTO_Validator userCreateRequestValidator;


	//Actions
	@Autowired
    public UserController(UserDTO_Validator userCreateRequestValidator)
    {
        this.userCreateRequestValidator = userCreateRequestValidator;
    }


    @InitBinder("userDTO")
    public void setupBinder(WebDataBinder binder)
    {
        binder.addValidators(userCreateRequestValidator);
    }


    @GetMapping
	public List<UserDTO> getAllUsers()
	{
		return userService.getAllUsers();
	}


	@GetMapping("/name/{username}")
	public List<UserDTO> getAllUsersByName(@PathVariable(name = "username", required = false) String username)
	{
		return userService.getAllUsersByName(username);
	}


	@GetMapping("/{id}")
	public void getUserById(@PathVariable int id)
	{
		
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO saveUser(@RequestBody @Valid UserDTO userDto)
	{
		return userService.command_CreateUser(userDto);
	}


	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser( id );
    }
}
