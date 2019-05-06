import java.util.*;

/**
 * Esta es una clase para representar un criterio de ordenaci�n adicional para las pel�culas
 * de nuestra aplicacion. <br/>
 * La interface Comparator<T> obliga a implementar un m�todo <code>int compare(T t1, T t2)</code>
 * que funciona de manera similar a compareTo. Necesita dos par�metros porque esta clase es <i>ajena</i> a la
 * clase Pelicula, as� que <b>this</b> no es una pel�cula, sino el propio comparador... Ambas pel�culas a
 * comparar deben ser recibidas como par�metro.
 */
public class ComparatorPelisPorDuracion implements Comparator < Pelicula > {

    /**
     *  Compara dos pel�culas, en el orden que especifiquemos... en este caso por duraci�n, y si duran
     *  lo mismo, lexicogr�ficamente por t�tulo ignorando may�sculas y min�sculas.
     *  <br/> el m�todo compareTo devuelve:
     *  <ul>
     *  <li>Un negativo si en nuestro orden, p1 va ANTES que p2</li>
     *  <li>Un positivo si en nuestro orden, p1 va DESPU�S que p2 (o dicho de otra manera, p2 deber�a ir ANTES que p1)</li>
     *  <li>Un 0 si en nuestro orden, no nos importa cu�l vaya delante o detr�s... consideramos que ambas 
     *      pueden ocupar la misma posici�n o son iguales </li>
     *  </ul>
     *  
     *  @param p1 Una peli
     *  @param p2 Otra peli
     *  @return Lo mismo de siempre... un negativo si p1 va delante, un positivo si p2 va delante, un 0 si ninguna
     *  de las dos va delante
     */

    public int compare(Pelicula p1, Pelicula p2) {
        int resultado = p1.getDuracion() - p2.getDuracion();
        if (resultado == 0) {
            resultado = p1.getTitulo().compareToIgnoreCase(p2.getTitulo());
        }

        return resultado;
    }
}