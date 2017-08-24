package gaspar_laynez_201602755;
import java.util.InputMismatchException;
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
    private static Scanner scV = new Scanner(System.in);
    
    // Ganar o perder
    private static boolean perdio = false;
    
    public static void main(String[] args) {
        // Doing menu
        bienvenida();
        menu();
    }
    
    // Juega hasta que el usuario salga o hasta perder o ganar
    public static void juego(){
        
        String nivel="";
        // Determina el nivel del juego
        if(nDif ==4){
            nivel = "NIVEL PRINCIPIANTE";
        }else if(nDif == 6){
            nivel = "NIVEL INTERMEDIO";
        }else{
            nivel = "NIVEL EXPERTO";
        }
        
        //Mostrando titulo
        System.out.println("                    " + nivel);

        while(opcJuego !='s'){
            matrizInterfase();
            opcionJuego();   
            menuJuego();
        }
    }
    
    // Asigna bombas, llena matriz.
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
        System.out.println("                    Solcion");
        for(int i = 0; i < matrizL.length;i++){
            System.out.print("                 ");
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

        // Matriz Interfase asigna [X] a la matriz que el usuario mira
        for(int i = 0; i < matrizI.length;i++){
            for(int j = 0; j < matrizI.length;j++){
                matrizI[i][j] = "[X]";
            }
        }
        
        return matrizL;
    }
    
    //Muestra matriz solucion
    public static void mSolucion(){
        // Muerstar matriz Solucion 
        System.out.println("                    Solcion");
        
        for(int i = 0; i < matrizL.length;i++){
            System.out.print("                  ");
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
    }
    
    // Chequea cordenada ingresada y la pone en matriz Interfase para ser mostrada
    // En cruz de acuerdo al algoritmo indicado
    public static void matrizInterfase(){
        
        /* Matriz Interfase*/
        // Chequea si el numero ingresado en voltear no es -1
        // Lo destapa segun el agoritmo en forma de cruz
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
    
    // Pide una cordenada, la convierte en entero. verifica si ya fue escojida
    // Verifica si es bomba, y indica que perdio.
    public static void voltear(){
        System.out.println("");
        System.out.println("                 -----------------------------");
        System.out.print("                    Ingrese Fila y Columna: ");
        opV = volE.nextLine();
        
        String[] parts = opV.split(",");
        
        //Eliminar espacios
        parts[0] = parts[0].replaceAll("\\s","");
        parts[1] = parts[1].replaceAll("\\s", "");
        
        // Tratar de converti parte 1 y 2 a integer si no se puede
        // volver a pedir posicion devido a que es invalida
        try{
            opF = Integer.parseInt(parts[0]);
            opC = Integer.parseInt(parts[1]);
        }catch(Exception e){
            System.out.println("Opcion invalida");
            System.out.println("");
            voltear();
        }
        
        // validacion de datos mayor al tamaño de la matriz
        if(opF  > matrizI.length || opC > matrizI.length ){
            System.out.println("cordenada no esta en el rango.");
            voltear();
        }
        
        // validacion de datos menores al tamaño de la matriz
        if(opF  < 1 || opC < 1 ){
            System.out.println("cordenada no esta en el rango.");
            voltear();
        }
        
        // preguntar si esta seguro de ingresar cordenada 
        System.out.print("                    Quiere destapar (" + opF + "," + opC + ") Y o N: ");
        char val = scV.next().trim().charAt(0);

        // si no esta seguro le regresa al menu
        if(val == 'N' || val == 'n'){
            opF=0;
            opC=0;
            System.out.println("");
            juego();
        }        
                
        // Contar cuantas casillas quedan sin destapar
        int gano = 0;
        for(int i = 0; i < matrizI.length; i++ ){
            for(int j = 0; j < matrizI.length; j++ ){
                if(matrizI[i][j].compareTo("[X]")==0){
                    gano++;
                    perdio = false;
                }
            }
        }
        
        // verifica si el usuario gano
        if(gano-1 == numBom && !perdio){
            System.out.println("");
            System.out.println("                        FELICIDADES!!! HA GANADO EL JUEGO");
            System.out.println("");
            mSolucion();
            System.out.println("");
            System.out.println("Nota: -1 representa bomba");
            
            // Despues de ganar preguntar si quiero volver a jugar
            System.out.println("");
            System.out.print("Desea volvera jugar? Y o N: ");
            char volverGano = scV.next().trim().charAt(0);
            
            // si Y volver a jguar en mismo nivel
            // si N ir a menu principal
            if(volverGano == 'y' || volverGano == 'Y'){
                opF = 0;
                opC = 0;
                matrizL = matrizLogica();
                juego();
            }else{
                opF = 0;
                opC = 0;
                matrizL = matrizLogica();
                menu();
                opcJuego = 's';
            }
        }
        
        // Analizar el usuario elijio una bomba.
        if(matrizL[opF-1][opC-1] == -1 ){
            perdio = true;
        }
        
        // Si elegio una bomba mandar un mensaje indicando que perdio y la solucion
        if(perdio){
            System.out.println("");
            System.out.println("                        PERDIO!!! :(");
            System.out.println();
            mSolucion();
            System.out.println("");
            System.out.println("Nota: -1 representa bomba");
            
            // que hacer si el usuario pierde?  y si quiere volver a jugar o no
            System.out.print("Desea volvera jugar? Y o N: ");
            char volverPerdio = scV.next().trim().charAt(0);
            
            if(volverPerdio == 'y' || volverPerdio == 'Y'){
                opF = 0;
                opC = 0;
                matrizL = matrizLogica();
                juego();
            }else{
                opF = 0;
                opC = 0;
                matrizL = matrizLogica();
                menu();
                opcJuego = 's';
            }
            
        }else{
            // verifica si ya fue descubierta la casilla.
            try{
                if(matrizI[opF-1][opC-1].compareTo("[X]")!=0 ){
                    System.out.println("                    Ya fue descubierto. Vuelva a seleccionar");
                    voltear();
                }else{
                    System.out.println("");
                    juego();
                }
            }catch(Exception e){}
        }
    }
    
    //Menu de Pantalla 2
    // Menu funcional regresa un caracter para controlar ciclo
    public static void menuJuego(){
        
        switch(opcJuego){
            case 'v':
                voltear();         
                break;
            case 'V':
                voltear();
                break;
                
            case 'r':
                opF = 0;
                opC = 0;
                matrizL = matrizLogica();
                juego();
                break;
            case 'R':
                opF = 0;
                opC = 0;
                matrizL = matrizLogica();
                juego();
                break;
                
            case 's':
                opF = 0;
                opC = 0;
                matrizL = matrizLogica();
                menu();
                break;
            case 'S':
                opcJuego ='s';
                opF = 0;
                opC = 0;
                matrizL = matrizLogica();
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
                opcJuego = 'n';
                opMenu1 = 4;;
                nDif = 4;
                matrizI = new String[nDif][nDif];
                numBom = 4;
                matrizL = matrizLogica();
                juego();
                break;
            case 2:
                opcJuego = 'n';
                opMenu1 = 4;
                nDif = 6;
                matrizI = new String[nDif][nDif];
                numBom = 8;
                matrizL = matrizLogica();
                juego();
                break;
            case 3:
                opcJuego = 'n';
                opMenu1 = 4;
                nDif = 8;
                matrizI = new String[nDif][nDif];
                numBom = 12;
                matrizL = matrizLogica();
                juego();
                break;
            case 4:
                System.out.println("                    Gracias Por Jugar!!");
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
        
        // Validacion para solo recibir numeros
        try{
            System.out.println("");
            System.out.println("                    BUSCAMINAS!!!");
            System.out.println("                    1. Principiante");
            System.out.println("                    2. Intermedio");
            System.out.println("                    3. Experto");
            System.out.println("                    4. Salir!");
            System.out.print("Ingrese Opcion; ");
            opMenu1 = opEMenu1.nextInt();
        }catch(InputMismatchException e){
            opEMenu1.nextLine();
        }

        
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