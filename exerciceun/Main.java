package exerciceun;

import exerciceun.services.DeliveryCalculator;
import exerciceun.services.InvoiceService;
import exerciceun.services.UrgentPricingDecorator;
import exerciceun.services.pricing.PricingStrategy;
import exerciceun.services.pricing.StandardPricing;
import exerciceun.services.pricing.VIPPricing;
import exerciceun.domain.Package;
import exerciceun.domain.CustomerType;

import java.util.Arrays;
import java.util.List;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Package> packages = Arrays.asList(
                new Package(6, 50),
                new Package(12, 100),
                new Package(8, 70),
                new Package(2, 30)
        );

        CustomerType customerType = CustomerType.VIP;

        PricingStrategy pricingStrategy = customerType.getPricingStrategy();

        boolean isUrgent = true;
        if (isUrgent) {
            pricingStrategy = new UrgentPricingDecorator(pricingStrategy);
        }

        DeliveryCalculator calculator = new DeliveryCalculator(pricingStrategy);
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.printInvoice(packages, calculator);
    }
}


