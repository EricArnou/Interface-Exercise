package ericarnou68.services;

import ericarnou68.entities.Contract;
import ericarnou68.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){
        double contractInstallmentWithoutInterest = contract.getTotalValue() / months;
        LocalDate dueDate = contract.getDate();

        for (int i = 1; i <= months; i++) {

            double interest = onlinePaymentService.interest(contractInstallmentWithoutInterest, i);
            double paymentFee = onlinePaymentService.paymentFee(contractInstallmentWithoutInterest + interest);

            Installment installment = new Installment(dueDate.plusMonths(i), contractInstallmentWithoutInterest + interest + paymentFee);

            contract.getInstallmentsList().add(installment);
        }
    }
}

