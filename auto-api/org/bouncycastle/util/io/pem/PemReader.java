package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.util.encoders.Base64;

public class PemReader extends BufferedReader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.943 -0400", hash_original_method = "422165DD33429D3A249B1D2E2C0897A9", hash_generated_method = "5592100559038DF99263536657464ADF")
    public  PemReader(Reader reader) {
        super(reader);
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.953 -0400", hash_original_method = "D58B040BED022541C97B3ACE6DF7F511", hash_generated_method = "B26E40A6C83A11D5A2C3F546B853C4B1")
    public PemObject readPemObject() throws IOException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_1203322348 = null; //Variable for return #1
        PemObject varB4EAC82CA7396A68D541C85D26508E83_1245286387 = null; //Variable for return #2
        String line;
        line = readLine();
        {
            boolean var6003EFBA66BA1B979DFF34F710C1C1A9_1884881371 = (line != null && line.startsWith(BEGIN));
            {
                line = line.substring(BEGIN.length());
                int index;
                index = line.indexOf('-');
                String type;
                type = line.substring(0, index);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1203322348 = loadObject(type);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1245286387 = null;
        PemObject varA7E53CE21691AB073D9660D615818899_1375898619; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1375898619 = varB4EAC82CA7396A68D541C85D26508E83_1203322348;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1375898619 = varB4EAC82CA7396A68D541C85D26508E83_1245286387;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1375898619.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1375898619;
        // ---------- Original Method ----------
        //String line = readLine();
        //if (line != null && line.startsWith(BEGIN))
        //{
            //line = line.substring(BEGIN.length());
            //int index = line.indexOf('-');
            //String type = line.substring(0, index);
            //if (index > 0)
            //{
                //return loadObject(type);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.954 -0400", hash_original_method = "B4339AB43686CE97B8B754B51FC0C571", hash_generated_method = "31757B85D6345BD798496543972BD17D")
    private PemObject loadObject(String type) throws IOException {
        PemObject varB4EAC82CA7396A68D541C85D26508E83_1749039988 = null; //Variable for return #1
        String line;
        String endMarker;
        endMarker = END + type;
        StringBuffer buf;
        buf = new StringBuffer();
        List headers;
        headers = new ArrayList();
        {
            boolean varB7B4B8211310A2E4109AA8FCB4B4D760_1907825352 = ((line = readLine()) != null);
            {
                {
                    boolean varFCDE5AC4CFB1198ED9954991DCD02499_1679930073 = (line.indexOf(":") >= 0);
                    {
                        int index;
                        index = line.indexOf(':');
                        String hdr;
                        hdr = line.substring(0, index);
                        String value;
                        value = line.substring(index + 1).trim();
                        headers.add(new PemHeader(hdr, value));
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var013E33F2E4E7F1B5281ED067A196F717_804561614 = (line.indexOf(endMarker) != -1);
                } //End collapsed parenthetic
                buf.append(line.trim());
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(endMarker + " not found");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1749039988 = new PemObject(type, headers, Base64.decode(buf.toString()));
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1749039988.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1749039988;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.954 -0400", hash_original_field = "20A8C2705F62633A6C198025CB3E9306", hash_generated_field = "FEDE3C58A859361CB2EE4384AEFCB3BA")

    private static String BEGIN = "-----BEGIN ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.954 -0400", hash_original_field = "2E57F28A99A70BA82478B238D4989DCC", hash_generated_field = "385C0F1D5DFD07EB6585ABE607AB7611")

    private static String END = "-----END ";
}

