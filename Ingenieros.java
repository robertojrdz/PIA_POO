public class Ingenieros extends Workers{
    private String depertamento;

    public Ingenieros(String nombre, int edad, float salario, String numEmpleado, String departamento){

        super(nombre, edad, salario, numEmpleado);
        this.depertamento = departamento;
    }

    public String getDepartamento(){
        return this.depertamento;
    }

    @Override
    public String getQueryValues(){
        return "(edad, nombre, salario, numEmpleado, departamento) values (" +
        this.getEdad() + ", " +
        "'" + this.getNombre() + "' , " +
        this.getSalario() + ", " +
        this.getNumEmpleado() + ", "
        + "'" + this.getDepartamento() + "'); ";
    }

}
