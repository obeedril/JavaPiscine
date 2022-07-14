package ex00;

import java.util.UUID;

enum TransferCategory {
    DEBIT,
    CREDIT
}

public class Transaction {
    String Identifier;
    private User Recipient;
    private User Sender;
    private TransferCategory transfercategory;
    private int TransferAmount;

    Transaction(User Recipient, User Sender, int TransferAmount) {
        this.Recipient = Recipient;
        this.Sender = Sender;
        this.TransferAmount = TransferAmount;
        if (TransferAmount < 0) {
            transfercategory = TransferCategory.CREDIT;
        }
        else if (TransferAmount > 0) {
            transfercategory = TransferCategory.DEBIT;
        }  else {
            System.out.println("The transfer amount is not specified");
            return ;
        }
        UUID uuid = UUID.randomUUID();
        Identifier = uuid.toString();
        if (transfercategory == TransferCategory.CREDIT) {
            if (Recipient.getBalance() < TransferAmount) {
                System.out.println("The transaction "+Identifier+ " is not possible There are not enough funds in the account");
            } else {
                Recipient.setBalance(Recipient.getBalance() - TransferAmount*(-1));
                Sender.setBalance(Sender.getBalance()+TransferAmount*(-1));
            }
        }
        if (transfercategory == TransferCategory.DEBIT) {
            if (Sender.getBalance() < TransferAmount) {
                System.out.println("The transaction " + Identifier + "is not possible There are not enough funds in the account");
            } else {
                Sender.setBalance(Sender.getBalance()-TransferAmount);
                Recipient.setBalance(Recipient.getBalance()+TransferAmount);
            }
        }
    }
    public String getIdentifier() {
        return (Identifier);
    }
}
