package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.AttributeValue;

public final class DNParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.796 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.796 -0400", hash_original_field = "63A08F52A29E0F7A1F987F4495164AB0", hash_generated_field = "281969654EB14E15446253F1D771C5B0")

    private int beg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.796 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.796 -0400", hash_original_field = "B69D9BC635CCD79AD2C64BC862ABE3B4", hash_generated_field = "8CFCF0E96717F68959883591D279E158")

    private char[] chars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.796 -0400", hash_original_field = "EC32FC5A9FC36F29B6B89F4826B648EF", hash_generated_field = "790BB9C226E70D863513D01FB9E5249C")

    private boolean hasQE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.796 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.797 -0400", hash_original_method = "66B2F9736FABC0973929FB105735B82E", hash_generated_method = "5286CFA825BD8D2CE0A88F3464588C97")
    public  DNParser(String dn) throws IOException {
        chars = dn.toCharArray();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.798 -0400", hash_original_method = "7D5C37EF81BA8B102CA672C27E3E2647", hash_generated_method = "2DCF0CA78549E0C02CE0CA9A52FEE478")
    private String nextAT() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_468152528 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_784245186 = null; 
        hasQE = false;
        {
            varB4EAC82CA7396A68D541C85D26508E83_468152528 = null;
        } 
        beg = pos;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } 
        end = pos;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } 
        } 
        {
            beg += 4;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_784245186 = new String(chars, beg, end - beg);
        String varA7E53CE21691AB073D9660D615818899_1585075711; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1585075711 = varB4EAC82CA7396A68D541C85D26508E83_468152528;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1585075711 = varB4EAC82CA7396A68D541C85D26508E83_784245186;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1585075711.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1585075711;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.799 -0400", hash_original_method = "5F9B58135FF863A8E24F4B2AD9DF48BE", hash_generated_method = "78AAF80F8226EDEE48ADF563C61E3A94")
    private String quotedAV() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_319527868 = null; 
        beg = pos;
        end = beg;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } 
            {
                chars[end] = getEscaped();
            } 
            {
                chars[end] = chars[pos];
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_319527868 = new String(chars, beg, end - beg);
        varB4EAC82CA7396A68D541C85D26508E83_319527868.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_319527868;
        
        
        
        
        
            
                
            
            
                
                
            
                
            
                
            
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.801 -0400", hash_original_method = "59E635302CD6807B36C1A45A26BE591E", hash_generated_method = "F9B6633A47A7431073F90320F6E1F2CF")
    private String hexAV() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_560699049 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } 
        beg = pos;
        {
            {
                end = pos;
            } 
            {
                end = pos;
            } 
            {
                chars[pos] += 32;
            } 
        } 
        int hexLen = end - beg;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } 
        encoded = new byte[hexLen / 2];
        {
            int i = 0;
            int p = beg + 1;
            p += 2;
            {
                encoded[i] = (byte) getByte(p);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_560699049 = new String(chars, beg, hexLen);
        varB4EAC82CA7396A68D541C85D26508E83_560699049.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_560699049;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.802 -0400", hash_original_method = "FC33535E1A62E80F93C12FF4F8D2E290", hash_generated_method = "1AB4ABF8BFADE62704B25BC13F43C397")
    private String escapedAV() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1385608726 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1037831175 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1553517483 = null; 
        beg = pos;
        end = pos;
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1385608726 = new String(chars, beg, end - beg);
            } 
            
            varB4EAC82CA7396A68D541C85D26508E83_1037831175 = new String(chars, beg, end - beg);
            
            
            chars[end++] = getEscaped();
            
            
            int cur = end;
            
            
            chars[end++] = ' ';
            
            
            {
                chars[end++] = ' ';
            } 
            
            
            {
                varB4EAC82CA7396A68D541C85D26508E83_1553517483 = new String(chars, beg, cur - beg);
            } 
            
            
            chars[end++] = chars[pos];
            
        } 
        String varA7E53CE21691AB073D9660D615818899_1387322627; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1387322627 = varB4EAC82CA7396A68D541C85D26508E83_1385608726;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1387322627 = varB4EAC82CA7396A68D541C85D26508E83_1037831175;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1387322627 = varB4EAC82CA7396A68D541C85D26508E83_1553517483;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1387322627.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1387322627;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.803 -0400", hash_original_method = "1A89A1602A29634CB35E16E135F5FE74", hash_generated_method = "29D994AC20F95C79B0DB7E0AD4522E0B")
    private char getEscaped() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } 
        char ch = chars[pos];
        
        hasQE = true;
        
        
        char var6B59433B346D0CF4C614C82DD9B9249C_1861776002 = (getUTF8());
        
        char varA87DEB01C5F539E6BDA34829C8EF2368_1592291534 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1592291534;
        
        
        
            
        
        
        
        
        
            
            
        
        
        
        
        
        
        
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.803 -0400", hash_original_method = "12C3774F0261E7D12FCB54FD470B78E6", hash_generated_method = "2DD86A70D5A1FB5F0B1B0D70EC532D82")
    protected char getUTF8() throws IOException {
        int res = getByte(pos);
        {
            int count;
            {
                count = 1;
                res = res & 0x1F;
            } 
            {
                count = 2;
                res = res & 0x0F;
            } 
            {
                count = 3;
                res = res & 0x07;
            } 
            int b;
            {
                int i = 0;
                {
                    b = getByte(pos);
                    res = (res << 6) + (b & 0x3F);
                } 
            } 
        } 
        char varA87DEB01C5F539E6BDA34829C8EF2368_1465344202 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1465344202;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.804 -0400", hash_original_method = "C98D163E17FC33654783E302104D54C8", hash_generated_method = "E3240DA4C0CB34D174062A9DCF00716C")
    private int getByte(int position) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } 
        int b1 = chars[position];
        {
            b1 = b1 - '0';
        } 
        {
            b1 = b1 - 87;
        } 
        {
            b1 = b1 - 55;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } 
        int b2 = chars[position + 1];
        {
            b2 = b2 - '0';
        } 
        {
            b2 = b2 - 87;
        } 
        {
            b2 = b2 - 55;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
        } 
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1845482370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1845482370;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.805 -0400", hash_original_method = "17512CE00D4450F012CF195B2D29239B", hash_generated_method = "4B1CA750E4308A226BD6BEDAAB611E4E")
    public List<List<AttributeTypeAndValue>> parse() throws IOException {
        List<List<AttributeTypeAndValue>> varB4EAC82CA7396A68D541C85D26508E83_1845666995 = null; 
        List<List<AttributeTypeAndValue>> varB4EAC82CA7396A68D541C85D26508E83_777302201 = null; 
        List<List<AttributeTypeAndValue>> varB4EAC82CA7396A68D541C85D26508E83_1601974668 = null; 
        List<List<AttributeTypeAndValue>> list = new ArrayList<List<AttributeTypeAndValue>>();
        String attType = nextAT();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1845666995 = list;
        } 
        List<AttributeTypeAndValue> atav = new ArrayList<AttributeTypeAndValue>();
        {
            {
                atav.add(new AttributeTypeAndValue(attType, new AttributeValue("", false)));
                list.add(0, atav);
                varB4EAC82CA7396A68D541C85D26508E83_777302201 = list;
            } 
            
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue(quotedAV(), hasQE)));
            
            
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue(hexAV(), encoded)));
            
            
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue("", false)));
            
            
            atav.add(new AttributeTypeAndValue(attType, new AttributeValue(
                        escapedAV(), hasQE)));
            
            {
                list.add(0, atav);
                varB4EAC82CA7396A68D541C85D26508E83_1601974668 = list;
            } 
            {
                list.add(0, atav);
                atav = new ArrayList<AttributeTypeAndValue>();
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } 
            attType = nextAT();
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid distinguished name string");
            } 
        } 
        List<List<AttributeTypeAndValue>> varA7E53CE21691AB073D9660D615818899_1608297778; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1608297778 = varB4EAC82CA7396A68D541C85D26508E83_1845666995;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1608297778 = varB4EAC82CA7396A68D541C85D26508E83_777302201;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1608297778 = varB4EAC82CA7396A68D541C85D26508E83_1601974668;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1608297778.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1608297778;
        
        
    }

    
}

