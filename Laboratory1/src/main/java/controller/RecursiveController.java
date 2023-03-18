package controller;

import domain.Recursive;
import domain.Stopwatch;
import domain.TestData;
import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;

public class RecursiveController
{
    //Inicializar atributos para los metodos a testear
    //private domain.Recursive recursive;
    private Recursive recursive;
    private int resultados[];
    private int a[][] = {{3, 5}, {2, 4}, {6, 8}, {3, 6}, {4, 8}, {10, 14}};
    private String result1 = "mcd test...";
    private String result2 = "ackermanTest test...\n";
    private String result3 = "minimo test... \n";

    //Metodo para la recoleccion de datos del testeo
    private TestData testData[];

    //Etiqueta para graficos y textArea
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private BarChart barChart;

//    public RecursiveController() {
//    }

    //EJECUTAR METODOS PARA EL TESTEO
    @javafx.fxml.FXML
    public void initialize() {
        this.recursive = new Recursive();
        this.testData = new TestData[3]; //TestData array
        this.textArea.setText(mcdTest()+"\n"+ackermanTest()+"\n"+minTest());


        //BarChart info
        barChartGetData();
    }

    private void barChartGetData() {
        barChart.getData().add(
                new XYChart.Series<String, Double>("Recursive Class",
                        FXCollections.observableArrayList(
                                new XYChart.Data<String, Double>(testData[0].getInfo(), testData[0].getTime()),
                                new XYChart.Data<String, Double>(testData[1].getInfo(), testData[1].getTime()),
                                new XYChart.Data<String, Double>(testData[2].getInfo(), testData[2].getTime()))
                ));
    }
    public String mcdTest(){
        result1 = "m.c.d test...";
        int fila = a.length;//6

        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < fila; i++){
            result1 += "\nmcd(" + a[i][0] + "," + a[i][1] + ") == " + this.recursive.mcd(a[i][0],a[i][1]);
        }
        double time = timer.elapsedTime();
        this.testData[0] = new TestData("mcd", time);
        //String hhmmss = timer.elapsedTimeHMS();
        //System.out.println(
        result1 += "\nTn: "+util.Utility.format(time)+" milliseconds\n";
        //);
        return result1;
    }

    public String ackermanTest(){
        result2 = "Ackerman test...";
        int a[] = util.Utility.generador(4,16);
        int tamanho = a.length;
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < tamanho -1; i++) {
            result2 += "\n(" + a[i] + ")" + "(" + a[i+1] + ") == " + this.recursive.ackerman(a[i], a[i+1]);
        }
        double time = timer.elapsedTime();
        this.testData[1] = new TestData("Ackerman ", time);
        result2 += "\nTn: "+util.Utility.format(time)+" milliseconds\n";
        return result2;
    }

    public String minTest(){
        result3 = "Min test...";
        int a[] = util.Utility.generador(101,100);
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
        this.testData[2] = new TestData("min", time);
        result3 += "\n" + recursive.min(a,0,a[0]);
        result3 +="\nTn: "+util.Utility.format(time)+" milliseconds\n";
        return result3;
    }

}

