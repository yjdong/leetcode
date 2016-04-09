package leetcode;

import java.util.List;
import java.util.ListIterator;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null)
        {
            intervals.add(newInterval);
            return intervals;
        }
        if(newInterval == null)
        {
            return intervals;
        }
        ListIterator i = intervals.listIterator();
        while(i.hasNext())
        {
            Interval curr = (Interval)i.next();
            if(newInterval.end<curr.start)
            {
                i.previous();
                i.add(newInterval);
                return intervals;
            }
            if(newInterval.start<curr.end)
            {
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
                i.remove();
            }
        }
        return intervals;
    }
}
