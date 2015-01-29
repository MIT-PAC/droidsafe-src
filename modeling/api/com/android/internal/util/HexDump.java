package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class HexDump {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.078 -0500", hash_original_method = "7FA399DA453396F4D2EEE2775C9F35FF", hash_generated_method = "E23151A364951C4396F43DB5E2BA25CD")
    
public static String dumpHexString(byte[] array)
    {
        return dumpHexString(array, 0, array.length);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.081 -0500", hash_original_method = "6D001C7E00C3CE7619E8E874960F2D9E", hash_generated_method = "AC8D0CFA06752AA14BBB162F26494447")
    
public static String dumpHexString(byte[] array, int offset, int length)
    {
        StringBuilder result = new StringBuilder();
        
        byte[] line = new byte[16];
        int lineIndex = 0;
        
        result.append("\n0x");
        result.append(toHexString(offset));
        
        for (int i = offset ; i < offset + length ; i++)
        {
            if (lineIndex == 16)
            {
                result.append(" ");
                
                for (int j = 0 ; j < 16 ; j++)
                {
                    if (line[j] > ' ' && line[j] < '~')
                    {
                        result.append(new String(line, j, 1));
                    }
                    else
                    {
                        result.append(".");
                    }
                }
                
                result.append("\n0x");
                result.append(toHexString(i));
                lineIndex = 0;
            }
            
            byte b = array[i];
            result.append(" ");
            result.append(HEX_DIGITS[(b >>> 4) & 0x0F]);
            result.append(HEX_DIGITS[b & 0x0F]);
            
            line[lineIndex++] = b;
        }
        
        if (lineIndex != 16)
        {
            int count = (16 - lineIndex) * 3;
            count++;
            for (int i = 0 ; i < count ; i++)
            {
                result.append(" ");
            }
            
            for (int i = 0 ; i < lineIndex ; i++)
            {
                if (line[i] > ' ' && line[i] < '~')
                {
                    result.append(new String(line, i, 1));
                }
                else
                {
                    result.append(".");
                }
            }
        }
        
        return result.toString();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.083 -0500", hash_original_method = "BA869BF39EB1A5D9EFA5B926AFA6E3ED", hash_generated_method = "D55E178621593D7590AB7C5F0410BA00")
    
public static String toHexString(byte b)
    {
        return toHexString(toByteArray(b));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.086 -0500", hash_original_method = "2B461C41F59F4BBEB103C84DAFFF95E4", hash_generated_method = "6CA119F2FAAD5EE7576244BBA8DBC96C")
    
public static String toHexString(byte[] array)
    {
        return toHexString(array, 0, array.length);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.088 -0500", hash_original_method = "FDE867589E5B51F6209F598560A4738D", hash_generated_method = "68B0C1FA9F122D6516D7E83EC4EBBAF4")
    
public static String toHexString(byte[] array, int offset, int length)
    {
        char[] buf = new char[length * 2];

        int bufIndex = 0;
        for (int i = offset ; i < offset + length; i++) 
        {
            byte b = array[i];
            buf[bufIndex++] = HEX_DIGITS[(b >>> 4) & 0x0F];
            buf[bufIndex++] = HEX_DIGITS[b & 0x0F];
        }

        return new String(buf);        
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.090 -0500", hash_original_method = "B157F4A1E101F1E60BB7F2E01FC9F6DA", hash_generated_method = "1E2044860E09E3C0402A19F40C6C7C41")
    
public static String toHexString(int i)
    {
        return toHexString(toByteArray(i));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.093 -0500", hash_original_method = "F35514D23B7EC0201304108EB7846BA0", hash_generated_method = "2EE5C81556239D2CC5D0289FADE21656")
    
public static byte[] toByteArray(byte b)
    {
        byte[] array = new byte[1];
        array[0] = b;
        return array;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.096 -0500", hash_original_method = "9500957DFE8BAA9DAE04444E360591E5", hash_generated_method = "1973A6D615C066176559D7F29F8FDE00")
    
public static byte[] toByteArray(int i)
    {
        byte[] array = new byte[4];
        
        array[3] = (byte)(i & 0xFF);
        array[2] = (byte)((i >> 8) & 0xFF);
        array[1] = (byte)((i >> 16) & 0xFF);
        array[0] = (byte)((i >> 24) & 0xFF);
        
        return array;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.098 -0500", hash_original_method = "5A3669A0F97ABE322D99A6FE1918D1AA", hash_generated_method = "01A101033B4AC0A655225EFED6798AF4")
    
private static int toByte(char c)
    {
        if (c >= '0' && c <= '9') return (c - '0');
        if (c >= 'A' && c <= 'F') return (c - 'A' + 10);
        if (c >= 'a' && c <= 'f') return (c - 'a' + 10);

        throw new RuntimeException ("Invalid hex char '" + c + "'");
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.101 -0500", hash_original_method = "E285E1106C0B9E132A4F1F1878A6B1BC", hash_generated_method = "CDF4A7049CEE4795139933F5DC6F5B01")
    
public static byte[] hexStringToByteArray(String hexString)
    {
        int length = hexString.length();
        byte[] buffer = new byte[length / 2];

        for (int i = 0 ; i < length ; i += 2)
        {
            buffer[i / 2] = (byte)((toByte(hexString.charAt(i)) << 4) | toByte(hexString.charAt(i+1)));
        }
        
        return buffer;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:49.076 -0500", hash_original_field = "3D1F00D92E68E7AF7131B9257AA44523", hash_generated_field = "13725BDB05CFF8B147726B2CE8E01291")

    private final static char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.746 -0400", hash_original_method = "41D5EB93F66EEE1C2A5191C2288E5263", hash_generated_method = "41D5EB93F66EEE1C2A5191C2288E5263")
    public HexDump ()
    {
        //Synthesized constructor
    }
}

