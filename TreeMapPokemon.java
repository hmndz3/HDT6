// Implementación concreta para TreeMap
import java.util.Map;
import java.util.TreeMap;

public class TreeMapPokemon implements MapaPokemon {
    private Map<String, Pokemon> mapa;

//--------------------------------------------------------------------------  
//Constructor que inicializa el TreeMap
    public TreeMapPokemon() {
        mapa = new TreeMap<>();
    }

//--------------------------------------------------------------------------  
//Implementación de los métodos de la interfaz
    @Override
    public void agregar(String nombre, Pokemon pokemon) {
        mapa.put(nombre, pokemon);
    }

    @Override
    public Pokemon obtener(String nombre) {
        return mapa.get(nombre);
    }

    @Override
    public boolean contieneLlave(String nombre) {
        return mapa.containsKey(nombre);
    }

    @Override
    public Map<String, Pokemon> getMapa() {
        return mapa;
    }
}
