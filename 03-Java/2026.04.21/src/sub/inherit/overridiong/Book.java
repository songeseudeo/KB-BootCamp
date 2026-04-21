package sub.inherit.overridiong;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book(String author, int price, String title) {
        this.author = author;
        this.price = price;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;
        if(!(obj instanceof Book other)){
            return false;
        }
        return this.title.equals(other.title)
                && this.author.equals(other.author)
                && this.price == other.price;
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, price);
    }
}
