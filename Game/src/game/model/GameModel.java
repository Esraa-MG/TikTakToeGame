/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

/**
 *
 * @author moutaz hegazy
 */
public class GameModel {
    
    //states of game cell.
    private enum CELL
    {
        isMarkedX,
        isMarkedO,
        isUnmarked
    }
    
    //on/off indicator for the game. 
    private boolean gameOn  = false;
    
    //three row of the game.
    /*private CELL firstRow[];
    private CELL secondRow[];
    private CELL thirdRow[];*/
    
    private CELL gameModel[][];
    
    public GameModel()
    {
      //determining the 3 rows for the game.  
        gameModel = new CELL[3][3];
        
     //setting inital state for the game.   
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                gameModel[i][j] = CELL.isUnmarked;
            }
        }
        gameOn = true;
    }
    
    /*
    number : is the number of the cell needs to be marked(1 - 9).
    mark : is the mark as 'X' or 'O' any other input is denied.
    
    returns : if X wins it returns                           "Xwin"
              if O wins it returns                           "Owin"
              if draw it returns                             "draw"
              if the cell is already marked it returns       "isMarked"
              and normally it returns                        "none"
    */
    public String selectCell(int number,char mark)
    {
        boolean win = false;
        boolean draw = false;
        
        CELL  marker = CELL.isUnmarked;
        if(gameOn)
        {
            switch(mark)
            {
                case 'X' : 
                    marker = CELL.isMarkedX;
                    break;
                case 'O' :
                    marker = CELL.isMarkedO;
                    break;
                default : break;
            }  
       
            if(number >0 && number<10 && marker!=CELL.isUnmarked)
            {    
                number --;
                int clmn = number%3;
                int row = number/3;
                System.out.println(row+","+clmn);
                if(gameModel[row][clmn] == CELL.isUnmarked)
                {
                    gameModel[row][clmn] = marker;
                    win = checkForWin(row,clmn);
                    draw = checkForDraw();
                }else{
                    return "isMarked";
                }
            }
        }
        
        if(win)
        {
            if(marker == CELL.isMarkedX)
            {
                return "Xwin";
            }else{
                return "Owin";
            }
        }else if(draw)
        {
            return "draw";
        }else{
            return "none";
        }
    }   
    
    private boolean checkForWin(int row,int clmn)
    {
        int cell = row*3 + (clmn+1);
        
        boolean win = false;
        System.out.println(cell+","+row+","+clmn);
        
        //check row for match.
        if((gameModel[row][0] == gameModel[row][1]) && (gameModel[row][0] == gameModel[row][2])
                && (gameModel[row][2] == gameModel[row][1]))
        {
            win = true;
        }else if ((gameModel[0][clmn] == gameModel[1][clmn]) && (gameModel[0][clmn] == gameModel[2][clmn])
                && (gameModel[1][clmn] == gameModel[2][clmn])) // check clmn for match.
        {
            win = true;
        }
        
        else if(cell%2 != 0)
        {
            switch(cell)
            {
                case 1:
                case 9:
                    if ((gameModel[0][0] == gameModel[1][1]) 
                            && (gameModel[0][0] == gameModel[2][2])
                            && (gameModel[2][2] == gameModel[1][1]))
                    {
                        win = true;
                    }
                    break;
                    
                case 3:
                case 7:
                    if ((gameModel[0][2] == gameModel[1][1]) 
                            && (gameModel[0][2] == gameModel[2][0])
                            && (gameModel[2][0] == gameModel[1][1]))
                    {
                        win = true;
                    }
                    break;
                    
                case 5:
                    if ((gameModel[0][0] == gameModel[1][1]) 
                            && (gameModel[0][0] == gameModel[2][2])
                            && (gameModel[2][2] == gameModel[1][1])
                        || (gameModel[0][2] == gameModel[1][1]) 
                            && (gameModel[0][2] == gameModel[2][0])
                            && (gameModel[2][0] == gameModel[1][1]))
                    {
                        win = true;
                    }
                    break;
            }
        }    
        if(win)
        {
            gameOn = false;
            System.out.println("WINNER");
        }
        return win;
    }
    
    private boolean checkForDraw()
    {
        boolean draw = true;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if (gameModel[i][j] == CELL.isUnmarked)
                {
                    draw = false;
                }
            }
        }
        if(draw)
        {
            gameOn = false;
            System.out.println("DRAW");
        }
        return draw;
    }
    
    public void resetGame()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                gameModel[i][j] = CELL.isUnmarked;
            }
        }    
        gameOn = true;
    }
    
    public void printGame()
    {
       for(int i=0;i<3;i++)
       {
            for(int j=0;j<3;j++)
            {
                System.out.print(gameModel[i][j]+"/");
            }
            System.out.print("\n");
       }
    }
}


