import java.rmi.*;
import java.rmi.registry.*;
public class MyServer{
    public static void main(String args[]){
        try{
       LocateRegistry.createRegistry(1099);
       Concat stub = new ConcatRemote();
       Naming.rebind("rmi://localhost/concat",stub);
       System.out.println("server ready");
        }catch(Exception e){
            System.out.println(e);
        }
    }
} 