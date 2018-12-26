package windstudy.com.androidgopro.DetalProduct;


import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;


public class Detal {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("product_id")
    @Expose
    public Integer productId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("remain")
    @Expose
    public Integer remain;
    @SerializedName("images")
    @Expose
    public String images;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("price")
    @Expose
    public Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}