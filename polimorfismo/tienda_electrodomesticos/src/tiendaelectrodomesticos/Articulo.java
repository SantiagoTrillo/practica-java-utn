package tiendaelectrodomesticos;

public class Articulo {
    private String codigo;
    private Resistencia resistenciaEmbalaje;
    private Fabrica fabricante;

    public Articulo(String codigo, Resistencia resistenciaEmbalaje, Fabrica fabricante) throws IllegalArgumentException {
        setCodigo(codigo);
        setResistenciaEmbalaje(resistenciaEmbalaje);
        setFabricante(fabricante);
    }

    public String getCodigo() {
        return codigo;
    }

    public Resistencia getResistenciaEmbalaje() {
        return resistenciaEmbalaje;
    }

    public Fabrica getFabricante() {
        return fabricante;
    }

    private void setCodigo(String codigo) throws IllegalArgumentException {
        if (codigo.strip().isEmpty()) {
            throw new IllegalArgumentException("(Articulo) el codigo no puede estar vacio.");
        }
        this.codigo = codigo;
    }

    private void setResistenciaEmbalaje(Resistencia resistenciaEmbalaje) throws IllegalArgumentException {
        if (resistenciaEmbalaje == null) {
            throw new IllegalArgumentException("(Articulo) la resistencia del embalaje no puede ser nula.");
        }
        this.resistenciaEmbalaje = resistenciaEmbalaje;
    }

    private void setFabricante(Fabrica fabricante) throws IllegalArgumentException {
        if (fabricante == null) {
            throw new IllegalArgumentException("(Articulo) el fabricante no puede ser nulo.");
        }
        this.fabricante = fabricante;
    }
}