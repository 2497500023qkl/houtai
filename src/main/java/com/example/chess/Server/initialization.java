package com.example.chess.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class initialization {
    private ServerSocket ss;
    private Socket s;
    private InputStreamReader ois;
    private OutputStreamWriter oos;

    public InputStreamReader getOis() {
        return ois;
    }

    public void setOis(InputStreamReader ois) {
        this.ois = ois;
    }

    public OutputStreamWriter getOos() {
        return oos;
    }

    public void setOos(OutputStreamWriter oos) {
        this.oos = oos;
    }
    public void getiInitialization() throws IOException {
        ss=new ServerSocket(8088);
        s=ss.accept();
        System.out.println(s.getInetAddress().getHostAddress()+"成功连接");
        oos = new OutputStreamWriter(s.getOutputStream());
        ois = new InputStreamReader(s.getInputStream());
    }
    public void deliInitialization() throws IOException{
        ois.close();
        oos.close();
        s.close();
        ss.close();
    }
}
