package com.example.bysell.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "bysell", name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String title;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreated;

    public void addImageToProduct(Image image) {
        image.setProduct(this);
        this.images.add(image);
    }

    public Product(Long id, String title, String description, String city, String author, int price, List<Image> images, Long previewImageId, LocalDateTime dateOfCreated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.city = city;
        this.author = author;
        this.price = price;
        this.images = images;
        this.previewImageId = previewImageId;
        this.dateOfCreated = dateOfCreated;
    }

    @PrePersist
    private void init() {
        this.dateOfCreated = LocalDateTime.now();
    }

    public Product(Long id, String title, String description, String city, String author, int price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.city = city;
        this.author = author;
        this.price = price;
    }

    public Product() {
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        final Product other = (Product) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$author = this.getAuthor();
        final Object other$author = other.getAuthor();
        if (this$author == null ? other$author != null : !this$author.equals(other$author)) return false;
        if (this.getPrice() != other.getPrice()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Product;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $author = this.getAuthor();
        result = result * PRIME + ($author == null ? 43 : $author.hashCode());
        result = result * PRIME + this.getPrice();
        return result;
    }

    public String toString() {
        return "Products(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", city=" + this.getCity() + ", author=" + this.getAuthor() + ", price=" + this.getPrice() + ")";
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCity() {
        return this.city;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPrice() {
        return this.price;
    }

    public List<Image> getImages() {
        return this.images;
    }

    public Long getPreviewImageId() {
        return this.previewImageId;
    }

    public LocalDateTime getDateOfCreated() {
        return this.dateOfCreated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setPreviewImageId(Long previewImageId) {
        this.previewImageId = previewImageId;
    }

    public void setDateOfCreated(LocalDateTime dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }
}
