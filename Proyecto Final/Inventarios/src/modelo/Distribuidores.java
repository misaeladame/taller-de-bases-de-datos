package modelo;

public class Distribuidores {
    private int id;
    private String direccion;
    private String nombre;

    public Distribuidores(int id, String direccion, String nombre) {
        this.id = id;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
