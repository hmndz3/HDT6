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
                        // Suponiendo el formato CSV: Nombre,Tipo1,Tipo2,Total,HP,Ataque,Defensa,AtaqueEsp,DefensaEsp,Velocidad,Generacion,Legendario,Habilidades
                        int idx = 0;
                        String nombre = linea[idx++];
                        String tipo1 = linea[idx++];
                        String tipo2 = linea[idx++];
                        int total = Integer.parseInt(linea[idx++]);
                        int hp = Integer.parseInt(linea[idx++]);
                        int ataque = Integer.parseInt(linea[idx++]);
                        int defensa = Integer.parseInt(linea[idx++]);
                        int ataqueEsp = Integer.parseInt(linea[idx++]);
                        int defensaEsp = Integer.parseInt(linea[idx++]);
                        int velocidad = Integer.parseInt(linea[idx++]);
                        int generacion = Integer.parseInt(linea[idx++]);
                        boolean legendario = Boolean.parseBoolean(linea[idx++]);
                        String habilidades = linea.length > idx ? linea[idx] : "";
                        
                        Pokemon pokemon = new Pokemon(nombre, tipo1, tipo2, total, hp, ataque, defensa, ataqueEsp, defensaEsp, velocidad, generacion, legendario, habilidades);
                        mapaPokemon.agregar(nombre, pokemon);
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error al analizar la línea: " + String.join(",", linea));
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al leer el archivo CSV: " + e.getMessage());
            }
            
            return mapaPokemon;
        }
    }