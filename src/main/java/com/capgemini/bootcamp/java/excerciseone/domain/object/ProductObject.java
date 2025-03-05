package com.capgemini.bootcamp.java.excerciseone.domain.object;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ProductObject {

    @NotNull
    @Min(0)
    private long id;

    @NotNull(message = "The name is needed")
    @Min(value = 2, message = "The name should be at least of two characters")
    private String name;

    @NotNull(message = "The description is needed")
    @Min(value=10, message = "The description should be at least of teen characters")
    private String description;

    @NotNull(message = "The price is needed")
    @DecimalMin(value = "0.01", message = "The price should be at least 0.01")
    private double price;

    @NotNull(message = "The image is needed")
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
