package edu.miu.cs489.lab2.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private BigDecimal yearlySalary;
    private PensionPlan pensionPlan;

    public String toJsonString() {
        return String.format(
                "%n\t{\"employeeId\": %d, \"firstName\": \"%s\", \"lastName\": \"%s\", \"employmentDate\": \"%s\", \"yearlySalary\": %.2f, \"pensionPlan\": %s}",
                employeeId, firstName, lastName, DateTimeFormatter.ISO_DATE.format(employmentDate), yearlySalary,
                pensionPlan != null ? pensionPlan.toJsonString() : "null");
    }
}
