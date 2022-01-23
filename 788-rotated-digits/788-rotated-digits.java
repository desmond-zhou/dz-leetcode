class Solution {
public int rotatedDigits(int n) {
	
	int dp[] = new int[n+1];
    if(n<=1){
        return 0;
    }else if(n<=4){
        return 1;
    }else if(n<=5){
        return 2;
    }else if(n<=8){
        return 3;
    }else if(n<=10){
        return 4;
    }
    
    for(int i = 0 ; i<10; i++){
        if(i == 2 || i == 5 || i == 6 || i == 9){
            dp[i] = 1;
        }else if(i==0 || i == 1 || i==8){
            dp[i] = 2;                
        }
    }
    
    for(int i = 10 ; i<n+1; i++){
        int up = i%10;
        int rod = i /10;
        
        if(dp[up] == 0 || dp[rod] == 0){
            dp[i] = 0;
        }else if( (dp[up] == 1 && (dp[rod] == 1 || dp[rod] == 2)) || (dp[rod] ==1 && (dp[rod] == 2 || dp[rod] == 1)) ) {
            dp[i] = 1;
        }else if( (dp[up] == 2 && dp[rod] == 2) || (dp[rod]==2 && dp[up] ==2)){
            dp[i] = 2;
        }
    }
    
    int count = 0;
    for(int i =2; i< n+1; i++){
        if(dp[i] == 1) count++;
    }
    
    return count;
}
}