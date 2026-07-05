package ec.edu.uce.miproyecto.dominio;

public class Pista {
    private final int idpista;
    private static int idPistaContador = 1;
    private String descripcion;
    private int orden;

    public Pista() {
        this.idpista = idPistaContador++;
        this.descripcion = "Sin descripción";
        this.orden = 1;
    }

    public Pista(String descripcion, int orden) {
        this.idpista = idPistaContador++;
        this.descripcion = descripcion;
        this.orden = orden;
    }

    public int getIdpista() {
        return idpista;
    }


    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }

    @Override
    public String toString() {
        return "Pista{" + "idpista=" + idpista + ", descripcion='" + descripcion + '\'' + ", orden=" + orden + '}';
    }
}