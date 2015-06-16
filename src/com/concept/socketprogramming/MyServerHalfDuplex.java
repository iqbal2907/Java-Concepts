package com.concept.socketprogramming;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerHalfDuplex {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();// establishes connection
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = dis.readUTF();
			System.out.println("message= " + str);
			ss.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
