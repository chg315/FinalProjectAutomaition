package Data;

public class RegistrationData {
	public RegistrationData() {
		
	}

	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	private String confirmPassword;
	private String stringErr;



	public RegistrationData(String firstName, String lastName, String phone, String email,
			String password, String confirmPassword, String stringErr) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.stringErr = stringErr;
	}

	public String getStringErr() {
		return stringErr;
	}

	public void setStringErr(String stringErr) {
		this.stringErr = stringErr;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public String getBirthDate() {
//		return birthDate;
//	}
//
//	public void setBirthDate(String birthDate) {
//		this.birthDate = birthDate;
//	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "RegistrationData [firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}

}
