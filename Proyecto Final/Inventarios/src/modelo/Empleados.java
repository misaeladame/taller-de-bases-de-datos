package modelo;

public class Empleados {
    private int id;
    private String nombre;
    private String direccion;
    private String rfc;
    private String curp;
    private int ncontrol;
    private int supervisor;

    public Empleados(int id, String direccion, String nombre, String rfc, String curp , int ncontrol, int supervisor) {
        this.id = id;
        this.direccion = direccion;
        this.nombre = nombre;
        this.rfc = rfc;
        this.curp = curp;
        this.ncontrol = ncontrol;
        this.supervisor = supervisor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getNcontrol() {
        return ncontrol;
    }

    public void setNcontrol(int ncontrol) {
        this.ncontrol = ncontrol;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
