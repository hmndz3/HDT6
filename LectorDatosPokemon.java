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
                    // Formato del CSV actual: 
                    // Name, Pokedex Number, Type1, Type2, Classification, Height (m), Weight (kg), Abilities, Generation, Legendary Status
                    
                    // Mapear correctamente las columnas
                    String nombre = linea[0].trim(); // Name
                    int pokedexNum = Integer.parseInt(linea[1].trim()); // Pokedex Number
                    String tipo1 = linea[2].trim();  // Type1
                    String tipo2 = linea[3].trim();  // Type2
                    String clasificacion = linea[4].trim(); // Classification
                    String altura = linea[5].trim();  // Height (m)
                    String peso = linea[6].trim();    // Weight (kg)
                    String habilidades = linea[7].trim(); // Abilities
                    int generacion = Integer.parseInt(linea[8].trim()); // Generation
                    
                    // Legendary status - convertir "Yes"/"No" a boolean
                    boolean legendario = linea[9].trim().equalsIgnoreCase("Yes");
                    
                    Pokemon pokemon = new Pokemon(nombre, pokedexNum, tipo1, tipo2, clasificacion, 
                                                 altura, peso, habilidades, generacion, legendario);
                                                 
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