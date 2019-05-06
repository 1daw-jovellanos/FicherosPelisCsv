/**
 * Esta es una clase de ejemplo para ilustrar el orden de los objetos en una colección
 * <br/>
 * Vamos a programar un orden por defecto para las películas:
 * Se van a ordenar cronológicamente por año, y si el año coincide, lexicográficamente por título,
 * ignorando mayúsculas y minúsculas.
 * <br/>
 * implementar la interface Comparable<Pelicula> <i>obliga</i> a redefinir el m�todo compareTo y parametriza el
 * tipo con el operador diamante ( <..> ) lo cual es una ayuda, pero no es estrictamente necesario.
 */

public class Pelicula implements Comparable < Pelicula > {

    private int anno;
    private int duracion;
    private String titulo;

    public Pelicula(String titulo, int anno, int duracion) {
        this.anno = anno;
        this.duracion = duracion;
        this.titulo = titulo;
    }

    public void setAnno(int a) {
        this.anno = a;
    }

    public int getAnno() {
        return anno;
    }

    public void setDuracion(int d) {
        this.duracion = d;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setTitulo(String t) {
        this.titulo = t;
    }

    public String getTitulo() {
        return titulo;
    }

    /**
     * Criterio de comparaci�n por defecto.<br/>
     * Las pel�culas se van a ordenar por defecto cronol�gicamente por a�o
     * Y si el a�o coincide, por t�tulo.
     * <br/> el m�todo compareTo devuelve:
     * <ul>
     * <li>Un negativo si en nuestro orden, this va ANTES que p</li>
     * <li>Un positivo si en nuestro orden, this va DESPU�S que p (o dicho de otra manera, p deber�a ir ANTES que this)</li>
     * <li>Un 0 si en nuestro orden, no nos importa cu�l vaya delante o detr�s... consideramos que ambas pueden ocupar la misma posici�n o son iguales </li>
     * </ul>
     */

    public int compareTo(Pelicula p) {
        int resultado = this.getAnno() - p.getAnno();
        if (resultado == 0) {
            //si los a�os son iguales
            //comparamos el t�tulo
            resultado = this.getTitulo().compareToIgnoreCase(p.getTitulo());

        }
        return resultado;
    }

    /**
     * S�lo para para prop�sitos de prueba y dupuraci�n, redefinimos el m�todo toString() heredado de Object
     */
    public String toString() {
        return String.format("%40s, a�o %4d, %4d minutos", getTitulo(), getAnno(), getDuracion());
    }

}