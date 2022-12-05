package modelo;

public class Empleados {
    private String nombre;
    private String direccion;
    private String rfc;
    private String curp;
    private String fnac;
    private int ncontrol;
    private int supervisor;

    public Empleados(String nombre, String direccion, String rfc, String curp, String fnac, int ncontrol, int supervisor) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.rfc = rfc;
        this.curp = curp;
        this.fnac = fnac;
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

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
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
    
    
}
