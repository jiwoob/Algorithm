class Solution {
 
    
    public long solution(int w, int h) {
        long x = GCD(w, h);
        
        return ((long) w * h) - (((w / x) + (h / x) - 1) * x);
        
    }
    
    //최대공약수 구하기
    public static int GCD(int x, int y){
        if(y == 0){
            return x;
        }else{
            return GCD(y, x%y);
        }
    }
}