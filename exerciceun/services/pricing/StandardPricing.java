package exerciceun.services.pricing;

import exerciceun.domain.Package;

public class StandardPricing implements PricingStrategy {
    @Override
    public double calculatePrice(Package pkg) {
        double base = pkg.getDistance() * 0.1;
        if (pkg.getWeight() > 10) {
            base += 5;
        } else if (pkg.getWeight() > 5) {
            base += 3;
        }
        return base;
    }
}

