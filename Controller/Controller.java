import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Controller {
  public static void main(String[] args) throws Exception {
    
    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
    server.createContext("/addUser", new addUser());
    server.setExecutor(null); // creates a default executor
    server.start();
    System.out.println("The server is running");
  }

  static class addUser implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
      Map <String,String>parms = Controller.queryToMap(httpExchange.getRequestURI().getQuery());
      System.out.println(parms);
      /*
       * TODO: CONNECT YOUR DATABASE
       */
      StringBuilder response = new StringBuilder();
      response.append("<html><body>");
      response.append("We got your request." + "<br/>");
      response.append("Add new User" + "<br/>");
      response.append("</body></html>");
      Controller.writeResponse(httpExchange, response.toString());
    }
  }
  public static void writeResponse(HttpExchange httpExchange, String response) throws IOException {
    httpExchange.sendResponseHeaders(200, response.length());
    OutputStream os = httpExchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }
  /**
   * returns the url parameters in a map
   * @param query
   * @return map
   */
  public static Map<String, String> queryToMap(String query){
    Map<String, String> result = new HashMap<String, String>();
    for (String param : query.split("&")) {
        String pair[] = param.split("=");
        if (pair.length>1) {
            result.put(pair[0], pair[1]);
        }else{
            result.put(pair[0], "");
        }
    }
    return result;
  }
}