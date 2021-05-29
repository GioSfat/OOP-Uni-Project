import java.util.Scanner;
public abstract class Ship{
    int size;
    int row;
    int col;
    int direction;
    Scanner sc = new Scanner(System.in);
    int i,j;
    public Ship(int size,int x, int y,int dir){
        this.size = size;
        this.row = x;
        this.col = y;
        this.direction = dir;
    }
    public int getSize(){
        return size;
    }
    abstract void method(); 
    public void placeShip(String[][] board) throws NewException, OverlapTilesException, AdjacentTilesException{
        boolean x=true;
    int i;
        
    while(x) {
            
        try{
            System.out.println("Place your Ship!");
            sc = new Scanner(System.in);
        System.out.println("Give a row: ");
                    row = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.println("Give a column: ");
                    col = sc.nextInt();
                    do {
                        System.out.println("Horizontal or Vertical(1/0)? : ");
                        direction = sc.nextInt();
                        if(direction!=0 && direction!=1) {System.out.println("Wrong direction!");}
                    }while(direction!=1 && direction!=0 );
                    
                    if(board[row][col]=="S")/*if gia tin arxi*/ {
                        throw new OverlapTilesException("Same point");
                    }else {
                    if(direction == 1 ) {
                        
                        for( i = 0; i<size ; i++) {
                            if(board[row][col+i]=="S") {
                                
                                throw new NewException("Overlap");
                            }
                        }
                        if(row==0 && col==0){
                            for(i=0;i<size;i++){
                                if(board[row+1][col+i]=="S"){
                                    throw new AdjacentTilesException("");
                                }
                            }
                            if(board[row][col+1]=="S"){
                                throw new AdjacentTilesException("");
                            }
                        }else if (row==0 && col==board.length-1) {
                            for(i=0;i<size;i++){
                                if(board[row+1][col+i]=="S"){
                                    throw new AdjacentTilesException("");
                                }
                            }
                            if(board[row][col-1]=="S"){
                                throw new AdjacentTilesException("");
                            }
                        }else if (row==board.length-1 && col==0) {
                            for(i=0;i<size;i++){
                                if(board[row-1][col+i]=="S"){
                                    throw new AdjacentTilesException("");
                                }
                            }
                            if(board[row][col+1]=="S"){
                                throw new AdjacentTilesException("");
                            }
                        }else if (row==board.length-1 && col==board.length-size) {
                            for(i=0;i<size;i++){
                                if(board[row-1][col+i]=="S"){
                                    throw new AdjacentTilesException("");
                                }
                            }
                            if(board[row][col-1]=="S"){
                                throw new AdjacentTilesException("");
                            }
                        }else{
                            for (i=0;i<size;i++){//horizontal
                                if(row!=0) {
                                if(board[row-1][col+i]=="S"){
                                    throw new AdjacentTilesException("");
                                }}if(row!=board.length-1) {//horizontal
                                if(board[row+1][col+i]=="S"){
                                    throw new AdjacentTilesException("");
                                    }
                                }
                            }}
                        
                        for( i = 0; i<size ; i++ ) {
                                board[row][col+i] = "S";}
                    }
                    else if (direction == 0){
                        for( i = 0; i<size ; i++) {
                            if(board[row+i][col]=="S") {
                                throw new NewException("Overlap");
                            }
                            if(row==0 && col==0) {
                                for(i=0;i<size;i++) {
                                    if(board[row+i][col+1]=="S") {
                                        throw new AdjacentTilesException("");
                                    }                           
                                }
                                if(board[row+1][col]=="S") {
                                    throw new AdjacentTilesException("");
                                }                           
                            }else if(row==0 && col==board[0].length-1){
                                for (i=0;i<size;i++) {
                                    if(board[row+i][col-1]=="S"){
                                        throw new AdjacentTilesException("");
                                    }
                                }
                                if (board[row+1][col]=="S") {
                                    throw new AdjacentTilesException("");
                                }
                            }else if(row==(board[0].length-size) && col==0){
                                for (i=0;i<size;i++) {
                                    if(board[row+i][col]=="S"){
                                        throw new AdjacentTilesException("");
                                    }
                                }
                                if (board[row-1][col]=="S") {
                                    throw new AdjacentTilesException("");
                                }
                            }else if(row==(board[0].length-size) && col==board[0].length-1){
                                for (i=0;i<size;i++) {
                                    if(board[row+i][col-1]=="S"){
                                        throw new AdjacentTilesException("");
                                    }
                                }
                                if (board[row-1][col]=="S") {
                                    throw new AdjacentTilesException("");
                                }
                            }else{
                                if(col!=0) {//vertical
                                if(board[row][col-1]=="S"){
                                    throw new AdjacentTilesException("");
                                }}
                                if(col!=board.length-1) {//vertical
                                if(board[row][col+1]=="S"){
                                    throw new AdjacentTilesException("");
                                    
                                }}
                            }}
                            
                        for( i = 0; i<size ; i++) {
                            board[row+i][col] =Tiles2.SHIP;
                        }   
                    }
                }
                    x=false;
                    break;
        }catch(IndexOutOfBoundsException e){
            System.out.println("Warning: ArrayIndexOutOfBoundsException");
            x=true;
            continue;
        }catch(OverlapTilesException e){
            System.out.println("Warning: Ships start fromt the same point!");
            x=true;
            continue;
        }catch(NewException e) {
            System.out.println("Warning: Ship over Ship!");
        }catch(AdjacentTilesException e) {
            System.out.println("Warning: Ships too close to each other!");
        }           
    }       
    }
}
