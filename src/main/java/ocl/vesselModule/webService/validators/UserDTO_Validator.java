package ocl.vesselModule.webService.validators;

import java.util.List;

import ocl.vesselModule.webService.buisnessLogic.UserService;
import ocl.vesselModule.webService.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserDTO_Validator implements Validator{
	
	@Autowired
	private UserService userService;
	private List<String> existingEmailIds;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoadValidationData();
		UserDTO user = (UserDTO)target;
		boolean isEmailValid = ValidateForEmailId(user.getEmailId());
		//errors.rejectValue( "emailId","", "EmailId already exists");
	}

	private boolean ValidateForEmailId(String p_emailId) {
		// TODO Auto-generated method stub
		return !existingEmailIds.contains(p_emailId);
	}

	private void LoadValidationData() {
		// TODO Auto-generated method stub
		existingEmailIds = userService.getAllExistingEmailIds();
	}

}
