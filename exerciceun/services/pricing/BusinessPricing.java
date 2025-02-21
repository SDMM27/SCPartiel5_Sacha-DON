package exerciceun.services.pricing;

import exerciceun.domain.Package;
public class BusinessPricing implements PricingStrategy {
    private final PricingStrategy baseStrategy;

    public BusinessPricing(PricingStrategy baseStrategy) {
        this.baseStrategy = baseStrategy;
    }

    @Override
    public double calculatePrice(Package pkg) {
        return baseStrategy.calculatePrice(pkg) * 0.9;
    }
}

