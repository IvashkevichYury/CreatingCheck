package repository;

import java.math.BigDecimal;

public class PriceImpl implements Price {

    BigDecimal totalPrice = new BigDecimal(0);
    BigDecimal discount;
    BigDecimal totalPriceWithDiscount;
    BigDecimal amountOfDiscount = new BigDecimal(0);

    @Override
    public BigDecimal calculatingTotalCostProduct(BigDecimal priceOfProduct, int quantity) {

        totalPrice = new BigDecimal(quantity).multiply(priceOfProduct);

        return totalPrice;
    }

    @Override
    public BigDecimal discountCalculationForPromotionalProduct() {
        discount = totalPrice.multiply(new BigDecimal(0.1));
        return discount;
    }

    @Override
    public BigDecimal calculationOfTotalCostOfPromotionalProduct() {
        totalPriceWithDiscount = totalPrice.multiply(new BigDecimal(0.9));
        return totalPriceWithDiscount;
    }

    @Override
    public BigDecimal discountCalculationForDiscountCard(BigDecimal priceAllProducts, String card) {
        if (card != null) {
            amountOfDiscount = priceAllProducts.multiply(new BigDecimal(0.05));
        }
        return amountOfDiscount;
    }
}
