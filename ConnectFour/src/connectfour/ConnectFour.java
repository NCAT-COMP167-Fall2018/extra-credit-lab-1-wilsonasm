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
        int col=rnd.nextInt(6);
        int row=5;
        if(gameBoard[row][col]==('b'))
        {
            gameBoard[row][col]=turnPoint;
            if(gameBoard[row][col]==('y')||gameBoard[row][col]==('r'))
            {
                row=row-1;
                gameBoard[row][col]=turnPoint;
            }
            if(gameBoard[0][col]=='y'||gameBoard[0][col]=='r')
            {
                col=col+1;
                gameBoard[row][col]=turnPoint;
            }
        }
        printBoard();
    }
    private static boolean checkRows(char[][] board)
    {
        int row=0;
        int col=0;
        int counterR=0;
        int countY=0;
        while (row>board.length)
        {
            if(board[row][col]=='r')
            {
                countR++;
                row++;
            }
            else if(board[row][col]=='y')
            {
                countY++;
                row++;
            }
            else
            {
                row++;
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
            col++;
        }
        return false;
    }
    private static boolean checkCols(char[][] board)
    {
        int row=0;
        int col=0;
        int countR=0;
        int countY=0;
        while (col>board[row].length)
        {
            if(board[row][col]=='r')
            {
                countR++;
                col++;
            }
            if(board[row][col]=='y')
            {
                countY++;
                col++;
            }
            else
            {
                col++;
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
            row++;
        }

        return false;
        
    }
    private static char playGame(char[][] board)
    {
        char redTurn='r';
        char yellowTurn='y';
        char temp=redTurn;
        int i=0;      
        while (i<11)
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
        createBoard('b');
        printBoard();
        System.out.println("----------------");
        playGame(createBoard('b'));
    }
    
}
