package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.Comparable;

public final class ComponentName implements Parcelable, Cloneable, Comparable<ComponentName> {
    private String mPackage;
    private String mClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.079 -0400", hash_original_method = "1714B1C8173E376D41E514F902D33E99", hash_generated_method = "6D04F34B98F67E6B45A2563E4ED33203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName(String pkg, String cls) {
        dsTaint.addTaint(cls);
        dsTaint.addTaint(pkg);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("package name is null");
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("class name is null");
        // ---------- Original Method ----------
        //if (pkg == null) throw new NullPointerException("package name is null");
        //if (cls == null) throw new NullPointerException("class name is null");
        //mPackage = pkg;
        //mClass = cls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.083 -0400", hash_original_method = "36F25878FE380B4CEA8E7C4B89DDFC1A", hash_generated_method = "94A7CE3632E44E3726626257BFA25C95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName(Context pkg, String cls) {
        dsTaint.addTaint(cls);
        dsTaint.addTaint(pkg.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("class name is null");
        mPackage = pkg.getPackageName();
        // ---------- Original Method ----------
        //if (cls == null) throw new NullPointerException("class name is null");
        //mPackage = pkg.getPackageName();
        //mClass = cls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.084 -0400", hash_original_method = "8AE00F6D12874A3382D28F364D43BAC6", hash_generated_method = "FE81E2D58AA675CC5036C9BB64431BA2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.084 -0400", hash_original_method = "85979238AB87BCF4845F6771314A5B1D", hash_generated_method = "01E45DB52DD673F849CDB5C337DC8C14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mPackage = in.readString();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "package name is null");
        mClass = in.readString();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "class name is null");
        // ---------- Original Method ----------
        //mPackage = in.readString();
        //if (mPackage == null) throw new NullPointerException(
                //"package name is null");
        //mClass = in.readString();
        //if (mClass == null) throw new NullPointerException(
                //"class name is null");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.085 -0400", hash_original_method = "5EFEBE9DDFB777526DBE0E9A79DAA5EE", hash_generated_method = "7DA5A32F20C5A5AA58FBD5A15BE1E9DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ComponentName(String pkg, Parcel in) {
        dsTaint.addTaint(pkg);
        dsTaint.addTaint(in.dsTaint);
        mClass = in.readString();
        // ---------- Original Method ----------
        //mPackage = pkg;
        //mClass = in.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.085 -0400", hash_original_method = "0C586E8D4837845118D5ECAFE1DD23B0", hash_generated_method = "F04F2120995BCF7AF436D0FE660EDEE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName clone() {
        ComponentName var714CD1F3BDF39E49329D51E096DA6072_888135513 = (new ComponentName(mPackage, mClass));
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ComponentName(mPackage, mClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.086 -0400", hash_original_method = "89B4378559F402BEFD7FD434E355C3B4", hash_generated_method = "58DF160E8A46F1410BB377D7FC8F468E")
    @DSModeled(DSC.SAFE)
    public String getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.087 -0400", hash_original_method = "ABD4E1FA4C56F78B933D2E76ACF407D1", hash_generated_method = "D7568970816E34F0409A6BCE67DB9CF4")
    @DSModeled(DSC.SAFE)
    public String getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.088 -0400", hash_original_method = "1928B7DE815A138E651EC762B534B9EC", hash_generated_method = "C4D14F74015523DFDE60F919ED12D640")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getShortClassName() {
        {
            boolean var8791F3C1D7BA53F557592F67D168B096_2097935027 = (mClass.startsWith(mPackage));
            {
                int PN;
                PN = mPackage.length();
                int CN;
                CN = mClass.length();
                {
                    boolean var358F7397C8EC103C9FA8376FFDCED82F_494253712 = (CN > PN && mClass.charAt(PN) == '.');
                    {
                        String varE9BB5E1BBE7D8F1363105843082B7965_136314340 = (mClass.substring(PN, CN));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.088 -0400", hash_original_method = "390AD2AD67B7039AADEA1F7D4A32A2A2", hash_generated_method = "A0513E4C5CD37DFF7E976EF48FD17A63")
    @DSModeled(DSC.SAFE)
    public String flattenToString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackage + "/" + mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.088 -0400", hash_original_method = "CF7AA080F36C0EC07816037C2C3C9C55", hash_generated_method = "A23DF44B82D75479878C555F4DFA8DCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String flattenToShortString() {
        String varA65FBA025EFD2E2ECAF06BBE75A55CC8_486796255 = (mPackage + "/" + getShortClassName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackage + "/" + getShortClassName();
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.089 -0400", hash_original_method = "7CD87B9188FFFCA76A5FF9BDC65CF37F", hash_generated_method = "F1B0D6092F31B241010F72139302633B")
    @DSModeled(DSC.SAFE)
    public String toShortString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "{" + mPackage + "/" + mClass + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.089 -0400", hash_original_method = "54FBA5D02AAB0DA35DA4E57242A769F6", hash_generated_method = "124E55E671A9977FF606B78B47AAFC1A")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ComponentInfo{" + mPackage + "/" + mClass + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.090 -0400", hash_original_method = "221E549665728B04A91E5C9A58326754", hash_generated_method = "1909A1C8DA33E45201152E3AE54C3A0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        try 
        {
            {
                ComponentName other;
                other = (ComponentName)obj;
                boolean var36C27DE2882E82617D9C990E849A569D_165445738 = (mPackage.equals(other.mPackage)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.091 -0400", hash_original_method = "0BD278EA5D55E08CD4E56E53F182D0C7", hash_generated_method = "E2F3502E1003FFB2727EB0D7456D90E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varBEE63132B8B98B94DDD6E03EDEC851FF_2075212184 = (mPackage.hashCode() + mClass.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPackage.hashCode() + mClass.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.091 -0400", hash_original_method = "DB0D439501C0EAB456A0FFDB0A59DF6E", hash_generated_method = "3C6695992718B27C4B6E2A284DF9757A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(ComponentName that) {
        dsTaint.addTaint(that.dsTaint);
        int v;
        v = this.mPackage.compareTo(that.mPackage);
        int varFDFA92AC821D7F2A5DB9B7881F805EC0_1831800759 = (this.mClass.compareTo(that.mClass));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int v;
        //v = this.mPackage.compareTo(that.mPackage);
        //if (v != 0) {
            //return v;
        //}
        //return this.mClass.compareTo(that.mClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.091 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.092 -0400", hash_original_method = "04D15992D5C44ACF00A97C758C27E164", hash_generated_method = "E761C4DFA6DD3908986E3C8AB3068CA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeString(mPackage);
        out.writeString(mClass);
        // ---------- Original Method ----------
        //out.writeString(mPackage);
        //out.writeString(mClass);
    }

    
        public static void writeToParcel(ComponentName c, Parcel out) {
        if (c != null) {
            c.writeToParcel(out, 0);
        } else {
            out.writeString(null);
        }
    }

    
        public static ComponentName readFromParcel(Parcel in) {
        String pkg = in.readString();
        return pkg != null ? new ComponentName(pkg, in) : null;
    }

    
    public static final Parcelable.Creator<ComponentName> CREATOR = new Parcelable.Creator<ComponentName>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.093 -0400", hash_original_method = "B8B6FA6877F2BC7297214F94718448AF", hash_generated_method = "2FB36AAFE4FE7922032163DCA35578F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ComponentName createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            ComponentName varC0786A824E00D35FE9B5D16E7F3ED84E_725566218 = (new ComponentName(in));
            return (ComponentName)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ComponentName(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.093 -0400", hash_original_method = "E4EFBA185D141B45B652C08AB65870BB", hash_generated_method = "B11DCBE745C3EC731F0B8BA6AD10F150")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ComponentName[] newArray(int size) {
            dsTaint.addTaint(size);
            ComponentName[] varB68F988C1D72E7A020BB1F5D90876BFA_2125405594 = (new ComponentName[size]);
            return (ComponentName[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ComponentName[size];
        }

        
}; //Transformed anonymous class
}

