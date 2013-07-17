package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.DerInputStream;

public final class AttributeValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.713 -0400", hash_original_field = "1B9369CE805E2E405AA325049258CD66", hash_generated_field = "D85F8A65E9DE43097BB265479C87E73B")

    public boolean wasEncoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.713 -0400", hash_original_field = "1BD737972B6402C63472543389F9660E", hash_generated_field = "4A17972559F62AB2783311336A9D4582")

    public String escapedString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.713 -0400", hash_original_field = "6325307BA7A35071F7CCF392A5DEF623", hash_generated_field = "6CF85B6901CE5996CC9D91D793C48B7A")

    private String hexString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.713 -0400", hash_original_field = "FDC324D07BAC6B5172A85181924BBEE8", hash_generated_field = "917AECB67DEB49506F6054710716A2C2")

    private int tag = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.713 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "8DF314849D9BDCEAE78F4B8DFF0C1E45")

    public byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.713 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "1395852C401E496F85701A0A9D82F003")

    public byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.713 -0400", hash_original_field = "EC32FC5A9FC36F29B6B89F4826B648EF", hash_generated_field = "439798B0B0B82905E05B97B14950EE49")

    public boolean hasQE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.713 -0400", hash_original_field = "86C8EF5116F9F2D53104EB36EE5FEBD4", hash_generated_field = "B06E71DF7A343E20C8542F4E7F9F2A51")

    public String rawString;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.714 -0400", hash_original_method = "A5E243B4900F23BDC01508FC8D249E26", hash_generated_method = "7018932926AC83E9AF8E52329C5BE90F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.716 -0400", hash_original_method = "5A85F043C6F0B70EF97E2EBE9C6D742A", hash_generated_method = "5EDBA688924A1FB605AF8106E6508D90")
    public  AttributeValue(String hexString, byte[] encoded) {
        wasEncoded = true;
        this.hexString = hexString;
        this.encoded = encoded;
        try 
        {
            DerInputStream in = new DerInputStream(encoded);
            tag = in.tag;
            if(DirectoryString.ASN1.checkTag(tag))            
            {
                this.rawString = (String) DirectoryString.ASN1.decode(in);
                this.escapedString = makeEscaped(rawString);
            } //End block
            else
            {
                this.rawString = hexString;
                this.escapedString = hexString;
            } //End block
        } //End block
        catch (IOException e)
        {
            IllegalArgumentException iae = new IllegalArgumentException();
            iae.initCause(e);
            iae.addTaint(taint);
            throw iae;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.718 -0400", hash_original_method = "B45EBCED75AEC87D8B9060BD1DB130BC", hash_generated_method = "3E7830540965546C3C6ADA1C6AFC24EB")
    public  AttributeValue(String rawString, byte[] encoded, int tag) {
        wasEncoded = true;
        this.encoded = encoded;
        this.tag = tag;
        if(rawString == null)        
        {
            this.rawString = getHexString();
            this.escapedString = hexString;
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.719 -0400", hash_original_method = "01F8BD1A541A09C15BC5DA5B1F02995A", hash_generated_method = "5919327E047A467DDDD06BE71976A089")
    public int getTag() {
        if(tag == -1)        
        {
            tag = isPrintableString(rawString)
                    ? ASN1StringType.PRINTABLESTRING.id
                    : ASN1StringType.UTF8STRING.id;
        } //End block
        int varE4D23E841D8E8804190027BCE3180FA5_2109526823 = (tag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_742479372 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_742479372;
        // ---------- Original Method ----------
        //if (tag == -1) {
            //tag = isPrintableString(rawString)
                    //? ASN1StringType.PRINTABLESTRING.id
                    //: ASN1StringType.UTF8STRING.id;
        //}
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.720 -0400", hash_original_method = "2B88DEF802689DAD6E450E66D9E740A5", hash_generated_method = "06FDD37E452896E7DE47C7B8A362BF1B")
    public String getHexString() {
        if(hexString == null)        
        {
            if(!wasEncoded)            
            {
                encoded = isPrintableString(rawString)
                        ? ASN1StringType.PRINTABLESTRING.encode(rawString)
                        : ASN1StringType.UTF8STRING.encode(rawString);
            } //End block
            StringBuilder buf = new StringBuilder(encoded.length * 2 + 1);
            buf.append('#');
for(int i = 0, c;i < encoded.length;i++)
            {
                c = (encoded[i] >> 4) & 0x0F;
                if(c < 10)                
                {
                    buf.append((char) (c + 48));
                } //End block
                else
                {
                    buf.append((char) (c + 87));
                } //End block
                c = encoded[i] & 0x0F;
                if(c < 10)                
                {
                    buf.append((char) (c + 48));
                } //End block
                else
                {
                    buf.append((char) (c + 87));
                } //End block
            } //End block
            hexString = buf.toString();
        } //End block
String varBA008EE6531228751573AF399048D4DC_27548481 =         hexString;
        varBA008EE6531228751573AF399048D4DC_27548481.addTaint(taint);
        return varBA008EE6531228751573AF399048D4DC_27548481;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.721 -0400", hash_original_method = "8E668EEB627F91F8E1893DDB676A8040", hash_generated_method = "B9958E763EE84DD36FDECB87BFAF164E")
    public void appendQEString(StringBuilder sb) {
        addTaint(sb.getTaint());
        sb.append('"');
        if(hasQE)        
        {
            char c;
for(int i = 0;i < rawString.length();i++)
            {
                c = rawString.charAt(i);
                if(c == '"' || c == '\\')                
                {
                    sb.append('\\');
                } //End block
                sb.append(c);
            } //End block
        } //End block
        else
        {
            sb.append(rawString);
        } //End block
        sb.append('"');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.721 -0400", hash_original_method = "63614CD0FCED93BBCAC192EC682E4A51", hash_generated_method = "1B62E56033DA596B7F47D5383B534E96")
    private String makeEscaped(String name) {
        addTaint(name.getTaint());
        int length = name.length();
        if(length == 0)        
        {
String varB017984728AC60AD1F0BF8734F33F15C_1462282662 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_1462282662.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_1462282662;
        } //End block
        StringBuilder buf = new StringBuilder(length * 2);
for(int index = 0;index < length;index++)
        {
            char ch = name.charAt(index);
switch(ch){
            case ' ':
            if(index == 0 || index == (length - 1))            
            {
                buf.append('\\');
            } //End block
            buf.append(' ');
            break;
            case '"':
            case '\\':
            hasQE = true;
            buf.append('\\');
            buf.append(ch);
            break;
            case ',':
            case '+':
            case '<':
            case '>':
            case ';':
            case '#':
            case '=':
            buf.append('\\');
            buf.append(ch);
            break;
            default:
            buf.append(ch);
            break;
}
        } //End block
String var4FC680801218E6372BC708D6FA44AE60_1206425441 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1206425441.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1206425441;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.722 -0400", hash_original_method = "2CE0F91F50A3484CAFB1D45D122355E5", hash_generated_method = "E62DBAD9475901348E8CF2F02F26AFD9")
    public String makeCanonical() {
        int length = rawString.length();
        if(length == 0)        
        {
String var4B9D0983C640FEFA2A1CCD188F4CB7B8_1796945580 =             rawString;
            var4B9D0983C640FEFA2A1CCD188F4CB7B8_1796945580.addTaint(taint);
            return var4B9D0983C640FEFA2A1CCD188F4CB7B8_1796945580;
        } //End block
        StringBuilder buf = new StringBuilder(length * 2);
        int index = 0;
        if(rawString.charAt(0) == '#')        
        {
            buf.append('\\');
            buf.append('#');
            index++;
        } //End block
        int bufLength;
for(;index < length;index++)
        {
            char ch = rawString.charAt(index);
switch(ch){
            case ' ':
            bufLength = buf.length();
            if(bufLength == 0 || buf.charAt(bufLength - 1) == ' ')            
            {
                break;
            } //End block
            buf.append(' ');
            break;
            case '"':
            case '\\':
            case ',':
            case '+':
            case '<':
            case '>':
            case ';':
            buf.append('\\');
            default:
            buf.append(ch);
}
        } //End block
for(bufLength = buf.length() - 1;bufLength > -1
                && buf.charAt(bufLength) == ' ';bufLength--)
        {
        } //End block
        buf.setLength(bufLength + 1);
String var4FC680801218E6372BC708D6FA44AE60_827686400 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_827686400.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_827686400;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

