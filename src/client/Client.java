/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author uqjmeng2
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import java.util.*;
public class Client {
   public static void main(String[] args) {
      try {
         Socket s = new Socket("127.0.0.1",8899);
         
         //构建IO
         InputStream is = s.getInputStream();
         OutputStream os = s.getOutputStream();
         
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
         //向服务器端发送一条消息
         bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
         bw.flush();
         
         //读取服务器返回的消息
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
         String mess = br.readLine();
         System.out.println("服+务+器："+mess);
         s.close();
      }
      catch (ConnectException e){
          System.out.println(e.toString());
     
      }
      catch (UnknownHostException e) {   
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("good!");
         
         
      } 
   }
}