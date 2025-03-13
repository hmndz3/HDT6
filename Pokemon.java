// Clase para almacenar datos de Pokemon
public class Pokemon {
    private String nombre;
    private String tipo1;
    private String tipo2;
    private int total;
    private int hp;
    private int ataque;
    private int defensa;
    private int ataqueEsp;
    private int defensaEsp;
    private int velocidad;
    private int generacion;
    private boolean legendario;
    private String habilidades;

//--------------------------------------------------------------------------  
//Constructor de la clase Pokemon
    public Pokemon(String nombre, String tipo1, String tipo2, int total, int hp, int ataque, int defensa,
                  int ataqueEsp, int defensaEsp, int velocidad, int generacion, boolean legendario, String habilidades) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.total = total;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEsp = ataqueEsp;
        this.defensaEsp = defensaEsp;
        this.velocidad = velocidad;
        this.generacion = generacion;
        this.legendario = legendario;
        this.habilidades = habilidades;
    }

//--------------------------------------------------------------------------  
//Getters de todos los atributos
    public String getNombre() {
        return nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public int getTotal() {
        return total;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaqueEsp() {
        return ataqueEsp;
    }

    public int getDefensaEsp() {
        return defensaEsp;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getGeneracion() {
        return generacion;
    }

    public boolean isLegendario() {
        return legendario;
    }

    public String getHabilidades() {
        return habilidades;
    }

//--------------------------------------------------------------------------  
//ToString para mostrar la información completa del Pokemon
    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", tipo1='" + tipo1 + '\'' +
                ", tipo2='" + tipo2 + '\'' +
                ", total=" + total +
                ", hp=" + hp +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", ataqueEsp=" + ataqueEsp +
                ", defensaEsp=" + defensaEsp +
                ", velocidad=" + velocidad +
                ", generacion=" + generacion +
                ", legendario=" + legendario +
                ", habilidades='" + habilidades + '\'' +
                '}';
    }
}