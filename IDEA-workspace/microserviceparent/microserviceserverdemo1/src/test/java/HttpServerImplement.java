import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * @ClassName HttpServerImplement
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/15 19:31
 * @Version 1.0
 **/
public class HttpServerImplement {

    public static void main(String[] args) throws IOException {

        HttpServerThread httpServerThread = new HttpServerThread();
        httpServerThread.start();


    }


}
