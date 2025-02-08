package com.example.bysell.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "bysell", name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;

    @Column(name = "photo")
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;


    public Image(Long id, String name, String originalFileName, Long size, String contentType, boolean isPreviewImage, byte[] bytes, Product product) {
        this.id = id;
        this.name = name;
        this.originalFileName = originalFileName;
        this.size = size;
        this.contentType = contentType;
        this.isPreviewImage = isPreviewImage;
        this.bytes = bytes;
        this.product = product;
    }

    public Image() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getOriginalFileName() {
        return this.originalFileName;
    }

    public Long getSize() {
        return this.size;
    }

    public String getContentType() {
        return this.contentType;
    }

    public boolean isPreviewImage() {
        return this.isPreviewImage;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setPreviewImage(boolean isPreviewImage) {
        this.isPreviewImage = isPreviewImage;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Image)) return false;
        final Image other = (Image) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$originalFileName = this.getOriginalFileName();
        final Object other$originalFileName = other.getOriginalFileName();
        if (this$originalFileName == null ? other$originalFileName != null : !this$originalFileName.equals(other$originalFileName))
            return false;
        final Object this$size = this.getSize();
        final Object other$size = other.getSize();
        if (this$size == null ? other$size != null : !this$size.equals(other$size)) return false;
        final Object this$contentType = this.getContentType();
        final Object other$contentType = other.getContentType();
        if (this$contentType == null ? other$contentType != null : !this$contentType.equals(other$contentType))
            return false;
        if (this.isPreviewImage() != other.isPreviewImage()) return false;
        if (!java.util.Arrays.equals(this.getBytes(), other.getBytes())) return false;
        final Object this$product = this.getProduct();
        final Object other$product = other.getProduct();
        if (this$product == null ? other$product != null : !this$product.equals(other$product)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Image;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $originalFileName = this.getOriginalFileName();
        result = result * PRIME + ($originalFileName == null ? 43 : $originalFileName.hashCode());
        final Object $size = this.getSize();
        result = result * PRIME + ($size == null ? 43 : $size.hashCode());
        final Object $contentType = this.getContentType();
        result = result * PRIME + ($contentType == null ? 43 : $contentType.hashCode());
        result = result * PRIME + (this.isPreviewImage() ? 79 : 97);
        result = result * PRIME + java.util.Arrays.hashCode(this.getBytes());
        final Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        return result;
    }

    public String toString() {
        return "Image(id=" + this.getId() + ", name=" + this.getName() + ", originalFileName=" + this.getOriginalFileName() + ", size=" + this.getSize() + ", contentType=" + this.getContentType() + ", isPreviewImage=" + this.isPreviewImage() + ", bytes=" + java.util.Arrays.toString(this.getBytes()) + ", product=" + this.getProduct() + ")";
    }
}
