package leetcode;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())
        {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean result[][] = new boolean[m+1][n+1];
        result[0][0] = true;
        for(int i=1;i<=n;i++)
        {
            result[0][i] = s2.charAt(i-1) == s3.charAt(i-1) ? result[0][i-1] : false;
        }
        for(int i=1;i<=m;i++)
        {
            result[i][0] = s1.charAt(i-1) == s3.charAt(i-1) ? result[i-1][0] : false;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                result[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && result[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && result[i][j-1]);
            }
        }
        return result[m][n];
    }  
}
