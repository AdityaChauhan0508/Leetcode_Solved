class Solution {

    public static void mergeSort(int[] arr, int si , int ei) {

        if(si >= ei) return; //Base Case

        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid); //Sorting left part
        mergeSort(arr, mid+1, ei); //Sorting right part

        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei) {

        int[] temp = new int[ei - si + 1];

        int i = si;  // Iterator for the left sorted part
        int j = mid+1; //Iterator for the roght sorted part
        int k = 0;  // iterator for the temp array

        while(i <= mid && j <= ei) {

            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid) {  //Left over element in left part
            temp[k++] = arr[i++];
        }
        while(j <= ei) {  //left over element in right part
            temp[k++] = arr[j++];
        }
 
        for(k = 0 , i = si ; k<temp.length; k++,i++) { //copy temp to original array
            arr[i] = temp[k];
        }
    }


    public int[] sortArray(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }
}