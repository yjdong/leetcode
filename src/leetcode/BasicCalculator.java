package leetcode;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        if(s == null || s.length()<1)
        {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int flag = 1;
        int num = 0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num = num*10+c-'0';
            }
            else if(c == '+')
            {
                res += num*flag;
                flag = 1;
                num = 0;
            }
            else if(c == '-')
            {
                res += num*flag;
                flag = -1;
                num = 0;
            }
            else if(c == '(')
            {
                stack.push(res);
                stack.push(flag);
                num = 0;
                res = 0;
                flag = 1;
            }
            else if(c == ')')
            {
                res += num*flag;
                res = res*stack.pop()+stack.pop();
                num = 0;
                flag = 1;
            }
        }
        res += num*flag;
        return res;
    }
}