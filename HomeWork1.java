package HW_1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Calculator {
    public double calculateDiscount(double totalAmount, double discountPercentage) {
        if (totalAmount < 0 || discountPercentage < 0 || discountPercentage > 100) {
            throw new ArithmeticException("Invalid input values");
        }
        double discountAmount = (totalAmount * discountPercentage) / 100;
        return totalAmount - discountAmount;
    }
}

public class CalculatorTest {
    @Test
    public void testCalculateDiscount() {
        Calculator calculator = new Calculator();

        // Valid input values
        Assertions.assertThat(calculator.calculateDiscount(100.0, 10.0))
            .isEqualTo(90.0);

        // Check if it rounds correctly
        Assertions.assertThat(calculator.calculateDiscount(101.0, 10.0))
            .isEqualTo(90.90);

        // Check if discount is 0%
        Assertions.assertThat(calculator.calculateDiscount(100.0, 0.0))
            .isEqualTo(100.0);

        // Check if discount is 100%
        Assertions.assertThat(calculator.calculateDiscount(100.0, 100.0))
            .isEqualTo(0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculateDiscountInvalidInput() {
        Calculator calculator = new Calculator();

        // Negative total amount
        calculator.calculateDiscount(-100.0, 10.0);

        // Negative discount percentage
        calculator.calculateDiscount(100.0, -10.0);

        // Discount percentage > 100
        calculator.calculateDiscount(100.0, 110.0);
    }

    public class Product {

        public double getPrice() {
            return 0;
        }
    
    }

    public class Shop {
        private List<Product> products = new ArrayList<>();
    
        public void addProduct(Product product) {
            products.add(product);
        }
    
        public List<Product> getProducts() {
            return products;
        }
    
        public void sortProductsByPrice() {
            Collections.sort(products, (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        }
    
        public Product getMostExpensiveProduct() {
            if (products.isEmpty()) {
                return null;
            }
            return Collections.max(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        }
    }
    
    public class ShopTest {
        @Test
        public void testSortProductsByPrice() {
            Shop shop = new Shop();
            shop.addProduct(new Product("Product A", 50.0));
            shop.addProduct(new Product("Product B", 30.0));
            shop.addProduct(new Product("Product C", 70.0));
    
            shop.sortProductsByPrice();
    
            List<Product> sortedProducts = shop.getProducts();
            Assertions.assertThat(sortedProducts)
                .containsExactly(
                    new Product("Product C", 70.0),
                    new Product("Product A", 50.0),
                    new Product("Product B", 30.0)
                );
        }
    
        @Test
        public void testGetMostExpensiveProduct() {
            Shop shop = new Shop();
            shop.addProduct(new Product("Product A", 50.0));
            shop.addProduct(new Product("Product B", 30.0));
            shop.addProduct(new Product("Product C", 70.0));
    
            Product mostExpensiveProduct = shop.getMostExpensiveProduct();
            Assertions.assertThat(mostExpensiveProduct)
                .isEqualTo(new Product("Product C", 70.0));
        }
    
        @Test
        public void testGetMostExpensiveProductEmptyShop() {
            Shop shop = new Shop();
            Product mostExpensiveProduct = shop.getMostExpensiveProduct();
            Assertions.assertThat(mostExpensiveProduct)
                .isNull();
        }
    }


}