

 
import java.util.*;

public class tokenring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number Of Processes In Ring: ");
        int n = sc.nextInt();

        System.out.println("\nRing Formed Is:");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");
        }
        System.out.println("0");

        int token = 0;
        int choice=1;

        do {

            System.out.print("\nEnter Process Requesting Critical Section: ");
            int request = sc.nextInt();

            

            System.out.println("\nCurrent Token At Process: " + token);

            // Token Passing
            System.out.print("Token Passing: ");

            int i = token;

            while (i != request) {
                System.out.print(i + " -> ");
                i = (i + 1) % n;
            }

            System.out.println(request);

            // Critical Section
            System.out.println("\nProcess " + request + " Enters Critical Section");
            System.out.println("Process " + request + " Is Executing...");
            System.out.println("Process " + request + " Exits Critical Section");

            // Pass token to next process
            token = (request + 1) % n;

            System.out.println("Token Passed To Process: " + token);

            System.out.print("\nDo You Want To Continue? (1 for YES / 0 for NO): ");
            choice = sc.nextInt();

        } while (choice == 1);

        System.out.println("\nExecution Finished.");
    }
}
