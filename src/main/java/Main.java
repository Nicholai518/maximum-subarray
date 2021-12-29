public class Main {
	public static void main(String[] args){

		// test only one number
		int[] onlyOneNumber = new int[]{1};
		System.out.println("Only one number. Should return 1 : " + maxSubArray(onlyOneNumber));

		// test all positive numbers
		int[] allPositiveNumbers = new int[]{1, 2, 3};
		System.out.println("all positive numbers. Should return 6 : " + maxSubArray(allPositiveNumbers));

		// test all positive numbers
		int[] allNegativeNumbers = new int[]{-1, -2, -3};
		System.out.println("all negative numbers. Should return -1 : " + maxSubArray(allNegativeNumbers));

		// test highest number on left. array includes positive and negative numbers
		int[] highestNumberOnLeftArray = new int[]{10, 1, -1};
		System.out.println("highest number on left. array contains positive and negative. Should return 11: " + maxSubArray(highestNumberOnLeftArray));

		// test highest number on left. array includes positive and negative numbers
		int[] highestNumberOnRightArray = new int[]{-1, 1, 10};
		System.out.println("highest number on right. array contains positive and negative. Should return 11: " + maxSubArray(highestNumberOnRightArray));

	}
	public static int maxSubArray(int[] nums) {

		// edge case 1
		// if there is only 1 number in nums
		// return nums[0]
		if(nums.length == 1){
			return nums[0];
		}


		 boolean allNumbersPositive = true;
		 boolean allNumbersNegative = true;
		 int highestNumberIndex = 0;


		// for loop to iterate through all the numbers
		for(int i = 0; i<nums.length; i++){
			// there is a negative number, set allNumbersPositive to false
			if(nums[i] < 0){
				allNumbersPositive = false;
			}
			// if there is a positive number, set allNumbersNegative to false
			else if(nums[i] >= 0){
				allNumbersNegative = false;
			}

			// update the highestNumberIndex if necessary
			// if they are the same number, do not update
			if(nums[i] > nums[highestNumberIndex]){
				highestNumberIndex = i;
			}
		}

		// now that we have iterated through nums, check the flags
		// There are NO negative numbers, add them up and return the sum
		 if (allNumbersPositive){
			 return allNumbersPositive(nums);
		 }
		 // ALL numbers are negative, find the least negative number and return it
		 else if  (allNumbersNegative){
			 return allNumbersNegative(nums);
		 }

		 // if both flags are false, we have a mixture of numbers
		 // lets check if the highest index is 0, nums.length-1, or in the middle
		// index = 0, the highest number is all the way on the left
		 if (highestNumberIndex == 0){
			 return highestNumberOnLeft(nums);
		 }
		// index = nums.length -1 , the highest number is all the way on the right
		 else if (highestNumberIndex == nums.length -1){
			 return highestNumberOnRight(nums);
		 }
		// else the highestNumberIsSomewhereInTheMiddle - call





		// --- Anything below this point are arrays that include a mixture of negative and positive numbers ---

		// we will need an int variable to keep track of the highestSum
		// int highestSum

		// We will need an int variable to keep track of the result (highest sum + element and index), to be compared to highestSum
		// int result

		// we need to find the index of the largest number in num
		// int largestNumberIndex
		// set the largest number to "highestSum" variable









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

	 public static int allNumbersPositive(int[] nums){
		int sum = 0;
		for(int i = 0; i<nums.length; i++){
			sum += nums[i];
		}
		return sum;
	 }

	public static int allNumbersNegative(int[] nums){
		int leastNegativeNumber = nums[0];

		for(int i = 0; i<nums.length; i++){
			if(nums[i] > leastNegativeNumber){
				leastNegativeNumber = nums[i];
			}
		}
		return leastNegativeNumber;
	}


	// scenario 1
	// The largest number is the farthest left number of the contiguous array
	// EX:
	//Input: nums = [9, 1, 2, -3 ]
	//Output: 12

	public static int highestNumberOnLeft(int[] nums){
		int highestSum = nums[0];
		int result = 0;

		// iterate through array, starting at index 0
		for(int i=0; i<nums.length; i++){
			result = result + nums[i];

			// then compare result to highestSum
			if (result > highestSum){
				highestSum = result;
			}
		}
		// lastly return highestSum
		return highestSum;
	}


	// scenario 2
	// The largest number is the farthest right number of the contiguous array
	// EX:
	// Input: nums = [-1,-2,-3,4,5]
	// Output: 9

	public static int highestNumberOnRight(int[] nums){
		int highestSum = nums[nums.length - 1];
		int result = 0;

		// iterate through array, starting at index nums.length -1
		for(int i = nums.length -1; i >= 0; i--){
			result = result + nums[i];

			// then compare result to highestSum
			if (result > highestSum){
				highestSum = result;
			}
		}

		// lastly return highestSum
		return highestSum;
	}

	// create public static int highestNumberInMiddle(int[] nums, index){}

	// public static int moveLeftFirst(){}

	// public static int moveRightFirst(){}
}
