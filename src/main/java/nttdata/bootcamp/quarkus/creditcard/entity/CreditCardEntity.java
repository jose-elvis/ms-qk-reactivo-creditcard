package nttdata.bootcamp.quarkus.creditcard.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

@MongoEntity(collection="creditcard")
public class CreditCardEntity extends ReactivePanacheMongoEntity {

    private ObjectId id;
    private String descripcion;
    private double creditLimit;
    private double balanceAvailable;
    private String creditCardNumber;
    private int cvv;
    private String expirationDate;
    private String closingDate;
    private String lastOfPay;

    public CreditCardEntity(){}
    public CreditCardEntity(ObjectId id, String descripcion, double creditLimit, double balanceAvailable, String creditCardNumber, int cvv, String expirationDate, String closingDate, String lastOfPay) {
        this.id = id;
        this.descripcion = descripcion;
        this.creditLimit = creditLimit;
        this.balanceAvailable = balanceAvailable;
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.closingDate = closingDate;
        this.lastOfPay = lastOfPay;
    }
    public ObjectId getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getBalanceAvailable() {
        return balanceAvailable;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public String getLastOfPay() {
        return lastOfPay;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setBalanceAvailable(double balanceAvailable) {
        this.balanceAvailable = balanceAvailable;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public void setLastOfPay(String lastOfPay) {
        this.lastOfPay = lastOfPay;
    }
    public static Multi<CreditCardEntity> streamAllUsers() {
        return streamAll();
    }
    public static Uni<CreditCardEntity> findUserById(String id) {
        return CreditCardEntity.findById(new ObjectId(id));
    }
    public static Uni<Boolean> deleteById(String id) {
        return CreditCardEntity.deleteById(new ObjectId(id));
    }
}