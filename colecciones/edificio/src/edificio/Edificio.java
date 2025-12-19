package edificio;
import java.util.ArrayList;

public class Edificio {
    private String direccion;
    private int cantidadDepartamentos;
    private ArrayList<Departamento> departamentos;

    public Edificio(String direccion, int cantidadDepartamentos) throws IllegalArgumentException {
        this.setDireccion(direccion);
        this.setCantidadDepartamentos(cantidadDepartamentos);
        this.departamentos = new ArrayList<>();
    }
    
    public boolean agregarDepartamento(int numeroUnidadBuscado, int dniPropietarioNuevo, String nombrePropietarioNuevo) {
        boolean operacion = false;
        
        if (buscarDepartamento(numeroUnidadBuscado) == null) {
            this.departamentos.add(new Departamento(dniPropietarioNuevo, nombrePropietarioNuevo));
            operacion = true;
        }
        
        return operacion;
    }
    
    public boolean actualizarVoto(int numeroUnidadBuscado, Voto votoNuevo) {
        boolean operacion = false;
        Departamento departamentoObjetivo = buscarDepartamento(numeroUnidadBuscado);
        
        if (departamentoObjetivo != null) {
            if (departamentoObjetivo.getVoto() != votoNuevo) {
                departamentoObjetivo.setVoto(votoNuevo);
                operacion = true;
            }
        }
        
        return operacion;
    }
    
    public void mostrarPropietariosVotoPositivo() {
        for (Departamento propietario : departamentos) {
            if (propietario.getVoto() == Voto.POSITIVO) {
                System.out.println(propietario);
            }
        }
        System.out.println("Porcentaje total de votantes: " + calcularPorcentajeVotantes());
    }
    
    private Departamento buscarDepartamento(int numeroUnidadBuscado) {
        Departamento departamentoBuscado = null;
        int i = 0;
        
        while (i < this.departamentos.size() && departamentoBuscado == null) {
            if (this.departamentos.get(i).getNumeroUnidad() == numeroUnidadBuscado) {
                departamentoBuscado = this.departamentos.get(i);
            } else {
                i++;
            }
        }
        
        return departamentoBuscado;
    }
    
    private int calcularPorcentajeVotantes() {
        int contadorResidentes = 0;
        int contadorVotantes = 0;
        
        for (Departamento residente : departamentos) {
            contadorResidentes ++;
            if (residente.getVoto() != null) {
                contadorVotantes ++;
            }
        }
        
        int porcentajeVotantes = (contadorVotantes / contadorResidentes) * 100;
        
        return porcentajeVotantes;
    }

    private void setDireccion(String direccion) throws IllegalArgumentException {
        if (direccion.strip().isEmpty()) {
            throw new IllegalArgumentException("(Edificio) la direccion no puede estar vacia.");
        }
        
        this.direccion = direccion;
    }

    private void setCantidadDepartamentos(int cantidadDepartamentos) throws IllegalArgumentException {
        if (cantidadDepartamentos < 1) {
            throw new IllegalArgumentException("(Edificio) la cantidad de departamentos no puede ser menor que 1");
        }
        if (cantidadDepartamentos > 6700) {
            throw new IllegalArgumentException("(Edificio) la cantidad de departamentos no puede ser mayor que 6700.");
        }
        
        this.cantidadDepartamentos = cantidadDepartamentos;
    }
}