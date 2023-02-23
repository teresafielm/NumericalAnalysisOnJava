package proyecto.analisis.numerico;

/*Creado por Teresa Fiel Muñoz*/
public class GaussJordan {

    public double[] GaussJordan(double[][] A,double[] B,int N) 
    {
        int i,s,x,y;
        double d,c;
        for(i=0;i<=N-1;i++)
        {
            d=A[i][i];
            for(s=0;s<=N-1;s++)
            {
                A[i][s]=((A[i][s])/d);
            }
            B[i]=((B[i])/d);
            for(x=0;x<=N-1;x++)
            {
                if(i!=x)
                {
                    c=A[x][i];
                    for(y=0;y<=N-1;y++)
                    {
                        A[x][y]=A[x][y]-c*A[i][y];
                    }
                    B[x]=B[x]-c*B[i];
                }
            }
        }
    return B;
    }
}