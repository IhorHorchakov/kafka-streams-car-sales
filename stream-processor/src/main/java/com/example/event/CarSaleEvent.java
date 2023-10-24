package com.example.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarSaleEvent {
    public String transactionId;
    public String make;
    public String model;
    public String timestamp;
    public int dealerId;
    public String dealerName;
    public int price;

    @Override
    public String toString() {
        return "CarSaleEvent{" +
                "transactionId='" + transactionId + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", dealerId=" + dealerId +
                ", dealerName='" + dealerName + '\'' +
                ", price=" + price +
                '}';
    }
}
