/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_carlos_lara;


public class ABBHistorial {
    private final int size = 300;
    private Historial[] table;

    public ABBHistorial() {
        table = new Historial[size];
    }

    public void put(int cedula,String nombre,String apellido,String email,String genero,String llegada,int nro) {
        int index = nro-1;
        if (table[index] == null) {
            table[index] = new Historial(cedula,nombre, apellido, email, genero, llegada, nro);
        } else {
            Historial n = new Historial (cedula, nombre, apellido, email, genero, llegada,nro);
            insertIntoTree(table[index], n);
        }
    }

    private void insertIntoTree(Historial node, Historial n) {

        if (n.getCedula() < node.getCedula()) {
            if (node.getLeft() == null) {
                node.setLeft(n);
            } else {
                insertIntoTree(node.getLeft(), n);
            }
        } else if (n.getCedula() > node.getCedula()) {
            if (node.getRight() == null) {
                node.setRight(n);
            } else {
                insertIntoTree(node.getRight(), n);
            }
        } else {
            
        }
    }

    public String searchInTree(Historial node, String ln) {
        if (node == null) {
            return null;
        } else {
            if (node.getLeft()!= null){
            ln = searchInTree(node.getLeft(), ln);}
            if (node.getRight()!=null){
            ln = searchInTree(node.getRight(), ln);}
            ln += "Cedula: "+node.getCedula()+ " | Nombre: " + node.getNombre()+ " | Apellido:  " + node.getApellido() + " | Email: " + node.getEmail() +" | Genero: " + node.getGenero() + " | Llegada: " + node.getLlegada() + " | Numero de Habitacion: " + node.getNro() + "\n";

        }
        return ln;
    }
    
    public Historial buscar_hab(int nro){
        return table[nro-1];
    }

    private int hash(int key) {
        return key % size;
    }
    
}

