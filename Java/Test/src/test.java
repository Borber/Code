import java.util.Scanner;
import com.borber.*;
public class test{
    Scanner X = new Scanner(System.in);
    Compare C = new Compare();
    Clear L = new Clear();
    Print B = new Print();
    boolean Game_Over = true;
    int Wrong_Time = 0;
    String[] N_Keys = new String[]{
        "China",
        "BORBER",
        "Love",
        "Spring",
        "pneumonoultramicroscopicsilicovolcanoconiosis",
        "Australia",
        "romantic",
        "Crazy",
        "Talent",
        "wonderful",
        "apologize"
    };
    String Key;
    String M_Key="Zilan";
    char U_Key[];
    public void Show_Menu(){
        Chang_Key();
        do{
        System.out.println("  Guess Word Game");
        B.Print_Line(5, '-');
        System.out.print("Menu");
        B.Print_Line(5, '-');
        System.out.println();
        System.out.println("1. Play");
        System.out.println("2. Instructions");
        System.out.println("3. Secret");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Choose the option:");
        Game_Choose();
        }while(true);
    }
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
            Wife();
            case '4' :
            System.out.println("Bye");
            System.exit(0);
            default:
            System.out.println("1 or 2 oor 3 ooor 4 ,no fucking others");
        }
    }
    
    public void Wife(){
        X.nextLine();
        System.out.println("Input the Secret-Key");
        if (X.nextLine().equals(M_Key))
        System.out.println("I love you.My wife.");
        else
        System.out.println("I'm so sorry.It's not you.");
    }
    
    public void Game_Play(){
        char input;
        boolean Fleg;
        do{
            Fleg = false;
            System.out.println("Enter your guess: ");
            Wrong_Time++;
            input = X.next().charAt(0);
            for(int i = 0;i < Key.length();++i){
            if(C.Char_Ign(Key.charAt(i),input)){
            Fleg = true;
            U_Key[i] = Key.charAt(i);
            }
        }
        if (Fleg) System.out.println("It's in");
        else {
            System.out.println("It's not in");
            switch(Wrong_Time/5){
                case 1 :
                System.out.println("Come on!");
                break;
                case 2 :
                System.out.println("You can do this!");
                break;
                case 3 :
                System.out.println("I think this game is not for you.");
            }
        
        }
        Fleg = false;
        System.out.println(U_Key);
        Game_Over_Check();
    }while(Game_Over);
    }
    public void Game_Over_Check(){
        if(C.Str_Char(Key, U_Key)){
            System.out.println(Key);
            System.out.println("Winner winner! chicken dinner!");
            Game_Over = false;
        }
        if(!Game_Over){
            System.out.println("Do you wanna to play agian?(y/n)");
            char Check = X.next().charAt(0);
            if(Check == 'Y'||Check == 'y'){
                Chang_Key();
                Game_Over = true;
            }
        }
    }
    public void Chang_Key(){
        int N = (int)(Math.random()*10)%N_Keys.length;
        Key = N_Keys[N];
        U_Key = new char[Key.length()];
        U_Key = L.clear_Char(U_Key, '*');
        Wrong_Time = 0;
    }
    public static void main(String[] args) {
        test Game = new test();
        Game.Show_Menu();
        }
        }