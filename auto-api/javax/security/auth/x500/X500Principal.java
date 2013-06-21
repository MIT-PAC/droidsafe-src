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
    private transient Name dn;
    private transient String canonicalName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.210 -0400", hash_original_method = "A3047134DA2BBFDCD9EABEAC496A6A0D", hash_generated_method = "1BD768D9F61F8AE69FC0A1FCBCBFC65A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal(byte[] name) {
        dsTaint.addTaint(name[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.210 -0400", hash_original_method = "BF19E6A321D84C3196CD725DF225766B", hash_generated_method = "C1472C2C2E2EDAA85652E79A4FA377AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal(InputStream in) {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.210 -0400", hash_original_method = "4B12F08D986FED39E34C8D26B1B878DE", hash_generated_method = "308B5F47B4A69271B14FB047697CCCB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal(String name) {
        dsTaint.addTaint(name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.210 -0400", hash_original_method = "2009C8B3D7F2D72E316D77325E1D8621", hash_generated_method = "E635D1ED90936D3B011DACFDEACCA434")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal(String name, Map<String,String> keywordMap) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(keywordMap.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.211 -0400", hash_original_method = "9E8384C79D62223409840D75AB5AB58E", hash_generated_method = "8C233511EA030C7110160CB2FE47C9E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IllegalArgumentException incorrectInputEncoding(IOException e) {
        dsTaint.addTaint(e.dsTaint);
        IllegalArgumentException iae;
        iae = new IllegalArgumentException("Incorrect input encoding");
        iae.initCause(e);
        if (DroidSafeAndroidRuntime.control) throw iae;
        return (IllegalArgumentException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IllegalArgumentException iae = new IllegalArgumentException("Incorrect input encoding");
        //iae.initCause(e);
        //throw iae;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.211 -0400", hash_original_method = "6436965683334E035C1CE670538AE7C6", hash_generated_method = "CC54168E3F31F6FBF90BCAACAAAED592")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IllegalArgumentException incorrectInputName(IOException e, String name) {
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(name);
        IllegalArgumentException iae;
        iae = new IllegalArgumentException("Incorrect input name:" + name);
        iae.initCause(e);
        if (DroidSafeAndroidRuntime.control) throw iae;
        return (IllegalArgumentException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IllegalArgumentException iae = new IllegalArgumentException("Incorrect input name:" + name);
        //iae.initCause(e);
        //throw iae;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.211 -0400", hash_original_method = "4587ED52F7AA726C7418DB94B8315A23", hash_generated_method = "3A7B057D07B4286C3FB170815FE35D02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized String getCanonicalName() {
        {
            canonicalName = dn.getName(CANONICAL);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (canonicalName == null) {
            //canonicalName = dn.getName(CANONICAL);
        //}
        //return canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.211 -0400", hash_original_method = "16164FE0EFFEA9276C58202163E56457", hash_generated_method = "BD4F29EEBA705A6AE36EAFF6B57A79DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var9B27E520BBC2DDC5CC18F0AC09DC0048_837834531 = (o == null || this.getClass() != o.getClass());
        } //End collapsed parenthetic
        X500Principal principal;
        principal = (X500Principal) o;
        boolean var52630933BE63050CF1143372FB4ADF8E_1200492664 = (getCanonicalName().equals(principal.getCanonicalName()));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.211 -0400", hash_original_method = "0D44433D57FF4BE42B367E2D93A9CEDF", hash_generated_method = "A53D66BC07078BFB2EE186C28EE39AA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        byte[] src;
        src = dn.getEncoded();
        byte[] dst;
        dst = new byte[src.length];
        System.arraycopy(src, 0, dst, 0, dst.length);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] src = dn.getEncoded();
        //byte[] dst = new byte[src.length];
        //System.arraycopy(src, 0, dst, 0, dst.length);
        //return dst;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.212 -0400", hash_original_method = "2BCB4CFF6EEF485C6E2E6569B64BAD8B", hash_generated_method = "ED46F57D406E4A989D40652A628B9CC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        String var44C9769EDF99E276E74EFDE10CCF5B71_325064086 = (dn.getName(RFC2253));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dn.getName(RFC2253);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.212 -0400", hash_original_method = "DC6B95F939C1817F13ECF66B400795F1", hash_generated_method = "173099CB3590816247B9BF0E7E087BB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName(String format) {
        dsTaint.addTaint(format);
        {
            boolean var7BB6BC064FD8B633AC4A7BB6004A0653_1107008586 = (CANONICAL.equals(format));
            {
                String var86D23E2AB4D607C1E11D180B6C9CAF99_1927113403 = (getCanonicalName());
            } //End block
        } //End collapsed parenthetic
        String var1602C26595CAA4BCC73450DEE341A514_255601183 = (dn.getName(format));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (CANONICAL.equals(format)) {
            //return getCanonicalName();
        //}
        //return dn.getName(format);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.213 -0400", hash_original_method = "F26EAC27584EEA69A397CAF64D802897", hash_generated_method = "615DF6C9BADC8E4CCA08F90EA1B67063")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName(String format, Map<String, String> oidMap) {
        dsTaint.addTaint(oidMap.dsTaint);
        dsTaint.addTaint(format);
        String rfc1779Name;
        rfc1779Name = dn.getName(RFC1779);
        String rfc2253Name;
        rfc2253Name = dn.getName(RFC2253);
        {
            boolean var317C58144C2D356F44C249FF9A422765_910389685 = (format.equalsIgnoreCase("RFC1779"));
            {
                StringBuilder resultName;
                resultName = new StringBuilder(rfc1779Name);
                int fromIndex;
                fromIndex = resultName.length();
                int equalIndex;
                equalIndex = -1;
                {
                    boolean var2C7EED22DB4E70B23D1B5814ECC24A58_1983996063 = (-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex)));
                    {
                        int commaIndex;
                        commaIndex = resultName.lastIndexOf(",", equalIndex);
                        String subName;
                        subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                        {
                            boolean var2F5BE577C6E17AE90AC52170AB09B569_2113991782 = (subName.length() > 4
                        && subName.substring(0, 4).equals("OID."));
                            {
                                String subSubName;
                                subSubName = subName.substring(4);
                                {
                                    boolean var166A28986D6012D0BD61EB43E53C6B20_854024577 = (oidMap.containsKey(subSubName));
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
                String var99962FAA8051C00F007BE7586A77CB22_711931351 = (resultName.toString());
            } //End block
            {
                boolean varFD7A06A215C222B594B904F0CE620625_1376396473 = (format.equalsIgnoreCase("RFC2253"));
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
                        boolean var7DE2CCB1FC9DF985FE99CF9F770CA885_337253566 = (-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex)));
                        {
                            subsidyEqualIndex = subsidyName.lastIndexOf("=",
                        subsidyFromIndex);
                            int commaIndex;
                            commaIndex = resultName.lastIndexOf(",", equalIndex);
                            String subName;
                            subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                            {
                                boolean var689293F83B3EB1602CE23B7EB35A0D7D_92833099 = (oidMap.containsKey(subName));
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
                    String varAE728F0FF478521C4F23B34058A0AE20_1435230103 = (resultName.toString());
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invalid format specified: " + format);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.213 -0400", hash_original_method = "4EF4800FE4F6884E38EE2C97450FA744", hash_generated_method = "0EFC35E68A5713F4530C537384816F35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var385DD4FDA480CB6B9347ADFCBE096CAA_1134941323 = (getCanonicalName().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getCanonicalName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.213 -0400", hash_original_method = "FEC69921702EBFC3E3DC123C0BE46430", hash_generated_method = "F1E842A73A46C845ED87521835A4D9B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varC02F27386B412960420B0837EA1DF6A8_622959452 = (dn.getName(RFC1779));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dn.getName(RFC1779);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.213 -0400", hash_original_method = "11CA04BE900A069B4C6C484CD5BEB982", hash_generated_method = "C1FF087F5E3D0E68439295583B2065D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        out.writeObject(dn.getEncoded());
        // ---------- Original Method ----------
        //out.writeObject(dn.getEncoded());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.213 -0400", hash_original_method = "8759D8976B48D4CB6209F3200BF3598B", hash_generated_method = "D7EBA8640D21E950548358926708E13E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
        // ---------- Original Method ----------
        //dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.214 -0400", hash_original_method = "84EFD5BFB0134499160A2521897988D3", hash_generated_method = "AC47F7A34E1A29F9E8B2BA6404A6CF36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String substituteNameFromMap(String name, Map<String, String> keywordMap) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(keywordMap.dsTaint);
        StringBuilder sbName;
        sbName = new StringBuilder(name);
        int fromIndex;
        fromIndex = sbName.length();
        int equalIndex;
        {
            boolean var9971E52280D48DA133734AD4567B4879_171431867 = (-1 != (equalIndex = sbName.lastIndexOf("=", fromIndex)));
            {
                int commaIndex;
                commaIndex = sbName.lastIndexOf(",", equalIndex);
                String subName;
                subName = sbName.substring(commaIndex + 1, equalIndex).trim();
                {
                    boolean var9423E14BCBD60669169FA5083F5CAB59_1798087164 = (keywordMap.containsKey(subName));
                    {
                        sbName.replace(commaIndex + 1, equalIndex, keywordMap.get(subName));
                    } //End block
                } //End collapsed parenthetic
                fromIndex = commaIndex;
            } //End block
        } //End collapsed parenthetic
        String var6CB6E669096FD38CED8ED2EE831A4C25_926719761 = (sbName.toString());
        return dsTaint.getTaintString();
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

    
    private static final long serialVersionUID = -500463348111345721L;
    public static final String CANONICAL = "CANONICAL";
    public static final String RFC1779 = "RFC1779";
    public static final String RFC2253 = "RFC2253";
}

