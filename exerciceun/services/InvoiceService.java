package exerciceun.services;

import java.text.DecimalFormat;
import java.util.List;

import exerciceun.domain.Package;

public class InvoiceService {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void printInvoice(List<Package> packages, DeliveryCalculator calculator) {
        double price = calculator.calculateTotalPrice(packages);
        System.out.println("💰 Total: " + df.format(price) + " €");

        if (price > 100) {
            System.out.println("🎁 Apply special discount next time!");
        }
    }
}

