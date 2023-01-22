// package labcn;

import java.net.*;
import java.io.*;
import java.util.*;

class tcps {
    public static void main(String args[]) {
        try {
            ServerSocket se = new ServerSocket(1537);
            System.out.println("Server Waiting");

            Socket server = se.accept();
            System.out.println("Connection Established");

            BufferedReader k = new BufferedReader(new InputStreamReader(server.getInputStream()));

            String filename = k.readLine();
            FileReader f = null;
            BufferedReader ff = null;

            DataOutputStream sendtoclient = new DataOutputStream(server.getOutputStream());

            File file = new File(filename);
            System.out.println(file);
            if (file.exists()) {
                sendtoclient.writeBytes("Yes\n");
                f = new FileReader(filename);
                ff = new BufferedReader(f);
                String string;

                while ((string = ff.readLine()) != null) {
                    sendtoclient.writeBytes(string + "\n");
                }
            } else {
                sendtoclient.writeBytes("No\n");
            }

            k.close();
            sendtoclient.close();
            f.close();
            ff.close();
            se.close();

        } catch (Exception e) {
        }
        ;
    }
}