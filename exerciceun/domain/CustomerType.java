package exerciceun.domain;

import exerciceun.services.pricing.BusinessPricing;
import exerciceun.services.pricing.PricingStrategy;
import exerciceun.services.pricing.StandardPricing;
import exerciceun.services.pricing.VIPPricing;

public enum CustomerType {
    STANDARD {
        @Override
        public PricingStrategy getPricingStrategy() {
            return new StandardPricing();
        }
    },
    BUSINESS {
        @Override
        public PricingStrategy getPricingStrategy() {
            return new BusinessPricing(new StandardPricing());
        }
    },
    VIP {
        @Override
        public PricingStrategy getPricingStrategy() {
            return new VIPPricing(new StandardPricing());
        }
    };

    public abstract PricingStrategy getPricingStrategy();
}


