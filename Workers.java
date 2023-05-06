abstract class Workers {
  private String nombre;
  private int edad;
  private float salario;
  private String numEmpleado;

  public Workers(String nombre, int edad, float salario, String numEmpleado) {
    this.nombre = nombre;
    this.edad = edad;
    this.salario = salario;
    this.numEmpleado = numEmpleado;
  }

  public String getNombre() {
    return this.nombre;
  }

  public int getEdad() {
    return this.edad;
  }

  public float getSalario() {
    return this.salario;
  }

  public String getNumEmpleado() {
    return this.numEmpleado;
  }

  public abstract String getQueryValues();
}
