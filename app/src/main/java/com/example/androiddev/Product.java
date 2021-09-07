package com.example.androiddev;

import java.util.Comparator;

public class Product {
    private String Product;
    private String SerialNumber;
    private String Block;
    private String Fullname;

    public Product() {}

    public Product(String Product, String SerialNumber, String Block, String Fullname) {
        this.Product = Product;
        this.SerialNumber = SerialNumber;
        this.Block = Block;
        this.Fullname = Fullname;
    }

    public String getProduct() {
        return Product;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public String getBlock() {
        return Block;
    }

    public String getFullname() {
        return Fullname;
    }
}
