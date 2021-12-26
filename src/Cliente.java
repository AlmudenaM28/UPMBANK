import java.util.Scanner;

public class Cliente {
    private String nombre, apellidos, correo, dni;
    Fecha fechaNacimiento;
    ListaCuentas cuentas;

    public Cliente(String nombre, String apellidos, String correo, String dni, Fecha fechaNacimiento, ListaCuentas cuentas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.cuentas = cuentas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ListaCuentas getCuentas() {
        return cuentas;
    }

    public void setCuentas(ListaCuentas cuentas) {
        this.cuentas = cuentas;
    }

    public void añadirCuenta(){


    }

    public void imprimir(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Fecha nacimiento: " + fechaNacimiento.imprimir());
        System.out.println("DNI: " + dni);
        System.out.println("Correo electrónico: " + correo);

        //for para imprimir todas las cuentas dependiendo de la ocupación de la array

    }

}
