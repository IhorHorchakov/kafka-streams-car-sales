package com.example.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static com.example.model.CarModel.ACCORD;
import static com.example.model.CarModel.A_3;
import static com.example.model.CarModel.A_4;
import static com.example.model.CarModel.A_6;
import static com.example.model.CarModel.A_8;
import static com.example.model.CarModel.A_CLASS;
import static com.example.model.CarModel.CAMRY;
import static com.example.model.CarModel.CIVIC;
import static com.example.model.CarModel.COROLLA;
import static com.example.model.CarModel.C_CLASS;
import static com.example.model.CarModel.C_HR;
import static com.example.model.CarModel.C_RV;
import static com.example.model.CarModel.ES;
import static com.example.model.CarModel.E_CLASS;
import static com.example.model.CarModel.GLA;
import static com.example.model.CarModel.GLC;
import static com.example.model.CarModel.GOLF;
import static com.example.model.CarModel.G_CLASS;
import static com.example.model.CarModel.HIGHLANDER;
import static com.example.model.CarModel.H_RV;
import static com.example.model.CarModel.JETTA;
import static com.example.model.CarModel.LC;
import static com.example.model.CarModel.LS;
import static com.example.model.CarModel.NX;
import static com.example.model.CarModel.PASSAT;
import static com.example.model.CarModel.PRIUS;
import static com.example.model.CarModel.Q_5;
import static com.example.model.CarModel.RAV_4;
import static com.example.model.CarModel.RC;
import static com.example.model.CarModel.RS_3;
import static com.example.model.CarModel.RS_5;
import static com.example.model.CarModel.RX;
import static com.example.model.CarModel.SERIES_3;
import static com.example.model.CarModel.SERIES_4;
import static com.example.model.CarModel.SERIES_5;
import static com.example.model.CarModel.S_CLASS;
import static com.example.model.CarModel.TIGUAN;
import static com.example.model.CarModel.TOUAREG;
import static com.example.model.CarModel.TT;
import static com.example.model.CarModel.X_3;
import static com.example.model.CarModel.X_5;
import static com.example.model.CarModel.X_6;

public enum CarMake {
    BMW(SERIES_3, SERIES_4, SERIES_5, X_3, X_5, X_6),
    MERCEDES(A_CLASS, C_CLASS, E_CLASS, G_CLASS, S_CLASS, GLA, GLC),
    AUDI(A_4, A_3, A_6, A_8, RS_3, RS_5, TT, Q_5),
    VW(GOLF, JETTA, PASSAT, TIGUAN, TOUAREG),
    TOYOTA(PRIUS, COROLLA, CAMRY, C_HR, RAV_4, HIGHLANDER),
    HONDA(CIVIC, ACCORD, C_RV, H_RV),
    LEXUS(RC, LC, LS, ES, RX, NX);

    CarMake(CarModel... models) {
        this.models = Arrays.asList(models);
    }

    @Getter
    public List<CarModel> models;

}
