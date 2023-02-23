package proyecto.analisis.numerico;

import java.util.Scanner;
import static proyecto.analisis.numerico.ProyectoAnalisisNumerico.N;

/*Creado por Teresa Fiel*/
public class TercerOrdenD {
    double[] nodos= new double[N];
    double[] funcion= new double[N];
    double valor,r,r2,h1,h2,H;
    int subindice;
    
    public void PedirDatosTercerOD()
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
        System.out.println("Ingresa el valor de x para el que deseas obtener la derivada: ");
        Scanner val = new Scanner(System.in);
        valor=val.nextDouble();
        i=0;
        while(valor!=nodos[i])
        {
            i=i+1;
        }
        subindice=i;
        H=nodos[1]-nodos[0];
    }
    public int DerivadaTO()
    {
        int[] Y0={-11,18,-9,2};
        int[] Y1={-2,-3,6,-1};
        int[] Y2={1,-6,3,2};
        int[] Y3={1,-6,3,2};
        int[] Yx0={2,-5,4,-1};
        int[] Yx1={1,-2,1,0};
        int[] Yx2={0,1,-2,1};
        int[] Yx3={1,4,-5,2};
        double[] D=new double[4];
        double[] D2=new double[4];
        int i,n=N;
        
        switch(subindice)
        {
            case 0:
            for(i=0;i<=3;i++)
            {
                D[i]=funcion[i]*Y0[i];
                D2[i]=funcion[i]*Yx0[i];
            }
            for(i=0;i<=2;i++)
            {
                D[i+1]=D[i+1]+D[i];
                D2[i+1]=D2[i+1]+D2[i];
            }
            break;
            case(1):
            for(i=0;i<=3;i++)
            {
                D[i]=funcion[i]*Y1[i];
                D2[i]=funcion[i]*Yx1[i];
            }
            for(i=0;i<=2;i++)
            {
                D[i+1]=D[i+1]+D[i];
                D2[i+1]=D2[i+1]+D2[i];
            }
            break;
            case(2):
            for(i=0;i<=3;i++)
            {
                D[i]=funcion[i]*Y2[i];
                D2[i]=funcion[i]*Yx2[i];
            }
            for(i=0;i<=2;i++)
            {
                D[i+1]=D[i+1]+D[i];
                D2[i+1]=D2[i+1]+D2[i];
            }
            break;
            default:
            if(subindice==N-2)
            {
                for(i=3;i<=0;i--)
                {
                    D[4-i]=funcion[N-i+1]*Y1[i-4];
                    D2[4-i]=funcion[N-i+1]*Yx1[i-4];
                }
                for(i=0;i<=2;i++)
                {
                    D[i+1]=D[i+1]+D[i];
                    D2[i+1]=D2[i+1]+D2[i];
                }
            }
            else
            {
                if(subindice==N-1)
                {
                    for(i=3;i<=0;i--)
                    {
                        D[4-i]=funcion[N-i+1]*Y2[i-4];
                        D2[4-i]=funcion[N-i+1]*Yx2[i-4];
                    }
                    for(i=0;i<=2;i++)
                    {
                        D[i+1]=D[i+1]+D[i];
                        D2[i+1]=D2[i+1]+D2[i];  
                    }
                }
                else
                {
                    if(subindice==N)
                    {
                        for(i=3;i<=0;i--)
                        {
                            D[4-i]=funcion[N-i+1]*Y3[i-4];
                            D2[4-i]=funcion[N-i+1]*Yx3[i-4];
                        }
                        for(i=0;i<=2;i++)
                        {
                            D[i+1]=D[i+1]+D2[i];
                            D2[i+1]=D2[i+1]+D2[i];
                        }
                    }
                    else
                    {
                    if(subindice!=0)
                    {    
                        for(i=0;i<=3;i++)
                    {
                        D[i]=funcion[subindice+i-1]*Y1[i];
                        D2[i]=funcion[subindice+i-1]*Yx1[i];
                    }
                    for(i=0;i<=2;i++)
                    {
                        D[i+1]=D[i+1]+D[i];
                        D2[i+1]=D2[i+1]+D2[i];
                    }
                    }
                    }
            }
            }
             break;
        }
        h1=1/(6*H);
        h2=1/(H*H);
        r=h1*D[3];
        r2=h2*D2[3];
        System.out.println("La primera derivada de "+valor+" es: "+r+"+er");
        System.out.println("La segunda derivada de "+valor+" es: "+r2+"+er");
        return 1;
    }
}