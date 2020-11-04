package estudiantes;
import java.util.ArrayList;

public class Estudiante {
    String nombre;
    String documento;
    ArrayList<Double> notas = new ArrayList<Double>();

    public Estudiante(String nombre, String documento, ArrayList<Double> notas) {
        this.nombre = nombre;
        this.documento = documento;
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Documento: " + documento + '\'' +
                ", Estudiante: " + nombre + '\'' +
                ", notas: " + notas;
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
}
