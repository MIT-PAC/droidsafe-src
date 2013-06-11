package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final String mURL;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.363 -0400", hash_original_method = "5AD1FAF34DE3FA8A09E91DA82ECEC3B3", hash_generated_method = "1213E4433DCBF01D44CC29E5B58DA6AF")
    @DSModeled(DSC.SAFE)
    public URLSpan(String url) {
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
        //mURL = url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.363 -0400", hash_original_method = "DE27BD82F1FA5C839057FA46D57E26CE", hash_generated_method = "BFF89BE343E6E0F2ED848BD994332373")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URLSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mURL = src.readString();
        // ---------- Original Method ----------
        //mURL = src.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.363 -0400", hash_original_method = "922B12E08E67C6B8053CA65C059545DA", hash_generated_method = "6463B84FAE08294EE2B21C2032EC8D54")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.URL_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.363 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.363 -0400", hash_original_method = "C4C1C8BAFA904799F51D3BBA35A0D0C5", hash_generated_method = "30E2A6C9ED61F2409BC56D14EAA1DE3E")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeString(mURL);
        // ---------- Original Method ----------
        //dest.writeString(mURL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.363 -0400", hash_original_method = "C929B5C6A842A00D31BD07E0935FD2ED", hash_generated_method = "BB57A32EFD23A3617B0EFA8A405C459F")
    @DSModeled(DSC.SAFE)
    public String getURL() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.364 -0400", hash_original_method = "04E55325C1106D52B4E11E13B7EEFAD9", hash_generated_method = "C6BE98C6E3F31BDB30B34CB6187CC2F4")
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


