package za.co.reverside.takealot_replica.Repository;

import za.co.reverside.takealot_replica.Model.CreditCardForm;

public interface PaymentRepository {
    void payByCreditCard(CreditCardForm creditCardForm);
}