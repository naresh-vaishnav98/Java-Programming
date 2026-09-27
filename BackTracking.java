import java.util.*;

public class BackTracking{

    public static void ratMaze(int maze[][],int row,int col, String path, List<String> ans){
        int n = maze.length;
        if(row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0 || maze[row][col] == -1){
            return;
        }
        if(row == n-1 && col == n-1){
            ans.add(path);
            return;
        }

        maze[row][col] = -1;

        ratMaze(maze,row,col+1,path+'R',ans); //Right
        ratMaze(maze,row+1,col,path+'D',ans); //Down
        ratMaze(maze,row,col-1,path+'L',ans); //Left
        ratMaze(maze,row-1,col,path+'U',ans); //Up

        maze[row][col] = 1;
    }


    public static void main(String args[]){
        // System.out.println("Hello guysss");
        int maze[][] = { { 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 0 },
                        { 1, 1, 1, 1 } };
        // int maze[][] = { { 1, 0, 0, 0 },
        //                 { 1, 1, 0, 1 },
        //                 { 1, 1, 0, 0 },
        //                 { 0, 1, 1, 1 } };
        String path = "";
        List<String> ans = new ArrayList<>();
        ratMaze(maze,0,0,path,ans);
        System.out.print(ans);
    }
}