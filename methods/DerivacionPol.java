package proyecto.analisis.numerico;
/*Creado por Teresa Fiel Muñoz*/
public class DerivacionPol {
    double b[];
    public double[] Derivo(int grado, double a[])
            {
                double b[];
                int j;
                int grad=grado;
                b= new double[grado+1];
                for(j=0;j<=grado;j++)
                {
                    b[j]=a[j]*grad;
                    grad=grad-1;
                }
            return b;    
            }
    
}
