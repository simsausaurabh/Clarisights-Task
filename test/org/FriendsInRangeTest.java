import prog.FriendsInRange;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

// This Junit Test will actually test the list of friends within the range of 100 KM
public class FriendsInRangeTest {

    @Test
    public void findFriendsInRangeTest() {

    	// Creatng the object of the java file to be tested
    	FriendsInRange friendsInRange = new FriendsInRange();

    	// Creating the JSONArray of actual results
    	JSONArray actualValue = [
                                 {"latitude": "13.2411022", "user_id": 4, "name": "Ian", "longitude": "77.238335"},
                                 {"latitude": "13.1302756", "user_id": 5, "name": "Nora", "longitude": "77.2397222"},
                                 {"latitude": "13.1229599", "user_id": 6, "name": "Theresa", "longitude": "77.2701202"},
                                 {"latitude": "12.240382", "user_id": 10, "name": "Georgina", "longitude": "77.972413"},
                                 {"latitude": "13.008769", "user_id": 11, "name": "Richard", "longitude": "77.1056711"},
                                 {"latitude": "12.966", "user_id": 15, "name": "Michael", "longitude": "77.463"},
                                 {"latitude": "12.366037", "user_id": 16, "name": "Ian", "longitude": "78.179118"},
                                 {"latitude": "12.833502", "user_id": 25, "name": "David", "longitude": "78.122366"}
                                 {"latitude": "13.1489345", "user_id": 31, "name": "Alan", "longitude": "77.8422408"},
                                 {"latitude": "13.0033946", "user_id": 39, "name": "Lisa", "longitude": "77.3877505"},
                             ];

    	JSONParser parser = new JSONParser();

        try {
        	 // Reading JSON file and sending it as a prameter
        	 // into the function of finding friends within the range of 100 KM
             Object obj = parser.parse(new FileReader("friends.json")); 
             JSONArray jsonArray = (JSONArray) obj;

             // Asserting to check if the obtained list of friends are actually what is expected
             assertEquals(friendsInRange.findFriendsInRange(jsonArray), actualValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
