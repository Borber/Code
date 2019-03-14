import java.util.Scanner;

public class S{
    public static void main(String[] args) {
    double Sum = 0;
    Scanner X = new Scanner(System.in);
    System.out.print("Enter the size of array: ");
    int N = X.nextInt();
    double Num[] = new double[N];
    System.out.print("Enter "+N+" numbers: ");
    for (int i = 0;i < Num.length ;++i,Sum += Num[i]) Num[i]=X.nextDouble();
    System.out.print("Tatol is: "+ Sum);
    System.out.println();
    }
}