package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class AcceptLanguageList extends SIPHeaderList<AcceptLanguage> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.343 -0400", hash_original_method = "240BB3B9B24C078BD16B4E527289E882", hash_generated_method = "11DB9C05848E7350775B5746176F17CF")
    public  AcceptLanguageList() {
        super(AcceptLanguage.class, AcceptLanguageHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.345 -0400", hash_original_method = "D59E3796661CC485086FCE096143E912", hash_generated_method = "2B1EB8D528D81F95DA56889FF771FBA4")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_831683485 = null; //Variable for return #1
        AcceptLanguageList retval;
        retval = new AcceptLanguageList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_831683485 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_831683485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_831683485;
        // ---------- Original Method ----------
        //AcceptLanguageList retval = new AcceptLanguageList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.345 -0400", hash_original_method = "4EAA649C6A43B8603903A57164247286", hash_generated_method = "9517A0187805A6FB5AE873FB0762116C")
    public AcceptLanguage getFirst() {
        AcceptLanguage varB4EAC82CA7396A68D541C85D26508E83_437660702 = null; //Variable for return #1
        AcceptLanguage varB4EAC82CA7396A68D541C85D26508E83_2146668369 = null; //Variable for return #2
        AcceptLanguage retval;
        retval = (AcceptLanguage) super.getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_437660702 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2146668369 = new AcceptLanguage();
        AcceptLanguage varA7E53CE21691AB073D9660D615818899_199314334; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_199314334 = varB4EAC82CA7396A68D541C85D26508E83_437660702;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_199314334 = varB4EAC82CA7396A68D541C85D26508E83_2146668369;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_199314334.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_199314334;
        // ---------- Original Method ----------
        //AcceptLanguage retval = (AcceptLanguage) super.getFirst();
        //if (retval != null)
            //return retval;
        //else
            //return new AcceptLanguage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.352 -0400", hash_original_method = "D3074C13DEFE0D00E21551F82106E50D", hash_generated_method = "3ADDE5718696AA18FC5D6D3E14D5B65B")
    public AcceptLanguage getLast() {
        AcceptLanguage varB4EAC82CA7396A68D541C85D26508E83_1769167005 = null; //Variable for return #1
        AcceptLanguage varB4EAC82CA7396A68D541C85D26508E83_947679227 = null; //Variable for return #2
        AcceptLanguage retval;
        retval = (AcceptLanguage) super.getLast();
        varB4EAC82CA7396A68D541C85D26508E83_1769167005 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_947679227 = new AcceptLanguage();
        AcceptLanguage varA7E53CE21691AB073D9660D615818899_702096548; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_702096548 = varB4EAC82CA7396A68D541C85D26508E83_1769167005;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_702096548 = varB4EAC82CA7396A68D541C85D26508E83_947679227;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_702096548.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_702096548;
        // ---------- Original Method ----------
        //AcceptLanguage retval = (AcceptLanguage) super.getLast();
        //if (retval != null)
            //return retval;
        //else
            //return new AcceptLanguage();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.353 -0400", hash_original_field = "2DC0C9505B6601CC65D202A5B3F50DF0", hash_generated_field = "C8EDE36FBAAD8D6C44E86C30CD45EE55")

    private static long serialVersionUID = -3289606805203488840L;
}

