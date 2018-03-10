package com.rodrigo.TFG_cliente.Negocio.Modulo_Empleado.Entidad;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;


@XmlRootElement(name = "Usuario")
public class Empleado implements Serializable {

    protected Long id;

    private String nombre;

    protected String email;


    private String password;

    private Rol rol;


    protected long version;


    /****************************
     ******* CONSTRUCTORES ******
     ****************************/


    public Empleado(String nombre, String password, Rol rol) {
        this.nombre = nombre;
        this.password = password;
        this.email = nombre.toLowerCase().concat("@gmail.com");
        this.rol = rol;
    }


    /** Constructor
     *  Rol por defecto = Rol.EMPLEADO
     * */
    public Empleado(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        this.rol = Rol.EMPLEADO;
        this.email = nombre.toLowerCase().concat("@gmail.com");
    }

    public Empleado(Long id, String nombre, String password, String email, Rol rol, long version) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.email = email;
        this.version = version;
    }

    public Empleado(String nombre, String password, String email, Rol rol) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.email = email;

    }

    public Empleado() {
    }

    /****************************
     **** GETTERS AND SETTERS ***
     ****************************/

    @XmlElement(name = "id", required = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "nombre", required = true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "password", required = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name = "rol", required = true)
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @XmlElement(name = "version", required = true)
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @XmlElement(name = "email", required = true)
    public String getEmail() { return email;}

    public void setEmail(String email) {this.email = email;}



    /****************************
     ****** OTHER METHODS *******
     ****************************/

    @Override
    public String toString() {
        return "Usuario{" +
                "  id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", version=" + version +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado)) return false;
        Empleado empleado = (Empleado) o;
        return getVersion() == empleado.getVersion() &&
                Objects.equals(getId(), empleado.getId()) &&
                Objects.equals(getNombre(), empleado.getNombre()) &&
                Objects.equals(getEmail(), empleado.getEmail()) &&
                Objects.equals(getPassword(), empleado.getPassword()) &&
                getRol() == empleado.getRol();
    }

    public boolean equalsWithOutVersion(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado)) return false;
        Empleado empleado = (Empleado) o;
        return  Objects.equals(getId(), empleado.getId()) &&
                Objects.equals(getNombre(), empleado.getNombre()) &&
                Objects.equals(getEmail(), empleado.getEmail()) &&
                Objects.equals(getPassword(), empleado.getPassword()) &&
                Objects.equals(getRol(), empleado.getRol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getPassword(), getRol(), getVersion());
    }
}
