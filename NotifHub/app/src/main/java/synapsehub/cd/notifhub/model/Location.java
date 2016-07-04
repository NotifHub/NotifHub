package synapsehub.cd.notifhub.model;

import java.io.Serializable;

/**
 * Created by michelo on 7/2/16.
 */

public class Location {


        private String lat;
        private String lng;

        public Location() {
        }

        public Location(String lat, String lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

}
