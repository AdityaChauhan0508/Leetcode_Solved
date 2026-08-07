import java.util.*;

class Solution {

    HashSet<List<Integer>> s = new HashSet<>();

    void getAllCombinations(int[] arr, int idx, int tar,
                            List<List<Integer>> ans,
                            ArrayList<Integer> combin) {

        if (idx == arr.length || tar < 0) {
            return;
        }

        if (tar == 0) {
            if (!s.contains(combin)) {
                ans.add(new ArrayList<>(combin));
                s.add(new ArrayList<>(combin));
            }
            return;
        }

        combin.add(arr[idx]);

        // single
        getAllCombinations(arr, idx + 1, tar - arr[idx], ans, combin);

        // multiple
        getAllCombinations(arr, idx, tar - arr[idx], ans, combin);

        combin.remove(combin.size() - 1);

        // exclusion
        getAllCombinations(arr, idx + 1, tar, ans, combin);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> combin = new ArrayList<>();

        getAllCombinations(candidates, 0, target, ans, combin);

        return ans;
    }
}