/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;
import java.util.Random;
/**
 *
 * @author marku
 */
public class ConnectFour {
    private static final char[][] gameBoard=new char[6][7];
    /**
     * @param args the command line arguments
     */
    private static char[][] createBoard(char starter)
    {
        for (int i=0;i<gameBoard.length;i++)
        {
            for(int j=0;j<gameBoard[i].length;j++)
            {
                gameBoard[i][j]=starter;
            }
        }
        return gameBoard;
    }
    private static void printBoard()
    {
        for (int i=0;i<gameBoard.length;i++)
        {
            for (int j=0;j<gameBoard[i].length;j++)
            {
                System.out.print(gameBoard[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void takeTurn(char turnPoint)
    {
        System.out.println(turnPoint+"'s Turn:");
        Random rnd= new Random();
        int col=rnd.nextInt(7);
        int row=5;
        if (gameBoard[row][col]=='b')
        {
            gameBoard[row][col]=turnPoint;   
        }
        else if(gameBoard[row][col]=='r'||gameBoard[row][col]=='y')
        {
            while(gameBoard[row][col]=='r'||gameBoard[row][col]=='y')
            {
                row--;
                if (row<0)
                {
                    row=5;
                    col--;
                }
            }
            gameBoard[row][col]=turnPoint;
        }
        if(gameBoard[0][col]=='y'||gameBoard[0][col]=='r')
        {
            col++;
            gameBoard[row][col]=turnPoint;
        }
        
        printBoard();
    }
    private static boolean checkRows(char[][] board)
    {
        int row=5;
        int col=6;
        int countR=0;
        int countY=0;
        while (row>=0)
        {
            if(board[row][col]=='r')
            {
                countR++;
                countY=0;
                
            }
            else if(board[row][col]=='y')
            {
                countY++;
                countR=0;    
            }
            else if(board[row][col]=='b')
            {
                countY=0;
                countR=0;
            }

            if (countR>=4)
            {
                System.out.print("RED WON!");
                return true;         
            }
            else if (countY>=4)
            {
                System.out.print("YELLOW WON!");
                return true;         
            }
            row--;
        }
        if (false)
        {
            System.out.print("It's a tie");
        }
        return false;
    }
    private static boolean checkCols(char[][] board)
    {
        int row=5;
        int col=6;
        int countR=0;
        int countY=0;
        while (col>=0)
        {
            if(board[row][col]=='r')
            {
                countR++;
                countY=0;
            }
            else if(board[row][col]=='y')
            {
                countY++;
                countR=0;
            }
            else if(board[row][col]=='b')
            {
                countY=0;
                countR=0;
            }
            if (countR>=4)
            {
                System.out.print("RED WON!");
                return true;         
            }
            else if (countY>=4)
            {
                System.out.print("YELLOW WON!");
                return true;         
            }
            col--;
        }
        if (false)
        {
            System.out.print("It's a tie");
        }

        return false;
        
    }
    private static boolean checkDiagonals(char[][]gameBoard)
    {
        int row=5;
        int col=6;
        int countR=0;
        int countY=0;
        while(row>=0)
        {
            if(gameBoard[row][col]=='r')
            {
                countR++;
                countY=0;
            }
            else if(gameBoard[row][col]=='y')
            {
                countY++;
                countR=0;

            }
            else if(gameBoard[row][col]=='b')
            {
                countY=0;
                countR=0;

            } 
            row--;
            col--;
        }
        if (countR>=4)
        {
            System.out.print("RED WON!");
            return true;         
        }
        if (countY>=4)
        {
            System.out.print("YELLOW WON!");
            return true;         
        }
        else
        {
            System.out.print("It's a tie");
        }
                
        return false;
    }
    private static char playGame(char[][] board)
    {
        char redTurn='r';
        char yellowTurn='y';
        char temp=redTurn;
        int i=0;      
        while (i<16)
        {
            if (i%2==0)
            {
                temp=redTurn;   
            }
            if(i%2==1)
            {
                temp=yellowTurn;  
            } 
            takeTurn(temp);
            i++;
        }
        checkRows(board);
        checkCols(board);
        return temp;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("----------------");
        playGame(createBoard('b'));
    }
    
}
