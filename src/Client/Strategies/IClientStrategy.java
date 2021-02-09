package Client.Strategies;
import java.io.InputStream;
import java.io.OutputStream;

public interface IClientStrategy {
    String clientStrategy(InputStream inFromServer, OutputStream outToServer);
}
