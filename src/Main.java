import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Starting Chess Game, Let's GO !!!");

        PlayChess p = new PlayChess();

        int srcX=0, srcY=0, destX=0, destY=0;
        boolean flag=true;

        while(true){
            if(flag)System.out.println("White to move !");
            else System.out.println("Black to move !");

            System.out.println("Give move cordinates: srcX srcY destX destY");
            srcX= sc.nextInt(); srcY=sc.nextInt(); destX=sc.nextInt(); destY= sc.nextInt();

            int moved= p.makeMove(srcX, srcY, destX, destY);
            if(moved == 1)
                flag=!flag;
            else if(moved==-1)
                break;
        }
    }
}