package proyecto.analisis.numerico;

/**
 *
 * @author Tere
 */
public class MultMatrices {
    
    public double[][] MMatrices(double[][] A,double[][] B,int m,int n,int p)
    {
        int i,j,k;
        double[][] P = new double[m][n];
        for(i=0;i<=m;i++)
        {
            for(j=0;j<=n;j++)
            {
                for(k=0;k<=p;k++)
                {
                    P[i][j]=P[i][j]+A[i][k]*B[k][j];
                }
            }
        }
        return P;
    }
    
}
