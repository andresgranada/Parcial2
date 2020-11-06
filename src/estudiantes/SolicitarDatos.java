package estudiantes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolicitarDatos {
    public AccionesParaEstudiante accionesParaEstudiante = new AccionesParaEstudiante();
    Scanner teclado = new Scanner(System.in);

    public void crearEstudiante() {
        String textoAMostrar = "-------------------------- \n" +
                "Crear estudiante \n" +
                "-------------------------- \n";
        System.out.println(textoAMostrar);

        ArrayList<Double> notas = new ArrayList<>();

        System.out.println("Ingrese su documento: ");
        String documento = teclado.nextLine();

        System.out.println("Ingrese su nombre:");
        String nombre = teclado.nextLine();


        System.out.println("Notas");

        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese nota "+(i+1)+":");
            Double nota = teclado.nextDouble();
            teclado.nextLine();
            notas.add(nota);
        }

        Estudiante estudiante = new Estudiante(nombre,documento,notas);
        accionesParaEstudiante.crearEstudiante(estudiante);

    }

    public void actualizarEstudiante() {

        if (!validarEstudiantesExistentes()) {
            return;
        }

        System.out.println("Escriba el documento del estudiante");
        String documento = teclado.nextLine();

        if (accionesParaEstudiante.buscarIndiceEstudiantes(documento) < 0) {
            System.out.println("Documento incorrecto");
            return;
        }

        String textoAMostrar = "-------------------------- \n" +
                "Actualizar estudiante \n" +
                "-------------------------- \n";
        System.out.println(textoAMostrar);

        String textoActualizarEstudiante =  "Ingrese la opción 1 para actualizar nombre: \n" +
                "Ingrese la opción 2 para actualizar notas: \n";
        System.out.println(textoActualizarEstudiante);
        String opcionElegida = teclado.nextLine();

        int opcion = Integer.parseInt(opcionElegida);

        switch(opcion) {
            case 1:
                System.out.println("Nuevo nombre:");
                String nombre = teclado.nextLine();
                accionesParaEstudiante.actualizarNombreEstudiante(documento, nombre);
                break;
            case 2:
                ArrayList<Double> notas = new ArrayList<Double>();
                for (int i = 0; i < 4; i++) {
                    System.out.println("Ingrese nota "+(i+1)+":");
                    Double nota = teclado.nextDouble();
                    teclado.nextLine();
                    notas.add(nota);
                }
                accionesParaEstudiante.actualizarNotaEstudiante(documento, notas);
                break;
            default:
                System.out.println("Opción incorrecta, seleccione una opción correcta");
        }
    }

    public void menu() {
        String textoMenu =  "-------------------------------- Menú ---------------------------------- \n" +
                            "Ingrese la opción 1 para ingresar un estudiante: \n" +
                            "Ingrese la opción 2 para eliminar un estudiante: \n" +
                            "Ingrese la opción 3 para actualizar un estudiante: \n" +
                            "Ingrese la opción 4 para ver los 3 mejores estudiantes: \n" +
                            "Ingrese la opción 5 para ver el promedio y los estudiantes que ganaron: \n" +
                            "Ingrese la opción 6 para salir: \n" +
                            "----------------------------------------------------------------------- \n";

        System.out.println(textoMenu);
        try {
            String opcionElegida = teclado.nextLine();
            llamarFuncionElegida(opcionElegida);
        }
        catch(Exception e) {
            String opcionElegida = "0";
            llamarFuncionElegida(opcionElegida);
        }

    }

    public void llamarFuncionElegida(String opcionElegida) {
        int opcion = Integer.parseInt(opcionElegida);

        switch(opcion) {
            case 1:
                crearEstudiante();
                break;
            case 2:
                eliminarEstudiante();
                break;
            case 3:
                actualizarEstudiante();
                break;
            case 4:
                mejoresEstudiantes();
                break;
            case 5:
                estudiantesGanados();
                break;
            case 6:
                System.out.println("Proceso terminado");
                System.exit(0);
                break;
            default:
                System.out.println("Opción incorrecta, seleccione una opción correcta");
        }

        menu();
        System.out.println("Termina");


    }

    public void eliminarEstudiante() {
        if (!validarEstudiantesExistentes()) {
            return;
        }

        String textoAMostrar = "-------------------------- \n" +
                                "Eliminar \n" +
                                "-------------------------- \n";
        System.out.println(textoAMostrar);

        System.out.println("Escriba el documento del estudiante");
        String documento = teclado.nextLine();
        if (accionesParaEstudiante.buscarIndiceEstudiantes(documento) < 0) {
            System.out.println("Documento incorrecto");
            return;
        }

        accionesParaEstudiante.eliminarEstudiante(documento);
    }

    public void mejoresEstudiantes() {
        String textoAMostrar = "-------------------------- \n" +
                "Los 3 mejores estudiantes \n" +
                "-------------------------- \n";
        System.out.println(textoAMostrar);

        accionesParaEstudiante.obtenerMejoresEstudiantes();

        if (!validarEstudiantesExistentes()) {
            return;
        }
    }

    public void estudiantesGanados() {
        String textoAMostrar = "-------------------------- \n" +
                "Estudiantes que ganaron \n" +
                "-------------------------- \n";
        System.out.println(textoAMostrar);

        accionesParaEstudiante.promedioEstudiantes();
    }

    public boolean validarEstudiantesExistentes() {
        if (accionesParaEstudiante.estudiantes.size() < 1) {
            System.out.println("No hay estudiantes");
            return false;
        }

        return true;
    }

}
