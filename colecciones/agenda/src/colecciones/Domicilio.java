package colecciones;

public class Domicilio {
    private String calle, departamento, provincia;
    private int numero, piso, codigoPostal;

    public Domicilio(String calle, String departamento, String provincia, int numero, int piso, int codigoPostal) throws IllegalArgumentException {
        this.setCalle(calle);
        this.setDepartamento(departamento);
        this.setProvincia(provincia);
        this.setNumero(numero);
        this.setPiso(piso);
        this.setCodigoPostal(codigoPostal);
    }
    
    @Override
    public String toString() {
        return "Provincia: " + provincia + "\nCalle: " + calle + "\nNumero: " + numero + "\nPiso: " + piso + "\nDepartamento: " + departamento + "\nCodigo postal: " + codigoPostal;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    private void setCalle(String calle) throws IllegalArgumentException {
        if (calle.strip().isEmpty()) {
            throw new IllegalArgumentException("(Domicilio) La calle no puede estar vacia.");
        }
        
        this.calle = calle;
    }

    private void setDepartamento(String departamento) throws IllegalArgumentException {
        if (departamento.strip().isEmpty()) {
            throw new IllegalArgumentException("(Domicilio) El departamento no puede estar vacio.");
        }
        
        this.departamento = departamento;
    }

    private void setProvincia(String provincia) throws IllegalArgumentException {
        if (provincia.strip().isEmpty()) {
            throw new IllegalArgumentException("(Domicilio) La provincia no puede estar vacia.");
        }
        this.provincia = provincia;
    }

    private void setNumero(int numero) throws IllegalArgumentException {
        if (numero < 10) {
            throw new IllegalArgumentException("(Domicilio) El numero del domicilio no puede ser menor a 10.");
        }
        if (numero > 99999) {
            throw new IllegalArgumentException("(Domicilio) El numero del domicilio no puede ser mayor a 99999.");
        }
        
        this.numero = numero;
    }

    private void setPiso(int piso) throws IllegalArgumentException {
        if (piso < 16) {
            throw new IllegalArgumentException("(Domicilio) El numero de piso no puede ser menor a 16.");
        }
        if (piso > 163) {
            throw new IllegalArgumentException("(Domicilio) El numero de piso no puede ser mayor a 163.");
        }
        
        this.piso = piso;
    }

    private void setCodigoPostal(int codigoPostal) throws IllegalArgumentException {
        if (codigoPostal < 10) {
            throw new IllegalArgumentException("(Domicilio) El codigo postal no puede ser menor a 10.");
        }
        
        this.codigoPostal = codigoPostal;
    }
}