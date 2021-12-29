public class Main {
	public static void main(String[] args){

	}
	public static int maxSubArray(int[] nums) {


		// edge case 1
		// if there is only 1 number in nums
		// return nums[0]


		// boolean allNumbersPositive = true;
		// boolean allNumbersNegative = true;
		// int highestNumberIndex = 0;


		// for loop to iterate through all the numbers
		// if  allNumbersPositive is true  - call allNumbersPositive(int[] nums){}
		// else if  allNumbersNegative is true  - call allNumbersNegative(int[] nums){}
		// else if highestNumberIndex = 0  - call highestNumberOnLeft(int[] nums){}
		// else if highestNumberIndex = nums.length -1  - call highestNumberOnright(int[] nums){}
		// else the highestNumberIsSomewhereInTheMiddle - call

		// edge case 2
		// There are no negative numbers - return the sum of all numbers
		// EX:
		// Input: nums = [1, 2, 3]
		// Output: 6
		// create public static int allNumbersPositive(int[] nums){}
		// return result


		//edge case 3
		// All the numbers are negative - return the smallest number negative number
		// EX:
		// Input: nums = [-1, -2, -3, -4, -5]
		// Output: -1
		// create public static int allNumbersNegative(int[] nums){}
		// return result



		// --- Anything below this point are arrays that include a mixture of negative and positive numbers ---

		// we will need an int variable to keep track of the highestSum
		// int highestSum

		// We will need an int variable to keep track of the result (highest sum + element and index), to be compared to highestSum
		// int result

		// we need to find the index of the largest number in num
		// int largestNumberIndex
		// set the largest number to "highestSum" variable



		// scenario 1
		// The largest number is the farthest left number of the contiguous array
		// EX:
		//Input: nums = [9, 1, 2, -3 ]
		//Output: 12
		// create public static int highestNumberOnLeft(int[] nums){}
		// int highestSum = 0;
		// int result = 0;
		// iterate through array, starting at index 0
		// result = highestsum + element
		// then compare result to highestSum
		// if result is greater than highestSum, update. highestSum = result
		// lastly return highestSum


		// scenario 2
		// The largest number is the farthest right number of the contiguous array
		// EX:
		// Input: nums = [-1,-2,-3,4,5]
		// Output: 9
		// create public static int highestNumberOnRight(int[] nums){}
		// int highestSum = 0;
		// int result = 0;
		// iterate through array, starting at index nums.length -1
		// result = highestsum + element
		// then compare result to highestSum
		// if result is greater than highestSum, update. highestSum = result
		// lastly return highestSum


		// scenario 3
		// The largest number is NOT farthest left or Farthest right. Somewhere in the middle
		// EX:
		// Input: nums = [-2,1,10,1,-2]
		// Output: 12
		// create public static int highestNumberInMiddle(int[] nums, index){}

		// There are two scenarios,
		// you move the index to the left FIRST and the right SECOND and work your way outwards
		// you move the index to the right FIRST and the left SECOND and work your way outwards


		// variables
		// highestSum = nums[index];
		// int result = nums[index];


		// public static int moveLeftFirst(){}
		// logic for movement left FIRST
		// we know what index has the highest number
		// int availableMovesLEFTWARD = index - 1
		// availableMovesRIGHTWARD = (nums.length -1) - index

		// if availableMovesLEFTWARD >= zero
		// result = nums[availableMovesLEFTWARD] + result;
		// if result > highestSum,  update. highestSum = result;
		// decrement availableMovesLEFTWARD--

		// if availableMovesRIGHTWARD < nums.length
		// result = nums[availableMovesRightward] + result;
		// if result > highestSum,  update. highestSum = result;
		// increment availableMovesRightWARD++


		// public static int moveRightFirst(){}
		// logic for movement right FIRST
		// variables
		// highestSum = nums[index];
		// int result = nums[index];

		// if availableMovesRIGHTWARD < nums.length
		// result = nums[availableMovesRightward] + result;
		// if result > highestSum,  update. highestSum = result;
		// increment availableMovesRightWARD++

		// if availableMovesLEFTWARD >= zero
		// result = nums[availableMovesLEFTWARD] + result;
		// if result > highestSum,  update. highestSum = result;
		// decrement availableMovesLEFTWARD--


		return 0;
	}
}
