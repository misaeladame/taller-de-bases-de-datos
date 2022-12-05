package modelo;

public class Clientes {
    private String nombre;
    private String direccion;
    private int vendedor;

    public Clientes(String nombre, String direccion, int vendedor) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.vendedor = vendedor;
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

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }
    
    
}
