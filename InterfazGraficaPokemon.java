// Interfaz gráfica simple para el gestor de Pokemon
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InterfazGraficaPokemon extends JFrame {
    private MapaPokemon mapaPokemon;
    private OperacionesPokemon operaciones;
    private JTextArea areaResultado;
    private JTextField campoEntrada;
    
//--------------------------------------------------------------------------  
//Constructor de la interfaz gráfica
    public InterfazGraficaPokemon() {
        setTitle("Gestor de Pokemon");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Inicializar componentes
        inicializarComponentes();
        
        // Mostrar la ventana
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
//--------------------------------------------------------------------------  
//Método para inicializar todos los componentes de la interfaz
    private void inicializarComponentes() {
        // Panel superior para selección de mapa
        JPanel panelSuperior = new JPanel();
        JLabel etiquetaSeleccionMapa = new JLabel("Seleccionar Implementación de Mapa:");
        JComboBox<String> comboMapa = new JComboBox<>(new String[]{"HashMap", "TreeMap", "LinkedHashMap"});
        JButton botonSeleccionar = new JButton("Cargar");
        
        panelSuperior.add(etiquetaSeleccionMapa);
        panelSuperior.add(comboMapa);
        panelSuperior.add(botonSeleccionar);
        
        // Panel central para mostrar resultados
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane panelDesplazable = new JScrollPane(areaResultado);
        
        // Panel inferior para entrada y operaciones
        JPanel panelInferior = new JPanel(new BorderLayout());
        JPanel panelEntrada = new JPanel(new BorderLayout());
        campoEntrada = new JTextField();
        JButton botonEjecutar = new JButton("Ejecutar");
        
        panelEntrada.add(new JLabel("Entrada:"), BorderLayout.WEST);
        panelEntrada.add(campoEntrada, BorderLayout.CENTER);
        panelEntrada.add(botonEjecutar, BorderLayout.EAST);
        
        JPanel panelOperaciones = new JPanel(new GridLayout(5, 1));
        JButton botonAgregar = new JButton("1. Agregar Pokemon a Tu Colección");
        JButton botonMostrarDatos = new JButton("2. Mostrar Datos de Pokemon");
        JButton botonPokemonUsuario = new JButton("3. Mostrar Tus Pokemon Ordenados por Tipo1");
        JButton botonTodosPokemon = new JButton("4. Mostrar Todos los Pokemon Ordenados por Tipo1");
        JButton botonHabilidad = new JButton("5. Mostrar Pokemon con Habilidad");
        
        panelOperaciones.add(botonAgregar);
        panelOperaciones.add(botonMostrarDatos);
        panelOperaciones.add(botonPokemonUsuario);
        panelOperaciones.add(botonTodosPokemon);
        panelOperaciones.add(botonHabilidad);
        
        panelInferior.add(panelEntrada, BorderLayout.NORTH);
        panelInferior.add(panelOperaciones, BorderLayout.CENTER);
        
        // Añadir paneles a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(panelDesplazable, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        
        // Añadir ActionListeners
        botonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tipoMapa = comboMapa.getSelectedIndex() + 1;
                inicializarMapa(tipoMapa);
            }
        });
        
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operaciones == null) {
                    areaResultado.setText("Por favor, selecciona primero una implementación de mapa.");
                    return;
                }
                
                String nombrePokemon = campoEntrada.getText().trim();
                if (nombrePokemon.isEmpty()) {
                    areaResultado.setText("Por favor, ingresa un nombre de Pokemon.");
                    return;
                }
                
                String resultado = operaciones.agregarPokemonAColeccionUsuario(nombrePokemon);
                areaResultado.setText(resultado);
            }
        });
        
        botonMostrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operaciones == null) {
                    areaResultado.setText("Por favor, selecciona primero una implementación de mapa.");
                    return;
                }
                
                String nombrePokemon = campoEntrada.getText().trim();
                if (nombrePokemon.isEmpty()) {
                    areaResultado.setText("Por favor, ingresa un nombre de Pokemon.");
                    return;
                }
                
                String resultado = operaciones.getDatosPokemon(nombrePokemon);
                areaResultado.setText(resultado);
            }
        });
        
        botonPokemonUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operaciones == null) {
                    areaResultado.setText("Por favor, selecciona primero una implementación de mapa.");
                    return;
                }
                
                String resultado = operaciones.getPokemonUsuarioOrdenadosPorTipo1();
                areaResultado.setText(resultado);
            }
        });
        
        botonTodosPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operaciones == null) {
                    areaResultado.setText("Por favor, selecciona primero una implementación de mapa.");
                    return;
                }
                
                String resultado = operaciones.getTodosLosPokemonOrdenadosPorTipo1();
                areaResultado.setText(resultado);
            }
        });
        
        botonHabilidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operaciones == null) {
                    areaResultado.setText("Por favor, selecciona primero una implementación de mapa.");
                    return;
                }
                
                String habilidad = campoEntrada.getText().trim();
                if (habilidad.isEmpty()) {
                    areaResultado.setText("Por favor, ingresa una habilidad.");
                    return;
                }
                
                String resultado = operaciones.getPokemonConHabilidad(habilidad);
                areaResultado.setText(resultado);
            }
        });
    }
    
//--------------------------------------------------------------------------  
//Método para inicializar el mapa según la selección del usuario
    private void inicializarMapa(int tipoMapa) {
        try {
            mapaPokemon = FabricaMapaPokemon.crearMapa(tipoMapa);
            
            // Ruta al archivo CSV dentro del proyecto
            String rutaArchivo = "pokemon.csv"; // El archivo debe estar en la raíz del proyecto
            areaResultado.setText("Cargando datos de Pokemon desde " + rutaArchivo + "...");
            
            // Leer datos de Pokemon desde CSV
            mapaPokemon = LectorDatosPokemon.leerDatosPokemonDesdeCSV(rutaArchivo, mapaPokemon);
            operaciones = new OperacionesPokemon(mapaPokemon);
            
            areaResultado.setText("Datos de Pokemon cargados exitosamente!\n\n" +
                    "Implementación de Mapa: " + (tipoMapa == 1 ? "HashMap" : tipoMapa == 2 ? "TreeMap" : "LinkedHashMap") + "\n" +
                    "Total de Pokemon: " + mapaPokemon.getMapa().size() + "\n\n" +
                    "Ahora puedes usar las operaciones de abajo. Para las operaciones 1, 2 y 5, ingresa el nombre del Pokemon o la habilidad en el campo de entrada.");
        } catch (Exception e) {
            areaResultado.setText("Error al inicializar el mapa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}