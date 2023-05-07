package workers;

public class Piloto extends Workers {
    private String numPiloto;
    private String victorias;
    private String nacionalidad;

    public Piloto(String nombre, int edad, float salario, String numEmpleado, String numPiloto, String victorias,
            String nacionalidad) {
        super(nombre, edad, salario, numEmpleado);
        this.numPiloto = numPiloto;
        this.victorias = victorias;
        this.nacionalidad = nacionalidad;
    }

    public String getNumPiloto() {
        return this.numPiloto;
    }

    public String getVictorias() {
        return this.victorias;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }

    @Override
    public String getInsertValues() {
        return "(edad, nombre, salario, numEmpleado, numPiloto, victorias, nacionalidad) values (" +
                this.getEdad() + ", " +
                "'" + this.getNombre() + "' , " +
                this.getSalario() + ", " +
                this.getNumEmpleado() + ", " +
                this.getNumPiloto() + ", " +
                this.getVictorias() + ", " +
                "'" + this.getNacionalidad() + "' );";
    }

    @Override
    public String getUpdateValues() {

        return "edad = " + this.getEdad() + "," +
                " nombre = '" + this.getNombre() + "'," +
                " salario = " + this.getSalario() + "," +
                " numPiloto = " + this.getNumPiloto() + "," +
                " victorias = " + this.getVictorias() + "," +
                " nacionalidad = '" + this.getNacionalidad() + "'";

    }
}