public class Board{
    
    public static boolean ShipsSunk = true;
    public static boolean PCShipsSunk = true;
    public Board(String[][] board){
        Tiles2.Fill(board);
    }
    
    public static void drawboards(String[][] board){
        Tiles2.draw(board);
    }
    
    public static void PCdrawboards(String[][] board){
        Tiles2.PCdraw(board);
    }
    
    public static void placeAllShips(String[][] board) throws OverlapTilesException,NewException,AdjacentTilesException{
        Player.placeAllShips(board);
    }
    
    public static boolean allShipsSunk(String[][] board){
        if(Player.PLAYERhits >=17){
            ShipsSunk=false;
        }
        return ShipsSunk;
    }
    public static boolean PCallShipsSunk(String[][] board){
        if(Player.PChits >=17){
            PCShipsSunk=false; 
        }
        return PCShipsSunk;
    }
}