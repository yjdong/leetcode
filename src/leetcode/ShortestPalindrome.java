package leetcode;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if(s == null || s.length()<2)
        {
            return s;
        }
        StringBuffer sb = new StringBuffer(s);
        String s2 = s+"#"+sb.reverse().toString();
        int k=0;
        int result[] = new int[2*s.length()+1];
        for(int i=1;i<s2.length();i++)
        {
            while(k>0 && s2.charAt(k) != s2.charAt(i))
            {
                k = result[k-1];
            }
            if(s2.charAt(k) == s2.charAt(i))
            {
                k++;
            }
            result[i] = k;
        }
        int n = result[s2.length()-1];
        StringBuffer sb2 = new StringBuffer(s.substring(n));
        return sb2.reverse().toString()+s;
    }
}