package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict){
        boolean[] result = new boolean[s.length()+1];
        result[result.length-1] = true;
        List<String>[] fin = new LinkedList[s.length()];
        for(int i=s.length()-1;i>=0;i--)
        {
            fin[i] = new LinkedList<String>();
            for(int j = i+1;j<s.length()+1;j++)
            {
                if(dict.contains(s.substring(i,j)) && result[j])
                {
                    result[i] = true;
                    fin[i].add(s.substring(i,j));
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        List<String> list = new LinkedList<String>();
        if(result[0] == false)
        {
            return list;
        }
        dfs(fin, list, sb, 0);
        return list;   
    }
    
    public void dfs(List<String>[] fin, List<String> list, StringBuffer sb, int index)
    {
        if(index>=fin.length)
        {
            list.add(sb.toString());
            return;
        }
        for(int i=0;i<fin[index].size();i++)
        {
            String str = fin[index].get(i);
            int m = sb.length();
            if(index == 0)
            {
                sb.append(str);
            }
            else
            {
                sb.append(" "+str);
            }
            dfs(fin, list, sb, index+str.length());
            sb = sb.delete(m,sb.length());
        }
    }
}