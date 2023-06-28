public class ShopRepository {
    private Product[] products = new Product[0];

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            if (current[i].getId() != product.getId()) {
                tmp[i] = current[i];
            } else {
                int id = product.getId();
                throw new AlreadyExistsException("Element with id: " + id + " already exist");
            }
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public boolean add(Product product) {
        products = addToArray(products, product);
        return true;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int ID) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == ID) {
                return products[i];
            }
        }
        return null;
    }

    public boolean remove(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        else {
            products = tmp;
            return true;
        }
    }

}
