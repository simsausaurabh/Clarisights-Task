import prog.SumOfThreeNo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

// This Junit Test will actually test whether the 
// 3 numbers are returned or not for the given number and a list of numbers
public class SumOfThreeNoTest {

    @Test
    public void SumOfThreeNoTest() {
    	//j Testing the respective sum of three no method

    	// Creating the object of the respective class
        SumOfThreeNo sumOfThreeNos = new SumOfThreeNo();
        ArrayList<int[]> numbers = new ArrayList<int[]>();

        // For an example taking the actual array to be
        int[] actual_arr = {1, 2, 3, 5, 8, 10, 15};

        // For an example taking the actual no to be 10
        int given_sum_to_find = 10;

        // Computing the process by passing the numbers into the method
        sumOfThreeNos.findThreeNumbers(numbers, actual_arr, given_sum_to_find);

        // Asserting to check whether the returned results are equal to the given nos or not
        assertEquals(numbers.get(0)[0], 2);
        assertEquals(numbers.get(0)[1], 3);
        assertEquals(numbers.get(0)[2], 5);
    }

}
