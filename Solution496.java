public class Solution496 {
    public static void main(String[] args) {
        Solution496_1 s = new Solution496_1();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        for (int x: s.nextGreaterElement(nums1, nums2)) {
            System.out.println(x);
        }
    }
}

class Solution496_1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            result[index] = nums2[k];
                            break;
                        }
                        result[index] = -1;
                    }
                }
            }
        }
        return result;
    }
}