package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public final class ComponentName implements Parcelable, Cloneable, Comparable<ComponentName> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.666 -0400", hash_original_field = "089616237F5DED8B7A7F9A618C4FC032", hash_generated_field = "D6E102019562022F9DE7C9915C7FD917")

    private String mPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.666 -0400", hash_original_field = "3C06167D41E761EA62261D0BFD22DD5C", hash_generated_field = "5E2CA74CC8E570ED6932C7E63B69D503")

    private String mClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.668 -0400", hash_original_method = "1714B1C8173E376D41E514F902D33E99", hash_generated_method = "7D9E77D2C93B078A228882B5CD43438C")
    public  ComponentName(String pkg, String cls) {
        if(pkg == null)        
        {
        NullPointerException varFE0969A81276D79040FEA03F940F203A_1808091113 = new NullPointerException("package name is null");
        varFE0969A81276D79040FEA03F940F203A_1808091113.addTaint(taint);
        throw varFE0969A81276D79040FEA03F940F203A_1808091113;
        }
        if(cls == null)        
        {
        NullPointerException var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_208727214 = new NullPointerException("class name is null");
        var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_208727214.addTaint(taint);
        throw var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_208727214;
        }
        mPackage = pkg;
        mClass = cls;
        // ---------- Original Method ----------
        //if (pkg == null) throw new NullPointerException("package name is null");
        //if (cls == null) throw new NullPointerException("class name is null");
        //mPackage = pkg;
        //mClass = cls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.669 -0400", hash_original_method = "36F25878FE380B4CEA8E7C4B89DDFC1A", hash_generated_method = "10C31D504A19968F933EB3EDC6954081")
    public  ComponentName(Context pkg, String cls) {
        if(cls == null)        
        {
        NullPointerException var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_538169781 = new NullPointerException("class name is null");
        var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_538169781.addTaint(taint);
        throw var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_538169781;
        }
        mPackage = pkg.getPackageName();
        mClass = cls;
        // ---------- Original Method ----------
        //if (cls == null) throw new NullPointerException("class name is null");
        //mPackage = pkg.getPackageName();
        //mClass = cls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.670 -0400", hash_original_method = "8AE00F6D12874A3382D28F364D43BAC6", hash_generated_method = "13D4875E5F4F3BF7BA85EDE233A1EC9A")
    public  ComponentName(Context pkg, Class<?> cls) {
        mPackage = pkg.getPackageName();
        mClass = cls.getName();
        // ---------- Original Method ----------
        //mPackage = pkg.getPackageName();
        //mClass = cls.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.671 -0400", hash_original_method = "85979238AB87BCF4845F6771314A5B1D", hash_generated_method = "2030FB27F58141C549B331CB6B4261AC")
    public  ComponentName(Parcel in) {
        mPackage = in.readString();
        if(mPackage == null)        
        {
        NullPointerException varFE0969A81276D79040FEA03F940F203A_1034454430 = new NullPointerException(
                "package name is null");
        varFE0969A81276D79040FEA03F940F203A_1034454430.addTaint(taint);
        throw varFE0969A81276D79040FEA03F940F203A_1034454430;
        }
        mClass = in.readString();
        if(mClass == null)        
        {
        NullPointerException var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_1477469681 = new NullPointerException(
                "class name is null");
        var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_1477469681.addTaint(taint);
        throw var7A7C3C4FBB11BAF6F0C2FFDA50940E9B_1477469681;
        }
        // ---------- Original Method ----------
        //mPackage = in.readString();
        //if (mPackage == null) throw new NullPointerException(
                //"package name is null");
        //mClass = in.readString();
        //if (mClass == null) throw new NullPointerException(
                //"class name is null");
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.672 -0400", hash_original_method = "5EFEBE9DDFB777526DBE0E9A79DAA5EE", hash_generated_method = "EF7C0113FB2FFBE69E1004B0C1942B83")
    private  ComponentName(String pkg, Parcel in) {
        mPackage = pkg;
        mClass = in.readString();
        // ---------- Original Method ----------
        //mPackage = pkg;
        //mClass = in.readString();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.673 -0400", hash_original_method = "0C586E8D4837845118D5ECAFE1DD23B0", hash_generated_method = "7282876A691E19953B7C9F855AD89A5B")
    public ComponentName clone() {
ComponentName var6C09C2B1BA5F965B795709781D6C0A40_1651853086 =         new ComponentName(mPackage, mClass);
        var6C09C2B1BA5F965B795709781D6C0A40_1651853086.addTaint(taint);
        return var6C09C2B1BA5F965B795709781D6C0A40_1651853086;
        // ---------- Original Method ----------
        //return new ComponentName(mPackage, mClass);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.674 -0400", hash_original_method = "89B4378559F402BEFD7FD434E355C3B4", hash_generated_method = "EAD29F51ABDBDD0CF2DFF30407E69957")
    public String getPackageName() {
String varD0D543EB218BC9E16C17B23C08BC19C7_124568323 =         mPackage;
        varD0D543EB218BC9E16C17B23C08BC19C7_124568323.addTaint(taint);
        return varD0D543EB218BC9E16C17B23C08BC19C7_124568323;
        // ---------- Original Method ----------
        //return mPackage;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.674 -0400", hash_original_method = "ABD4E1FA4C56F78B933D2E76ACF407D1", hash_generated_method = "E882C6CA99F845AA727F0DE95726DACA")
    public String getClassName() {
String var64662C86CFFE7A9599CD4183BD66D434_1568058077 =         mClass;
        var64662C86CFFE7A9599CD4183BD66D434_1568058077.addTaint(taint);
        return var64662C86CFFE7A9599CD4183BD66D434_1568058077;
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.675 -0400", hash_original_method = "1928B7DE815A138E651EC762B534B9EC", hash_generated_method = "358CE748002EADDD7C6C134578464055")
    public String getShortClassName() {
        if(mClass.startsWith(mPackage))        
        {
            int PN = mPackage.length();
            int CN = mClass.length();
            if(CN > PN && mClass.charAt(PN) == '.')            
            {
String var61E0CC22616EDC037CCA88CFEEED63C1_664373569 =                 mClass.substring(PN, CN);
                var61E0CC22616EDC037CCA88CFEEED63C1_664373569.addTaint(taint);
                return var61E0CC22616EDC037CCA88CFEEED63C1_664373569;
            } //End block
        } //End block
String var64662C86CFFE7A9599CD4183BD66D434_465881585 =         mClass;
        var64662C86CFFE7A9599CD4183BD66D434_465881585.addTaint(taint);
        return var64662C86CFFE7A9599CD4183BD66D434_465881585;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.675 -0400", hash_original_method = "390AD2AD67B7039AADEA1F7D4A32A2A2", hash_generated_method = "C1D23AAD1D45776F30D3F8132F31B7DD")
    public String flattenToString() {
String var06A4D852FFCAF88A29792FA49A49FE23_1129316789 =         mPackage + "/" + mClass;
        var06A4D852FFCAF88A29792FA49A49FE23_1129316789.addTaint(taint);
        return var06A4D852FFCAF88A29792FA49A49FE23_1129316789;
        // ---------- Original Method ----------
        //return mPackage + "/" + mClass;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.676 -0400", hash_original_method = "CF7AA080F36C0EC07816037C2C3C9C55", hash_generated_method = "1DE3B84D90D69A752392E022119E09E7")
    public String flattenToShortString() {
String var25046991B4E1F9743FF1F8E8BA0A59D6_1056664800 =         mPackage + "/" + getShortClassName();
        var25046991B4E1F9743FF1F8E8BA0A59D6_1056664800.addTaint(taint);
        return var25046991B4E1F9743FF1F8E8BA0A59D6_1056664800;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.677 -0400", hash_original_method = "7CD87B9188FFFCA76A5FF9BDC65CF37F", hash_generated_method = "9866B2768CC99C01620E72D7D02CDFFE")
    public String toShortString() {
String varB78D2BB45811B1D90493C7362E6C1AA5_1707585833 =         "{" + mPackage + "/" + mClass + "}";
        varB78D2BB45811B1D90493C7362E6C1AA5_1707585833.addTaint(taint);
        return varB78D2BB45811B1D90493C7362E6C1AA5_1707585833;
        // ---------- Original Method ----------
        //return "{" + mPackage + "/" + mClass + "}";
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.677 -0400", hash_original_method = "54FBA5D02AAB0DA35DA4E57242A769F6", hash_generated_method = "4B26A426C62828D22AD4834C54B0CF81")
    @Override
    public String toString() {
String var6AF44BA55BD7D20B537175E5DA6FC475_357204788 =         "ComponentInfo{" + mPackage + "/" + mClass + "}";
        var6AF44BA55BD7D20B537175E5DA6FC475_357204788.addTaint(taint);
        return var6AF44BA55BD7D20B537175E5DA6FC475_357204788;
        // ---------- Original Method ----------
        //return "ComponentInfo{" + mPackage + "/" + mClass + "}";
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.678 -0400", hash_original_method = "221E549665728B04A91E5C9A58326754", hash_generated_method = "B4B2D0E422E371550B03A3464E5983B4")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        try 
        {
            if(obj != null)            
            {
                ComponentName other = (ComponentName)obj;
                boolean var8356FA77320BBA68F01C6368164B064A_1858674242 = (mPackage.equals(other.mPackage)
                        && mClass.equals(other.mClass));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_542419454 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_542419454;
            } //End block
        } //End block
        catch (ClassCastException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1028956155 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908189857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_908189857;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.678 -0400", hash_original_method = "0BD278EA5D55E08CD4E56E53F182D0C7", hash_generated_method = "5E6171FC9F8CCED525B67D3D45C24894")
    @Override
    public int hashCode() {
        int varA766BC0F74A4F36D2BE433AA6AFBC472_1295393437 = (mPackage.hashCode() + mClass.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888484346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888484346;
        // ---------- Original Method ----------
        //return mPackage.hashCode() + mClass.hashCode();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.679 -0400", hash_original_method = "DB0D439501C0EAB456A0FFDB0A59DF6E", hash_generated_method = "B32DA57D0768792F16897D1F3617DFF7")
    public int compareTo(ComponentName that) {
        addTaint(that.getTaint());
        int v;
        v = this.mPackage.compareTo(that.mPackage);
        if(v != 0)        
        {
            int var9E3669D19B675BD57058FD4664205D2A_2019248977 = (v);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622798474 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622798474;
        } //End block
        int var534F582EB4C6FA9FE69DF28B050F2B6F_848657702 = (this.mClass.compareTo(that.mClass));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210740687 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210740687;
        // ---------- Original Method ----------
        //int v;
        //v = this.mPackage.compareTo(that.mPackage);
        //if (v != 0) {
            //return v;
        //}
        //return this.mClass.compareTo(that.mClass);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.679 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0D5BC1879E1D9C434EF7E44966C9A9FA")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1494538848 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702496479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702496479;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.680 -0400", hash_original_method = "04D15992D5C44ACF00A97C758C27E164", hash_generated_method = "0015459FF2A6FD18C92307902A2DCE54")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.681 -0400", hash_original_field = "8E5A903B6B4C2E2ACAA815E1E466E4D8", hash_generated_field = "B1DC8C107C69903EE7EB8EF6D1247DBB")

    public static final Parcelable.Creator<ComponentName> CREATOR
            = new Parcelable.Creator<ComponentName>() {
        public ComponentName createFromParcel(Parcel in) {
            return new ComponentName(in);
        }

        @DSModeled(DSC.SAFE)
        public ComponentName[] newArray(int size) {
            return new ComponentName[size];
        }
    };
    // orphaned legacy method
    public ComponentName createFromParcel(Parcel in) {
            return new ComponentName(in);
        }
    
    // orphaned legacy method
    public ComponentName[] newArray(int size) {
            return new ComponentName[size];
        }
    
}

