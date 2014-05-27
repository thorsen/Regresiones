package es.ramondin.view.beans.backing;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.faces.bi.component.graph.Annotation;
import oracle.adf.view.faces.bi.component.graph.AnnotationSet;
import oracle.adf.view.faces.bi.component.graph.UIGraph;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class PruebaBacking {
    private UIGraph comboGraph1;
    private String valorK;
    private String valorP;
    private String valoresX;
    private String valoresY;
    private String funcionY;
    private String valorX;
    private String valorXCalculado;
    private String valorY;
    private String valorYCalculadoKP;
    private String valorYCalculadoX;

    public PruebaBacking() {
        valorK = "0.5";
        valorP = "0.25";
        
        valoresX = "-2269.41; -1269.41; -269.41; 730.59; 1730.59; 2730.59";
        valoresY = "1.0; 0.83333333333333333333333333333333; 0.75; 0.41666666666666666666666666666667; 0.16666666666666666666666666666667; 0.08333333333333333333333333333333";
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void calcularRegresion(ActionEvent actionEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("obtenerRegresion");
        operationBinding.execute();

        operationBinding = bindings.getOperationBinding("getFuncionY");
        setFuncionY((String)operationBinding.execute());

        //Añadimos las anotaciones
        if (comboGraph1.getAnnotationSet() == null)
            comboGraph1.setAnnotationSet(new AnnotationSet());

        Map annotationMap = null;
        //        annotationMap = comboGraph1.getAnnotationSet().getAnnotationMap();
        //        if(annotationMap == null){
        annotationMap = new HashMap();
        comboGraph1.getAnnotationSet().setAnnotationMap(annotationMap);
        //        }

        Annotation annotation = new Annotation();
        annotation.setSeries(1);
        annotation.setGroup(0);
        annotation.setText(getFuncionY());
        annotationMap.put(0, annotation);

        //AdfFacesContext.getCurrentInstance().addPartialTarget(comboGraph1);
    }

    public void obtenerValorYParaKP(ActionEvent actionEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("getValorYParaKP");
        setValorYCalculadoKP((String)operationBinding.execute());
    }

    public void obtenerValorX(ActionEvent actionEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("getValorXParaY");
        setValorXCalculado((String)operationBinding.execute());
    }
    
    public void obtenerValorYParaX(ActionEvent actionEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("getValorYParaX");
        setValorYCalculadoX((String)operationBinding.execute());
    }

    public void setComboGraph1(UIGraph comboGraph1) {
        this.comboGraph1 = comboGraph1;
    }

    public UIGraph getComboGraph1() {
        return comboGraph1;
    }

    public void setValorK(String valorK) {
        this.valorK = valorK;
    }

    public String getValorK() {
        return valorK;
    }

    public void setValorP(String valorP) {
        this.valorP = valorP;
    }

    public String getValorP() {
        return valorP;
    }

    public void setValoresX(String valoresX) {
        this.valoresX = valoresX;
    }

    public String getValoresX() {
        return valoresX;
    }

    public void setValoresY(String valoresY) {
        this.valoresY = valoresY;
    }

    public String getValoresY() {
        return valoresY;
    }

    public void setFuncionY(String valorY) {
        this.funcionY = valorY;
    }

    public String getFuncionY() {
        return funcionY;
    }

    public void setValorX(String valorX) {
        this.valorX = valorX;
    }

    public String getValorX() {
        return valorX;
    }

    public void setValorY(String valorY) {
        this.valorY = valorY;
    }

    public String getValorY() {
        return valorY;
    }

    public void setValorYCalculadoKP(String valorYCalculado) {
        this.valorYCalculadoKP = valorYCalculado;
    }

    public String getValorYCalculadoKP() {
        return valorYCalculadoKP;
    }

    public void setValorXCalculado(String valorXCalculado) {
        this.valorXCalculado = valorXCalculado;
    }

    public String getValorXCalculado() {
        return valorXCalculado;
    }

    public void setValorYCalculadoX(String valorYCalculadoX) {
        this.valorYCalculadoX = valorYCalculadoX;
    }

    public String getValorYCalculadoX() {
        return valorYCalculadoX;
    }
}
