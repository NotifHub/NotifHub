package synapsehub.cd.notifhub;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by michelo on 6/28/16.
 */

public class Config {

    public static final String PREFS_USERIDentity = "user_identity";
    public static final String ANNONCE_ID="id";
    public static final String RUBRIQUE_ENTITY="rubrique";
    public static final String SRUBRIQUE_ENTITY="sousrubrique";
    public static final String Child_annonce = "Annonce";


    /*private void storeImageToFirebase() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8; // shrink it down otherwise we will use stupid amounts of memory
        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoUri.getPath(), options);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bytes = baos.toByteArray();
        String base64Image = Base64.encodeToString(bytes, Base64.DEFAULT);

        // we finally have our base64 string version of the image, save it.
        firebase.child("pic").setValue(base64Image);
        System.out.println("Stored image with length: " + bytes.length);
    }*/

}
