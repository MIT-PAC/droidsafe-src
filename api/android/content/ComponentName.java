package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.Comparable;

public final class ComponentName implements Parcelable, Cloneable, Comparable<ComponentName> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.347 -0400", hash_original_field = "089616237F5DED8B7A7F9A618C4FC032", hash_generated_field = "D6E102019562022F9DE7C9915C7FD917")

    private String mPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.347 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "5E2CA74CC8E570ED6932C7E63B69D503")

    private String mClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.348 -0400", hash_original_method = "1714B1C8173E376D41E514F902D33E99", hash_generated_method = "970A1BDD440765D358CB946181343676")
    public  ComponentName(String pkg, String cls) {
    if(pkg == null)        
        {
        NullPointerException varFE0969A81276D79040FEA03F940F203A_55625047 = new NullPointerException("package name is null");
        varFE0969A81276D79040FEA03F940F203A_55625047.addTaint(taint);
        throw varFE0969A81276D79040FEA03F940F203A_55625047;
        }
    if(cls == null)        
        {
        NullPointerException var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_1036466083 = new NullPointerException("class name is null");
        var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_1036466083.addTaint(taint);
        throw var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_1036466083;
        }
        mPackage = pkg;
        mClass = cls;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.349 -0400", hash_original_method = "36F25878FE380B4CEA8E7C4B89DDFC1A", hash_generated_method = "B0533EBB297F9DEF927F6F45F7090515")
    public  ComponentName(Context pkg, String cls) {
    if(cls == null)        
        {
        NullPointerException var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_108730871 = new NullPointerException("class name is null");
        var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_108730871.addTaint(taint);
        throw var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_108730871;
        }
        mPackage = pkg.getPackageName();
        mClass = cls;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.350 -0400", hash_original_method = "8AE00F6D12874A3382D28F364D43BAC6", hash_generated_method = "13D4875E5F4F3BF7BA85EDE233A1EC9A")
    public  ComponentName(Context pkg, Class<?> cls) {
        mPackage = pkg.getPackageName();
        mClass = cls.getName();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.351 -0400", hash_original_method = "85979238AB87BCF4845F6771314A5B1D", hash_generated_method = "663C7043C1D4D9EDF0FD5FD11774116B")
    public  ComponentName(Parcel in) {
        mPackage = in.readString();
    if(mPackage == null)        
        {
        NullPointerException varFE0969A81276D79040FEA03F940F203A_1922573572 = new NullPointerException(
                "package name is null");
        varFE0969A81276D79040FEA03F940F203A_1922573572.addTaint(taint);
        throw varFE0969A81276D79040FEA03F940F203A_1922573572;
        }
        mClass = in.readString();
    if(mClass == null)        
        {
        NullPointerException var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_1297742497 = new NullPointerException(
                "class name is null");
        var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_1297742497.addTaint(taint);
        throw var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_1297742497;
        }
        
        
        
                
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.352 -0400", hash_original_method = "5EFEBE9DDFB777526DBE0E9A79DAA5EE", hash_generated_method = "EF7C0113FB2FFBE69E1004B0C1942B83")
    private  ComponentName(String pkg, Parcel in) {
        mPackage = pkg;
        mClass = in.readString();
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.352 -0400", hash_original_method = "0C586E8D4837845118D5ECAFE1DD23B0", hash_generated_method = "2D5199C3EDC59A2443DBB0E900B9D773")
    public ComponentName clone() {
ComponentName var6C09C2B1BA5F965B795709781D6C0A40_252668599 =         new ComponentName(mPackage, mClass);
        var6C09C2B1BA5F965B795709781D6C0A40_252668599.addTaint(taint);
        return var6C09C2B1BA5F965B795709781D6C0A40_252668599;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.353 -0400", hash_original_method = "89B4378559F402BEFD7FD434E355C3B4", hash_generated_method = "B7216F2A7D1D43B81E0D922656424BAC")
    public String getPackageName() {
String varD0D543EB218BC9E16C17B23C08BC19C7_46339205 =         mPackage;
        varD0D543EB218BC9E16C17B23C08BC19C7_46339205.addTaint(taint);
        return varD0D543EB218BC9E16C17B23C08BC19C7_46339205;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.354 -0400", hash_original_method = "ABD4E1FA4C56F78B933D2E76ACF407D1", hash_generated_method = "8A0440C1A5E2719F2CD9FC914B79AB41")
    public String getClassName() {
String var64662C86CFFE7A9599CD4183BD66D434_1978471194 =         mClass;
        var64662C86CFFE7A9599CD4183BD66D434_1978471194.addTaint(taint);
        return var64662C86CFFE7A9599CD4183BD66D434_1978471194;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.355 -0400", hash_original_method = "1928B7DE815A138E651EC762B534B9EC", hash_generated_method = "248553551F1C53921548297F9A394E82")
    public String getShortClassName() {
    if(mClass.startsWith(mPackage))        
        {
            int PN = mPackage.length();
            int CN = mClass.length();
    if(CN > PN && mClass.charAt(PN) == '.')            
            {
String var61E0CC22616EDC037CCA88CFEEED63C1_550039603 =                 mClass.substring(PN, CN);
                var61E0CC22616EDC037CCA88CFEEED63C1_550039603.addTaint(taint);
                return var61E0CC22616EDC037CCA88CFEEED63C1_550039603;
            } 
        } 
String var64662C86CFFE7A9599CD4183BD66D434_471093956 =         mClass;
        var64662C86CFFE7A9599CD4183BD66D434_471093956.addTaint(taint);
        return var64662C86CFFE7A9599CD4183BD66D434_471093956;
        
        
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.355 -0400", hash_original_method = "390AD2AD67B7039AADEA1F7D4A32A2A2", hash_generated_method = "7C621764D0635D1826932945E091877A")
    public String flattenToString() {
String var06A4D852FFCAF88A29792FA49A49FE23_353153014 =         mPackage + "/" + mClass;
        var06A4D852FFCAF88A29792FA49A49FE23_353153014.addTaint(taint);
        return var06A4D852FFCAF88A29792FA49A49FE23_353153014;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.356 -0400", hash_original_method = "CF7AA080F36C0EC07816037C2C3C9C55", hash_generated_method = "4111C9EAFAB8C8C9BC5BC8AAD2D083FC")
    public String flattenToShortString() {
String var25046991B4E1F9743FF1F8E8BA0A59D6_2048536845 =         mPackage + "/" + getShortClassName();
        var25046991B4E1F9743FF1F8E8BA0A59D6_2048536845.addTaint(taint);
        return var25046991B4E1F9743FF1F8E8BA0A59D6_2048536845;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.357 -0400", hash_original_method = "7CD87B9188FFFCA76A5FF9BDC65CF37F", hash_generated_method = "70A870FF344A2C8F82F6191FC06FB7AC")
    public String toShortString() {
String varB78D2BB45811B1D90493C7362E6C1AA5_965692711 =         "{" + mPackage + "/" + mClass + "}";
        varB78D2BB45811B1D90493C7362E6C1AA5_965692711.addTaint(taint);
        return varB78D2BB45811B1D90493C7362E6C1AA5_965692711;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.357 -0400", hash_original_method = "54FBA5D02AAB0DA35DA4E57242A769F6", hash_generated_method = "B591990818C47547CC535219CA60A63A")
    @Override
    public String toString() {
String var6AF44BA55BD7D20B537175E5DA6FC475_609710672 =         "ComponentInfo{" + mPackage + "/" + mClass + "}";
        var6AF44BA55BD7D20B537175E5DA6FC475_609710672.addTaint(taint);
        return var6AF44BA55BD7D20B537175E5DA6FC475_609710672;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.358 -0400", hash_original_method = "221E549665728B04A91E5C9A58326754", hash_generated_method = "3B09C02386C7F15C6DDEA7D903DB43A4")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        try 
        {
    if(obj != null)            
            {
                ComponentName other = (ComponentName)obj;
                boolean var8356FA77320BBA68F01C6368164B064A_2012915370 = (mPackage.equals(other.mPackage)
                        && mClass.equals(other.mClass));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25393803 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_25393803;
            } 
        } 
        catch (ClassCastException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_840917900 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1574646756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1574646756;
        
        
            
                
                
                        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.359 -0400", hash_original_method = "0BD278EA5D55E08CD4E56E53F182D0C7", hash_generated_method = "EA58D47E5D85EAFB6F8200BB332FDD10")
    @Override
    public int hashCode() {
        int varA766BC0F74A4F36D2BE433AA6AFBC472_1412420647 = (mPackage.hashCode() + mClass.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568619178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568619178;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.359 -0400", hash_original_method = "DB0D439501C0EAB456A0FFDB0A59DF6E", hash_generated_method = "07A464F114F872C7ECEF3D2EE243FDE5")
    public int compareTo(ComponentName that) {
        addTaint(that.getTaint());
        int v;
        v = this.mPackage.compareTo(that.mPackage);
    if(v != 0)        
        {
            int var9E3669D19B675BD57058FD4664205D2A_1034059292 = (v);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410389113 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410389113;
        } 
        int var534F582EB4C6FA9FE69DF28B050F2B6F_250652218 = (this.mClass.compareTo(that.mClass));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130144743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130144743;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.360 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "31DE1383E04D7A91CB75F43DDB516BFC")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_970800487 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331495961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331495961;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.360 -0400", hash_original_method = "04D15992D5C44ACF00A97C758C27E164", hash_generated_method = "0015459FF2A6FD18C92307902A2DCE54")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeString(mPackage);
        out.writeString(mClass);
        
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.361 -0400", hash_original_field = "8E5A903B6B4C2E2ACAA815E1E466E4D8", hash_generated_field = "B1DC8C107C69903EE7EB8EF6D1247DBB")

    public static final Parcelable.Creator<ComponentName> CREATOR
            = new Parcelable.Creator<ComponentName>() {
        public ComponentName createFromParcel(Parcel in) {
            return new ComponentName(in);
        }

        public ComponentName[] newArray(int size) {
            return new ComponentName[size];
        }
    };
    
    public ComponentName createFromParcel(Parcel in) {
            return new ComponentName(in);
        }
    
    
    public ComponentName[] newArray(int size) {
            return new ComponentName[size];
        }
    
}

