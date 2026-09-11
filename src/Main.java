public class Main {
    public static void main(String[] args) {
        Queue cola = new Queue();

        System.out.println("--- Modo FIFO (sin prioridad) ---");
        cola.insert("Ana");
        cola.insert("Juan");
        cola.insert("Pedro");
        System.out.println("Cola: " + cola.toString());
        System.out.println("Tamaño: " + cola.size());
        System.out.println("¿Está vacía? " + cola.isEmpty());

        System.out.println("\n--- Search ---");
        System.out.println("Contiene 'Juan': " + cola.search("Juan"));
        System.out.println("Contiene 'Luis': " + cola.search("Luis"));

        System.out.println("\n--- Extract (FIFO: debería salir 'Ana' primero) ---");
        System.out.println("Extract: " + cola.extract());
        System.out.println("Cola: " + cola.toString());
        System.out.println("Tamaño: " + cola.size());

        cola.clear();
        System.out.println("\n--- Clear ---");
        System.out.println("Cola: " + cola.toString());
        System.out.println("¿Está vacía? " + cola.isEmpty());

        System.out.println("\n--- Modo con prioridad ---");
        cola.insert("Tarea normal", 1);
        cola.insert("Tarea urgente", 5);
        cola.insert("Tarea media", 3);
        cola.insert("Otra urgente", 5);
        System.out.println("Cola: " + cola.toString());
        System.out.println("Tamaño: " + cola.size());

        System.out.println("\n--- Extract en orden de prioridad ---");
        System.out.println("Extract: " + cola.extract()); // debería ser "Tarea urgente" (prioridad 5, entró primero entre iguales)
        System.out.println("Cola: " + cola.toString());
        System.out.println("Extract: " + cola.extract()); // "Otra urgente" (misma prioridad 5, pero entró después)
        System.out.println("Cola: " + cola.toString());
        System.out.println("Extract: " + cola.extract()); // "Tarea media" (prioridad 3)
        System.out.println("Cola: " + cola.toString());
        System.out.println("Extract: " + cola.extract()); // "Tarea normal" (prioridad 1)
        System.out.println("Cola: " + cola.toString());

        System.out.println("\n--- Cola vacía ---");
        System.out.println("Extract en cola vacía: " + cola.extract());
        System.out.println("¿Está vacía? " + cola.isEmpty());
    }
}