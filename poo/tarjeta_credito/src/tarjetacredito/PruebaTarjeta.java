package tarjetacredito;

public class PruebaTarjeta {
    public static void main(String[] args) {
        TarjetaCredito tarjetaPrueba = new TarjetaCredito(21212121, "Marcelo", 100000);
        
        probarTarjeta(tarjetaPrueba);
    }
    
    public static void probarTarjeta(TarjetaCredito tarjetaPrueba) {
        System.out.println(tarjetaPrueba.realizarCompra(40000));
        System.out.println(tarjetaPrueba);
        tarjetaPrueba.actualizarLimite(30000);
        System.out.println(tarjetaPrueba.realizarCompra(40000));
        System.out.println(tarjetaPrueba);
    }
}