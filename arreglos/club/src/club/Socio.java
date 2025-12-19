package club;

public class Socio {
    private String nombre;
    private double[][] cuotasMensuales;
    private final int MESES = 12, CANTIDAD_IMPORTES = 2;

    public Socio(String nombre, double valorCuota) throws IllegalArgumentException {
        this.nombre = nombre;
        cuotasMensuales = new double[MESES][CANTIDAD_IMPORTES];
        for (double[] cuota : cuotasMensuales) {
            cuota[0] = valorCuota;
            cuota[1] = valorCuota;
        }
    }
    
    public boolean procesarPago(double dineroDisponible) {
        int i = 0;
        boolean pagoProcesado = false;
        
        while(dineroDisponible > 0 && i < cuotasMensuales.length) {
            if (cuotasMensuales[i][1] > 0) {
                if (dineroDisponible > cuotasMensuales[i][1]) {
                    dineroDisponible -= cuotasMensuales[i][1];
                    cuotasMensuales[i][1] = 0;
                } else {
                    cuotasMensuales[i][1] -= dineroDisponible;
                    dineroDisponible = 0;
                }
                pagoProcesado = true;
            }
            i++;
        }
        return pagoProcesado;
    }
    
    public void mostrarDeuda() {
        double deuda = 0;
        
        System.out.println("Detalle de la deuda de " + nombre);
        
        for (int i = 0; i < cuotasMensuales.length; i++) {
            if (cuotasMensuales[i][1] > 0) {
                int mes = i + 1;
                deuda += cuotasMensuales[i][1];
                System.out.println("Mes: " + mes + "\nDeuda: " + cuotasMensuales[i][1]);
            }
        }
        System.out.println("La deuda total de " + nombre + " es de " + deuda + " pesos.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre.strip().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        
        this.nombre = nombre;
    }
}