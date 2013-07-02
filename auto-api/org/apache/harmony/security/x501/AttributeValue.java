package org.apache.harmony.security.x501;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.DerInputStream;

public final class AttributeValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.531 -0400", hash_original_field = "1B9369CE805E2E405AA325049258CD66", hash_generated_field = "D85F8A65E9DE43097BB265479C87E73B")

    public boolean wasEncoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.531 -0400", hash_original_field = "1BD737972B6402C63472543389F9660E", hash_generated_field = "4A17972559F62AB2783311336A9D4582")

    public String escapedString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.531 -0400", hash_original_field = "6325307BA7A35071F7CCF392A5DEF623", hash_generated_field = "6CF85B6901CE5996CC9D91D793C48B7A")

    private String hexString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.531 -0400", hash_original_field = "FDC324D07BAC6B5172A85181924BBEE8", hash_generated_field = "917AECB67DEB49506F6054710716A2C2")

    private int tag = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.531 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "8DF314849D9BDCEAE78F4B8DFF0C1E45")

    public byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.531 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "1395852C401E496F85701A0A9D82F003")

    public byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.531 -0400", hash_original_field = "EC32FC5A9FC36F29B6B89F4826B648EF", hash_generated_field = "439798B0B0B82905E05B97B14950EE49")

    public boolean hasQE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.531 -0400", hash_original_field = "86C8EF5116F9F2D53104EB36EE5FEBD4", hash_generated_field = "B06E71DF7A343E20C8542F4E7F9F2A51")

    public String rawString;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.531 -0400", hash_original_method = "A5E243B4900F23BDC01508FC8D249E26", hash_generated_method = "7018932926AC83E9AF8E52329C5BE90F")
    public  AttributeValue(String parsedString, boolean hasQorE) {
        wasEncoded = false;
        this.hasQE = hasQorE;
        this.rawString = parsedString;
        this.escapedString = makeEscaped(rawString);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.532 -0400", hash_original_method = "5A85F043C6F0B70EF97E2EBE9C6D742A", hash_generated_method = "FF00181684B6FF59DD967DD75317AC60")
    public  AttributeValue(String hexString, byte[] encoded) {
        wasEncoded = true;
        this.hexString = hexString;
        this.encoded = encoded;
        try 
        {
            DerInputStream in = new DerInputStream(encoded);
            tag = in.tag;
            {
                boolean var7466733B22F4332843ED3830B816DED5_2114577284 = (DirectoryString.ASN1.checkTag(tag));
                {
                    this.rawString = (String) DirectoryString.ASN1.decode(in);
                    this.escapedString = makeEscaped(rawString);
                } 
                {
                    this.rawString = hexString;
                    this.escapedString = hexString;
                } 
            } 
        } 
        catch (IOException e)
        {
            IllegalArgumentException iae = new IllegalArgumentException();
            iae.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw iae;
        } 
        
        
        
        
        
            
            
            
                
                
            
                
                
            
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.532 -0400", hash_original_method = "B45EBCED75AEC87D8B9060BD1DB130BC", hash_generated_method = "FBE5BC997E95D3958A65AFB0663C96A6")
    public  AttributeValue(String rawString, byte[] encoded, int tag) {
        wasEncoded = true;
        this.encoded = encoded;
        this.tag = tag;
        {
            this.rawString = getHexString();
            this.escapedString = hexString;
        } 
        {
            this.rawString = rawString;
            this.escapedString = makeEscaped(rawString);
        } 
        
        
        
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.533 -0400", hash_original_method = "01F8BD1A541A09C15BC5DA5B1F02995A", hash_generated_method = "C88F3B17A26EC47457B1C3CE3C6C0CE0")
    public int getTag() {
        {
            tag = isPrintableString(rawString)
                    ? ASN1StringType.PRINTABLESTRING.id
                    : ASN1StringType.UTF8STRING.id;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723383134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723383134;
        
        
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.534 -0400", hash_original_method = "2B88DEF802689DAD6E450E66D9E740A5", hash_generated_method = "2A9D4DC9E58090D6F14D626B4E720F8C")
    public String getHexString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2137897742 = null; 
        {
            {
                encoded = isPrintableString(rawString)
                        ? ASN1StringType.PRINTABLESTRING.encode(rawString)
                        : ASN1StringType.UTF8STRING.encode(rawString);
            } 
            StringBuilder buf = new StringBuilder(encoded.length * 2 + 1);
            buf.append('#');
            {
                int i = 0;
                int c;
                {
                    c = (encoded[i] >> 4) & 0x0F;
                    {
                        buf.append((char) (c + 48));
                    } 
                    {
                        buf.append((char) (c + 87));
                    } 
                    c = encoded[i] & 0x0F;
                    {
                        buf.append((char) (c + 48));
                    } 
                    {
                        buf.append((char) (c + 87));
                    } 
                } 
            } 
            hexString = buf.toString();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2137897742 = hexString;
        varB4EAC82CA7396A68D541C85D26508E83_2137897742.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2137897742;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.536 -0400", hash_original_method = "8E668EEB627F91F8E1893DDB676A8040", hash_generated_method = "B4843B88ADE12BC0E3CB6005E617EDE2")
    public void appendQEString(StringBuilder sb) {
        sb.append('"');
        {
            char c;
            {
                int i = 0;
                boolean var489536AE5EACF56C867BD0460A2CDE53_1186559881 = (i < rawString.length());
                {
                    c = rawString.charAt(i);
                    {
                        sb.append('\\');
                    } 
                    sb.append(c);
                } 
            } 
        } 
        {
            sb.append(rawString);
        } 
        sb.append('"');
        addTaint(sb.getTaint());
        
        
        
            
            
                
                
                    
                
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.537 -0400", hash_original_method = "63614CD0FCED93BBCAC192EC682E4A51", hash_generated_method = "BC09208A89091E06091A1A5E088DA842")
    private String makeEscaped(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_251599503 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1693125760 = null; 
        int length = name.length();
        {
            varB4EAC82CA7396A68D541C85D26508E83_251599503 = name;
        } 
        StringBuilder buf = new StringBuilder(length * 2);
        {
            int index = 0;
            {
                char ch = name.charAt(index);
                
                {
                    buf.append('\\');
                } 
                
                
                buf.append(' ');
                
                
                hasQE = true;
                
                
                buf.append('\\');
                
                
                buf.append(ch);
                
                
                buf.append('\\');
                
                
                buf.append(ch);
                
                
                buf.append(ch);
                
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1693125760 = buf.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1146549190; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1146549190 = varB4EAC82CA7396A68D541C85D26508E83_251599503;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1146549190 = varB4EAC82CA7396A68D541C85D26508E83_1693125760;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1146549190.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1146549190;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.538 -0400", hash_original_method = "2CE0F91F50A3484CAFB1D45D122355E5", hash_generated_method = "4D3B2D18CD9C39132CEB3297BF8E2CB3")
    public String makeCanonical() {
        String varB4EAC82CA7396A68D541C85D26508E83_843266045 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1492981007 = null; 
        int length = rawString.length();
        {
            varB4EAC82CA7396A68D541C85D26508E83_843266045 = rawString;
        } 
        StringBuilder buf = new StringBuilder(length * 2);
        int index = 0;
        {
            boolean varF48C85942000814A2A20728333117321_1842007988 = (rawString.charAt(0) == '#');
            {
                buf.append('\\');
                buf.append('#');
            } 
        } 
        int bufLength;
        {
            char ch = rawString.charAt(index);
            
            bufLength = buf.length();
            
            
            {
                boolean var76068870855D73C60B790CBF930511C6_135386570 = (bufLength == 0 || buf.charAt(bufLength - 1) == ' ');
            } 
            
            
            buf.append(' ');
            
            
            buf.append('\\');
            
            
            buf.append(ch);
            
        } 
        {
            bufLength = buf.length() - 1;
            boolean varF07DB73BE4727375CF1F8671293E732D_1809311317 = (bufLength > -1
                && buf.charAt(bufLength) == ' ');
        } 
        buf.setLength(bufLength + 1);
        varB4EAC82CA7396A68D541C85D26508E83_1492981007 = buf.toString();
        String varA7E53CE21691AB073D9660D615818899_1108512966; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1108512966 = varB4EAC82CA7396A68D541C85D26508E83_843266045;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1108512966 = varB4EAC82CA7396A68D541C85D26508E83_1492981007;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1108512966.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1108512966;
        
        
    }

    
}

