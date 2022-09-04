package Data;

public class LoginData {
	private String email;
	private String password;
	private String stringErr;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStringErr() {
		return stringErr;
	}
	public void setStringErr(String stringErr) {
		this.stringErr = stringErr;
	}
	@Override
	public String toString() {
		return "LoginData [email=" + email + ", password=" + password + ", stringErr=" + stringErr + "]";
	}
	public LoginData(String email, String password, String stringErr) {
		super();
		this.email = email;
		this.password = password;
		this.stringErr = stringErr;
	}
	public LoginData() {
		super();
	}
	
	
}
