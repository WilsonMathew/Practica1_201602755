package gaspar_laynez_201602755;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Gaspar Wilson Laynez Mateo
 */

public class Gaspar_Laynez_201602755 {
   
    // Esperar en bienvenida
    private static Scanner sc = new Scanner(System.in);

    // Menu 1
    private static Scanner opEMenu1 = new Scanner(System.in);
    private static int opMenu1; 
    
    // Menu 2
    private static Scanner opEJuego = new Scanner(System.in);
    private static char opcJuego = 'n';
    
    // Matriz Logica
    private static int nDif = 4; // difucultad del juego
    private static int matrizL [][]= new int[nDif][nDif];
    private static Random rndF = new Random();
    private static Random rndC = new Random();
    private static int fR=0, cR=0; // fila y columna random asignados 
    private static int numBom = 4;
    
    // Matriz Interfase
     //   private static String matrizI[][]= new String[nDif][nDif];
    private static String matrizI[][] = new String[nDif][nDif];
    
    // variables de interaccion usuario y juego.
    private static Scanner volE = new Scanner(System.in);
    private static String opV;
    private static int opF, opC;
    
    
    public static void main(String[] args) {
        // Doing menu
        bienvenida();
        menu();
    }
    
    
    public static void juego(){
        
        String nivel="";
        
        if(nDif ==4){
            nivel = "NIVEL PRINCIPIANTE";
        }else if(nDif == 6){
            nivel = "NIVEL INTERMEDIO";
        }else{
            nivel = "NIVEL EXPERTO";
        }
        
        //Mostrando titulo
        System.out.println("                    " + nivel);

        do{
            matrizInterfase();
            opcionJuego();   
            menuJuego();         
        }while(opcJuego !='s');
    }
    
    // Para crea una nueva matriz logica. Escencialmente para reiniciar el juego
    public static void juegoL(){
        matrizL = matrizLogica(); 
    }
    
    // Asigna bombas, llena matriz. Muestra matriz solucion, y llena matriz usuario con [X]
    public static int[][] matrizLogica(){
        
        
        /*Matriz Logica*/
        int matrizL[][] = new int[nDif][nDif];
        
        // Asigna bombas aleatoriamente
        for(int i = 0; i < numBom ;i++){
            fR = rndF.nextInt(nDif);
            cR = rndC.nextInt(nDif);
            
            if(matrizL[fR][cR]==-1){
                i--;
            }else{
                matrizL[fR][cR] = -1;
            }
        }
        
        
        // Asigna numero asociado con bombas a su alreadedo 
        for(int i = 0; i < matrizL.length;i++){
            for(int j = 0; j < matrizL.length;j++){
                if(matrizL [i][j] != -1){
                    int numMin = 0;
                    for(int k = 0; k < 8; k++){
                        try{
                            switch(k){
                                case 0:
                                    if(matrizL[i-1][j-1]==-1){numMin++;}
                                    break;
                                case 1:
                                    if(matrizL[i-1][j]==-1){numMin++;}
                                    break;
                                case 2:
                                    if(matrizL[i-1][j+1]==-1){numMin++;}
                                    break;
                                case 3:
                                    if(matrizL[i][j+1]==-1){numMin++;}
                                    break;                                    
                                case 4:
                                    if(matrizL[i+1][j+1]==-1){numMin++;}
                                    break;
                                case 5:
                                    if(matrizL[i+1][j]==-1){numMin++;}
                                    break;
                                case 6:
                                    if(matrizL[i+1][j-1]==-1){numMin++;}
                                    break;
                                case 7:
                                    if(matrizL[i][j-1]==-1){numMin++;}
                                    break;                                    
                            }
                        }catch(Exception e){}
                    }
                    matrizL[i][j] = numMin;
                }
            }
        }
        
        System.out.println("");
        
        // Muerstar matriz Solucion 
        
        for(int i = 0; i < matrizL.length;i++){
            for(int j = 0; j < matrizL.length; j++){
                if(matrizL[i][j] == -1){
                    System.out.print(matrizL[i][j] + " ");
                } else{
                    System.out.print(" " + matrizL[i][j] + " ");
                }
                
            }
            System.out.println("");
        }
        
        System.out.println("");
        
        updateVUsuario();
        
        return matrizL;
    }
    
    //Matriz asigna [x] a la matriz Interfas  
    public static void updateVUsuario(){
        
        // Matriz Interfase
        
        for(int i = 0; i < matrizI.length;i++){
            for(int j = 0; j < matrizI.length;j++){
                matrizI[i][j] = "[X]";
            }
        }
    }
    
