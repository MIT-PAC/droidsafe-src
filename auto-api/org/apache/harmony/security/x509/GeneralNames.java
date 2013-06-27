package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class GeneralNames {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.828 -0400", hash_original_field = "08F24DEBB4A72445D5EE1F22A819AF4F", hash_generated_field = "12F5E55FAE92B8BE0DECC643C9318F42")

    private List<GeneralName> generalNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.828 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.828 -0400", hash_original_method = "900922C5A2333ABDC3D6DB9D2843B6C9", hash_generated_method = "8A74688EB414143E6D1C7929DFB8071B")
    public  GeneralNames() {
        generalNames = new ArrayList<GeneralName>();
        // ---------- Original Method ----------
        //generalNames = new ArrayList<GeneralName>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.829 -0400", hash_original_method = "FCF1D75BDAE857F225708496A2E96EC2", hash_generated_method = "6E3DE6D078A590F1F6C1BDB13C3E782D")
    public  GeneralNames(List<GeneralName> generalNames) {
        this.generalNames = generalNames;
        // ---------- Original Method ----------
        //this.generalNames = generalNames;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.829 -0400", hash_original_method = "84AB2B2BC22C66DEEE9A4059D9B177CB", hash_generated_method = "47666260E35014D1A86CB6DA4464F1BC")
    private  GeneralNames(List<GeneralName> generalNames, byte[] encoding) {
        this.generalNames = generalNames;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.generalNames = generalNames;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.830 -0400", hash_original_method = "0BE5F893124FC75916B0920319238607", hash_generated_method = "B8A455EEA71C9D69AB815FCD41B58DF7")
    public List<GeneralName> getNames() {
        List<GeneralName> varB4EAC82CA7396A68D541C85D26508E83_8560817 = null; //Variable for return #1
        List<GeneralName> varB4EAC82CA7396A68D541C85D26508E83_919843477 = null; //Variable for return #2
        {
            boolean var133461071AA2D0765E0C74451BBECA7C_1328653312 = ((generalNames == null) || (generalNames.size() == 0));
            {
                varB4EAC82CA7396A68D541C85D26508E83_8560817 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_919843477 = new ArrayList<GeneralName>(generalNames);
        List<GeneralName> varA7E53CE21691AB073D9660D615818899_358552412; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_358552412 = varB4EAC82CA7396A68D541C85D26508E83_8560817;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_358552412 = varB4EAC82CA7396A68D541C85D26508E83_919843477;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_358552412.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_358552412;
        // ---------- Original Method ----------
        //if ((generalNames == null) || (generalNames.size() == 0)) {
            //return null;
        //}
        //return new ArrayList<GeneralName>(generalNames);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.847 -0400", hash_original_method = "393D0968412D8AD2DE170EB074DB113A", hash_generated_method = "59F75A3E84E26125A62D416C3F6F0746")
    public Collection<List<?>> getPairsList() {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_770733023 = null; //Variable for return #1
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1075567728 = null; //Variable for return #2
        Collection<List<?>> result;
        result = new ArrayList<List<?>>();
        {
            varB4EAC82CA7396A68D541C85D26508E83_770733023 = result;
        } //End block
        {
            Iterator<GeneralName> var48792B06BC03602C9020A2E3077F838C_1122312697 = (generalNames).iterator();
            var48792B06BC03602C9020A2E3077F838C_1122312697.hasNext();
            GeneralName generalName = var48792B06BC03602C9020A2E3077F838C_1122312697.next();
            {
                result.add(generalName.getAsList());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1075567728 = result;
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_570868780; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_570868780 = varB4EAC82CA7396A68D541C85D26508E83_770733023;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_570868780 = varB4EAC82CA7396A68D541C85D26508E83_1075567728;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_570868780.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_570868780;
        // ---------- Original Method ----------
        //Collection<List<?>> result = new ArrayList<List<?>>();
        //if (generalNames == null) {
            //return result;
        //}
        //for (GeneralName generalName : generalNames) {
            //result.add(generalName.getAsList());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.860 -0400", hash_original_method = "62FCFAA5CD61EB40B84DD9F5E8E0A72D", hash_generated_method = "05F31B80D539EA5452F3942F20682D69")
    public void addName(GeneralName name) {
        encoding = null;
        {
            generalNames = new ArrayList<GeneralName>();
        } //End block
        generalNames.add(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //encoding = null;
        //if (generalNames == null) {
            //generalNames = new ArrayList<GeneralName>();
        //}
        //generalNames.add(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.860 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "4E0C700EB7D074B9CAA0146C318932BF")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1717134860 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1717134860;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.913 -0400", hash_original_method = "78509CF3CFA7027FFCDFED35C29E300D", hash_generated_method = "26ABE96BE3CEC57D68B419FFE0DE8E2E")
    public void dumpValue(StringBuilder sb, String prefix) {
        {
            Iterator<GeneralName> var48792B06BC03602C9020A2E3077F838C_1498036485 = (generalNames).iterator();
            var48792B06BC03602C9020A2E3077F838C_1498036485.hasNext();
            GeneralName generalName = var48792B06BC03602C9020A2E3077F838C_1498036485.next();
            {
                sb.append(prefix);
                sb.append(generalName);
                sb.append('\n');
            } //End block
        } //End collapsed parenthetic
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //if (generalNames == null) {
            //return;
        //}
        //for (GeneralName generalName : generalNames) {
            //sb.append(prefix);
            //sb.append(generalName);
            //sb.append('\n');
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.914 -0400", hash_original_field = "F9F6263E38C505EB7173C59BEEA7DE3D", hash_generated_field = "D64C2D3B9F619417B7A91D4BDC12D942")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(GeneralName.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) {
            return new GeneralNames((List<GeneralName>) in.content, in.getEncoded());
        }

        @Override public Collection getValues(Object object) {
            GeneralNames gns = (GeneralNames) object;
            return gns.generalNames;
        }
    };
}

