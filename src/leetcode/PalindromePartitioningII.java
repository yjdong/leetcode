package leetcode;

import java.util.Arrays;

public class PalindromePartitioningII {
    public int minCut(String s) {
        if(s == null || s.length()<2)
        {
            return 0;
        }
        int[] result = new int[s.length()+1];
        
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = -1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=1;i<=s.length();i++)
        {
            for(int j=i;j>=1;j--)
            {
                if(j==i || (i-j == 1 && s.charAt(i-1) == s.charAt(j-1) ) || (s.charAt(j-1) == s.charAt(i-1) && dp[j][i-2]))
                {
                    dp[j-1][i-1] = true;
                    result[i] = Math.min(result[j-1]+1, result[i]);
                }
            }
        }
        return result[result.length-1];
    }
}
