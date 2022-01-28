import java.util.ArrayList;

public class MyMain {
    // **************************
    // In-class Practice Problems
    // **************************

    // Write a method that uses recursion to search for a value in
    // an array using binary search!

    // Examples:
    // binarySearch([5, 2, 4, 3], 4) => true
    // binarySearch([6, 7, 1, 2, 8], 5) => false

    // Wrapper Method
    public static boolean binarySearch(int[] arr, int num) {
        return binarySearchTR(arr, num, 0, arr.length-1);
    }

    // Tail recursive method:
    public static boolean binarySearchTR(int[] arr, int num, int lowerBound, int upperBound) {
        int middle = lowerBound + (upperBound-lowerBound)/2;
        if(upperBound < middle){
            return false;
        }
        //now search left
        else if(arr[middle]>num){
            return binarySearchTR(arr, num, lowerBound, upperBound-1);
        }
        //now search right
        else if (arr[middle]<num){
            return binarySearchTR(arr, num, middle+1, upperBound);
        }
        else{
            return true;
        }
    }





    // ********************
    // Methods for homework:
    // ********************

    // This method does not use recursion!

    // Write a method takes two sorted arrays as input and combines them
    // into one large combined arrays.

    // Here is the pseudocode for merge:
    // * Create a new big output array
    // * Start at the beginning of both input arrays
    // * Take the smaller of the two values and add it to the output array
    // * Repeat until we’ve gone through all the values in one of the arrays
    // * Copy the remaining values from the other array into the output array

    // Here's an example of how it looks in action:
    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [                         ]
    //         ^                         ^                           ^
    //     idx1 = 0                  idx2 = 0                   outputIdx = 0

    // The current value in arr1 (1) is smaller than the current value
    // in arr2 (2). So we copy 1 into the output array. Then we increment
    // both idx1 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1,                       ]
    //            ^                      ^                              ^
    //        idx1 = 1               idx2 = 0                      outputIdx = 1

    // The current value in arr1 (4) is larger than the current value
    // in arr2 (2). So we copy 2 into the output array. Then we increment
    // both idx2 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1, 2,                     ]
    //            ^                         ^                              ^
    //        idx1 = 1                  idx2 = 1                      outputIdx = 2

    // We continue on until one of the arrays is empty
    // Then we need to copy the rest of the array

    public static int[] merge(int[] arr1, int[] arr2) {
        // YOUR CODE HERE

        int[] merged = new int[(arr1.length + arr2.length)];
        int arr1Index = 0;
        int arr2Index = 0;
        int mergedIndex = 0;
        while (arr1Index < arr1.length && arr2Index<arr2.length) {
            if (arr1[arr1Index] < arr2[arr2Index]) {
                merged[mergedIndex] = arr1[arr1Index];
                arr1Index++;
                mergedIndex++;
            } else {
                merged[mergedIndex] = arr2[arr2Index];
                arr2Index++;
                mergedIndex++;
            }
        }
        while (arr1Index< arr1.length){
            merged[mergedIndex]=arr1[arr1Index];
            mergedIndex++;
            arr1Index++;
        }
        while (arr2Index<arr2.length){
            merged[mergedIndex]=arr2[arr2Index];
            mergedIndex++;
            arr2Index++;
        }

        return merged;

    }
}



