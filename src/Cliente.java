
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

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDni() {
        return dni;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public ListaCuentas getCuentas() {
        return cuentas;
    }

    public void imprimir(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Fecha nacimiento: " + fechaNacimiento.imprimir());
        System.out.println("DNI: " + dni);
        System.out.println("Correo electrónico: " + correo);


    }

}
