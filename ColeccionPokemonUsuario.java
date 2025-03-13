import java.util.*;

public class ColeccionPokemonUsuario {
    private Set<String> pokemonUsuario; // Usando un Set para almacenar los nombres de Pokémon del usuario

//--------------------------------------------------------------------------  
//Constructor que inicializa la colección como un HashSet
    public ColeccionPokemonUsuario() {
        // Usando HashSet para búsquedas O(1) y sin duplicados
        pokemonUsuario = new HashSet<>();
    }
    
//--------------------------------------------------------------------------  
//Método para agregar un Pokemon a la colección del usuario
    public boolean agregarPokemon(String nombre, MapaPokemon todosLosPokemon) {
        if (!todosLosPokemon.contieneLlave(nombre)) {
            return false; // El Pokémon no existe en el dataset
        }
        
        return pokemonUsuario.add(nombre); // Devuelve false si ya está en la colección
    }
    
//--------------------------------------------------------------------------  
//Método para verificar si un Pokemon ya está en la colección del usuario
    public boolean tienePokemon(String nombre) {
        return pokemonUsuario.contains(nombre);
    }
    
//--------------------------------------------------------------------------  
//Método para obtener los nombres de todos los Pokemon del usuario
    public Set<String> getNombresPokemonUsuario() {
        return pokemonUsuario;
    }
    
//--------------------------------------------------------------------------  
//Método para obtener los Pokemon del usuario ordenados por Tipo1
    public List<Map.Entry<String, String>> getPokemonUsuarioOrdenadosPorTipo1(MapaPokemon todosLosPokemon) {
        List<Map.Entry<String, String>> pokemonConTipo = new ArrayList<>();
        
        for (String nombrePokemon : pokemonUsuario) {
            Pokemon pokemon = todosLosPokemon.obtener(nombrePokemon);
            if (pokemon != null) {
                pokemonConTipo.add(new AbstractMap.SimpleEntry<>(nombrePokemon, pokemon.getTipo1()));
            }
        }
        
        // Ordenar por Tipo1
        pokemonConTipo.sort(Map.Entry.comparingByValue());
        
        return pokemonConTipo;
    }
}