package models;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    public double amount;
    public LocalDate transactionDate;
    public Boolean isDeposit;

    public Transaction(double amount, LocalDate transactionDate, Boolean isDeposit) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isDeposit = isDeposit;
    }

    public double getAmount() {
        return amount;
    }

    public String getFormattedAmount() {
        return utility.DoubleFormatHelper.formatDouble(amount);
    }

    public LocalDate getDate() {
        return transactionDate;
    }

    public Boolean getIsDeposit() {
        return isDeposit;
    }
}
