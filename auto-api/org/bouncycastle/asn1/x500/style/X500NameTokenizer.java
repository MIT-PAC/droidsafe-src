package org.bouncycastle.asn1.x500.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class X500NameTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.746 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.747 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.747 -0400", hash_original_field = "E72814AAA963A3FA498930DCF0ED40FB", hash_generated_field = "9FFFB1A798BF85E8FA366500A206FB25")

    private char seperator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.747 -0400", hash_original_field = "AD725DF80177605E6571F15CF0B24371", hash_generated_field = "22C3EB28ABC67744D189D37B59EAF1C4")

    private StringBuffer buf = new StringBuffer();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.747 -0400", hash_original_method = "87C1EB4E958A465E857DAC381279FD5A", hash_generated_method = "DB78172E5A3B32C6719388F835122C90")
    public  X500NameTokenizer(
        String  oid) {
        this(oid, ',');
        addTaint(oid.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.747 -0400", hash_original_method = "C3EF91B48B2B40246915FB55098DB430", hash_generated_method = "2A83476EC8A14F59F934BAABCF82CC73")
    public  X500NameTokenizer(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.748 -0400", hash_original_method = "A840AC1B987121BDC7999220A560F7B6", hash_generated_method = "87B76BA9583E057F36AFBA393CA90BF7")
    public boolean hasMoreTokens() {
        boolean var7CD935BF8DE374BC92D8FD35111972EC_340896063 = ((index != value.length()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708428380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708428380;
        // ---------- Original Method ----------
        //return (index != value.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.753 -0400", hash_original_method = "A2F2FA85B4C6A562CE43722C053D9F00", hash_generated_method = "91B13BD9FFE3724850E0809D254F570C")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_1258376770 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_477101392 = null; //Variable for return #2
        {
            boolean varD1FB7B79F55DE8E4676B5276D1B14D19_154584582 = (index == value.length());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1258376770 = null;
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
            boolean var15C8D7A4D88CE8735C497FC63BBCD1F9_2062120506 = (end != value.length());
            {
                char c;
                c = value.charAt(end);
                {
                    {
                        quoted = !quoted;
                    } //End block
                    {
                        buf.append(c);
                    } //End block
                    escaped = false;
                } //End block
                {
                    {
                        {
                            boolean var5E354E81BA73B0495049F0FBF6BAAB34_1364710521 = (c == '#' && buf.charAt(buf.length() - 1) == '=');
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
        varB4EAC82CA7396A68D541C85D26508E83_477101392 = buf.toString().trim();
        String varA7E53CE21691AB073D9660D615818899_1569407044; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1569407044 = varB4EAC82CA7396A68D541C85D26508E83_1258376770;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1569407044 = varB4EAC82CA7396A68D541C85D26508E83_477101392;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1569407044.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1569407044;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

