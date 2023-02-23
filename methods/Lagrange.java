package proyecto.analisis.numerico;
import static proyecto.analisis.numerico.ProyectoAnalisisNumerico.N;

import java.util.Scanner;

/*Método de Lagrange creado por Teresa Fiel Muñoz*/
public class Lagrange {
        
    double[] nodos= new double[N];
    double[] funcion= new double[N];
    double valor;
    public void PedirDatos()
    {
        int i=0;
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
    }
    public void Lagrange()
    {
    int i=0;
    double fvalor=0;
    while(i<=N-1)
            {               
                int j = 0;
                double L = 1;
                while(j <=N-1)
                {                                   
                    if (i !=j)
                    {
                        L = L *((valor - nodos[j]) / (nodos[i] - nodos[j]));
                    }
                    j=j+1;
                }
                fvalor=fvalor+(L*funcion[i]);
                i = i + 1;               
            }
            System.out.println("El valor es: " + fvalor);
    }
}
