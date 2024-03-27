/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_carlos_lara;

public class ABBReservaciones {
    private final int size = 1000;
    private Reservacion[] table;

    public ABBReservaciones() {
        table = new Reservacion[size];
    }

    public void put(int cedula,String nombre,String apellido,String email,String genero,String tipo_hab,String tlf,String llegada,String salida) {
        int index = hash(cedula);
        
        if (table[index] == null) {
            table[index] = new Reservacion(cedula, nombre, apellido, email, genero, tipo_hab, tlf, llegada,salida);
        } else {
            Reservacion n = new Reservacion (cedula, nombre, apellido, email, genero, tipo_hab, tlf, llegada,salida);
            insertIntoTree(table[index], n);
        }
    }

    private void insertIntoTree(Reservacion node, Reservacion n) {
        if (n.getCedula() < node.getCedula()) {
            if (node.left == null) {
                node.left = n;
            } else {
                insertIntoTree(node.left, n);
            }
        } else if (n.getCedula() > node.getCedula()) {
            if (node.right == null) {
                node.right = n;
            } else {
                insertIntoTree(node.right, n);
            }
        } else {
            
        }
    }
    
    
    private int hash(int key) {
        return key % size;
    }
    
    public Reservacion get(int key) {
        int index = hash(key);
        return searchInTree(table[index], key);
    }

    private Reservacion searchInTree(Reservacion node, int key) {
        if (node == null) {
            return null;
        } else if (key == node.getCedula()) {
            return node;
        } else if (key < node.getCedula()) {
            return searchInTree(node.left, key);
        } else {
            return searchInTree(node.right, key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        Reservacion parent = null;
        Reservacion node = table[index];

        while (node != null) {
            if (key < node.getCedula()) {
                parent = node;
                node = node.left;
            } else if (key > node.getCedula()) {
                parent = node;
                node = node.right;
            } else {
                if (node.left == null && node.right == null) {
                    if (parent == null) {
                        table[index] = null;
                    } else if (node == parent.left) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (node.left == null) {
                    if (parent == null) {
                        table[index] = node.right;
                    } else if (node == parent.left) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                } else if (node.right == null) {
                    if (parent == null) {
                        table[index] = node.left;
                    } else if (node == parent.left) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }
                } else {
                    Reservacion successorParent = node;
                    Reservacion successor = node.right;
                    while (successor.left != null) {
                        successorParent = successor;
                        successor = successor.left;
                    }
                    node.setCedula(successor.getCedula()); 
                    node = successor;
                    if (successor == successorParent.left) {
                        successorParent.left = successor.right;
                    } else {
                        successorParent.right = successor.right;
                    }
                }
                return;
            }
        }
    
    
}
}
