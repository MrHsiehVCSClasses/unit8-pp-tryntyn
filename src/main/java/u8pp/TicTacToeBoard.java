package u8pp;


public class TicTacToeBoard {

    String[][] data;

    public TicTacToeBoard(String[][] data) {
        this.data = data;
    }

    public String toString() {
        String output = "";
        for(int r = 0; r < data.length; r++) {
            if(r != 0) {
                output += "\n";
                output += "-+".repeat(data[r].length - 1);
                output += "-";
                output += "\n";
            }
            for(int c = 0; c < data[r].length; c++) {
                if(c != 0) {
                    output += "|";
                }
                output += data[r][c];
            }
        }
        return output;
    }

    public boolean hasWin() {
        return hasDiagonalWin() || hasHorizontalWin() || hasVerticalWin();
    }

    public boolean hasHorizontalWin() {
        /* Your code here */
      int countX = 0;
      int countY = 0;
      for(int i = 0; i < data.length; i++){
        for(int j = 0; j < data[0].length; j++){
          if(data[i][j].equals("X")){
            countX++;
          }
          else if(data[i][j].equals("O")){
            countY++;
          }
        }
        if(countX == data.length){
          return true;
        }
        else if(countY == data.length){
          return true;
        }
        countX = 0;
        countY = 0;
      }
      return false;
    }

    public boolean hasVerticalWin() {
        /* Your code here */
      int countX = 0;
      int countY = 0;
      for(int c = 0; c < data[0].length; c++){
        for(int r = 0; r < data.length; r++){
          if(data[r][c].equals("X")){
            countX++;
          }
          else if(data[r][c].equals("O")){
            countY++;
          }
        }
        if(countX == data[0].length){
          return true;
        }
        else if(countY == data[0].length){
          return true;
        }
        countX = 0;
        countY = 0;
      }
      return false;
    }

    public boolean hasDiagonalWin() {
        /* Your code here */
      int diagonal = data.length -1;
      int countX = 0;
      int countY = 0;
      int countX2 = 0;
      int countY2 = 0;
      for(int i = 0; i < data.length;i++){
        
        if(data[i][i].equals("X")){
          countX++;
        }
        else if(data[i][i].equals("O")){
          countY++;
        }
        if(data[i][diagonal].equals("X")){
          countX2++;
          diagonal--;
        }
        else if(data[i][diagonal].equals("O")){
          countY2++;
          diagonal--;
        }
        
      }
      if(countX == data.length || countX2 == data.length){
        return true;
      }
      else if(countY2 == data.length || countY == data.length){
        return true;
      }
      else{
        return false;
      }
    }

    /* helper functions go here */
   
}