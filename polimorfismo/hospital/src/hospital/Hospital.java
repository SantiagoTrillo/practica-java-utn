package hospital;
import java.util.ArrayList;

public class Hospital {
    private String nombre;
    private final ArrayList<Medico> medicos;
    
    public Hospital(String nombre) {
        this.setNombre(nombre);
        this.medicos = new ArrayList<>();
        this.medicos.add(new Medico(18500, "Nefrologia", 4));
        this.medicos.add(new Medico(19500, "Cardiologia", 7));
        this.medicos.add(new Medico(17500, "Traumatismo", 15));
    }

    public int contarConsultasMasCostosasQue(int costoDado) {
        int consultasCostosas = 0;
        
        for (Medico medico : medicos) {
            for (Paciente paciente : medico.getPacientes()) {
                if (medico.realizarConsulta(paciente) > costoDado) {
                    consultasCostosas++;
                }
            }
        }
        
        return consultasCostosas;
    }
    
    public void mostrarMedicoConMasUrgencias() {
        Medico medicoConMasUrgencias = null;
        int contadorUrgencias = 0;
        int recordUrgencias = 0;
        
        for (Medico medico: medicos) {
            for (Paciente paciente : medico.getPacientes()) {
                if (paciente instanceof Urgencia) {
                    contadorUrgencias++;
                }
            }
            if (contadorUrgencias > recordUrgencias) {
                recordUrgencias = contadorUrgencias;
                medicoConMasUrgencias = medico;
            }
        }
        
        System.out.println("El medico que atendio la mayor cantidad de pacientes de urgencia es " + medicoConMasUrgencias);
    }
    
    public int calcularPromedioCostoConsultaTipoPaciente(Paciente tipoPaciente) {
        int promedioCostoConsulta;
        int contadorConsultas = 0;
        int acumuladorConsultas = 0;
        
        for (Medico medico : medicos) {
            for (Paciente paciente : medico.getPacientes()) {
                if (paciente.getClass() == tipoPaciente.getClass()) {
                    acumuladorConsultas += medico.realizarConsulta(paciente);
                    contadorConsultas++;
                }
            }
        }
        
        promedioCostoConsulta = acumuladorConsultas / contadorConsultas;
        
        return promedioCostoConsulta;
    }
    
    @Override
    public String toString() {
        return "Hospital{" + "nombre=" + nombre + ", medicos=" + medicos + '}';
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
}