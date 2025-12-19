package fabricamuebles;

public class PruebaFabrica {
    public static void main(String[] args) {
        FabricaMuebles fabricaPrueba = new FabricaMuebles("La Chula");
        
        probarFabrica(fabricaPrueba);
    }
    
    public static void probarFabrica(FabricaMuebles fabricaPrueba) {
        Mesa mesaPrueba = new Mesa(150, 70, EstiloMesa.MODERNA, "Dubai", 2000, 0.4);
        Silla sillaPrueba = new Silla(50, MaterialSilla.MADERA, "Hogareña", 7000, 0.2);
        Sillon sillonPrueba = new Sillon(3, TextilSillon.CUERO, "Luxor", 5000, 0.7);
        
        System.out.println(fabricaPrueba.fabricarMueble(mesaPrueba));
        System.out.println(fabricaPrueba.fabricarMueble(sillaPrueba));
        System.out.println(fabricaPrueba.fabricarMueble(sillonPrueba));
        
        System.out.println(fabricaPrueba.verificarFabricacionMueble(mesaPrueba));
        System.out.println(fabricaPrueba.verificarFabricacionMueble(sillaPrueba));
        System.out.println(fabricaPrueba.verificarFabricacionMueble(sillonPrueba));
        System.out.println(fabricaPrueba.verificarFabricacionMueble(new Mesa(200, 100, EstiloMesa.MODERNA, "Eclair", 5000, 0.4)));
        
        fabricaPrueba.mostrarFabrica();
    }
}