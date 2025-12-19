package karting;
import java.util.ArrayList;

public class Parque {
    int cantidadKartings;
    private final int EDAD_MINIMA = 12, EDAD_MAXIMA = 65;
    private final ArrayList<Karting> listaAutos;
    private final ArrayList<Jugador> listaEspera;
    
    public Parque(int cantidadKartings) {
        this.setCantidadKartings(cantidadKartings);
        this.listaAutos = new ArrayList<>();
        for (int i = 0; i < cantidadKartings; i++) {
            this.listaAutos.add(new Karting(i + 1));
        }
        this.listaEspera = new ArrayList<>();
    }
    
    public ResultadoInscripcion anotarPersona(String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        ResultadoInscripcion resultado;
        
        if (nuevoNombre.strip().equals("")) {
            resultado = ResultadoInscripcion.NOMBRE_INVALIDO;
        } else if (nuevaEdad < EDAD_MINIMA || nuevaEdad > EDAD_MAXIMA) {
            resultado = ResultadoInscripcion.EDAD_INVALIDA;
        } else if (buscarJugador(nuevoNombre, nuevoApellido) != null) {
            resultado = ResultadoInscripcion.YA_ANOTADA;
        } else {
            this.listaEspera.add(new Jugador(nuevoNombre, nuevoApellido, nuevaEdad));
            resultado = ResultadoInscripcion.ANOTADA_CORRECTAMENTE;
        }
        
        return resultado;
    }
    
    public boolean cambiarEstadoKarting(int numeroKarting) {
        boolean cambioExitoso = false;
        Karting kartingObjetivo = buscarKarting(numeroKarting);
        
        if (kartingObjetivo != null) {
            if (kartingObjetivo.isEstadoOperativo() == true) {
                kartingObjetivo.setEstadoOperativo(false);
                kartingObjetivo.setUltimoJugador(null);
                cambioExitoso = true;
            } else {
                kartingObjetivo.setEstadoOperativo(true);
                cambioExitoso = true;
            }
        }
        
        return cambioExitoso;
    }
    
    public int ubicarPersonas(){
        int personasUbicadas = 0;
        
        if (listaEspera.size() > 1) {
            for (int i = 0; i < listaAutos.size() && !listaEspera.isEmpty(); i++) {
                if (listaAutos.get(i).isEstadoOperativo()) {
                    listaAutos.get(i).setUltimoJugador(listaEspera.get(0));
                    if (listaEspera.get(0).getEdad() < 18) {
                        listaAutos.get(i).setMontoRecaudado(17000);
                    } else {
                        listaAutos.get(i).setMontoRecaudado(25000);
                    }
                    listaEspera.remove(0);
                    personasUbicadas++;
                }   
            }
        }
        
        return personasUbicadas;
    }
    
   public int mostrarRecaudación() {
       int totalRecaudado = 0;
       
       for (int i = 0; i < listaAutos.size(); i++) {
           System.out.println(this.listaAutos.get(i).toString());
           totalRecaudado += this.listaAutos.get(i).getMontoRecaudado();
       }
       
       return totalRecaudado;
   }
    
    private Jugador buscarJugador(String nombreBuscado, String apellidoBuscado) {
        Jugador jugadorBuscado = null;
        int i = 0;
        
        while (i < this.listaEspera.size() && jugadorBuscado == null) {
            if (this.listaEspera.get(i).getNombre().equals(nombreBuscado) && this.listaEspera.get(i).getApellido().equals(apellidoBuscado)) {
                jugadorBuscado = this.listaEspera.get(i);
            }
            i++;
        }
        
        return jugadorBuscado;
    }
    
    private Karting buscarKarting(int numeroBuscado) {
        Karting kartingBuscado = null;
        int i = 0;
        
        while (i < this.listaAutos.size() && kartingBuscado == null) {
            if (this.listaAutos.get(i).getNumero() == numeroBuscado) {
                kartingBuscado = this.listaAutos.get(i);
            }
            i++;
        }
        
        return kartingBuscado;
    }

    public int getCantidadKartings() {
        return cantidadKartings;
    }

    private void setCantidadKartings(int cantidadKartings) {
        this.cantidadKartings = cantidadKartings;
    }
}