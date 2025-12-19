package hospital;
import java.util.ArrayList;
import java.util.Random;

public class Medico {
    private int legajo, añosExperiencia;
    private String especialidad;
    private final int COSTO_BASE_CONSULTA = 10000;
    private final ArrayList<Paciente> pacientes;
    
    public Medico(int legajo, String especialidad, int añosExperiencia) {
       this.setLegajo(legajo);
       this.setEspecialidad(especialidad);
       this.setAñosExperiencia(añosExperiencia);
       this.pacientes = new ArrayList<>();
       Random random = new Random();
       for (int i = 0; i < 4; i++) {
            int numeroAleatorio = random.nextInt(3);
            
            if (numeroAleatorio == 0) {
                this.pacientes.add(new Ambulatorio(40404040 + i, "Paciente " + i, 20, 5));
            } else if (numeroAleatorio == 1) {
                this.pacientes.add(new Internado(40404040 + i, "Paciente " + i, 20, 13, "Maternidad"));
            } else if (numeroAleatorio == 2) {
                this.pacientes.add(new Urgencia(40404040 + i, "Paciente " + i, 20, 7));
            }
        }
    }

    public int realizarConsulta(Paciente paciente) {
        int costoFinal;
        
        if (paciente instanceof Ambulatorio ambulatorio) {
            costoFinal = COSTO_BASE_CONSULTA * ambulatorio.getVisitasAño();
        } else if (paciente instanceof  Internado internado) {
            costoFinal = COSTO_BASE_CONSULTA * internado.getDiasInternado();
        } else if (paciente instanceof Urgencia urgencia) {
            costoFinal = COSTO_BASE_CONSULTA * urgencia.getGravedad();
        } else {
            costoFinal = 0;
        }
        
        return costoFinal;
    }
   
    @Override
    public String toString() {
        return "Medico{" + "legajo=" + legajo + ", añosExperiencia=" + añosExperiencia + ", especialidad=" + especialidad + ", pacientes=" + pacientes + '}';
    }

    public int getLegajo() {
        return legajo;
    }

    private void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    private void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    private void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}