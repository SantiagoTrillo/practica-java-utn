package colegio;
import java.util.ArrayList;

public class Familia {
    private String nombreResponsable, apellidoResponsable;
    private int numeroLegajo;
    private static int contadorLegajo = 1;
    private final ArrayList<Hijo> hijosInscriptos;

    public Familia(String nombreResponsable, String apellidoResponsable, ArrayList<Hijo> hijosInscriptos) {
        this.nombreResponsable = nombreResponsable;
        this.apellidoResponsable = apellidoResponsable;
        this.numeroLegajo = contadorLegajo++;
        this.hijosInscriptos = hijosInscriptos;
    }

    @Override
    public String toString() {
        return "Responsable de la familia: " + nombreResponsable + " " + apellidoResponsable + "\nNumero de legajo: " + numeroLegajo;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public String getApellidoResponsable() {
        return apellidoResponsable;
    }

    public ArrayList<Hijo> getHijosInscriptos() {
        return hijosInscriptos;
    }
}