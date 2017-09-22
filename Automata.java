//Martínez Domínguez José Luis 140504
//Expresión regular  aa(abc*)*
import java.util.Scanner;

public class Automata {
     int cont;
     char [] cad;
    boolean aceptado;

    public static void main(String[] args) {
          
        String cadena;
        Scanner teclado=new Scanner(System.in);
        Automata aut = new Automata();
        cadena=teclado.next();//lee la cadena
       
        aut.cad = cadena.toCharArray();//la agrega a un arreglo llamado cad
        aut.inicio(); //llama la función inicio
        if(aut.aceptado)
             System.out.println("cadena aceptada");
        else System.out.println("cadena no aceptada");
    }
   public void inicio(){ //esta función inicializa un contenedor en 0 y llama al estado q0 que en realidad es una función
           cont =0;
           q0();
   }
   public void q0(){
       System.out.println("En q0");
       aceptado=false;
    if(cont<cad.length){
       if(cad[cont]=='a'){//verifica que la primera letra de la cadena sea la letra a
            cont++;
            q1();
       }
    }
   
   }
   public void q1(){
     System.out.println("En q1");
    if(cont<cad.length){
       if(cad[cont]=='a'){//verifica que la segunda letra de la cadena sea a
            cont++;
            q2();
       }}
       
   }
   public void q2(){
     System.out.println("En q2");
     aceptado=true; //aqui ya puede terminar la cadena pues esta en estado de aceptación
    if(cont<cad.length){
       if(cad[cont]=='a'){//verifica que la tercera letra de la cadena sea a
            cont++;
            q3();
       }else if(cad[cont]!='a'){//si es otra letra ya marca error
            cont++;
            qerror();}
    }
   }
   public void q3(){
     System.out.println("En q3 ");
    
    if(cont<cad.length){
       if(cad[cont]=='b'){//verifica que la cuarta letra de la cadena sea b
            cont++;
            q4();
       }}
   
   }
      public void q4(){
     System.out.println("En q4");
    if(cont<cad.length){
       if(cad[cont]=='c'){//verifica que la quinta letra de la cadena sea c
            cont++;
            q5();
       }}
   }
      public void q5(){
     System.out.println("En q5 ");
     aceptado=true;

    if(cont<cad.length){

       if(cad[cont]=='c'){//verifica que la sexta letra de la cadena sea c
            cont++;
            q5();
       }else if(cad[cont]=='a'){//verifica que la sexta letra de la cadena sea a ya que puede regresar al estado q3
            cont++;
            q3();

       }else if(cad[cont]!='b'){//marca error si es otra letra
            cont++;
            qerror();}
    }

   }

   public void qerror(){
   System.out.println("En error");
   aceptado = false;//regresa el estado invalido ya que es error
    return;
   }
  

   }