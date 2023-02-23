package proyecto.analisis.numerico;

import java.util.Scanner;

/* Creado por Teresa Fiel Muñoz
 */
public class ProyectoAnalisisNumerico {
    
    static int N;

    public static void main(String[] args) 
    {
        int menu;
        int error;
        System.out.println("---PROYECTO ANÁLISIS NUMÉRICO--");
        System.out.println("");
        System.out.println("    Menú:");
        System.out.println("1.Newton-Raphson.");
        System.out.println("2.Crout.");
        System.out.println("3.Gauss-Seidel.");
        System.out.println("4.Krylov.");
        System.out.println("5.Interpolación por polinomio de Lagrange.");
        System.out.println("6.Newton-Gregory en avance.");
        System.out.println("7.Derivación con tercer orden de interpolación.");
        System.out.println("8.Integración con Regla de Simpson 1/3.");
        System.out.println("9.Runge-Kutta de 4to orden.");
        System.out.println("10.Factores cuadráticos.");
        do{
        try
        {
        Scanner sc = new Scanner(System.in);
        error= sc.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Ingresa solo números enteros. Error encontrado: "+e);
            error=0;
        }
        }while(error==0);
        menu=error;

        switch(menu)
        {
            case 1:
                NewtonRaphson metodo = new NewtonRaphson();
                metodo.leePol();
                metodo.pideValoresdeEntrada();
                metodo.DerivadasFuncion();
                metodo.FuncionNewtonRaphson();
            break;
            case 2:
                System.out.println("Ingrese grado del sistema a resolver: ");
                Scanner scc = new Scanner(System.in);
                N= scc.nextInt();
                Crout metodoCrout = new Crout();
                metodoCrout.LlenarMatrices();
                metodoCrout.Crout();
            break;
            case 3:
                System.out.println("Ingrese grado del sistema a resolver: ");
                Scanner scj = new Scanner(System.in);
                N= scj.nextInt();
                GaussSeidel metodoGaussSeidel = new GaussSeidel();
                metodoGaussSeidel.LlenarDatos();
                metodoGaussSeidel.GaussSeidel();
            break;
            case 4:
                System.out.println("Ingrese grado del sistema a resolver: ");
                Scanner sck = new Scanner(System.in);
                N= sck.nextInt();
                Krylov metodoKrylov= new Krylov();
                metodoKrylov.LLenarA();
                metodoKrylov.Krylov();
            break;
            case 5:
                System.out.println("Ingrese el número de datos: ");
                Scanner scl = new Scanner(System.in);
                N= scl.nextInt();
                Lagrange metodoLagrange=new Lagrange();
                metodoLagrange.PedirDatos();
                metodoLagrange.Lagrange();
            break;
            case 6:
            System.out.println("Ingrese el número de datos: ");
            Scanner scng = new Scanner(System.in);
            N= scng.nextInt();
            break;
            case 7:
            System.out.println("Ingrese el número de datos: ");
            Scanner sctod = new Scanner(System.in);
            N= sctod.nextInt();
            TercerOrdenD metodoDerivacion = new TercerOrdenD();
            metodoDerivacion.PedirDatosTercerOD();
            metodoDerivacion.DerivadaTO();
            break;
            case 8:
            Simpson scs=new Simpson();
            scs.PedirDatosSimpson();
            scs.Simpson();
            break;
            case 9:
            RungeKutta metodoRungeKutta4 = new RungeKutta();
            metodoRungeKutta4.pedirDatos();
            metodoRungeKutta4.RungeKutta();
            break;
            case 10:
            System.out.println("Este método solo calcula raíces de polinomios de la forma ax*2+b*x+c");
            FactoresCuadraticos metodoFC = new FactoresCuadraticos();
            metodoFC.pedirDatosFC();
            metodoFC.FactoresCuadraticos();
            break;
            default:
                System.out.println("Lo siento, debes ingresar un número entero del 1-9.");
                break;
        }
    }
}