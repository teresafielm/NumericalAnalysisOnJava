package proyecto.analisis.numerico;
import java.util.Scanner;
import static proyecto.analisis.numerico.ProyectoAnalisisNumerico.N;

/**
 *
 * @author Tere
 */
public class Krylov {
    
    double[][] A = new double[N][N];
    double[][] Ax= new double[N][N];
    double[] B = new double[N];
    double[][] Y= new double[N][1];
    int error;
    
    public void LLenarA()
    {
        int i,j;
        N=N-1;
        for(i=0;i<=N;i++)
        {
            for(j=0;j<=N;j++)
            {
                Ax[i][j]=0;
            }
        }
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
            B[i]=0;
            if(i==0)
            {
              Y[i][0]=1;  
            }
            else
            {
                Y[i][0]=0;
            }
        }
    }
public int Krylov()
{
   int i,j;
   for(i=0;i<=N;i++)
   {
       for(j=0;j<=2;j++)
       {
       if(A[j][N-i]==0)
           Ax[j][N-i]=Y[i][0];
       else
       {
           double[][] X=new double[N+1][N+1];
           double[][] S=new double[N+1][1];
           double[][] Z=new double[N+1][N+1];
           PotMatrices x = new PotMatrices();
           X=x.PMatrices(A,N,i);
           MultMatrices y = new MultMatrices();
           S=y.MMatrices(A,Y,N,N,1);
           MultMatrices z = new MultMatrices();
           Z=z.MMatrices(X, S, N, N, 1);
           Ax[j][N-i]=Z[j][N-i];
       }
       }
       double[][] T=new double[N+1][N+1];
       double[][] F= new double[N+1][1];
       double[][] R = new double[N+1][1];
       PotMatrices An= new PotMatrices();
       MultMatrices Ln=new MultMatrices();
       MultMatrices Re=new MultMatrices();
       T=An.PMatrices(A,N,N);
       F=Ln.MMatrices(T,Y, N, N, 1);
       R=Re.MMatrices(T, F, N, N, 1);
       for(i=0;i<=N;i++)
       {
           B[i]=-1*R[i][0];
       }
   }
   double[] Res= new double[N];
   GaussJordan res = new GaussJordan();
   Res=res.GaussJordan(A, B, N);
   System.out.println("El polinomio característico es: ");
   int c;
   for(c=0;c<=N;c++)
   {
       System.out.println(Res[c]+" ");
   }
   return 1;
}
}