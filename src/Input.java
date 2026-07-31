import java.util.Scanner;

/* TODO
a more proper input detection system
*/

public class Input {
    private Scanner player_input = new Scanner(System.in);


    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(player_input.nextLine().trim()); // return a valid value only
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    public int readInt(int maximum) { // overloaded method to restrict max value
        while (true) {
            int selection = readInt();

            if (selection > 0 && selection <= maximum) { // selection can only be between 1 and max
                return selection;
            }
            else {
                System.out.printf("Invalid input! Please pick between 1 to %d only", maximum);
            }
        }
    }

    public String readString() {
        String input;
        while (true) {
            input = player_input.nextLine().trim(); // remove whitespaces if any
            if (!input.isEmpty()) { // no empty input
                input = input.substring(0, Math.min(input.length(), 20)); // truncates to only 20 chars
                return input;
            }
            System.out.println("Input cannot be empty! Please enter something!");

        }
    }

    public void promptEnter() {
        player_input.nextLine();
    }
}
