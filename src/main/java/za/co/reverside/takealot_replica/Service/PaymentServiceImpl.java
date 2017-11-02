package za.co.reverside.takealot_replica.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.reverside.takealot_replica.Model.CreditCardForm;
import za.co.reverside.takealot_replica.Model.Customer;
import za.co.reverside.takealot_replica.Repository.PaymentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    private HttpSession session;

    @Override
    public void payByCreditCard(CreditCardForm creditCardForm) {
        paymentRepository.payByCreditCard(creditCardForm);
    }

    @Override
    public CreditCardForm gatherCardDetails(CreditCardForm creditCardForm,
                                            HttpServletRequest request) {
        session = request.getSession();
        Long customerId = ((Customer) session.getAttribute("customer"))
                .getCustomerId();
        String creditCardNumber = request.getParameter("creditCardNumber");
        Integer month = Integer.parseInt(request.getParameter("month"));
        Integer year = Integer.parseInt(request.getParameter("year"));
        String name = request.getParameter("name");
        String cvvCode = request.getParameter("cvvCode");

        creditCardForm.setCustomerId(customerId);
        creditCardForm.setCreditCardNumber(creditCardNumber);
        creditCardForm.setMonth(month);
        creditCardForm.setYear(year);
        creditCardForm.setCvvCode(cvvCode);
        creditCardForm.setName(name);

        return creditCardForm;

    }

}