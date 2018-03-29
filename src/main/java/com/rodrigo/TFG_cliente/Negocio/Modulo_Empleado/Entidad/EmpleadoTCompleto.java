package com.rodrigo.TFG_cliente.Negocio.Modulo_Empleado.Entidad;


import com.rodrigo.TFG_cliente.Negocio.Modulo_Departamento.Entidad.Departamento;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name ="EmpleadoTCompleto")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmpleadoTCompleto extends Empleado implements Serializable {


    /****************************
     ********* ATRIBUTOS ********
     ****************************/

    @NotBlank
    private int antiguedad = 0;

    @NotBlank
    private int sueldoBase = 1200;



    /****************************
     ******* CONSTRUCTORES ******
     ****************************/

    public EmpleadoTCompleto() {
    }

    public EmpleadoTCompleto(String nombre, String password, Rol rol) {
        super(nombre, password, rol);
        this.departamento = new Departamento();
    }
    public EmpleadoTCompleto(String nombre, String password, Rol rol, Departamento d) {
        super(nombre, password, rol);
        this.departamento = d;
    }

    public EmpleadoTCompleto(EmpleadoTCompleto e) {
        super(e);
        antiguedad = e.antiguedad;
        sueldoBase = e.sueldoBase;
    }


    /****************************
     ********** METODOS *********
     ****************************/

    @Override
    public double calcularNominaMes() {
        return sueldoBase+sueldoBase*0.05*antiguedad;
    }


    /****************************
     **** GETTERS AND SETTERS ***
     ****************************/


    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return "EmpleadoTCompleto{" +
                "antiguedad=" + antiguedad +
                ", sueldoBase=" + sueldoBase +
                "} " + super.toString();
    }

    @Override
    public Object onCycleDetected(Context cycleRecoveryContext) {
        // Context provides access to the Marshaller being used:
        //System.out.println("JAXB Marshaller is: " + cycleRecoveryContext.getMarshaller());

        EmpleadoTCompleto e = new EmpleadoTCompleto(this);
        return e;
    }
}