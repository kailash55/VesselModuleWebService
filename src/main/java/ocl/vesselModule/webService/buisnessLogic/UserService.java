package ocl.vesselModule.webService.buisnessLogic;

import java.util.ArrayList;
import java.util.List;

import ocl.vesselModule.webService.dao.UserDAO;
import ocl.vesselModule.webService.dbEntities.UserModel;
import ocl.vesselModule.webService.dto.LoginDTO;
import ocl.vesselModule.webService.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDAO userDAO;

	public UserDTO command_CreateUser(UserDTO p_user)
	{
		UserModel user = new UserModel();
		user.setName(p_user.getUserName());
		user.setEmailId(p_user.getEmailId());
		user.setPassword(p_user.getPassword());
		userDAO.save(user);
		p_user.setId(user.getId());
		return p_user;
	}


	public List<UserDTO> getAllUsers()
	{
		List<UserModel> users = (List<UserModel>) userDAO.findAll();
		List<UserDTO> userResultList = new ArrayList<UserDTO>();
		
		for(UserModel userModel : users)
		{
			UserDTO userResult = new UserDTO();
			userResult.setId(userModel.getId());
			userResult.setEmailId(userModel.getEmailId());
			userResult.setUserName(userModel.getName());
			userResult.setPassword(userModel.getPassword());
			
			userResultList.add(userResult);
		}
		
		return userResultList;
	}
	
	
	public List<UserDTO> getAllUsersByName(String username)
	{
		List<UserModel> users = new ArrayList<UserModel>();
		
		if(username.isEmpty())
			users = (List<UserModel>) userDAO.findAll();
		else
			users = (List<UserModel>) userDAO.findByNameContainingIgnoreCase(username);
		List<UserDTO> userResultList = new ArrayList<UserDTO>();
		
		for(UserModel userModel : users)
		{
			UserDTO userResult = new UserDTO();
			userResult.setId(userModel.getId());
			userResult.setEmailId(userModel.getEmailId());
			userResult.setUserName(userModel.getName());
			userResult.setPassword(userModel.getPassword());
			
			userResultList.add(userResult);
		}
		
		return userResultList;
	}
	
	
	public boolean isUserExist(LoginDTO p_user)
	{
		List<UserModel> users = (List<UserModel>) userDAO.findByEmailIdAndPassword(p_user.getEmailId(), p_user.getPassword());
		
		if(users != null && users.size() > 0)
			return true;
		else
			return false;
	}
	
	public List<String> getAllExistingEmailIds()
	{
		return userDAO.getAllEmailIds();
	}

	public void deleteUser(Long id)
	{
		userDAO.deleteById( id );
	}
}
