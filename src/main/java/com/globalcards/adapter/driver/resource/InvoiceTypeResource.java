package com.globalcards.adapter.driver.resource;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;


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
    public String createRequest() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/lucas.barbosa.p.reis/test.txt"));
            String line = bufferedReader.readLine();
            while( line != null ) {
                invoyceTypeRequestEmitter.send(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
