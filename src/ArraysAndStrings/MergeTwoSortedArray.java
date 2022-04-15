package ArraysAndStrings;

public class MergeTwoSortedArray {
    public static void main(String[] args){
        int[] nums1 = {4,6,9,10};
        int[] nums2 = {1,2,4,6,8};

        int[] result = mergeArray(nums1, nums2);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
    public static int[] mergeArray(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length+nums2.length];
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0, k = 0;

        while(i < len1 && j < len2){
            if(nums1[i] <= nums2[j]){
                result[k++] = nums1[i];
                i++;
            }
            else{
                result[k++] = nums2[j];
                j++;
            }
        }
        while(i < len1)
            result[k++] = nums1[i++];
        while (j < len2)
            result[k++] = nums2[j++];
        return result;
    }
}
