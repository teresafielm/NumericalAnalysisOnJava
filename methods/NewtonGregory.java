/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.analisis.numerico;
import java.util.ArrayList;
import java.util.Scanner;
import static proyecto.analisis.numerico.ProyectoAnalisisNumerico.N;

/*Derivación por método de Newton-Gregory*/
public class NewtonGregory {
    double[] nodos= new double[N];
    double[] funcion= new double[N];
    ArrayList<double[]> ListadeArreglos= new ArrayList<>();
    double valor;
    
    public void PedirDatosNG()
    {
        int i=0,subindice;
        double h,k;
        while(i<=N-1)
        {
            System.out.println("Ingresa el valor de x"+i+": ");
            Scanner nodo = new Scanner(System.in);
            nodos[i]=nodo.nextDouble();
            System.out.println("Ingresa el valor de fx"+1+": ");
            Scanner func = new Scanner(System.in);
            funcion[i]=func.nextDouble();
            i=i+1;
        }
        System.out.println("Ingresa el valor de x que deseas interpolar: ");
        Scanner val = new Scanner(System.in);
        valor=val.nextDouble();
    ListadeArreglos.add(nodos);
    ListadeArreglos.add(funcion);
    i=0;
    h=nodos[i+1]-nodos[i];
    while(nodos[i]<=valor && valor<=nodos[i+1])
    {
        i=i+1;
    }
    subindice=i;
    k=(valor-nodos[subindice])/h;
    }
    public int NewtonGregory()
    {
        int i=0;
        double[] X= new double[N];
        for(i=0;i<=N-1;N++)
        {
            
            ListadeArreglos.add(X);
        }
        return 1;
    }
    
}
