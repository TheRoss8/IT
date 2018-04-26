package gq.francescorossato.mailclient.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Pop3Client {

    private final InetAddress serverAddress;
    private final int port;

    private String user;
    private String password;

    private Socket socket;
    private BufferedReader input;
    private PrintWriter out;


    public Pop3Client(String user, String password, InetAddress serverAddress) throws UnknownHostException {
        this.serverAddress = serverAddress;
        port = 110;
        this.user = user;
        this.password = password;
    }
    public Pop3Client() throws UnknownHostException {
        this(null, null, null);
    }

    public boolean connect() throws IOException {
        boolean isConnected = false;
        socket = new Socket(serverAddress, port);

        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        String answer = input.readLine();
        if (answer.contains(Interact.OK)) {
            out.println(Interact.IN_USER + user);
            answer = input.readLine();

            if (answer.contains(Interact.OK)) {
                out.println(Interact.IN_PASSWORD + password);
                answer = input.readLine();
                if (answer.contains(Interact.OK))
                    isConnected = true;
            }

        }
        return isConnected;
    }
    public void disconnect() throws IOException{
        if(socket != null){
            out.println(Interact.QUIT);
            String answer = input.readLine();
            if(answer.contains(Interact.OK))
                socket.close();
        }
    }
    public int getNumOfMessages() throws IOException {
        int num = 0;
        String answer;
        out.println(Interact.MSG_NUMBER);
        answer = input.readLine();
        if (answer.contains(Interact.OK))
            num = Integer.parseInt(answer.split(" ")[1]);
        return num;
    }
    public ObservableList getMessages() throws IOException {
        ObservableList<Message> messages = FXCollections.observableArrayList();
        int num = getNumOfMessages();
        for(int i = 0; i < num; i++)
            messages.add(new Message());
        for(int i = 0; i < messages.size(); i++) {
            boolean isMessage = false;
            out.println(Interact.GET_MSG + String.valueOf(i + 1));
            String answer = input.readLine();
            StringBuilder message = new StringBuilder();
            while(!answer.equals(".")){
                if(answer.startsWith("From: ")) {
                    Message temp = messages.get(i);
                    temp.setFrom(answer.replace("From: ", ""));
                    messages.set(i, temp);
                }
                else {
                    if (answer.startsWith("Date: ")) {
                        Message temp = messages.get(i);
                        temp.setDate(answer.replace("Date: ", ""));
                        messages.set(i, temp);
                    }
                    else {
                        if (answer.startsWith("To: ")) {
                            Message temp = messages.get(i);
                            temp.setTo(answer.replace("To: ", ""));
                            messages.set(i, temp);
                        }
                        else
                            if (answer.startsWith("Subject: ")) {
                                Message temp = messages.get(i);
                                temp.setSubject(answer.replace("Subject: ", ""));
                                messages.set(i, temp);
                                isMessage = true;
                            }
                    }
                }
                if(isMessage)
                    message.append(answer);
                System.out.println(answer);
                answer = input.readLine();
            }
            Message temp = messages.get(i);
            temp.setMessage(message.toString());
            messages.set(i, temp);
        }
        return messages;

    }
    public boolean delete(int message) throws IOException {
        out.println(Interact.DEL_MSG + message);
        return input.readLine().contains(Interact.OK);
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }





}
