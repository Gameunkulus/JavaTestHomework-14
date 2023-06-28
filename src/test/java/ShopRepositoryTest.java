import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    void remove() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Рубашка белая", 5000);
        Product product2 = new Product(2, "Рубашка синяя", 3500);
        Product product3 = new Product(3, "Рубашка розовая", 6000);
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        Assertions.assertTrue(repository.remove(1));
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(1);
        });
    }

    @Test
    void add() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Рубашка белая", 5000);
        Product product2 = new Product(2, "Рубашка синяя", 3500);
        Product product3 = new Product(3, "Рубашка розовая", 6000);
        Product product4 = new Product(1, "Рубашка tengo le comissa negra", 10000);
        repository.add(product1);
        repository.add(product2);
        Assertions.assertTrue(repository.add(product3));
        Assertions.assertThrows(AlreadyExistsException.class, ()->{
           repository.add(product4);
        });
    }
}