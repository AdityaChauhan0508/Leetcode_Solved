class Solution {
    public String[] createGrid(int m, int n) {
        String[] arr = new String[m];

        for (int i = 0; i < m - 1; i++) {
            arr[i] = "." + "#".repeat(n - 1);
        }

        arr[m - 1] = ".".repeat(n);

        return arr;
    }
}