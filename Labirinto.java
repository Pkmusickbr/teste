import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
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
