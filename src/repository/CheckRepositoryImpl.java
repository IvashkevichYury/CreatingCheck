package repository;

import model.Product;
import model.ProductDataSource;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CheckRepositoryImpl implements CheckRepository {

    private final ProductDataSource productDataSource;
    private final Price price;
    int checkNumber = 1;

    public CheckRepositoryImpl(ProductDataSource productDataSource, Price price) {
        this.productDataSource = productDataSource;
        this.price = price;
    }

    @Override
    public void printCheck(Map<Integer, Integer> map, String card) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("check.txt");

            Date dateNow = new Date();
            SimpleDateFormat formatDateNow = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatTimeNow = new SimpleDateFormat("hh:mm:ss");
            BigDecimal totalPriceAllProducts = new BigDecimal(0);
            BigDecimal amountOfDiscount = new BigDecimal(0);

            writer.println("              CASH RECEIPT \n" +
                    "            SUPERMARKET 000\n" +
                    "          23, Nemiga str, Minsk\n" +
                    "CASHIER: " + checkNumber + "                    DATE: " + formatDateNow.format(dateNow) + "\n" +
                    "                              TIME: " + formatTimeNow.format(dateNow) + "\n" +
                    "________________________________________________\n" +
                    "QTY     DESCRIPTION       PRICE        TOTAL\n"
            );

            for (Map.Entry<Integer, Integer> pr : map.entrySet()) {
                Integer number = pr.getValue();
                Product product = null;
                for (Map.Entry<Integer, Product> productEntry : productDataSource.getProductMap().entrySet()) {
                    if (pr.getKey().equals(productEntry.getKey())) {
                        product = productEntry.getValue();
                    }
                }

                try {
                    BigDecimal totalPrice = price.calculatingTotalCostProduct(product.getPriceOfProduct(), number);

                    BigDecimal discount = price.discountCalculationForPromotionalProduct();

                    BigDecimal totalPriceWithDiscount = (product.isPromotional() && number > 5)
                            ? price.calculationOfTotalCostOfPromotionalProduct()
                            : totalPrice;

                    totalPriceAllProducts = totalPriceAllProducts.add(totalPriceWithDiscount);

                    amountOfDiscount = price.discountCalculationForDiscountCard(totalPriceAllProducts, card);

                    writer.printf("%-7d %-17s %.2f %-7s %.2f\n",
                            number, product.getNameProduct(), product.getPriceOfProduct(), " ", totalPrice);
                    if (product.isPromotional() && number > 5) {
                        writer.printf("discount 10%% %-25s -%.2f\n", " ", discount);
                    }
                } catch (NullPointerException e) {
                    writer.println("No product with ID=" + pr.getKey());
                }
            }

            writer.println("________________________________________________\n");
            writer.printf("TAXABLE TOT. %-25s %.2f\n", " ", totalPriceAllProducts);
            writer.printf("VAT%d%% %-33s %.2f\n", 5, " ", amountOfDiscount);
            writer.printf("TOTAL %-32s %.2f", " ", totalPriceAllProducts.subtract(amountOfDiscount));

            checkNumber++;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

    }
}

