package estudiantes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccionesParaEstudiante {
    public static List<Estudiante> estudiantes = new ArrayList<>();

    public void crearEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        System.out.println("Estudiante creado");
    }

    public void eliminarEstudiante(String documento) {
        estudiantes = estudiantes.stream()
                .filter(name -> !name.getDocumento().equals(documento))
                .collect(Collectors.toList());
        System.out.println("Estudiante eliminado");
    }

    public void actualizarNombreEstudiante(String documento, String nombre) {
        estudiantes.stream()
                .filter(name -> name.getDocumento().equals(documento))
                .forEach(estudiante -> {
                    estudiante.setNombre(nombre);
                });
        System.out.println("Estudiante actualizado");

    }

    public void actualizarNotaEstudiante(String documento, ArrayList<Double> nuevasNotas) {
        estudiantes.stream()
                .filter(estudiante -> estudiante.getDocumento().equals(documento))
                .forEach(estudiante -> {
                    estudiante.setNotas(nuevasNotas);
                });

        System.out.println("Estudiante actualizado");

    }

    public void obtenerMejoresEstudiantes() {

        estudiantes.stream()
                .sorted(Comparator.comparing(Estudiante::obtenerPromedio, Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList())
                .forEach(estudiante -> System.out.println(estudiante.toString()));


    }

    public int buscarIndiceEstudiantes(String documento) {
        return IntStream.range(0, estudiantes.size())
                .filter(i -> documento.equals(estudiantes.get(i).documento))
                .findFirst()
                .orElse(-1);
    }

    public void promedioEstudiantes() {
        Map<String, Double> map = estudiantes.stream()
                .filter(estudiante -> estudiante.obtenerPromedio() >= 3.0)
                .collect(Collectors.toMap(Estudiante::getDocumento, Estudiante::obtenerPromedio));

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println("Documento: " + entry.getKey() + ", Promedio: " + entry.getValue());
        }

        if (map.size() == 0) {
            System.out.println("No se encuentran estudiantes ganados");
        }
    }
}
