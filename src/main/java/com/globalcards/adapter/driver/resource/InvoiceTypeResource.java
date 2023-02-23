package com.globalcards.adapter.driver.resource;

import com.globalcards.adapter.infrastructure.entity.InvoiceType;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("invoice-type")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Slf4j
public class InvoiceTypeResource {

    @Channel("invoice-requests")
    Emitter<String> invoyceTypeRequestEmitter;

    @POST
    @Path("/emit")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequest(InvoiceType invoiceType) {
        invoyceTypeRequestEmitter.send(invoiceType.name);
        return invoiceType.name;
    }

}
