package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.provider.Browser;
import android.text.ParcelableSpan;
import android.text.TextUtils;
import android.view.View;

public class URLSpan extends ClickableSpan implements ParcelableSpan {
    private String mURL;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.024 -0400", hash_original_method = "5AD1FAF34DE3FA8A09E91DA82ECEC3B3", hash_generated_method = "D2481A88B0F838AE5AAB0004C82CF018")
    @DSModeled(DSC.SAFE)
    public URLSpan(String url) {
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
        //mURL = url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.024 -0400", hash_original_method = "DE27BD82F1FA5C839057FA46D57E26CE", hash_generated_method = "D192F72E250AFA1D335F58C72D76193B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URLSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mURL = src.readString();
        // ---------- Original Method ----------
        //mURL = src.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.025 -0400", hash_original_method = "922B12E08E67C6B8053CA65C059545DA", hash_generated_method = "3D68D9B1C03ED89210C4A6F26D1B5603")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.URL_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.025 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.025 -0400", hash_original_method = "C4C1C8BAFA904799F51D3BBA35A0D0C5", hash_generated_method = "3881512B0AC64389773B3DC326502F9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(mURL);
        // ---------- Original Method ----------
        //dest.writeString(mURL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.025 -0400", hash_original_method = "C929B5C6A842A00D31BD07E0935FD2ED", hash_generated_method = "1DF93B8ADBAC85F9EE6FD9A5065323F0")
    @DSModeled(DSC.SAFE)
    public String getURL() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.025 -0400", hash_original_method = "04E55325C1106D52B4E11E13B7EEFAD9", hash_generated_method = "A851B0D2E49E517811FCF9D4D2A8FD94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onClick(View widget) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(widget.dsTaint);
        Uri uri;
        uri = Uri.parse(getURL());
        Context context;
        context = widget.getContext();
        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
        context.startActivity(intent);
        // ---------- Original Method ----------
        //Uri uri = Uri.parse(getURL());
        //Context context = widget.getContext();
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
        //context.startActivity(intent);
    }

    
}

