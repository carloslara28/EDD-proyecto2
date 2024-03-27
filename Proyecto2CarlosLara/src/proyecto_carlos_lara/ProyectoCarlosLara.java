/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_carlos_lara;
import Ventanas.VentanaPrincipal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProyectoCarlosLara {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ABBReservaciones x = new ABBReservaciones();
        HashTable y = new HashTable();
        ABBHistorial a = new ABBHistorial();
        Habitacion []ñ = new Habitacion[300];
        try{
            FileInputStream f = new FileInputStream("Booking_hotel.xlsx");
            XSSFWorkbook libro = new XSSFWorkbook(f);
            
            XSSFSheet hoja = libro.getSheetAt(0);
            
            Iterator <Row> filas = hoja.iterator();
            Iterator <Cell> celdas;
            int n = 1;
            int h = 0;
            Row fila;
            Cell celda;
            
            int cedula = 0;
            String nombre = "";
            String apellido= "";
            String email= "";
            String genero= "";
            String tipo_H= "";
            String celular= "";
            String llegada = "";
            String salida= "";
            int nro= 0;
            int piso= 0;
            String aux;
            double au;
            Date d;
            boolean vacio= false;
            fila = filas.next();

            while (h<4){
                hoja = libro.getSheetAt(h);
            
                filas = hoja.iterator();
                fila = filas.next();

                while (filas.hasNext()){

                    fila = filas.next();

                    celdas = fila.cellIterator();
                    n=1;
                    while (celdas.hasNext()){
                        if (vacio){
                            vacio = false;
                            break;
                        }
                        celda = celdas.next();

                        switch (h) {
                            case 0 -> {
                                switch (n) {
                                    case 1 -> {
                                        try{cedula= (int)celda.getNumericCellValue();
                                        aux = Integer.toString(cedula);
                                        aux = aux.replace(".", "");
                                        cedula = Integer.parseInt(aux);}
                                        catch(Exception e){
                                            vacio = true;
                                            break;
                                        }
                                    }
                                    case 2 -> nombre = celda.getStringCellValue();
                                    case 3 -> apellido = celda.getStringCellValue();
                                    case 4 -> email = celda.getStringCellValue();
                                    case 5 -> genero = celda.getStringCellValue();
                                    case 6 -> tipo_H = celda.getStringCellValue();
                                    case 7 -> {celular = celda.getStringCellValue();
//                                        System.out.println(celda.getStringCellValue());
                                    }
                                    case 8 -> {d = celda.getDateCellValue();
                                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                        String fechaString = formato.format(d);
                                        llegada = fechaString;
                                    
                                    }
                                    case 9 -> {d = celda.getDateCellValue();
                                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                        String fechaString = formato.format(d);
                                        salida = fechaString;
                                    
                                    }
                                    default -> {
                                    }
                                }
                            }

                            case 1 -> {
                                switch (n) {
                                    case 1 -> {
                                    nro = (int)celda.getNumericCellValue();
                                    }
                                    case 2 -> tipo_H=celda.getStringCellValue();
                                    case 3 -> piso = (int)celda.getNumericCellValue();
                                    default -> {
                                    }
                                }
                            }
                            case 2 -> {
                                
                                switch (n) {
                                    case 1 -> {try{
                                        nro = (int)celda.getNumericCellValue();
                                    }
                                    catch (Exception e){
                                        vacio = true;
                                        break;
                                }
                                    }
                                    case 2 -> {nombre = celda.getStringCellValue();
                                        ;}
                                    case 3 -> apellido = celda.getStringCellValue();
                                    case 4 -> email = celda.getStringCellValue();
                                    case 5 -> genero = celda.getStringCellValue();
                                    case 6 -> celular = celda.getStringCellValue();
                                    case 7 -> {d = celda.getDateCellValue();
                                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                        String fechaString = formato.format(d);
                                        llegada = fechaString;
                                    
                                    }
                                    default -> {
                                    }
                                }
                            }
                            case 3 -> {
                                switch (n) {
                                    case 1 -> {cedula= (int)celda.getNumericCellValue();
                                        aux = Integer.toString(cedula);
                                        aux.replace(".", "");
                                        cedula = Integer.parseInt(aux);
                                        System.out.println(aux);
                                    }
                                    case 2 -> {nombre = celda.getStringCellValue();
                                    System.out.println(celda.getStringCellValue());
                                    }
                                    case 3 -> {apellido = celda.getStringCellValue();
                                    System.out.println(celda.getStringCellValue());
                                    }
                                    case 4 -> {email = celda.getStringCellValue();
                                    System.out.println(celda.getStringCellValue());
                                    }
                                    case 5 -> {genero = celda.getStringCellValue();
                                    System.out.println(celda.getStringCellValue());
                                    }
                                    
                                    case 6 -> {
                                        System.out.println(String.valueOf(celda.getNumericCellValue()));
                                        llegada =String.valueOf(celda.getNumericCellValue());
//                                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//                                        String fechaString = formato.format(d);
//                                        llegada = d;
                                    
                                    }
                                    case 7 -> nro = (int)celda.getNumericCellValue();
                                    default -> {
                                    }
                                }
                            }
                            default -> {
                            }
                        }
//                        switch (celda.getCellType()){
//
////                            case Cell.CELL_TYPE_BLANK -> {
////                                if(n==1 && h ==2){
////                                    nro = 0;
////                                }
////                            }
//                        }
                        n+=1;

                    }
                    switch (h) {
                        case 0 -> x.put(cedula, nombre, apellido, email, genero, tipo_H, celular, llegada, salida);
                        case 1 -> ñ[nro-1]= new Habitacion(nro,tipo_H,false);
                        case 2 -> y.insertarHuesped(nro, nombre, apellido, email, genero, celular, llegada, ñ);
                        case 3 -> a.put(cedula, nombre, apellido, email, genero, llegada, nro);
                        default -> {
                        }
                    }

                }
//                if (h)
                h+=1;
                

            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        VentanaPrincipal vp = new VentanaPrincipal(x,y,a,ñ);
        // TODO code application logic here

        

    }
    
}
