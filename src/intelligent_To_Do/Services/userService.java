package intelligent_To_Do.Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.google.appengine.labs.repackaged.org.json.JSONException;

import intelligent_To_Do.Model.*; 


@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class userService {

@POST
@Path("/RegestrationService")
public String registrationService( @FormParam("username") String name,
		 @FormParam("userpassword") String password ,@FormParam("useremail") String email 
		,@FormParam("gender") String gender,@FormParam("city") String city
		,@FormParam("birth_date")String birth_date,@FormParam("Twitter_Account")String Twitter_Account) throws JSONException
{
	
	User user =new User(name, email, password, Twitter_Account, gender, city, birth_date);
	UserBDManager BD =new UserBDManager(user);
	long userId =BD.SaveUser();
	JSONObject object = new JSONObject();
	if (userId != 0){
	  object.put("Status", "OK");
	  object.put("userId", userId);
	  object.put("username", name);

	}
	else 
	{
		 object.put("Status", "fail");
	}
	return object.toString();
	
}

@POST
@Path("/LoginService")
public String loginService(@FormParam("useremail") String useremail,
		@FormParam("userpassword") String pass) {
	JSONObject object = new JSONObject();
	User user =new User(useremail, pass);
	UserBDManager BD =new UserBDManager(user);
	User Result=BD.getUser();
	object.put("Status", "OK");
	object.put("username", Result.getUserName());
	object.put("userId", Result.getUserId());
	return object.toString();
}

@POST
@Path("/GetUserInfoService")
public String GetUserInfoService (@FormParam("userId") String userid){
	JSONObject object = new JSONObject();
	User user =new User(Long .parseLong(userid));
	UserBDManager BD =new UserBDManager(user);
	User Result=BD.GetUserInfo();
	object.put("Status", "OK");
	object.put("username", Result.getUserName());
	object.put("useremail", Result.getUserEmail());
	object.put("userpassword", Result.getUserPassword());
	object.put("usergender", Result.getGender());
	object.put("usercity", Result.getCity());
	object.put("usertwiterAcc", Result.getUserTwitterAccount());
	object.put("userbirthdate", Result.getDateOfBirth());
	
	return object.toString();

	
}

@POST
@Path("/UpdateProfileService")
public String UpdateProfileService(@FormParam("userId")String id,@FormParam("username") String name,
		@FormParam("useremail") String email ,@FormParam("userpassword") String password ,
		@FormParam("gender") String gender,@FormParam("city") String city
        ,@FormParam("birth_date")String birth_date
        ,@FormParam("Twitter_Account")String Twitter_Account) throws JSONException
{
	
	User user =new User(name, email, password, Twitter_Account, gender, city, birth_date);
	user.setUserId(Long.parseLong(id));
	UserBDManager BD =new UserBDManager(user);
	 boolean test =BD.UpdateProfile();
	JSONObject object = new JSONObject();
	if ( test==true){
	  object.put("Status", "OK");

	}
	else 
	{
		 object.put("Status", "fail");
	}
	return object.toString();
}

@POST
@Path("/AddOrdinaryNoteService")
public String AddOrdinaryNoteService(){
	
	
	
	return null;
	
	
}

}