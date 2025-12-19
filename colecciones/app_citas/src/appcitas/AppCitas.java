package appcitas;
import java.util.ArrayList;

public class AppCitas {
    private String nombre;
    private final ArrayList<Usuario> usuarios;
    
    public AppCitas(String nombre) {
        this.nombre = nombre;
        this.usuarios = new ArrayList<>();
    }
    
    public void registrarUsuario(String nuevoNombre, String nuevoEmail, Genero nuevoGenero, int nuevaEdad, Genero generoBuscado, int edadMinimaBuscada, int edadMaximaBuscada) {        
        if (buscarUsuario(nuevoEmail) == null) {
            this.usuarios.add(new Usuario(nuevoNombre, nuevoEmail, nuevoGenero, generoBuscado, nuevaEdad, edadMinimaBuscada, edadMaximaBuscada));
        }
    }
    
    public boolean verificarCoincidenciaParcial(Usuario usuario1, Usuario usuario2) {
        boolean coincidenciaParcial = false;
        
        if (usuario2.getGenero() == usuario1.getGeneroBuscado() && usuario2.getEdad() <= usuario1.getEdadMaximaBuscada() && usuario2.getEdad() >= usuario1.getEdadMinimaBuscada()) {
            coincidenciaParcial = true;
        }
        
        return coincidenciaParcial;
    }
    
    public boolean verificarCoincidenciaTotal(Usuario usuario1, Usuario usuario2) {
        boolean coincidenciaTotal = false;
        
        if (usuario2.getGenero() == usuario1.getGeneroBuscado() && usuario2.getEdad() <= usuario1.getEdadMaximaBuscada() && usuario2.getEdad() >= usuario1.getEdadMinimaBuscada()) {
            if (usuario1.getGenero() == usuario2.getGeneroBuscado() && usuario1.getEdad() <= usuario2.getEdadMaximaBuscada() && usuario1.getEdad() >= usuario2.getEdadMinimaBuscada()) {
                coincidenciaTotal = true;
            }
        }
        
        return coincidenciaTotal;
    }
    
    public void mostrarCoincidencias(String emailPeticionario) {
        Usuario usuarioPeticionario = buscarUsuario(emailPeticionario);
        
        System.out.println("Listado de coincidencias encontaradas: ");
        for (Usuario usuario : usuarios) {
            if (usuario != usuarioPeticionario) {
                verificarCoincidenciaParcial(usuarioPeticionario, usuario);
                System.out.println(usuario.toString());
            }
        }
    }
    
    private Usuario buscarUsuario(String emailBuscado) {
        Usuario usuarioBuscado = null;
        int i = 0;
        
        while (i < this.usuarios.size() && usuarioBuscado == null) {
            if (this.usuarios.get(i).getEmail().equals(emailBuscado)) {
                usuarioBuscado = this.usuarios.get(i);
            }
            i++;
        }
        
        return usuarioBuscado;
    }
    
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        
        for (Usuario usuario : usuarios) {
            listaUsuarios.add(usuario);
        }
        
        return listaUsuarios;
    }
}