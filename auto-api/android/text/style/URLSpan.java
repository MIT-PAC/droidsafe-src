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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.150 -0400", hash_original_field = "8A98B268A3185DCF10FD476BB56AA991", hash_generated_field = "92D0AFAEA52DADCF8157B0CE1915F0CF")

    private String mURL;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.151 -0400", hash_original_method = "5AD1FAF34DE3FA8A09E91DA82ECEC3B3", hash_generated_method = "B54D202A14D180513BBE84D40D7107CE")
    public  URLSpan(String url) {
        mURL = url;
        // ---------- Original Method ----------
        //mURL = url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.151 -0400", hash_original_method = "DE27BD82F1FA5C839057FA46D57E26CE", hash_generated_method = "2AD0059B727D0874C6EE4948E755257A")
    public  URLSpan(Parcel src) {
        mURL = src.readString();
        // ---------- Original Method ----------
        //mURL = src.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.151 -0400", hash_original_method = "922B12E08E67C6B8053CA65C059545DA", hash_generated_method = "61BB65436CB799A5B8EBBE1CAAF98B43")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1776703293 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1776703293;
        // ---------- Original Method ----------
        //return TextUtils.URL_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.152 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "14E9E0B7E6BC1D38BB51479CFE60C5D7")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461682450 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461682450;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.152 -0400", hash_original_method = "C4C1C8BAFA904799F51D3BBA35A0D0C5", hash_generated_method = "819D9178922FA7943AAED32806C41C8C")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mURL);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeString(mURL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.153 -0400", hash_original_method = "C929B5C6A842A00D31BD07E0935FD2ED", hash_generated_method = "56C9721A75C5CA11C7405C4C8C8F453F")
    public String getURL() {
        String varB4EAC82CA7396A68D541C85D26508E83_1124966405 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1124966405 = mURL;
        varB4EAC82CA7396A68D541C85D26508E83_1124966405.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1124966405;
        // ---------- Original Method ----------
        //return mURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.163 -0400", hash_original_method = "04E55325C1106D52B4E11E13B7EEFAD9", hash_generated_method = "43F7EF2C735FA62CE4C7BEC9E84A268E")
    @Override
    public void onClick(View widget) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Uri uri;
        uri = Uri.parse(getURL());
        Context context;
        context = widget.getContext();
        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
        context.startActivity(intent);
        addTaint(widget.getTaint());
        // ---------- Original Method ----------
        //Uri uri = Uri.parse(getURL());
        //Context context = widget.getContext();
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
        //context.startActivity(intent);
    }

    
}

