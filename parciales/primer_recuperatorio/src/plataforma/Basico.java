package plataforma;
// @author Santiago Trillo
public class Basico extends Perfil {
    public Basico(String nombre, String pais, int edad) {
        super(nombre, pais, edad);
    }
    
    @Override
    public boolean habilitarContenidoAdulto() {
        return false;
    }
    
    @Override
    public boolean habilitarContenidoAdolescente() {
        return false;
    }
}