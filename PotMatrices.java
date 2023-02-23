package proyecto.analisis.numerico;

/**
 *
 * @author Tere
 */
public class PotMatrices {
    
    public double[][] PMatrices(double[][] A,int N,int x)
    {
        int i,j,k;
        double[][] P = new double[N][N];
        do
        {
        for(i=0;i<=N-1;i++)
        {
            for(j=0;j<=N-1;j++)
            {
                for(k=0;k<=N-1;k++)
                {
                    P[i][j]=P[i][j]+A[i][k]*A[k][j];
                }
            }
        }
        x=x-1;
        }while(x>=2);
        return P;
    }
}
    

