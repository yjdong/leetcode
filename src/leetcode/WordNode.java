package leetcode;

public class WordNode {
    String word;
    int stepNum;
    WordNode pre;
    
    public WordNode(String word, int stepNum, WordNode pre)
    {
        this.word = word;
        this.stepNum = stepNum;
        this.pre = pre;
    }
}
