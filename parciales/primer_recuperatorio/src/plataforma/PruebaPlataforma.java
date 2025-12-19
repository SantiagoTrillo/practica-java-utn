package plataforma;
// @author Santiago Trillo
public class PruebaPlataforma {
    public static void main(String[] args) {
        final int MAXIMO_CONTENIDOS = 10;
        Contenido[] contenidos = new Contenido[MAXIMO_CONTENIDOS];

        System.out.println("Se cargan contenidos");
        cargarContenidos(contenidos);

        Plataforma plataforma = new Plataforma("UTNFlix", contenidos);

        System.out.println("Se registran visualizaciones");
        registrarPerfilesYVisualizaciones(plataforma);

        System.out.println("Listado de errores");
        plataforma.mostrarErrores();
    }

    private static void cargarContenidos(Contenido[] contenidos) {
        contenidos[0] = new Contenido(6, "Comedia Familiar", Clasificacion.FAMILIAR);
        contenidos[1] = new Contenido(2, "Drama Adolescente", Clasificacion.ADOLESCENTE);
        contenidos[2] = new Contenido(8, "Documental Naturaleza", Clasificacion.FAMILIAR);
        contenidos[3] = new Contenido(4, "Serie Adolescente", Clasificacion.ADOLESCENTE);
        contenidos[4] = new Contenido(3, "Película Familiar", Clasificacion.FAMILIAR);
        contenidos[5] = new Contenido(1, "Thriller Adultos", Clasificacion.ADULTO);
        contenidos[6] = new Contenido(10, "Serie Policial Adultos", Clasificacion.ADULTO);
        contenidos[7] = new Contenido(5, "Anime Adolescente", Clasificacion.ADOLESCENTE);
        contenidos[8] = new Contenido(7, "Reality Familiar", Clasificacion.FAMILIAR);
        contenidos[9] = new Contenido(9, "MiniSerie Adultos", Clasificacion.ADULTO);
    }

    private static void registrarPerfilesYVisualizaciones(Plataforma plataforma) {
        registrarPerfilBasico(plataforma, "Juan", "Argentina", 23, 3);   // OK (familiar)
        registrarPerfilBasico(plataforma, "John", "USA", 16, 1);         // edad inválida
        registrarPerfilBasico(plataforma, "Catalina", "Argentina", 23, 5); // intenta ADULTO → error
        registrarPerfilBasico(plataforma, "Catalina", "Argentina", 23, 10); // id inexistente → error

        registrarPerfilEstandar(plataforma, "Esteban", "Argentina", 23, 2); // ADOLESCENTE ok
        registrarPerfilEstandar(plataforma, "", "Chile", 23, 3);            // nombre vacío
        registrarPerfilEstandar(plataforma, "Ricardo", "España", 23, 7);    // FAMILIAR ok
        registrarPerfilEstandar(plataforma, "Juana", null, 23, 7);          // país nulo
        registrarPerfilEstandar(plataforma, "Carolina", "Argentina", 23, 1);// ADULTO no autorizado

        registrarPerfilPremium(plataforma, "Maximiliano", "Argentina", 23, 1);  // ADULTO ok
        registrarPerfilPremium(plataforma, "Maximiliano", "Argentina", 23, 144);// id inexistente
        registrarPerfilPremium(plataforma, "Juana", "Argentina", 23, 2);        // ADOLESCENTE ok
        registrarPerfilPremium(plataforma, "Josefa", "Argentina", 23, 7);       // FAMILIAR ok
    }

    private static void registrarPerfilBasico(Plataforma plataforma, String nombre, String pais, int edad, int idContenido) {
        try {
            Perfil perfil = new Basico(nombre, pais, edad);
            plataforma.registrarVisualizacion(perfil, idContenido);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
    }

    private static void registrarPerfilEstandar(Plataforma plataforma, String nombre, String pais, int edad, int idContenido) {
        try {
            Perfil perfil = new Estandar(nombre, pais, edad);
            plataforma.registrarVisualizacion(perfil, idContenido);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registrarPerfilPremium(Plataforma plataforma, String nombre, String pais, int edad, int idContenido) {
        try {
            Perfil perfil = new Premium(nombre, pais, edad);
            plataforma.registrarVisualizacion(perfil, idContenido);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}