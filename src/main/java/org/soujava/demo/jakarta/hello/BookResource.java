package org.soujava.demo.jakarta.hello;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@ApplicationScoped
@Path("books")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class BookResource {

    @Inject
    private NextReadBookService nextReadBookService;

    @POST
    public NextReadBooks recommend(BookRequest request) {
        return nextReadBookService.recommend(request);
    }
}
