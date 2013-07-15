package javax.security.auth.x500;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.Principal;
import java.util.Map;
import org.apache.harmony.security.x501.Name;

public final class X500Principal implements Serializable, Principal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.201 -0400", hash_original_field = "567C996739EDFA1CDBAD4C55A80580DF", hash_generated_field = "CFC846905F9BAB769B1824279452E9D4")

    private transient Name dn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.201 -0400", hash_original_field = "3FD37E7C1754DA8004AB09E17AD51B85", hash_generated_field = "6B8880E941EC803BC6CC2DFD6A5E024B")

    private transient String canonicalName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.204 -0400", hash_original_method = "A3047134DA2BBFDCD9EABEAC496A6A0D", hash_generated_method = "BBE310B73D8A96B59CB31589263E9685")
    public  X500Principal(byte[] name) {
    if(name == null)        
        {
            IllegalArgumentException var4611648A39111752F4444BE2F12A2156_418841863 = new IllegalArgumentException("Name cannot be null");
            var4611648A39111752F4444BE2F12A2156_418841863.addTaint(taint);
            throw var4611648A39111752F4444BE2F12A2156_418841863;
        } //End block
        try 
        {
            dn = (Name) Name.ASN1.decode(name);
        } //End block
        catch (IOException e)
        {
            java.lang.IllegalArgumentException varCBE615D094712B7C6E39025FB16B5668_1295602942 = incorrectInputEncoding(e);
            varCBE615D094712B7C6E39025FB16B5668_1295602942.addTaint(taint);
            throw varCBE615D094712B7C6E39025FB16B5668_1295602942;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.208 -0400", hash_original_method = "BF19E6A321D84C3196CD725DF225766B", hash_generated_method = "044C3FEBA5188538E6D68CE7A06F2CB6")
    public  X500Principal(InputStream in) {
    if(in == null)        
        {
            NullPointerException varF5E88630BAEB32AA1B2D44C55B908E4A_1432374836 = new NullPointerException("in == null");
            varF5E88630BAEB32AA1B2D44C55B908E4A_1432374836.addTaint(taint);
            throw varF5E88630BAEB32AA1B2D44C55B908E4A_1432374836;
        } //End block
        try 
        {
            dn = (Name) Name.ASN1.decode(in);
        } //End block
        catch (IOException e)
        {
            java.lang.IllegalArgumentException varCBE615D094712B7C6E39025FB16B5668_1952465625 = incorrectInputEncoding(e);
            varCBE615D094712B7C6E39025FB16B5668_1952465625.addTaint(taint);
            throw varCBE615D094712B7C6E39025FB16B5668_1952465625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.211 -0400", hash_original_method = "4B12F08D986FED39E34C8D26B1B878DE", hash_generated_method = "7B198095A78382D56F14D483F5A9EC96")
    public  X500Principal(String name) {
    if(name == null)        
        {
            NullPointerException varD55C34D141FD57420C78F6F4EB8B48E8_381408716 = new NullPointerException("Name cannot be null");
            varD55C34D141FD57420C78F6F4EB8B48E8_381408716.addTaint(taint);
            throw varD55C34D141FD57420C78F6F4EB8B48E8_381408716;
        } //End block
        try 
        {
            dn = new Name(name);
        } //End block
        catch (IOException e)
        {
            java.lang.IllegalArgumentException varF3BA263C43D67A9C283EE45F1DF671F7_1716858445 = incorrectInputName(e, name);
            varF3BA263C43D67A9C283EE45F1DF671F7_1716858445.addTaint(taint);
            throw varF3BA263C43D67A9C283EE45F1DF671F7_1716858445;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.217 -0400", hash_original_method = "2009C8B3D7F2D72E316D77325E1D8621", hash_generated_method = "ADE387DD6FC981CA8CD1567716B14331")
    public  X500Principal(String name, Map<String,String> keywordMap) {
    if(name == null)        
        {
            NullPointerException varD55C34D141FD57420C78F6F4EB8B48E8_993316709 = new NullPointerException("Name cannot be null");
            varD55C34D141FD57420C78F6F4EB8B48E8_993316709.addTaint(taint);
            throw varD55C34D141FD57420C78F6F4EB8B48E8_993316709;
        } //End block
        try 
        {
            dn = new Name(substituteNameFromMap(name, keywordMap));
        } //End block
        catch (IOException e)
        {
            java.lang.IllegalArgumentException varF3BA263C43D67A9C283EE45F1DF671F7_307816010 = incorrectInputName(e, name);
            varF3BA263C43D67A9C283EE45F1DF671F7_307816010.addTaint(taint);
            throw varF3BA263C43D67A9C283EE45F1DF671F7_307816010;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.218 -0400", hash_original_method = "9E8384C79D62223409840D75AB5AB58E", hash_generated_method = "09EFF356EBDF39DF087EF8EC087C4E14")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.219 -0400", hash_original_method = "6436965683334E035C1CE670538AE7C6", hash_generated_method = "ABDA72E7CBEFE08540F89AF93F018AF2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.219 -0400", hash_original_method = "4587ED52F7AA726C7418DB94B8315A23", hash_generated_method = "A134BEA11A2228832DB0F0EC69336A9A")
    private synchronized String getCanonicalName() {
    if(canonicalName == null)        
        {
            canonicalName = dn.getName(CANONICAL);
        } //End block
String var7E150FCC7E02D69327EC2754E827BBC0_1942694981 =         canonicalName;
        var7E150FCC7E02D69327EC2754E827BBC0_1942694981.addTaint(taint);
        return var7E150FCC7E02D69327EC2754E827BBC0_1942694981;
        // ---------- Original Method ----------
        //if (canonicalName == null) {
            //canonicalName = dn.getName(CANONICAL);
        //}
        //return canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.219 -0400", hash_original_method = "16164FE0EFFEA9276C58202163E56457", hash_generated_method = "428133C4AEAB98EC37610A272337696B")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1022790439 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954906732 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954906732;
        } //End block
    if(o == null || this.getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1630057361 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301090744 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301090744;
        } //End block
        X500Principal principal = (X500Principal) o;
        boolean varBFB080AED0E2AF7359E60DC9CCF7D15B_1605151750 = (getCanonicalName().equals(principal.getCanonicalName()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831756980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831756980;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.220 -0400", hash_original_method = "0D44433D57FF4BE42B367E2D93A9CEDF", hash_generated_method = "F1DFB4AEE3A4565C7F652C0875F712D6")
    public byte[] getEncoded() {
        byte[] src = dn.getEncoded();
        byte[] dst = new byte[src.length];
        System.arraycopy(src, 0, dst, 0, dst.length);
        byte[] var28E3D688A3C077B887921CEA3FB1DBC7_2146205188 = (dst);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1521149589 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1521149589;
        // ---------- Original Method ----------
        //byte[] src = dn.getEncoded();
        //byte[] dst = new byte[src.length];
        //System.arraycopy(src, 0, dst, 0, dst.length);
        //return dst;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.220 -0400", hash_original_method = "2BCB4CFF6EEF485C6E2E6569B64BAD8B", hash_generated_method = "956B1359DD58B66C4F6A91B0BE284D87")
    public String getName() {
String var08F6DAD71EC6EDB0BE0363A140D3B809_1153128483 =         dn.getName(RFC2253);
        var08F6DAD71EC6EDB0BE0363A140D3B809_1153128483.addTaint(taint);
        return var08F6DAD71EC6EDB0BE0363A140D3B809_1153128483;
        // ---------- Original Method ----------
        //return dn.getName(RFC2253);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.221 -0400", hash_original_method = "DC6B95F939C1817F13ECF66B400795F1", hash_generated_method = "E07BF1E33C21AC4940245E34E745F8FC")
    public String getName(String format) {
        addTaint(format.getTaint());
    if(CANONICAL.equals(format))        
        {
String var1C29F95F65985963179EA1C2D95D2CEA_753337713 =             getCanonicalName();
            var1C29F95F65985963179EA1C2D95D2CEA_753337713.addTaint(taint);
            return var1C29F95F65985963179EA1C2D95D2CEA_753337713;
        } //End block
String var2D5D2E4F12D8C4AC82C9F6D97E3483B0_1463862857 =         dn.getName(format);
        var2D5D2E4F12D8C4AC82C9F6D97E3483B0_1463862857.addTaint(taint);
        return var2D5D2E4F12D8C4AC82C9F6D97E3483B0_1463862857;
        // ---------- Original Method ----------
        //if (CANONICAL.equals(format)) {
            //return getCanonicalName();
        //}
        //return dn.getName(format);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.222 -0400", hash_original_method = "F26EAC27584EEA69A397CAF64D802897", hash_generated_method = "DB40AE397DC49785DD7225433D99112A")
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
String var3318B6470F204095A1A93B089A3A90B2_1700999986 =             resultName.toString();
            var3318B6470F204095A1A93B089A3A90B2_1700999986.addTaint(taint);
            return var3318B6470F204095A1A93B089A3A90B2_1700999986;
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
String var3318B6470F204095A1A93B089A3A90B2_1024155405 =             resultName.toString();
            var3318B6470F204095A1A93B089A3A90B2_1024155405.addTaint(taint);
            return var3318B6470F204095A1A93B089A3A90B2_1024155405;
        } //End block
        else
        {
            IllegalArgumentException varF9C22D5169D99F66FED780168FB8177D_1292820258 = new IllegalArgumentException("invalid format specified: " + format);
            varF9C22D5169D99F66FED780168FB8177D_1292820258.addTaint(taint);
            throw varF9C22D5169D99F66FED780168FB8177D_1292820258;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.223 -0400", hash_original_method = "4EF4800FE4F6884E38EE2C97450FA744", hash_generated_method = "A52E6B1E58114C020DF1B28C4897079B")
    @Override
    public int hashCode() {
        int varCA006599DDB1EBBCCF1A331311F932D0_308825492 = (getCanonicalName().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156242132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156242132;
        // ---------- Original Method ----------
        //return getCanonicalName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.223 -0400", hash_original_method = "FEC69921702EBFC3E3DC123C0BE46430", hash_generated_method = "4812BA9F75EEB651598E056D087F3022")
    @Override
    public String toString() {
String var04328ADBCE8325DAA95AEC1783AFD17A_275641583 =         dn.getName(RFC1779);
        var04328ADBCE8325DAA95AEC1783AFD17A_275641583.addTaint(taint);
        return var04328ADBCE8325DAA95AEC1783AFD17A_275641583;
        // ---------- Original Method ----------
        //return dn.getName(RFC1779);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.224 -0400", hash_original_method = "11CA04BE900A069B4C6C484CD5BEB982", hash_generated_method = "8FB4070FC90A2E7E6893E0A4FF922ED6")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeObject(dn.getEncoded());
        // ---------- Original Method ----------
        //out.writeObject(dn.getEncoded());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.224 -0400", hash_original_method = "8759D8976B48D4CB6209F3200BF3598B", hash_generated_method = "152ACDA71726E5032041ABE752F2EA68")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
        // ---------- Original Method ----------
        //dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.225 -0400", hash_original_method = "84EFD5BFB0134499160A2521897988D3", hash_generated_method = "A7896ABFF1F143AF29043ED4F53678B0")
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
String var25FABEFC42C74DDAF545088033E64C8D_696445534 =         sbName.toString();
        var25FABEFC42C74DDAF545088033E64C8D_696445534.addTaint(taint);
        return var25FABEFC42C74DDAF545088033E64C8D_696445534;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.225 -0400", hash_original_field = "8DD0850A45DD8279208B0A47E4970B1B", hash_generated_field = "26CAD3B6FC0EACF2E9B47D2D50E32979")

    private static final long serialVersionUID = -500463348111345721L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.225 -0400", hash_original_field = "43F9C433C6C27576D56B459CD29942CC", hash_generated_field = "82CE65EBAABC70666F50B8A10883BA7F")

    public static final String CANONICAL = "CANONICAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.225 -0400", hash_original_field = "E56BCDB17498A8325666AA28E444D830", hash_generated_field = "DBAC8AB28BADF6FBFEEA44C4163EFD9F")

    public static final String RFC1779 = "RFC1779";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.225 -0400", hash_original_field = "2A20ED380CA46C19AFB99FB1EE259E06", hash_generated_field = "C120F901C78A5D9CE52D3BC1A7B434D8")

    public static final String RFC2253 = "RFC2253";
}

