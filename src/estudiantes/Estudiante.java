package estudiantes;
import java.util.ArrayList;
import java.util.OptionalDouble;

public class Estudiante {
    String nombre;
    String documento;
    ArrayList<Double> notas;

    public Estudiante(String nombre, String documento, ArrayList<Double> notas) {
        this.nombre = nombre;
        this.documento = documento;
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Documento: " + documento + '\'' +
                ", Estudiante: " + nombre + '\'' +
                ", notas: " + notas + '\'' +
                ", promedio: " + obtenerPromedio();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public double obtenerPromedio() {
        OptionalDouble promedio;
        promedio = notas.stream()
                .mapToDouble(e -> e)
                .average();

        return promedio.isPresent() ? promedio.getAsDouble() : null;
    }
}
