package array;


/**
 * 
 * @author younggg
  Given n non-negative integers a1, a2, ..., an , 
  where each represents a point at coordinate (i, ai). 
  n vertical lines are drawn such that 
  the two endpoints of line i is at (i, ai) and (i, 0). 
  Find two lines, which together with x-axis forms a container, 
  such that the container contains the most water.
  
  Note: You may not slant the container and n is at least 2.
  
  Example:

  Input: [1,8,6,2,5,4,8,3,7]
  Output: 49
  
  	左端为L,右端为R,则体积为Math.min(A[L],A[R])*(r-l)

	如果 L < R,向右移动L, 因为此时容器的高度是L,R-L 
	即宽度减小,体积必然减小,所以可以忽略所有其他的当L为左端边界的情况.

	R的移动同理.
 */

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int r = height.length - 1;
		int l = 0;
		int result = 0;
		while(r > l) {
			result = Math.max(result, Math.min(height[l], height[r]) * (r - l));
			if(height[r] > height[l]) {
				l++;
			} else {
				r--;
			}
			
		}
		return result;
        
    }
}
