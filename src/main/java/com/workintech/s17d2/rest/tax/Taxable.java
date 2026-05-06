package com.workintech.s17d2.rest.tax;

public interface Taxable {
    double getSimpleRateTax();

    double getMiddleRateTax();

    double getUpperRateTax();
}
