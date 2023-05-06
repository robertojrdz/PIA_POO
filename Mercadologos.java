public class Mercadologos extends Workers{
    
    private String area;

    public Mercadologos(String nombre, int edad, float salario, String numEmpleado, String area){
        super(nombre, edad, salario, numEmpleado);
        this.area = area;
    }

    public String getArea(){
        return this.area;
    }
    
    @Override
    public String getQueryValues(){
        return "(edad, nombre, salario, numEmpleado, area) values ("
        + this.getEdad() + ", " + 
        "'" + this.getNombre() + "', "
        + this.getSalario() + ", " + 
        this.getNumEmpleado() + ", " + 
        "'" + this.getArea() + "' );";
    }
}
