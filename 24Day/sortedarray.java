class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        for (int num = 0; num < n - 1; num++) {
            if (arr[num] > arr[num + 1]) {
                return false;
            }
        }
        return true;
    }
}