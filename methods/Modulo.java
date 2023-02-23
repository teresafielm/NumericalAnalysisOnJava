package proyecto.analisis.numerico;

/*Creado por Teresa Fiel*/
public class Modulo {
    
    public int Modulo(double[] X,int N)
    {
        int i,res=0;
        double[] R=new double[N+1];
        for(i=0;i<=N;i++)
        {
            R[i]=X[i];
        }
        for(i=0;i<=N;i++)
        {
            R[i]=Math.pow(R[i],2);
        }
        for(i=0;i<=N-1;i++)
        {
            R[i+1]=R[i+1]+R[i];
        }
        R[N]=res;
    return res;    
    }
    
}
