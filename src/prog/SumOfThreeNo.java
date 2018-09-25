package prog;

import java.util.ArrayList;

// This java file is for obtaining the three no whose sum is equal to a given no
public class SumOfThreeNo {

	// Method for actually finding the 3 numbers
    public void findThreeNumbers(ArrayList<int[]> numbers, int[] arr, int given_sum) {

        int index = 0;
        int[] arrOfThreeNum = new int[3];

        // Obtaining the 1st number
        for(int i = 0; i < arr.length-2; i++) {
        	// Obtaining the 2nd number

            for(int j = i+1; j < arr.length-1; j++) {
            	// Obtaining the 3rd number

                for(int k = j+1; k < arr.length; k++) {

                	// Checking the sum condition
                    if (arr[i] + arr[j] + arr[k] == given_sum) {
                        arrOfThreeNum[0] = arr[i];
                        arrOfThreeNum[1] = arr[j];
                        arrOfThreeNum[2] = arr[k];

                        // Adding those numbers to the array list in form of an array
                        numbers.add(index, arrOfThreeNum);
                    }
                }
            }
        }
    }

    // Method for printing the obtained three no present in ArrayList in form of Arrays
    public void printSetOfThreeNumbers(ArrayList<int[]> numbers) {

        if(numbers.size() == 0) {
            System.out.println("There isn't any set of 3 numbers matching the criteria");
        }
        for(int i = 0; i < numbers.size(); i++) {
            for(int j = 0; j < numbers.get(i).length; j++) {
                System.out.print(" " + numbers.get(i)[j]);
            }
            System.out.println("");
        }
    }
}
