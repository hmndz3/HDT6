import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PruebasAplicacionPokemon {
    private MapaPokemon mapaPokemon;
    private OperacionesPokemon operaciones;
    
    @Before
    public void configurarPruebas() {
        // Usar HashMap para pruebas
        mapaPokemon = FabricaMapaPokemon.crearMapa(1);
        
        // Agregar algunos Pokemon de prueba
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, "Grass", "Poison", 
                                         "Seed Pokémon", "0.7", "6.9", 
                                         "Overgrow, Chlorophyll", 1, false);
        Pokemon charmander = new Pokemon("Charmander", 4, "Fire", "", 
                                          "Lizard Pokémon", "0.6", "8.5", 
                                          "Blaze, Solar-power", 1, false);
        Pokemon pikachu = new Pokemon("Pikachu", 25, "Electric", "", 
                                        "Mouse Pokémon", "0.4", "6.0", 
                                        "Static, Lightning-rod", 1, false);
        
        mapaPokemon.agregar("Bulbasaur", bulbasaur);
        mapaPokemon.agregar("Charmander", charmander);
        mapaPokemon.agregar("Pikachu", pikachu);
        
        operaciones = new OperacionesPokemon(mapaPokemon);
    }
    
    /**
     * Prueba para el método agregarPokemonAColeccionUsuario
     * Este método es crítico porque maneja la funcionalidad principal 
     * de agregar Pokémon a la colección del usuario.
     */
    @Test
    public void testAgregarPokemonAColeccionUsuario() {
        // Caso 1: Agregar un Pokémon que existe
        String resultado1 = operaciones.agregarPokemonAColeccionUsuario("Pikachu");
        assertTrue("Debe confirmar que se agregó el Pokémon", 
                   resultado1.contains("agregado a tu colección"));
        assertTrue("El Pokémon debe estar en la colección", 
                   operaciones.getColeccionUsuario().tienePokemon("Pikachu"));
        
        // Caso 2: Intentar agregar un Pokémon que no existe
        String resultado2 = operaciones.agregarPokemonAColeccionUsuario("Mewtwo");
        assertTrue("Debe indicar que no se encontró el Pokémon", 
                   resultado2.contains("no encontrado"));
        assertFalse("El Pokémon no debe estar en la colección", 
                    operaciones.getColeccionUsuario().tienePokemon("Mewtwo"));
        
        // Caso 3: Intentar agregar un Pokémon que ya está en la colección
        String resultado3 = operaciones.agregarPokemonAColeccionUsuario("Pikachu");
        assertTrue("Debe indicar que el Pokémon ya está en la colección", 
                   resultado3.contains("ya está en tu colección"));
    }
    
    /**
     * Prueba para el método getTodosLosPokemonOrdenadosPorTipo1
     * Este método es crítico porque implementa la operación #4 requerida
     * y tiene la complejidad temporal analizada anteriormente.
     */
    @Test
    public void testGetTodosLosPokemonOrdenadosPorTipo1() {
        String resultado = operaciones.getTodosLosPokemonOrdenadosPorTipo1();
        
        // Verificar que el resultado contiene todos los Pokémon
        assertTrue("Debe contener a Bulbasaur", resultado.contains("Bulbasaur"));
        assertTrue("Debe contener a Charmander", resultado.contains("Charmander"));
        assertTrue("Debe contener a Pikachu", resultado.contains("Pikachu"));
        
        // Verificar el orden correcto: Electric, Fire, Grass
        int posElectric = resultado.indexOf("Electric");
        int posFire = resultado.indexOf("Fire");
        int posGrass = resultado.indexOf("Grass");
        
        assertTrue("Electric debe aparecer antes que Fire", posElectric < posFire);
        assertTrue("Fire debe aparecer antes que Grass", posFire < posGrass);
    }
}