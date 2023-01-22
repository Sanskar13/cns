import java.util.*;
import java.net.*;

public class LeakyBucket {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numeber of time intervals");
        int n = sc.nextInt();
        int t[] = new int[n];
        for (int i = 0; i < n; i++)
            t[i] = sc.nextInt();

        System.out.println("Enter i and l");
        int i = sc.nextInt();
        int l = sc.nextInt();

        int lct = t[0];
        int x = 0, y = 0;
        for (int j = 0; j < n; j++) {
            y = x - (t[j] - lct);
            if (y > 1) {
                System.out.println("Non Conformal Packet " + t[j]);
            } else {
                x = y + i;
                lct = t[j];
                System.out.println("Conformal Packet " + t[j]);
            }
        }
    }
}
