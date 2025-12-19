package cafetera;

public class Cafetera {
    private double capacidadMaxima, cantidadActual;
    
    public Cafetera() throws IllegalArgumentException {
        this(1000, 0);
    }
    
    public Cafetera(double capacidadMaxima) throws IllegalArgumentException {
        this(capacidadMaxima, 0);
    }
    
    public Cafetera(double capacidadMaxima, double cantidadActual) throws IllegalArgumentException {
        this.setCapacidadMaxima(capacidadMaxima);
        this.setCantidadActual(cantidadActual);
    }
    
    public void llenar() {
        this.setCantidadActual(capacidadMaxima);
    }
    
    public boolean servirTaza(double capacidadTaza) {
        boolean operacion = false;
        
        if (cantidadActual >= capacidadTaza) {
            this.setCantidadActual(cantidadActual - capacidadTaza);
            operacion = true;
            System.out.println("Se pudo servir la cantidad solicitada de cafe.");
        } else if (cantidadActual == 0) {
            System.out.println("No se pudo servir la cantidad solicitada de cafe.");
        } else {
            System.out.println("Se sirvió parcialmente: " + cantidadActual + " ml.");
            this.setCantidadActual(0);
            operacion = true;
        }
        return operacion;
    }

    public void vaciar() {
        this.setCantidadActual(0);
    }
    
    public double agregarCafe(double cafeNuevo) {
        double cafeSobrante = 0;
        
        if (cafeNuevo <= (capacidadMaxima - cantidadActual)) {
            this.setCantidadActual(cantidadActual + cafeNuevo);
            System.out.println("Se pudo agregar todo el cafe.");
        } else if (cafeNuevo > (capacidadMaxima - cantidadActual)) {
            this.setCantidadActual(capacidadMaxima);
            cafeSobrante = (cantidadActual + cafeNuevo) - capacidadMaxima;
            System.out.println("Se pudo agregar todo el cafe, y sobraron " + cafeSobrante + "ml.");
        } else if (cafeNuevo == 0) {
            System.out.println("No se pudo agregar el cafe.");
        }
        return cafeSobrante;
    }
    
    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    private void setCapacidadMaxima(double capacidadMaxima) throws IllegalArgumentException {
        if (capacidadMaxima < 250) {
            throw new IllegalArgumentException("La capacidad maxima no puede ser menor a 250ml.");
        }
        if (capacidadMaxima > 1000) {
            throw new IllegalArgumentException("La capacidad maxima no puede ser mayor a 1000ml.");
        }
        
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    private void setCantidadActual(double cantidadActual) throws IllegalArgumentException {
        if (cantidadActual < 0) {
            throw new IllegalArgumentException("La cantidad actual no puede ser un numero negativo");
        }
        if (cantidadActual > capacidadMaxima) {
            throw new IllegalArgumentException("La cantidad actual no puede exceder la capacidad maxima de la cafetera");
        }
        
        this.cantidadActual = cantidadActual;
    }
}