package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Enumeration;

public class LazyDERSequence extends DERSequence {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.348 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.348 -0400", hash_original_field = "0E27CA10ED218E22AD1B0B35F24A7764", hash_generated_field = "8C5EC66D29868A1962676316469FC881")

    private boolean parsed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.348 -0400", hash_original_field = "304D03889695AEE9913D341019E1E376", hash_generated_field = "10F76FD865BC4D8F6F2C3440897633F6")

    private int size = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.360 -0400", hash_original_method = "774E91359D875B822740E8694BBD0378", hash_generated_method = "F13296280E5E5D813549095EB53048EE")
      LazyDERSequence(
        byte[] encoded) throws IOException {
        this.encoded = encoded;
        // ---------- Original Method ----------
        //this.encoded = encoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.360 -0400", hash_original_method = "F52BE1D6A2A2A6E978CE6B87E0C287FA", hash_generated_method = "CF05B932A7BA2E94BA76B7AC22A0FDE7")
    private void parse() {
        Enumeration en;
        en = new LazyDERConstructionEnumeration(encoded);
        {
            boolean varB188EF125CE599069C2B3F78653D629C_1114098708 = (en.hasMoreElements());
            {
                addObject((DEREncodable)en.nextElement());
            } //End block
        } //End collapsed parenthetic
        parsed = true;
        // ---------- Original Method ----------
        //Enumeration en = new LazyDERConstructionEnumeration(encoded);
        //while (en.hasMoreElements())
        //{
            //addObject((DEREncodable)en.nextElement());
        //}
        //parsed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.361 -0400", hash_original_method = "D55432484A7204F62197A1C42F1222BB", hash_generated_method = "A3761DCA071B2DE848F3CB97414971C0")
    public synchronized DEREncodable getObjectAt(int index) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_995940277 = null; //Variable for return #1
        {
            parse();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_995940277 = super.getObjectAt(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_995940277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_995940277;
        // ---------- Original Method ----------
        //if (!parsed)
        //{
            //parse();
        //}
        //return super.getObjectAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.361 -0400", hash_original_method = "939539D3FCA2F2720237F25863622D9D", hash_generated_method = "714BE69396F17F1C50769A6A7ED0B8E4")
    public synchronized Enumeration getObjects() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_128683322 = null; //Variable for return #1
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1974560635 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_128683322 = super.getObjects();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1974560635 = new LazyDERConstructionEnumeration(encoded);
        Enumeration varA7E53CE21691AB073D9660D615818899_1737532771; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1737532771 = varB4EAC82CA7396A68D541C85D26508E83_128683322;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1737532771 = varB4EAC82CA7396A68D541C85D26508E83_1974560635;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1737532771.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1737532771;
        // ---------- Original Method ----------
        //if (parsed)
        //{
            //return super.getObjects();
        //}
        //return new LazyDERConstructionEnumeration(encoded);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.362 -0400", hash_original_method = "4DAF8F12C79E02A5B25C6CFF5DA9F3C5", hash_generated_method = "5A290CBD068467A003E02F12764EDEE1")
    public int size() {
        {
            Enumeration en;
            en = new LazyDERConstructionEnumeration(encoded);
            size = 0;
            {
                boolean var3500FA4D58FB8FB3E63D650C6AAEA7F5_696688509 = (en.hasMoreElements());
                {
                    en.nextElement();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650667236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650667236;
        // ---------- Original Method ----------
        //if (size < 0)
        //{
            //Enumeration en = new LazyDERConstructionEnumeration(encoded);
            //size = 0;
            //while (en.hasMoreElements())
            //{
                //en.nextElement();
                //size++;
            //}
        //}
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.362 -0400", hash_original_method = "46D9E51ED6BB4A9637D586153D86E513", hash_generated_method = "C2129C70203253B927C3BD855D6170C5")
     void encode(
        DEROutputStream out) throws IOException {
        out.writeEncoded(SEQUENCE | CONSTRUCTED, encoded);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(SEQUENCE | CONSTRUCTED, encoded);
    }

    
}

