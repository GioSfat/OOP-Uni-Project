import java.util.Scanner;
import java.util.Random;

public class Player{
    public static boolean hidden;
    public static int PCmisses=0;
    public static int PChits=0;
    public static int PLAYERmisses=0;
    public static int PLAYERhits=0;
    public static int shots=0;
    public static int alreadymiss = 0;
    public static int alreadyshot = 0;
    String name;
    public Player(String name){this.name = name;}
    public static void Fire(String[][] board) {
        int row,col;
        shots++;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose row for the shot");
        row = sc.nextInt();
        while(row>9 || row<0) {//Elegxos gia akures times 
            System.out.println("Choose valid row for the shot(0-9)");
            row = sc.nextInt();
        }
        System.out.println("Choose column for the shot");
        col = sc.nextInt();
        while(col>9 || col<0) {//Elegxos gia akures times 
            System.out.println("Choose valid column for the shot(0-9)");
            col = sc.nextInt();
        }
        if(board[row][col]==Tiles2.SHIP) {
            System.out.println("-----HIT-----");
            board[row][col]=Tiles2.HIT;
            PLAYERhits++;
        }else if(board[row][col]==Tiles2.SEA) {
            System.out.println("-----MISS-----");
            board[row][col]=Tiles2.MISS;
            PLAYERmisses++;
        }else if(board[row][col]==Tiles2.HIT) {
            System.out.println("Already HIT.");
            alreadyshot++;
        }else if(board[row][col]==Tiles2.MISS) {
            System.out.println("Already MISS.");
            alreadymiss++;
        }
        
    }
    public static void PCFire(String[][] board) {
    int row,col;
    //shots++;
    row = (int) (Math.random()*board.length);
        //while(row>9 || row<0) {//Elegxos gia akures times 
            //row = (int) (Math.random()*board.length);
        
    col = (int) (Math.random()*board.length);
        //while(col>9 || col<0) {//Elegxos gia akures times 
            //col = (int) (Math.random()*board.length);
        //}
    if(board[row][col]==Tiles2.SHIP) {
        System.out.println("-----HIT-----");
        board[row][col]=Tiles2.HIT;
        PChits++;
    }else if(board[row][col]==Tiles2.SEA) {
        System.out.println("-----MISS-----");
        board[row][col]=Tiles2.MISS;
        PCmisses++;
    }else if(board[row][col]==Tiles2.HIT) {
        System.out.println("Already HIT.");
    }else if(board[row][col]==Tiles2.MISS) {
            System.out.println("Already MISS.");
    }
    }
    
    public static void getStats() {
        //System.out.println(misses);
        //System.out.println(hits);
        //System.out.println(shots);
        System.out.println("Miss ratio is: " + (int)((PLAYERmisses * 100.0f) / shots)+"%");
        System.out.println("Hit ratio is: " + (int)((PLAYERhits * 100.0f) / shots)+"%");
    }
    public static void placeShip(String[][] board,Ship ship, int x, int y) throws NewException, 
    OverlapTilesException, AdjacentTilesException{
            
            ship.placeShip(board);
       }
    
    public static void placeAllShips(String[][] board) throws OverlapTilesException,NewException,AdjacentTilesException {
    
        Random rand = new Random();
        
        Carrier ship1 = new Carrier(5,1,1,1);
        BattleShip ship2 = new BattleShip(4,1,1,1);
        Cruiser ship3 = new Cruiser(3,1,1,1);
        Submarine ship4 = new Submarine(3,1,1,1);
        Destroyer ship5 = new Destroyer(2,1,1,1);   
        
        int[] size = new int[5];
        size[0]=ship1.getSize();
        size[1]=ship2.getSize();
        size[2]=ship3.getSize();
        size[3]=ship4.getSize();
        size[4]=ship5.getSize();
        
       
         int rotation = ((int)(100 * Math.random())) % 2;
         int row = (int)(board.length* Math.random());
         int col = (int)(board.length* Math.random());
         int i;
         int counter;
         boolean x;  
        for(int z=0;z<5;z++){
            x=true;
       
            do{
                     row = (int)(board.length* Math.random());
                     col = (int)(board.length* Math.random());
                     rotation = ((int)(100 * Math.random())) % 2;
                    
                    
                    if (rotation == 0){
                        //
                        if(col + size[z]<=board.length-1){
                            counter=0;
                            for(int j=col;j<size[z];j++){
                                if(board[row][j]==Tiles2.SEA){
                                    counter++;
                                }
                            }
                            if(counter==size[z]){
                                for(int j=col;j<size[z];j++){
                                   
                                        board[row][j]=Tiles2.SHIP;
                                        if(row-1>=0)
                                            board[row-1][j]="O";
                                        if(row+1<=board.length-1)
                                            board[row+1][j]="O";
                                        
                                }
                                x=false;
                                
                            }
                        }
                    }
                    else{
                        if(row+size[z]<=board.length-1){
                            counter=0;
                            for(int j=row;j<size[z];j++){
                                if(board[j][col]==Tiles2.SEA){
                                    counter++;
                                }
                            }
                            if(counter==size[z]){
                                for(int j=row;j<size[z];j++){
                                            
                                        board[j][col]=Tiles2.SHIP;                                                                                
                                        
                                        if(col-1>=0)
                                            board[j][col-1]="O";
                                        if(col+1<=board.length-1)
                                            board[j][col+1]="O";
                                        
                                }
                                x=false;
                                
                            }
                        }
                    }
                    //System.out.println("Fail!!!" + size[z]);
            }while(x==true);
            
       }
       for(i=0;i<10;i++){
           for(int j=0;j<10;j++){
               if(board[i][j]=="O")
                   board[i][j]=Tiles2.SEA;
           }
       }
       
    }
}