import java.util.Scanner;
import java.rmi.*;
public class MyClient{
    public static void main(String args[]){
        try{
            Concat stub=(Concat) Naming.lookup("rmi://localhost/concat");
            Scanner input = new Scanner(System.in);
            String x,y;
            System.out.println("enter str 1");
            x=input.nextLine();
            System.out.println("enter str 2");
            y=input.nextLine();
            System.out.println(stub.concat(x,y));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
} 