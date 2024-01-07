package ericarnou68.application;

import ericarnou68.entities.Contract;
import ericarnou68.services.ContractService;
import ericarnou68.services.OnlinePaymentService;
import ericarnou68.services.PayPalPaymentService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        OnlinePaymentService paypalService = new PayPalPaymentService();

        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        int contractNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Date: ");
        LocalDate contractDate = LocalDate.parse(scanner.next(), fmt);
        System.out.print("Total value: ");
        double contractValue= scanner.nextDouble();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);

        System.out.print("\nEnter number of installments: ");
        int contractInstallments = scanner.nextInt();

        ContractService contractService = new ContractService(paypalService);

        contractService.processContract(contract, contractInstallments);
        System.out.println(contract);
    }
}