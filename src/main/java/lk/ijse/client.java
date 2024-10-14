package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {


    public static void main(String[] args) {

        try {
            //remote socket
            Socket socket = new Socket( "localhost",3000);
            System.out.println("connected");

            //data output
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            //data input
            DataInputStream in = new DataInputStream(socket.getInputStream());


            Scanner sc = new Scanner(System.in);


            while (true){
                System.out.print("Client: ");
                String clientMessage = sc.nextLine();
                out.writeUTF(clientMessage);
                out.flush();


                String serverMessage = in.readUTF();
                System.out.println("Server: " + serverMessage);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}


/*package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost" , 3000);

            while (!socket.isClosed()){
                Scanner input = new Scanner(System.in);

                System.out.println("Client :");
                String messege =input.next();
                DataOutputStream dataOutStream = new DataOutputStream(socket.getOutputStream());
                dataOutStream.writeUTF(messege);
                dataOutStream.flush();

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String rep = dataInputStream.readUTF();
                System.out.println("Server :"+rep);

            }
            socket.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}*/
