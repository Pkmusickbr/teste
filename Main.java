public class Main {
    public static void main(String[] args) {
        // Testando LinkedStack
        System.out.println("Testando LinkedStack:");
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Tamanho da pilha: " + stack.size());
        System.out.println("Elemento no topo: " + stack.peek());

        System.out.println("Desempilhando...");
        while (!stack.isEmpty()) {
            System.out.println("Desempilhado: " + stack.pop());
        }

        // Testando LinkedQueue
        System.out.println("\nTestando LinkedQueue:");
        Queue<String> queue = new LinkedQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("Tamanho da fila: " + queue.size());
        System.out.println("Elemento na frente: " + queue.peek());

        System.out.println("Desenfileirando...");
        while (!queue.isEmpty()) {
            System.out.println("Desenfileirado: " + queue.dequeue());
        }
    }
}
