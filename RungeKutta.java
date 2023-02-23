package proyecto.analisis.numerico;
import java.util.Scanner;
/*Creado por Teresa Fiel*/
public class RungeKutta {
    
    double x0,y0,x,h;
    
    public void pedirDatos()
    {
      System.out.println("Ingresa el valor de x0: ");
      Scanner a0 = new Scanner(System.in);
      x0=a0.nextDouble();
      System.out.println("Ingresa el valor de y0: ");
      Scanner b0 = new Scanner(System.in);
      y0=b0.nextDouble();
      System.out.println("Ingresa el valor de x: ");
      Scanner a = new Scanner(System.in);
      x=a.nextDouble();
      System.out.println("Ingresa el valor de h: ");
      Scanner H = new Scanner(System.in);
      h=H.nextDouble();
    }

    double Deriv(double x, double y)
    {
        return (1000-3*y);
    }

    public void RungeKutta()
    {
        RungeKutta d1 = new RungeKutta();
        
        int i;
        int n = (int)((x - x0) / h);
        double r1, r2, r3, r4;
        double y = y0;
        
        for (i=1;i<=n;i++) 
        {
            r1 = h*(d1.Deriv(x0, y));
            r2 = h*(d1.Deriv(x0 +0.5*h,y+0.5*r1));
            r3 = h*(d1.Deriv(x0 +0.5*h,y+0.5*r2));
            r4 = h*(d1.Deriv(x0 +h,y+r3));
 
            y =(y+(1.0/6.0)*(r1+2*r2+2*r3+r4));
             
            x0=x0+h;
        }
        System.out.println("El valor calculado de y en x="+x+" es: "+y);
    }
}