package javax.security.auth.x500;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.Principal;
import java.util.Map;

import org.apache.harmony.security.x501.Name;






public final class X500Principal implements Serializable, Principal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.061 -0400", hash_original_field = "567C996739EDFA1CDBAD4C55A80580DF", hash_generated_field = "CFC846905F9BAB769B1824279452E9D4")

    private transient Name dn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.061 -0400", hash_original_field = "3FD37E7C1754DA8004AB09E17AD51B85", hash_generated_field = "6B8880E941EC803BC6CC2DFD6A5E024B")

    private transient String canonicalName;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.071 -0400", hash_original_method = "A3047134DA2BBFDCD9EABEAC496A6A0D", hash_generated_method = "71C9B942FA13C6142F257D881FE648B3")
    public  X500Principal(byte[] name) {
        if(name == null)        
        {
            IllegalArgumentException var4611648A39111752F4444BE2F12A2156_79592633 = new IllegalArgumentException("Name cannot be null");
            var4611648A39111752F4444BE2F12A2156_79592633.addTaint(taint);
            throw var4611648A39111752F4444BE2F12A2156_79592633;
        } //End block
        try 
        {
            dn = (Name) Name.ASN1.decode(name);
        } //End block
        catch (IOException e)
        {
            java.lang.IllegalArgumentException varCBE615D094712B7C6E39025FB16B5668_1282160131 = incorrectInputEncoding(e);
            varCBE615D094712B7C6E39025FB16B5668_1282160131.addTaint(taint);
            throw varCBE615D094712B7C6E39025FB16B5668_1282160131;
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name cannot be null");
        //}
        //try {
            //dn = (Name) Name.ASN1.decode(name);
        //} catch (IOException e) {
            //throw incorrectInputEncoding(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.104 -0400", hash_original_method = "BF19E6A321D84C3196CD725DF225766B", hash_generated_method = "58D5451E864A7F45F3E14A584098CC86")
    public  X500Principal(InputStream in) {
        if(in == null)        
        {
            NullPointerException varF5E88630BAEB32AA1B2D44C55B908E4A_1100852188 = new NullPointerException("in == null");
            varF5E88630BAEB32AA1B2D44C55B908E4A_1100852188.addTaint(taint);
            throw varF5E88630BAEB32AA1B2D44C55B908E4A_1100852188;
        } //End block
        try 
        {
            dn = (Name) Name.ASN1.decode(in);
        } //End block
        catch (IOException e)
        {
            java.lang.IllegalArgumentException varCBE615D094712B7C6E39025FB16B5668_1727701994 = incorrectInputEncoding(e);
            varCBE615D094712B7C6E39025FB16B5668_1727701994.addTaint(taint);
            throw varCBE615D094712B7C6E39025FB16B5668_1727701994;
        } //End block
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new NullPointerException("in == null");
        //}
        //try {
            //dn = (Name) Name.ASN1.decode(in);
        //} catch (IOException e) {
            //throw incorrectInputEncoding(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.135 -0400", hash_original_method = "4B12F08D986FED39E34C8D26B1B878DE", hash_generated_method = "58C03B4E618301C756226F917093ECF9")
    public  X500Principal(String name) {
        if(name == null)        
        {
            NullPointerException varD55C34D141FD57420C78F6F4EB8B48E8_1975858802 = new NullPointerException("Name cannot be null");
            varD55C34D141FD57420C78F6F4EB8B48E8_1975858802.addTaint(taint);
            throw varD55C34D141FD57420C78F6F4EB8B48E8_1975858802;
        } //End block
        try 
        {
            dn = new Name(name);
        } //End block
        catch (IOException e)
        {
            java.lang.IllegalArgumentException varF3BA263C43D67A9C283EE45F1DF671F7_1020333256 = incorrectInputName(e, name);
            varF3BA263C43D67A9C283EE45F1DF671F7_1020333256.addTaint(taint);
            throw varF3BA263C43D67A9C283EE45F1DF671F7_1020333256;
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("Name cannot be null");
        //}
        //try {
            //dn = new Name(name);
        //} catch (IOException e) {
            //throw incorrectInputName(e, name);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.152 -0400", hash_original_method = "2009C8B3D7F2D72E316D77325E1D8621", hash_generated_method = "46ACB32B13BD47CB01CB8C661672C48A")
    public  X500Principal(String name, Map<String,String> keywordMap) {
        if(name == null)        
        {
            NullPointerException varD55C34D141FD57420C78F6F4EB8B48E8_1992296771 = new NullPointerException("Name cannot be null");
            varD55C34D141FD57420C78F6F4EB8B48E8_1992296771.addTaint(taint);
            throw varD55C34D141FD57420C78F6F4EB8B48E8_1992296771;
        } //End block
        try 
        {
            dn = new Name(substituteNameFromMap(name, keywordMap));
        } //End block
        catch (IOException e)
        {
            java.lang.IllegalArgumentException varF3BA263C43D67A9C283EE45F1DF671F7_1068229304 = incorrectInputName(e, name);
            varF3BA263C43D67A9C283EE45F1DF671F7_1068229304.addTaint(taint);
            throw varF3BA263C43D67A9C283EE45F1DF671F7_1068229304;
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("Name cannot be null");
        //}
        //try {
            //dn = new Name(substituteNameFromMap(name, keywordMap));
        //} catch (IOException e) {
            //throw incorrectInputName(e, name);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.153 -0400", hash_original_method = "9E8384C79D62223409840D75AB5AB58E", hash_generated_method = "09EFF356EBDF39DF087EF8EC087C4E14")
    private IllegalArgumentException incorrectInputEncoding(IOException e) {
        addTaint(e.getTaint());
        IllegalArgumentException iae = new IllegalArgumentException("Incorrect input encoding");
        iae.initCause(e);
        iae.addTaint(taint);
        throw iae;
        // ---------- Original Method ----------
        //IllegalArgumentException iae = new IllegalArgumentException("Incorrect input encoding");
        //iae.initCause(e);
        //throw iae;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.154 -0400", hash_original_method = "6436965683334E035C1CE670538AE7C6", hash_generated_method = "ABDA72E7CBEFE08540F89AF93F018AF2")
    private IllegalArgumentException incorrectInputName(IOException e, String name) {
        addTaint(name.getTaint());
        addTaint(e.getTaint());
        IllegalArgumentException iae = new IllegalArgumentException("Incorrect input name:" + name);
        iae.initCause(e);
        iae.addTaint(taint);
        throw iae;
        // ---------- Original Method ----------
        //IllegalArgumentException iae = new IllegalArgumentException("Incorrect input name:" + name);
        //iae.initCause(e);
        //throw iae;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.154 -0400", hash_original_method = "4587ED52F7AA726C7418DB94B8315A23", hash_generated_method = "7661A1D74C9E8F17648EC4CB2286CF6F")
    private synchronized String getCanonicalName() {
        if(canonicalName == null)        
        {
            canonicalName = dn.getName(CANONICAL);
        } //End block
String var7E150FCC7E02D69327EC2754E827BBC0_1762934192 =         canonicalName;
        var7E150FCC7E02D69327EC2754E827BBC0_1762934192.addTaint(taint);
        return var7E150FCC7E02D69327EC2754E827BBC0_1762934192;
        // ---------- Original Method ----------
        //if (canonicalName == null) {
            //canonicalName = dn.getName(CANONICAL);
        //}
        //return canonicalName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.155 -0400", hash_original_method = "16164FE0EFFEA9276C58202163E56457", hash_generated_method = "398DB588BA1D39F2DE958FDAF526ACDA")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_589956096 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115347247 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115347247;
        } //End block
        if(o == null || this.getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_2040916446 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1430609959 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1430609959;
        } //End block
        X500Principal principal = (X500Principal) o;
        boolean varBFB080AED0E2AF7359E60DC9CCF7D15B_1161901849 = (getCanonicalName().equals(principal.getCanonicalName()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894473254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_894473254;
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (o == null || this.getClass() != o.getClass()) {
            //return false;
        //}
        //X500Principal principal = (X500Principal) o;
        //return getCanonicalName().equals(principal.getCanonicalName());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.155 -0400", hash_original_method = "0D44433D57FF4BE42B367E2D93A9CEDF", hash_generated_method = "9F18D801B0D0BD88AE619CA61F782458")
    public byte[] getEncoded() {
        byte[] src = dn.getEncoded();
        byte[] dst = new byte[src.length];
        System.arraycopy(src, 0, dst, 0, dst.length);
        byte[] var28E3D688A3C077B887921CEA3FB1DBC7_2009735962 = (dst);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1660523616 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1660523616;
        // ---------- Original Method ----------
        //byte[] src = dn.getEncoded();
        //byte[] dst = new byte[src.length];
        //System.arraycopy(src, 0, dst, 0, dst.length);
        //return dst;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.156 -0400", hash_original_method = "2BCB4CFF6EEF485C6E2E6569B64BAD8B", hash_generated_method = "4273AAC63D413CCEF795547A25ED6BDE")
    public String getName() {
String var08F6DAD71EC6EDB0BE0363A140D3B809_1700881439 =         dn.getName(RFC2253);
        var08F6DAD71EC6EDB0BE0363A140D3B809_1700881439.addTaint(taint);
        return var08F6DAD71EC6EDB0BE0363A140D3B809_1700881439;
        // ---------- Original Method ----------
        //return dn.getName(RFC2253);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.156 -0400", hash_original_method = "DC6B95F939C1817F13ECF66B400795F1", hash_generated_method = "49BC7B1AFF94CF4D7BFC4963970F9F22")
    public String getName(String format) {
        addTaint(format.getTaint());
        if(CANONICAL.equals(format))        
        {
String var1C29F95F65985963179EA1C2D95D2CEA_1561629300 =             getCanonicalName();
            var1C29F95F65985963179EA1C2D95D2CEA_1561629300.addTaint(taint);
            return var1C29F95F65985963179EA1C2D95D2CEA_1561629300;
        } //End block
String var2D5D2E4F12D8C4AC82C9F6D97E3483B0_2093643254 =         dn.getName(format);
        var2D5D2E4F12D8C4AC82C9F6D97E3483B0_2093643254.addTaint(taint);
        return var2D5D2E4F12D8C4AC82C9F6D97E3483B0_2093643254;
        // ---------- Original Method ----------
        //if (CANONICAL.equals(format)) {
            //return getCanonicalName();
        //}
        //return dn.getName(format);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.158 -0400", hash_original_method = "F26EAC27584EEA69A397CAF64D802897", hash_generated_method = "46A315B808E3D9A75BEAD7C6CFA67334")
    public String getName(String format, Map<String, String> oidMap) {
        addTaint(oidMap.getTaint());
        addTaint(format.getTaint());
        String rfc1779Name = dn.getName(RFC1779);
        String rfc2253Name = dn.getName(RFC2253);
        if(format.equalsIgnoreCase("RFC1779"))        
        {
            StringBuilder resultName = new StringBuilder(rfc1779Name);
            int fromIndex = resultName.length();
            int equalIndex = -1;
            while
(-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex)))            
            {
                int commaIndex = resultName.lastIndexOf(",", equalIndex);
                String subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                if(subName.length() > 4
                        && subName.substring(0, 4).equals("OID."))                
                {
                    String subSubName = subName.substring(4);
                    if(oidMap.containsKey(subSubName))                    
                    {
                        String replaceName = oidMap.get(subSubName);
                        if(commaIndex > 0)                        
                        replaceName = " " + replaceName;
                        resultName.replace(commaIndex + 1, equalIndex, replaceName);
                    } //End block
                } //End block
                fromIndex = commaIndex;
            } //End block
String var3318B6470F204095A1A93B089A3A90B2_13211977 =             resultName.toString();
            var3318B6470F204095A1A93B089A3A90B2_13211977.addTaint(taint);
            return var3318B6470F204095A1A93B089A3A90B2_13211977;
        } //End block
        else
        if(format.equalsIgnoreCase("RFC2253"))        
        {
            StringBuilder resultName = new StringBuilder(rfc2253Name);
            StringBuilder subsidyName = new StringBuilder(rfc1779Name);
            int fromIndex = resultName.length();
            int subsidyFromIndex = subsidyName.length();
            int equalIndex = -1;
            int subsidyEqualIndex = -1;
            while
(-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex)))            
            {
                subsidyEqualIndex = subsidyName.lastIndexOf("=",
                        subsidyFromIndex);
                int commaIndex = resultName.lastIndexOf(",", equalIndex);
                String subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                if(oidMap.containsKey(subName))                
                {
                    int subOrignalEndIndex = resultName
                            .indexOf(",", equalIndex);
                    if(subOrignalEndIndex == -1)                    
                    subOrignalEndIndex = resultName.length();
                    int subGoalEndIndex = subsidyName.indexOf(",",
                            subsidyEqualIndex);
                    if(subGoalEndIndex == -1)                    
                    subGoalEndIndex = subsidyName.length();
                    resultName.replace(equalIndex + 1, subOrignalEndIndex,
                            subsidyName.substring(subsidyEqualIndex + 1,
                                    subGoalEndIndex));
                    resultName.replace(commaIndex + 1, equalIndex, oidMap
                            .get(subName));
                } //End block
                fromIndex = commaIndex;
                subsidyFromIndex = subsidyEqualIndex - 1;
            } //End block
String var3318B6470F204095A1A93B089A3A90B2_888095840 =             resultName.toString();
            var3318B6470F204095A1A93B089A3A90B2_888095840.addTaint(taint);
            return var3318B6470F204095A1A93B089A3A90B2_888095840;
        } //End block
        else
        {
            IllegalArgumentException varF9C22D5169D99F66FED780168FB8177D_1997216476 = new IllegalArgumentException("invalid format specified: " + format);
            varF9C22D5169D99F66FED780168FB8177D_1997216476.addTaint(taint);
            throw varF9C22D5169D99F66FED780168FB8177D_1997216476;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.159 -0400", hash_original_method = "4EF4800FE4F6884E38EE2C97450FA744", hash_generated_method = "8716BD0635B04ED690B812DA8CA7C2EE")
    @Override
    public int hashCode() {
        int varCA006599DDB1EBBCCF1A331311F932D0_1941132940 = (getCanonicalName().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088744868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088744868;
        // ---------- Original Method ----------
        //return getCanonicalName().hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.160 -0400", hash_original_method = "FEC69921702EBFC3E3DC123C0BE46430", hash_generated_method = "DF2098F70B86518100FD273BFAE6AAC2")
    @Override
    public String toString() {
String var04328ADBCE8325DAA95AEC1783AFD17A_455315863 =         dn.getName(RFC1779);
        var04328ADBCE8325DAA95AEC1783AFD17A_455315863.addTaint(taint);
        return var04328ADBCE8325DAA95AEC1783AFD17A_455315863;
        // ---------- Original Method ----------
        //return dn.getName(RFC1779);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.160 -0400", hash_original_method = "11CA04BE900A069B4C6C484CD5BEB982", hash_generated_method = "8FB4070FC90A2E7E6893E0A4FF922ED6")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeObject(dn.getEncoded());
        // ---------- Original Method ----------
        //out.writeObject(dn.getEncoded());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.160 -0400", hash_original_method = "8759D8976B48D4CB6209F3200BF3598B", hash_generated_method = "152ACDA71726E5032041ABE752F2EA68")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
        // ---------- Original Method ----------
        //dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.161 -0400", hash_original_method = "84EFD5BFB0134499160A2521897988D3", hash_generated_method = "C09F354362013FCF1AD51629340FE853")
    private String substituteNameFromMap(String name, Map<String, String> keywordMap) {
        addTaint(keywordMap.getTaint());
        addTaint(name.getTaint());
        StringBuilder sbName = new StringBuilder(name);
        int fromIndex = sbName.length();
        int equalIndex;
        while
(-1 != (equalIndex = sbName.lastIndexOf("=", fromIndex)))        
        {
            int commaIndex = sbName.lastIndexOf(",", equalIndex);
            String subName = sbName.substring(commaIndex + 1, equalIndex).trim();
            if(keywordMap.containsKey(subName))            
            {
                sbName.replace(commaIndex + 1, equalIndex, keywordMap.get(subName));
            } //End block
            fromIndex = commaIndex;
        } //End block
String var25FABEFC42C74DDAF545088033E64C8D_1580736073 =         sbName.toString();
        var25FABEFC42C74DDAF545088033E64C8D_1580736073.addTaint(taint);
        return var25FABEFC42C74DDAF545088033E64C8D_1580736073;
        // ---------- Original Method ----------
        //StringBuilder sbName = new StringBuilder(name);
        //int fromIndex = sbName.length();
        //int equalIndex;
        //while (-1 != (equalIndex = sbName.lastIndexOf("=", fromIndex))) {
            //int commaIndex = sbName.lastIndexOf(",", equalIndex);
            //String subName = sbName.substring(commaIndex + 1, equalIndex).trim();
            //if (keywordMap.containsKey(subName)) {
                //sbName.replace(commaIndex + 1, equalIndex, keywordMap.get(subName));
            //}
            //fromIndex = commaIndex;
        //}
        //return sbName.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.161 -0400", hash_original_field = "8DD0850A45DD8279208B0A47E4970B1B", hash_generated_field = "26CAD3B6FC0EACF2E9B47D2D50E32979")

    private static final long serialVersionUID = -500463348111345721L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.161 -0400", hash_original_field = "43F9C433C6C27576D56B459CD29942CC", hash_generated_field = "82CE65EBAABC70666F50B8A10883BA7F")

    public static final String CANONICAL = "CANONICAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.161 -0400", hash_original_field = "E56BCDB17498A8325666AA28E444D830", hash_generated_field = "DBAC8AB28BADF6FBFEEA44C4163EFD9F")

    public static final String RFC1779 = "RFC1779";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.161 -0400", hash_original_field = "2A20ED380CA46C19AFB99FB1EE259E06", hash_generated_field = "C120F901C78A5D9CE52D3BC1A7B434D8")

    public static final String RFC2253 = "RFC2253";
}

