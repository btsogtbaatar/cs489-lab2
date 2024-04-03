package edu.miu.cs489.lab2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.miu.cs489.lab2.model.Employee;
import edu.miu.cs489.lab2.model.PensionPlan;

public class PensionPlanApp {

        private static Stream<Employee> getStreamOfSortEmployees(Employee[] employees) {
                return Stream.of(employees)
                                .sorted(Comparator.comparing(Employee::getLastName)
                                                .thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()));
        }

        private static void printEmployees(String header, Stream<Employee> employees) {
                String body = employees
                                .map(Employee::toJsonString).collect(Collectors.joining(","));

                System.out.println(header);
                System.out.println(String.format("[%s%n]", body));
                System.out.println("------------------------------------------");
        }

        private static void printMonthlyUpcomingEnrollees(Stream<Employee> employees) {
                var upcomingEnrollees = employees.filter(employee -> employee.getPensionPlan() == null)
                                .filter(Employee::isQualifiedForPensionPlan);

                printEmployees("Monthly Upcoming Enrollment:", upcomingEnrollees);
        }

        public static void main(String[] args) {
                Employee[] employees = new Employee[] {
                                new Employee(1L, "Daniel", "Agar", LocalDate.of(2018, 1, 17),
                                                BigDecimal.valueOf(105945.50),
                                                new PensionPlan("EX1089", LocalDate.of(2023, 1, 17),
                                                                BigDecimal.valueOf(100.0))),
                                new Employee(2L, "Benard", "Shaw", LocalDate.of(2019, 4, 3),
                                                BigDecimal.valueOf(197750.00),
                                                null),
                                new Employee(3L, "Carly", "Agar", LocalDate.of(2014, 5, 16),
                                                BigDecimal.valueOf(842000.75),
                                                new PensionPlan("SM2307", LocalDate.of(2019, 11, 04),
                                                                BigDecimal.valueOf(1555.0))),
                                new Employee(4L, "Wesley", "Schneider", LocalDate.of(2019, 5, 2),
                                                BigDecimal.valueOf(74500),
                                                null)
                };

                printEmployees("Employee List:", getStreamOfSortEmployees(employees));
                printMonthlyUpcomingEnrollees(getStreamOfSortEmployees(employees));
        }
}