class Solution {
    // Calculate the sum of digits recursively
    private int sumofdigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumofdigits(n / 10);
    }

    public int minSwaps(int[] nums1) {
        // Create a copy to get the required sorted order
        int[] nums2 = nums1.clone();

        // Convert to Integer[] to use a custom comparator
        Integer[] arr = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            arr[i] = nums2[i];
        }

        // Sort by digit sum, then by numeric value
        Arrays.sort(arr, (a, b) -> {
            int x = sumofdigits(a);
            int y = sumofdigits(b);

            if (x == y) return Integer.compare(a, b);
            return Integer.compare(x, y);
        });

        // Store each number's target index
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], i);
        }

        int ans = 0;
        int i = 0;

        // Place each number at its correct index
        while (i < nums1.length) {
            if (mp.get(nums1[i]) == i) {
                // Number is already at its target index
                i++;
            } else {
                // Swap the number with the element at its target index
                ans++;
                int j = mp.get(nums1[i]);

                int temp = nums1[i];
                nums1[i] = nums1[j];
                nums1[j] = temp;
            }
        }

        return ans;
    }
}