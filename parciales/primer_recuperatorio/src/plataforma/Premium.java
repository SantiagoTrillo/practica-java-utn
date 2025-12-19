package plataforma;
// @author Santiago Trillo
public class Premium extends Perfil{
    public Premium(String nombre, String pais, int edad) {
        super(nombre, pais, edad);
    }
    
    @Override
    public boolean habilitarContenidoAdulto() {
        return true;
    }
    
    @Override
    public boolean habilitarContenidoAdolescente() {
        return true;
    }
}