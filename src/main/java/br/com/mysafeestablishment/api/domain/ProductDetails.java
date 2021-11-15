package br.com.mysafeestablishment.api.domain;

public class ProductDetails extends AbstractEntity {

    private String imgurId;
    private String imgurDeleteId;
    private String urlImage;

    public String getImgurId() {
        return imgurId;
    }

    public void setImgurId(String imgurId) {
        this.imgurId = imgurId;
    }

    public String getImgurDeleteId() {
        return imgurDeleteId;
    }

    public void setImgurDeleteId(String imgurDeleteId) {
        this.imgurDeleteId = imgurDeleteId;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public ProductDetails() {
    }

    public ProductDetails(String imgurId, String imgurDeleteId, String urlImage) {
        this.imgurId = imgurId;
        this.imgurDeleteId = imgurDeleteId;
        this.urlImage = urlImage;
    }
}
