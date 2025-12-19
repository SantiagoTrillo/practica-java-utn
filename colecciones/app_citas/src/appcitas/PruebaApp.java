package appcitas;

public class PruebaApp {
    public static void main(String[] args) {
        AppCitas appCitasPrueba = new AppCitas("UTinder");
        
        probarAppCitas(appCitasPrueba);
    }
    
    public static void probarAppCitas(AppCitas appCitasPrueba) {
        appCitasPrueba.registrarUsuario("Santiago", "santiago.trillo.utn@gamil.com", Genero.MASCULINO, 18, Genero.FEMENINO, 18, 20);
        appCitasPrueba.registrarUsuario("Santiago", "santiago.trillo.utn@gamil.com", Genero.MASCULINO, 18, Genero.FEMENINO, 18, 20);
        appCitasPrueba.registrarUsuario("Chiara", "chiara.clavenna.utn@gmail.com", Genero.FEMENINO, 18, Genero.MASCULINO, 18, 22);
        appCitasPrueba.registrarUsuario("Sofia", "sofia.sola.utn@gmail.com", Genero.FEMENINO, 18, Genero.MASCULINO, 17, 21);
        
        System.out.println(appCitasPrueba.verificarCoincidenciaParcial(appCitasPrueba.listarUsuarios().get(0), appCitasPrueba.listarUsuarios().get(1)));
        
        System.out.println(appCitasPrueba.verificarCoincidenciaTotal(appCitasPrueba.listarUsuarios().get(0), appCitasPrueba.listarUsuarios().get(1)));
        
        appCitasPrueba.mostrarCoincidencias("santiago.trillo.utn@gamil.com");
    }
}