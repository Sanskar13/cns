
import java.util.*;
import java.net.*;

public class crc {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        String gen = sc.nextLine();

        int[] data = new int[msg.length() + gen.length() - 1];
        int[] div = new int[gen.length()];

        for (int i = 0; i < msg.length(); i++) {
            data[i] = Integer.parseInt(msg.charAt(i) + "");
        }
        for (int i = 0; i < gen.length(); i++) {
            div[i] = Integer.parseInt(gen.charAt(i) + "");
        }

        for (int i = 0; i < msg.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < gen.length(); j++) {
                    data[i + j] ^= div[j];
                }
            }
        }

        for (int i = 0; i < msg.length(); i++) {
            data[i] = Integer.parseInt(msg.charAt(i) + "");
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "");
        }
        System.out.println("\n");

        // Receiver Side

        msg = sc.nextLine();
        gen = sc.nextLine();

        data = new int[msg.length() + gen.length() - 1];
        div = new int[gen.length()];

        for (int i = 0; i < msg.length(); i++) {
            data[i] = Integer.parseInt(msg.charAt(i) + "");
        }
        for (int i = 0; i < gen.length(); i++) {
            div[i] = Integer.parseInt(gen.charAt(i) + "");
        }

        for (int i = 0; i < msg.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < gen.length(); j++) {
                    data[i + j] ^= div[j];
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                flag = false;
                break;
            }
        }

        if (!flag)
            System.out.println("Invalid");
        else
            System.out.println("valid");
    }
}
