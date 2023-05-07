package workers;

public class Mecanicos extends Workers {
    private String seccion;

    public Mecanicos(String nombre, int edad, float salario, String numEmpleado, String seccion) {
        super(nombre, edad, salario, numEmpleado);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return this.seccion;
    }

    @Override
    public String getInsertValues() {
        return "(edad, nombre, salario, numEmpleado, seccion) values ("
                + this.getEdad() + ", " +
                "'" + this.getNombre() + "', "
                + this.getSalario() + ", " +
                this.getNumEmpleado() + ", " +
                "'" + this.getSeccion() + "' );";
    }

    @Override
    public String getUpdateValues() {

        return "edad = " + this.getEdad() + "," +
                " nombre = '" + this.getNombre() + "'," +
                " salario = " + this.getSalario() + "," +
                " seccion = '" + this.getSeccion() + "'";

    }
}
