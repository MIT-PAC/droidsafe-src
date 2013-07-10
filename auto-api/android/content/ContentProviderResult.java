package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.net.Uri;
import android.os.Parcelable;
import android.os.Parcel;

public class ContentProviderResult implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.701 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "CD245B47D421EDF9464454AF3C13247D")

    public Uri uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.701 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "F85BE5307E9B96D5B0C722FEC3E9F10D")

    public Integer count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.702 -0400", hash_original_method = "D6E18454D2E4039ABD60A78819D956A0", hash_generated_method = "2F01B12EDA33C4E7EBA32AF6135D8E30")
    public  ContentProviderResult(Uri uri) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri must not be null");
        this.uri = uri;
        this.count = null;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.702 -0400", hash_original_method = "5670F9D71891732E7FC99BCF350F686F", hash_generated_method = "AA7EB08A3CDF6F6C603956BBE8C417DA")
    public  ContentProviderResult(int count) {
        this.count = count;
        this.uri = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.703 -0400", hash_original_method = "1A17E80C5D5F7715CF5E56754C18C8A6", hash_generated_method = "62A615EE010495D454995C5E73C59A9B")
    public  ContentProviderResult(Parcel source) {
        int type = source.readInt();
        {
            count = source.readInt();
            uri = null;
        } 
        {
            count = null;
            uri = Uri.CREATOR.createFromParcel(source);
        } 
        
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.704 -0400", hash_original_method = "9CD6B2E6D05DCE725086FF1495B545F8", hash_generated_method = "04C621D876EF5C5E14440926A4621C34")
    public void writeToParcel(Parcel dest, int flags) {
        {
            dest.writeInt(1);
            dest.writeInt(count);
        } 
        {
            dest.writeInt(2);
            uri.writeToParcel(dest, 0);
        } 
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.704 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "808015A96CE12EC9ADC8B2B183E19E25")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897477622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897477622;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.707 -0400", hash_original_method = "892D2D0BDFABE856512808AB86E3168D", hash_generated_method = "3F2759EF1B63708F8E6786AE68CB8749")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_322414200 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_381080270 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_322414200 = "ContentProviderResult(uri=" + uri.toString() + ")";
        } 
        varB4EAC82CA7396A68D541C85D26508E83_381080270 = "ContentProviderResult(count=" + count + ")";
        String varA7E53CE21691AB073D9660D615818899_1129228138; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1129228138 = varB4EAC82CA7396A68D541C85D26508E83_322414200;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1129228138 = varB4EAC82CA7396A68D541C85D26508E83_381080270;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1129228138.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1129228138;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.707 -0400", hash_original_field = "F018B6EF0D315D56317D0DF9DCDA6979", hash_generated_field = "CFE4FC623FC720B7BBEAC41F3A8161D9")

    public static final Creator<ContentProviderResult> CREATOR =
            new Creator<ContentProviderResult>() {
        public ContentProviderResult createFromParcel(Parcel source) {
            return new ContentProviderResult(source);
        }

        public ContentProviderResult[] newArray(int size) {
            return new ContentProviderResult[size];
        }
    };
    
    public ContentProviderResult createFromParcel(Parcel source) {
            return new ContentProviderResult(source);
        }
    
    
    public ContentProviderResult[] newArray(int size) {
            return new ContentProviderResult[size];
        }
    
}

