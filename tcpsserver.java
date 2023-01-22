import java.util.*;
import java.io.*;
import java.net.*;

public class tcpsserver {
    public static void main(String args[]) {
        try {
            ServerSocket se = new ServerSocket(1537);
            System.out.println("Server Waiting");

            Socket server = se.accept();
            System.out.println("Connection established");

            BufferedReader k = new BufferedReader(new InputStreamReader(server.getInputStream()));
            String filename = k.readLine();

            FileReader f = null;
            BufferedReader ff = null;
            DataOutputStream sentoClient = new DataOutputStream(server.getOutputStream());

            File file = new File(filename);
            System.out.println(file);

            if (file.exists()) {
                sentoClient.writeBytes("Yes\n");
                f = new FileReader(filename);
                ff = new BufferedReader(f);
                String string;

                while ((string = ff.readLine()) != null) {
                    sentoClient.writeBytes(string + "\n");
                }
            } else {
                sentoClient.writeBytes("No");
            }

            se.close();
        } catch (Exception ex) {
        }
    }
}
