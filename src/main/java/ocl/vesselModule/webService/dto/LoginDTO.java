package ocl.vesselModule.webService.dto;

public class LoginDTO {
	String emailId;
	String password;
	boolean isLoginSuccessfull;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLoginSuccessfull() {
		return isLoginSuccessfull;
	}
	public void setLoginSuccessfull(boolean isLoginSuccessfull) {
		this.isLoginSuccessfull = isLoginSuccessfull;
	}
}
