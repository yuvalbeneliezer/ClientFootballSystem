package Client.Strategies;
import java.io.*;

public class ClientSender implements IClientStrategy {

    private StringBuilder request;

    public void setRequest(StringBuilder request) {
        this.request = request;
    }

    @Override
    public String clientStrategy(InputStream inFromServer, OutputStream outToServer) {
        String ans = null;
        try {
            ObjectOutputStream toServer = new ObjectOutputStream(outToServer);

            toServer.flush();

            //Send to Server
            toServer.writeObject(request);
            toServer.flush();

            //Receive from Server
            ObjectInputStream fromServer = new ObjectInputStream(inFromServer);
            StringBuilder answer = (StringBuilder) fromServer.readObject();
            ans = answer.toString();
            fromServer.close();
            toServer.close();
        } catch (Exception e) {

        }
        return ans;
    }
}
