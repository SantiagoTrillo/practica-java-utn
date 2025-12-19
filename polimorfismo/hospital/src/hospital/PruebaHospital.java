package hospital;

public class PruebaHospital {
    public static void main(String[] args) {
        Hospital hospitalPrueba = new Hospital("Hospital Aleman");
        Ambulatorio ambulatorioPrueba = new Ambulatorio(30303030, "Pepito", 20, 5);
        Internado internadoPrueba = new Internado(30303030, "Ramona", 20, 10, "Sala 13");
        Urgencia urgenciaPrueba = new Urgencia(40404040, "Salomon", 20, 3);
        
        probarHospital(hospitalPrueba, ambulatorioPrueba, internadoPrueba, urgenciaPrueba);
    }
    
    public static void probarHospital(Hospital hospitalPrueba, Ambulatorio ambulatorioPrueba, Internado internadoPrueba, Urgencia urgenciaPrueba) {
        System.out.println(hospitalPrueba.contarConsultasMasCostosasQue(120000));
        
        hospitalPrueba.mostrarMedicoConMasUrgencias();
        
        System.out.println(hospitalPrueba.calcularPromedioCostoConsultaTipoPaciente(ambulatorioPrueba));
        System.out.println(hospitalPrueba.calcularPromedioCostoConsultaTipoPaciente(internadoPrueba));
        System.out.println(hospitalPrueba.calcularPromedioCostoConsultaTipoPaciente(urgenciaPrueba));
    }
}