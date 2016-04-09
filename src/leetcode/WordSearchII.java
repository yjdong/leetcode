package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII{
    Set<String> result = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Trie trie = new Trie();
        for(String s : words)
        {
            trie.insertWord(s);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                 dfs(i, j, "", visited, board, trie);
            }
        }
        return new ArrayList<String>(result);
    }
    
    public void dfs(int width, int length, String s, boolean[][] visited, char[][] board, Trie trie)
    {
        int m = board.length;
        int n = board[0].length;
        int[][] set = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        if(width<0 || length<0 || width>=m || length>=n)
            return;
        if(visited[width][length])
            return;
        String str = s+board[width][length];
        if(!trie.prefix(str))
            return;
        if(trie.searchWord(str))
            result.add(str);
        visited[width][length] = true;
        for(int i=0;i<4;i++)
        {
            int x = width+set[i][0];
            int y = length+set[i][1];
            dfs(x, y, str, visited, board, trie);
        }
        visited[width][length] = false;
    }
}

class TrieNode
{
    TrieNode[] child = new TrieNode[26];
    String item = "";
}

class Trie
{
    TrieNode root = new TrieNode();
    
    public void insertWord(String word)
    {
        TrieNode node = root;
        char[] word2 = word.toCharArray();
        for(char x : word2)
        {
            if(node.child[x-'a'] == null)
            {
                node.child[x-'a'] = new TrieNode();
            }
            node = node.child[x-'a'];
        }
        node.item = word;
    }
    
    public boolean searchWord(String word)
    {
        TrieNode node = root;
        char word2[] = word.toCharArray();
        for(char x : word2)
        {
            if(node.child[x-'a'] == null)
            {
                return false;
            }
            node = node.child[x-'a'];
        }
        if(node.item.equals(word))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean prefix(String word)
    {
        TrieNode node = root;
        char word2[] = word.toCharArray();
        for(char x : word2)
        {
            if(node.child[x-'a'] == null)
            {
                return false;
            }
            node = node.child[x-'a'];
        }
        return true;
    }
}