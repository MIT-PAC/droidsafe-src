package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.DerInputStream;

public final class AttributeValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.429 -0400", hash_original_field = "1B9369CE805E2E405AA325049258CD66", hash_generated_field = "D85F8A65E9DE43097BB265479C87E73B")

    public boolean wasEncoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.429 -0400", hash_original_field = "1BD737972B6402C63472543389F9660E", hash_generated_field = "4A17972559F62AB2783311336A9D4582")

    public String escapedString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.429 -0400", hash_original_field = "6325307BA7A35071F7CCF392A5DEF623", hash_generated_field = "6CF85B6901CE5996CC9D91D793C48B7A")

    private String hexString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.429 -0400", hash_original_field = "FDC324D07BAC6B5172A85181924BBEE8", hash_generated_field = "917AECB67DEB49506F6054710716A2C2")

    private int tag = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.430 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "8DF314849D9BDCEAE78F4B8DFF0C1E45")

    public byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.430 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "1395852C401E496F85701A0A9D82F003")

    public byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.434 -0400", hash_original_field = "EC32FC5A9FC36F29B6B89F4826B648EF", hash_generated_field = "439798B0B0B82905E05B97B14950EE49")

    public boolean hasQE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.434 -0400", hash_original_field = "86C8EF5116F9F2D53104EB36EE5FEBD4", hash_generated_field = "B06E71DF7A343E20C8542F4E7F9F2A51")

    public String rawString;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.436 -0400", hash_original_method = "A5E243B4900F23BDC01508FC8D249E26", hash_generated_method = "7018932926AC83E9AF8E52329C5BE90F")
    public  AttributeValue(String parsedString, boolean hasQorE) {
        wasEncoded = false;
        this.hasQE = hasQorE;
        this.rawString = parsedString;
        this.escapedString = makeEscaped(rawString);
        // ---------- Original Method ----------
        //wasEncoded = false;
        //this.hasQE = hasQorE;
        //this.rawString = parsedString;
        //this.escapedString = makeEscaped(rawString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.442 -0400", hash_original_method = "5A85F043C6F0B70EF97E2EBE9C6D742A", hash_generated_method = "0E369B5A1C4D94BCE2CA60FD4793461E")
    public  AttributeValue(String hexString, byte[] encoded) {
        wasEncoded = true;
        this.hexString = hexString;
        this.encoded = encoded;
        try 
        {
            DerInputStream in;
            in = new DerInputStream(encoded);
            tag = in.tag;
            {
                boolean var7466733B22F4332843ED3830B816DED5_47859069 = (DirectoryString.ASN1.checkTag(tag));
                {
                    this.rawString = (String) DirectoryString.ASN1.decode(in);
                    this.escapedString = makeEscaped(rawString);
                } //End block
                {
                    this.rawString = hexString;
                    this.escapedString = hexString;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            IllegalArgumentException iae;
            iae = new IllegalArgumentException();
            iae.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw iae;
        } //End block
        // ---------- Original Method ----------
        //wasEncoded = true;
        //this.hexString = hexString;
        //this.encoded = encoded;
        //try {
            //DerInputStream in = new DerInputStream(encoded);
            //tag = in.tag;
            //if (DirectoryString.ASN1.checkTag(tag)) {
                //this.rawString = (String) DirectoryString.ASN1.decode(in);
                //this.escapedString = makeEscaped(rawString);
            //} else {
                //this.rawString = hexString;
                //this.escapedString = hexString;
            //}
        //} catch (IOException e) {
            //IllegalArgumentException iae = new IllegalArgumentException(); 
            //iae.initCause(e);
            //throw iae;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.445 -0400", hash_original_method = "B45EBCED75AEC87D8B9060BD1DB130BC", hash_generated_method = "FBE5BC997E95D3958A65AFB0663C96A6")
    public  AttributeValue(String rawString, byte[] encoded, int tag) {
        wasEncoded = true;
        this.encoded = encoded;
        this.tag = tag;
        {
            this.rawString = getHexString();
            this.escapedString = hexString;
        } //End block
        {
            this.rawString = rawString;
            this.escapedString = makeEscaped(rawString);
        } //End block
        // ---------- Original Method ----------
        //wasEncoded = true;
        //this.encoded = encoded;
        //this.tag = tag;
        //if (rawString == null) {
            //this.rawString = getHexString();
            //this.escapedString = hexString;
        //} else {
            //this.rawString = rawString;
            //this.escapedString = makeEscaped(rawString);
        //}
    }

    
        private static boolean isPrintableString(String str) {
        for (int i = 0; i< str.length(); ++i) {
            char ch = str.charAt(i);
            if (!(ch == 0x20
            || ch >= 0x27 && ch<= 0x29 
            || ch >= 0x2B && ch<= 0x3A 
            || ch == '='
            || ch == '?'
            || ch >= 'A' && ch<= 'Z'
            || ch >= 'a' && ch<= 'z')) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.446 -0400", hash_original_method = "01F8BD1A541A09C15BC5DA5B1F02995A", hash_generated_method = "9636802A31F16BA2287DCC938A027056")
    public int getTag() {
        {
            tag = isPrintableString(rawString)
                    ? ASN1StringType.PRINTABLESTRING.id
                    : ASN1StringType.UTF8STRING.id;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557590935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557590935;
        // ---------- Original Method ----------
        //if (tag == -1) {
            //tag = isPrintableString(rawString)
                    //? ASN1StringType.PRINTABLESTRING.id
                    //: ASN1StringType.UTF8STRING.id;
        //}
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.455 -0400", hash_original_method = "2B88DEF802689DAD6E450E66D9E740A5", hash_generated_method = "A38D29A7C267A7FAD0F2D71BC3371AA4")
    public String getHexString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1414410360 = null; //Variable for return #1
        {
            {
                encoded = isPrintableString(rawString)
                        ? ASN1StringType.PRINTABLESTRING.encode(rawString)
                        : ASN1StringType.UTF8STRING.encode(rawString);
            } //End block
            StringBuilder buf;
            buf = new StringBuilder(encoded.length * 2 + 1);
            buf.append('#');
            {
                int i, c;
                i = 0;
                {
                    c = (encoded[i] >> 4) & 0x0F;
                    {
                        buf.append((char) (c + 48));
                    } //End block
                    {
                        buf.append((char) (c + 87));
                    } //End block
                    c = encoded[i] & 0x0F;
                    {
                        buf.append((char) (c + 48));
                    } //End block
                    {
                        buf.append((char) (c + 87));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            hexString = buf.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1414410360 = hexString;
        varB4EAC82CA7396A68D541C85D26508E83_1414410360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1414410360;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.460 -0400", hash_original_method = "8E668EEB627F91F8E1893DDB676A8040", hash_generated_method = "D855E6C8BB63B0E9C56A490ECD8851CA")
    public void appendQEString(StringBuilder sb) {
        sb.append('"');
        {
            char c;
            {
                int i;
                i = 0;
                boolean var489536AE5EACF56C867BD0460A2CDE53_1495290249 = (i < rawString.length());
                {
                    c = rawString.charAt(i);
                    {
                        sb.append('\\');
                    } //End block
                    sb.append(c);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            sb.append(rawString);
        } //End block
        sb.append('"');
        addTaint(sb.getTaint());
        // ---------- Original Method ----------
        //sb.append('"');
        //if (hasQE) {
            //char c;
            //for (int i = 0; i < rawString.length(); i++) {
                //c = rawString.charAt(i);
                //if (c == '"' || c == '\\') {
                    //sb.append('\\');
                //}
                //sb.append(c);
            //}
        //} else {
            //sb.append(rawString);
        //}
        //sb.append('"');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.462 -0400", hash_original_method = "63614CD0FCED93BBCAC192EC682E4A51", hash_generated_method = "949CDB9460C61E88732406EB15E19FBD")
    private String makeEscaped(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1605728389 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1988610096 = null; //Variable for return #2
        int length;
        length = name.length();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1605728389 = name;
        } //End block
        StringBuilder buf;
        buf = new StringBuilder(length * 2);
        {
            int index;
            index = 0;
            {
                char ch;
                ch = name.charAt(index);
                //Begin case ' ' 
                {
                    buf.append('\\');
                } //End block
                //End case ' ' 
                //Begin case ' ' 
                buf.append(' ');
                //End case ' ' 
                //Begin case '"' '\\' 
                hasQE = true;
                //End case '"' '\\' 
                //Begin case '"' '\\' 
                buf.append('\\');
                //End case '"' '\\' 
                //Begin case '"' '\\' 
                buf.append(ch);
                //End case '"' '\\' 
                //Begin case ',' '+' '<' '>' ';' '#' '=' 
                buf.append('\\');
                //End case ',' '+' '<' '>' ';' '#' '=' 
                //Begin case ',' '+' '<' '>' ';' '#' '=' 
                buf.append(ch);
                //End case ',' '+' '<' '>' ';' '#' '=' 
                //Begin case default 
                buf.append(ch);
                //End case default 
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1988610096 = buf.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_246379555; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_246379555 = varB4EAC82CA7396A68D541C85D26508E83_1605728389;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_246379555 = varB4EAC82CA7396A68D541C85D26508E83_1988610096;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_246379555.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_246379555;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.477 -0400", hash_original_method = "2CE0F91F50A3484CAFB1D45D122355E5", hash_generated_method = "DCC6C29273E59131B4017F748B2A3161")
    public String makeCanonical() {
        String varB4EAC82CA7396A68D541C85D26508E83_1017707900 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1133702179 = null; //Variable for return #2
        int length;
        length = rawString.length();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1017707900 = rawString;
        } //End block
        StringBuilder buf;
        buf = new StringBuilder(length * 2);
        int index;
        index = 0;
        {
            boolean varF48C85942000814A2A20728333117321_1502080562 = (rawString.charAt(0) == '#');
            {
                buf.append('\\');
                buf.append('#');
            } //End block
        } //End collapsed parenthetic
        int bufLength;
        {
            char ch;
            ch = rawString.charAt(index);
            //Begin case ' ' 
            bufLength = buf.length();
            //End case ' ' 
            //Begin case ' ' 
            {
                boolean var76068870855D73C60B790CBF930511C6_989397698 = (bufLength == 0 || buf.charAt(bufLength - 1) == ' ');
            } //End collapsed parenthetic
            //End case ' ' 
            //Begin case ' ' 
            buf.append(' ');
            //End case ' ' 
            //Begin case '"' '\\' ',' '+' '<' '>' ';' 
            buf.append('\\');
            //End case '"' '\\' ',' '+' '<' '>' ';' 
            //Begin case default 
            buf.append(ch);
            //End case default 
        } //End block
        {
            bufLength = buf.length() - 1;
            boolean varF07DB73BE4727375CF1F8671293E732D_918711873 = (bufLength > -1
                && buf.charAt(bufLength) == ' ');
        } //End collapsed parenthetic
        buf.setLength(bufLength + 1);
        varB4EAC82CA7396A68D541C85D26508E83_1133702179 = buf.toString();
        String varA7E53CE21691AB073D9660D615818899_1237844993; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1237844993 = varB4EAC82CA7396A68D541C85D26508E83_1017707900;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1237844993 = varB4EAC82CA7396A68D541C85D26508E83_1133702179;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1237844993.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1237844993;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

