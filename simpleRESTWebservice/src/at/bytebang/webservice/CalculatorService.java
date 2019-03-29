package at.bytebang.webservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( CalculatorService.webContextPath )
public class CalculatorService
{
   public static final String webContextPath = "/calculator";

   @GET @Path("/add") @Produces( MediaType.TEXT_PLAIN )
   public float add(@QueryParam("a") float a, @QueryParam("b") float b)
   {
       return a+b;
   }

   @GET @Path("/subtract") @Produces( MediaType.TEXT_PLAIN )
   public float subtract(@QueryParam("a") float a, @QueryParam("b") float b)
   {
       return a-b;
   }

   @GET @Path("/multiply") @Produces( MediaType.TEXT_PLAIN )
   public float multiply(@QueryParam("a") float a, @QueryParam("b") float b)
   {
       return a*b;
   }

   @GET @Path("/divide") @Produces( MediaType.TEXT_PLAIN )
   public float divide(@QueryParam("a") float a, @QueryParam("b") float b)
   {
       // Example http://localhost:4434/calculator/divide?a=5&b=3
       return a/b;
   }
}