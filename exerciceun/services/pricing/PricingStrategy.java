package exerciceun.services.pricing;

import exerciceun.domain.Package;

public interface PricingStrategy {
    double calculatePrice(Package pkg);
}
