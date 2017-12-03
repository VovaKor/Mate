package com.korobko;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Vova Korobko
 */
public class MergeSortTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void random() {
        int[] arr = {6, 2, 9, 7, 5, 10, 4, 8, 3, 1};
        MergeSort.imsort(arr);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(arr));
    }
    @Test
    public void duplicates() {
        int[] arr = {1, 3, 15, 3, 7, 9, 8, 15, 0};
        MergeSort.imsort(arr);
        assertEquals("[0, 1, 3, 3, 7, 8, 9, 15, 15]", Arrays.toString(arr));

    }

    @Test
    public void reverseInput() {
        int[] arr = {22, 21, 19, 18, 15, 14, 9, 7, 5};
        MergeSort.imsort(arr);
        assertEquals("[5, 7, 9, 14, 15, 18, 19, 21, 22]", Arrays.toString(arr));

    }

    @Test
    public void emptyInput() {
        int[] arr = {};
        MergeSort.imsort(arr);
        assertEquals("[]", Arrays.toString(arr));
    }

    @Test
    public void alreadySorted() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MergeSort.imsort(arr);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(arr));
    }
}