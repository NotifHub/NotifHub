package synapsehub.cd.notifhub.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by michelo on 7/4/16.
 */

public class PhotoTaker {

        public static final int REQUEST_TAKE_PHOTO = 101;

        private final Activity mActivity;

        public PhotoTaker(Activity activity) {

            mActivity = activity;

        }

        /**

         * Takes a photo stores it in the given file.

         * You should override onActivityResult if you want to know when this has finished, and filter

         * the requestCode on PhotoTaker.REQUEST_TAKE_PHOTO.

         */

        public boolean takePhoto(File outputFile) {

            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // Ensure that there's a camera activity to handle the intent

            if (takePictureIntent.resolveActivity(mActivity.getPackageManager()) != null) {

                // Continue only if the File was successfully created

                if (outputFile != null) {

                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(outputFile));

                    mActivity.startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);

                    return true;

                }

            }

            return false;

        }

}
