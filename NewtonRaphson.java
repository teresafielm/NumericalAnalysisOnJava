package proyecto.analisis.numerico;

    import java.io.*;
    import java.lang.*;
    import java.util.*; 

public class NewtonRaphson 
{
    
    int grado;
    double a[];
    double p0;
    double e1;
    double e2;
    double TOL;
    int N;
        
    public void leePol()
    {
        System.out.println("Ingrese grado del polinomio: ");
        Scanner sc = new Scanner(System.in);
        grado= sc.nextInt();
        a = new double[grado+1];
        int i;
        for(i=0;i<=grado;i++)
        {
                System.out.println("Valor del coeficiente "+ i+": ");
                a[i] = sc.nextDouble();
        }
    }
    public void pideValoresdeEntrada()
        {
            System.out.println("Ingresa el valor aproximado de la función: ");
            Scanner sc = new Scanner(System.in);
            p0 = sc.nextDouble();
            System.out.println("Ingresa el valor de la tolerancia: ");
            Scanner sc2 = new Scanner(System.in);
            TOL = sc2.nextDouble();
            System.out.println("Ingresa el número de iteraciones que quieres que realice el método: ");
            Scanner sc3 = new Scanner(System.in);
            N = sc3.nextInt();
        }
        public void DerivadasFuncion()
        {
            double d1[];
            double d2[];
            int g;
            g=grado-1;
            DerivacionPol d= new DerivacionPol();
            d1= d.Derivo(grado,a);
            Evaluacion e = new Evaluacion();
            e1= e.Evaluacion(grado,p0,d1);
            d2=d.Derivo(grado, a);
            e2= e.Evaluacion(g,p0,d2);
            
        }
        public double FuncionNewtonRaphson()
        {
            int i=1;
            while (i<=N)
            {
                double p;
                p= (p0-e1)/e2;
                if(Math.abs(p-p0)<TOL)
                {
                    System.out.println("Proceso exitoso, el valor obtenido es: "+p);
                    return p;
                }
                else
                {
                    i=i+1;
                    p0=p;
                }
            System.out.println("Error, el método ha fracasado después de "+N+" iteraciones");   
            }
        return 0;
        }
}

