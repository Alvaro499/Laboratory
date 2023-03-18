package domain;

import java.util.Arrays;

import static org.testng.Assert.*;
public class RecursiveTest {
    private Recursive recursive;
    private int resultados[];
    private int a[][] = {{3, 5}, {2, 4}, {6, 8}, {3, 6}, {4, 8}, {10, 14}};
    private String result1 = "mcd test...";
    private String result2 = "ackermanTest test...\n";
    private String result3 = "minimo test... \n";
    public RecursiveTest(){
        recursive = new Recursive();

    }
    @org.testng.annotations.Test
    public void mcdTest(){
        result1 = "mcd test...";
        int fila = a.length;//6

        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < fila; i++){
            result1 += "\nmcd(" + a[i][0] + "," + a[i][1] + ") == " + recursive.mcd(a[i][0],a[i][1]);
        }
        double time = timer.elapsedTime();
        //String hhmmss = timer.elapsedTimeHMS();
        System.out.println(
                "\n" + result1
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
        );
    }


    @org.testng.annotations.Test
    public void ackermanTest(){
        int a[] = util.Utility.generador(4,6);
        int tamanho = a.length;
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < tamanho -1; i++) {
            result2 += "\n(" + a[i] + ")" + "(" + a[i+1] + ") == " + recursive.ackerman(a[i], a[i+1]);
        }
        double time = timer.elapsedTime();
        System.out.println(
                "\n" + result2
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
        );
    }


    @org.testng.annotations.Test
    public void minTest(){
        int a[] = util.Utility.generador(501,100);
        int tamanho = a.length;
        int count = 0;
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < tamanho; i++){
            result3 += a[i] + " ";
            if (++count == 20){
                result3+="\n";
                count = 0;
            }
        }
        double time = timer.elapsedTime();
        result3 += "\n" + recursive.min(a,0,a[0]);
        System.out.println(
                "\n" + result3
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
        );
    }

}