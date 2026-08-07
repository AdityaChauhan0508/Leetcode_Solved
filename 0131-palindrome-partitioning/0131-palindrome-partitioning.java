class Solution {

    boolean isPalin(String s) {
        StringBuilder s2 = new StringBuilder(s);
        s2.reverse();

        return s.equals(s2.toString());
    }

    void getAllParts(String s, ArrayList<String> partitions, List<List<String>> ans) {

        if(s.length() == 0) {
            ans.add(new ArrayList<>(partitions));
            return;
        }

        for(int i=0; i<s.length(); i++) {

            String part = s.substring(0, i+1);

            if(isPalin(part)) {
                partitions.add(part);

                getAllParts(s.substring(i+1), partitions, ans);

                partitions.remove(partitions.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> partitions = new ArrayList<>();

        getAllParts(s, partitions, ans);

        return ans;
    }
}