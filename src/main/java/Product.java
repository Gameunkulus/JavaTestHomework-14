import java.util.Objects;

public class Product {


    protected int id;
    protected String title;
    protected int price;

    protected int getId() {
        return id;
    }

    protected String getTitle() {
        return title;
    }

    protected int getPrice() {
        return price;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId() && getPrice() == product.getPrice() && getTitle().equals(product.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPrice());
    }

}
