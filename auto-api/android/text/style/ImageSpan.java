package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;

public class ImageSpan extends DynamicDrawableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.772 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "F17AF26B1AE93DE0DD2EED2442B6F076")

    private Drawable mDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.772 -0400", hash_original_field = "E793B03816B1EA3A9EE570ADD1129553", hash_generated_field = "5230A0318FFD99BBF5DCA1BF9243AE7A")

    private Uri mContentUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.772 -0400", hash_original_field = "3B71E056EB528FE6CFFAD85F16931309", hash_generated_field = "C75E6DA122FF842A3C7D587E6E200AF8")

    private int mResourceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.772 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.772 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "5EB2E77F51594E2C1DE90F3545DAFA8A")

    private String mSource;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.773 -0400", hash_original_method = "185ED0AA6BEAFCFF142A4CFD45E574FC", hash_generated_method = "A07A0D560E14AC6BFF5EC27074D850EF")
    @Deprecated
    public  ImageSpan(Bitmap b) {
        this(null, b, ALIGN_BOTTOM);
        addTaint(b.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.773 -0400", hash_original_method = "34B2A214F0FD529DA939313FB3C3E538", hash_generated_method = "20517FF326BBFA3AE674B5D14253695E")
    @Deprecated
    public  ImageSpan(Bitmap b, int verticalAlignment) {
        this(null, b, verticalAlignment);
        addTaint(b.getTaint());
        addTaint(verticalAlignment);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.773 -0400", hash_original_method = "7AEE11D7D0A74AC540256E446F7A2408", hash_generated_method = "1BF645892A16E60686906A67E9E1A4EB")
    public  ImageSpan(Context context, Bitmap b) {
        this(context, b, ALIGN_BOTTOM);
        addTaint(context.getTaint());
        addTaint(b.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.774 -0400", hash_original_method = "3963AA6755EF0F8E669BE02E5FE48B0A", hash_generated_method = "234F135A01099274ADCD83937E2E704F")
    public  ImageSpan(Context context, Bitmap b, int verticalAlignment) {
        super(verticalAlignment);
        mContext = context;
        mDrawable = context != null
                ? new BitmapDrawable(context.getResources(), b)
                : new BitmapDrawable(b);
        int width = mDrawable.getIntrinsicWidth();
        int height = mDrawable.getIntrinsicHeight();
        mDrawable.setBounds(0, 0, width > 0 ? width : 0, height > 0 ? height : 0);
        addTaint(verticalAlignment);
        // ---------- Original Method ----------
        //mContext = context;
        //mDrawable = context != null
                //? new BitmapDrawable(context.getResources(), b)
                //: new BitmapDrawable(b);
        //int width = mDrawable.getIntrinsicWidth();
        //int height = mDrawable.getIntrinsicHeight();
        //mDrawable.setBounds(0, 0, width > 0 ? width : 0, height > 0 ? height : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.774 -0400", hash_original_method = "0D126CCCA77E2FB90C8091AB4A5A8377", hash_generated_method = "E79200323EF1A04321E241174B1E2BBF")
    public  ImageSpan(Drawable d) {
        this(d, ALIGN_BOTTOM);
        addTaint(d.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.774 -0400", hash_original_method = "A8A2FDBB2FE3A38ECC14673F42D0EA39", hash_generated_method = "53E829C606B02BE7FAC2E0E8FF4EB5AA")
    public  ImageSpan(Drawable d, int verticalAlignment) {
        super(verticalAlignment);
        mDrawable = d;
        addTaint(verticalAlignment);
        // ---------- Original Method ----------
        //mDrawable = d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.774 -0400", hash_original_method = "54F6AA82EA4B003ADF5D8246E336A82D", hash_generated_method = "A5E9C9C85EDA6F0CA04F27CDFA7D76F7")
    public  ImageSpan(Drawable d, String source) {
        this(d, source, ALIGN_BOTTOM);
        addTaint(d.getTaint());
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.774 -0400", hash_original_method = "F9636F3F26DA70FC2592614F77D85D71", hash_generated_method = "6EC0F85B4D6D429B071F61CCCC6D8935")
    public  ImageSpan(Drawable d, String source, int verticalAlignment) {
        super(verticalAlignment);
        mDrawable = d;
        mSource = source;
        addTaint(verticalAlignment);
        // ---------- Original Method ----------
        //mDrawable = d;
        //mSource = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.775 -0400", hash_original_method = "E44302541FD4ECECF2698F7D07EBCA57", hash_generated_method = "ABA52C58197816D0921A080C14682E86")
    public  ImageSpan(Context context, Uri uri) {
        this(context, uri, ALIGN_BOTTOM);
        addTaint(context.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.775 -0400", hash_original_method = "97E5D1114EAA0CA1A8404960D716AC3A", hash_generated_method = "3881FCD77036B538F2EE927379CFCE0F")
    public  ImageSpan(Context context, Uri uri, int verticalAlignment) {
        super(verticalAlignment);
        mContext = context;
        mContentUri = uri;
        mSource = uri.toString();
        addTaint(verticalAlignment);
        // ---------- Original Method ----------
        //mContext = context;
        //mContentUri = uri;
        //mSource = uri.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.776 -0400", hash_original_method = "9E8FB6BDEE77C38D81FCBDDCFBDDF78F", hash_generated_method = "E382C28F70CD49549C0C7F4DAC8EC6D2")
    public  ImageSpan(Context context, int resourceId) {
        this(context, resourceId, ALIGN_BOTTOM);
        addTaint(context.getTaint());
        addTaint(resourceId);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.776 -0400", hash_original_method = "112063CFBD1BF410C553139A09CB99FD", hash_generated_method = "DEBB1886CB47BF4A236F7FFE7F1BE91E")
    public  ImageSpan(Context context, int resourceId, int verticalAlignment) {
        super(verticalAlignment);
        mContext = context;
        mResourceId = resourceId;
        addTaint(verticalAlignment);
        // ---------- Original Method ----------
        //mContext = context;
        //mResourceId = resourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.777 -0400", hash_original_method = "16DECD9D0B2DB9DD9C51FE274851DFB5", hash_generated_method = "9A8BBC59A1019B0BC2ED389CAC21B247")
    @Override
    public Drawable getDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_60210859 = null; //Variable for return #1
        Drawable drawable = null;
        {
            drawable = mDrawable;
        } //End block
        {
            Bitmap bitmap = null;
            try 
            {
                InputStream is = mContext.getContentResolver().openInputStream(
                        mContentUri);
                bitmap = BitmapFactory.decodeStream(is);
                drawable = new BitmapDrawable(mContext.getResources(), bitmap);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight());
                is.close();
            } //End block
            catch (Exception e)
            { }
        } //End block
        {
            try 
            {
                drawable = mContext.getResources().getDrawable(mResourceId);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight());
            } //End block
            catch (Exception e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_60210859 = drawable;
        varB4EAC82CA7396A68D541C85D26508E83_60210859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_60210859;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.778 -0400", hash_original_method = "6D9DB226EA21C548410845AA7A7E2DD4", hash_generated_method = "219FE45404F151A7EA42AD7052E1DF68")
    public String getSource() {
        String varB4EAC82CA7396A68D541C85D26508E83_1434075746 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1434075746 = mSource;
        varB4EAC82CA7396A68D541C85D26508E83_1434075746.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1434075746;
        // ---------- Original Method ----------
        //return mSource;
    }

    
}

