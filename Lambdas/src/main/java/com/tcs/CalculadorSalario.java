package main.java.com.tcs;

import main.java.com.tcs.capaNegocio.Empleado;
import main.java.com.tcs.capaNegocio.OperacionesSalario;

import java.util.*;

public class CalculadorSalario {

   public static void main(String[] args) {
      int opc=-1;

      Empleado emp= new Empleado("Carlos", "Usuga Madrid", "1'017.185.478");


      while(opc != 0) {
         System.out.println("********** Menu nómina empleado: "+emp.getNombre()+" "+emp.getApellido()+" ********");
         System.out.println("1. Calcular salario Neto");
         System.out.println("0. Salir");

         Scanner lector = new Scanner(System.in);
         opc= lector.nextInt();

         if(opc == 1){
            System.out.println("Ingrese salario bruto...");
            Double salarioBruto= lector.nextDouble();

            //Implementación de la Interfaz funcional mediante expresión Lambda
            OperacionesSalario deducciones = () -> {
               Double salud, pension, retefuente= 0.0;
               salud = salarioBruto * 0.04;
               pension = salarioBruto * 0.04;
               if (salarioBruto > 2500000)
                  retefuente = salarioBruto * 0.015;
               return Arrays.asList(salud, pension, retefuente);
            };

            System.out.println(deducciones.calcularDeducciones().get(0));
            System.out.println("Salario Bruto: "+salarioBruto);
            System.out.println("Salario Neto: "+ calcularSalarioNeto(salarioBruto, deducciones));
            System.out.println("...Deducciones...");
            System.out.println("- Salud (4%): "+ deducciones.calcularDeducciones().get(0));
            System.out.println("- Pensión (4%): "+ deducciones.calcularDeducciones().get(1));
            System.out.println("- Rete Fuente (1.5%): "+ deducciones.calcularDeducciones().get(2));
         }
      }
   }

   public static Double calcularSalarioNeto(Double salBruto, OperacionesSalario deducciones){
      return salBruto -
              (deducciones.calcularDeducciones().get(0)
                      + deducciones.calcularDeducciones().get(1)
                      + deducciones.calcularDeducciones().get(2));
   }
}
