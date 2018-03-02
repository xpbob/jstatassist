package com.xp.agent.main;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.xp.agent.DirectMemoryCollector;

public class Main {
	public static void agentmain(String args) {
		PrintWriter pw = null;
		Socket accept = null;
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(6161);
			accept = ss.accept();
			pw = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()));
			pw.println(DirectMemoryCollector.getString());
		} catch (Exception e) {

		} finally {
			if (pw != null) {
				pw.close();
			}
			if (accept != null) {
				try {
					accept.close();
				} catch (IOException e) {

				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {

				}
			}
		}

	}

	public static void main(String[] args) {
		agentmain(null);
	}
}
