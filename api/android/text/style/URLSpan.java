package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.provider.Browser;
import android.text.ParcelableSpan;
import android.text.TextUtils;
import android.view.View;





public class URLSpan extends ClickableSpan implements ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.388 -0500", hash_original_field = "08871E39128BE26E8E2A4AE5070B5D92", hash_generated_field = "92D0AFAEA52DADCF8157B0CE1915F0CF")


    private  String mURL;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.388 -0500", hash_original_method = "5AD1FAF34DE3FA8A09E91DA82ECEC3B3", hash_generated_method = "A95CF5F09DE19CE03A897F3B464BD9A0")
    public URLSpan(String url) {
        mURL = url;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.389 -0500", hash_original_method = "DE27BD82F1FA5C839057FA46D57E26CE", hash_generated_method = "0A9D557D147F620CBCF83B3A482F85AF")
    public URLSpan(Parcel src) {
        mURL = src.readString();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.390 -0500", hash_original_method = "922B12E08E67C6B8053CA65C059545DA", hash_generated_method = "495FBB71C1F9157E146EAB6C60C7B5FF")
    public int getSpanTypeId() {
        return TextUtils.URL_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.391 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.392 -0500", hash_original_method = "C4C1C8BAFA904799F51D3BBA35A0D0C5", hash_generated_method = "B684501AFBFCF2CC27265A515649F824")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mURL);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.393 -0500", hash_original_method = "C929B5C6A842A00D31BD07E0935FD2ED", hash_generated_method = "2A024A82A1FC88FE53C083EBAF13F92A")
    public String getURL() {
        return mURL;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.393 -0500", hash_original_method = "04E55325C1106D52B4E11E13B7EEFAD9", hash_generated_method = "F6AAE900FBE3FE8ECAA6E9BE2C1CF933")
    @Override
public void onClick(View widget) {
        Uri uri = Uri.parse(getURL());
        Context context = widget.getContext();
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
        context.startActivity(intent);
    }

    
}

