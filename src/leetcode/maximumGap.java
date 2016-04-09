package leetcode;

import java.util.Arrays;

public class maximumGap {
    public int maximumGap(int[] num) {
        if(num == null || num.length<2)
            return 0;
        if(num.length==2)
            return num[0]-num[1]>0 ? num[0]-num[1] : num[1]-num[0];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++)
        {
            if(num[i]<min)
                min = num[i];
        }
        for(int i=0;i<num.length;i++)
        {
            if(num[i]>max)
                max = num[i];
        }
        int gap = (max-min)/(num.length-1)+1;
        int size = (max-min)/gap+1;
        int bucketmin[] = new int[size];
        int bucketmax[] = new int[size];
        Arrays.fill(bucketmin, Integer.MAX_VALUE);
        Arrays.fill(bucketmax, Integer.MIN_VALUE);
        for(int i=0; i<num.length; i++)
        {
            int index = (num[i]-min)/gap;
            bucketmin[index] = Math.min(num[i], bucketmin[index]);
            bucketmax[index] = Math.max(num[i], bucketmax[index]);
        }
        int previous = bucketmax[0];
        int maximum = Integer.MIN_VALUE;
        for(int i=1;i<size;i++)
        {
            if(bucketmin[i]!=Integer.MAX_VALUE || bucketmax[i]!=Integer.MIN_VALUE)
            {
                maximum = Math.max(bucketmin[i]-previous, maximum);
                previous = bucketmax[i];
            }
        }
        return maximum;
    }
}