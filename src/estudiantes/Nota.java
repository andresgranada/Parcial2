package estudiantes;

import java.util.ArrayList;

public class Nota {
    double nota1;
    double nota2;
    double nota3;
    double nota4;

    public Nota(double nota1, double nota2, double nota3, double nota4) {
//        super(nombre, documento, notas);
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public ArrayList<Double> getTodasLasNotas() {
        ArrayList<Double> notas = new ArrayList<Double>();
        notas.add(this.nota1);
        notas.add(this.nota2);
        notas.add(this.nota3);
        notas.add(this.nota4);
        return notas;
    }
}
