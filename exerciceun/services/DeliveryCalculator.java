package exerciceun.services;

import exerciceun.services.pricing.PricingStrategy;
import exerciceun.domain.Package;

import java.util.List;

public class DeliveryCalculator {
    private final PricingStrategy pricingStrategy;

    public DeliveryCalculator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateTotalPrice(List<Package> packages) {
        double total = packages.stream().mapToDouble(pricingStrategy::calculatePrice).sum();

        if (packages.size() > 3) {
            total *= 0.95; // Réduction de 5% si plus de 3 colis
        }

        return total;
    }
}

