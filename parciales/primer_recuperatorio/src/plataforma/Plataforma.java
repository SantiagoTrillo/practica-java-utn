package plataforma;
import java.util.ArrayList;
// @author Santiago Trillo
public class Plataforma {
    private String nombre;
    private Contenido[] catalogo;
    private ArrayList<Perfil> usuarios;
    private ArrayList<ErrorContenido> historialErrores;

    public Plataforma(String nombre, Contenido[] catalogo) throws IllegalArgumentException {
        setNombre(nombre);
        this.catalogo = catalogo;
        usuarios = new ArrayList<>();
        historialErrores = new ArrayList<>();
    }
    
    public void registrarVisualizacion(Perfil perfilSeleccionado, int idContenido) {
        boolean errorEncontrado = false;
        
        if (perfilSeleccionado == null) {
            historialErrores.add(new ErrorContenido(null, "(Plataforma, registrarVisualizacion) el perfil seleccionado no puede ser nulo."));
            errorEncontrado = true;
        }
        Contenido contenidoSeleccionado = buscarContenido(idContenido);
        
        if (contenidoSeleccionado == null) {
            historialErrores.add(new ErrorContenido(perfilSeleccionado != null ? perfilSeleccionado.getNombre() : null, "(Plataforma, registrarVisualizacion) el contendio seleccionado no puede ser nulo."));
            errorEncontrado = true;
        } 
        
        if (!errorEncontrado) {
            Clasificacion clasificacionContenido = contenidoSeleccionado.getClasificacion();
            
            switch (clasificacionContenido) {
                case ADULTO -> {
                    if (!perfilSeleccionado.habilitarContenidoAdulto()) {
                        historialErrores.add(new ErrorContenido(perfilSeleccionado.getNombre(), "(Plataforma, registrarVisualizacion) el perfil no cumple con los requistos para ver el contenido deseado (adulto requerido)."));
                        errorEncontrado = true;
                    }
                }
                case ADOLESCENTE -> {
                    if (!perfilSeleccionado.habilitarContenidoAdolescente()) {
                        historialErrores.add(new ErrorContenido(perfilSeleccionado.getNombre(), "(Plataforma, registrarVisualizacion) el perfil no cumple con los requistos para ver el contenido deseado (adolescente requerido)."));
                        errorEncontrado = true;
                    }
                }
            }
            if (contenidoSeleccionado.getVisualizaciones() >= 10) {
                historialErrores.add(new ErrorContenido(perfilSeleccionado.getNombre(), "(Plataforma, registrarVisualizacion) el contenido no tiene mas visualizaciones disponibles"));
                errorEncontrado = true;
            }
            if (!errorEncontrado) {
                contenidoSeleccionado.setVisualizaciones(contenidoSeleccionado.getVisualizaciones() + 1);
            }
        }
    }
    
    private Contenido buscarContenido(int idBuscado) {
        Contenido contenidoBuscado = null;
        int i = 0;
        
        while (i < catalogo.length && contenidoBuscado == null) {
            if (catalogo[i] != null && catalogo[i].getId() == idBuscado) {
                contenidoBuscado = catalogo[i];
            }
            i++;
        }
        return contenidoBuscado;
    }

    public void mostrarErrores() {
        for (ErrorContenido Error : historialErrores) {
            System.out.println(Error);
        }
    }
    
    private void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre.strip().isEmpty()) {
            throw new IllegalArgumentException("(Plataforma, constructor) el nombre no puede estar vacio.");
        }
        this.nombre = nombre;
    }
}