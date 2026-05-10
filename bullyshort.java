
import java.util.*;

public class bullyshort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        boolean[] active = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            active[i] = true;

        int coordinator = n;

        System.out.print("Enter crashed process: ");
        int crash = sc.nextInt();

        active[crash] = false;

        System.out.println("Process " + crash + " crashed");

        System.out.print("Enter initiator process: ");
        int init = sc.nextInt();

        System.out.println("\nElection Messages:");
        for (int i=init+1;i<=n;i++){
            if (active[i]){
                for (int j=i+1;j<=n;j++){
                    if (active[j]){
                        System.out.println("process   "+i+"   sending election message to process   "+j);
                
                    }
                
            }
            System.out.println("------------------------------");
            
            }else {
                System.out.println("the process "+i+" is offline ");
                System.out.println("------------------------------");
            }
        
                
        }

        for (int i = n; i >= 1; i--) {
            if (active[i]) {
                coordinator = i;
                break;
            }
        }

        System.out.println("\nNew Coordinator is Process " + coordinator);
    }

}
