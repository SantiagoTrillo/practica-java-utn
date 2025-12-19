package colecciones;

public class PruebaAgenda {
    public static void main(String[] args) {
        try {
            Agenda agendaPrueba = new Agenda("Agenda de Prueba");
            Domicilio domicilioPrueba1 = new Domicilio("Asamblea", "C", "CABA", 1406, 3, 1281);
            Domicilio domicilioPrueba2 = new Domicilio("Tiro", "A", "CABA", 1093, 2, 3891);

            probarAgenda(agendaPrueba, domicilioPrueba1, domicilioPrueba2);
        } catch (IllegalArgumentException excepción) {
            System.out.println("Error al crear un objeto: " + excepción.getMessage());
        }
    }
    
    public static void probarAgenda(Agenda agendaPrueba, Domicilio domicilioPrueba1, Domicilio domicilioPrueba2) {
        System.out.println(agendaPrueba.agregarContacto("Santiago", "Trillo", "santiago.trillo.utn@gmail.com", 23232323, domicilioPrueba1, TipoContacto.PERSONAL));
        System.out.println(agendaPrueba.agregarContacto("Santiago", "Trillo", "santiago.trillo.utn@gmail.com", 23232323, domicilioPrueba1, TipoContacto.PERSONAL));
        
        System.out.println(agendaPrueba.modificarDomicilio("santiago.trillo.utn@gmail.com", domicilioPrueba2));
        System.out.println(agendaPrueba.modificarDomicilio("santiago.trillo.utn@gmail.com", domicilioPrueba2));
        
        agendaPrueba.mostrarContactos();
        
        System.out.println(agendaPrueba.obtenerUltimoContactoAgregado());
        
        agendaPrueba.mostrarContactosPorCodigoPostal(3891);
        agendaPrueba.mostrarContactosPorCodigoPostal(1281);
        
        System.out.println(agendaPrueba.agregarContacto("Selena", "Luna", "selena.luna.utn@gmail.com", 89898989, domicilioPrueba1, TipoContacto.LABORAL));
        System.out.println(agendaPrueba.listarContactosLaborales());
        
        System.out.println(agendaPrueba.removerContacto("selena.luna.utn@gmail.com"));
    }
}