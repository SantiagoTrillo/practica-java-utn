package edificio;

public class Departamento {
    private int numeroUnidad, dniPropietario;
    private static int contadorNumeroUnidad = 1;
    private String nombrePropietario;
    private Voto voto;

    public Departamento(int dniPropietario, String nombrePropietario) throws IllegalArgumentException {
        this.setNumeroUnidad();
        this.dniPropietario = dniPropietario;
        this.setNombrePropietario(nombrePropietario);
        this.setVoto(voto);
    }

    @Override
    public String toString() {
        return "Numero de unidad: " + numeroUnidad + "\nDNI del propietario: " + dniPropietario + "\nNombre del propietario: " + nombrePropietario + "\nVoto: " + voto;
    }
    
    public int getNumeroUnidad() {
        return numeroUnidad;
    }

    public Voto getVoto() {
        return voto;
    }
    
    private void setNumeroUnidad() {
        this.numeroUnidad = contadorNumeroUnidad;
        Departamento.contadorNumeroUnidad += 1;
    }

    private void setNombrePropietario(String nombrePropietario) throws IllegalArgumentException {
        if (nombrePropietario.strip().isEmpty()) {
            throw new IllegalArgumentException("(Departamento) El nombre no puede estar vacio.");
        }
        this.nombrePropietario = nombrePropietario;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }
}