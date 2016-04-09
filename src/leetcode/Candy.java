package leetcode;

public class Candy {
    public int candy(int[] ratings) {
        int d[] = new int[ratings.length];
        d[0] = 1;
        for(int i=1;i<d.length;i++)
        {
            if(ratings[i]>ratings[i-1])
                d[i] = d[i-1]+1;
            else
                d[i] = 1;
        }
        int total = d[d.length-1];
        d[d.length-1] = 1;
        for(int i=d.length-2;i>=0;i--)
        {
            int cur = 1;
            if(ratings[i]>ratings[i+1])
                cur = d[i+1]+1;
            d[i] = Math.max(cur, d[i]);
            total += d[i];
        }
        return total;
    }
}
