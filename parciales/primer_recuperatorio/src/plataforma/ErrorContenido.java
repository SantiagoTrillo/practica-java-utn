package plataforma;
// @author Santiago Trillo
public class ErrorContenido {
    private String nombrePerfil, textoError;

    public ErrorContenido(String nombrePerfil, String textoError) throws IllegalArgumentException {
        setNombrePerfil(nombrePerfil);
        setTextoError(textoError);
    }
    
    @Override
    public String toString() {
        return "Nombre del perfil: " + nombrePerfil + "\nTexto del error: " + textoError;
    }

    private void setNombrePerfil(String nombrePerfil) throws IllegalArgumentException {
        if (nombrePerfil != null && nombrePerfil.strip().isEmpty()) {
            throw new IllegalArgumentException("(ErrorContenido, constructor) el nombre del perfil no puede estar vacio.");
        }
        this.nombrePerfil = nombrePerfil;
    }

    private void setTextoError(String textoError) throws IllegalArgumentException {
        if (textoError.strip().isEmpty()) {
            throw new IllegalArgumentException("(ErrorContenido, constructor) el texto del error no puede estar vacio.");
        }
        this.textoError = textoError;
    }
}