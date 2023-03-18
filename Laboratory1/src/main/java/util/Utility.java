package util;

import java.text.DecimalFormat;
import java.util.Random;

public class Utility {
    private static Random random;
    private static long seed; //semilla para el random

    //static initializer: siempre se ejecutará esta porción de código cuando se llame al metodo Utility
    static {
        //devolver el tiempo actual en milisegundos
        seed = System.currentTimeMillis();

        //la instancia random irá generando números aleatorios, pero tomando como
        //límite la hora actual, es decir que cada vez que se ejecute esta linea, será
        //imposible que se repitan números, debido al cambio de hora y además por que son
        //números mas pequeños que cero
        random = new Random(seed);
    }

    public static int random(int bound){
        //return 1+(int)Math.floor(Math.random()*bound);
        return 1+random.nextInt()*bound;
    }

    public static String format(double value) {
        return new DecimalFormat("###,###,###.##")
                 .format(value);
    }

    //método que recibe un arreglo de enteros, e ira reemplazando los valores
    //que posee con los aleatorios asignados en random
    public static void fill(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = random(99);
        }
    }

    //
    public static int[] generador(int max,int cant) {
        int array[] = new int[cant];
        int tamanho = array.length;
        for (int i = 0; i < tamanho; i++) {
            array[i] = (int) (Math.random()*max) ;
        }
        return array;
    }
}
