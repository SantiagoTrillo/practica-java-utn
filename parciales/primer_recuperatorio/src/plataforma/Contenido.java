package plataforma;
// @author Santiago Trillo
public class Contenido {
    private int id, visualizaciones;
    private String titulo;
    private Clasificacion clasificacion;

    public Contenido(int id, String titulo, Clasificacion clasificacion) {
        setId(id);
        setTitulo(titulo);
        setClasificacion(clasificacion);
    }

    public int getId() {
        return id;
    }

    public int getVisualizaciones() {
        return visualizaciones;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    private void setId(int id) throws IllegalArgumentException {
        if (id < 1) {
            throw new IllegalArgumentException("(Contenido, constructor) el id no puede ser 0 o menor.");
        }
        this.id = id;
    }

    public void setVisualizaciones(int visualizaciones) {
        if (visualizaciones < 0 || visualizaciones > 10) {
            throw new IllegalArgumentException("(Contenido, constructor) las visualizaciones no puede ser negativas ni mayores a 10.");
        }
        this.visualizaciones = visualizaciones;
    }

    private void setTitulo(String titulo) {
        if (titulo.strip().isEmpty()) {
            throw new IllegalArgumentException("(Contenido, constructor) el titulo no puede estar vacio.");
        }
        this.titulo = titulo;
    }

    private void setClasificacion(Clasificacion clasificacion) {
        if (clasificacion == null) {
            throw new IllegalArgumentException("(Contenido, constructor) la clasificacion no puede ser nula.");
        }
        this.clasificacion = clasificacion;
    }
}