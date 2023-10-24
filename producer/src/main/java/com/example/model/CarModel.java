package com.example.model;

public enum CarModel {
    /* BMW */
    SERIES_3, SERIES_4, SERIES_5, X_3, X_5, X_6,

    /* MERCEDES */
    A_CLASS, C_CLASS, E_CLASS, G_CLASS, S_CLASS, GLA, GLC,

    /* AUDI */
    A_4, A_3, A_6, A_8, RS_3, RS_5, TT, Q_5,

    /* VW */
    GOLF, JETTA, PASSAT, TIGUAN, TOUAREG,

    /* TOYOTA */
    PRIUS, COROLLA, CAMRY, C_HR, RAV_4, HIGHLANDER,

    /* HONDA */
    CIVIC, ACCORD, C_RV, H_RV,

    /* LEXUS */
    RC, LC, LS, ES, RX, NX;

    public String getCaption() {
        return this.name();
    }
}
