package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.Comparable;

public final class ComponentName implements Parcelable, Cloneable, Comparable<ComponentName> {
    private final String mPackage;
    private final String mClass;
    public static final Parcelable.Creator<ComponentName> CREATOR = new Parcelable.Creator<ComponentName>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.259 -0400", hash_original_method = "B8B6FA6877F2BC7297214F94718448AF", hash_generated_method = "1A40A3A1C35191542AF6A22547B74336")
        @DSModeled(DSC.SAFE)
        public ComponentName createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (ComponentName)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ComponentName(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.259 -0400", hash_original_method = "E4EFBA185D141B45B652C08AB65870BB", hash_generated_method = "2E72769FBC1C77490F712EBCCF0D8A47")
        @DSModeled(DSC.SAFE)
        public ComponentName[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ComponentName[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ComponentName[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.259 -0400", hash_original_method = "1714B1C8173E376D41E514F902D33E99", hash_generated_method = "AA885785CDA7A0C3DF61E201A6E92EB6")
    @DSModeled(DSC.SAFE)
    public ComponentName(String pkg, String cls) {
        dsTaint.addTaint(cls);
        dsTaint.addTaint(pkg);
        throw new NullPointerException("package name is null");
        throw new NullPointerException("class name is null");
        // ---------- Original Method ----------
        //if (pkg == null) throw new NullPointerException("package name is null");
        //if (cls == null) throw new NullPointerException("class name is null");
        //mPackage = pkg;
        //mClass = cls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.260 -0400", hash_original_method = "36F25878FE380B4CEA8E7C4B89DDFC1A", hash_generated_method = "C129333F30FB1A007FE3A212737BDF5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName(Context pkg, String cls) {
        dsTaint.addTaint(cls);
        dsTaint.addTaint(pkg.dsTaint);
        throw new NullPointerException("class name is null");
        mPackage = pkg.getPackageName();
        // ---------- Original Method ----------
        //if (cls == null) throw new NullPointerException("class name is null");
        //mPackage = pkg.getPackageName();
        //mClass = cls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.260 -0400", hash_original_method = "8AE00F6D12874A3382D28F364D43BAC6", hash_generated_method = "86999A4F18DF5BA332D943AD9A4D5E76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName(Context pkg, Class<?> cls) {
        dsTaint.addTaint(cls.dsTaint);
        dsTaint.addTaint(pkg.dsTaint);
        mPackage = pkg.getPackageName();
        mClass = cls.getName();
        // ---------- Original Method ----------
        //mPackage = pkg.getPackageName();
        //mClass = cls.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.260 -0400", hash_original_method = "85979238AB87BCF4845F6771314A5B1D", hash_generated_method = "2F840427537D1CDD532AAE01612B1541")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mPackage = in.readString();
        throw new NullPointerException(
                "package name is null");
        mClass = in.readString();
        throw new NullPointerException(
                "class name is null");
        // ---------- Original Method ----------
        //mPackage = in.readString();
        //if (mPackage == null) throw new NullPointerException(
                //"package name is null");
        //mClass = in.readString();
        //if (mClass == null) throw new NullPointerException(
                //"class name is null");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.260 -0400", hash_original_method = "5EFEBE9DDFB777526DBE0E9A79DAA5EE", hash_generated_method = "3B7A95602F019A44B4B7966514899D56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ComponentName(String pkg, Parcel in) {
        dsTaint.addTaint(pkg);
        dsTaint.addTaint(in.dsTaint);
        mClass = in.readString();
        // ---------- Original Method ----------
        //mPackage = pkg;
        //mClass = in.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.261 -0400", hash_original_method = "0C586E8D4837845118D5ECAFE1DD23B0", hash_generated_method = "07946CB53C1E5B31A02C8BC67B708997")
    @DSModeled(DSC.SAFE)
    public ComponentName clone() {
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ComponentName(mPackage, mClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.261 -0400", hash_original_method = "89B4378559F402BEFD7FD434E355C3B4", hash_generated_method = "D813909CB0A58B5E8C069B5F7063ECDC")
    @DSModeled(DSC.SAFE)
    public String getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.261 -0400", hash_original_method = "ABD4E1FA4C56F78B933D2E76ACF407D1", hash_generated_method = "7CF0BEBEBF49EA6E331DA9D6F96FB79A")
    @DSModeled(DSC.SAFE)
    public String getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.261 -0400", hash_original_method = "1928B7DE815A138E651EC762B534B9EC", hash_generated_method = "8F0AF176051354D0135BAEE8CD1BAEA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getShortClassName() {
        {
            boolean var8791F3C1D7BA53F557592F67D168B096_1384836811 = (mClass.startsWith(mPackage));
            {
                int PN;
                PN = mPackage.length();
                int CN;
                CN = mClass.length();
                {
                    boolean var358F7397C8EC103C9FA8376FFDCED82F_684458797 = (CN > PN && mClass.charAt(PN) == '.');
                    {
                        String varE9BB5E1BBE7D8F1363105843082B7965_2656022 = (mClass.substring(PN, CN));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mClass.startsWith(mPackage)) {
            //int PN = mPackage.length();
            //int CN = mClass.length();
            //if (CN > PN && mClass.charAt(PN) == '.') {
                //return mClass.substring(PN, CN);
            //}
        //}
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.262 -0400", hash_original_method = "390AD2AD67B7039AADEA1F7D4A32A2A2", hash_generated_method = "5CFC23A8A1FE6FD046F51B68999EB828")
    @DSModeled(DSC.SAFE)
    public String flattenToString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackage + "/" + mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.262 -0400", hash_original_method = "CF7AA080F36C0EC07816037C2C3C9C55", hash_generated_method = "CCEB778EC659E50D7A6959691355E4E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String flattenToShortString() {
        String varA65FBA025EFD2E2ECAF06BBE75A55CC8_577539535 = (mPackage + "/" + getShortClassName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackage + "/" + getShortClassName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.262 -0400", hash_original_method = "D4E8AB1939E332222FA82C6706402E5E", hash_generated_method = "AC1ABC1EAD9359F8606C0A629E68E2FF")
    public static ComponentName unflattenFromString(String str) {
        int sep = str.indexOf('/');
        if (sep < 0 || (sep+1) >= str.length()) {
            return null;
        }
        String pkg = str.substring(0, sep);
        String cls = str.substring(sep+1);
        if (cls.length() > 0 && cls.charAt(0) == '.') {
            cls = pkg + cls;
        }
        return new ComponentName(pkg, cls);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.262 -0400", hash_original_method = "7CD87B9188FFFCA76A5FF9BDC65CF37F", hash_generated_method = "E681F4D488C244D8AC3EE8A074BC19F3")
    @DSModeled(DSC.SAFE)
    public String toShortString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "{" + mPackage + "/" + mClass + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.263 -0400", hash_original_method = "54FBA5D02AAB0DA35DA4E57242A769F6", hash_generated_method = "AEE078518C6B34FA705DE64F586DEE1F")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ComponentInfo{" + mPackage + "/" + mClass + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.263 -0400", hash_original_method = "221E549665728B04A91E5C9A58326754", hash_generated_method = "C722C2D81A2D6F4F152D671167B5CED9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        try 
        {
            {
                ComponentName other;
                other = (ComponentName)obj;
                boolean var36C27DE2882E82617D9C990E849A569D_1661304437 = (mPackage.equals(other.mPackage)
                        && mClass.equals(other.mClass));
            } //End block
        } //End block
        catch (ClassCastException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //if (obj != null) {
                //ComponentName other = (ComponentName)obj;
                //return mPackage.equals(other.mPackage)
                        //&& mClass.equals(other.mClass);
            //}
        //} catch (ClassCastException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.263 -0400", hash_original_method = "0BD278EA5D55E08CD4E56E53F182D0C7", hash_generated_method = "94448CD7BA825FDD44E0AFAFF035C4BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varBEE63132B8B98B94DDD6E03EDEC851FF_1719037366 = (mPackage.hashCode() + mClass.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPackage.hashCode() + mClass.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.264 -0400", hash_original_method = "DB0D439501C0EAB456A0FFDB0A59DF6E", hash_generated_method = "17E7F7F195FB44B0E9D365F6D63610C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(ComponentName that) {
        dsTaint.addTaint(that.dsTaint);
        int v;
        v = this.mPackage.compareTo(that.mPackage);
        int varFDFA92AC821D7F2A5DB9B7881F805EC0_637392438 = (this.mClass.compareTo(that.mClass));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int v;
        //v = this.mPackage.compareTo(that.mPackage);
        //if (v != 0) {
            //return v;
        //}
        //return this.mClass.compareTo(that.mClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.264 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.264 -0400", hash_original_method = "04D15992D5C44ACF00A97C758C27E164", hash_generated_method = "2B24FC72F0CEC80F2C87D37223159160")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeString(mPackage);
        out.writeString(mClass);
        // ---------- Original Method ----------
        //out.writeString(mPackage);
        //out.writeString(mClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.264 -0400", hash_original_method = "9548AC220202FFEF37F66BD7413BDD60", hash_generated_method = "8DD7C14E921C218432A74389513A08DC")
    public static void writeToParcel(ComponentName c, Parcel out) {
        if (c != null) {
            c.writeToParcel(out, 0);
        } else {
            out.writeString(null);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.265 -0400", hash_original_method = "6EAB545510B30AF94F1868FF1E5E1EEA", hash_generated_method = "547AE93556C371FCD245DF3F0C522778")
    public static ComponentName readFromParcel(Parcel in) {
        String pkg = in.readString();
        return pkg != null ? new ComponentName(pkg, in) : null;
    }

    
}


