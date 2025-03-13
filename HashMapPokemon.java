// Implementación concreta para HashMap
import java.util.HashMap;
import java.util.Map;

public class HashMapPokemon implements MapaPokemon {
    private Map<String, Pokemon> mapa;

//--------------------------------------------------------------------------  
//Constructor que inicializa el HashMap
    public HashMapPokemon() {
        mapa = new HashMap<>();
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