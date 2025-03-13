import java.util.*;

public class OperacionesPokemon {
    private MapaPokemon todosLosPokemon;
    private ColeccionPokemonUsuario coleccionUsuario;
    
//--------------------------------------------------------------------------  
//Constructor que inicializa con el mapa de todos los Pokemon
    public OperacionesPokemon(MapaPokemon todosLosPokemon) {
        this.todosLosPokemon = todosLosPokemon;
        this.coleccionUsuario = new ColeccionPokemonUsuario();
    }
    
//--------------------------------------------------------------------------  
//Operación 1: Agregar un Pokemon a la colección del usuario
    public String agregarPokemonAColeccionUsuario(String nombre) {
        if (!todosLosPokemon.contieneLlave(nombre)) {
            return "Error: Pokemon '" + nombre + "' no encontrado en el dataset.";
        }
        
        if (coleccionUsuario.tienePokemon(nombre)) {
            return "Pokemon '" + nombre + "' ya está en tu colección.";
        }
        
        coleccionUsuario.agregarPokemon(nombre, todosLosPokemon);
        return "Pokemon '" + nombre + "' agregado a tu colección.";
    }
    
//--------------------------------------------------------------------------  
//Operación 2: Mostrar datos de un Pokemon específico
    public String getDatosPokemon(String nombre) {
        if (!todosLosPokemon.contieneLlave(nombre)) {
            return "Error: Pokemon '" + nombre + "' no encontrado en el dataset.";
        }
        
        Pokemon pokemon = todosLosPokemon.obtener(nombre);
        return formatearDatosPokemon(pokemon);
    }
    
//--------------------------------------------------------------------------  
//Método auxiliar para formatear los datos de un Pokemon
    private String formatearDatosPokemon(Pokemon pokemon) {
        return "Nombre: " + pokemon.getNombre() + "\n" +
               "Tipo1: " + pokemon.getTipo1() + "\n" +
               "Tipo2: " + pokemon.getTipo2() + "\n" +
               "Total: " + pokemon.getTotal() + "\n" +
               "HP: " + pokemon.getHp() + "\n" +
               "Ataque: " + pokemon.getAtaque() + "\n" +
               "Defensa: " + pokemon.getDefensa() + "\n" +
               "Ataque Esp.: " + pokemon.getAtaqueEsp() + "\n" +
               "Defensa Esp.: " + pokemon.getDefensaEsp() + "\n" +
               "Velocidad: " + pokemon.getVelocidad() + "\n" +
               "Generación: " + pokemon.getGeneracion() + "\n" +
               "Legendario: " + pokemon.isLegendario() + "\n" +
               "Habilidades: " + pokemon.getHabilidades();
    }
    
//--------------------------------------------------------------------------  
//Operación 3: Mostrar los Pokemon del usuario ordenados por Tipo1
    public String getPokemonUsuarioOrdenadosPorTipo1() {
        List<Map.Entry<String, String>> pokemonOrdenados = coleccionUsuario.getPokemonUsuarioOrdenadosPorTipo1(todosLosPokemon);
        
        if (pokemonOrdenados.isEmpty()) {
            return "Tu colección está vacía.";
        }
        
        StringBuilder resultado = new StringBuilder("Tus Pokemon ordenados por Tipo1:\n");
        for (Map.Entry<String, String> entrada : pokemonOrdenados) {
            resultado.append(entrada.getKey()).append(" (").append(entrada.getValue()).append(")\n");
        }
        
        return resultado.toString();
    }
    
//--------------------------------------------------------------------------  
//Operación 4: Mostrar todos los Pokemon ordenados por Tipo1
    public String getTodosLosPokemonOrdenadosPorTipo1() {
        // Crear una lista de pares (nombre, tipo1)
        List<Map.Entry<String, String>> pokemonConTipo = new ArrayList<>();
        
        for (Map.Entry<String, Pokemon> entrada : todosLosPokemon.getMapa().entrySet()) {
            pokemonConTipo.add(new AbstractMap.SimpleEntry<>(entrada.getKey(), entrada.getValue().getTipo1()));
        }
        
        // Ordenar por Tipo1
        pokemonConTipo.sort(Map.Entry.comparingByValue());
        
        StringBuilder resultado = new StringBuilder("Todos los Pokemon ordenados por Tipo1:\n");
        for (Map.Entry<String, String> entrada : pokemonConTipo) {
            resultado.append(entrada.getKey()).append(" (").append(entrada.getValue()).append(")\n");
        }
        
        return resultado.toString();
    }
    
//--------------------------------------------------------------------------  
//Operación 5: Mostrar Pokemon con una habilidad específica
    public String getPokemonConHabilidad(String habilidad) {
        List<String> pokemonConHabilidad = new ArrayList<>();
        
        for (Map.Entry<String, Pokemon> entrada : todosLosPokemon.getMapa().entrySet()) {
            if (entrada.getValue().getHabilidades().contains(habilidad)) {
                pokemonConHabilidad.add(entrada.getKey());
            }
        }
        
        if (pokemonConHabilidad.isEmpty()) {
            return "No se encontraron Pokemon con la habilidad '" + habilidad + "'.";
        }
        
        StringBuilder resultado = new StringBuilder("Pokemon con la habilidad '" + habilidad + "':\n");
        for (String nombre : pokemonConHabilidad) {
            resultado.append(nombre).append("\n");
        }
        
        return resultado.toString();
    }
    
//--------------------------------------------------------------------------  
//Getter para la colección del usuario
    public ColeccionPokemonUsuario getColeccionUsuario() {
        return coleccionUsuario;
    }
}