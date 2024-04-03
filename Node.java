import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}

interface Stack<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}

class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E removedElement = top.data;
        top = top.next;
        size--;
        return removedElement;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }
}

interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
}

class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E removedElement = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return removedElement;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }
}

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

        // Testando Etapa 1 - Labirinto
        try {
            Labirinto labirinto = new Labirinto();
            labirinto.criaLabirinto("labirinto.txt");
            boolean resultado = labirinto.percorreLabirinto();
            System.out.println("Labirinto solucionado: " + resultado);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo do labirinto: " + e.getMessage());
        }

        // Testando Etapa 2 - Candidatos
        Candidato[] candidatos = geraCandidatosAleatorios(10);
        ordenaCandidatosPorNome(candidatos);
        System.out.println("Ordenados por nome:");
        System.out.println(Arrays.toString(candidatos));

        ordenaCandidatosPorVotos(candidatos);
        System.out.println("\nOrdenados por intenções de votos:");
        System.out.println(Arrays.toString(candidatos));

        ordenaCandidatosPorPartido(candidatos);
        System.out.println("\nOrdenados por partido:");
        System.out.println(Arrays.toString(candidatos));

        Candidato candidatoPesquisado = pesquisaBinariaCandidatos(candidatos, "João");
        System.out.println("\nCandidato encontrado: " + candidatoPesquisado);

        // Testando Etapa 3 - Listas Estáticas
        int[] array = {1, 2, 3, 4, 1, 2, 1, 5};
        int count = contaElementos(array, 1);
        System.out.println("\nNúmero de vezes que 1 aparece na lista: " + count);

        Stack<Character> brackets1 = new LinkedStack<>();
        brackets1.push('(');
        brackets1.push('(');
        brackets1.push('A');
        System.out.println("\nExpressão 1 está correta? " + checkBrackets(brackets1));

        Stack<Character> brackets2 = new LinkedStack<>();
        brackets2.push('(');
        brackets2.push('A');
        brackets2.push('+');
        System.out.println("Expressão 2 está correta? " + checkBrackets(brackets2));

        Stack<Character> brackets3 = new LinkedStack<>();
        brackets3.push('(');
        brackets3.push(')');
        brackets3.push('A');
        brackets3.push('+');
        System.out.println("Expressão 3 está correta? " + checkBrackets(brackets3));

        Stack<Character> brackets4 = new LinkedStack<>();
        brackets4.push('(');
        brackets4.push('A');
        brackets4.push('+');
        brackets4.push('(');
        brackets4.push('B');
        brackets4.push(')');
        brackets4.push(')');
        System.out.println("Expressão 4 está correta? " + checkBrackets(brackets4));
    }

    private static Candidato[] geraCandidatosAleatorios(int quantidade) {
        Candidato[] candidatos = new Candidato[quantidade];
        for (int i = 0; i < quantidade; i++) {
            candidatos[i] = new Candidato("Candidato" + i, "Partido" + (i % 3), (int) (Math.random() * 1000));
        }
        return candidatos;
    }

    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        // Implementação da ordenação por nome
    }

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        // Implementação da ordenação por intenções de votos
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        // Implementação da ordenação por partido
    }

    public static Candidato pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        // Implementação da pesquisa binária
        return null;
    }

    public static int contaElementos(int[] array, int el) {
        // Implementação do método contaElementos
        return 0;
    }

    public static boolean checkBrackets(Stack<Character> s1) {
        // Implementação do método checkBrackets
        return false;
    }
}

class Labirinto {
    private char[][] labirinto;

    public Labirinto() {
        // Construtor vazio
    }

    public void criaLabirinto(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int rows = 0;
        int cols = 0;

        while ((line = reader.readLine()) != null) {
            rows++;
            cols = line.length();
        }

        reader.close();

        labirinto = new char[rows][cols];

        reader = new BufferedReader(new FileReader(filename));
        int row = 0;

        while ((line = reader.readLine()) != null) {
            char[] chars = line.toCharArray();
            for (int col = 0; col < cols; col++) {
                labirinto[row][col] = chars[col];
            }
            row++;
        }

        reader.close();
    }

    public boolean percorreLabirinto() {
        // Implementação do método para percorrer o labirinto de forma recursiva
        return false;
    }
}

class Candidato {
    private String nome;
    private String partido;
    private int intencoesVotos;

    public Candidato(String nome, String partido, int intencoesVotos) {
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getIntencoesVotos() {
        return intencoesVotos;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", partido='" + partido + '\'' +
                ", intencoesVotos=" + intencoesVotos +
                '}';
    }
}
