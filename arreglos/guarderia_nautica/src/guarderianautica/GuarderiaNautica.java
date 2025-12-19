package guarderianautica;

public class GuarderiaNautica {
    private final Embarcacion[][] embarcaciones;
    private final int CAMAS = 4, NIVELES = 2;
    private int primerNivelLibre, primeraCamaLibre;
    private Fecha fechaActual;

    public GuarderiaNautica(Fecha fechaActual) throws IllegalArgumentException {
        this.embarcaciones = new Embarcacion[NIVELES][CAMAS];
        primerNivelLibre = 0;
        primeraCamaLibre = 0;
        setFechaActual(fechaActual);
    }

    public void mostrarPagosEmbarcaciones() {
        System.out.println("-----Pagos por embarcacion-----");
        for (int i = 0; i <= primerNivelLibre; i++) {
            for (Embarcacion embarcación : embarcaciones[i]) {
                if (embarcación != null) {
                    System.out.println(embarcación + "\nTotal recaudado: " + embarcación.calcularTotalAbonado(fechaActual) + "\nDeuda: " + embarcación.verificarDeuda(fechaActual));
                }
            }
        }
    }
    
    public void registrarPago(String patentePagador, double montoPagado, int dniPagador) {
        Embarcacion embarcacionBuscada = buscarEmbarcacion(patentePagador);
        
        if (embarcacionBuscada != null) {
            if (embarcacionBuscada.verificarDeuda(fechaActual)) {
                embarcacionBuscada.registrarPago(montoPagado, dniPagador, fechaActual);
            }
        }
    }
    
    public void agregarEmbarcación(String patenteNueva, Fecha fechaActual) {
        if (primerNivelLibre < NIVELES) {
            embarcaciones[primerNivelLibre][primeraCamaLibre] = new Embarcacion(patenteNueva, fechaActual, (primerNivelLibre + 1) * 10 + primeraCamaLibre + 1);
            primeraCamaLibre++;
            
            if (primeraCamaLibre == CAMAS) {
                primerNivelLibre++;
                primeraCamaLibre = 0;
            }
        }
    }
    
    private Embarcacion buscarEmbarcacion(String patenteBuscada) {
        int nivel = 0;
        int cama;
        Embarcacion embarcaciónBuscada = null;
        
        while (nivel < NIVELES && nivel <= primerNivelLibre && embarcaciónBuscada == null) {
            cama = 0;
            
            while(cama < CAMAS && embarcaciónBuscada == null) {
                if (embarcaciones[nivel][cama] != null && embarcaciones[nivel][cama].getPatente().equals(patenteBuscada)) {
                    embarcaciónBuscada = embarcaciones[nivel][cama];
                } else {
                    cama++;
                }
            }
            nivel++;
        }
        return embarcaciónBuscada;
    }
    
    private void setFechaActual(Fecha fechaActual) throws IllegalArgumentException {
        if (fechaActual == null) {
            throw new IllegalArgumentException("(Guardería) La fecha actual no puede estar vacía.");
        }
        this.fechaActual = fechaActual;
    }
}