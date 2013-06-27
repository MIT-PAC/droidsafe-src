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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.031 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

    private int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.031 -0400", hash_original_field = "86C8EF5116F9F2D53104EB36EE5FEBD4", hash_generated_field = "6456B20A1E1CCB2639ECC7BC4AF85249")

    private String rawString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.031 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "DFCB3B49B2D60B2C16CC443A648E9AFE")

    private PhoneNumber number;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.032 -0400", hash_original_method = "24CA5CFFCC859FAC59BD892D4A4B2393", hash_generated_method = "90E4FAF9A569BB9DBF263DA575D17BAC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.037 -0400", hash_original_method = "3AF6887A924E6E03501A94FECACFA30D", hash_generated_method = "22EFDB0CA8A32B02B542AD831187FF78")
    public PhoneNumber number() {
        PhoneNumber varB4EAC82CA7396A68D541C85D26508E83_1005090721 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1005090721 = number;
        varB4EAC82CA7396A68D541C85D26508E83_1005090721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1005090721;
        // ---------- Original Method ----------
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.037 -0400", hash_original_method = "5948F380AB147474B7B360324D01D8A7", hash_generated_method = "ACBC26FAD2923DA73EB35EDD58E1D864")
    public int start() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245853934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245853934;
        // ---------- Original Method ----------
        //return start;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.038 -0400", hash_original_method = "7D10A3C1D28519413DA457C01967C482", hash_generated_method = "13329DD55EDF9B6B07E2EBFB9E38FBD2")
    public int end() {
        int varB24BA409889D2DF54BA645250444F1AF_161680215 = (start + rawString.length());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105634340 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105634340;
        // ---------- Original Method ----------
        //return start + rawString.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.038 -0400", hash_original_method = "9FB54278FE2075E29BA0E55156E431DE", hash_generated_method = "54BE35AF6CE7F690E659D8E2639DCAD3")
    public String rawString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1678257120 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1678257120 = rawString;
        varB4EAC82CA7396A68D541C85D26508E83_1678257120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678257120;
        // ---------- Original Method ----------
        //return rawString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.045 -0400", hash_original_method = "13786FFFFB16751EA6F3DAD6D70C98CC", hash_generated_method = "EA29B137DF5453293EEC16C40C3210B6")
    @Override
    public int hashCode() {
        int var68DAC3103D3FDE3551F375601B10A6D7_1703201909 = (Arrays.hashCode(new Object[]{start, rawString, number}));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425298255 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425298255;
        // ---------- Original Method ----------
        //return Arrays.hashCode(new Object[]{start, rawString, number});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.046 -0400", hash_original_method = "38076D29780FBE1507C47919C30AB86E", hash_generated_method = "67EBDD0523DAEB251105477651C92508")
    @Override
    public boolean equals(Object obj) {
        PhoneNumberMatch other;
        other = (PhoneNumberMatch) obj;
        boolean var543198B8CD21F9CD3A16350E5A2DC427_1955770887 = (rawString.equals(other.rawString) && (start == other.start) &&
        number.equals(other.number));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265929790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_265929790;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:12.047 -0400", hash_original_method = "9E681ADFB274F0FD80239D8E6C0D9096", hash_generated_method = "FAFCAFACC11A8AB93382DE9BA4509922")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_388701388 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_388701388 = "PhoneNumberMatch [" + start() + "," + end() + ") " + rawString;
        varB4EAC82CA7396A68D541C85D26508E83_388701388.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_388701388;
        // ---------- Original Method ----------
        //return "PhoneNumberMatch [" + start() + "," + end() + ") " + rawString;
    }

    
}

