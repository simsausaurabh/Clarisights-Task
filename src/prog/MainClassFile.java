package prog;

import java.util.ArrayList;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
// This is the Main Class file for the whole project
class MainClassFile {

    public static void main(String args[]) {

    	// This Section is for first problem i.e. Sum of Three Numbers
    	System.out.println("Section 1 for first problem i.e. Sum of Three Numbers\n");

    	// Creating object for the first problem file
    	SumOfThreeNo sumOfThreeNos = new SumOfThreeNo();
        ArrayList<int[]> numbers = new ArrayList<int[]>();

        // For an example, taking the array elements as:
        int[] actual_arr = {1, 2, 3, 5, 8, 10, 15};

        // The given sum to be:
        int given_sum_to_find = 10;

        // Obtaining the result
        sumOfThreeNos.findThreeNumbers(numbers, actual_arr, given_sum_to_find);

        // Printing the result on console
        sumOfThreeNos.printSetOfThreeNumbers(numbers);

        System.out.println("\n");

        // This Section is for second problem i.e. Finding Friends in range < 100 KM
        System.out.println("Section 2 for second problem i.e. Finding Friends in range < 100 KM\n");

        // Creating object for the second problem file
        FriendsInRange friendsInRange = new FriendsInRange();
        JSONParser parser = new JSONParser();

        // Handling the file input exception
        try {
        	// Reading the json file
             Object obj = parser.parse(new FileReader("friends.json")); 
             JSONArray jsonArray = (JSONArray) obj;

             // Obtaining the result
             JSONArray friendsJsonResult = (JSONArray)friendsInRange.findFriendsInRange(jsonArray);

             // Printing the result on console
             for(int i = 0; i<friendsJsonResult.size(); i++) {
            	 JSONObject friendObject = (JSONObject) friendsJsonResult.get(i);
            	 System.out.println("User_id = " + friendObject.get("user_id") +
            			 " name = " + friendObject.get("name"));
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
