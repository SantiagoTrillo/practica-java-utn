package tiendaelectrodomesticos;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TiendaElectrodomesticos {
    private static final int DEPOSITOS = 5, COMUNES = 3;
    private final Deposito depositos[];
    private final ArrayList<Articulo> articulosPendientes;
    
    public TiendaElectrodomesticos() throws IllegalArgumentException, NoSuchElementException {
        depositos = new Deposito[DEPOSITOS];
        
        for (int i = 0; i < depositos.length; i++) {
            if (i < COMUNES) {
                depositos[i] = new Comun();
            } else {
                depositos[i] = new Fragil();
            }
        }
        articulosPendientes = new ArrayList<>();
    }
    
    public void ingresarArticuloPendiente(Articulo articuloPendiente) throws IllegalArgumentException {
        if (articuloPendiente == null) {
            throw new IllegalArgumentException("(Tienda) el articulo pendiente no puede ser nulo.");
        }
        if (buscarArticulo(articuloPendiente.getCodigo()) != null) {
            throw new IllegalArgumentException("(Tienda) el articulo ya esta ingresado en la lista de pendientes.");
        }
        articulosPendientes.add(articuloPendiente);
    }
    
    private Articulo buscarArticulo(String codigoBuscado) {
        Articulo articuloBuscado = null;
        int i = 0;
        
        while (i < articulosPendientes.size() && articuloBuscado == null) {
            if (articulosPendientes.get(i).getCodigo().equals(codigoBuscado)) {
                articuloBuscado = articulosPendientes.get(i);
            }
            i++;
        }
        return articuloBuscado;
    }
    
    public Fabrica buscarFabricaMasArticulosPendientes() {
        int contadorSanpung = 0, contadorThilips = 0, contadorPoblex = 0, contadorElgil = 0;
        Fabrica fabricaMasArticulosPendientes = null;
        
        for (Articulo articuloPendiente : articulosPendientes) {
            switch (articuloPendiente.getFabricante()) {
                case SANPUNG -> contadorSanpung++;
                case THILIPS -> contadorThilips++;
                case POBLEX -> contadorPoblex++;
                case ELGIL -> contadorElgil++;
            }
        }
        if (contadorSanpung > contadorThilips && contadorSanpung > contadorPoblex && contadorSanpung > contadorElgil) {
            fabricaMasArticulosPendientes = Fabrica.SANPUNG;
        } else if (contadorThilips > contadorSanpung && contadorThilips > contadorPoblex && contadorThilips > contadorElgil) {
            fabricaMasArticulosPendientes = Fabrica.THILIPS;
        } else if (contadorPoblex > contadorSanpung && contadorPoblex > contadorThilips && contadorPoblex > contadorElgil) {
            fabricaMasArticulosPendientes = Fabrica.POBLEX;
        } else if (contadorElgil > contadorSanpung && contadorElgil > contadorThilips && contadorElgil > contadorPoblex){
            fabricaMasArticulosPendientes = Fabrica.ELGIL;
        }
        return fabricaMasArticulosPendientes;
    }
    
    public void guardarArticulos() throws IllegalStateException {
        ArrayList<Integer> indicesParaEliminar = new ArrayList<>();
        
        for (int i = 0; i < articulosPendientes.size(); i++) {
            int j = 0;
            boolean articuloGuardado = false;
            Articulo articuloPendiente = articulosPendientes.get(i);
            
            while (j < depositos.length && !articuloGuardado) {
                if ((depositos[j] instanceof Comun && articuloPendiente.getResistenciaEmbalaje() == Resistencia.ALTA) || (depositos[j] instanceof Fragil && articuloPendiente.getResistenciaEmbalaje() == Resistencia.BAJA)) {
                    depositos[j].ingresarArticulo(articuloPendiente);
                    articuloGuardado = true;
                    indicesParaEliminar.add(i);
                }
                j++;
            }
        }
        
        eliminarArticulos(indicesParaEliminar);
    }
    
    private void eliminarArticulos(ArrayList<Integer> indicesParaEliminar) {
        for (int i = indicesParaEliminar.size() - 1; i >= 0; i--) {
            articulosPendientes.remove((int) indicesParaEliminar.get(i));
        }
    }
}