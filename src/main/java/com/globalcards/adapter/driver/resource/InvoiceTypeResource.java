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
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;


@Path("invoice-type")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Slf4j
public class InvoiceTypeResource {
    @Channel("sends")
    Emitter<String> invoyceTypeRequestEmitter;

    @POST
    @Path("/emit")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequest() {
        UUID uuid = UUID.randomUUID();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/lucas.barbosa.p.reis/test.txt"));

            invoyceTypeRequestEmitter.send(bufferedReader.readLine());
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return uuid.toString();
    }
}
