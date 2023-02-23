package proyecto.analisis.numerico;
import java.util.Scanner;
import static proyecto.analisis.numerico.ProyectoAnalisisNumerico.N;

/*Creado por Teresa Elpidia Fiel Muñoz*/
public class Crout 
{
    
    double[][] L = new double[N][N];
    double[][] U = new double[N][N];
    double[][] A = new double[N][N];
    double[] B = new double[N];
    double[] Y = new double[N];
    double[] X = new double[N];
    int error;
    
    public void LlenarMatrices()
    {
        N=N-1;
        int i,j;
        for(i=0;i<=N;i++)
        {
            for(j=0;j<=N;j++)
            {
             L[i][j]=0;
            }
        }
        for(i=0;i<=N;i++)
        {
            for(j=0;j<=N;j++)
            {
                if (i==j)
                    U[i][j]=1;
                else    
                    U[i][j]=0;
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
                        System.out.println("Ingresa el valor de B"+i);
                        Scanner mat = new Scanner(System.in);
                        B[i]= mat.nextDouble();
            }
        
    }
    public double Crout()
    {
        int j=1,i=1;
        int ks,j0=0;
        double w=0;
        double[] q=new double[N];
        double[] z=new double[N];
        L[0][0]=A[0][0];
        if (L[0][0]*U[0][0]==0)
        {
            System.out.println("Factorización imposible.");
            return 0;
        }        
        while(j<=N)
        {
           U[0][j]=A[0][j]/L[0][0];
           L[j][0]=A[j][0];
           j=j+1;
        }
        while(i<=N-1)
        {
           double[] r=new double[N+1];
           double[] t=new double[N+1];
           double[] p=new double[N+1];
           double[] v=new double[N+1];
           int k;
           int i0=i,i01=i;
           int s=0;
           for(i01=1;i01<=N-1;i01++)
           {
            for(k=0;k<=i0;k++)
            {
                r[s]=r[s]+ L[i][k]*U[k][i];
            }
           s=s+1;
           }
            L[i][i]=A[i][i]-r[i-1];
            if(U[i][i]*L[i][i]==0)
            {
                System.out.println("Factorización Imposible");
                return 0;
            } 
            s=0;
            for(j=i+1;j<=N;j++)//i=2 j=3 k=1
            {
                for(k=0;k<=i-1;k++)
                {
                 t[s]=t[s]+L[i][k]*U[k][j];   
                 v[s]=v[s]+L[j][k]*U[k][i];
                }
            double h,l;
            h=1/L[i][i];
            l=A[i][j]-t[i-1];
            U[i][j]=h*l;
            L[j][i]=A[j][i]-v[i-1];    
            s=s+1;
            }
        i=i+1;
        }
        for(ks=0;ks<=N-1;ks++)
        {
            w=w+L[N][ks]*U[ks][N];
        }
        L[N][N]=A[N][N]-w;
        if(L[N][N]*U[N][N]==0)
            {
                System.out.println("Factorización Imposible");
                return 0;
            }
        Y[0]=B[0]/L[0][0];
        for(i=1;i<=N;i++)
        {
            for(j=0;j<=i-1;j++)
            {
                q[j0]=q[j0]+L[i][j]*Y[j];
            }
        double m,n;
        m=1/L[i][i];
        n=B[i]-q[i-1];
        Y[i]=m*n;
        j0=j0+1;
        }
        X[N]=Y[N]/U[N][N];
        int y=0;
        for(i=N-1;i>=0;i--)//i=2 j=3
        {
            for(j=i+1;j<=N;j++)
            {
                z[y]=z[y]+U[i][j]*X[j];
            }
            double ñ;
            ñ=1/U[i][i];
            X[i]=ñ*Y[i]-z[y];
            y=y+1;
        }
        System.out.println("La solución es: ");
        for(i=0;i<=N;i++)
        {
            System.out.println("X["+i+"]="+X[i]);
        }
        return 1;
    }
}
