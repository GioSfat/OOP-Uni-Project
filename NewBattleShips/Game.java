import java.util.Scanner;

public class Game{
    
    public static void main(String args[]) throws OverlapTilesException,NewException,AdjacentTilesException{
        
        //Kataskevi twn paiktwn
        Player player = new Player("PLAYER");
        Player pc = new Player("PC");
        
        //Kataskevi twn pinakwn
        String[][] pcboard = new String[10][10];
        String[][] playerboard = new String[10][10];
        
        //Kataskevi twn ploiwn
        Carrier ship1 = new Carrier(5,1,1,1);
        BattleShip ship2 = new BattleShip(4,1,1,1);
        Cruiser ship3 = new Cruiser(3,1,1,1);
        Submarine ship4 = new Submarine(3,1,1,1);
        Destroyer ship5 = new Destroyer(2,1,1,1);
        
        //Topothetisi twn ploiwn
        System.out.println("Do you want your ships placed random? (1/0)");
        Scanner sc = new Scanner(System.in);
        int eisodos = sc.nextInt();
        while(eisodos != 0 && eisodos !=1 ){
            System.out.println("Wrong input! Please Insert valid input(Y/N or y/n): ");
            eisodos = sc.nextInt();
            System.out.println(eisodos);
        }
        if(eisodos == 0){
            Tiles2.Fill(playerboard);
            Tiles2.Fill(pcboard);
            
            player.placeAllShips(playerboard);
            
            pc.placeAllShips(pcboard);
            
            System.out.println("--------PLAYER--------");
            Board.drawboards(playerboard);
            System.out.println();
            System.out.println("----------PC----------"); 
            
            Board.PCdrawboards(pcboard);
            
            System.out.println("IN");
        }
        else if(eisodos == 1){
            
            Tiles2.Fill(playerboard);
            Tiles2.Fill(pcboard);
            
            player.placeShip(playerboard,ship1,1,1);
            Board.drawboards(playerboard);
            player.placeShip(playerboard,ship2,1,1);
            Board.drawboards(playerboard);
            player.placeShip(playerboard,ship3,1,1);
            Board.drawboards(playerboard);
            player.placeShip(playerboard,ship4,1,1);
            Board.drawboards(playerboard);
            player.placeShip(playerboard,ship5,1,1);
            
            pc.placeAllShips(pcboard);
            
            System.out.println("--------PLAYER--------");
            Board.drawboards(playerboard);
            System.out.println();
            System.out.println("----------PC----------");
            
            Board.PCdrawboards(pcboard);     
        }
        //Arxi tou paixnidiou!!!
        do{
            player.Fire(pcboard);
            pc.PCFire(playerboard);
            
            System.out.println("--------PLAYER--------");
            
            Board.drawboards(playerboard);
            System.out.println();
            System.out.println("----------PC----------");
            
            Board.PCdrawboards(pcboard);
            
            System.out.println(Player.shots);
            
        }while(Board.PCallShipsSunk(playerboard) && Board.allShipsSunk(pcboard) && Player.shots<25);
        Player.getStats();
    } 
}