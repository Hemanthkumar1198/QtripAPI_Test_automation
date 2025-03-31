package api.utils;

import api.payload.Registerpayload;

public class Loginpojo {

	private String email;
	private String password;

	public Loginpojo(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public static Loginpojo loginpaylod() {
		Loginpojo loginpayload = new Loginpojo(Registerpayload.email, Registerpayload.password);
		return loginpayload;
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
	
	//to use Loginpojo.tojson in method
	 public String toJson() {
	        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
	    }

}
