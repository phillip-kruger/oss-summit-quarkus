package org.oss.summit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Inject
    private HostInfoService hostInfoService;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello (" + hostInfoService.getHostName() + ")";
    }
    
//    @GET
//    @Path("/{name}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String helloToSomeone(@PathParam("name") String name) {
//        return "hello " + name + " (" + hostInfoService.getHostName() + ")";
//    }
}