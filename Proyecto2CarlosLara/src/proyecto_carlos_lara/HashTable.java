/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_carlos_lara;


public class HashTable {
    private final int size = 1000;
    private  Huesped[] ht;
    
    public HashTable() {
        ht = new Huesped[size];
    }
    public  void insertarHuesped(int nro, String nombre,String apellido,String email,String genero,String tlf,String llegada, Habitacion[] h) {
    int hash1 = (nombre.hashCode()+ apellido.hashCode()) % ht.length;
    hash1 = (hash1 + ht.length) % ht.length;
    int hash2 = (hash1 * 13) % (ht.length - 2) + 1;
    int index = hash1;
    h[nro-1].setOcupada(true);
    while (ht[index] != null) {
        index = (index + hash2) % ht.length;
        if (index == hash1) {
            throw new IllegalStateException("Hash table is full.");
        }
    }
    ht[index] = new Huesped( nro, nombre, apellido, email, genero, tlf, llegada);
}
    public Huesped buscarHuesped(String nombre, String apellido) {
    int hash1 = (nombre.hashCode()+ apellido.hashCode()) % ht.length;
    hash1 = (hash1 + ht.length) % ht.length;

    int hash2 = (hash1 * 13) % (ht.length - 2) + 1;

    int index = hash1;
    while (ht[index] != null) {
        if (ht[index].getNombre().equals(nombre) && ht[index].getApellido().equals(apellido)) {
            return ht[index];
        }
        index = (index + hash2) % ht.length;
        if (index == hash1) {
            break;
        }
    }
    return null;
}
    public Habitacion buscar_habitacion(Habitacion[] h, String tipo){
        for (int i = 0; i < 300; i++) {
            if (h[i].isOcupada()== false && h[i].getTipo().equals(tipo)){
                return h[i];
            }
        }
        return null;
    }
    
    public void eliminar(String nombre, String apellido, Habitacion[] h){
        int hash1 = (nombre.hashCode()+ apellido.hashCode()) % ht.length;
    int hash2 = (hash1 * 13) % (ht.length - 2) + 1;

    int index = hash1;
    while (ht[index] != null) {
        if (ht[index].getNombre().equals(nombre) && ht[index].getApellido().equals(apellido)) {
            int nro = ht[index].getNro();
            h[nro-1].setOcupada(false);
            ht[index] = null;
            
        }
        index = (index + hash2) % ht.length;
        if (index == hash1) {
            break;
        }
    }
    }

}
