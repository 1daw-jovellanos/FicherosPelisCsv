import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 * Esta aplicaci�n es una modificaci�n de la que viste cuando estudiamos las
 * colecciones ordenadas.<br/>
 * 
 * Presenta dos novedades:
 * -Tiene un m�todo que logra grabar todas las pel�culas en un fichero de texto cuando termina la ejecuci�n.
 * -Tiene un m�todo que intenta recuperar las pel�culas de ese fichero.
 * 
 * El fichero se llama "pelis.bdt". La extensi�n me-la-he-inventado. Pero como es un fichero de texto, puedes
 * abrirlo con el block de notas.<b>POR FAVOR, HAZLO: ABRE EL FICHERO CON EL BLOCK DE NOTAS Y COMPRUEBA SU CONTENIDO</b>
 * 
 * El formato del texto es posicional: he separado los valores por comas al grabar, y conf�o en ello al leer.
 * 
 * Como los nombres de las pelis podr�an contener una coma, utilizo la t�cnica del "escapado" de cadenas.
 * 
 */

public class App {
    //Los dos SortedSet. Mira como los inicializamos en main(...)
    static SortedSet <Pelicula> setPelisPorAnno;
    static SortedSet <Pelicula> setPelisPorDuracion;

    /* ********************************************************************************************
     *************   M�TODOS PARA GUARDAR / RECUPERAR LOS DATOS EN FICHEROS ************************
     ******************************************************************************************** */

    /**
     * Método que repasa todas las pelis y las guarda en un fichero de texto, con un sistema posicional: separando los valores por comas.
     * En cada l�nea del fichero voy a guardar el t�tulo de la peli, el a�o y la duraci�n (separadas por comas)
     * 
     * Como el t�tulo es una cadena, podr�a contener una coma en su interior, y eso me fastidiar�a mi algorit
     */
    public static void guardarEnFichero(String nombreFichero) {
           // TO-DO


    }

    public static void cargarDelFichero(String nombreFichero) {
        setPelisPorAnno.clear();
        setPelisPorDuracion.clear();
        
        // TO - DO.
        // Cada peli leida se guarda en ambos  dos sets.

        
    }

    /**
     * Reemplaza cada coma ',' encontrada por una secuencia que me he inventado y que es ##COMA##
     * Esto se hace porque los datos pueden contener comas de manera natural, e interferir�an en nuestro proceso de
     * leer valores separados por comas.
     * 'Escapar' (t�rmino de argot vulgar, viene del ingl�s 'escape'), es evitar esos s�mbolos que podrian molestarnos.
     */
    public static String escaparComa(String s) {

        // TODO
        return "";
    }

    /**
     * Hace lo contrario. 'Desescapar', restaura la cadena 'escapada'.
     */
    public static String desEscaparComa(String s) {

       // TODO
       return "";
    }

    /* ********************************************************************************************
     *************   FIN DE LOS M�TODOS PARA FICHEROS **********************************************
     ******************************************************************************************** */

    //*************************
    //M�todos auxiliares de E/S
    //Ya los conoces
    //*************************

    static Scanner in ;

    public static String pedirCadena(String msg) {
        System.out.format("%s: ", msg);
        return in.nextLine();
    }

    public static int pedirEntero(String msg) {
        return Integer.parseInt(pedirCadena(msg));
    }

    public static int pedirEntero(String msg, int min, int max) {
        int resultado;
        boolean estaEnRango;

        do {
            resultado = Integer.parseInt(pedirCadena(String.format("%s [%d-%d]", msg, min, max)));
            estaEnRango = resultado >= min && resultado <= max;
            if (!estaEnRango) {
                System.out.format("   ERROR: El número introducido está fuera del rango.");
            }
        } while (!estaEnRango);
        return resultado;
    }

    //---------- M�todos para realizar cada accion "Quick&dirty".

    /** 
     * Pide los datos de una peli y la a�ade a los dos sets... sin m�s comprobaciones.
     */
    public static void annadirPeli() {
        String titulo;
        int anno, duracion;
        Pelicula p;

        titulo = pedirCadena("Introduce título");
        anno = pedirEntero("Introduce año de producción");
        duracion = pedirEntero("Introduce duración en minutos");
        //crear la peli
        p = new Pelicula(titulo, anno, duracion);
        //a�adirla a ambos sets
        setPelisPorAnno.add(p);
        setPelisPorDuracion.add(p);

        System.out.println("OK. Añadida");
    };

    /** 
     * Listar pelis... saca por pantalla los datos b�sicos de todas las pelis, en el orden del set por a�o
     */
    public static void listarPelisPorAnno() {
        int i = 0;
        if (setPelisPorAnno.isEmpty()) {
            System.out.println("NO HAY PELIS");
        } else {
            for (Pelicula p: setPelisPorAnno) {
                System.out.format("%d: ", i);
                System.out.println(p);
                i++;
            }
        }
    }

    /** 
     * Listar pelis por duraci�n... saca por pantalla los datos b�sicos de todas las pelis, en el orden 
     * del set por duraci�n. Este m�todo es id�ntico al anterior. Deber�amos aplicar DRY, pero este programa
     * es s�lo una aplicaci�n de prueba r�pida y poco elegante
     */
    public static void listarPelisPorDuracion() {
        int i = 0;
        if (setPelisPorAnno.isEmpty()) {
            System.out.println("NO HAY PELIS");
        } else {
            for (Pelicula p: setPelisPorDuracion) {
                System.out.format("%d: ", i);
                System.out.println(p);
                i++;
            }
        }
    }

    //el men�...
    public static void mainMenu() {
        int opcion;
        //t�pico bucle de men� de texto.
        do {
            System.out.println();
            System.out.println("*******************************************************************");
            System.out.println("* MENÚ PRINCIPAL (Prueba de colecciones ordenadas)                *");
            System.out.println("*******************************************************************");
            System.out.println("1.- Añadir peli a la lista (a ambos sets)");
            System.out.println("2.- Listar pelis siguiendo el set ordenado por defecto (año+título)");
            System.out.println("3.- Listar pelis siguiendo el set ordenado por comparador (duración+titulo)");
            System.out.println();
            System.out.println("0.-Salir");
            opcion = pedirEntero("\n-->Opcion", 0, 3);

            //Ejec
            if (opcion == 1) {
                annadirPeli();
            } else if (opcion == 2) {
                listarPelisPorAnno();
            } else if (opcion == 3) {
                listarPelisPorDuracion();
            }

        } while (opcion != 0);
    }

    //El main....    
    public static void main(String[] args) {
        //inicializar ambos setst. La clase TreeSet es un set basado internamente en un arbol
        //que implementa la interface sortedSet

        //Utilizamos constructor por defecto-->Orden por defecto programado en la clase Pelicula
        setPelisPorAnno = new TreeSet < Pelicula > ();

        //Utilizadmos constructor que acepta un conparador --> Orden establecido por el comparador
        setPelisPorDuracion = new TreeSet < Pelicula > (new ComparatorPelisPorDuracion());

        in = new Scanner(System.in); //Scanner para leer del teclado
        String nombreFicheroPersistencia = "pelis.bdt"; //La extensi�n me la he inventado. Es texto Unicode, al margen de la extensi�n que yo ponga.

        cargarDelFichero(nombreFicheroPersistencia);

        mainMenu(); //saltar al men�... La aplicaci�n principal.

        guardarEnFichero(nombreFicheroPersistencia);
        System.out.println("Adiós");

    }
}