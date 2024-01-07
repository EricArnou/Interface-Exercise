package ericarnou68.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    Integer contractNumber;
    LocalDate date;
    Double totalValue;
    List <Installment> installmentsList = new ArrayList<>();

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Contract(Integer contractNumber, LocalDate date, Double totalValue) {
        this.contractNumber = contractNumber;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallmentsList() {
        return installmentsList;
    }

    @Override
    public String toString(){

        System.out.println("\nCONTRACT SUMMARY");
        System.out.print("Number: " + getContractNumber() + " - Total Value: " + getTotalValue() + "\n");
        System.out.println("Installments");
        String resume = "";
        for (Installment e: installmentsList ){
            resume += e.getDueDate().format(fmt) + " - " + e.getAmount() + "\n";
        }
        return resume;
    }
}
