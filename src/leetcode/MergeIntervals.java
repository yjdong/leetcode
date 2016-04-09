package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> list = new LinkedList<Interval>();
        if(intervals == null || intervals.size()<1)
        {
            return list;
        }
        Interval prev = intervals.get(0);
        for(int i=1;i<intervals.size();i++)
        {
            Interval curr = intervals.get(i);
            if(prev.end>=curr.start)
            {
                Interval interval = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = interval;
            }
            else
            {
                list.add(prev);
                prev = curr;
            }
        }
        list.add(prev);
        return list;
    }
}
class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval a, Interval b)
    {
        return a.start - b.start;
    }
}