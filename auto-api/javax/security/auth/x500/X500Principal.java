package javax.security.auth.x500;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.Principal;
import java.util.Map;
import org.apache.harmony.security.x501.Name;

public final class X500Principal implements Serializable, Principal {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.484 -0400", hash_original_field = "567C996739EDFA1CDBAD4C55A80580DF", hash_generated_field = "CFC846905F9BAB769B1824279452E9D4")

    private transient Name dn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.484 -0400", hash_original_field = "3FD37E7C1754DA8004AB09E17AD51B85", hash_generated_field = "6B8880E941EC803BC6CC2DFD6A5E024B")

    private transient String canonicalName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.487 -0400", hash_original_method = "A3047134DA2BBFDCD9EABEAC496A6A0D", hash_generated_method = "D1670BCBFC7E9E6DDA75D14700463F25")
    public  X500Principal(byte[] name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name cannot be null");
        } //End block
        try 
        {
            dn = (Name) Name.ASN1.decode(name);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw incorrectInputEncoding(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.487 -0400", hash_original_method = "BF19E6A321D84C3196CD725DF225766B", hash_generated_method = "862B6082B8FE622BFD0D1334D6D0970F")
    public  X500Principal(InputStream in) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("in == null");
        } //End block
        try 
        {
            dn = (Name) Name.ASN1.decode(in);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw incorrectInputEncoding(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.488 -0400", hash_original_method = "4B12F08D986FED39E34C8D26B1B878DE", hash_generated_method = "971A99D48F138A498C8CF6478A3FE9EB")
    public  X500Principal(String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Name cannot be null");
        } //End block
        try 
        {
            dn = new Name(name);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw incorrectInputName(e, name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.488 -0400", hash_original_method = "2009C8B3D7F2D72E316D77325E1D8621", hash_generated_method = "697ACD877E62AAFAF1A3311DF3A049AB")
    public  X500Principal(String name, Map<String,String> keywordMap) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Name cannot be null");
        } //End block
        try 
        {
            dn = new Name(substituteNameFromMap(name, keywordMap));
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw incorrectInputName(e, name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.489 -0400", hash_original_method = "9E8384C79D62223409840D75AB5AB58E", hash_generated_method = "94952B045952BE7DF7C519E8633C27C2")
    private IllegalArgumentException incorrectInputEncoding(IOException e) {
        IllegalArgumentException iae;
        iae = new IllegalArgumentException("Incorrect input encoding");
        iae.initCause(e);
        if (DroidSafeAndroidRuntime.control) throw iae;
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //IllegalArgumentException iae = new IllegalArgumentException("Incorrect input encoding");
        //iae.initCause(e);
        //throw iae;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.490 -0400", hash_original_method = "6436965683334E035C1CE670538AE7C6", hash_generated_method = "8AC362FFB7A8D084C8D9B570E0D5CF67")
    private IllegalArgumentException incorrectInputName(IOException e, String name) {
        IllegalArgumentException iae;
        iae = new IllegalArgumentException("Incorrect input name:" + name);
        iae.initCause(e);
        if (DroidSafeAndroidRuntime.control) throw iae;
        addTaint(e.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //IllegalArgumentException iae = new IllegalArgumentException("Incorrect input name:" + name);
        //iae.initCause(e);
        //throw iae;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.490 -0400", hash_original_method = "4587ED52F7AA726C7418DB94B8315A23", hash_generated_method = "6D6030EA127514AA451F9BEF9000E458")
    private synchronized String getCanonicalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2064572226 = null; //Variable for return #1
        {
            canonicalName = dn.getName(CANONICAL);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2064572226 = canonicalName;
        varB4EAC82CA7396A68D541C85D26508E83_2064572226.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2064572226;
        // ---------- Original Method ----------
        //if (canonicalName == null) {
            //canonicalName = dn.getName(CANONICAL);
        //}
        //return canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.496 -0400", hash_original_method = "16164FE0EFFEA9276C58202163E56457", hash_generated_method = "343445FAAD74997E859411E5EB40FF5E")
    @Override
    public boolean equals(Object o) {
        {
            boolean var9B27E520BBC2DDC5CC18F0AC09DC0048_596662614 = (o == null || this.getClass() != o.getClass());
        } //End collapsed parenthetic
        X500Principal principal;
        principal = (X500Principal) o;
        boolean var52630933BE63050CF1143372FB4ADF8E_408528252 = (getCanonicalName().equals(principal.getCanonicalName()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1212465173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1212465173;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.502 -0400", hash_original_method = "0D44433D57FF4BE42B367E2D93A9CEDF", hash_generated_method = "AC57DCB906223BA83786D23E62E56881")
    public byte[] getEncoded() {
        byte[] src;
        src = dn.getEncoded();
        byte[] dst;
        dst = new byte[src.length];
        System.arraycopy(src, 0, dst, 0, dst.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_631513103 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_631513103;
        // ---------- Original Method ----------
        //byte[] src = dn.getEncoded();
        //byte[] dst = new byte[src.length];
        //System.arraycopy(src, 0, dst, 0, dst.length);
        //return dst;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.517 -0400", hash_original_method = "2BCB4CFF6EEF485C6E2E6569B64BAD8B", hash_generated_method = "6C8F12B4BFA9229129586080225214D8")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_974998621 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_974998621 = dn.getName(RFC2253);
        varB4EAC82CA7396A68D541C85D26508E83_974998621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_974998621;
        // ---------- Original Method ----------
        //return dn.getName(RFC2253);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.518 -0400", hash_original_method = "DC6B95F939C1817F13ECF66B400795F1", hash_generated_method = "C1239F2E2516D385376A2391C8D281E0")
    public String getName(String format) {
        String varB4EAC82CA7396A68D541C85D26508E83_1564269210 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_366048744 = null; //Variable for return #2
        {
            boolean var7BB6BC064FD8B633AC4A7BB6004A0653_1100457235 = (CANONICAL.equals(format));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1564269210 = getCanonicalName();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_366048744 = dn.getName(format);
        addTaint(format.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2113532872; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2113532872 = varB4EAC82CA7396A68D541C85D26508E83_1564269210;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2113532872 = varB4EAC82CA7396A68D541C85D26508E83_366048744;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2113532872.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2113532872;
        // ---------- Original Method ----------
        //if (CANONICAL.equals(format)) {
            //return getCanonicalName();
        //}
        //return dn.getName(format);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.519 -0400", hash_original_method = "F26EAC27584EEA69A397CAF64D802897", hash_generated_method = "0D7A2A7100A2E4930B180A3B1FD00C23")
    public String getName(String format, Map<String, String> oidMap) {
        String varB4EAC82CA7396A68D541C85D26508E83_15848550 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1428790483 = null; //Variable for return #2
        String rfc1779Name;
        rfc1779Name = dn.getName(RFC1779);
        String rfc2253Name;
        rfc2253Name = dn.getName(RFC2253);
        {
            boolean var317C58144C2D356F44C249FF9A422765_1881776018 = (format.equalsIgnoreCase("RFC1779"));
            {
                StringBuilder resultName;
                resultName = new StringBuilder(rfc1779Name);
                int fromIndex;
                fromIndex = resultName.length();
                int equalIndex;
                equalIndex = -1;
                {
                    boolean var2C7EED22DB4E70B23D1B5814ECC24A58_1219137964 = (-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex)));
                    {
                        int commaIndex;
                        commaIndex = resultName.lastIndexOf(",", equalIndex);
                        String subName;
                        subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                        {
                            boolean var2F5BE577C6E17AE90AC52170AB09B569_1409331069 = (subName.length() > 4
                        && subName.substring(0, 4).equals("OID."));
                            {
                                String subSubName;
                                subSubName = subName.substring(4);
                                {
                                    boolean var166A28986D6012D0BD61EB43E53C6B20_686486046 = (oidMap.containsKey(subSubName));
                                    {
                                        String replaceName;
                                        replaceName = oidMap.get(subSubName);
                                        replaceName = " " + replaceName;
                                        resultName.replace(commaIndex + 1, equalIndex, replaceName);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        fromIndex = commaIndex;
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_15848550 = resultName.toString();
            } //End block
            {
                boolean varFD7A06A215C222B594B904F0CE620625_265702358 = (format.equalsIgnoreCase("RFC2253"));
                {
                    StringBuilder resultName;
                    resultName = new StringBuilder(rfc2253Name);
                    StringBuilder subsidyName;
                    subsidyName = new StringBuilder(rfc1779Name);
                    int fromIndex;
                    fromIndex = resultName.length();
                    int subsidyFromIndex;
                    subsidyFromIndex = subsidyName.length();
                    int equalIndex;
                    equalIndex = -1;
                    int subsidyEqualIndex;
                    subsidyEqualIndex = -1;
                    {
                        boolean var7DE2CCB1FC9DF985FE99CF9F770CA885_348271820 = (-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex)));
                        {
                            subsidyEqualIndex = subsidyName.lastIndexOf("=",
                        subsidyFromIndex);
                            int commaIndex;
                            commaIndex = resultName.lastIndexOf(",", equalIndex);
                            String subName;
                            subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                            {
                                boolean var689293F83B3EB1602CE23B7EB35A0D7D_1589532103 = (oidMap.containsKey(subName));
                                {
                                    int subOrignalEndIndex;
                                    subOrignalEndIndex = resultName
                            .indexOf(",", equalIndex);
                                    subOrignalEndIndex = resultName.length();
                                    int subGoalEndIndex;
                                    subGoalEndIndex = subsidyName.indexOf(",",
                            subsidyEqualIndex);
                                    subGoalEndIndex = subsidyName.length();
                                    resultName.replace(equalIndex + 1, subOrignalEndIndex,
                            subsidyName.substring(subsidyEqualIndex + 1,
                                    subGoalEndIndex));
                                    resultName.replace(commaIndex + 1, equalIndex, oidMap
                            .get(subName));
                                } //End block
                            } //End collapsed parenthetic
                            fromIndex = commaIndex;
                            subsidyFromIndex = subsidyEqualIndex - 1;
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1428790483 = resultName.toString();
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invalid format specified: " + format);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(format.getTaint());
        addTaint(oidMap.getTaint());
        String varA7E53CE21691AB073D9660D615818899_735472651; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_735472651 = varB4EAC82CA7396A68D541C85D26508E83_15848550;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_735472651 = varB4EAC82CA7396A68D541C85D26508E83_1428790483;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_735472651.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_735472651;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.520 -0400", hash_original_method = "4EF4800FE4F6884E38EE2C97450FA744", hash_generated_method = "EBAA441CA6A95E171445FA01A018A104")
    @Override
    public int hashCode() {
        int var385DD4FDA480CB6B9347ADFCBE096CAA_689512251 = (getCanonicalName().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918008494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918008494;
        // ---------- Original Method ----------
        //return getCanonicalName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.528 -0400", hash_original_method = "FEC69921702EBFC3E3DC123C0BE46430", hash_generated_method = "E6B4560C0B578001A09476CFECA9F3BD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1837596920 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1837596920 = dn.getName(RFC1779);
        varB4EAC82CA7396A68D541C85D26508E83_1837596920.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1837596920;
        // ---------- Original Method ----------
        //return dn.getName(RFC1779);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.532 -0400", hash_original_method = "11CA04BE900A069B4C6C484CD5BEB982", hash_generated_method = "0386439EAF585343B117859A12EA3602")
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(dn.getEncoded());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeObject(dn.getEncoded());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.533 -0400", hash_original_method = "8759D8976B48D4CB6209F3200BF3598B", hash_generated_method = "152ACDA71726E5032041ABE752F2EA68")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
        // ---------- Original Method ----------
        //dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.533 -0400", hash_original_method = "84EFD5BFB0134499160A2521897988D3", hash_generated_method = "E22FC9C2B89B67248497FA99B504152E")
    private String substituteNameFromMap(String name, Map<String, String> keywordMap) {
        String varB4EAC82CA7396A68D541C85D26508E83_731383518 = null; //Variable for return #1
        StringBuilder sbName;
        sbName = new StringBuilder(name);
        int fromIndex;
        fromIndex = sbName.length();
        int equalIndex;
        {
            boolean var9971E52280D48DA133734AD4567B4879_1251926701 = (-1 != (equalIndex = sbName.lastIndexOf("=", fromIndex)));
            {
                int commaIndex;
                commaIndex = sbName.lastIndexOf(",", equalIndex);
                String subName;
                subName = sbName.substring(commaIndex + 1, equalIndex).trim();
                {
                    boolean var9423E14BCBD60669169FA5083F5CAB59_1640226803 = (keywordMap.containsKey(subName));
                    {
                        sbName.replace(commaIndex + 1, equalIndex, keywordMap.get(subName));
                    } //End block
                } //End collapsed parenthetic
                fromIndex = commaIndex;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_731383518 = sbName.toString();
        addTaint(name.getTaint());
        addTaint(keywordMap.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_731383518.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_731383518;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.535 -0400", hash_original_field = "8DD0850A45DD8279208B0A47E4970B1B", hash_generated_field = "609908791419F032C748947B5CE55445")

    private static long serialVersionUID = -500463348111345721L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.535 -0400", hash_original_field = "43F9C433C6C27576D56B459CD29942CC", hash_generated_field = "82CE65EBAABC70666F50B8A10883BA7F")

    public static final String CANONICAL = "CANONICAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.535 -0400", hash_original_field = "E56BCDB17498A8325666AA28E444D830", hash_generated_field = "DBAC8AB28BADF6FBFEEA44C4163EFD9F")

    public static final String RFC1779 = "RFC1779";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.535 -0400", hash_original_field = "2A20ED380CA46C19AFB99FB1EE259E06", hash_generated_field = "C120F901C78A5D9CE52D3BC1A7B434D8")

    public static final String RFC2253 = "RFC2253";
}

