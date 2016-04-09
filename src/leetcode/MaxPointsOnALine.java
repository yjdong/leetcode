package leetcode;

import java.util.HashMap;

public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if(points == null || points.length<1)
        {
            return 0;
        }
        int allmax = 1;
        for(int i=0;i<points.length;i++)
        {
            int samepoint = 0;
            int samex = 0;
            int samey = 0;
            int max = 0;
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            for(int j=i+1;j<points.length;j++)
            {
                if(points[j].x == points[i].x && points[j].y == points[i].y)
                {
                    samepoint ++;
                }
                else if(points[i].x == points[j].x)
                {
                    samex ++;
                }
                else if(points[i].y == points[j].y)
                {
                    samey ++;
                }
                else
                {
                    double m = (double)(points[i].y-points[j].y)/(points[i].x-points[j].x);
                    if(map.containsKey(m))
                    {
                        map.put(m, map.get(m)+1);
                    }
                    else
                    {
                        map.put(m, 1);
                    }
                    if(map.get(m)>max)
                    {
                        max = map.get(m);
                    }
                }
            }
            if(samex > max)
            {
                max = samex;
            }
            if(samey > max)
            {
                max = samey;
            }
            max += samepoint+1;
            if(max > allmax)
            {
                allmax = max;
            }
        }
        return allmax;
    }
}