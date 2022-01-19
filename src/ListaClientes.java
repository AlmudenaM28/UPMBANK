public class ListaClientes {
    Cliente[] clientes;
    int numClientes;

    public ListaClientes(Cliente[] clientes, int numClientes) {
        this.clientes = clientes;
        this.numClientes = numClientes;
    }


    public Cliente getCliente(String dni){
        boolean clienteEncontrado = false;
        int i = 0;
        while (i < numClientes && !clienteEncontrado){
            if (clientes[i].getDni().equals(dni.toUpperCase())){
                clienteEncontrado = true;
            }
            i++;
        }
        return (clienteEncontrado)?clientes[i-1]:null;
    }

    public void imprimir(){
        for (int i = 0; i < numClientes; i++){
            System.out.println(clientes[i].getDni() + ";" + clientes[i].getApellidos() + ";" + clientes[i].getNombre() + ";" + clientes[i].getCorreo() + ";" + clientes[i].getFechaNacimiento());
        }
    }


    public Cliente[] getClientes() {
        return clientes;
    }



}
