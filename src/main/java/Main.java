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

		// logic for movement left FIRST, when highest number index is in the middle
		// EX:
		// Input: nums = [-2,1,10,-1,-2]
		// Output: 11
		int[] middleMoveLeftFirst = new int[]{-2, 1, 10, -1, -2};
		System.out.println("highest number in middle, moving left first. should return 11: " + maxSubArray(middleMoveLeftFirst));

		int[] middleMoveRightFirst = new int[]{-2, -1, 10, 1, -2};
		System.out.println("highest number in middle, moving right first. should return 11: " + maxSubArray(middleMoveRightFirst));


		// failed example on leet code
		int[] failedExample = new int[]{-2, 1,-3,4,-1,2,1,-5,4};
		System.out.println("Two or More of same highest number. should return 6: " + maxSubArray(failedExample));
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
		else if(highestNumberIndex != 0 && highestNumberIndex != nums.length -1){
			 return highestNumberInMiddle (nums, highestNumberIndex);
		 }



		// code should never make it this far, but if it does return 0
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

	// scenario 3
	// The largest number is NOT farthest left or Farthest right. Somewhere in the middle
	// EX:
	// Input: nums = [-2,1,10,1,-2]
	// Output: 12
	 public static int highestNumberInMiddle(int[] nums, int index){
		 // variables
		 int highestSum = nums[index];
		 int finalResult = 0;
		 int moveLeftFirstResult = 0;
		 int moveRightFirstResult = 0;
		 int moveOnlyLeftwardResult = 0;
		 int moveOnlyRightwardResult = 0;

		 // There are two scenarios,
		 // you move the index to the left FIRST and the right SECOND and work your way outwards
		 moveLeftFirstResult = moveLeftFirst(nums, index);

		 // you move the index to the right FIRST and the left SECOND and work your way outwards
		 moveRightFirstResult = moveRightFirst(nums, index);

		 // from the index, just move left until the beginning
		 moveOnlyLeftwardResult = fromMiddleMoveAllTheWayleft(nums, index);

		 // from the index, just move right until the end
		 moveOnlyRightwardResult = fromMiddleMoveAllTheWayRight(nums, index);

		 // add all result to array
		 int[] allResults = new int[]{moveLeftFirstResult, moveRightFirstResult, moveOnlyLeftwardResult, moveOnlyRightwardResult};

		 // iterate through all results, find the highest
		finalResult = moveLeftFirstResult;
		for(int i = 0; i<allResults.length; i++){
			// if current index is higher then "final result" , update
			if(allResults[i] > finalResult){
				finalResult = allResults[i];
			}
		}
		return finalResult;

	 }


	// logic for movement left FIRST, when highest number index is in the middle
	// EX:
	// Input: nums = [-2,1,10,-1,-2]
	// Output: 11
	public static int moveLeftFirst(int[] nums, int index){
		//                            2     -1
		int availableMovesLeftward = index - 1;
		//                                 4           - 2
		int availableMovesRightward = (nums.length -1) - index;

		// result should nums[index]
		int result = nums[index];
		// set the highest sum to the highest number found in the array at the parameter index
		int highestSum = nums[index];
		// set flag to true to begin the while loop
		boolean flag = true;

		int leftMoveCounter = 1;
		int rightMoveCounter =1;

		while(flag) {
			// left movement first
			// you still need the if statement because its possible to run out of left movement
			// but still have right movement available

			if ( (index - leftMoveCounter) >= 0){
				// the nums index should be index - movecounter
				result = nums[index - leftMoveCounter] + result;

				// if result is greater than highestSum, update highestSum
				if (result > highestSum) {
					highestSum = result;
				}

				// increment leftMoveCounter
				leftMoveCounter++;
			}

			// right movement second
			// you still need the if statement because its possible to run out of right movement
			// but still have left movement available
			if ( (index + rightMoveCounter) < nums.length){

				// the nums index should be index - movecounter
				result = nums[index + rightMoveCounter] + result;

				// if result is greater than highestSum, update highestSum
				if (result > highestSum) {
					highestSum = result;
				}

				// increment rightMoveCounter
				rightMoveCounter++;
			}

			// update flag for next run of while loop
			// use OR because its possible the highest index is not exactly in middle
			// we may have more left or more right movements
			flag = ( (index - leftMoveCounter) >= 0) || ( (index + rightMoveCounter) < nums.length);
		}

			// after the while loop completes
			// return the highest sum for left movement first
			return highestSum;
	}

	// logic for movement right FIRST, when highest number index is in the middle
	// EX:
	// Input: nums = [-2,-1,10,1,-2]
	// Output: 11
	public static int moveRightFirst(int[] nums, int index){
		//                            2     -1
		int availableMovesLeftward = index - 1;
		//                                 4           - 2
		int availableMovesRightward = (nums.length -1) - index;

		// result should nums[index]
		int result = nums[index];
		// set the highest sum to the highest number found in the array at the parameter index
		int highestSum = nums[index];
		// set flag to true to begin the while loop
		boolean flag = true;

		int leftMoveCounter = 1;
		int rightMoveCounter =1;

		while(flag) {


			// right movement first
			// you still need the if statement because its possible to run out of right movement
			// but still have left movement available
			if ( (index + rightMoveCounter) < nums.length){

				// the nums index should be index - movecounter
				result = nums[index + rightMoveCounter] + result;

				// if result is greater than highestSum, update highestSum
				if (result > highestSum) {
					highestSum = result;
				}

				// increment rightMoveCounter
				rightMoveCounter++;
			}

			// left movement second
			// you still need the if statement because its possible to run out of left movement
			// but still have right movement available

			if ( (index - leftMoveCounter) >= 0){
				// the nums index should be index - movecounter
				result = nums[index - leftMoveCounter] + result;

				// if result is greater than highestSum, update highestSum
				if (result > highestSum) {
					highestSum = result;
				}

				// increment leftMoveCounter
				leftMoveCounter++;
			}

			// update flag for next run of while loop
			// use OR because its possible the highest index is not exactly in middle
			// we may have more left or more right movements
			flag = ( (index - leftMoveCounter) >= 0) || ( (index + rightMoveCounter) < nums.length);
		}

		// after the while loop completes
		// return the highest sum for left movement first
		return highestSum;

	}

	// {-2, 1,-3,4,-1,2,1,-5,4}
	public static int fromMiddleMoveAllTheWayleft(int[] nums, int index){
		// result should nums[index]
		int result = nums[index];
		// set the highest sum to the highest number found in the array at the parameter index
		int highestSum = nums[index];

		int leftMoveCounter = 1;

		while((index - leftMoveCounter) >=0 ){
			// the nums index should be index - movecounter
			result = nums[index - leftMoveCounter] + result;

			// if result is greater than highestSum, update highestSum
			if (result > highestSum) {
				highestSum = result;
			}

			// increment leftMoveCounter
			leftMoveCounter++;
		}

		// after the while loop completes
		// return the highest sum for left movement first
		return highestSum;
	}

	// {-2, 1,-3,4,-1,2,1,-5,4}
	public static int fromMiddleMoveAllTheWayRight(int[] nums, int index){

		// result should nums[index]
		int result = nums[index];
		// set the highest sum to the highest number found in the array at the parameter index
		int highestSum = nums[index];

		int rightMoveCounter = 1;

		while((index + rightMoveCounter) < nums.length ){
			// the nums index should be index - movecounter
			result = nums[index + rightMoveCounter] + result;

			// if result is greater than highestSum, update highestSum
			if (result > highestSum) {
				highestSum = result;
			}

			// increment rightMoveCounter
			rightMoveCounter++;
		}

		// after the while loop completes
		// return the highest sum for left movement first
		return highestSum;
	}
}
