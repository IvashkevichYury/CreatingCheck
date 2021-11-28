package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private String nameProduct;
    private BigDecimal priceOfProduct;
    private boolean isPromotional;

    public Product(String nameProduct, BigDecimal priceOfProduct, boolean isPromotional) {

        this.nameProduct = nameProduct;
        this.priceOfProduct = priceOfProduct;
        this.isPromotional = isPromotional;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public BigDecimal getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(BigDecimal priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public boolean isPromotional() {
        return isPromotional;
    }

    public void setPromotional(boolean promotional) {
        isPromotional = promotional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return isPromotional == product.isPromotional && Objects.equals(nameProduct, product.nameProduct) && Objects.equals(priceOfProduct, product.priceOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, priceOfProduct, isPromotional);
    }

}
