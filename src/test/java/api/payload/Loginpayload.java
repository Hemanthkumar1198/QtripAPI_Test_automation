package api.payload;

import org.json.JSONObject;

public class Loginpayload {
	
	public static JSONObject loginpayload() {
		System.out.println(Registerpayload.email+" | "+Registerpayload.password);
		JSONObject obj = new JSONObject();
		obj.put("email", Registerpayload.email);
		obj.put("password", Registerpayload.password);
		
		return obj;
	}

}
