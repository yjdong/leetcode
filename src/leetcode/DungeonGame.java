package leetcode;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
                int width = dungeon.length;
                int length = dungeon[0].length;
                int result[][] = new int[width][length];
                if(dungeon[width-1][length-1]>=0)
                        result[width-1][length-1] = 0;
                else
                        result[width-1][length-1] = -dungeon[width-1][length-1];
                for(int i = width-2;i>=0;i--)
                        result[i][length-1] = Math.max(result[i+1][length-1]-dungeon[i][length-1],0);
                for(int i = length-2;i>=0;i--)
                        result[width-1][i] = Math.max(result[width-1][i+1]-dungeon[width-1][i],0);
                for(int i=width-2;i>=0;i--)
                {
                        for(int j=length-2;j>=0;j--)
                        {
                                result[i][j] = Math.min(Math.max(result[i+1][j]-dungeon[i][j],0),Math.max(result[i][j+1]-dungeon[i][j],0));
                        }
                }
                return result[0][0]+1;
    }
}