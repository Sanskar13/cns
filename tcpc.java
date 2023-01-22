// package labcn;

import java.util.*;
import java.io.*;
import java.net.*;

class tcpc {
    public static void main(String args[]) {

        try {
            Socket client = new Socket("192.168.1.8", 1537);
            BufferedReader k = new BufferedReader(new InputStreamReader(System.in));

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
                System.out.println("File not found");
            }

            client.close();
        } catch (Exception e) {
        }
    }
}
