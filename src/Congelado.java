
import java.time.LocalDate;
public class Congelado extends Producto {

    private String codORGSuper;
    private double tempMant;

    public Congelado() {
        super();
    }

    public Congelado(String codORGSuper, double tempMant, LocalDate fechaCaducidad, LocalDate fecha_envasado, int num_lote, int pais_origen) {
        super(fechaCaducidad, fecha_envasado, num_lote, pais_origen);
        this.codORGSuper = codORGSuper;
        this.tempMant = tempMant;
    }

    public String getCodORGSuper() {
        return codORGSuper;
    }

    public void setCodORGSuper(String codORGSuper) {
        this.codORGSuper = codORGSuper;
    }

    public double getTempMant() {
        return tempMant;
    }

    public void setTempMant(double tempMant) {
        this.tempMant = tempMant;
    }

    @Override
    public String toString() {
        return "codORGSuper= " + codORGSuper + ", tempMant= " + tempMant + super.toString();
    }
}

enum TipoCogenlacion {
    AGUA, NITROGENO, AIRE
}
