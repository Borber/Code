
import java.math.*;
import java.util.Scanner;
public class test{
    public class Student{
    void ID_Input(){
        System.out.print("Enter ID:\t");
        ID = BORBER.nextInt();
    }
    void Name_Input(){
        System.out.print("Enter Name:\t");
        Name = BORBER.next();
    }void Age_Input(){
        System.out.print("Enter Age:\t");
        Age = BORBER.nextInt();
    }void Gender_Input(){
        System.out.print("Enter Gender:\t");
        Gender = BORBER.next().charAt(0);
    }void Adress_Input(){
        System.out.print("Enter Adress:\t");
        Address = BORBER.next();
    }
    void fees_Input(){
        System.out.print("Enter fees:\t");
        fees = BORBER.nextDouble();
    }
    Scanner BORBER = new Scanner(System.in);
    int ID,Age;
    double fees;
    String Name,Address;
    char Gender;
}
    Student Student_First = new Student();
    void Print(){
        for(int i=0;i <= 50;++i)
        System.out.print("*");
        System.out.println("");
    }
    void Student_Input(){
        Print();
        System.out.println("\t\tStudent Details");
        Print();
        Student_First.ID_Input();
        Student_First.Name_Input();
        Student_First.Age_Input();
        Student_First.Gender_Input();
        Student_First.Adress_Input();
        Student_First.fees_Input();
        Print();
        System.out.println("You have entered:");
        Print();
        System.out.println(""
        +Student_First.ID+" "
        +Student_First.Name+" "
        +Student_First.Age+" "
        +Student_First.Gender+" "
        +Student_First.Address+" "
        +Student_First.fees);
        Print();
        System.out.println("Thank you......");
    }
    public static void main(String[] args) {
        test Test = new test();
        Test.Student_Input();
}
}