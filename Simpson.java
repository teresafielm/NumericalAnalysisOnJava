package proyecto.analisis.numerico;
import java.util.Scanner;

/*Creado por Teresa Fiel*/
public class Simpson {
    
    double limi,limsu;
    int CASO=0;
    String funcion;
    double func;
    
    public void PedirDatosSimpson()
    {
            /*Scanner caso = new Scanner(System.in);
            System.out.println("Ingresa la naturaleza de la función que deseas integrar: ");
            System.out.println("1.Trigonométrica.");
            System.out.println("2.Polinómica.");
            System.out.println("3.Trascendente.");
            CASO=caso.nextInt();
            System.out.println("Ingresa la función que deseas integrar: ");
            Scanner ffunc = new Scanner(System.in);
            funcion = ffunc.nextLine();*/
            Scanner limiteinferior = new Scanner(System.in);
            System.out.print("Ingresa el límite inferior: ");
            limi = limiteinferior.nextDouble();
            Scanner limitesuperior = new Scanner(System.in);
            System.out.print("Ingresa el límite superior: ");
            limsu = limitesuperior.nextDouble();
    }
  public void Simpson() 
  {
    final int n = 1000;
    double h=(limsu-limi)/n; 
    double suma=f(limi)+f(limsu);
    if(CASO==1)
    {
        limi=limi*(Math.PI/180);
        limsu=limsu*(Math.PI/180);
    }
    for(int i=1; i<=n; i=i+2)
    suma+=4*f(limi+i*h);

    for(int i=2; i<=n; i=i+2)
    suma+=2*f(limi+i*h);
    
    System.out.println("La integral aproximada de tu función es: "+(suma*h/3));
   } 
    
  public double f(double x) 
    {
    return Math.pow(1.6,2)*9*1/Math.pow(x,2);
    }
}