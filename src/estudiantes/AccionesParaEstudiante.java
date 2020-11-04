package estudiantes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class AccionesParaEstudiante {
    public static List<Estudiante> estudiantes = new ArrayList<>();
    public ArrayList<Double> notas = new ArrayList <Double>() {
        {
            add(2.0);
            add(3.0);
            add(4.0);
            add(5.0);
        }
    };

    public boolean crearEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        return true;
    }

    public void eliminarEstudiante(String documento) {
        estudiantes = estudiantes.stream()
                .filter(name -> name.getDocumento() != documento)
                .collect(Collectors.toList());
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        int indiceEstudiante = buscarIndiceEstudiantes(estudiante.documento);
        estudiantes.set(indiceEstudiante, estudiante);
    }

    public List<Estudiante> obtenerMejoresEstudiantes() {
        ArrayList<Estudiante> mejoresEstudiantes = new ArrayList<>();

        List<Double> promedio = estudiantes.stream()
                .map(estudiante -> obtenerPromedio(estudiante.getNotas()))
                .sorted()
//                .max(Comparator.comparing(estudiante -> obtenerPromedio(estudiante.getNotas())))
                .collect(Collectors.toList());

        Collections.reverse(promedio);
        promedio = promedio.stream().limit(3).collect(Collectors.toList());

        for (int i = 0; i < estudiantes.size(); i++) {
//            System.out.println(obtenerPromedio(estudiantes.get(i).getNotas()));
            if (promedio.indexOf(obtenerPromedio(estudiantes.get(i).getNotas())) != -1) {
                mejoresEstudiantes.add(estudiantes.get(i));
            }
        }


        return mejoresEstudiantes;
    }

    public int buscarIndice(List<Double> a, Double target) {
        return IntStream.range(0, estudiantes.size())
                .filter(i -> target == a.get(i))
                .findFirst()
                .orElse(-1);
    }

    public int buscarIndiceEstudiantes(String documento) {
        return IntStream.range(0, estudiantes.size())
                .filter(i -> documento == estudiantes.get(i).documento)
                .findFirst()
                .orElse(-1);
    }

    public double obtenerPromedio(ArrayList<Double> lista) {
        OptionalDouble promedio = OptionalDouble.empty();
        promedio = lista.stream()
                .mapToDouble(e -> e)
                .average();

        return promedio.isPresent() ? promedio.getAsDouble() : null;
    }

    public void promedioEstudiantes() {
        Map<String, Double> map = estudiantes.stream()
                .collect(Collectors.toMap(Estudiante::getDocumento, estudiante -> obtenerPromedio(estudiante.getNotas())));
//        return map;
        System.out.println(map);
    }
}
