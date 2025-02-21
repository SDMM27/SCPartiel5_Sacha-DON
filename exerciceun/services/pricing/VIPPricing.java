package exerciceun.services.pricing;

import exerciceun.domain.Package;

public class VIPPricing implements PricingStrategy {
    private final PricingStrategy baseStrategy;

    public VIPPricing(PricingStrategy baseStrategy) {
        this.baseStrategy = baseStrategy;
    }

    @Override
    public double calculatePrice(Package pkg) {
        return baseStrategy.calculatePrice(pkg) * 0.8;
    }
}

