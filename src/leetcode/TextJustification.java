package leetcode;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> list = new LinkedList<String>();
        int i=0;
        while(i<words.length)
        {
            int len = words[i].length();
            int j=i+1;
            for(;j<words.length && len+words[j].length()+1<=L;j++)
            {
                len += words[j].length()+1;
            }
            if(j == words.length)
            {
                String s = words[i];
                for(int k = i+1;k<j;k++)
                {
                    s += " "+words[k]; 
                }
                while(s.length()<L)
                {
                    s+=" ";
                }
                list.add(s);
            }
            else if(j-i == 1)
            {
                String s = words[i];
                while(s.length()<L)
                {
                    s+= " ";
                }
                list.add(s);
            }
            else
            {
                int a = (L-len)/(j-1-i)+1;
                int b = (L-len)%(j-1-i);
                String s1 = "";
                while(s1.length()<a)
                {
                    s1+=" ";
                }
                String s = words[i];
                for(int k=i+1;k<j;k++)
                {
                    s+=s1;
                    if(b>0)
                    {
                        s+=" ";
                        b--;
                    }
                    s+=words[k];
                }
                list.add(s);
            }
            i = j;
        }
        return list;
    }
}
