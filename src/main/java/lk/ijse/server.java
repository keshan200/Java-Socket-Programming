package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {

        try {
            //server socket
            System.out.println("waiting for client >>>>>");
            ServerSocket serverSocket = new ServerSocket(3000);


            //local socket
            Socket socket = serverSocket.accept();
            System.out.println("client connected");

            //data output
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            //data input
            DataInputStream in = new DataInputStream(socket.getInputStream());


            Scanner sc = new Scanner(System.in);


            while (true){
                String clientMessage = in.readUTF();
                System.out.println("Client: " + clientMessage);


                System.out.print("Server: ");
                String serverMessage = sc.nextLine();
                out.writeUTF(serverMessage);
                out.flush();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        try {
            System.out.println("waiting for client");
            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept();

            while (!socket.isClosed()){
                System.out.println("Client accepted");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                String msg = dataInputStream.readUTF();
                System.out.println("Client " + msg);


                Scanner input = new Scanner(System.in);
                System.out.println("Server :");
                String mm =input.next();
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(mm);
                dataOutputStream.flush();

            }
            socket.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}*/
