package guarderianautica;

public class Fecha {
    private int año;
    private int mes;
    private int día;
    private int númeroDía; // Dia del año correspondiente a esta fecha.
    private static final int[] díasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // La estructura que guarda la cantidad de dí­as del mes será compartida por todas las instancias de Fecha.

    public Fecha(int año, int mes, int día) {
        this.año = año;
    	this.mes = mes;
    	this.día = día;
    	calcularDíaDelAño();
    	verificarFecha();
    }

    private void verificarFecha() {
        //Primero verifica que la fecha pertenezca a este año y no a uno posterior.
        int días = (verificarAñoBisiesto(año)) ? 366 : 365;
        
    	while (númeroDía > días) {
            númeroDía -= días;
            año++;
            días = (verificarAñoBisiesto(año)) ? 366 : 365;
        }
        // Ya quedan menos dias que los que tiene el año. Verifica el mes.
	int mesAuxiliar = 1;
	días = getDíasMes(mesAuxiliar);
        
	while (númeroDía > días) {
            númeroDía -= días;
            mesAuxiliar++;
            días = getDíasMes(mesAuxiliar);
	}
        // Se suma 1 para no guardar el mes en "base cero".
	mes = mesAuxiliar;
	día = númeroDía;
    }

    private void calcularDíaDelAño() {
    	this.númeroDía = 0;
    	for (int m = 1; m < mes; m++) {
            this.númeroDía += getDíasMes(m);
	}
	númeroDía += día;
    }
    
    public static boolean verificarAñoBisiesto(int anio) {
    	return ((anio % 4 == 0) && (anio % 400 != 0));
    }

    private int getDíasMes(int mes) {
    	return getDíasMes(this.año, mes);
    }

    public static int getDíasMes(int año, int mes) {
    	int dias = díasMes[mes - 1];
    	if (mes == 2 && verificarAñoBisiesto(año)){
            dias++;
        }
        return dias;
    }

    public int getDía() {
    	return día;
    }

    public int getMes() {
    	return mes;
    }

    public int getAño() {
        return año;
    }

    public int getNúmeroDía() {
        return númeroDía;
    }

    @Override
    public String toString() {
	return String.format("%s/%s/%s", día, mes, año);
    }
}