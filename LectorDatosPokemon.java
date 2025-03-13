import java.util.List;

public class LectorDatosPokemon {
    //--------------------------------------------------------------------------  
    //Función para leer los datos de Pokemon desde un archivo CSV y guardarlos en el mapa
    public static MapaPokemon leerDatosPokemonDesdeCSV(String rutaArchivo, MapaPokemon mapaPokemon) {
        try {
            List<String[]> datos = LectorCSV.leerCSV(rutaArchivo);
            
            // Saltar la fila de encabezado
            boolean esEncabezado = true;
            
            for (String[] linea : datos) {
                if (esEncabezado) {
                    esEncabezado = false;
                    continue;
                }
                
                try {
                    // Formato del CSV actual: Name,Pokedex Number,Type1,Type2,Classification,Height,Weight,Abilities,Generation,Legendary Status
                    // Mapear correctamente las columnas
                    String nombre = linea[0].trim(); // Name
                    String tipo1 = linea[2].trim();  // Type1
                    String tipo2 = linea[3].trim();  // Type2
                    
                    // Valores que no están en el CSV se ponen por defecto
                    int pokedexNum = Integer.parseInt(linea[1].trim());
                    int total = 0; // Valor por defecto
                    int hp = 0;    // Valor por defecto
                    int ataque = 0; // Valor por defecto
                    int defensa = 0; // Valor por defecto
                    int ataqueEsp = 0; // Valor por defecto
                    int defensaEsp = 0; // Valor por defecto
                    int velocidad = 0; // Valor por defecto
                    
                    // Generation está en el CSV
                    int generacion = Integer.parseInt(linea[8].trim());
                    
                    // Legendary status - convertir "Yes"/"No" a boolean
                    boolean legendario = linea[9].trim().equalsIgnoreCase("Yes");
                    
                    // Abilities está en el CSV
                    String habilidades = linea[7].trim();
                    
                    Pokemon pokemon = new Pokemon(nombre, tipo1, tipo2, total, hp, ataque, defensa, ataqueEsp, defensaEsp, velocidad, generacion, legendario, habilidades);
                    mapaPokemon.agregar(nombre, pokemon);
                    
                    // Agregamos también una versión con la primera letra en minúscula para búsqueda más flexible
                    if (nombre.length() > 0) {
                        String nombreMinuscula = nombre.substring(0, 1).toLowerCase() + nombre.substring(1);
                        if (!nombre.equals(nombreMinuscula)) {
                            mapaPokemon.agregar(nombreMinuscula, pokemon);
                        }
                    }
                    
                    // Debug - imprimir cada pokémon procesado
                    System.out.println("Pokémon cargado: " + nombre);
                    
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error al analizar la línea: " + String.join(",", linea));
                    e.printStackTrace();
                }
            }
            
            System.out.println("Total de pokémon cargados: " + mapaPokemon.getMapa().size());
            
        } catch (Exception e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
        
        return mapaPokemon;
    }
}