package com.sella.api.enumeration;

public enum Currency {
    EUR("EUR"),
    USD("USD"),
    GBP("GBP"),
    CNY("CNY"),
    RUB("RUB");

    private String value;

    Currency(String value) {
        this.value = value;
    }
}
