package proyecto.analisis.numerico;

public class Evaluacion{
    public double Evaluacion(int grado, double p0, double b[])
    {
        double c=0.0;
        int k;
        for(k=0;k<=grado-1;k++)
        {
            c=b[k]*(p0)*Math.pow(p0,grado);
        }
        return c;    
    }
}
