class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a,b) -> {
            if(a[0] != b[0]) {
                return b[0] - a[0];
            } else{
                return a[1] - b[1];
            }
        });

        List<int[]> orderedList = new ArrayList<>();
        for(int[] person : people) {
            orderedList.add(person[1], person);
        }

        return orderedList.toArray(new int[people.length][]);
        
    }
}