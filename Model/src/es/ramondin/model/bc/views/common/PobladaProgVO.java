package es.ramondin.model.bc.views.common;

import java.math.BigDecimal;

import java.util.ArrayList;

import oracle.jbo.ViewObject;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Apr 01 17:54:32 CEST 2014
// ---------------------------------------------------------------------
public interface PobladaProgVO extends ViewObject {
    String getFuncionY();


    void obtenerRegresion(String valoresX, String valoresY);

    String getValorYParaX(String valorX);

    String getValorYParaKP(String valorK, String valorP);

    String getValorXParaY(String valorY);
}
