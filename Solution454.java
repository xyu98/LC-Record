import java.util.HashMap;
import java.util.Map;

public class Solution454 {
}

class Solution454_1 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        // 先用一个二重循环，列举出A+B的所有情况sumAB，并将每种A[i]+B[j]出现的次数作为value
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                int sumAB = A[i] + B[j];
                if (map.containsKey(sumAB)) map.put(sumAB,map.get(sumAB)+1);
                else map.put(sumAB,1);
            }
        }

        // 再用一个二重循环，列举出-(C+D)的所有情况，在hashmap中查找是否存在key为sumCD. 若存在的话，
        // 就会存在value种情况使得A[]+B[]+C[]+D[] = 0
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < D.length; j++){
                int sumCD = -(C[i] + D[j]);
                if (map.containsKey(sumCD)) res += map.get(sumCD);
            }
        }
        return res;
    }
}