import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
        public static void main(String[] args) {
            try {
                String host = "localhost";
                String servermessage;
                Socket meinEchoSocket = new Socket(host,3000);

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(meinEchoSocket.getOutputStream()));
                BufferedReader br = new BufferedReader(new InputStreamReader(meinEchoSocket.getInputStream()));
                Scanner scanner = new Scanner(System.in);

                servermessage = br.readLine();
                System.out.println(servermessage);

                String clientMessage = scanner.nextLine();
                bw.write(clientMessage);
                bw.newLine();
                bw.flush();

                servermessage = br.readLine();
                System.out.println(servermessage);

                bw.close();
                br.close();
                meinEchoSocket.close();
            } catch (UnknownHostException uhe) {
              System.out.println(uhe);
            }
            catch (IOException ioe) {
              System.out.println(ioe);
            }
        }
}
