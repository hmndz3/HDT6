// Clase para almacenar datos de Pokemon
public class Pokemon {
    private String nombre;
    private int pokedexNum;
    private String tipo1;
    private String tipo2;
    private String clasificacion;
    private String altura;
    private String peso;
    private String habilidades;
    private int generacion;
    private boolean legendario;

//--------------------------------------------------------------------------  
//Constructor de la clase Pokemon
    public Pokemon(String nombre, int pokedexNum, String tipo1, String tipo2, 
                   String clasificacion, String altura, String peso, 
                   String habilidades, int generacion, boolean legendario) {
        this.nombre = nombre;
        this.pokedexNum = pokedexNum;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.clasificacion = clasificacion;
        this.altura = altura;
        this.peso = peso;
        this.habilidades = habilidades;
        this.generacion = generacion;
        this.legendario = legendario;
    }

//--------------------------------------------------------------------------  
//Getters de todos los atributos
    public String getNombre() {
        return nombre;
    }

    public int getPokedexNum() {
        return pokedexNum;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getAltura() {
        return altura;
    }

    public String getPeso() {
        return peso;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public int getGeneracion() {
        return generacion;
    }

    public boolean isLegendario() {
        return legendario;
    }

//--------------------------------------------------------------------------  
//ToString para mostrar la información completa del Pokemon
    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", pokedexNum=" + pokedexNum +
                ", tipo1='" + tipo1 + '\'' +
                ", tipo2='" + tipo2 + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", altura='" + altura + '\'' +
                ", peso='" + peso + '\'' +
                ", habilidades='" + habilidades + '\'' +
                ", generacion=" + generacion +
                ", legendario=" + legendario +
                '}';
    }
}