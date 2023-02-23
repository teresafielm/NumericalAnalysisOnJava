package proyecto.analisis.numerico;
import java.util.Scanner;

public class FactoresCuadraticos 
{
    double a,b,c;
    double r1 = 0;
    double r2 = 0;
    
    public void pedirDatosFC()
    {
        System.out.println("Ingresa el valor de a: ");
        Scanner ax = new Scanner(System.in);
        a = ax.nextDouble();
        System.out.println("Ingresa el valor de b: ");
        Scanner bx = new Scanner(System.in);
        b = bx.nextDouble();
        System.out.println("Ingresa el valor de c: ");
        Scanner cx = new Scanner(System.in);
        c = cx.nextDouble();

    }
    
    public void FactoresCuadraticos()
    {
        double discriminante=(b*b)-4*(a*c);
 
        if (discriminante>0)
        {
            r1=(-b+Math.sqrt(discriminante))/(2*a);
            r2=(-b-Math.sqrt(discriminante))/(2*a);
            System.out.println("Las raíces de la ecuación son: " + r1 + " y " + r2);
        }
        if (discriminante==0)
        {
            r1=-b/(2*a);
            r2=-b/(2*a);
            System.out.println("Las raíces de la ecuación son: " +r1+" y "+r2);
        }
        if (discriminante<0)
        {
            System.out.println("Lo siento, tu ecuación no tiene raíces reales.");
        }    
    }
}