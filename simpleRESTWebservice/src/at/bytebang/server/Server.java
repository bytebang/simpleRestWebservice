package at.bytebang.server;


import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import at.bytebang.webservice.CalculatorService;

public class Server
{
   public static void main( String[] args ) throws IOException, InterruptedException 
   {
      String baseUrl = ( args.length > 0 ) ? args[0] : "http://localhost:4434";

      final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
            URI.create( baseUrl ), new ResourceConfig( CalculatorService.class ), false );
      Runtime.getRuntime().addShutdownHook( new Thread( new Runnable() {
         @Override
         public void run() {
            server.shutdownNow();
         }
      } ) );
      server.start();

      System.out.println("Grizzly-HTTP-Server started withURL: " + baseUrl + CalculatorService.webContextPath);

      Thread.currentThread().join();
   }
}