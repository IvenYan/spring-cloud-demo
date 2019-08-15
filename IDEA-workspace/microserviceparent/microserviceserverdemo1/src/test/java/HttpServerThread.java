import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName HttpServerThread
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/15 19:35
 * @Version 1.0
 **/
public class HttpServerThread  extends Thread{

//    public static

    @Override
    public void run() {
//        while (true){

            try {
                HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
                httpServer.createContext("/test",new TestHandler());
                httpServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }

    }

    public static class TestHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,1000,5000,);
            executorService

            String response="response success";
            httpExchange.sendResponseHeaders(200,0);
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
