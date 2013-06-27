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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.622 -0400", hash_original_field = "BADDC1E0767DE74C04327A058F5013C3", hash_generated_field = "7492C3C299D1412332C93303F683B706")

    XmlPullParser mParser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.633 -0400", hash_original_method = "46700DF76961858760F1F54A77DCF120", hash_generated_method = "9596B1361EACD78292EF670433107D82")
    public  XmlPullAttributes(XmlPullParser parser) {
        mParser = parser;
        // ---------- Original Method ----------
        //mParser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.633 -0400", hash_original_method = "AC633D604462F0666116EB932D89F378", hash_generated_method = "4525F2A8E7F70BDF1A43B9430A3FCEA1")
    public int getAttributeCount() {
        int varF72DC07A82EAB97ADB3C3B546A9DB653_230528541 = (mParser.getAttributeCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424777436 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424777436;
        // ---------- Original Method ----------
        //return mParser.getAttributeCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.634 -0400", hash_original_method = "BEE4E7A446CC9E8B5C15985188859485", hash_generated_method = "CAED8665AC7058787B7B70F7D2959365")
    public String getAttributeName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1626653318 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1626653318 = mParser.getAttributeName(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1626653318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1626653318;
        // ---------- Original Method ----------
        //return mParser.getAttributeName(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.637 -0400", hash_original_method = "A5436A02B7CB2BE76E834F087F6ECBA1", hash_generated_method = "39EF78CF277A73E3F0CF8ED9FD75AB7D")
    public String getAttributeValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1656446592 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1656446592 = mParser.getAttributeValue(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1656446592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1656446592;
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.638 -0400", hash_original_method = "0F6DE45848B198201E8558211308FA90", hash_generated_method = "A6FF6F940528661E09905758CAC27196")
    public String getAttributeValue(String namespace, String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1160382402 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1160382402 = mParser.getAttributeValue(namespace, name);
        addTaint(namespace.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1160382402.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1160382402;
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(namespace, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.639 -0400", hash_original_method = "D18F44DE17503E98739B2795B002BD8F", hash_generated_method = "7479E51DBF095CA919010432E5826247")
    public String getPositionDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_948072019 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_948072019 = mParser.getPositionDescription();
        varB4EAC82CA7396A68D541C85D26508E83_948072019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_948072019;
        // ---------- Original Method ----------
        //return mParser.getPositionDescription();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.639 -0400", hash_original_method = "367A5DCA84F3DB949AE42F70B52DA04A", hash_generated_method = "E59F51B4F08B4AB822BBFB945F9AA74B")
    public int getAttributeNameResource(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375088094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375088094;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.639 -0400", hash_original_method = "4E31AE9A9364AB1AB86A7E4A35CF8815", hash_generated_method = "CABACE4E694484EC9140ECA8CD2D823F")
    public int getAttributeListValue(String namespace, String attribute,
            String[] options, int defaultValue) {
        int var715EB671317F6D9184C790D39DEF00A8_2005053594 = (XmlUtils.convertValueToList(
            getAttributeValue(namespace, attribute), options, defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(options[0].getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757730535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757730535;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(namespace, attribute), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.640 -0400", hash_original_method = "CB59BE8B074EA88200C6D038DF92BCD2", hash_generated_method = "DEEB28492B355987DCDC6DBF96D97942")
    public boolean getAttributeBooleanValue(String namespace, String attribute,
            boolean defaultValue) {
        boolean var250FF62F8D3921AC8272255A24D76A37_65802014 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383045547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_383045547;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.641 -0400", hash_original_method = "B72C52627D560B7B2B8F954C65A581EF", hash_generated_method = "B846F2764959B998AF5DDA40D009F8E4")
    public int getAttributeResourceValue(String namespace, String attribute,
            int defaultValue) {
        int varA9705B02A7D9315B6178C1600A3F7939_246449143 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622612844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622612844;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.641 -0400", hash_original_method = "449DD6F89BAD60DF7A85871E701FCB24", hash_generated_method = "6A5968DF4F9641A7BD1D80D807B96BDE")
    public int getAttributeIntValue(String namespace, String attribute,
            int defaultValue) {
        int varA9705B02A7D9315B6178C1600A3F7939_1285005075 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788683627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788683627;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.641 -0400", hash_original_method = "6A2C36F5482C4EBD163273692E451C50", hash_generated_method = "AC8855B1A0E9E1570383FFFB7DB6B85A")
    public int getAttributeUnsignedIntValue(String namespace, String attribute,
            int defaultValue) {
        int varCE3F9DBD69572A69DFC24BFED7017E04_2080729385 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309865092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309865092;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.642 -0400", hash_original_method = "D502685784CC790809C97ABBA05A2BE9", hash_generated_method = "41D541C1B1ABADC1BAC6BBE4D4CEE32B")
    public float getAttributeFloatValue(String namespace, String attribute,
            float defaultValue) {
        String s;
        s = getAttributeValue(namespace, attribute);
        {
            float var502301E3A4629072E930D323C47A3F08_483608316 = (Float.parseFloat(s));
        } //End block
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1274207744 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1274207744;
        // ---------- Original Method ----------
        //String s = getAttributeValue(namespace, attribute);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.642 -0400", hash_original_method = "4662E8BE42C313C76CDB4789305F27BC", hash_generated_method = "88CAB1FD1D6A07D0F74B6931CE795096")
    public int getAttributeListValue(int index,
            String[] options, int defaultValue) {
        int var4EC91EC07CA7157BDAA3C419E7A846E6_904807065 = (XmlUtils.convertValueToList(
            getAttributeValue(index), options, defaultValue));
        addTaint(index);
        addTaint(options[0].getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257896433 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257896433;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(index), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.650 -0400", hash_original_method = "5307D0D140F223DF06C748E39BFCF6F9", hash_generated_method = "464FD455C443C324CC4391D1997C89AC")
    public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
        boolean varD49E277DCF89E54EAC6AD0F7A669FCE1_516824015 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_606740504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_606740504;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.651 -0400", hash_original_method = "13E9FD87B957377B70C3AD0477E922F3", hash_generated_method = "337EDC274FBB4A6C7BFA758913A2C0C9")
    public int getAttributeResourceValue(int index, int defaultValue) {
        int var9E5E2AF0AB6AB748E42DE75C1B4E07BB_1885441740 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494447934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494447934;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.652 -0400", hash_original_method = "139FB7EC46A06573986F935A6AB04CC8", hash_generated_method = "ACF7DAAC28E540BBD27CD6E8DF257491")
    public int getAttributeIntValue(int index, int defaultValue) {
        int var9E5E2AF0AB6AB748E42DE75C1B4E07BB_1105275192 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176589118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176589118;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.652 -0400", hash_original_method = "078871C14853487C7F2D178FA05191E4", hash_generated_method = "DC8D6E2530246ADBAD09577C1044244C")
    public int getAttributeUnsignedIntValue(int index, int defaultValue) {
        int varBDA2420184B64FE38B062CC9A682A5E7_555213807 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090726769 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090726769;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.653 -0400", hash_original_method = "565BFCAA0E42C39EE8ABF3F09F50B574", hash_generated_method = "7705F792569DF18BAE73FE70363FEABB")
    public float getAttributeFloatValue(int index, float defaultValue) {
        String s;
        s = getAttributeValue(index);
        {
            float var502301E3A4629072E930D323C47A3F08_289714155 = (Float.parseFloat(s));
        } //End block
        addTaint(index);
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1393806576 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1393806576;
        // ---------- Original Method ----------
        //String s = getAttributeValue(index);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.670 -0400", hash_original_method = "30F655EDD1D9E306F8BD8B4F098F75CB", hash_generated_method = "27E90FA561E924388E5B0D09CC2539B8")
    public String getIdAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_18219971 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_18219971 = getAttributeValue(null, "id");
        varB4EAC82CA7396A68D541C85D26508E83_18219971.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_18219971;
        // ---------- Original Method ----------
        //return getAttributeValue(null, "id");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.671 -0400", hash_original_method = "07D690E8F20AB7BFDE3AB681FB8BA29B", hash_generated_method = "0BB0212AC4A90984CF063ABAA4D3E1F4")
    public String getClassAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_1702858761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1702858761 = getAttributeValue(null, "class");
        varB4EAC82CA7396A68D541C85D26508E83_1702858761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1702858761;
        // ---------- Original Method ----------
        //return getAttributeValue(null, "class");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.671 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "461AC43A729F6F06CF5F07C9A2A72120")
    public int getIdAttributeResourceValue(int defaultValue) {
        int var834619C47448B8325060A7C2F54A8B64_1488309800 = (getAttributeResourceValue(null, "id", defaultValue));
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755975443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755975443;
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "id", defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.672 -0400", hash_original_method = "47F1D8ADCD04851946BC9C0B882261EE", hash_generated_method = "463ED2C4B1BE295F06647ACA1D5B2A1E")
    public int getStyleAttribute() {
        int var78D595595E9DBE14DC15098C8C968D18_163286754 = (getAttributeResourceValue(null, "style", 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998350644 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998350644;
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "style", 0);
    }

    
}

