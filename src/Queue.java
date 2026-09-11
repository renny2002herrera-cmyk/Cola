public class Queue implements QueueInterface {

    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;


    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
        isPriorityQueue = false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean insert(Object object) {
        return insert(object, 0);
    }

    @Override
    public boolean insert(Object object, int priority) {
        if (object == null) return false;

        QueueNode nuevo = new QueueNode(object, priority);

        if (priority != 0) {
            isPriorityQueue = true;
        }

        if (head == null) {
            head = nuevo;
            tail = nuevo;
        }
        else if (!isPriorityQueue) {
            tail.next = nuevo;
            tail = nuevo;
        }
        else {
            if (priority > head.priority) {
                nuevo.next = head;
                head = nuevo;
            } else {
                QueueNode actual = head;
                while (actual.next != null && actual.next.priority >= priority) {
                    actual = actual.next;
                }
                nuevo.next = actual.next;
                actual.next = nuevo;

                if (nuevo.next == null) {
                    tail = nuevo;
                }
            }
        }

        size++;
        return true;
    }

    @Override
    public Object extract() {
        if (head == null) {
            return null;
        }

        Object dato = head.dato;
        head = head.next;
        size--;

        if (head == null) {
            tail = null; // la cola quedó vacía
        }

        return dato;
    }

    @Override
    public boolean search(Object object) {
        if (object == null || head == null) {
            return false;
        }

        QueueNode actual = head;
        while (actual != null) {
            if (actual.dato.equals(object)) {
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        String resultado = "[";
        QueueNode actual = head;

        while (actual != null) {
            resultado = resultado + actual.dato;
            if (isPriorityQueue) {
                resultado = resultado + "(p" + actual.priority + ")";
            }
            if (actual.next != null) {
                resultado = resultado + ", ";
            }
            actual = actual.next;
        }
        resultado = resultado + "]";

        return resultado;
    }
}