    // Chequea cordenada ingresada y la pone en matriz Interfase para ser mostrada
    // En cruz de acuerdo al algoritmo indicado
    public static void matrizInterfase(){
        
        /* Matriz Interfase*/
        //String matrizI [][] = new String[nDif][nDif];
        
        try{
            if(matrizL[opF-1][opC-1] != -1){
                matrizI[opF-1][opC-1] = " " + String.valueOf(matrizL[opF-1][opC-1]) + " ";
                for(int k = 0; k < 4; k++){

                    try{
                        switch(k){
                            case 0:
                                if(matrizL[opF-2][opC-1] != -1){
                                    matrizI[opF-2][opC-1] = " " + String.valueOf(matrizL[opF-2][opC-1]) + " ";   
                                }
                                break;
                            case 1:
                                if(matrizL[opF][opC-1] != -1){
                                    matrizI[opF][opC-1] = " " + String.valueOf(matrizL[opF][opC-1]) + " ";   
                                }
                                break;
                            case 2:
                                if(matrizL[opF-1][opC-2] != -1){
                                    matrizI[opF-1][opC-2] = " " + String.valueOf(matrizL[opF-1][opC-2]) + " ";   
                                }
                                break;
                            case 3:
                                if(matrizL[opF-1][opC] != -1){
                                    matrizI[opF-1][opC] = " " + String.valueOf(matrizL[opF-1][opC]) + " ";   
                                }
                                break;
                        }
                    }catch(Exception e){}
                }
            }
        }catch(Exception e){}

        // Muestra la matriz interfase acutalizada
        for(int i = 0; i < matrizI.length;i++){
            System.out.print("                  ");
            for(int j = 0; j < matrizI.length; j++){
                System.out.print(matrizI[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    
    public static void voltear(){
        System.out.println("                 --------------------------------");
        System.out.println("                    Ingrese Fila y Columna");
        System.out.print("                             ");
        opV = volE.nextLine();
        
        String[] parts = opV.split(",");
        
        //Eliminar espacios
        parts[0] = parts[0].replaceAll("\\s","");
        parts[1] = parts[1].replaceAll("\\s", "");
        
        System.out.println(parts[0]);
        System.out.println(parts[1]);
        
        try{
            opF = Integer.parseInt(parts[0]);
            opC = Integer.parseInt(parts[1]);
        }catch(Exception e){
            System.out.println("Opcion invalida");
            System.out.println("");
            voltear();
        }       
        juego();
        
    }
    //Menu de Pantalla 2
    // Menu funcional regresa un caracter para controlar ciclo
    public static void menuJuego(){
        
        System.out.println("char:  " + opcJuego);
        
        switch(opcJuego){
            case 'v':
                opcJuego = 's';
                voltear();
                break;
            case 'r':
                opcJuego = 's';
                opF = 0;
                opC = 0;
                juegoL();
                juego();
                break;
            case 's':
                menu();
                break;
                // no haga nada para inicializar.
            case 'n':
                break;
            default: 
                System.out.println("No es opcion, trate de nuevo");
        }
            
    }
    
    // muestra opciones y regresa un caracter que el usuario ingreso
    public static void opcionJuego(){
        
        System.out.println("");
        System.out.println("                 -----------------------------");
        System.out.println("");

        System.out.println("                    Voltear: V");
        System.out.println("                    Reiniciar: R"); 
        System.out.println("                    Salir: S");

        System.out.println("");
        System.out.print("                    Ingresar Opcion: "); 
        
        opcJuego = opEJuego.next().trim().charAt(0);

    } 
    
    
    // MENU DE PANTALLA 1
    // Menu funcional. Dirije opciones segun opcion seleccionada.
    public static void menu(){
        
        do{

            menuText();
            
        switch(opMenu1){
            case 1:
                opMenu1 = 4;;
                nDif = 4;
                matrizI = new String[nDif][nDif];
                numBom = 4;
                juegoL();
                juego();
                break;
            case 2:
                opMenu1 = 4;
                nDif = 6;
                matrizI = new String[nDif][nDif];
                numBom = 8;
                juegoL();
                juego();
                break;
            case 3:
                opMenu1 = 4;
                nDif = 8;
                matrizI = new String[nDif][nDif];
                numBom = 12;
                juegoL();
                juego();
                break;
            case 4:
                break;
            default :
                System.out.println();
                System.out.println("Usten escojio: " + opMenu1 + " Opcion invalida, elija del 1 al 4");
                System.out.println(" ");
                break;
        }
        
        }while(opMenu1 != 4); 
    }
    
    // Muesta menu de texto, pide un numero integer, regresa integer selecionado
    public static void menuText(){

         

        
        System.out.println("                    BUSCAMINAS!!!");
        System.out.println("                    1. Principiante");
        System.out.println("                    2. Intermedio");
        System.out.println("                    3. Experto");
        System.out.println("                    4. Salir!");
        System.out.println("Ingrese Opcion; ");
        opMenu1 = opEMenu1.nextInt();
        
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