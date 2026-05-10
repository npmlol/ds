import java.util.*;

public class berkelyshort {

    public static void main(String args[]) {
// define scanner sc object form scanner class to read any input from terminal 
        Scanner sc = new Scanner(System.in);
// mention serve time and stor it in variable servertime
        int sh = 10, sm = 0, ss = 0;

        int serverTime = sh * 3600 + sm * 60 + ss;
// take input number of nodes using sc and nxtInt funcrion for the biult in scanner calss
        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        //declare array to store node rime and diff ,len of array = number of nodes 
        int nodeTime[] = new int[n];
        int diff[] = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("Enter hours:");
            int h = sc.nextInt();

            System.out.println("Enter minutes:");
            int m = sc.nextInt();

            System.out.println("Enter seconds:");
            int s = sc.nextInt();

            nodeTime[i] = h * 3600 + m * 60 + s;

            diff[i] = nodeTime[i] - serverTime;

            System.out.println("Difference of Node "
                    + (i + 1) + " = " + diff[i]);

            sum += diff[i];
        }

        int avg = sum / (n + 1);

        System.out.println("Average difference = " + avg);

        int synchronizedTime = serverTime + avg;

        System.out.println("\nSynchronized Clocks:");

        int h = synchronizedTime / 3600;
        int m = (synchronizedTime % 3600) / 60;
        int s = synchronizedTime % 60;

        System.out.println("Server = "
                + h + ":" + m + ":" + s);

        for (int i = 0; i < n; i++) {

            System.out.println("Node "
                    + (i + 1) + " = "
                    + h + ":" + m + ":" + s);
        }
    }
}