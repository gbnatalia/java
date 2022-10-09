import java.util.*;

public class KnightTour {
    static int N = 8;

    // xMove[] и yMove[] перемещение коня по оси Х и Y соответственно
    static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String args[]) {
        N = 5;
        solveKT();
    }

    // проверка валидности
    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    // печать массива sol
    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.printf("%02d ",sol[x][y]);
            System.out.println();
        }
    }

    // Функция получает 1 вариант передвижения коня по доске.
    // Возвращает true при успехе, иначе false
    static boolean solveKT()
    {
        int src_x = 0, src_y = 0;

        // создание и инициализация матрицы
        int sol[][] = new int[N][N];
        for (int[] row: sol)
            Arrays.fill(row, -1);

        // начальная точка коня
        sol[src_x][src_y] = 1;

        // Стартуем с точки 0:0 и проходим все варианты
        if (!solveKTUtil(src_x, src_y, 1, sol)) {
            System.out.println("Решения нет");
            return false;
        }
        else
            printSolution(sol);

        return true;
    }

    // Вспомогательная функция
    static boolean solveKTUtil(int x, int y, int movei, int sol[][]) {

        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        // Проверка перемещений с текущей координаты x, y
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei + 1;
                if (solveKTUtil(next_x, next_y, movei + 1, sol))
                    return true;
                else
                    sol[next_x][next_y] = -1; // возврат
            }
        }
        return false;
    }
}
