class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        List<Integer> div = new ArrayList<>();

        for(int i=1; i*i<=n; i++) {
            if (n%i == 0) {
                div.add(i);
                if(i*i != n) div.add(n/i);
            }
        }

        int totalSum = 0;
        for(int k : div) {
            if (isSortable(nums, n, k)) {
                totalSum += k;
            }
        }
        return totalSum;
    }

    private boolean isSortable(int[] nums, int n, int k) {
        int prevMax = Integer.MIN_VALUE;

        for(int i=0; i<n; i+=k) {
            int drops = 0;
            int dropIdx = -1;

            for(int j=i; j<i+k-1; j++) {
            
                if( nums[j] > nums[j+1]) {
                    drops++;
                    dropIdx = j+1;
                }
            }
            if(drops > 1) return false;
            if(drops == 1 && nums[i+k-1] > nums[i]) return false;

            int currentMin, currentMax;
            if(drops == 0) {
                currentMin = nums[i];
                currentMax = nums[i+k-1];
            } else {
                currentMin = nums[dropIdx];
                currentMax = nums[dropIdx-1];
            }

            if(currentMin < prevMax) return false;
            prevMax = currentMax;
        }
        return true;
    }
}