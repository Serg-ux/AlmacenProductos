
import java.time.LocalDate;
import java.util.Arrays;

public class Producto implements Comparable<Producto>{

    LocalDate fechaCaducidad;
    LocalDate fecha_envasado;
    int num_lote;
    int pais_origen;

    public Producto() {
    }

    public Producto(LocalDate fechaCaducidad, LocalDate fecha_envasado, int num_lote, int pais_origen) {
        this.fechaCaducidad = fechaCaducidad;
        this.fecha_envasado = fecha_envasado;
        this.num_lote = num_lote;
        this.pais_origen = pais_origen;

    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDate getFecha_envasado() {
        return fecha_envasado;
    }

    public void setFecha_envasado(LocalDate fecha_envasado) {
        this.fecha_envasado = fecha_envasado;
    }

    public int getNum_lote() {
        return num_lote;
    }

    public void setNum_lote(int num_lote) {
        this.num_lote = num_lote;
    }

    public int getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(int pais_origen) {
        this.pais_origen = pais_origen;
    }

    public void Caducidad() {
        if (fechaCaducidad.isBefore(fecha_envasado)) {
            fechaCaducidad = fecha_envasado.plusDays(10);
        }
    }

    @Override
    public String toString() {
        return "Producto{" + "fechaCaducidad=" + fechaCaducidad + ", fecha_envasado=" + fecha_envasado + ", num_lote=" + num_lote + ", pais_origen=" + pais_origen + '}';
    }

    
    @Override
    public int compareTo(Producto o) {
       
        if (this.pais_origen > o.pais_origen) {
            return 1;
        } else if (this.pais_origen < o.pais_origen) {
            return -1;
        }
        return 0;

    }

}
