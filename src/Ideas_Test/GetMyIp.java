package Ideas_Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetMyIp {
    public static void main(String[] args) throws UnknownHostException {


        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip);
    }
}
