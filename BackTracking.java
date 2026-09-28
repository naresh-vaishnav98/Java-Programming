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


    //N-Queens
     public static void nQueens(char board[][], int n, int row){
        if(row == n){
            printBoard(board,n);
            return;
        }
        for(int i = 0; i < n; i++){
            if(isSafe(board,row,i,n)){
                board[row][i] = 'Q';
                nQueens(board,n,row+1);
                board[row][i] = 'x';
            }
        }
     }

     public static boolean isSafe(char board[][], int row, int col, int n){
        for(int i = row; i >= 0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int j = col; j >= 0; j--){
            if(board[row][j] == 'Q'){
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row, j = col; i >= 0 && j < n; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
     }

     public static void printBoard(char board[][], int n){
        System.out.println("-------Chess Board--------");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
     }

    //Keypad Combination
     public static void keypadCombination(String str, String ans, String keypad[]){
        if(str == ""){
            System.out.println(ans);
            return;
        }
        String key = keypad[str.charAt(0) - 48];

        for(int i = 0; i < key.length(); i++){
            keypadCombination(str.substring(1),ans+key.charAt(i),keypad);
        }
     }


    public static void main(String args[]){
        // int maze[][] = { { 1, 0, 0, 0 },
        //                 { 1, 1, 0, 1 },
        //                 { 0, 1, 0, 0 },
        //                 { 1, 1, 1, 1 } };
        
        // String path = "";
        // List<String> ans = new ArrayList<>();
        // ratMaze(maze,0,0,path,ans);
        // System.out.print(ans);


        // N-Queens
        // int n = 4;
        // char board[][] = {{'x','x','x','x'},{'x','x','x','x'},{'x','x','x','x'},{'x','x','x','x'}};
        // nQueens(board,n,0);


        //Keypad Combinations
        String keypad[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String str = "846";
        String ans = "";
        keypadCombination(str,ans,keypad);
        
    }
}