package org.bouncycastle.util.io.pem;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.util.encoders.Base64;

public class PemReader extends BufferedReader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.383 -0400", hash_original_method = "422165DD33429D3A249B1D2E2C0897A9", hash_generated_method = "5592100559038DF99263536657464ADF")
    public  PemReader(Reader reader) {
        super(reader);
        addTaint(reader.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.384 -0400", hash_original_method = "D58B040BED022541C97B3ACE6DF7F511", hash_generated_method = "D4EA3C54B7BF3BDE85B6EA769B4D9EEF")
    public PemObject readPemObject() throws IOException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_353841840 = null; 
        PemObject varB4EAC82CA7396A68D541C85D26508E83_2046261861 = null; 
        String line = readLine();
        {
            boolean var6003EFBA66BA1B979DFF34F710C1C1A9_1189416974 = (line != null && line.startsWith(BEGIN));
            {
                line = line.substring(BEGIN.length());
                int index = line.indexOf('-');
                String type = line.substring(0, index);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_353841840 = loadObject(type);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2046261861 = null;
        PemObject varA7E53CE21691AB073D9660D615818899_193294681; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_193294681 = varB4EAC82CA7396A68D541C85D26508E83_353841840;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_193294681 = varB4EAC82CA7396A68D541C85D26508E83_2046261861;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_193294681.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_193294681;
        
        
        
        
            
            
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.386 -0400", hash_original_method = "B4339AB43686CE97B8B754B51FC0C571", hash_generated_method = "CD7E5AA6E89953A38815FF1F6B040A87")
    private PemObject loadObject(String type) throws IOException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_50587800 = null; 
        String line;
        String endMarker = END + type;
        StringBuffer buf = new StringBuffer();
        List headers = new ArrayList();
        {
            boolean varB7B4B8211310A2E4109AA8FCB4B4D760_862058497 = ((line = readLine()) != null);
            {
                {
                    boolean varFCDE5AC4CFB1198ED9954991DCD02499_2032318788 = (line.indexOf(":") >= 0);
                    {
                        int index = line.indexOf(':');
                        String hdr = line.substring(0, index);
                        String value = line.substring(index + 1).trim();
                        headers.add(new PemHeader(hdr, value));
                    } 
                } 
                {
                    boolean var013E33F2E4E7F1B5281ED067A196F717_1143719711 = (line.indexOf(endMarker) != -1);
                } 
                buf.append(line.trim());
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(endMarker + " not found");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_50587800 = new PemObject(type, headers, Base64.decode(buf.toString()));
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_50587800.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_50587800;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.386 -0400", hash_original_field = "20A8C2705F62633A6C198025CB3E9306", hash_generated_field = "3012F10FFC028E270306D326E4F2BB4D")

    private static final String BEGIN = "-----BEGIN ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.386 -0400", hash_original_field = "2E57F28A99A70BA82478B238D4989DCC", hash_generated_field = "33FE8EF509AB5350D82B1C830CA62BCF")

    private static final String END = "-----END ";
}

