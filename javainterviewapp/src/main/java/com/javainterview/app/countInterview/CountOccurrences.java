package com.javainterview.app.countInterview;

import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;

/**
 * Given an array of Integers, determine if there exists
 * at least x occurrences of a number.
 * T: O(n)
 * S: O(n)
 *
 * Assume proper values for count such as greater than 1.
 */
public class CountOccurrences {

    public boolean hasNOccurrences(int[] array, int count) {
        int length = array.length;

        if (length < count) {
            return false;
        }

        Map<Integer, Integer> countTracker = new HashMap<Integer, Integer>();
        for (int num : array) {
            if (countTracker.containsKey(num)) {
                int val = countTracker.get(num) + 1;
                if (val >= count) {
                    return true;
                } else {
                    countTracker.put(num, val);
                }
            } else {
                countTracker.put(num, 1);
            }
        }
        return false;
    }


    /**
     * This is a modification of the above problem.
     * Instead of asking if there are existence of numbers.
     *
     * We want an incrementing consecutive array.
     * [1,2,3] is of size 3
     */
    public boolean hasNConsecutive(int[] array, int count) {
        // base case where array is of size 1
        if (array.length == 1) {
            if (count ==1) {
                return true;
            } else {
                return false;
            }
        }

        int tempCount = 1;
        int leftVal = array[0];
        for (int i=1; i<array.length; i++) {
            // check if the index val is 1 greater
            if (array[i] - leftVal == 1) {
                tempCount++;
                if (tempCount == count) {
                    return true;
                }
            } else {
                // not consecutive so reset the count
                tempCount = 1;
            }
            // update the leftVal
            leftVal = array[i];
        }

        return false;
    }
}

