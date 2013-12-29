package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.util.encoders.Base64;






public class PemReader extends BufferedReader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.268 -0500", hash_original_field = "4B5018B208B1D25A1E57B78BC5773F2B", hash_generated_field = "3012F10FFC028E270306D326E4F2BB4D")

    private static final String BEGIN = "-----BEGIN ";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.268 -0500", hash_original_field = "ACDD7DF7CEFFE10381CC73399C5D5A81", hash_generated_field = "33FE8EF509AB5350D82B1C830CA62BCF")

    private static final String END = "-----END ";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.269 -0500", hash_original_method = "422165DD33429D3A249B1D2E2C0897A9", hash_generated_method = "81E0698B66208C250B9CA5E2B4379DC6")
    public PemReader(Reader reader)
    {
        super(reader);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.271 -0500", hash_original_method = "D58B040BED022541C97B3ACE6DF7F511", hash_generated_method = "FA1ABE982A9EABFA55820C8F3A5FFF3C")
    public PemObject readPemObject()
        throws IOException
    {
        String line = readLine();

        if (line != null && line.startsWith(BEGIN))
        {
            line = line.substring(BEGIN.length());
            int index = line.indexOf('-');
            String type = line.substring(0, index);

            if (index > 0)
            {
                return loadObject(type);
            }
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.272 -0500", hash_original_method = "B4339AB43686CE97B8B754B51FC0C571", hash_generated_method = "8801FBEA7E395329E4F4FB9F2332D887")
    private PemObject loadObject(String type)
        throws IOException
    {
        String          line;
        String          endMarker = END + type;
        StringBuffer    buf = new StringBuffer();
        List            headers = new ArrayList();

        while ((line = readLine()) != null)
        {
            if (line.indexOf(":") >= 0)
            {
                int index = line.indexOf(':');
                String hdr = line.substring(0, index);
                String value = line.substring(index + 1).trim();

                headers.add(new PemHeader(hdr, value));

                continue;
            }

            if (line.indexOf(endMarker) != -1)
            {
                break;
            }
            
            buf.append(line.trim());
        }

        if (line == null)
        {
            throw new IOException(endMarker + " not found");
        }

        return new PemObject(type, headers, Base64.decode(buf.toString()));
    }
}

