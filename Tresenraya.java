package ExercicisUF6.TresEnRaya;
/**
 * @author Esther Carcel Bastidas
 */
import java.util.Scanner;

public class Tresenraya {
    /**
     * @param args the command line arguments
     */
            public static void main(String[] args) {
        try (Scanner lector = new Scanner(System.in)) {
            int[][] tauler = new int[3][3];

            do {
                boolean guanyat = false;
                int jugador = 1;

                while (!guanyat) {
                    /*He posat un “mostrar tauler” perquè els jugadors visualitzin millor la partida. D'aquesta manera, abans de cada torn surt com està el tauler i les fitxes*/
                    mostrarTauler(tauler);
                    System.out.print("Es el torn del jugador: " + jugador + "\n");
                    int fila, columna;
                    /* Les files i les columnes van del zero a l'u. désquerra a dereta i */
                    do {
                        System.out.print("Introdueix la fila: ");
                        fila = lector.nextInt();
                        System.out.print("Introdueix la columna: ");
                        columna = lector.nextInt();
                    } while (tauler[fila][columna] != 0);

                    tauler[fila][columna] = jugador;
                    guanyat = guanyat(tauler, jugador);

                    if (!guanyat) {
                        jugador = 3 - jugador;
                    }
                }

                mostrarTauler(tauler);
                System.out.println("El jugador " + jugador + " ha guanyat la partida!");
                /*He posat un "jugar de nou" */
            } while (lector.nextLine().equalsIgnoreCase("jugar de nou"));
        }
    }

    public static void mostrarTauler(int[][] tauler) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tauler[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean guanyat(int[][] tauler, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (tauler[i][0] == jugador && tauler[i][1] == jugador && tauler[i][2] == jugador) {
                return true;
            }
            if (tauler[0][i] == jugador && tauler[1][i] == jugador && tauler[2][i] == jugador) {
                return true;
            }
        }

        if (tauler[0][0] == jugador && tauler[1][1] == jugador && tauler[2][2] == jugador) {
            return true;
        }
        if (tauler[0][2] == jugador && tauler[1][1] == jugador && tauler[2][0] == jugador) {
            return true;
        }

        return false;
    }
}
