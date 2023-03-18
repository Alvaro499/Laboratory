package domain;

public class Recursive {


    public double mcd(int a,int b){
        double result;
        if (b==0){
            result = a;
        }else{
            result = mcd(b,a%b);
        }
        return result;

    }
    public int ackerman(int a, int b){
        int result;
        if (a == 0){

            result = b+1;

        }else if(a > 0 && b == 0){

            result = ackerman(a-1,1);
        }else{
            result = ackerman(a-1,ackerman(a,b-1));

        }
        return result;
    }

    public int min(int[] a, int index,int value){

        if (a.length-1 < index){
            //si el indice es mayor al tamano del arreglo
            //devolver el valor actual y detener la recursividad
            return value;
        }else{
            if (value > a[index]) {
                value = a[index];
                return min(a,index+1,value);
            }else{
                return min(a,index+1,value);
            }
        }
    }




}
