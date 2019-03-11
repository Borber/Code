import java.util.Scanner;
import com.borber.*;
public class test{
    String Key = "Love";
    Scanner X = new Scanner(System.in);
    public void Game_Choose(){
        char Choose;
        Choose= X.next().charAt(0);
        switch(Choose){
            case '1' :
            Game_Play();
            break;
            case '2' :
            System.out.println("Just input your fucking words!");
            break;
            case '3' :
            System.out.println("Bye");
            System.exit(0);
            default:
            System.out.println("1 or 2 oor 3 ,no fucking others");
        }
    }
    public void Start(){
        do{
        Print B = new Print();
        B.Print_Line(5, '-');
        System.out.print("Menu");
        B.Print_Line(5, '-');
        System.out.println();
        System.out.println("1. Play");
        System.out.println("2. Instructions");
        System.out.println("3. Exit");
        System.out.println();
        System.out.print("Choose the option:");
        Game_Choose();
        }while(true);
    }
    public void Game_Play(){
        char Game_Over,input;
        boolean Fleg = false;
        do{
            System.out.println("Enter your guess: ");
            input = X.next().charAt(0);
            for(int i = 0;i < Key.length();++i){
            if(Key.toUpperCase().charAt(i) == input || Key.toLowerCase().charAt(i) == input)
            Fleg = true;
        }
        if (Fleg)
        System.out.println("It's in");
        else 
        System.out.println("It's not in");
        Fleg = false;
        System.out.println("Again?(y/n) or Answer the key(k)[You just have one chance]");
        Game_Over = X.next().charAt(0);
        if (Game_Over == 'k'|| Game_Over=='K'){
            Game_Key();
        }
    }while(Game_Over == 'y'||Game_Over=='Y');
    }
    public void Game_Key(){
        System.out.println("Enter the key!!!");
        String Play_Key = X.next();
        int Win = Play_Key.toLowerCase().compareTo(Key.toLowerCase());
        if(Win == 0) 
        System.out.println("Winner winner! chicken dinner!");
        else
        System.out.println("Sorry you are wrong.");
        System.exit(0);
    }
    public static void main(String[] args) {
        test Game = new test();
        Game.Start();
        }
        }