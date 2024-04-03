package edu.miu.cs489.lab2.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private BigDecimal monthlyContribution;

    public String toJsonString() {
        return String.format(
                "{\"planReferenceNumber\": \"%s\", \"enrollmentDate\": \"%s\", \"monthlyContribution\": \"%.2f\"}",
                planReferenceNumber, DateTimeFormatter.ISO_DATE.format(enrollmentDate), monthlyContribution);
    }
}
