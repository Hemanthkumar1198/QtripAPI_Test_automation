package api.payload;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;



public class Registerpayload {
	static Date now = new Date();
	static String getlocaltime = new SimpleDateFormat("ddMMyyyy_HHmmss").format(now);
	public static String email = "Tester_"+getlocaltime+"@gmail.com";
	public static String password = "Pass_"+getlocaltime;
	
	public static JSONObject registerpayload() {
		System.out.println(email+" | "+password);
		JSONObject obj = new JSONObject();
		obj.put("email", email);
		obj.put("password", password);
		obj.put("confirmpassword", password);
		
		return obj;
	}

}
