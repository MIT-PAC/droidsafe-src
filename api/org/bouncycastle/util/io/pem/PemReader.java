package org.bouncycastle.util.io.pem;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.util.encoders.Base64;

public class PemReader extends BufferedReader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.625 -0400", hash_original_method = "422165DD33429D3A249B1D2E2C0897A9", hash_generated_method = "5592100559038DF99263536657464ADF")
    public  PemReader(Reader reader) {
        super(reader);
        addTaint(reader.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.626 -0400", hash_original_method = "D58B040BED022541C97B3ACE6DF7F511", hash_generated_method = "2F398D3571699455D9CF3514E7CC4211")
    public PemObject readPemObject() throws IOException {
        String line = readLine();
    if(line != null && line.startsWith(BEGIN))        
        {
            line = line.substring(BEGIN.length());
            int index = line.indexOf('-');
            String type = line.substring(0, index);
    if(index > 0)            
            {
PemObject varF43941D02037384D10CA5FB8B762A045_1774711427 =                 loadObject(type);
                varF43941D02037384D10CA5FB8B762A045_1774711427.addTaint(taint);
                return varF43941D02037384D10CA5FB8B762A045_1774711427;
            } 
        } 
PemObject var540C13E9E156B687226421B24F2DF178_706426976 =         null;
        var540C13E9E156B687226421B24F2DF178_706426976.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_706426976;
        
        
        
        
            
            
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.626 -0400", hash_original_method = "B4339AB43686CE97B8B754B51FC0C571", hash_generated_method = "EAC0E78CDA4847D4518D539417123D3A")
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
            } 
    if(line.indexOf(endMarker) != -1)            
            {
                break;
            } 
            buf.append(line.trim());
        } 
    if(line == null)        
        {
            IOException varE7B2AD8B7A180FB87C1B156A33C18DBA_2143644794 = new IOException(endMarker + " not found");
            varE7B2AD8B7A180FB87C1B156A33C18DBA_2143644794.addTaint(taint);
            throw varE7B2AD8B7A180FB87C1B156A33C18DBA_2143644794;
        } 
PemObject varE56C95CA57B81340ED810C6A8E7780EE_1882760675 =         new PemObject(type, headers, Base64.decode(buf.toString()));
        varE56C95CA57B81340ED810C6A8E7780EE_1882760675.addTaint(taint);
        return varE56C95CA57B81340ED810C6A8E7780EE_1882760675;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.627 -0400", hash_original_field = "20A8C2705F62633A6C198025CB3E9306", hash_generated_field = "3012F10FFC028E270306D326E4F2BB4D")

    private static final String BEGIN = "-----BEGIN ";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.627 -0400", hash_original_field = "2E57F28A99A70BA82478B238D4989DCC", hash_generated_field = "33FE8EF509AB5350D82B1C830CA62BCF")

    private static final String END = "-----END ";
}

