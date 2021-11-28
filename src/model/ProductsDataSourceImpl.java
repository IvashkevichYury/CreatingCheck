package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductsDataSourceImpl implements ProductDataSource {
    private List<Product> products = new ArrayList<>();
    private Map<Integer, Product> productMap = new LinkedHashMap<>();

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public ProductsDataSourceImpl() {
        initDate();
    }

    private void initDate() {

        productMap.put(1, new Product("Bread", new BigDecimal(1.5), false));
        productMap.put(2, new Product("Milk", new BigDecimal(2.3), false));
        productMap.put(3, new Product("Pasta", new BigDecimal(3.5), true));
        productMap.put(4, new Product("Sausages", new BigDecimal(5.0), false));
        productMap.put(5, new Product("Apples", new BigDecimal(3.8), true));
        productMap.put(6, new Product("Oranges", new BigDecimal(4.1), false));
        productMap.put(7, new Product("Rice", new BigDecimal(4.3), false));
        productMap.put(8, new Product("Tea", new BigDecimal(3.8), true));
        productMap.put(9, new Product("Tomatoes", new BigDecimal(2.5), true));
        productMap.put(10, new Product("Potatoes", new BigDecimal(2.0), false));
    }
}
