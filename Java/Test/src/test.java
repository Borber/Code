import java.util.Scanner;
//import com.borber.*;
public class test{
    Scanner X = new Scanner(System.in);
    boolean Game_Over = true;
    //TODO: int Wrong_TimeS = 0;
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
    int U_Key_N;
    char U_Key[];
    public void Start(){
        Chang_Key();
        do{
        System.out.println("  Guess Word Game");
        Print_Line(5, '-');
        System.out.print("Menu");
        Print_Line(5, '-');
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
    public void Chang_Key(){
        int N = (int)(Math.random()*10)%N_Keys.length;
        Key = N_Keys[N];
        U_Key_N = 0;
        U_Key = new char[Key.length()];
    }
    public void Game_Play(){
        char input;
        boolean Fleg,EXIST;
        do{
            Fleg = false;
            System.out.println("Enter your guess: ");
            input = X.next().charAt(0);
            for(int i = 0;i < Key.length();++i){
            if(Key.toUpperCase().charAt(i) == input || Key.toLowerCase().charAt(i) == input){
            boolean Copy = false;
            for(int j=0;j<U_Key_N;++j)
            if (input == U_Key[j]||input == U_Key[j] + 'A' -'a') Copy = true;
            Fleg = true;
            if(!Copy) U_Key[U_Key_N++] = Key.charAt(i);
            }
        }
        if (Fleg) System.out.println("It's in");
        else System.out.println("It's not in");
        Fleg = false;
        for(int i=0;i < Key.length();++i){
            EXIST = false;
            for(int j=0;j<U_Key_N;++j)
            if(Key.charAt(i) == U_Key[j]) EXIST = true;
            if(EXIST) System.out.print(Key.charAt(i));
            else System.out.print("*");
        }
        System.out.println();
        Game_Over_Check();
    }while(Game_Over);
    }
    public void Game_Over_Check(){
        int Length = 0;
        for(int i = 0;i < Key.length();++i)
        for(int j = 0;j < U_Key_N;++j)
        if(Key.charAt(i) == U_Key[j]){
            Length++;
            break;
        }
        if(Length == Key.length()){
            System.out.println(Key);
            System.out.println("Winner winner! chicken dinner!");
            Game_Over = false;
        }
        if(!Game_Over){
            System.out.println("Do you wanna to play agian?(y/n)");
            char Check = X.next().charAt(0);
            if(Check == 'Y'||Check == 'y'){
                Chang_Key();
                U_Key = new char[Key.length()];
                U_Key_N = 0;
                Game_Over = true;
            }
        }
    }
    public void Print_Line(int NUM,char S){
        for(int i=0;i<=NUM;++i)
        System.out.print(S);
    }
    public static void main(String[] args) {
        test Game = new test();
        Game.Start();
        }
        }