// Clase fábrica para crear la implementación específica del mapa
public class FabricaMapaPokemon {
    public static MapaPokemon crearMapa(int tipoMapa) {
        switch (tipoMapa) {
            case 1:
                return new HashMapPokemon();
            case 2:
                return new TreeMapPokemon();
            case 3:
                return new LinkedHashMapPokemon();
            default:
                return new HashMapPokemon(); // Por defecto usar HashMap
        }
    }
}