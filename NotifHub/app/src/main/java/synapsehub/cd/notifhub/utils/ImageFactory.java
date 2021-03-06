package synapsehub.cd.notifhub.utils;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by michelo on 7/4/16.
 */

public class ImageFactory {


        /**
         * Creates a new jpg file that can be used to store an image.
         *
         * @return null if the file couldn't be created.
         */

        public static File newFile() {

            // Create an image file name

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String imageFileName = "JPEG_" + timeStamp + "_";

            File storageDir = Environment.getExternalStoragePublicDirectory(

                    Environment.DIRECTORY_PICTURES);

            File imageFile;

            try {

                imageFile = File.createTempFile(imageFileName, ".jpg", storageDir);

            } catch (IOException e) {

                return null;

            }

            return imageFile;

        }

}
