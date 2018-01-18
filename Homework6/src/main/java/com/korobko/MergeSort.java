package com.korobko;

import java.util.Arrays;

/**
 * Merge Sort:
 * - Google => Merge Sort, how it works.
 * - Google => Merge Sort, how it works.
 * - and maybe again… you should understand very clear how it works
 * for your future practice.
 * - for now it should works with basic cases. Any unsorted arrays
 * will be good.
 * <p>
 * Note: your implementations should perform all actions in-place.
 * It means you don’t need to create additional objects for storing
 * information or using Java readymade APIs.
 *
 * @author Vova Korobko
 */
public class MergeSort {

    private static void wmerge(int[] xs, int i, int m, int j, int n, int w) {
        while (i < m && j < n)
            swap(xs, w++, xs[i] < xs[j] ? i++ : j++);
        while (i < m)
            swap(xs, w++, i++);
        while (j < n)
            swap(xs, w++, j++);
    }
    private static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }
    /*
     * sort xs[l, u), and put result to working area w.
     * constraint, len(w) == u - l
     */
    private static void wsort(int[] xs, int l, int u, int w) {
        int m;
        if (u - l > 1) {
            m = l + (u - l) / 2;
            imsort(xs, l, m);
            imsort(xs, m, u);
            wmerge(xs, l, m, m, u, w);
        }
        else
            while (l < u)
                swap(xs, l++, w++);
    }

    public static void imsort(int[] array) {
        imsort(array, 0, array.length);
    }

    private static void imsort(int[] xs, int l, int u) {
        int m, n, w;
        if (u - l > 1) {
            m = l + (u - l) / 2;
            w = l + u - m;
            wsort(xs, l, m, w); /* the last half contains sorted elements */
            while (w - l > 2) {
                n = w;
                w = l + (n - l + 1) / 2;
                wsort(xs, w, n, l);  /* the first half of the previous working area contains sorted elements */
                wmerge(xs, l, l + n - w, n, u, w);
            }
            for (n = w; n > l; --n) /*switch to insertion sort*/
                for (m = n; m < u && xs[m] < xs[m-1]; ++m)
                    swap(xs, m, m - 1);
        }
    }

    private static void sort(int array[], int firstIndex, int lastIndex) {

        if (firstIndex >= lastIndex) {
            return;
        }
        int mid = (firstIndex + lastIndex) / 2;

        /*Partition the list into two lists and sort them recursively */
        sort(array, firstIndex, mid);
        sort(array, mid + 1, lastIndex);

        /* * Merge the two sorted lists */
        int end_lo = mid;
        int start_hi = mid + 1;
        while ((firstIndex <= end_lo) && (start_hi <= lastIndex)) {

            if (array[firstIndex] < array[start_hi]) {
                firstIndex++;
            } else {
                /* a[lo] >= a[start_hi]
                 * The next element comes from the second list,
                 * move the a[start_hi] element into the next
                 * position and shuffle all the other elements up.
                 */
                int t = array[start_hi];
                for (int k = start_hi - 1; k >= firstIndex; k--) {
                    array[k + 1] = array[k];

                }
                array[firstIndex] = t;
                firstIndex++;
                end_lo++;
                start_hi++;
            }
        }
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    // textbook merge
    public static void mergeSort(int[] inputArray) {
        int size = inputArray.length;
        if (size < 2)
            return;
        int mid = size / 2;
        int[] left = Arrays.copyOfRange(inputArray, 0, mid);
        int[] right = Arrays.copyOfRange(inputArray, mid, inputArray.length);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, inputArray);
    }

    // textbook merge
    private static void merge(int[] left, int[] right, int[] array) {
        int leftSize = left.length;
        int rightSize = right.length;
        int leftStart = 0, rightStart = 0, arrayIndex = 0;
        while (leftStart < leftSize && rightStart < rightSize) {
            if (left[leftStart] <= right[rightStart]) {
                array[arrayIndex++] = left[leftStart++];
            } else {
                array[arrayIndex++] = right[rightStart++];
            }
        }
        while (leftStart < leftSize) {
            array[arrayIndex++] = left[leftStart++];
        }
        while (rightStart < rightSize) {
            array[arrayIndex++] = right[rightStart++];
        }
    }
}
