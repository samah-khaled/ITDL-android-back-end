/**
 * 
 */
package intelligent_To_Do.Model;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;


/**
 * @author samah
 *
 */
public class UserBDManager {

	 User CurrentActiveUser ;
	
	/**
	 * 
	 */
	public UserBDManager(User user) {
		CurrentActiveUser =user;
	}

	
	public	long SaveUser (){
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Transaction txn = datastore.beginTransaction();
		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		Entity employee;
		try {
			//Entity employee1 = new Entity();	
		 employee = new Entity("users");
		
		employee.setProperty("name", CurrentActiveUser.getUserName());
		employee.setProperty("email", CurrentActiveUser.getUserEmail());
		employee.setProperty("password", CurrentActiveUser.getUserPassword());
		employee.setProperty("gender", CurrentActiveUser.getGender());
		employee.setProperty("city", CurrentActiveUser.getCity());
		employee.setProperty("birth_date", CurrentActiveUser.getDateOfBirth());
		employee.setProperty("Twitter_Account", CurrentActiveUser.getUserTwitterAccount());
		datastore.put(employee);
		
		txn.commit();

		}finally{
			if (txn.isActive()) {
		        txn.rollback();
		    }
		}
		return employee.getKey().getId();
			
		}
	
	
	public  User getUser() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("email").toString().equals(CurrentActiveUser.getUserEmail())
					&& entity.getProperty("password").toString().equals(CurrentActiveUser.getUserPassword()))
			{
				User returnedUser = new User(entity.getProperty(
						"name").toString(), entity.getProperty("email")
						.toString(), entity.getProperty("password").toString(),
						entity.getProperty("Twitter_Account").toString(),entity.getProperty("gender").toString(),
						entity.getProperty("city").toString(),entity.getProperty("birth_date").toString());
				 returnedUser.setUserId(entity.getKey().getId() );
						return returnedUser;
			}
		}

		return null;
	}

	public User GetUserInfo(){
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		
		for (Entity entity : pq.asIterable()) {
			if (entity.getKey().getId() == CurrentActiveUser.getUserId())
			{
				User returnedUser = new User(entity.getProperty(
						"name").toString(), entity.getProperty("email")
						.toString(), entity.getProperty("password").toString(),
						entity.getProperty("Twitter_Account").toString(),entity.getProperty("gender").toString(),
						entity.getProperty("city").toString(),entity.getProperty("birth_date").toString());
				 returnedUser.setUserId(entity.getKey().getId());
						return returnedUser;
			}
		}

		return null;
		
	}
	
public boolean UpdateProfile(){
	DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

	Query gaeQuery = new Query("users");
	PreparedQuery pq = datastore.prepare(gaeQuery);
	for (Entity entity : pq.asIterable()) {
		if (entity.getKey().getId() == CurrentActiveUser.getUserId())
		{
			entity.setProperty("name", CurrentActiveUser.getUserName());
			entity.setProperty("email", CurrentActiveUser.getUserEmail());
			entity.setProperty("password", CurrentActiveUser.getUserPassword());
			entity.setProperty("gender", CurrentActiveUser.getGender());
			entity.setProperty("city", CurrentActiveUser.getCity());
			entity.setProperty("birth_date", CurrentActiveUser.getDateOfBirth());
			entity.setProperty("Twitter_Account", CurrentActiveUser.getUserTwitterAccount());
			datastore.put(entity);

			return true;
		}
		
	}
	
	
	return false;
	
	
}
}
