import java.util.Scanner;


public class Input {
    private Scanner playerInput = new Scanner(System.in);

    /*
    the main goal of this class is to accept and verify input safely
     */

    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(playerInput.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    public int readInt(int maximum) { // overloaded method to restrict max value
        while (true) {
            int selection = readInt();

            if (selection > 0 && selection <= maximum) {
                return selection;
            }
            else {
                System.out.printf("Invalid input! Please pick between 1 to %d only\n", maximum);
            }
        }
    }

    public String readString() {
        String input;
        while (true) {
            input = playerInput.nextLine().trim();
            if (!input.isEmpty()) {
                // this line compares what the user typed with 20
                // it will then pick whichever is shorter
                // it will then return each char from index 0 to math.min OR until index 19
                input = input.substring(0, Math.min(input.length(), 20));
                return input;
            }
            System.out.println("Input cannot be empty! Please enter something!");

        }
    }

    public void promptEnter() {
        playerInput.nextLine();
    } // press enter to continue
}
