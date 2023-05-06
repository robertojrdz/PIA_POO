import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DataBase db = DataBase.getConnection();
        String nombre, nacionalidad, podios, numEmpleado, numPiloto, departamento, seccion, area;
        int edad;
        float salario;

        int n;
        do {
            System.out.println("Empleados");
            System.out.println("1) Registrar nuevo empleado");
            System.out.println("2) Mostrar lista de empleados");
            System.out.println("3) Actualizar datos");
            System.out.println("4) Dar de baja a empleado");
            System.out.println("5) Salir");
            System.out.println("¿Qué desea hacer?");
            n = scan.nextInt();
            int x;
            switch (n) {
                case 1: // CREATE
                    do {
                        menu_empleados();
                        System.out.print("¿Qué tipo de empleado desea registrar?");
                        x = scan.nextInt();
                        switch (x) {
                            case 1: // Piloto
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                numEmpleado = InputUtils.reqString("# de empleado: ");
                                numPiloto = InputUtils.reqString("# de piloto: ");
                                podios = InputUtils.reqString("# de victorias: ");
                                nacionalidad = InputUtils.reqString("Nacionalidad: ");
                                Piloto piloto = new Piloto(nombre, edad, salario, numEmpleado, numPiloto, podios,
                                        nacionalidad);
                                try {
                                    db.insert("pilotos", piloto.getQueryValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                break;
                            case 2: // Mecanico
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                numEmpleado = InputUtils.reqString("# de empleado: ");
                                departamento = InputUtils.reqString("Departamento: ");
                                Mecanicos mecanico = new Mecanicos(nombre, edad, salario, numEmpleado, departamento);
                                try {
                                    db.insert("mecanicos", mecanico.getQueryValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                break;
                            case 3: // Ingeniero
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                numEmpleado = InputUtils.reqString("# de empleado: ");
                                seccion = InputUtils.reqString("Sección: ");
                                Ingenieros ingeniero = new Ingenieros(nombre, edad, salario, numEmpleado, seccion);
                                try {
                                    db.insert("ingenieros", ingeniero.getQueryValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 4: // Mercadologo
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                numEmpleado = InputUtils.reqString("# de empleado: ");
                                area = InputUtils.reqString("Área: ");
                                Mercadologos mercadologo = new Mercadologos(nombre, edad, salario, numEmpleado, area);
                                try {
                                    db.insert("mercadologos", mercadologo.getQueryValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 5: // Estratega
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                numEmpleado = InputUtils.reqString("# de empleado: ");
                                Estrategas estratega = new Estrategas(nombre, edad, salario, numEmpleado);
                                try {
                                    db.insert("estrategas", estratega.getQueryValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            default:
                                System.out.println("OPCIÓN ERRONEA!!!\nInserte una opción correcta.");
                                break;
                        }
                    } while (x != 6);
                    break;
                case 2: // READ
                    do {
                        menu_empleados();
                        System.out.println("¿Qué lista desea visulizar?");
                        x = scan.nextInt();
                        switch (x) {
                            case 1: // Piloto
                                db.showDataBase("pilotos");
                                break;
                            case 2: // Mecanico
                                db.showDataBase("mecanicos");
                                break;
                            case 3: // Ingeniero
                                db.showDataBase("ingenieros");
                                break;
                            case 4: // Mercadologo
                                db.showDataBase("mercadologos");
                                break;
                            case 5: // Estratega
                                db.showDataBase("estrategas");
                                break;
                            default:
                                break;
                        }
                    } while (x != 6);
                    break;
                case 3: // UPDATE
                    do {
                        menu_empleados();
                        System.out.println("¿Qué tipo de empleado desea actualizar?");
                        x = scan.nextInt();
                        switch (x) {
                            case 1: // Piloto
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");

                                break;
                            case 2: // Mecanico
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");

                                break;
                            case 3: // Ingeniero
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");

                                break;
                            case 4: // Mercadologo
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");

                                break;
                            case 5: // Estratega
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");

                                break;
                            default:
                                break;
                        }
                    } while (x != 6);
                    break;
                case 4: // DELETE
                    do {
                        menu_empleados();
                        System.out.println("¿Qué tipo de empleado desea eliminar?");
                        x = scan.nextInt();
                        switch (x) {
                            case 1: // Piloto
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                break;
                            case 2: // Mecanico
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                break;
                            case 3: // Ingeniero
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                break;
                            case 4: // Mercadologo
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                break;
                            case 5: // Estratega
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                break;
                            default:
                                break;
                        }
                    } while (x != 6);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("OPCIÓN ERRONEA!!!\nInserte una opción correcta.");
                    break;
            }

        } while (n != 5);

        scan.close();
    }

    private static void menu_empleados() {
        System.out.println("1) Piloto");
        System.out.println("2) Mecanico");
        System.out.println("3) Ingeniero");
        System.out.println("4) Mercadologo");
        System.out.println("5) Estratega");
        System.out.println("6) Regresar");
    }
}