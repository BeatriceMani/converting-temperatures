import Exceptions.InvalidMenuChoiceException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConversionApplication {

    private static Scanner userKeyboardDevice = new Scanner(System.in);

    /**
     * Menu options
     */
    private static final String CELSIUS_TO_FAHRENHEIT = "Celsius to Fahrenheit";
    private static final String FAHRENHEIT_TO_CELSIUS = "Fahrenheit to Celsius";
    private static final String EXIT = "Exit Units Conversion Application";
    /**
     * Array of menu options to display to user
     */

    private static final String[] mainMenuOptions = {CELSIUS_TO_FAHRENHEIT,
                                                     FAHRENHEIT_TO_CELSIUS,
                                                     EXIT};

    /**
     * Constructor for this application
     */

    public ConversionApplication() {

    }

    /**
     * Application controller
     */
    public void run() {
        startOfApplication();
        String userChoice = new String("");
        boolean shouldLoop = true;

        while (shouldLoop) {
            try {
                userChoice = displayMenuAndGetChoice();
                System.out.println("You chose: " + userChoice);

                switch(userChoice) {
                    case CELSIUS_TO_FAHRENHEIT: {
                        findCelsiusToFahrenheit();
                        break;
                    }
                    case FAHRENHEIT_TO_CELSIUS: {
                        findFahrenheitToCelsius();
                        break;
                    }
                    case EXIT: {
                        shouldLoop = false;
                        break;
                    }
                    default: {
                        throw new InvalidMenuChoiceException("Invalid menu choice");
                    }
                }
            } catch (InvalidMenuChoiceException exception) {
                System.out.println("\n Invalid menu choice, please try again.");
            }

        }
        endOfApplication();
    } // end of run()


    /**
     * Helper methods
     */

    public void startOfApplication() {
        System.out.println("Welcome to the Unit Conversion App!");
    }

    public String displayMenuAndGetChoice() {
        int choice = -1;

        System.out.println("What would you like to convert?");

        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println(i + 1 + ". " + mainMenuOptions[i]);
        }

        System.out.println("\n Enter choice:");

        try {
            choice = Integer.parseInt(userKeyboardDevice.nextLine());
            return mainMenuOptions[choice -1];
        } catch (NumberFormatException exception) {
            throw new InvalidMenuChoiceException("Invalid menu option " + choice + "entered.");
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new InvalidMenuChoiceException("Invalid menu option " + choice + "entered");
        }
    }

    public void endOfApplication() {
        System.out.println("Thank you for using my app!");
    }

    /**
     * Menu option methods
     */

    public void findCelsiusToFahrenheit() {
        String celsiusInput = "";
        String yesOrNo = "";

        System.out.println("\n Please enter the integer temperature in Celsius you would like to convert to Fahrenheit:");
        celsiusInput = userKeyboardDevice.nextLine();

        try {
            Integer.parseInt(celsiusInput);
        } catch (NumberFormatException exception) {
            System.out.println("\n Invalid input, please try again.");
            findCelsiusToFahrenheit();
        }

        int equivalentDegreesF = (Integer.parseInt(celsiusInput) * 9) / 5 + 32;

        System.out.println(celsiusInput + " degrees C is equivalent to " + equivalentDegreesF + " degrees F");
        System.out.println("Would you like to make another conversion? (y/n)");
        yesOrNo = userKeyboardDevice.nextLine();

        if (yesOrNo.toLowerCase().startsWith("y")) {
            findCelsiusToFahrenheit();
        }

    }

    public void findFahrenheitToCelsius() {
        String fahrenheitInput = "";
        String yesOrNo = "";

        System.out.println("\n Please enter the integer temperature in Fahrenheit you would like to convert to Celsius:");
        fahrenheitInput = userKeyboardDevice.nextLine();

        try {
            Integer.parseInt(fahrenheitInput);
        } catch (NumberFormatException excepetion) {
            System.out.println("\n Invalid input, please try again.");
            findFahrenheitToCelsius();
        }

        int equivalentDegreesC = (Integer.parseInt(fahrenheitInput) - 32) * 5 / 9 ;

        System.out.println(fahrenheitInput +" degrees F is equivalent to " + equivalentDegreesC + " degrees C");
        System.out.println("Would you like to make another conversion? (y/n)");
        yesOrNo = userKeyboardDevice.nextLine();

        if (yesOrNo.toLowerCase().startsWith("y")) {
            findFahrenheitToCelsius();
        }

    }




}
