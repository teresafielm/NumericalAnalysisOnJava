package proyecto.analisis.numerico;
import java.util.Scanner;
import static proyecto.analisis.numerico.ProyectoAnalisisNumerico.N;

public class GaussSeidel 
{
    double[][] A=new double[N][N];
    double[] B=new double[N];
    double imax;
    double tolerancia;
    int error;
    public void LlenarDatos()
    {
        int i,j;
        N=N-1;
        for(i=0;i<=N;i++)
        {
            for(j=0;j<=N;j++)
            {
             
                        System.out.println("Ingresa el valor de A"+i+j);
                        Scanner mat = new Scanner(System.in);
                        A[i][j]= mat.nextDouble();
            }
        }
        for(i=0;i<=N;i++)
        {
                System.out.println("Ingresa el valor de B"+i);
                Scanner mat = new Scanner(System.in);
                B[i]= mat.nextDouble();  
        }
        System.out.println("Ingresa el máximo número de iteraciones: ");
        Scanner Imax = new Scanner(System.in);
        imax= Imax.nextDouble();
        System.out.println("Ingresa el valor de la tolerancia: ");
        Scanner tol = new Scanner(System.in);
        tolerancia= tol.nextDouble();
    }
    public double[] GaussSeidel()
    {
        int c,i,j,k=0;
        double M=0,L=0,P;
        double[] Xk = new double[N+1];
        double[] Xkk=new double[N+1];
        N=N-1;
        for(c=0;c<=N;c++)
        {
            Xk[c]=0;
            Xkk[c]=0;
        }
        while(k<=imax)
        {
            for(i=0;i<=N;i++)
            {
                int i0=i;
                for(j=0;j<=i+1;j++)
                {
                    M=M+A[i][j]*Xkk[j];
                }
                for(j=i0+1;j<=N;j++)
                {
                    L=L+A[i][j]*Xkk[j];
                }
                double U,S;
                U=1/A[i][i];
                S=B[i]-M-L;
                Xkk[i]=U*S;
                }
                double[] mod=new double[N+1];
                for(k=0;k<=N;k++)
                {
                    mod[k]=Xk[k]+Xkk[k];
                }
                Modulo Modulo = new Modulo();
                P=Modulo.Modulo(mod, N);
                System.out.println("El valor de p es: "+P);
                if(P<=tolerancia)
                {
                    System.out.println("Procedimiento exitoso.");
                    System.out.println("El resultado es: ");
                    System.out.print("|");
                    for(i=0;i<=N;i++)
                    {
                        System.out.print(Xkk[i]+",");
                    }
                    System.out.print("|");
                    System.out.println("|5,10|");
                System.exit(0);
                }
            for(c=0;c<=N;c++)
            {
                Xk[c]=Xkk[c];
            }
            k=k+1;
        }
        System.out.println("Máximo número de iteraciones alcanzado");
        System.out.println("El resultado aproximado es: ");
        for(i=0;i<=N;i++)
        {
            System.out.println(Xk[i]+",");
        }
        System.out.print("|");
        return Xk;
    }
}