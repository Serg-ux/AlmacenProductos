
import java.time.LocalDate;
import java.time.Month;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Arrays;
import java.util.Scanner;


public class principal {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        Producto[] productos = new Producto[20];
        CrearDatos(productos);
        int n;
        do {
            System.out.println("0-Salir \n 1-Listar Ordenados Pais \n 2-Listar Caducados \n 3-Productos Mayor Caducidad");
            n = leer.nextInt();
            leer.nextLine();
            switch (n) {
                case 1:
                    System.out.println("Paises ordenados:");
                    ListarOrdenadosPais(productos);
                    System.out.println("___________________________________________________________________________");
                    break;
                case 2:
                    System.out.println("Lista de los productos caducados:");
                    ListarProductosCaducados(productos);
                     System.out.println("___________________________________________________________________________");
                    break;
                case 3:
                    System.out.println("El producto con mayor caducidad:");
                    ProductoMayorCaducidad(productos);
            }
        } while (n != 0);

    }

    public static void CrearDatos(Producto[] productos) {
        for (int i = 0; i < productos.length; i++) {
              productos[i]= new Producto();
              productos[i].setFechaCaducidad(LocalDate.of(2000+(int)(Math.random()*50)+1,(int)(Math.random()*11)+1,(int)(Math.random()*27)+1));
              productos[i].setFecha_envasado(LocalDate.of(2000+(int)(Math.random()*50)+1,(int)(Math.random()*11)+1,(int)(Math.random()*27)+1));
              productos[i].setNum_lote((int)(Math.random()*1000));
              productos[i].setPais_origen((int)(Math.random()*194)+1);
        }
    }
    public static void ListarOrdenadosPais(Producto[]productos){
        Arrays.sort(productos);
        for (int i = 0; i <productos.length; i++) {
            System.out.println(productos[i].toString());
        }
    }
    public static void ListarProductosCaducados(Producto[]productos){
        LocalDate fecha_actual=LocalDate.now();
        System.out.println("La fecha actual es : "+fecha_actual);
        for (int i = 0; i <productos.length; i++) {
            LocalDate fecha_caducado= productos[i].getFechaCaducidad();
            if (fecha_actual.isAfter( fecha_caducado)) {
                System.out.println(productos[i]);
            }
        }
    }
    public static void ProductoMayorCaducidad(Producto[]productos){
        long dias ;
        int producto=0;
        long maximoDias = Integer.MIN_VALUE;
        for (int i = 0; i < productos.length; i++) {
            if(productos[i].getFechaCaducidad().isAfter(LocalDate.now())){
                dias = DAYS.between(LocalDate.now(), productos[i].getFechaCaducidad());
                if (dias>maximoDias){
                    maximoDias = dias;
                    producto=i;
                }
            }
        }
        System.out.println("El producto con mas dias antes de caducar es " + productos[producto].toString() + " con un total de "+ maximoDias + " antes de caducar");
    }
}
