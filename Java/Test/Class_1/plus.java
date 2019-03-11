import java.math.BigInteger;
import java.util.Scanner;

public class plus{
    public static void main(String[] args) {
    Scanner X = new Scanner(System.in);
    String Num1,Num2;
    Num1 = X.nextLine();
    Num2 = X.nextLine();
    BigInteger A = new BigInteger(Num1);
    BigInteger B = new BigInteger(Num2);
    B = B.add(A);
    System.out.println(B);
    }
}