package club;
import java.util.ArrayList;

public class Club {
    private final ArrayList<Socio> socios;
    
    public Club() {
        this.socios = new ArrayList<>();
    }
    
    private Socio buscarSocio(String nombreBuscado) {
        Socio socioBuscado = null;
        int i = 0;
        
        while (i < this.socios.size() && socioBuscado == null) {
            if (this.socios.get(i).getNombre().equals(nombreBuscado)) {
                socioBuscado = this.socios.get(i);
            }
            
            i++;
        }
        
        return socioBuscado;
    }
    
    public boolean agregarSocio(String nombreNuevo, double valorCuotaNuevo) {
        boolean resultado = false;
        
        if (buscarSocio(nombreNuevo) == null) {
            this.socios.add(new Socio(nombreNuevo, valorCuotaNuevo));
            resultado = true;
        }
        
        return resultado;
    }
    
    public boolean cargarPago(String nombreBuscado, double pago) {
        Socio socioBuscado = buscarSocio(nombreBuscado);
        boolean resultado = false;
        
        if (socioBuscado != null) {
            resultado = socioBuscado.procesarPago(pago);
        }
        
        return resultado;
    }
    
    public void mostrarDeuda(String nombreBuscado) {
        Socio socioBuscado = buscarSocio(nombreBuscado);
        
        if (socioBuscado != null) {
            socioBuscado.mostrarDeuda();
        }
    }
}