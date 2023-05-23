package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String beginningState = "         ";

        char[][] grid = generate2DGrid(beginningState);

        printGrid(grid);

        char player = 'X';

        do {
            getPlayerInput(grid, player);

            printGrid(grid);

            player = player == 'X' ? 'O' : 'X';
        } while (gameNotEnded(grid));

    }

    private static char[][] generate2DGrid(String input) {
        char[][] symbols = new char[3][3];

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                symbols[i][j] = input.charAt(index);
                index++;
            }
        }

        return symbols;
    }

    private static void getPlayerInput(char[][] grid, char player) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputOne = scanner.next();
            String inputTwo = scanner.next();

            int firstCoordinate;
            int secondCoordinate;

            try {
                firstCoordinate = Integer.parseInt(inputOne);
                secondCoordinate = Integer.parseInt(inputTwo);
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (firstCoordinate > 3 || firstCoordinate < 1 || secondCoordinate > 3 || secondCoordinate < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (grid[firstCoordinate - 1][secondCoordinate - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            grid[firstCoordinate - 1][secondCoordinate - 1] = player;
            break;
        }

    }

    private static boolean gameNotEnded(char[][] grid) {

        int amountX = 0;
        int amountO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'X') {
                    amountX++;
                } else if (grid[i][j] == 'O') {
                    amountO++;
                }
            }
        }

        if (Math.abs(amountX - amountO) > 1) {
            System.out.println("Impossible");
            return false;
        }

        int firstRow = grid[0][0] + grid[0][1] + grid[0][2];
        int secondRow = grid[1][0] + grid[1][1] + grid[1][2];
        int thirdRow = grid[2][0] + grid[2][1] + grid[2][2];
        int firstCol = grid[0][0] + grid[1][0] + grid[2][0];
        int secondCol = grid[0][1] + grid[1][1] + grid[2][1];
        int thirdCol = grid[0][2] + grid[1][2] + grid[2][2];
        int firstDia = grid[0][0] + grid[1][1] + grid[2][2];
        int secondDia = grid[2][0] + grid[1][1] + grid[0][2];

        boolean xWin = false;
        boolean oWin = false;

        if (firstRow == 264
                || secondRow == 264
                || thirdRow == 264
                || firstCol == 264
                || secondCol == 264
                || thirdCol == 264
                || firstDia == 264
                || secondDia == 264) {
            xWin = true;
        }

        if (firstRow == 237
                || secondRow == 237
                || thirdRow == 237
                || firstCol == 237
                || secondCol == 237
                || thirdCol == 237
                || firstDia == 237
                || secondDia == 237) {
            oWin = true;
        }

        if (xWin && oWin) {
            System.out.println("Impossible");
            return false;
        } else if (xWin) {
            System.out.println("X wins");
            return false;
        } else if (oWin) {
            System.out.println("O wins");
            return false;
        } else if (amountO + amountX == 9) {
            System.out.println("Draw");
            return false;
        } else {
            return true;
        }

    }

    public static void printGrid(char[][] grid) {
        System.out.println("---------");


        System.out.println("| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        System.out.println("| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        System.out.println("| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");

        System.out.println("---------");
    }
}
