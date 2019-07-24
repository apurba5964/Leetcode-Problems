package edu.ub.leetcode.DP;

public class BitMagic {
	
	
	
	public int totalHammingDistance(int[] nums) {
        int sum =0;
        int n=nums.length;
        for(int j=0;j<32;j++){
            int c=0;
            
            for(int i=0;i<n;i++){
                c+= nums[i] & 1;
                nums[i] = nums[i] >> 1;
            }
            sum+=c*(nums.length-c);
            
        }
        
        return sum;
    }
	
	
	
	//https://leetcode.com/problems/single-number-ii/
	
	public int singleNumber(int[] nums) {
        
		 int result = 0;
       
       for(int j=0;j<32;j++){
           int sum=0;
           int x = (1 << j);
       
       
       
		 for(int i=0;i<nums.length;i++) {
		 
			if((nums[i] & x) !=0)
               sum++;
            
            
		 }
           
           if(sum % 3 !=0)
               result = result | x;
		 
       }
		 
		return result;
	        
   }

	
//https://leetcode.com/problems/single-number-iii/	
public int[] singleNumber3(int[] nums) {
        
        int result =0;
        
        for(int i=0;i<nums.length;i++){
            result = result ^ nums[i];
            
        }
        
        int y=0,z=0,c=0;
        for(int i=0;i<32;i++){
            int x = (1 << i);
            x = x & result;
             
            if(x!=0 && c==0){
               
            for(int n : nums){
                
                if((n & x) !=0){
                    
                    y = y ^ n ;
                }
                else
                    z= z ^ n;
                
            }
                c++;
            }
                
            
        }
        int[] res = {y,z};
        return res;
    }
}
