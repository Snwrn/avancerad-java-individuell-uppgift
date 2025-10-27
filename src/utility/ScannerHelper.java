package utility;

import java.util.Scanner;

//Unified scanner was created to fix a problem that sometimes Back to menu function required enter twice

public class ScannerHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }
}