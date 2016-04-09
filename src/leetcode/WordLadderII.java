package leetcode;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> list = new LinkedList<List<String>>();
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        dict.add(end);
        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
        unvisited.addAll(dict);
        queue.add(new WordNode(start, 1, null));
        int minStep = 0;
        int numStep = 0;
        while(!queue.isEmpty())
        {
            WordNode node = queue.poll();
            int level = node.stepNum;
            if(numStep<level && minStep!=0)
            {
                break;
            }
            if(numStep<level)
            {
                unvisited.removeAll(visited);
            }
            numStep = level;
            if(node.word.equals(end))
            {
                if(minStep == 0)
                {
                    minStep = level;
                }
                
                LinkedList<String> list2 = new LinkedList<String>();
                list2.add(node.word);
                while(node.pre != null)
                {
                    list2.add(0, node.pre.word);
                    node = node.pre;
                }
                list.add(list2);
                continue;
            }
            
            String s = node.word;
            char[] news = s.toCharArray();
            for(int i=0;i<s.length();i++)
            {
                for(char j='a';j<='z';j++)
                {
                    char temp = news[i];
                    news[i] = j;
                    String str = new String(news);
                    if(unvisited.contains(str))
                    {
                        queue.add(new WordNode(str, level+1, node));
                        visited.add(str);
                    }
                    news[i] = temp;
                }
            }
        }
        return list;
    }
}
