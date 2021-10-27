
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int sits = scanner.nextInt();

        String[][] str = new String[rows + 1][sits + 1];
        int total = 0;
        int currentIncome = 0;

        System.out.println("Total income:");
        if (rows * sits <= 60) {
            total = (rows * sits * 10);
            System.out.println("$" + (rows * sits * 10));
        } else if (rows * sits > 60 && rows % 2 == 0) {
            total = ((rows / 2 * sits * 10) + (rows / 2 * sits * 8));
            System.out.println("$" + ((rows / 2 * sits * 10) + (rows / 2 * sits * 8)));
        } else if (rows * sits > 60 && rows % 2 != 0) {
            total = (((rows / 2 + 1) * sits * 8) + (rows / 2 * sits * 10));
            System.out.println("$" + (((rows / 2 + 1) * sits * 8) + (rows / 2 * sits * 10)));
        }

        boolean exit = false;

        int ticketCount = 0;

        boolean bueTickets = false;

        int price1 = 0;

        while (exit == false) {
            menu();
            int numbMenu = scanner.nextInt();
            switch (numbMenu) {

                case 1:
                    seats(rows, sits, str);
                    break;

                case 2:
                    while (bueTickets == false) {
                        System.out.println("Enter a row number:");
                        int rowsInput = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seatInput = scanner.nextInt();

                        if (rows * sits <= 60) {
                            currentIncome += 10;

                        } else if (rows * sits > 60 && rows % 2 == 0 && rowsInput >= rows / 2) {
                            currentIncome += 8;

                        } else if (rows * sits > 60 && rows % 2 != 0 && rowsInput >= rows / 2 + 1) {
                            currentIncome += 8;


                        } else {
                            currentIncome += 10;

                        }


                        if (rowsInput > rows || seatInput > sits) {
                            System.out.println(" Wrong input!");
                            continue;
                        } else if (str[rowsInput][seatInput] == "B") {
                            System.out.println("That ticket has already been purchased!");
                            continue;
                        }
                        price(rows, sits, rowsInput);
                        str[rowsInput][seatInput] = "B";
                        ticketCount++;
                        break;
                    }
                    break;
                case 3:
                    statistic(rows, sits, ticketCount, total, currentIncome);
                    break;
                case 0:
                    exit = true;
            }
            if (exit == true) {
                break;
            }

        }
    }

    public static void menu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void seats(int rows, int sits, String[][] str) {

        System.out.println("Cinema:");
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < sits + 1; j++) {
                if (i == 0 && j == 0) {
                    str[i][j] = " ";
                } else if (str[i][j] == "B") {
                    str[i][j] = "B";
                } else if (i == 0 && j != 0) {
                    str[i][j] = "" + j;
                } else if (i != 0 && j == 0) {
                    str[i][j] = "" + i;
                } else {
                    str[i][j] = "S";
                }
                System.out.print(str[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void price(int rows, int sits, int rowsInput) {
        if (rows * sits <= 60) {
            System.out.println("Ticket price: $10");

        } else if (rows * sits > 60 && rows % 2 == 0 && rowsInput >= rows / 2) {
            System.out.println("Ticket price: $8");

        } else if (rows * sits > 60 && rows % 2 != 0 && rowsInput >= rows / 2 + 1) {
            System.out.println("Ticket price: $8");

        } else {
            System.out.println("Ticket price: $10");

        }
    }


    public static void statistic(double rows, double sits, double ticketCount, int total, int currentIncome) {

        System.out.printf("Number of purchased tickets: %.0f %n", ticketCount);
        System.out.printf("Percentage: %.2f%% %n", (ticketCount / (rows * sits) * 100));
        System.out.println("Current income: $" + currentIncome);


        if (rows * sits <= 60) {
            System.out.println("Total income: $" + total);
        } else if (rows * sits > 60 && rows % 2 == 0) {
            System.out.println("Total income: $" + total);
        } else if (rows * sits > 60 && rows % 2 != 0) {
            System.out.println("Total income: $" + total);
        }

    }
}