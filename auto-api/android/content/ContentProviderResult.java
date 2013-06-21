package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.Uri;
import android.os.Parcelable;
import android.os.Parcel;

public class ContentProviderResult implements Parcelable {
    public Uri uri;
    public Integer count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.612 -0400", hash_original_method = "D6E18454D2E4039ABD60A78819D956A0", hash_generated_method = "921BDD8DFE12CC3C488690E9C0732960")
    @DSModeled(DSC.SPEC)
    public ContentProviderResult(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri must not be null");
        this.count = null;
        // ---------- Original Method ----------
        //if (uri == null) throw new IllegalArgumentException("uri must not be null");
        //this.uri = uri;
        //this.count = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.618 -0400", hash_original_method = "5670F9D71891732E7FC99BCF350F686F", hash_generated_method = "A5F49DA375246A1EAF9BCED5E6075557")
    @DSModeled(DSC.SAFE)
    public ContentProviderResult(int count) {
        dsTaint.addTaint(count);
        this.uri = null;
        // ---------- Original Method ----------
        //this.count = count;
        //this.uri = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.623 -0400", hash_original_method = "1A17E80C5D5F7715CF5E56754C18C8A6", hash_generated_method = "BB9ADD6AC5E30760320D19B265DCF730")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentProviderResult(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        int type;
        type = source.readInt();
        {
            count = source.readInt();
            uri = null;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.624 -0400", hash_original_method = "9CD6B2E6D05DCE725086FF1495B545F8", hash_generated_method = "603BBEE8259CF858668430BC40F17ED6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        {
            dest.writeInt(1);
            dest.writeInt(count);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.624 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.625 -0400", hash_original_method = "892D2D0BDFABE856512808AB86E3168D", hash_generated_method = "0DC5B8B04AC64235EA892467E0135002")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        {
            String varB4F9109AA14DA8CF26ED4D888C9F4059_1926080160 = ("ContentProviderResult(uri=" + uri.toString() + ")");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (uri != null) {
            //return "ContentProviderResult(uri=" + uri.toString() + ")";
        //}
        //return "ContentProviderResult(count=" + count + ")";
    }

    
    public static final Creator<ContentProviderResult> CREATOR = new Creator<ContentProviderResult>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.625 -0400", hash_original_method = "0C8258457979985FA0D5E299A051E461", hash_generated_method = "25186290C94052AE8E971AF432F9281D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ContentProviderResult createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ContentProviderResult varD5ADAB3D0D613162255C944C904BA32D_421617685 = (new ContentProviderResult(source));
            return (ContentProviderResult)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ContentProviderResult(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.625 -0400", hash_original_method = "5088D34CAD75AD433E47CE2C22D5303F", hash_generated_method = "E9473A827C8E51FA73CDB4F42636A9F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ContentProviderResult[] newArray(int size) {
            dsTaint.addTaint(size);
            ContentProviderResult[] var3047B8AAFF2E94A99EFD73DDFA973453_71700439 = (new ContentProviderResult[size]);
            return (ContentProviderResult[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ContentProviderResult[size];
        }

        
}; //Transformed anonymous class
}

