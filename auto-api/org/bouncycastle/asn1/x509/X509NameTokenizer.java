package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class X509NameTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.324 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.324 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.324 -0400", hash_original_field = "E72814AAA963A3FA498930DCF0ED40FB", hash_generated_field = "9FFFB1A798BF85E8FA366500A206FB25")

    private char seperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.324 -0400", hash_original_field = "AD725DF80177605E6571F15CF0B24371", hash_generated_field = "22C3EB28ABC67744D189D37B59EAF1C4")

    private StringBuffer buf = new StringBuffer();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.324 -0400", hash_original_method = "E29DC46EF5738DAFDF44DDEEECCCD2C0", hash_generated_method = "530DAC4DCE86DDCE43D9C6AC5EDA6C09")
    public  X509NameTokenizer(
        String  oid) {
        this(oid, ',');
        addTaint(oid.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.327 -0400", hash_original_method = "6C4980154E892C5E33B9260977D1D61C", hash_generated_method = "4BEA75B12AAC351464B943202513991C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.327 -0400", hash_original_method = "A840AC1B987121BDC7999220A560F7B6", hash_generated_method = "EAC7FAA317948880C39B602F23D46BBB")
    public boolean hasMoreTokens() {
        boolean var7CD935BF8DE374BC92D8FD35111972EC_2046102294 = ((index != value.length()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535980851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_535980851;
        // ---------- Original Method ----------
        //return (index != value.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.328 -0400", hash_original_method = "609C206EB69C69406C6D19A5ED0989AC", hash_generated_method = "9D40779EE490D24B6434AD36A087E998")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_953193127 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_734554864 = null; //Variable for return #2
        {
            boolean varD1FB7B79F55DE8E4676B5276D1B14D19_795339400 = (index == value.length());
            {
                varB4EAC82CA7396A68D541C85D26508E83_953193127 = null;
            } //End block
        } //End collapsed parenthetic
        int end;
        end = index + 1;
        boolean quoted;
        quoted = false;
        boolean escaped;
        escaped = false;
        buf.setLength(0);
        {
            boolean var15C8D7A4D88CE8735C497FC63BBCD1F9_1111738598 = (end != value.length());
            {
                char c;
                c = value.charAt(end);
                {
                    {
                        quoted = !quoted;
                    } //End block
                    {
                        {
                            boolean var5E354E81BA73B0495049F0FBF6BAAB34_1265916797 = (c == '#' && buf.charAt(buf.length() - 1) == '=');
                            {
                                buf.append('\\');
                            } //End block
                            {
                                buf.append('\\');
                            } //End block
                        } //End collapsed parenthetic
                        buf.append(c);
                    } //End block
                    escaped = false;
                } //End block
                {
                    {
                        {
                            boolean var5E354E81BA73B0495049F0FBF6BAAB34_2008406134 = (c == '#' && buf.charAt(buf.length() - 1) == '=');
                            {
                                buf.append('\\');
                            } //End block
                            {
                                buf.append('\\');
                            } //End block
                        } //End collapsed parenthetic
                        buf.append(c);
                        escaped = false;
                    } //End block
                    {
                        escaped = true;
                    } //End block
                    {
                        buf.append(c);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        index = end;
        varB4EAC82CA7396A68D541C85D26508E83_734554864 = buf.toString().trim();
        String varA7E53CE21691AB073D9660D615818899_1938241817; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1938241817 = varB4EAC82CA7396A68D541C85D26508E83_953193127;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1938241817 = varB4EAC82CA7396A68D541C85D26508E83_734554864;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1938241817.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1938241817;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

