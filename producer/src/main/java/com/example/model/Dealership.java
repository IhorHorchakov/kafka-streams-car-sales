package com.example.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static com.example.model.CarMake.AUDI;
import static com.example.model.CarMake.BMW;
import static com.example.model.CarMake.HONDA;
import static com.example.model.CarMake.LEXUS;
import static com.example.model.CarMake.MERCEDES;
import static com.example.model.CarMake.TOYOTA;
import static com.example.model.CarMake.VW;

@Getter
public enum Dealership {
    BMW_FLORIDA(0, "Braman Motorcars, Florida", BMW),
    BMW_CALIFORNIA(1, "Pacific BMW - Glendale, California", BMW),
    MERCEDES_BROOKLYN(2, "Mercedes-Benz of Brooklyn", MERCEDES),
    MERCEDES_BURLINGTON(3, "Mercedes-Benz Dealership | Burlington, ON", MERCEDES),
    MERCEDES_ORLAND(4, "Mercedes-Benz of Orland Park", MERCEDES),
    AUDI_LOS_ANGELES(5, "Los Angeles Audi Dealer ", AUDI),
    AUDI_ATLANTA(6, "Audi Atlanta", AUDI),
    VW_SANTA_MONICA(7, "Volkswagen Santa Monica", VW),
    VW_LOS_ANGELES(8, "Volkswagen Dealership in Los Angeles", VW),
    TOYOTA_FLORIDA(9, "Toyota Dealership in Hollywood, Florida", TOYOTA),
    LEXUS_FLORIDA(10, "JM Lexus in Margate, Florida", TOYOTA, LEXUS),
    HONDA_FLORIDA(11, "Honda Dealership in Miami, Florida", HONDA),
    HONDA_TENNESSEE(12, "Used Honda Dealership in Cookeville, Tennessee", HONDA);

    private final int id;
    private final String caption;
    private final List<CarMake> carMakeList;

    Dealership(int id, String caption, CarMake... carMake) {
        this.id = id;
        this.caption = caption;
        this.carMakeList = Arrays.asList(carMake);
    }

    public String getFullInformation() {
        return "Dealership{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", carMakeList=" + carMakeList +
                '}';
    }
}
