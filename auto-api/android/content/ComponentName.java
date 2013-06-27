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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.372 -0400", hash_original_field = "089616237F5DED8B7A7F9A618C4FC032", hash_generated_field = "D6E102019562022F9DE7C9915C7FD917")

    private String mPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.372 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "5E2CA74CC8E570ED6932C7E63B69D503")

    private String mClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.373 -0400", hash_original_method = "1714B1C8173E376D41E514F902D33E99", hash_generated_method = "AE87946FCDE3FD8D905AEE2CE80271AA")
    public  ComponentName(String pkg, String cls) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("package name is null");
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("class name is null");
        mPackage = pkg;
        mClass = cls;
        // ---------- Original Method ----------
        //if (pkg == null) throw new NullPointerException("package name is null");
        //if (cls == null) throw new NullPointerException("class name is null");
        //mPackage = pkg;
        //mClass = cls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.374 -0400", hash_original_method = "36F25878FE380B4CEA8E7C4B89DDFC1A", hash_generated_method = "8899488BB1B0D6914F3C0D43DB715576")
    public  ComponentName(Context pkg, String cls) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("class name is null");
        mPackage = pkg.getPackageName();
        mClass = cls;
        // ---------- Original Method ----------
        //if (cls == null) throw new NullPointerException("class name is null");
        //mPackage = pkg.getPackageName();
        //mClass = cls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.375 -0400", hash_original_method = "8AE00F6D12874A3382D28F364D43BAC6", hash_generated_method = "13D4875E5F4F3BF7BA85EDE233A1EC9A")
    public  ComponentName(Context pkg, Class<?> cls) {
        mPackage = pkg.getPackageName();
        mClass = cls.getName();
        // ---------- Original Method ----------
        //mPackage = pkg.getPackageName();
        //mClass = cls.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.376 -0400", hash_original_method = "85979238AB87BCF4845F6771314A5B1D", hash_generated_method = "A88DE96E3E1AA0A2C7F15C61F9CB2D89")
    public  ComponentName(Parcel in) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.377 -0400", hash_original_method = "5EFEBE9DDFB777526DBE0E9A79DAA5EE", hash_generated_method = "EF7C0113FB2FFBE69E1004B0C1942B83")
    private  ComponentName(String pkg, Parcel in) {
        mPackage = pkg;
        mClass = in.readString();
        // ---------- Original Method ----------
        //mPackage = pkg;
        //mClass = in.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.396 -0400", hash_original_method = "0C586E8D4837845118D5ECAFE1DD23B0", hash_generated_method = "6622CA72C8B37B3F924464711A29F17F")
    public ComponentName clone() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1125940898 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1125940898 = new ComponentName(mPackage, mClass);
        varB4EAC82CA7396A68D541C85D26508E83_1125940898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1125940898;
        // ---------- Original Method ----------
        //return new ComponentName(mPackage, mClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.397 -0400", hash_original_method = "89B4378559F402BEFD7FD434E355C3B4", hash_generated_method = "361FF668164902C749FC0D7DFF43BA7A")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1330762979 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1330762979 = mPackage;
        varB4EAC82CA7396A68D541C85D26508E83_1330762979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1330762979;
        // ---------- Original Method ----------
        //return mPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.406 -0400", hash_original_method = "ABD4E1FA4C56F78B933D2E76ACF407D1", hash_generated_method = "483EE678EA3D0EB0B5B736E56AA10BC3")
    public String getClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_417489310 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_417489310 = mClass;
        varB4EAC82CA7396A68D541C85D26508E83_417489310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_417489310;
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.424 -0400", hash_original_method = "1928B7DE815A138E651EC762B534B9EC", hash_generated_method = "BE7F4913B768E8C45DDA92584BC7A8AE")
    public String getShortClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1317260187 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1551164832 = null; //Variable for return #2
        {
            boolean var8791F3C1D7BA53F557592F67D168B096_1747804727 = (mClass.startsWith(mPackage));
            {
                int PN;
                PN = mPackage.length();
                int CN;
                CN = mClass.length();
                {
                    boolean var358F7397C8EC103C9FA8376FFDCED82F_244965011 = (CN > PN && mClass.charAt(PN) == '.');
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1317260187 = mClass.substring(PN, CN);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1551164832 = mClass;
        String varA7E53CE21691AB073D9660D615818899_595893953; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_595893953 = varB4EAC82CA7396A68D541C85D26508E83_1317260187;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_595893953 = varB4EAC82CA7396A68D541C85D26508E83_1551164832;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_595893953.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_595893953;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.426 -0400", hash_original_method = "390AD2AD67B7039AADEA1F7D4A32A2A2", hash_generated_method = "69F3083EDA3667986DA85C4A943F2C45")
    public String flattenToString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2003383717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2003383717 = mPackage + "/" + mClass;
        varB4EAC82CA7396A68D541C85D26508E83_2003383717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2003383717;
        // ---------- Original Method ----------
        //return mPackage + "/" + mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.451 -0400", hash_original_method = "CF7AA080F36C0EC07816037C2C3C9C55", hash_generated_method = "30693837250017B761B17FAF5993AB47")
    public String flattenToShortString() {
        String varB4EAC82CA7396A68D541C85D26508E83_435577072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_435577072 = mPackage + "/" + getShortClassName();
        varB4EAC82CA7396A68D541C85D26508E83_435577072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_435577072;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.460 -0400", hash_original_method = "7CD87B9188FFFCA76A5FF9BDC65CF37F", hash_generated_method = "6BDAFE2AFE84DD0873A6CA3C627B1331")
    public String toShortString() {
        String varB4EAC82CA7396A68D541C85D26508E83_80809711 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_80809711 = "{" + mPackage + "/" + mClass + "}";
        varB4EAC82CA7396A68D541C85D26508E83_80809711.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_80809711;
        // ---------- Original Method ----------
        //return "{" + mPackage + "/" + mClass + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.462 -0400", hash_original_method = "54FBA5D02AAB0DA35DA4E57242A769F6", hash_generated_method = "89B37A487A66394480E8638EF9FFA298")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1078263517 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1078263517 = "ComponentInfo{" + mPackage + "/" + mClass + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1078263517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1078263517;
        // ---------- Original Method ----------
        //return "ComponentInfo{" + mPackage + "/" + mClass + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.463 -0400", hash_original_method = "221E549665728B04A91E5C9A58326754", hash_generated_method = "C5F2787C3B9F3DE9B7759B16526F09BB")
    @Override
    public boolean equals(Object obj) {
        try 
        {
            {
                ComponentName other;
                other = (ComponentName)obj;
                boolean var36C27DE2882E82617D9C990E849A569D_908906853 = (mPackage.equals(other.mPackage)
                        && mClass.equals(other.mClass));
            } //End block
        } //End block
        catch (ClassCastException e)
        { }
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663877875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_663877875;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.464 -0400", hash_original_method = "0BD278EA5D55E08CD4E56E53F182D0C7", hash_generated_method = "A62DF79AEFF0D3645456CB9D34153FFC")
    @Override
    public int hashCode() {
        int varBEE63132B8B98B94DDD6E03EDEC851FF_817226387 = (mPackage.hashCode() + mClass.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514043528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514043528;
        // ---------- Original Method ----------
        //return mPackage.hashCode() + mClass.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.488 -0400", hash_original_method = "DB0D439501C0EAB456A0FFDB0A59DF6E", hash_generated_method = "43280D20B3738188889359E3E11F631C")
    public int compareTo(ComponentName that) {
        int v;
        v = this.mPackage.compareTo(that.mPackage);
        int varFDFA92AC821D7F2A5DB9B7881F805EC0_912353463 = (this.mClass.compareTo(that.mClass));
        addTaint(that.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514531776 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514531776;
        // ---------- Original Method ----------
        //int v;
        //v = this.mPackage.compareTo(that.mPackage);
        //if (v != 0) {
            //return v;
        //}
        //return this.mClass.compareTo(that.mClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.489 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "EBAD53A29791F8C1ADAA05F1868715B9")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704271114 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704271114;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.490 -0400", hash_original_method = "04D15992D5C44ACF00A97C758C27E164", hash_generated_method = "630C8C053DB6FF462FB381AB3CD78527")
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mPackage);
        out.writeString(mClass);
        addTaint(out.getTaint());
        addTaint(flags);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.506 -0400", hash_original_field = "8E5A903B6B4C2E2ACAA815E1E466E4D8", hash_generated_field = "B1DC8C107C69903EE7EB8EF6D1247DBB")

    public static final Parcelable.Creator<ComponentName> CREATOR
            = new Parcelable.Creator<ComponentName>() {
        public ComponentName createFromParcel(Parcel in) {
            return new ComponentName(in);
        }

        public ComponentName[] newArray(int size) {
            return new ComponentName[size];
        }
    };
}

