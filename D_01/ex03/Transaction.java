package Ex03;

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

    Transaction(User _Recipient, User _Sender, int _TransferAmount) {

        Recipient = _Recipient;
        Sender = _Sender;
        TransferAmount = _TransferAmount;
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
//        countTrans++;
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

    public User getRecipient() {
        return Recipient;
    }

    public void setRecipient(User recipient) {
        Recipient = recipient;
    }

    public User getSender() {
        return Sender;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public TransferCategory getTransfercategory() {
        return transfercategory;
    }

    public void setTransfercategory(TransferCategory transfercategory) {
        this.transfercategory = transfercategory;
    }

    public int getTransferAmount() {
        return TransferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        TransferAmount = transferAmount;
    }

    public String getIdentifier() {
        return (Identifier);
    }
}
