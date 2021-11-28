package model;

import java.util.List;
import java.util.Map;

public interface ProductDataSource {
    List<Product> getProducts();
    Map<Integer, Product> getProductMap();
}
