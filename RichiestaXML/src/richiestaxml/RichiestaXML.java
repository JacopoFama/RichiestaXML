package richiestaxml;

import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RichiestaXML 
{
    PrintWriter out;
    Scanner in;
    Socket socket;

    public RichiestaXML() 
    {   
        try 
        {
            socket = new Socket("129.186.122.19", 80);
            out = new PrintWriter(socket.getOutputStream(), true);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(RichiestaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
           
    
    public static void main(String[] args) 
    {
        RichiestaXML richiesta = new RichiestaXML();
        richiesta.add();
    }
    
    public void add()
    {
        out.println("POST /~engelen/calcserver.cgi HTTP/1.1");
        out.println("Host: websrv.cs.fsu.edu");
        out.println("Connection: Keep-Alive");
        out.println("Content-Type: text/xml; charset=utf-8");
        out.println();
        out.println("<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:calc\">\n" +
                    "<soapenv:Header/>\n" +
                    "<soapenv:Body>\n" +
                    "<urn:add soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                    "<a xsi:type=\"xsd:double\">?</a>\n" +
                    "<b xsi:type=\"xsd:double\">?</b>\n" +
                    "</urn:add>\n" +
                    "</soapenv:Body>\n" +
                    "</soapenv:Envelope>");
        out.flush();
        
        String ln;
        try
        {
            in = new Scanner(socket.getInputStream());
        }
        catch(Exception e)
        {
            System.out.println("errore: "+e);
        }
        
        
        while(true)
        {
            ln=in.nextLine();
            System.out.println("xml: ");
            System.out.println(ln);
        }
    }
    
    public void sub()
    {
        
    }
    
    public void mul()
    {
        
    }
    
    public void div()
    {
        
    }
    
    public void pow()
    {
        
    }
    
}
