package nttdata.bootcamp.quarkus.creditcard;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nttdata.bootcamp.quarkus.creditcard.entity.CreditCardEntity;
import org.bson.types.ObjectId;

@Path("/api/creditcard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class CreditCardResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<CreditCardEntity> userList() {
        return CreditCardEntity.streamAllUsers();
    }
    @POST
    public Uni<Response> addCreditCard(CreditCardEntity user) {
        return user.persist().
                map(r -> Response.accepted().build());
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<CreditCardEntity> findUserById(@PathParam("id") String id) {
        return CreditCardEntity.findUserById(id);
    }
    @DELETE
    @Path("{id}")
    public Uni<Boolean> deleteUserById(@PathParam("id") String id) {
        return CreditCardEntity.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<Response> updateUserById(@PathParam("id") String id,CreditCardEntity user) {
        user.setId(new ObjectId(id));
        return user.update().
                map(r -> Response.accepted().build());
    }
}
