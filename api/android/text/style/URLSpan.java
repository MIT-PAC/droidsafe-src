package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.provider.Browser;
import android.text.ParcelableSpan;
import android.text.TextUtils;
import android.view.View;

public class URLSpan extends ClickableSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.499 -0400", hash_original_field = "8A98B268A3185DCF10FD476BB56AA991", hash_generated_field = "92D0AFAEA52DADCF8157B0CE1915F0CF")

    private String mURL;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.500 -0400", hash_original_method = "5AD1FAF34DE3FA8A09E91DA82ECEC3B3", hash_generated_method = "B54D202A14D180513BBE84D40D7107CE")
    public  URLSpan(String url) {
        mURL = url;
        // ---------- Original Method ----------
        //mURL = url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.501 -0400", hash_original_method = "DE27BD82F1FA5C839057FA46D57E26CE", hash_generated_method = "2AD0059B727D0874C6EE4948E755257A")
    public  URLSpan(Parcel src) {
        mURL = src.readString();
        // ---------- Original Method ----------
        //mURL = src.readString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.501 -0400", hash_original_method = "922B12E08E67C6B8053CA65C059545DA", hash_generated_method = "E560DC24A19628C9937B85323C067523")
    public int getSpanTypeId() {
        int var65668C9F02B7364BCF30E3F3AA6CFF0C_663120060 = (TextUtils.URL_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233054815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233054815;
        // ---------- Original Method ----------
        //return TextUtils.URL_SPAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.502 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1D11134DF46DFD889E16848834B6654B")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_145516108 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793747433 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793747433;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.502 -0400", hash_original_method = "C4C1C8BAFA904799F51D3BBA35A0D0C5", hash_generated_method = "164A2B7E6CB571F4987742457FEDC27F")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(mURL);
        // ---------- Original Method ----------
        //dest.writeString(mURL);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.503 -0400", hash_original_method = "C929B5C6A842A00D31BD07E0935FD2ED", hash_generated_method = "840A024808F45B12B8DF8ECD8DEE1B53")
    public String getURL() {
String var550501E49D065ECDEDD352E121BD3166_1649224760 =         mURL;
        var550501E49D065ECDEDD352E121BD3166_1649224760.addTaint(taint);
        return var550501E49D065ECDEDD352E121BD3166_1649224760;
        // ---------- Original Method ----------
        //return mURL;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.503 -0400", hash_original_method = "04E55325C1106D52B4E11E13B7EEFAD9", hash_generated_method = "DAB6AA801DD7FA674B91531DADEB1659")
    @Override
    public void onClick(View widget) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(widget.getTaint());
        Uri uri = Uri.parse(getURL());
        Context context = widget.getContext();
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
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

