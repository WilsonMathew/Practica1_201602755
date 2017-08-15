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
        
    public static void menu(){
        int opcion;
        do{
        
           opcion = menuText();
            
        switch(opcion){
            case 1:
                System.out.println("opcion1");
                break;
            case 2:
                opcion = 4;
                System.out.println("opcion2");
                break;
            case 3:
                opcion = 4;
                System.out.println("opcion3");
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
    
    public static int menuText(){
         Scanner op = new Scanner(System.in);
         
        int opcion; 
        
        System.out.println("    BUSCAMINAS!!!");
        System.out.println("    1. Principiante");
        System.out.println("    2. Intermedio");
        System.out.println("    3. Experto");
        System.out.println("    4. Salir!");
        opcion = op.nextInt();
        
        return opcion;
    }
    
    public static void bienvenida(){
        String wait = "";
        
        System.out.println("Gaspar Wilson Laynez Mateo");
        System.out.println("        201602755");
        System.out.println("    IPC1 \"A\" Practica 1");
        System.out.println("        BUSCAMINAS!!!");
        wait = sc.nextLine();
    }
 }
