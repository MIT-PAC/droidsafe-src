package javax.security.auth.x500;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final long serialVersionUID = -500463348111345721L;
    public static final String CANONICAL = "CANONICAL";
    public static final String RFC1779 = "RFC1779";
    public static final String RFC2253 = "RFC2253";
    private transient Name dn;
    private transient String canonicalName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.504 -0400", hash_original_method = "A3047134DA2BBFDCD9EABEAC496A6A0D", hash_generated_method = "EB7F52B21E6538B1FBAD58F7D2814C36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal(byte[] name) {
        dsTaint.addTaint(name);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name cannot be null");
        } //End block
        try 
        {
            dn = (Name) Name.ASN1.decode(name);
        } //End block
        catch (IOException e)
        {
            throw incorrectInputEncoding(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.504 -0400", hash_original_method = "BF19E6A321D84C3196CD725DF225766B", hash_generated_method = "7A28DFC44908064770FDE3E7DB393CF4")
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
            throw incorrectInputEncoding(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.504 -0400", hash_original_method = "4B12F08D986FED39E34C8D26B1B878DE", hash_generated_method = "DC3F675928868B181C3D8A745A0F2C3A")
    @DSModeled(DSC.SAFE)
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
            throw incorrectInputName(e, name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.504 -0400", hash_original_method = "2009C8B3D7F2D72E316D77325E1D8621", hash_generated_method = "C8097A8CA9DC84C4DDB4202E7D6E0431")
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
            throw incorrectInputName(e, name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.504 -0400", hash_original_method = "9E8384C79D62223409840D75AB5AB58E", hash_generated_method = "1C95D35D5763A982DACDBA4E8F6938DD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.504 -0400", hash_original_method = "6436965683334E035C1CE670538AE7C6", hash_generated_method = "CC0E82BD97DE50D50A2337F06F3750C1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.504 -0400", hash_original_method = "4587ED52F7AA726C7418DB94B8315A23", hash_generated_method = "87DDD747EDB0A712A028790049E95B51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.505 -0400", hash_original_method = "16164FE0EFFEA9276C58202163E56457", hash_generated_method = "A04E1E161535F9A9BD7DD35AE289F1CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var9B27E520BBC2DDC5CC18F0AC09DC0048_31676060 = (o == null || this.getClass() != o.getClass());
        } //End collapsed parenthetic
        X500Principal principal;
        principal = (X500Principal) o;
        boolean var52630933BE63050CF1143372FB4ADF8E_870896189 = (getCanonicalName().equals(principal.getCanonicalName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.505 -0400", hash_original_method = "0D44433D57FF4BE42B367E2D93A9CEDF", hash_generated_method = "BD9995CE6A634B24C256DFF423B48F70")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.505 -0400", hash_original_method = "2BCB4CFF6EEF485C6E2E6569B64BAD8B", hash_generated_method = "151956E4D7628E7A4D3421EB3B977590")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        String var44C9769EDF99E276E74EFDE10CCF5B71_1884184197 = (dn.getName(RFC2253));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dn.getName(RFC2253);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.505 -0400", hash_original_method = "DC6B95F939C1817F13ECF66B400795F1", hash_generated_method = "C8064BB0DE7BF7759BF040E9EF969D13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName(String format) {
        dsTaint.addTaint(format);
        {
            boolean var7BB6BC064FD8B633AC4A7BB6004A0653_1775657186 = (CANONICAL.equals(format));
            {
                String var86D23E2AB4D607C1E11D180B6C9CAF99_778209357 = (getCanonicalName());
            } //End block
        } //End collapsed parenthetic
        String var1602C26595CAA4BCC73450DEE341A514_1346695674 = (dn.getName(format));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (CANONICAL.equals(format)) {
            //return getCanonicalName();
        //}
        //return dn.getName(format);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.505 -0400", hash_original_method = "F26EAC27584EEA69A397CAF64D802897", hash_generated_method = "289C2C2E19EF45F12975A41ADB6F3E58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName(String format, Map<String, String> oidMap) {
        dsTaint.addTaint(oidMap.dsTaint);
        dsTaint.addTaint(format);
        String rfc1779Name;
        rfc1779Name = dn.getName(RFC1779);
        String rfc2253Name;
        rfc2253Name = dn.getName(RFC2253);
        {
            boolean var317C58144C2D356F44C249FF9A422765_879550947 = (format.equalsIgnoreCase("RFC1779"));
            {
                StringBuilder resultName;
                resultName = new StringBuilder(rfc1779Name);
                int fromIndex;
                fromIndex = resultName.length();
                int equalIndex;
                equalIndex = -1;
                {
                    boolean var2C7EED22DB4E70B23D1B5814ECC24A58_1665105765 = (-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex)));
                    {
                        int commaIndex;
                        commaIndex = resultName.lastIndexOf(",", equalIndex);
                        String subName;
                        subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                        {
                            boolean var2F5BE577C6E17AE90AC52170AB09B569_183720590 = (subName.length() > 4
                        && subName.substring(0, 4).equals("OID."));
                            {
                                String subSubName;
                                subSubName = subName.substring(4);
                                {
                                    boolean var166A28986D6012D0BD61EB43E53C6B20_1529934604 = (oidMap.containsKey(subSubName));
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
                String var99962FAA8051C00F007BE7586A77CB22_505769369 = (resultName.toString());
            } //End block
            {
                boolean varFD7A06A215C222B594B904F0CE620625_1525273992 = (format.equalsIgnoreCase("RFC2253"));
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
                        boolean var7DE2CCB1FC9DF985FE99CF9F770CA885_589544122 = (-1 != (equalIndex = resultName.lastIndexOf("=", fromIndex)));
                        {
                            subsidyEqualIndex = subsidyName.lastIndexOf("=",
                        subsidyFromIndex);
                            int commaIndex;
                            commaIndex = resultName.lastIndexOf(",", equalIndex);
                            String subName;
                            subName = resultName.substring(commaIndex + 1,
                        equalIndex).trim();
                            {
                                boolean var689293F83B3EB1602CE23B7EB35A0D7D_1033076780 = (oidMap.containsKey(subName));
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
                    String varAE728F0FF478521C4F23B34058A0AE20_1032491136 = (resultName.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.506 -0400", hash_original_method = "4EF4800FE4F6884E38EE2C97450FA744", hash_generated_method = "811F538C338BB39040DB14D9C5D1F0EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var385DD4FDA480CB6B9347ADFCBE096CAA_1429911601 = (getCanonicalName().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getCanonicalName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.506 -0400", hash_original_method = "FEC69921702EBFC3E3DC123C0BE46430", hash_generated_method = "06E6D1FE217D44645C2808AE5339F42D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varC02F27386B412960420B0837EA1DF6A8_114953857 = (dn.getName(RFC1779));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dn.getName(RFC1779);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.506 -0400", hash_original_method = "11CA04BE900A069B4C6C484CD5BEB982", hash_generated_method = "7608A117EB52FC3028B9E0D30E39C47B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        out.writeObject(dn.getEncoded());
        // ---------- Original Method ----------
        //out.writeObject(dn.getEncoded());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.506 -0400", hash_original_method = "8759D8976B48D4CB6209F3200BF3598B", hash_generated_method = "3611E5695ECBD14B6274E32A94CC5125")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
        // ---------- Original Method ----------
        //dn = (Name) Name.ASN1.decode((byte[]) in.readObject());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.506 -0400", hash_original_method = "84EFD5BFB0134499160A2521897988D3", hash_generated_method = "8D8CA361CF69BB2961E7999490A66A81")
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
            boolean var9971E52280D48DA133734AD4567B4879_30599262 = (-1 != (equalIndex = sbName.lastIndexOf("=", fromIndex)));
            {
                int commaIndex;
                commaIndex = sbName.lastIndexOf(",", equalIndex);
                String subName;
                subName = sbName.substring(commaIndex + 1, equalIndex).trim();
                {
                    boolean var9423E14BCBD60669169FA5083F5CAB59_1887330315 = (keywordMap.containsKey(subName));
                    {
                        sbName.replace(commaIndex + 1, equalIndex, keywordMap.get(subName));
                    } //End block
                } //End collapsed parenthetic
                fromIndex = commaIndex;
            } //End block
        } //End collapsed parenthetic
        String var6CB6E669096FD38CED8ED2EE831A4C25_2070416560 = (sbName.toString());
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

    
}


