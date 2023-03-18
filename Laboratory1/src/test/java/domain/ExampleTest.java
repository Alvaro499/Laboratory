package domain;

import static org.testng.Assert.*;

public class ExampleTest {

    //Tamaño de los arreglos a llenar
    private final int N=10000000; //example1, example2, example4
    private final int M=100000; //example3
    private final int P=2000; //example5
    private final int Q=3000; //example5

    //Creación de los arreglos
    private int a[];
    private int b[];
    private int c[];
    private int d[];

    //instancia de la clase con los ciclos a testear
    private Example example;

    //Constructor
    public ExampleTest() {
        //Se asigna el tamaño a los arreglos
        this.example = new Example();
        this.a = new int[N];
        this.b = new int[M];
        this.c = new int[P];
        this.d = new int[Q];

        //Se llenan los arreglos con el metodo fill(), el cual ejecuta random() y genera numeros
        //random para llenar los arreglos
        fill(a); fill(b); fill(c); fill(d);
    }

    //se esta llenando un arreglo de tamano N (1000000) con valores random hasta el 99
    //donde se emplea una semilla para evitar repetir valores random de forma consecutiva
    private void fill(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = util.Utility.random(99);
        }
    }

    @org.testng.annotations.BeforeMethod
    public void setUp() {
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
    }

    @org.testng.annotations.Test
    public void testExample1() {
        //Instancia de StopWatch, quien mide, calcula y recoge el tiempo de la
        //ejecución del método
        Stopwatch timer = new Stopwatch();

        //Se ejecutan las pruebas
        int result = example.example1(a);

        //Obtener el tiempo transcurrido del método
        double time = timer.elapsedTime();

        //Obtener el tiempo transcurrido del método, pero en String
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println(
                "Test Example 1"
                +"\nn: "+util.Utility.format(N)
                +"\nResult: "+util.Utility.format(result)
                +"\nTn: "+util.Utility.format(time)+" milliseconds"
                +"\nTn: "+hhmmss+"\n"
        );
    }

    @org.testng.annotations.Test
    public void testExample2() {

        //Se crea la instancia para calcular el tiempo, donde
        //el constructor automaticamente inicia el conteo
        Stopwatch timer = new Stopwatch();//--->(1) inicia el conteo

        //Se ejecuta el metodo
        int result = example.example2(a); //--->(2) se ejecuta el metodo inmediatamente

        //Se ejecutan los metodos elapsedTime para calcular
        double time = timer.elapsedTime();//--->(3) se calcula el tiempo durante la ejecucion del metodo
        String hhmmss = timer.elapsedTimeHMS();//--->(4) se calcula el tiempo durante la ejecucion del metodo
        System.out.println(
                "Test Example 2"
                        +"\nn: "+util.Utility.format(N)
                        +"\nResult: "+util.Utility.format(result)
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
                        +"\nTn: "+hhmmss+"\n"
        );
    }

    @org.testng.annotations.Test
    public void testExample3() {
        Stopwatch timer = new Stopwatch();
        int result = example.example3(b);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println(
                "Test Example 3"
                        +"\nn: "+util.Utility.format(M)
                        +"\nResult: "+util.Utility.format(result)
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
                        +"\nTn: "+hhmmss+"\n"
        );
    }

    @org.testng.annotations.Test
    public void testExample4() {
        Stopwatch timer = new Stopwatch();
        int result = example.example4(a);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println("Test Example 4"
                +"\nn: "+util.Utility.format(N)
                +"\nResult: "+ util.Utility.format(result)
                +"\nTn: "+ util.Utility.format(time) +" milliseconds"
                +"\nTn: "+ hhmmss+"\n"
        );
    }

    @org.testng.annotations.Test
    public void testExample5() {
        Stopwatch timer = new Stopwatch();
        int result = example.example5(c, d);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println("Test Example 5"
                +"\nn: "+util.Utility.format(P)
                +"\nm: "+util.Utility.format(Q)
                +"\nResult: "+ util.Utility.format(result)
                +"\nTn: "+ util.Utility.format(time) +" milliseconds"
                +"\nTn: "+ hhmmss+"\n"
        );
    }
}