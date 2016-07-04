package synapsehub.cd.notifhub.model;

import java.io.Serializable;

/**
 * Created by michelo on 7/2/16.
 */

public class Annonce implements Serializable {

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String id;
    private String title;
    private String desc;
    private String adresse;
    private String price;

    public Annonce(){}

    public Annonce(String id, String title, String desc, String adresse, String price){
        this.id=id;
        this.title=title;
        this.desc=desc;
        this.adresse=adresse;
        this.price=price;
    }





    @Override
    public String toString() {
        return "Annonce{" +
                "id ='" + id + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", adresse='" + adresse + '\'' +
                ", price=" + price +
                '}';
    }

}
