package ocl.vesselModule.webService.dao;

import java.util.List;

import ocl.vesselModule.webService.dbEntities.UserModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<UserModel, Long>{
	
	Iterable<UserModel> findByEmailIdAndPassword(String emailId, String password);
	
	Iterable<UserModel> findByNameContainingIgnoreCase(String name);
	
	@Query("select u from ocl.vesselModule.webService.dbEntities.UserModel u where u.name=:username")
	List<UserModel> getUserByUserName(@Param("username")String username);
	
	@Query("select u.emailId from ocl.vesselModule.webService.dbEntities.UserModel u")
	List<String> getAllEmailIds();
}
