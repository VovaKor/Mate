package com.korobko;


import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple BinarySearch.
 */
public class BinarySearchTest {
    private int[] intArray = new int[] {5, 6, 9, 10, 15, 1, 3, 4};
    private int[] arrayWithDuplicates = new int[] {5, 5, 1, 7, 7, 6, 6, 2, 2};

    @Test
    public void find_arrayWithDuplicates_MidElementIndex() {
        Assert.assertEquals(3, BinarySearch.find(7, arrayWithDuplicates));
    }
    @Test
    public void find_arrayWithDuplicates_LastElementIndex() {
        Assert.assertEquals(7, BinarySearch.find(2, arrayWithDuplicates));
    }
    @Test
    public void find_arrayWithDuplicates_ZeroElementIndex() {
        Assert.assertEquals(0, BinarySearch.find(5, arrayWithDuplicates));
    }
    @Test
    public void find_arrayWithDuplicatesLowMidElement_success() {
        Assert.assertEquals(2, BinarySearch.find(1, arrayWithDuplicates));
    }
    @Test
    public void find_arrayWithDuplicatesHighMidElement_success() {
        Assert.assertEquals(5, BinarySearch.find(6, arrayWithDuplicates));
    }
    @Test
    public void find_circularSortedArrayHighMidElement_success() {
        Assert.assertEquals(6, BinarySearch.find(3, intArray));
    }

    @Test
    public void find_circularSortedArrayLowMidElement_success() {
        Assert.assertEquals(2, BinarySearch.find(9, intArray));
    }

    @Test
    public void find_circularSortedArrayMidElement_success() {
        Assert.assertEquals(4, BinarySearch.find(15, intArray));
    }
    @Test
    public void find_circularSortedArrayZeroElement_success() {
        Assert.assertEquals(0, BinarySearch.find(5, intArray));
    }
    @Test
    public void find_circularSortedArrayLastElement_success() {
        Assert.assertEquals(7, BinarySearch.find(4, intArray));
    }
}
