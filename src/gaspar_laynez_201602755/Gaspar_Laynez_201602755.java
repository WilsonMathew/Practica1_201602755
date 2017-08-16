package gaspar_laynez_201602755;
import java.util.Scanner;
/**
 *
 * @author Gaspar Wilson Laynez Mateo
 */

public class Gaspar_Laynez_201602755 {
    
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Doing menu
        bienvenida();
        menu();
    }
       
    public static void juego(int n, String nivel){
         
        //Mostrando titulo
        System.out.println("                    " + nivel);

        // Arreglos de filas y columnas
        String filas[] = new String[n];
        String columnas[] = new String[n];
        
        //Mostrar columnas indentadas
        for(int i = 0; i < filas.length; i++){
            
            System.out.print("                   ");
            
            for(int j = 0; j < columnas.length; j++){
                System.out.print("[X]");
            }
            
            System.out.print("                  ");
            System.out.println("");   
        }
        
        char opJuego = opcionJuego();
        System.out.println("char:  " + opJuego);
        
    }
    
    // muestra opciones y regresa un caracter que el usuario ingreso
    public static char opcionJuego(){
        
        Scanner opJ = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("                 -----------------------------");
        System.out.println("");

        System.out.println("                    Voltear: V");
        System.out.println("                    Reiniciar: R"); 
        System.out.println("                    Salir: S");

        System.out.println("");
        System.out.println("                    Ingresar Opcion:"); 
        
        char opcion = opJ.next().trim().charAt(0);
        
        return opcion;
    }

    // Menu funcional. Dirije opciones segun opcion seleccionada.
    public static void menu(){
        int opcion;
        do{
        
           opcion = menuText();
            
        switch(opcion){
            case 1:
                opcion = 4;
                juego(4,"NIVEL PRINCIPIANTE");
                break;
            case 2:
                opcion = 4;
                juego(6,"NIVEL INTERMEDIO");
                break;
            case 3:
                opcion = 4;
                juego(8,"NIVEL EXPERTO");
                break;
            case 4:
                break;
            default :
                System.out.println();
                System.out.println("Usten escojio: " + opcion + " Opcion invalida, elija del 1 al 4");
                System.out.println(" ");
                break;
        }
        
        }while(opcion != 4); 
    }
    
    // Muesta menu de texto, pide un numero integer, regresa integer selecionado
    public static int menuText(){
         Scanner op = new Scanner(System.in);
         
        int opcion; 
        
        System.out.println("                    BUSCAMINAS!!!");
        System.out.println("                    1. Principiante");
        System.out.println("                    2. Intermedio");
        System.out.println("                    3. Experto");
        System.out.println("                    4. Salir!");
        System.out.println("Ingrese Opcion; ");
        opcion = op.nextInt();
        
        return opcion;
    }
    
    //Muestra texto de bienvenida y espera hasta dar enter
    public static void bienvenida(){
        String wait = "";
        
        System.out.println("                    Gaspar Wilson Laynez Mateo");
        System.out.println("                            201602755");
        System.out.println("                        IPC1 \"A\" Practica 1");
        System.out.println("                            BUSCAMINAS!!!");
        wait = sc.nextLine();
    }
    
 }
