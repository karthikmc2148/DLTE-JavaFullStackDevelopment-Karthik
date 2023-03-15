package card;

import javax.xml.ws.Endpoint;

public class ExecuteEnd {
    private static String url="http://localhost:8082/card";
    public static void main(String[] args) {
        Cardcrudl cardcrudl = new Cardcrudl();
        System.out.println("Webservice is running on "+url);
        Endpoint.publish(url,cardcrudl);
    }
}
