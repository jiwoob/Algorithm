function isPrime(n) {  // 소수 판별 함수
    if(n<=1){ //0,1은 소수가 아님.
        return false;
    }
    for(let i = 2; i <= Math.sqrt(n); i++){
        if(n % i === 0){  //소수가 아니다.
            return false;
        }
    }
    return true;  
}

function solution(nums) {
    let answer = 0;
    const n = nums.length;
    //숫자 3개의 조합.
    
    for(let i = 0; i < n; i++){
        for(let j = i+1; j < n; j++){
            for(let k = j+1; k < n; k++){
                let sum = nums[i] + nums[j] + nums[k];
                //console.log(sum);
                if(isPrime(sum)){
                  //  console.log(sum);
                    answer++;
                }
                
            }
        }
    }
    
    return answer;
}
