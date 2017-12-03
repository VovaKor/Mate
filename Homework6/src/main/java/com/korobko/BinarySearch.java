package com.korobko;

/**
 * Binary Search:
 * - Google => BinarySearch, how it works.
 * - this case should works correctly:    [5, 6, 9, 10, 15, 1, 3, 4].
 * It means you should modify basic implementation of the BinarySearch.
 * <p>
 * ***WARNING!
 * <p>
 * If you have this kind of case 5,5,1,3,4,5,5,5,5,
 * and your target is 5 result value should be index of first satisfactory
 * value in array. In our array it will be 0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] intArray = new int[] {5, 6, 9, 10, 15, 1, 3, 4};
       // intArray = new int[] {5, 5, 1, 3, 4, 5, 5, 5, 5};

        System.out.println(find(4, intArray));
    }

    public static int find(int searchKey, int[] intArray) {
        int firstElementIndex = 0;
        int arrayLastIndex = intArray.length - 1;
        int lowerBound = firstElementIndex;
        int upperBound = arrayLastIndex;
        int currentIndex;
        while (lowerBound <= upperBound) {
            currentIndex = (lowerBound + upperBound) / 2;
            if (intArray[currentIndex] == searchKey) {

                // checking for duplicates
                if (currentIndex == firstElementIndex
                        && intArray[currentIndex + 1] != searchKey) {
                    return currentIndex;
                } else if (currentIndex == arrayLastIndex
                        && intArray[currentIndex - 1] != searchKey) {
                    return currentIndex;
                }

            }

            // checking for circular sorted array
            if (intArray[currentIndex] <= intArray[upperBound]) {
                if (intArray[currentIndex] < searchKey && searchKey <= intArray[upperBound]) {
                    lowerBound = currentIndex + 1;
                } else {
                    upperBound = currentIndex - 1;
                }
            } else {

                if (intArray[currentIndex] > searchKey && searchKey >= intArray[lowerBound]) {
                    upperBound = currentIndex - 1;
                } else {
                    lowerBound = currentIndex + 1;
                }
            }
        }

        // Linear search if array contains duplicates
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == searchKey)
                return i;
        }
        return -1;
    }
}
