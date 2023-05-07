import java.util.Scanner;

import workers.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DataBase db = DataBase.getConnection();
        String nombre, nacionalidad, podios, numEmpleado, numPiloto, departamento, seccion, area;
        int edad;
        float salario;

        int n;
        do {
            System.out.println("\nEmpleados");
            System.out.println("1) Registrar nuevo empleado");
            System.out.println("2) Mostrar lista de empleados");
            System.out.println("3) Actualizar datos");
            System.out.println("4) Dar de baja a empleado");
            System.out.println("5) Salir");
            System.out.print("¿Qué desea hacer?: ");
            n = scan.nextInt();
            int x;
            switch (n) {
                case 1: // CREATE
                    do {
                        menu_empleados();
                        System.out.print("¿Qué tipo de empleado desea registrar?: ");
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
                                    db.insert("pilotos", piloto.getInsertValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                break;
                            case 2: // Mecanico
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                numEmpleado = InputUtils.reqString("# de empleado: ");
                                seccion = InputUtils.reqString("Seccion: ");
                                Mecanicos mecanico = new Mecanicos(nombre, edad, salario, numEmpleado, seccion);
                                try {
                                    db.insert("mecanicos", mecanico.getInsertValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                break;
                            case 3: // Ingeniero
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                numEmpleado = InputUtils.reqString("# de empleado: ");
                                departamento = InputUtils.reqString("Departamento: ");
                                Ingenieros ingeniero = new Ingenieros(nombre, edad, salario, numEmpleado, departamento);
                                try {
                                    db.insert("ingenieros", ingeniero.getInsertValues());
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
                                    db.insert("mercadologos", mercadologo.getInsertValues());
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
                                    db.insert("estrategas", estratega.getInsertValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 6:
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
                        System.out.print("¿Qué lista desea visulizar?: ");
                        x = scan.nextInt();
                        switch (x) {
                            case 1: // Piloto
                                db.displayTable("pilotos");
                                break;
                            case 2: // Mecanico
                                db.displayTable("mecanicos");
                                break;
                            case 3: // Ingeniero
                                db.displayTable("ingenieros");
                                break;
                            case 4: // Mercadologo
                                db.displayTable("mercadologos");
                                break;
                            case 5: // Estratega
                                db.displayTable("estrategas");
                                break;
                            default:
                                break;
                        }
                    } while (x != 6);
                    break;
                case 3: // UPDATE
                    do {
                        menu_empleados();
                        System.out.print("¿Qué tipo de empleado desea actualizar?: ");
                        x = scan.nextInt();
                        switch (x) {
                            case 1: // Piloto
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                try {
                                    if (!db.findOne("pilotos", numEmpleado)) {
                                        System.out.println("Este empleado no está registrado en los pilotos");
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                numPiloto = InputUtils.reqString("# de piloto: ");
                                podios = InputUtils.reqString("# de victorias: ");
                                nacionalidad = InputUtils.reqString("Nacionalidad: ");

                                Piloto piloto = new Piloto(nombre, edad, salario, numEmpleado, numPiloto, podios,
                                        nacionalidad);
                                try {
                                    db.update("pilotos", numEmpleado, piloto.getUpdateValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 2: // Mecanico
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                try {
                                    if (!db.findOne("mecanicos", numEmpleado)) {
                                        System.out.println("Este empleado no está registrado en los mecanicos");
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                seccion = InputUtils.reqString("Sección: ");

                                Mecanicos mecanico = new Mecanicos(nombre, edad, salario, numEmpleado, seccion);
                                try {
                                    db.update("mecanicos", numEmpleado, mecanico.getUpdateValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 3: // Ingeniero
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                try {
                                    if (!db.findOne("ingenieros", numEmpleado)) {
                                        System.out.println("Este empleado no está registrado en los ingenieros");
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                departamento = InputUtils.reqString("Departamento: ");

                                Ingenieros ingeniero = new Ingenieros(nombre, edad, salario, numEmpleado, departamento);
                                try {
                                    db.update("ingenieros", numEmpleado, ingeniero.getUpdateValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 4: // Mercadologo
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                try {
                                    if (!db.findOne("mercadologos", numEmpleado)) {
                                        System.out.println("Este empleado no está registrado en los mercadologos");
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");
                                area = InputUtils.reqString("Area: ");

                                Mercadologos mercadologo = new Mercadologos(nombre, edad, salario, numEmpleado, area);
                                try {
                                    db.update("mercadologos", numEmpleado, mercadologo.getUpdateValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 5: // Estratega
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a actualizar: ");
                                try {
                                    if (!db.findOne("estrategas", numEmpleado)) {
                                        System.out.println("Este empleado no está registrado en los estrategas");
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                nombre = InputUtils.reqString("Nombre: ");
                                edad = InputUtils.reqInt("Edad: ");
                                salario = InputUtils.reqFloat("Salario: ");

                                Estrategas estratega = new Estrategas(nombre, edad, salario, numEmpleado);
                                try {
                                    db.update("estrategas", numEmpleado, estratega.getUpdateValues());
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            default:
                                break;
                        }
                    } while (x != 6);
                    break;
                case 4: // DELETE
                    do {
                        menu_empleados();
                        System.out.print("¿Qué tipo de empleado desea eliminar?: ");
                        x = scan.nextInt();
                        switch (x) {
                            case 1: // Piloto
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a eliminar: ");
                                try {
                                    db.delete("pilotos", numEmpleado);
                                    System.out.println("Usuario " + numEmpleado + " eliminado!");
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 2: // Mecanico
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a eliminar: ");
                                try {
                                    db.delete("mecanicos", numEmpleado);
                                    System.out.println("Usuario " + numEmpleado + " eliminado!");
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 3: // Ingeniero
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a eliminar: ");
                                try {
                                    db.delete("ingenieros", numEmpleado);
                                    System.out.println("Usuario " + numEmpleado + " eliminado!");
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 4: // Mercadologo
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a eliminar: ");
                                try {
                                    db.delete("mercadologos", numEmpleado);
                                    System.out.println("Usuario " + numEmpleado + " eliminado!");
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 5: // Estratega
                                numEmpleado = InputUtils.reqString("Ingrese el numero de empleado a eliminar: ");
                                try {
                                    db.delete("estrategas", numEmpleado);
                                    System.out.println("Usuario " + numEmpleado + " eliminado!");
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
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
        System.out.println("\n1) Piloto");
        System.out.println("2) Mecanico");
        System.out.println("3) Ingeniero");
        System.out.println("4) Mercadologo");
        System.out.println("5) Estratega");
        System.out.println("6) Regresar");
    }
}