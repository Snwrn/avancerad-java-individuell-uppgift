package command;

import models.FilterChoice;
import models.Transaction;
import service.TransactionService;
import utility.FilterHelper;
import java.time.LocalDate;
import java.util.Scanner;

public class FilterTransactions extends Command {
    public FilterTransactions() {
        super("Filter transactions", "Filter transactions and see balance by year, month week or day.");
    }

    @Override
    public void execute() {

            Scanner scanner = utility.ScannerHelper.getScanner();

            //Choose type (deposit or withdrawal)
            System.out.println("Choose transaction type:");
            System.out.println("1. Deposits");
            System.out.println("2. Withdrawals");
            int filterTypeChoice = scanner.nextInt();
            scanner.nextLine();

            // Show available filters
            for (FilterChoice choice : FilterChoice.values()) {
                System.out.println(choice);
            }

            // User chooses filter
            System.out.print("Enter the number of the filter you want to use: ");
            int usersChoice = scanner.nextInt();
            scanner.nextLine();

            //to count total
            double total = 0;

            // By year
            if (usersChoice == FilterChoice.BY_YEAR.getID()) {
                int year = FilterHelper.getYearFromUserInput();
                for (Transaction t : service.TransactionService.transactions) {
                    if (t.getDate().getYear() == year) {
                        total = FilterHelper.processTransaction(t, filterTypeChoice, total);
                    }
                }
            }

            // By month
            else if (usersChoice == FilterChoice.BY_MONTH.getID()) {
                int year = FilterHelper.getYearFromUserInput();
                int month = FilterHelper.getMonthFromUserInput();
                for (Transaction t : TransactionService.transactions) {
                    if (t.getDate().getYear() == year && t.getDate().getMonthValue() == month) {
                        total = FilterHelper.processTransaction(t, filterTypeChoice, total);
                    }
                }
            }

            // By day
            else if (usersChoice == FilterChoice.BY_DAY.getID()) {
                LocalDate day = FilterHelper.getDayFromUserInput();
                for (Transaction t : TransactionService.transactions) {
                    if (t.getDate().equals(day)) {
                        total = FilterHelper.processTransaction(t, filterTypeChoice, total);
                    }
                }
            }

            // By week
            else if (usersChoice == FilterChoice.BY_WEEK.getID()) {
                int year = FilterHelper.getYearFromUserInput();
                int week = FilterHelper.getWeekNumberFromUserInput();
                for (Transaction t : TransactionService.transactions) {
                    int transactionWeek = FilterHelper.getWeekOfYear(t.getDate());
                    if (t.getDate().getYear() == year && transactionWeek == week) {
                        total = FilterHelper.processTransaction(t, filterTypeChoice, total);
                    }
                }
            }

            // Print total
            FilterHelper.printTotal(total, filterTypeChoice);
        backToMenu();
        }
    }


