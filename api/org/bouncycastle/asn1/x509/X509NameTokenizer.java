package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class X509NameTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.239 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.239 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.240 -0400", hash_original_field = "E72814AAA963A3FA498930DCF0ED40FB", hash_generated_field = "9FFFB1A798BF85E8FA366500A206FB25")

    private char seperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.240 -0400", hash_original_field = "AD725DF80177605E6571F15CF0B24371", hash_generated_field = "22C3EB28ABC67744D189D37B59EAF1C4")

    private StringBuffer buf = new StringBuffer();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.240 -0400", hash_original_method = "E29DC46EF5738DAFDF44DDEEECCCD2C0", hash_generated_method = "530DAC4DCE86DDCE43D9C6AC5EDA6C09")
    public  X509NameTokenizer(
        String  oid) {
        this(oid, ',');
        addTaint(oid.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.240 -0400", hash_original_method = "6C4980154E892C5E33B9260977D1D61C", hash_generated_method = "4BEA75B12AAC351464B943202513991C")
    public  X509NameTokenizer(
        String  oid,
        char    seperator) {
        this.value = oid;
        this.index = -1;
        this.seperator = seperator;
        // ---------- Original Method ----------
        //this.value = oid;
        //this.index = -1;
        //this.seperator = seperator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.241 -0400", hash_original_method = "A840AC1B987121BDC7999220A560F7B6", hash_generated_method = "4BAA38F6973688756A8503D5D5A59CCE")
    public boolean hasMoreTokens() {
        boolean var93EB2FC7E0BFEAF90EB3D9B6C402E119_1053125360 = ((index != value.length()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2018918478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2018918478;
        // ---------- Original Method ----------
        //return (index != value.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.242 -0400", hash_original_method = "609C206EB69C69406C6D19A5ED0989AC", hash_generated_method = "48FA9B79E393F03DABFCC30AAD1A259B")
    public String nextToken() {
        if(index == value.length())        
        {
String var540C13E9E156B687226421B24F2DF178_579310495 =             null;
            var540C13E9E156B687226421B24F2DF178_579310495.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_579310495;
        } //End block
        int end = index + 1;
        boolean quoted = false;
        boolean escaped = false;
        buf.setLength(0);
        while
(end != value.length())        
        {
            char c = value.charAt(end);
            if(c == '"')            
            {
                if(!escaped)                
                {
                    quoted = !quoted;
                } //End block
                else
                {
                    if(c == '#' && buf.charAt(buf.length() - 1) == '=')                    
                    {
                        buf.append('\\');
                    } //End block
                    else
                    if(c == '+' && seperator != '+')                    
                    {
                        buf.append('\\');
                    } //End block
                    buf.append(c);
                } //End block
                escaped = false;
            } //End block
            else
            {
                if(escaped || quoted)                
                {
                    if(c == '#' && buf.charAt(buf.length() - 1) == '=')                    
                    {
                        buf.append('\\');
                    } //End block
                    else
                    if(c == '+' && seperator != '+')                    
                    {
                        buf.append('\\');
                    } //End block
                    buf.append(c);
                    escaped = false;
                } //End block
                else
                if(c == '\\')                
                {
                    escaped = true;
                } //End block
                else
                if(c == seperator)                
                {
                    break;
                } //End block
                else
                {
                    buf.append(c);
                } //End block
            } //End block
            end++;
        } //End block
        index = end;
String varBDA64BFF30DEE049350358D65DFD8D33_987768555 =         buf.toString().trim();
        varBDA64BFF30DEE049350358D65DFD8D33_987768555.addTaint(taint);
        return varBDA64BFF30DEE049350358D65DFD8D33_987768555;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

