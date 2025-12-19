package concesionaria;

public class Concesionaria {
    private final int CANTIDAD_VEHICULOS = 30;
    private Vehiculo vehiculos[];

    public Concesionaria() {
        inicializarArreglo();
    }
    
    private void inicializarArreglo() {
        vehiculos = new Vehiculo[CANTIDAD_VEHICULOS];
    }
    
    public boolean agregarVehiculo(String nuevaPatente, TipoVehiculo nuevoTipo, double nuevoPrecioVenta) {
        boolean vehiculoAgregado = false;
        
        if (buscarVehiculo(nuevaPatente) == null && verificarEspacioDisponible() == true) {
            for (int i = 0; i < vehiculos.length && !vehiculoAgregado; i ++) {
                if (vehiculos[i] == null) {
                    vehiculos[i] = new Vehiculo(nuevaPatente, nuevoTipo, nuevoPrecioVenta);
                    vehiculoAgregado = true;
                }
            }
        }
        
        return vehiculoAgregado;
    }
    
    public Vehiculo buscarVehiculo(String patenteBuscada) {
        Vehiculo vehiculoBuscado = null;
        int i = 0;
        
        while (i < this.vehiculos.length && vehiculoBuscado == null) {
            if (this.vehiculos[i] != null && this.vehiculos[i].getPatente().equals(patenteBuscada)) {
                vehiculoBuscado = this.vehiculos[i];
            }
            
            i++;
        }
        
        return vehiculoBuscado;
    }
    
    private boolean verificarEspacioDisponible() {
        boolean resultado = false;
        boolean recorrer = true;
        
        while (recorrer == true) {
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo == null) {
                    resultado = true;
                    recorrer = false;
                }
            }
        }
        
        return resultado;
    }
    
    public boolean venderVehiculo (Vehiculo vehiculoVendido) {
        boolean resultado = false;
        
        if (buscarVehiculo(vehiculoVendido.getPatente()) != null) {
            for (int i = 0; i < vehiculos.length; i ++) {
                if (vehiculos[i] == vehiculoVendido) {
                    System.out.println(vehiculoVendido);
                    vehiculos[i] = null;
                    resultado = true;
                }
            }
        }
        
        return resultado;
    }
}