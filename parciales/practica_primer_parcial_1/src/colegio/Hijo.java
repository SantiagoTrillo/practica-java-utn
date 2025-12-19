package colegio;

public abstract class Hijo {
    private String nombre, apellido;
    private TipoArancel tipoArancel;

    public Hijo(String nombre, String apellido, TipoArancel tipoArancel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoArancel = tipoArancel;
    }

    public abstract double calcularCostoArancel();
    
    public String traducirTipoArancel() {
        String tipoAranceltraducido;
        
        tipoAranceltraducido = switch (tipoArancel) {
            case DESCUENTO_HERMANO -> "Descuento por hermano (10% de descuento)";
            case BECA -> "Beca (50% de descuento)";
            default -> "Completo";
        };
        
        return tipoAranceltraducido;
    }
    
    @Override
    public String toString() {
        return "Nombre del estudiante: " + nombre + "\nApellido del estudiante: " + apellido + "\nTipo de arancel: " + traducirTipoArancel();
    }

    public TipoArancel getTipoArancel() {
        return tipoArancel;
    }
}