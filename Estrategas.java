public class Estrategas extends Workers{
    
    public Estrategas(String nombre, int edad, float salario, String numEmpleado){
        super(nombre, edad, salario, numEmpleado);
    }

    @Override
    public String getQueryValues(){
        return "(edad, nombre, salario, numEmpleado) values (" +
        this.getEdad() + ", " + 
        "'" + this.getNombre() + "', "
        + this.getSalario() + ", "
        + "'" + this.getNumEmpleado() + "');";
    }
}
