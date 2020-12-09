package com.users;

import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransport;

public class Main  {
    public static void main(String[] args) throws Exception{

         UserAPIs.Processor processor = new UserAPIs.Processor(new UserAPIs.Iface() {
            public void saveUser(User user) throws TException {
                System.out.println("saveUser: " + user.toString());
            }

             public String ping() throws TException {
                 return "pong";
             }
         });

        TServerTransport serverTransport = new TServerSocket(9090);
        TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
        server.serve();
    }
}
