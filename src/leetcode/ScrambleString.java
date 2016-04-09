package leetcode;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
        {
            return false;
        }
        int n= s1.length();
        boolean[][][] result = new boolean[n][n][n+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(s1.charAt(i) == s2.charAt(j))
                {
                    result[i][j][1] = true;
                }
            }
        }
        for(int len = 2; len<=n; len++)
        {
            for(int i=0;i+len-1<n;i++)
            {
                for(int j=0;j+len-1<n;j++)
                {
                    for(int k=1;k<len;k++)
                    {
                        result[i][j][len] |= (result[i][j][k] && result[i+k][j+k][len-k]) || (result[i][j+k][len-k] && result[i+len-k][j][k]);  
                    }
                }
            }
        }
        return result[0][0][n];
    }
}
