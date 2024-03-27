/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_carlos_lara;


public class Historial {
    private Historial siguiente;
    private int cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String llegada;
    private int nro;

    private Historial left;
    private Historial right;
    private static int tamaño;
    
    public Historial (int cedula,String nombre,String apellido,String email,String genero,String llegada,int nro){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.llegada = llegada;
        this.nro = nro;
    
    }

    /**
     * @return the siguiente
     */
    public Historial getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Historial siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the llegada
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * @param llegada the llegada to set
     */
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    /**
     * @return the nro
     */
    public int getNro() {
        return nro;
    }

    /**
     * @param nro the nro to set
     */
    public void setNro(int nro) {
        this.nro = nro;
    }

    /**
     * @return the left
     */
    public Historial getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Historial left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Historial getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Historial right) {
        this.right = right;
    }

    /**
     * @return the tamaño
     */
    public static int getTamaño() {
        return tamaño;
    }

    /**
     * @param aTamaño the tamaño to set
     */
    public static void setTamaño(int aTamaño) {
        tamaño = aTamaño;
    }
}
