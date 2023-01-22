
import java.util.*;
import java.io.*;
import java.net.*;

public class tcpclient {
    public static void main(String args[]) {

        try {
            Socket client = new Socket("192.168.1.8", 1537);
            BufferedReader k = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter file location");
            String filename = k.readLine();

            DataOutputStream senttoserver = new DataOutputStream(client.getOutputStream());
            senttoserver.writeBytes(filename + "\n");

            BufferedReader i = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String string = i.readLine();
            if (string.equalsIgnoreCase("Yes")) {
                while ((string = i.readLine()) != null) {
                    System.out.println(string);
                }
            } else {
                System.out.println("file not found");
            }

            client.close();
            k.close();
            senttoserver.close();
            i.close();
        } catch (Exception ex) {
        }
    }
}
