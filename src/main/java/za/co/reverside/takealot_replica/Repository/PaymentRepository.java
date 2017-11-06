package za.co.reverside.takealot_replica.Repository;

import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.CreditCardForm;

@Repository
public interface PaymentRepository {
    void payByCreditCard(CreditCardForm creditCardForm);
}