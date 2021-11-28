import model.ProductDataSource;
import model.ProductsDataSourceImpl;
import repository.CheckRepository;
import repository.CheckRepositoryImpl;
import repository.Price;
import repository.PriceImpl;

import java.util.*;
import java.util.regex.Pattern;


public class RunnerCreatingCheck {

    public static void main(String[] args) {
        Map<Integer, Integer> argsMap = new LinkedHashMap<>();
        String card = null;

        if (Pattern.matches("card([0-9]{4})", args[args.length - 1])) {
            card = args[args.length - 1];
            for (int i = 0; i < args.length - 1; i++) {
                String[] parts = args[i].split("-");
                argsMap.put(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
            }

        } else {
            for (int i = 0; i < args.length; i++) {
                String[] parts = args[i].split("-");
                argsMap.put(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
            }
        }

        ProductDataSource productDataSource = new ProductsDataSourceImpl();
        Price price = new PriceImpl();
        CheckRepository checkRepository = new CheckRepositoryImpl(productDataSource, price);

        checkRepository.printCheck(argsMap, card);

    }
}
