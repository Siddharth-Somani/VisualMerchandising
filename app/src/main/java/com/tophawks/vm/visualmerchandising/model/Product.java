package com.tophawks.vm.visualmerchandising.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Tofiq Quadri on 14-03-2017.
 */

public class Product implements Serializable{

    private String itemId;
    private String productName, productColor, productSpecification, imageUrl;
    private float wholeSalePrice, retailPrice, originalPrice, discountPrice;
    private int productQuantity;

    public Product() {
    }

    public Product(String itemId, String productName, String productColor, String productSpecification, String imageUrl, float wholeSalePrice, float retailPrice, float originalPrice, float discountPrice, int productQuantity) {
        this.itemId = itemId;
        this.productName = productName;
        this.productColor = productColor;
        this.productSpecification = productSpecification;
        this.imageUrl = imageUrl;
        this.wholeSalePrice = wholeSalePrice;
        this.retailPrice = retailPrice;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.productQuantity = productQuantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getWholeSalePrice() {
        return wholeSalePrice;
    }

    public void setWholeSalePrice(float wholeSalePrice) {
        this.wholeSalePrice = wholeSalePrice;
    }

    public float getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(float retailPrice) {
        this.retailPrice = retailPrice;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }


}
