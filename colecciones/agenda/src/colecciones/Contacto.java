package colecciones;

public class Contacto {
    private String nombre, apellido, email;
    private int telefono;
    private Domicilio domicilio;
    private TipoContacto tipoContacto;

    public Contacto(String nombre, String apellido, String email, int telefono, Domicilio domicilio, TipoContacto tipoContacto) throws IllegalArgumentException {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
        this.telefono = telefono;
        this.setDomicilio(domicilio);
        this.tipoContacto = tipoContacto;
    }
    
    public int getCodigoPostal() {
        return domicilio.getCodigoPostal();
    }   

    @Override
    public String toString() {
        return "-------------------\nNombre: " + nombre + "\nApellido: " + apellido + "\nEmail: " + email + "\nTelefono: " + telefono + "\nTipo de contacto: " + traducirTipoContacto() + "\nDomicilio\n-------------------\n: " + domicilio;
    }    
    
    private String traducirTipoContacto() {
        String traduccion = "";
        
        if (tipoContacto == TipoContacto.LABORAL) {
            traduccion = "Laboral";
        } else if (tipoContacto == TipoContacto.PERSONAL) {
            traduccion = "Personal";
        }
        
        return traduccion;
    } 

    public String getEmail() {
        return email;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public TipoContacto getTipoContacto() {
        return tipoContacto;
    }

    private void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre.strip().isEmpty()) {
            throw new IllegalArgumentException("(Contacto) El nombre no puede estar vacio.");
        }
        
        this.nombre = nombre;
    }

    private void setApellido(String apellido) throws IllegalArgumentException {
        if (apellido.strip().isEmpty()) {
            throw new IllegalArgumentException("(Contacto) El apellido no puede estar vacio.");
        }
        
        this.apellido = apellido;
    }

    private void setEmail(String email) throws IllegalArgumentException {
        if (email.strip().isEmpty()) {
            throw new IllegalArgumentException("(Contacto) El email no puede estar vacio.");
        }
        
        this.email = email;
    }

    public void setDomicilio(Domicilio domicilio) throws IllegalArgumentException {
        if (domicilio == null) {
            throw new IllegalArgumentException("(Contacto) el domicilio no puede ser nulo.");
        }
        
        this.domicilio = domicilio;
    }
}