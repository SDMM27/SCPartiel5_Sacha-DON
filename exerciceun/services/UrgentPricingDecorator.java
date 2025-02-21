package exerciceun.services;

import exerciceun.services.pricing.PricingStrategy;
import exerciceun.domain.Package;

public class UrgentPricingDecorator implements PricingStrategy {
    private final PricingStrategy baseStrategy;

    public UrgentPricingDecorator(PricingStrategy baseStrategy) {
        this.baseStrategy = baseStrategy;
    }

    @Override
    public double calculatePrice(Package pkg) {
        return baseStrategy.calculatePrice(pkg) * 1.5;
    }
}

