import java.util.*;
public class ringshort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] p = new int[n];

        System.out.println("Enter process IDs:");
        for (int i = 0; i < n; i++)
            p[i] = sc.nextInt();

        System.out.print("Enter initiator index: ");
        int init = sc.nextInt();

        int max = p[init];

        System.out.println("\nMessage Passing:");
        for (int i = 1; i < n; i++) {
            int next = (init + i) % n;

            System.out.println(
                "Process " + p[(next - 1 + n) % n] +
                " -> Process " + p[next]);

            if (p[next] > max)
                max = p[next];
        }

        System.out.println("\nCoordinator is Process " + max);
    }
} 