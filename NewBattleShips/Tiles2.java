public class Tiles2 {
    public static final String SEA = "~";
    public static final String SHIP = "S";
    public static final String HIT = "X";
    public static final String MISS = "O";
    static int i,j;
    public static boolean hidden=false;
    
    public static void Fill(String[][] board){
        {for(i=0;i<board.length;i++){
            {for(j=0;j<board[0].length;j++){
                board[i][j]=Tiles2.SEA;
            }}
        }}
    } 
    
    
    
    public static void draw(String[][] board){
        for (i=0 ; i<board.length ; i++) {
            for(j=0;j<board.length;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    
    public static void PCdraw(String[][] board){
	for (i=0 ; i<board.length ; i++) {
	    if(hidden==false) {
		for( j =0 ; j<board[0].length ; j++){
		    System.out.print(board[i][j] + " " );
		}
		System.out.println();
            }else {
		for(j=0; j<board.length;j++) {
		    if(board[i][j]==Tiles2.SHIP) {
					System.out.print(Tiles2.SEA+" ");
		    }else {
					System.out.print(board[i][j] + " ");
		    }
		}
		System.out.println("");
                 }
	}
    }
    
    
}