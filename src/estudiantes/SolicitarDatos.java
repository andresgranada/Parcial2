package estudiantes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolicitarDatos {
    public AccionesParaEstudiante accionesParaEstudiante = new AccionesParaEstudiante();
    public Scanner teclado = new Scanner(System.in);

    public void crearEstudiante() {
        ArrayList<Double> notas = new ArrayList<Double>();
        Scanner teclado1 = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);

        System.out.println("Ingrese su documento: ");
        String documento = teclado1.nextLine();

        System.out.println("Ingrese su nombre:");
        String nombre = teclado2.nextLine();


        System.out.println("Notas");

        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese nota "+(i+1)+":");
            Double nota = teclado2.nextDouble();
            notas.add(nota);
        }

        Estudiante estudiante = new Estudiante(nombre,documento,notas);
        if (accionesParaEstudiante.crearEstudiante(estudiante)) {
            System.out.println("Estudiante creado");
        }

    }

    public void actualizarEstudiante() {

        if (accionesParaEstudiante.estudiantes.size() < 1) {
            System.out.println("No hay estudiantes");
            return;
        }

        System.out.println("Escriba el documento del estudiante");
        String documento = teclado.nextLine();

        if (accionesParaEstudiante.buscarIndiceEstudiantes(documento) < 0) {
            System.out.println("Documento incorrecto");
            return;
        }
        ArrayList<Double> notas = new ArrayList<Double>();

        System.out.println("Nuevo nombre:");
        String nombre = teclado.nextLine();

        System.out.println("Notas");

        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese nota "+(i+1)+":");
            Double nota = teclado.nextDouble();
            notas.add(nota);
        }

        Estudiante estudiante = new Estudiante(nombre,documento,notas);
        accionesParaEstudiante.actualizarEstudiante(estudiante);

        System.out.println("Estudiante actualizado");


    }

    public void menu() {
        System.out.println("Menú");
        String textoMenu =  "Ingrese la opción 1 para ingresar un estudiante: \n" +
                            "Ingrese la opción 2 para eliminar un estudiante: \n" +
                            "Ingrese la opción 3 para actualizar un estudiante: \n" +
                            "Ingrese la opción 4 para ver los 3 mejores estudiantes: \n" +
                            "Ingrese la opción 5 para ver el promedio de los estudiantes: \n";

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
                accionesParaEstudiante.promedioEstudiantes();
            default:
                System.out.println("Opción incorrecta, seleccione una opción correcta");
        }

        menu();


    }

    public void eliminarEstudiante() {
        if (accionesParaEstudiante.estudiantes.size() < 1) {
            System.out.println("No hay estudiantes");
            return;
        }

        System.out.println("Escriba el documento del estudiante");
        String documento = teclado.nextLine();
        if (accionesParaEstudiante.buscarIndiceEstudiantes(documento) < 0) {
            System.out.println("Documento incorrecto");
            return;
        }
        accionesParaEstudiante.eliminarEstudiante(documento);
        System.out.println("Estudiante eliminado");
    }

    public void mejoresEstudiantes() {
        List<Estudiante> mejoresEstudiantes = accionesParaEstudiante.obtenerMejoresEstudiantes();
        mejoresEstudiantes.stream().forEach((p)-> {
            System.out.println(p.toString());
        });
        if (accionesParaEstudiante.estudiantes.size() < 1) {
            System.out.println("No hay estudiantes");
            return;
        }
    }

}
