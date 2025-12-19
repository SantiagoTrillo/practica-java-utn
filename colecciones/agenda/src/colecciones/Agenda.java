package colecciones;
import java.util.ArrayList;

public class Agenda {
    private String nombre;
    private ArrayList<Contacto> contactos;
    
    public Agenda(String nombre) throws IllegalArgumentException {
        this.setNombre(nombre);
        this.contactos = new ArrayList<>();
    }
    
    public boolean agregarContacto(String nombreNuevo, String apellidoNuevo, String emailNuevo, int telefonoNuevo, Domicilio domicilioNuevo, TipoContacto tipoContactoNuevo) {
        boolean operacion = false;
        
        if (buscarContacto(emailNuevo) == null) {
            this.contactos.add(new Contacto(nombreNuevo, apellidoNuevo, emailNuevo, telefonoNuevo, domicilioNuevo, tipoContactoNuevo));
            operacion = true;
        }
        
        return operacion;
    }
    
    public boolean modificarDomicilio(String emailBuscado, Domicilio domicilioNuevo) {
        boolean operacion = false;
        Contacto contactoObjetivo = buscarContacto(emailBuscado);
        
        if (contactoObjetivo != null) {
            if (contactoObjetivo.getDomicilio() != domicilioNuevo) {
                contactoObjetivo.setDomicilio(domicilioNuevo);
                operacion = true;
            }
        }
        
        return operacion;
    }
    
    public Contacto removerContacto(String emailBuscado) {
        Contacto contactoObjetivo = buscarContacto(emailBuscado);
        
        if (contactoObjetivo != null) {
            this.contactos.remove(contactoObjetivo);
        }
        
        return contactoObjetivo;
    }
    
    public void mostrarContactos() {
        System.out.println("Listado de contactos");
        
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
        } else {
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        }
    }    
    
    public Contacto obtenerUltimoContactoAgregado() {
        Contacto ultimaPersona = null;
       
        if (!this.contactos.isEmpty()) {
           ultimaPersona = this.contactos.get(this.contactos.size() - 1);
        }
       
       return ultimaPersona;
    }
    
    public void mostrarContactosPorCodigoPostal(int codigoPostalBuscado) {
        for (Contacto contacto : contactos) {
            if (contacto.getCodigoPostal() == codigoPostalBuscado) {
                System.out.println(contacto);
            }
        }
    }
    
    public ArrayList listarContactosLaborales() {
        ArrayList<Contacto> contactosLaborales = new ArrayList<>();
        
        for (Contacto contacto : contactos) {
            if (contacto.getTipoContacto() == TipoContacto.LABORAL) {
                contactosLaborales.add(contacto);
            }
        }
        
        return contactosLaborales;
    }
    
    private Contacto buscarContacto(String emailBuscado) {
        Contacto contactoBuscado = null;
        int i = 1;
        
        while (i < this.contactos.size() && contactoBuscado == null) {
            if (this.contactos.get(i).getEmail().equals(emailBuscado)) {
                contactoBuscado = this.contactos.get(i);
            } else {
                i ++;
            }
        }
        
        return contactoBuscado;
    }

    private void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre.strip().isEmpty()) {
            throw new IllegalArgumentException("(Agenda) el nombre no puede estar vacio.");
        }
        
        this.nombre = nombre;
    }
    
}