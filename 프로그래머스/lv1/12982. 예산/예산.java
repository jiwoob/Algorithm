import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int result = 0;
            
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++){
            budget = budget - d[i];
            if(budget >= 0){
                result++;
            }
                
        }
        
        return result;
    }
}