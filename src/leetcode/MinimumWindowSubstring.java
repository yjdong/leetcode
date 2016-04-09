package leetcode;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> map =  new HashMap<Character, Integer>();
        for(int i=0;i<T.length();i++)
        {
            if(map.containsKey(T.charAt(i)))
            {
                map.put(T.charAt(i), map.get(T.charAt(i))+1);
            }
            else
            {
                map.put(T.charAt(i), 1);
            }
        }
        int left = 0;
        int count = 0;
        int result = S.length()+1;
        int start = -1;
        int end = -1;
        int right = 0;
        for(;right<S.length();right++)
        {
            if(map.containsKey(S.charAt(right)))
            {
                map.put(S.charAt(right), map.get(S.charAt(right))-1);
                if(map.get(S.charAt(right))>=0)
                {
                    count++;
                }
                while(count == T.length())
                {
                    if(right-left+1<result)
                    {
                        result = right-left+1;
                        start = left;
                        end = right;
                    }
                    if(map.containsKey(S.charAt(left)))
                    {
                        map.put(S.charAt(left), map.get(S.charAt(left))+1);
                        if(map.get(S.charAt(left))>0)
                        {
                            count--;
                        }
                    }
                    left ++;
                }
            }
        }
        if(start == -1)
        {
            return "";
        }
        else
        {
            return S.substring(start, end+1);
        }
    }
}
