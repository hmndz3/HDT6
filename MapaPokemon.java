import java.util.Map;

public interface MapaPokemon {
    void agregar(String nombre, Pokemon pokemon);
    Pokemon obtener(String nombre);
    boolean contieneLlave(String nombre);
    Map<String, Pokemon> getMapa();
}