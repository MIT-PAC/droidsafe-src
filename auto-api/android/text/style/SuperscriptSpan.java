package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class SuperscriptSpan extends MetricAffectingSpan implements ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.104 -0400", hash_original_method = "A61AB96C11E77F6A36ED29C74BA40E45", hash_generated_method = "DE65DBC0A53FF2E3ADE17A2A294E4A04")
    public  SuperscriptSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.105 -0400", hash_original_method = "B19848584389A2607BE1DAAEB2FA7668", hash_generated_method = "5D2C230AE1780D325FE9D87CD354E471")
    public  SuperscriptSpan(Parcel src) {
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.105 -0400", hash_original_method = "0CB176122CE000C44267FEA34CA341C1", hash_generated_method = "7C21D28978016916FFD1965374FDB89E")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436789257 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436789257;
        // ---------- Original Method ----------
        //return TextUtils.SUPERSCRIPT_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.106 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E78CCA49A71FCFCF8FFA4BD9782176EE")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897364937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897364937;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.106 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "E7DBC20584A55C26974D54383A48E9F7")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.106 -0400", hash_original_method = "E27C5F044B669DD3305C3952779CC951", hash_generated_method = "0EC429023F13963888CA4492D7F0740B")
    @Override
    public void updateDrawState(TextPaint tp) {
        tp.baselineShift += (int) (tp.ascent() / 2);
        addTaint(tp.getTaint());
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.125 -0400", hash_original_method = "A4B2093D2F6B24A1446298F151C8C815", hash_generated_method = "FD19025545772C3FB075F0950CD5E7B1")
    @Override
    public void updateMeasureState(TextPaint tp) {
        tp.baselineShift += (int) (tp.ascent() / 2);
        addTaint(tp.getTaint());
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
}

