package com.booleanuk.core;

import java.util.Map;

public interface IInventory {
    Boolean hasProduct(String productSku);
    Map<String, Product> getInventory();
}
