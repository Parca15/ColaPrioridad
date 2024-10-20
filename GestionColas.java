package ColaPrioridad;

import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Queue;

public class GestionColas {
    private PriorityQueue<Paciente> colaPrioridad;
    private Queue<Paciente> colaNormal;

    public GestionColas() {
        colaPrioridad = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getGravedad(), p1.getGravedad()));
        colaNormal = new LinkedList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        if (paciente.getGravedad() > 0) {
            colaPrioridad.offer(paciente);
        } else {
            colaNormal.offer(paciente);
        }
    }


    public Paciente consumirPaciente() {
        if (!colaPrioridad.isEmpty()) {
            return colaPrioridad.poll();
        } else if (!colaNormal.isEmpty()) {
            return colaNormal.poll();
        }
        return null;
    }


    public Queue<Paciente> getColaPrioridad() {
        return colaPrioridad;
    }


    public Queue<Paciente> getColaNormal() {
        return colaNormal;
    }
}
