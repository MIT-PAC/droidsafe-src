package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.util.encoders.Base64;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PemReader extends BufferedReader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.412 -0400", hash_original_method = "422165DD33429D3A249B1D2E2C0897A9", hash_generated_method = "5592100559038DF99263536657464ADF")
    public  PemReader(Reader reader) {
        super(reader);
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.413 -0400", hash_original_method = "D58B040BED022541C97B3ACE6DF7F511", hash_generated_method = "36B5EA7D50633DC6EF4D2AAA22DF9F99")
    public PemObject readPemObject() throws IOException {
        String line = readLine();
        if(line != null && line.startsWith(BEGIN))        
        {
            line = line.substring(BEGIN.length());
            int index = line.indexOf('-');
            String type = line.substring(0, index);
            if(index > 0)            
            {
PemObject varF43941D02037384D10CA5FB8B762A045_1809261265 =                 loadObject(type);
                varF43941D02037384D10CA5FB8B762A045_1809261265.addTaint(taint);
                return varF43941D02037384D10CA5FB8B762A045_1809261265;
            } //End block
        } //End block
PemObject var540C13E9E156B687226421B24F2DF178_95504384 =         null;
        var540C13E9E156B687226421B24F2DF178_95504384.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_95504384;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.414 -0400", hash_original_method = "B4339AB43686CE97B8B754B51FC0C571", hash_generated_method = "3DCA2B19CA5D69CBD09E916C66812A08")
    private PemObject loadObject(String type) throws IOException {
        addTaint(type.getTaint());
        String line;
        String endMarker = END + type;
        StringBuffer buf = new StringBuffer();
        List headers = new ArrayList();
        while
((line = readLine()) != null)        
        {
            if(line.indexOf(":") >= 0)            
            {
                int index = line.indexOf(':');
                String hdr = line.substring(0, index);
                String value = line.substring(index + 1).trim();
                headers.add(new PemHeader(hdr, value));
                continue;
            } //End block
            if(line.indexOf(endMarker) != -1)            
            {
                break;
            } //End block
            buf.append(line.trim());
        } //End block
        if(line == null)        
        {
            IOException varE7B2AD8B7A180FB87C1B156A33C18DBA_1156992512 = new IOException(endMarker + " not found");
            varE7B2AD8B7A180FB87C1B156A33C18DBA_1156992512.addTaint(taint);
            throw varE7B2AD8B7A180FB87C1B156A33C18DBA_1156992512;
        } //End block
PemObject varE56C95CA57B81340ED810C6A8E7780EE_1123676611 =         new PemObject(type, headers, Base64.decode(buf.toString()));
        varE56C95CA57B81340ED810C6A8E7780EE_1123676611.addTaint(taint);
        return varE56C95CA57B81340ED810C6A8E7780EE_1123676611;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.414 -0400", hash_original_field = "20A8C2705F62633A6C198025CB3E9306", hash_generated_field = "3012F10FFC028E270306D326E4F2BB4D")

    private static final String BEGIN = "-----BEGIN ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.414 -0400", hash_original_field = "2E57F28A99A70BA82478B238D4989DCC", hash_generated_field = "33FE8EF509AB5350D82B1C830CA62BCF")

    private static final String END = "-----END ";
}

