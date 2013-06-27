package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Arrays;

public final class PhoneNumberMatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.550 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

    private int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.550 -0400", hash_original_field = "86C8EF5116F9F2D53104EB36EE5FEBD4", hash_generated_field = "6456B20A1E1CCB2639ECC7BC4AF85249")

    private String rawString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.550 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "DFCB3B49B2D60B2C16CC443A648E9AFE")

    private PhoneNumber number;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.551 -0400", hash_original_method = "24CA5CFFCC859FAC59BD892D4A4B2393", hash_generated_method = "90E4FAF9A569BB9DBF263DA575D17BAC")
      PhoneNumberMatch(int start, String rawString, PhoneNumber number) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Start index must be >= 0.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.start = start;
        this.rawString = rawString;
        this.number = number;
        // ---------- Original Method ----------
        //if (start < 0) {
      //throw new IllegalArgumentException("Start index must be >= 0.");
    //}
        //if (rawString == null || number == null) {
      //throw new NullPointerException();
    //}
        //this.start = start;
        //this.rawString = rawString;
        //this.number = number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.551 -0400", hash_original_method = "3AF6887A924E6E03501A94FECACFA30D", hash_generated_method = "CA969B215E8119036B846A01779A610F")
    public PhoneNumber number() {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1048028989 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1048028989 = number;
        varB4EAC82CA7396A68D541C85D26508E83_1048028989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1048028989;
        // ---------- Original Method ----------
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.552 -0400", hash_original_method = "5948F380AB147474B7B360324D01D8A7", hash_generated_method = "5511BDCC38776B7C47DAD166F03B1805")
    public int start() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318861480 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318861480;
        // ---------- Original Method ----------
        //return start;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.565 -0400", hash_original_method = "7D10A3C1D28519413DA457C01967C482", hash_generated_method = "5508D606EC5444C5FEC3634D554A41E8")
    public int end() {
        int varB24BA409889D2DF54BA645250444F1AF_1193879103 = (start + rawString.length());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125432024 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125432024;
        // ---------- Original Method ----------
        //return start + rawString.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.566 -0400", hash_original_method = "9FB54278FE2075E29BA0E55156E431DE", hash_generated_method = "C963E9B36ADE75518E57928B62DD8E08")
    public String rawString() {
        String varB4EAC82CA7396A68D541C85D26508E83_29507923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_29507923 = rawString;
        varB4EAC82CA7396A68D541C85D26508E83_29507923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_29507923;
        // ---------- Original Method ----------
        //return rawString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.566 -0400", hash_original_method = "13786FFFFB16751EA6F3DAD6D70C98CC", hash_generated_method = "0D8C07C487CD9CB8D596065A0398042E")
    @Override
    public int hashCode() {
        int var68DAC3103D3FDE3551F375601B10A6D7_1055936062 = (Arrays.hashCode(new Object[]{start, rawString, number}));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784899234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784899234;
        // ---------- Original Method ----------
        //return Arrays.hashCode(new Object[]{start, rawString, number});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.575 -0400", hash_original_method = "38076D29780FBE1507C47919C30AB86E", hash_generated_method = "018A13D256483CB9BB11A0A3DC8DC90F")
    @Override
    public boolean equals(Object obj) {
        PhoneNumberMatch other;
        other = (PhoneNumberMatch) obj;
        boolean var543198B8CD21F9CD3A16350E5A2DC427_729777438 = (rawString.equals(other.rawString) && (start == other.start) &&
        number.equals(other.number));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406974565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406974565;
        // ---------- Original Method ----------
        //if (this == obj) {
      //return true;
    //}
        //if (!(obj instanceof PhoneNumberMatch)) {
      //return false;
    //}
        //PhoneNumberMatch other = (PhoneNumberMatch) obj;
        //return rawString.equals(other.rawString) && (start == other.start) &&
        //number.equals(other.number);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.576 -0400", hash_original_method = "9E681ADFB274F0FD80239D8E6C0D9096", hash_generated_method = "43805B100EB642BB262E00DBB2A6DA6E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1419073321 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1419073321 = "PhoneNumberMatch [" + start() + "," + end() + ") " + rawString;
        varB4EAC82CA7396A68D541C85D26508E83_1419073321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1419073321;
        // ---------- Original Method ----------
        //return "PhoneNumberMatch [" + start() + "," + end() + ") " + rawString;
    }

    
}

