package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;






public class LazyDERSequence extends DERSequence {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.800 -0500", hash_original_field = "B26EA4441AC976CE9D513DB2C8639526", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.802 -0500", hash_original_field = "0C6908DECCD5C0E843E68916106EDAB3", hash_generated_field = "8C5EC66D29868A1962676316469FC881")

    private boolean parsed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.805 -0500", hash_original_field = "3CDB782D34B39BD3DEC7B984A1617411", hash_generated_field = "10F76FD865BC4D8F6F2C3440897633F6")

    private int size = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.807 -0500", hash_original_method = "774E91359D875B822740E8694BBD0378", hash_generated_method = "774E91359D875B822740E8694BBD0378")
    
LazyDERSequence(
        byte[] encoded)
        throws IOException
    {
        this.encoded = encoded;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.809 -0500", hash_original_method = "F52BE1D6A2A2A6E978CE6B87E0C287FA", hash_generated_method = "40D9EF4B9923E360248D16E33B473F99")
    
private void parse()
    {
        Enumeration en = new LazyDERConstructionEnumeration(encoded);

        while (en.hasMoreElements())
        {
            addObject((DEREncodable)en.nextElement());
        }

        parsed = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.812 -0500", hash_original_method = "D55432484A7204F62197A1C42F1222BB", hash_generated_method = "39520F3DDDFF756F1C82DD84BDFDC4DD")
    
public synchronized DEREncodable getObjectAt(int index)
    {
        if (!parsed)
        {
            parse();
        }

        return super.getObjectAt(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.814 -0500", hash_original_method = "939539D3FCA2F2720237F25863622D9D", hash_generated_method = "909529DF9335120697A38B4A4924A312")
    
public synchronized Enumeration getObjects()
    {
        if (parsed)
        {
            return super.getObjects();
        }

        return new LazyDERConstructionEnumeration(encoded);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.817 -0500", hash_original_method = "4DAF8F12C79E02A5B25C6CFF5DA9F3C5", hash_generated_method = "770D38303F11D14549F2025688656CBC")
    
public int size()
    {
        if (size < 0)
        {
            Enumeration en = new LazyDERConstructionEnumeration(encoded);

            size = 0;
            while (en.hasMoreElements())
            {
                en.nextElement();
                size++;
            }
        }

        return size;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.819 -0500", hash_original_method = "46D9E51ED6BB4A9637D586153D86E513", hash_generated_method = "46D9E51ED6BB4A9637D586153D86E513")
    
void encode(
        DEROutputStream out)
        throws IOException
    {
        out.writeEncoded(SEQUENCE | CONSTRUCTED, encoded);
    }

    
}

