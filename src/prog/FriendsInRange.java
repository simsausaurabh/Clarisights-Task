package prog;

import java.lang.Math;
import java.util.Comparator;

// Required imports for handling JSON based functions
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/*
 * This Java class is for finding the friends within range of 100 KM
 * */
public class FriendsInRange {

/*
 * @param jsonArray: Input JSONArray having list of friends
 * */
	public JSONArray findFriendsInRange(JSONArray jsonArray) {
		// Method for finding friends within range of 100 KM

		// Latitude and Longitude of Home or Origin in Radian
		double latRadOrigin = 12.9611159 * 0.0174533;
		double longRadOrigin = 77.6362214 * 0.0174533;

		// Radius of Earth	
		double radOfEarth = 6371;

		// JSONArray to store the list of friend details within 100 KM
		JSONArray idAndName = new JSONArray();

		// Parsing the JSONArray
		for(int i = 0; i < jsonArray.size(); i++) {

			// Converting JSONArray item to JSONObject
			JSONObject friendObject = (JSONObject) jsonArray.get(i);

			// Taking each latitude and longitude of friend's location in radian
			double friendRadLat = Double.parseDouble((String)friendObject.get("latitude")) * 0.0174533;
			double friendRadLong = Double.parseDouble((String)friendObject.get("longitude")) * 0.0174533;

			// Calculating absolute distance between longitudes
			double absDist = Math.abs(longRadOrigin - friendRadLong);

			// Calculating the parameter required for arcos
			double radParam = Math.sin(latRadOrigin)*Math.sin(friendRadLat)
								+ Math.cos(latRadOrigin)*Math.cos(friendRadLat)*Math.cos(absDist);

			// Finding the central angle using the given formula in wikipedia
			double centralAngleRad = Math.acos(radParam);

			// Calculating the actual distance i.e. arc to the friends location
			double distFromFriend = radOfEarth*centralAngleRad;

			// Appending the friend if the distance is < 100 KM
			if(distFromFriend < 100) {
				idAndName.add(friendObject);
			}

			// Sorting the friend list based on ids
			idAndName.sort(new Comparator<JSONObject>() {
				public int compare(JSONObject a, JSONObject b) {
					long u1 = 0;
					long u2 = 0;
					try {
						u1 = (long)a.get("user_id");

						u2 = (long)b.get("user_id");
					}catch(JSONException e){
						
					}
					return Long.compare(u1, u2);
				}
				
			});
		}
		// Returning the required friend list
		return idAndName;
	}
}
