import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;

class ReverseClient
{
    
    public static void main(String args[])
    {
        Reverse ReverseImpl=null;
        
        try
        {
            // initialize the ORB object request broker
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	   
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            String name = "Reverse";

           // narrow converts generic object into string type 
            ReverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Enter String=");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str= br.readLine();

            String tempStr= ReverseImpl.reverse_string(str);
        
            System.out.println(tempStr);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

/*
 * cmds:
 * sudo apt-get remove openjdk*
 * sudo apt update
 * sudo apt install openjdk-8-jdk openjdk-8-jre
 * Terminal1:
 * 
 * idlj -fall ReverseModule.idl
 * javac .java ReverseModule/.java
 * orbd -ORBInitialPort 1056&
 * java ReverseServer -ORBInitiaPort 1056&
 * Reverse Object Created
 * 
 * Terminal2:
 * java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost
 */
