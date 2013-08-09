package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;





public class ContentProviderResult implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.094 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "CD245B47D421EDF9464454AF3C13247D")

    public Uri uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.094 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "F85BE5307E9B96D5B0C722FEC3E9F10D")

    public Integer count;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.095 -0400", hash_original_method = "D6E18454D2E4039ABD60A78819D956A0", hash_generated_method = "098B287804724605DFB56216EC409F31")
    public  ContentProviderResult(Uri uri) {
        if(uri == null)        
        {
        IllegalArgumentException varA7E51D1A6F179308507624649E54C0ED_1324209100 = new IllegalArgumentException("uri must not be null");
        varA7E51D1A6F179308507624649E54C0ED_1324209100.addTaint(taint);
        throw varA7E51D1A6F179308507624649E54C0ED_1324209100;
        }
        this.uri = uri;
        this.count = null;
        // ---------- Original Method ----------
        //if (uri == null) throw new IllegalArgumentException("uri must not be null");
        //this.uri = uri;
        //this.count = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.097 -0400", hash_original_method = "5670F9D71891732E7FC99BCF350F686F", hash_generated_method = "AA7EB08A3CDF6F6C603956BBE8C417DA")
    public  ContentProviderResult(int count) {
        this.count = count;
        this.uri = null;
        // ---------- Original Method ----------
        //this.count = count;
        //this.uri = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.099 -0400", hash_original_method = "1A17E80C5D5F7715CF5E56754C18C8A6", hash_generated_method = "0FBA470450D4187287DDBFB8BB057CAE")
    public  ContentProviderResult(Parcel source) {
        int type = source.readInt();
        if(type == 1)        
        {
            count = source.readInt();
            uri = null;
        } //End block
        else
        {
            count = null;
            uri = Uri.CREATOR.createFromParcel(source);
        } //End block
        // ---------- Original Method ----------
        //int type = source.readInt();
        //if (type == 1) {
            //count = source.readInt();
            //uri = null;
        //} else {
            //count = null;
            //uri = Uri.CREATOR.createFromParcel(source);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.100 -0400", hash_original_method = "9CD6B2E6D05DCE725086FF1495B545F8", hash_generated_method = "B7DA5B504F74C346D4EEE6532900A4C3")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        if(uri == null)        
        {
            dest.writeInt(1);
            dest.writeInt(count);
        } //End block
        else
        {
            dest.writeInt(2);
            uri.writeToParcel(dest, 0);
        } //End block
        // ---------- Original Method ----------
        //if (uri == null) {
            //dest.writeInt(1);
            //dest.writeInt(count);
        //} else {
            //dest.writeInt(2);
            //uri.writeToParcel(dest, 0);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.101 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5BD5F025F2098C56D26F11A548F55D21")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2083540048 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367045899 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367045899;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.101 -0400", hash_original_method = "892D2D0BDFABE856512808AB86E3168D", hash_generated_method = "5F6C043239608CBC776B8AA4C97A0B02")
    public String toString() {
        if(uri != null)        
        {
String var1833BEAF9797AD8E35A3051EAD41E293_209786921 =             "ContentProviderResult(uri=" + uri.toString() + ")";
            var1833BEAF9797AD8E35A3051EAD41E293_209786921.addTaint(taint);
            return var1833BEAF9797AD8E35A3051EAD41E293_209786921;
        } //End block
String var1437308D17F62188830CE1DADAF18CCF_1437087911 =         "ContentProviderResult(count=" + count + ")";
        var1437308D17F62188830CE1DADAF18CCF_1437087911.addTaint(taint);
        return var1437308D17F62188830CE1DADAF18CCF_1437087911;
        // ---------- Original Method ----------
        //if (uri != null) {
            //return "ContentProviderResult(uri=" + uri.toString() + ")";
        //}
        //return "ContentProviderResult(count=" + count + ")";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.102 -0400", hash_original_field = "F018B6EF0D315D56317D0DF9DCDA6979", hash_generated_field = "CFE4FC623FC720B7BBEAC41F3A8161D9")

    public static final Creator<ContentProviderResult> CREATOR =
            new Creator<ContentProviderResult>() {
        public ContentProviderResult createFromParcel(Parcel source) {
            return new ContentProviderResult(source);
        }

        @DSModeled(DSC.SAFE)
        public ContentProviderResult[] newArray(int size) {
            return new ContentProviderResult[size];
        }
    };
    // orphaned legacy method
    public ContentProviderResult createFromParcel(Parcel source) {
            return new ContentProviderResult(source);
        }
    
    // orphaned legacy method
    public ContentProviderResult[] newArray(int size) {
            return new ContentProviderResult[size];
        }
    
}

