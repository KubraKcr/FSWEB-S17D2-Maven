package com.workintech.s17d2;

import com.workintech.s17d2.rest.tax.Taxable;
import org.springframework.stereotype.Component;

@Component
public class DeveloperTax implements Taxable {

    @Override
    public double getSimpleRateTax() {
        return 15d;
    }

    @Override
    public double getMiddleRateTax() {
        return 25d;
    }

    @Override
    public double getUpperRateTax() {
        return 35d;
    }
}