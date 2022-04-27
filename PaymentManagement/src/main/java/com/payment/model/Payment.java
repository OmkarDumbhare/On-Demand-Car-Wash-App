package com.payment.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "payments")
public class Payment {

    @Id
    private ObjectId id;
    private int paymentId;
    private String customerName;
    private String washerName;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
    private LocalDateTime paymentDate;
    private String review;
    private int rating;

    @Override
    public String toString() {
        return "Hey " + customerName + "! \n " +
                " Payment Receipt for your Recent CAR WASH ! " + "\n " +
                " customerName  : " + customerName + " \n " +
                " washerName    : " + washerName + " \n " +
                " orderId       : " + orderId + " \n " +
                " paymentId     : " + paymentId + " \n " +
                " transactionId : " + transactionId + " \n " +
                " paymentStatus : " + paymentStatus + " \n " +
                " amount        : " + amount + " \n " +
                " paymentDate   : " + paymentDate + " \n " +
                " review        : " + review + " \n " +
                " rating        : " + rating + " \n ";
    }
}
