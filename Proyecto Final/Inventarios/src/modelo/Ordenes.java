package modelo;

public class Ordenes {
    private int id;
    private int idpro;
    private int cli_id;
    private String forden;
    private int total;

    public Ordenes(int id, int idpro, int cli_id, String forden, int total) {
        this.id = id;
        this.idpro = idpro;
        this.cli_id = cli_id;
        this.forden = forden;
        this.total = total;
    }

    
    public String getForden() {
        return forden;
    }

    public void setForden(String forden) {
        this.forden = forden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
