package com.capgemini.bootcamp.java.excerciseone.domain.object;

import com.capgemini.bootcamp.java.excerciseone.util.MessageProduct;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class ProductObject {

    private long id;

    @NotBlank(message = MessageProduct.nameNotBlank)
    @Size(min = 2, message = MessageProduct.nameSize)
    private String name;

    @NotBlank(message = MessageProduct.descriptionNotBlank)
    @Size(min = 10, message = MessageProduct.descriptionSize)
    private String description;

    @NotBlank(message = MessageProduct.priceNotBlank)
    @DecimalMin(value = "0.01", message = MessageProduct.priceMin)
    private double price;

    @NotBlank(message = MessageProduct.imageNonBlank)
    private String image;

    public ProductObject(){}

    public ProductObject(long id, String name, String description, double price, String image) {
        this();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
