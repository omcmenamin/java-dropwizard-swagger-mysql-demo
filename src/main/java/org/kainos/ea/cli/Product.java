package org.kainos.ea.cli;

public class Product {

   private int productInt;
   private String name;
   private String description;
    private Double price;

    public Product(int productInt, String name, String description, Double price) {
        this.productInt = productInt;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int compareTo(Product product){
       return Double.compare(this.getPrice(), product.getPrice());
    }

    public String toString(){
        return "Product name: " +this.getName() + ", Product price: £" + this.getPrice();
    }

    public int getProductInt() {
        return productInt;
    }

    public void setProductInt(int productInt) {
        this.productInt = productInt;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
