package controlador;

import conexion.Conexion;
import dao.MedicamentosDao;
import java.util.Scanner;
import modelo.Medicamentos;

public class MedicamentoController {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        entrada.useDelimiter("\n");
        Conexion cone = new Conexion();
        MedicamentosDao mediD = new MedicamentosDao(cone);
        Medicamentos medi = new Medicamentos(0);
        
        //menu de opciones
        
        int infinito = 1;
        
        while(infinito == 1){
            System.out.println("Menu de opciones \n"
                    + "1 => Ingresar \n"
                    + "2 => Mostrar \n"
                    + "Otro => Salir");
            int menu = entrada.nextInt();

            switch(menu){
                case 1:
                    System.out.println(" ");
                    System.out.println("Simulacion de vista de ingreso");
                    System.out.println("INGRESAR DATOS");
                    System.out.println("Ingrese medicamento");
                    medi.setMedicamento(entrada.next());
                    System.out.println("Ingrese descripcion");
                    medi.setDescripcion(entrada.next());
                    System.out.println("Ingrese cantidad");
                    medi.setCantidad(entrada.nextInt());
                    System.out.println("Ingrese fecha de vencimiento (Formato aaaa-mm-dd)");
                    medi.setFecha_vencimiento(entrada.next());
                    System.out.println(" ");


                    boolean res = mediD.insert(medi);
                    if (res) {
                        System.out.println("Si se guardo");
                        System.out.println(" ");
                    }else{
                        System.out.println("No se guardo");
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Mostrar");
                    for(Medicamentos medica: mediD.selectTodo()) { //Recorrer la lista comparandolo con el iterador
                        System.out.println("----------------------"); 
                        System.out.println("ID: " + medica.getId_medicamento());
                        System.out.println("Medicamento: " + medica.getMedicamento());
                        System.out.println("Descripcion: " + medica.getDescripcion());
                        System.out.println("Cantidad: " + medica.getCantidad());
                        System.out.println("Fecha vencimiento: " + medica.getFecha_vencimiento());
                        System.out.println("----------------------"); 
                        System.out.println(" ");
                    }
                    break;
                default:
                    System.exit(0);

            }
                    
        }
                
    }
        
}
