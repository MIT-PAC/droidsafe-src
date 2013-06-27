package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import android.util.AttributeSet;
import com.android.internal.util.XmlUtils;

class XmlPullAttributes implements AttributeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.331 -0400", hash_original_field = "BADDC1E0767DE74C04327A058F5013C3", hash_generated_field = "7492C3C299D1412332C93303F683B706")

    XmlPullParser mParser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.344 -0400", hash_original_method = "46700DF76961858760F1F54A77DCF120", hash_generated_method = "9596B1361EACD78292EF670433107D82")
    public  XmlPullAttributes(XmlPullParser parser) {
        mParser = parser;
        // ---------- Original Method ----------
        //mParser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.344 -0400", hash_original_method = "AC633D604462F0666116EB932D89F378", hash_generated_method = "8F5C5ADCA35B4D75D4652694649F7837")
    public int getAttributeCount() {
        int varF72DC07A82EAB97ADB3C3B546A9DB653_1175114207 = (mParser.getAttributeCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647120195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647120195;
        // ---------- Original Method ----------
        //return mParser.getAttributeCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.345 -0400", hash_original_method = "BEE4E7A446CC9E8B5C15985188859485", hash_generated_method = "7E4A8C7F319C5C7E3804F84335871B4B")
    public String getAttributeName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1821029238 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1821029238 = mParser.getAttributeName(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1821029238.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1821029238;
        // ---------- Original Method ----------
        //return mParser.getAttributeName(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.346 -0400", hash_original_method = "A5436A02B7CB2BE76E834F087F6ECBA1", hash_generated_method = "99D51DA95FE6074C5D47C5612E4B2F33")
    public String getAttributeValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1841407611 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1841407611 = mParser.getAttributeValue(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1841407611.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1841407611;
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.346 -0400", hash_original_method = "0F6DE45848B198201E8558211308FA90", hash_generated_method = "848510A1D5053362267B20F4EBDDBD73")
    public String getAttributeValue(String namespace, String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1880355598 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1880355598 = mParser.getAttributeValue(namespace, name);
        addTaint(namespace.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1880355598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1880355598;
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(namespace, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.347 -0400", hash_original_method = "D18F44DE17503E98739B2795B002BD8F", hash_generated_method = "5006ED0A4EA86AC8E7A14FE5638002D9")
    public String getPositionDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_1765253853 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1765253853 = mParser.getPositionDescription();
        varB4EAC82CA7396A68D541C85D26508E83_1765253853.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1765253853;
        // ---------- Original Method ----------
        //return mParser.getPositionDescription();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.348 -0400", hash_original_method = "367A5DCA84F3DB949AE42F70B52DA04A", hash_generated_method = "FCEAA35374E6773B0408B31C8BDECAB7")
    public int getAttributeNameResource(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887971459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887971459;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.349 -0400", hash_original_method = "4E31AE9A9364AB1AB86A7E4A35CF8815", hash_generated_method = "04D564F3A20636D0B0DDEF22A11467B8")
    public int getAttributeListValue(String namespace, String attribute,
            String[] options, int defaultValue) {
        int var715EB671317F6D9184C790D39DEF00A8_1386845946 = (XmlUtils.convertValueToList(
            getAttributeValue(namespace, attribute), options, defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(options[0].getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164043824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164043824;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(namespace, attribute), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.349 -0400", hash_original_method = "CB59BE8B074EA88200C6D038DF92BCD2", hash_generated_method = "E13C73362EFC5A5DE4C297555FC7D6F1")
    public boolean getAttributeBooleanValue(String namespace, String attribute,
            boolean defaultValue) {
        boolean var250FF62F8D3921AC8272255A24D76A37_114125195 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732931447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732931447;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.363 -0400", hash_original_method = "B72C52627D560B7B2B8F954C65A581EF", hash_generated_method = "D98DEB991F17ED9CFE1C2FE29B1F2D34")
    public int getAttributeResourceValue(String namespace, String attribute,
            int defaultValue) {
        int varA9705B02A7D9315B6178C1600A3F7939_1802006839 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_891372009 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_891372009;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.368 -0400", hash_original_method = "449DD6F89BAD60DF7A85871E701FCB24", hash_generated_method = "3A0FB2527EA4804AED087098761C4DC3")
    public int getAttributeIntValue(String namespace, String attribute,
            int defaultValue) {
        int varA9705B02A7D9315B6178C1600A3F7939_2140257243 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8120740 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8120740;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.369 -0400", hash_original_method = "6A2C36F5482C4EBD163273692E451C50", hash_generated_method = "A16819E8D9BFCCB23FB3CF58EC51844D")
    public int getAttributeUnsignedIntValue(String namespace, String attribute,
            int defaultValue) {
        int varCE3F9DBD69572A69DFC24BFED7017E04_1991752665 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837609000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837609000;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.369 -0400", hash_original_method = "D502685784CC790809C97ABBA05A2BE9", hash_generated_method = "2471CC68B04BB69ADA88281F1C79516D")
    public float getAttributeFloatValue(String namespace, String attribute,
            float defaultValue) {
        String s;
        s = getAttributeValue(namespace, attribute);
        {
            float var502301E3A4629072E930D323C47A3F08_1355833358 = (Float.parseFloat(s));
        } //End block
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1151990311 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1151990311;
        // ---------- Original Method ----------
        //String s = getAttributeValue(namespace, attribute);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.369 -0400", hash_original_method = "4662E8BE42C313C76CDB4789305F27BC", hash_generated_method = "C4DE8692FE942B2CBAC86E3E107B9C17")
    public int getAttributeListValue(int index,
            String[] options, int defaultValue) {
        int var4EC91EC07CA7157BDAA3C419E7A846E6_1801711951 = (XmlUtils.convertValueToList(
            getAttributeValue(index), options, defaultValue));
        addTaint(index);
        addTaint(options[0].getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911720757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1911720757;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(index), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.370 -0400", hash_original_method = "5307D0D140F223DF06C748E39BFCF6F9", hash_generated_method = "A71BAA0D926F0245AB0623C3ED246A32")
    public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
        boolean varD49E277DCF89E54EAC6AD0F7A669FCE1_1076567058 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891108613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_891108613;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.370 -0400", hash_original_method = "13E9FD87B957377B70C3AD0477E922F3", hash_generated_method = "408606EABF164784A2EBA0F17F3469F7")
    public int getAttributeResourceValue(int index, int defaultValue) {
        int var9E5E2AF0AB6AB748E42DE75C1B4E07BB_783394305 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478352239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478352239;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.378 -0400", hash_original_method = "139FB7EC46A06573986F935A6AB04CC8", hash_generated_method = "1B3B459A40EED364A2F7BA6B01AD7C46")
    public int getAttributeIntValue(int index, int defaultValue) {
        int var9E5E2AF0AB6AB748E42DE75C1B4E07BB_875900600 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558639161 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558639161;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.383 -0400", hash_original_method = "078871C14853487C7F2D178FA05191E4", hash_generated_method = "E13C8A8B3A6B36C93208711F21286A39")
    public int getAttributeUnsignedIntValue(int index, int defaultValue) {
        int varBDA2420184B64FE38B062CC9A682A5E7_1009633476 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_85800693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_85800693;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.383 -0400", hash_original_method = "565BFCAA0E42C39EE8ABF3F09F50B574", hash_generated_method = "8137CD338F9F38210445BE642D4BEBB6")
    public float getAttributeFloatValue(int index, float defaultValue) {
        String s;
        s = getAttributeValue(index);
        {
            float var502301E3A4629072E930D323C47A3F08_1957966574 = (Float.parseFloat(s));
        } //End block
        addTaint(index);
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_674620940 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_674620940;
        // ---------- Original Method ----------
        //String s = getAttributeValue(index);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.384 -0400", hash_original_method = "30F655EDD1D9E306F8BD8B4F098F75CB", hash_generated_method = "4188E6807AFC576727CFE24407C82E8E")
    public String getIdAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_106955232 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_106955232 = getAttributeValue(null, "id");
        varB4EAC82CA7396A68D541C85D26508E83_106955232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_106955232;
        // ---------- Original Method ----------
        //return getAttributeValue(null, "id");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.413 -0400", hash_original_method = "07D690E8F20AB7BFDE3AB681FB8BA29B", hash_generated_method = "B3DC2D094B0BE369E4148EEE4BA2D32C")
    public String getClassAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_2069541298 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2069541298 = getAttributeValue(null, "class");
        varB4EAC82CA7396A68D541C85D26508E83_2069541298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2069541298;
        // ---------- Original Method ----------
        //return getAttributeValue(null, "class");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.416 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "7C0472B8AC7043C9F06EEFA0EBFDE974")
    public int getIdAttributeResourceValue(int defaultValue) {
        int var834619C47448B8325060A7C2F54A8B64_280922864 = (getAttributeResourceValue(null, "id", defaultValue));
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485165692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485165692;
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "id", defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.417 -0400", hash_original_method = "47F1D8ADCD04851946BC9C0B882261EE", hash_generated_method = "AA92036CF7EF7CEB0F7CA2A7CCD68808")
    public int getStyleAttribute() {
        int var78D595595E9DBE14DC15098C8C968D18_1433113442 = (getAttributeResourceValue(null, "style", 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_568439100 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_568439100;
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "style", 0);
    }

    
}

