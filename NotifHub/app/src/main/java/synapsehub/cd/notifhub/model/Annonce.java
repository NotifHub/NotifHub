package synapsehub.cd.notifhub.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.parceler.Parcel;

import static android.R.attr.rating;

/**
 * Created by michelo on 7/2/16.
 */


@Parcel
public class Annonce {

        String title;
        String phone;
        String description;
        double price;
        String imageUrl;
        List<String> address = new ArrayList<>();
        double latitude;
        double longitude;
        List<String> rubriques = new ArrayList<>();

        // empty constructor needed by the Parceler library:
        public Annonce() {}

        public Annonce(String title, String phone, String description,
                          double price, String imageUrl, ArrayList<String> address,
                          double latitude, double longitude, ArrayList<String> rubriques) {
            this.title = title;
            this.phone = phone;
            this.description = description;
            this.price = price;
            this.imageUrl = getLargeImageUrl(imageUrl);
            this.address = address;
            this.latitude = latitude;
            this.longitude = longitude;
            this.rubriques = rubriques;
        }

        public String getTitle() {
            return title;
        }

        public String getPhone() {
            return phone;
        }

        public String getDescription() {
            return  description;
        }

        public double getPrice() {
            return price;
        }

        public String getImageUrl() { return imageUrl;}

        public String getLargeImageUrl(String imageUrl) {
            String largeImageUrl = imageUrl.substring(0, imageUrl.length() - 6).concat("o.jpg");
            return largeImageUrl;
        }

        public List<String> getAddress() {
            return address;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public List<String> getRubriques() {
            return rubriques;
        }


}
