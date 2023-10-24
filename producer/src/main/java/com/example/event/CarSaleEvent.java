package com.example.event;

import com.example.model.CarMake;
import com.example.model.CarModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarSaleEvent {
    public String transactionId;
    public CarMake make;
    public CarModel model;
    public String timestamp;
    public int dealerId;
    public String dealerName;
    public int price;

    @Override
    public String toString() {
        return "CarSaleEvent{" +
                "transactionId='" + transactionId + '\'' +
                ", make=" + make +
                ", model=" + model +
                ", timestamp='" + timestamp + '\'' +
                ", dealerId=" + dealerId +
                ", dealerName='" + dealerName + '\'' +
                ", price=" + price +
                '}';
    }
}
