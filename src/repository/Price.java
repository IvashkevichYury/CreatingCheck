package repository;

import java.math.BigDecimal;

public interface Price {
    BigDecimal calculatingTotalCostProduct(BigDecimal price, int quantity);

    BigDecimal discountCalculationForPromotionalProduct();

    BigDecimal calculationOfTotalCostOfPromotionalProduct();

    BigDecimal discountCalculationForDiscountCard(BigDecimal priceAllProducts, String card);

}
