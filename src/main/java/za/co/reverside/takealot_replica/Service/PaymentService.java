package za.co.reverside.takealot_replica.Service;

import za.co.reverside.takealot_replica.Model.CreditCardForm;

import javax.servlet.http.HttpServletRequest;

public interface PaymentService {
    public void payByCreditCard(CreditCardForm creditCardForm);

    public CreditCardForm gatherCardDetails(CreditCardForm creditCardForm,
                                            HttpServletRequest request);
}