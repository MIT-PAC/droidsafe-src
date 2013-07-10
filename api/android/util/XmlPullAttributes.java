package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import android.util.AttributeSet;
import com.android.internal.util.XmlUtils;

class XmlPullAttributes implements AttributeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.794 -0400", hash_original_field = "BADDC1E0767DE74C04327A058F5013C3", hash_generated_field = "7492C3C299D1412332C93303F683B706")

    XmlPullParser mParser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.794 -0400", hash_original_method = "46700DF76961858760F1F54A77DCF120", hash_generated_method = "9596B1361EACD78292EF670433107D82")
    public  XmlPullAttributes(XmlPullParser parser) {
        mParser = parser;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.794 -0400", hash_original_method = "AC633D604462F0666116EB932D89F378", hash_generated_method = "9DF7B2832BE7BFA13320A5348E03A44B")
    public int getAttributeCount() {
        int varF72DC07A82EAB97ADB3C3B546A9DB653_423624286 = (mParser.getAttributeCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999431413 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999431413;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.795 -0400", hash_original_method = "BEE4E7A446CC9E8B5C15985188859485", hash_generated_method = "2E5B0C32CADD8D54A29F2C0E9EE06349")
    public String getAttributeName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1838393446 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1838393446 = mParser.getAttributeName(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1838393446.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1838393446;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.795 -0400", hash_original_method = "A5436A02B7CB2BE76E834F087F6ECBA1", hash_generated_method = "FE3B133F87D9C6FD2C37F3E9A31ECEDB")
    public String getAttributeValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_790394325 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_790394325 = mParser.getAttributeValue(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_790394325.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_790394325;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.796 -0400", hash_original_method = "0F6DE45848B198201E8558211308FA90", hash_generated_method = "09C606CABEBBF48E69EF81AC881058DC")
    public String getAttributeValue(String namespace, String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_126051267 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_126051267 = mParser.getAttributeValue(namespace, name);
        addTaint(namespace.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_126051267.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_126051267;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.796 -0400", hash_original_method = "D18F44DE17503E98739B2795B002BD8F", hash_generated_method = "60B1210B7DE4D7FEFA8DEF01BBB17FCF")
    public String getPositionDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_2047007464 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2047007464 = mParser.getPositionDescription();
        varB4EAC82CA7396A68D541C85D26508E83_2047007464.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2047007464;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.796 -0400", hash_original_method = "367A5DCA84F3DB949AE42F70B52DA04A", hash_generated_method = "250BC064B0E727D18C9298B36BF3F948")
    public int getAttributeNameResource(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1167863072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1167863072;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.797 -0400", hash_original_method = "4E31AE9A9364AB1AB86A7E4A35CF8815", hash_generated_method = "3F8A45EAD8A446F55A068B38B0F56517")
    public int getAttributeListValue(String namespace, String attribute,
            String[] options, int defaultValue) {
        int var715EB671317F6D9184C790D39DEF00A8_694497217 = (XmlUtils.convertValueToList(
            getAttributeValue(namespace, attribute), options, defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(options[0].getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040911416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040911416;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.797 -0400", hash_original_method = "CB59BE8B074EA88200C6D038DF92BCD2", hash_generated_method = "8C1582096A9BCF0CC4B2B963E90C7D62")
    public boolean getAttributeBooleanValue(String namespace, String attribute,
            boolean defaultValue) {
        boolean var250FF62F8D3921AC8272255A24D76A37_1524858519 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_994169550 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_994169550;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.797 -0400", hash_original_method = "B72C52627D560B7B2B8F954C65A581EF", hash_generated_method = "4EAA91FAB32178D6B2B412AEB6257786")
    public int getAttributeResourceValue(String namespace, String attribute,
            int defaultValue) {
        int varA9705B02A7D9315B6178C1600A3F7939_487313300 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939364487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939364487;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.797 -0400", hash_original_method = "449DD6F89BAD60DF7A85871E701FCB24", hash_generated_method = "E8C9813A616FA4E42B20B53880CEABD3")
    public int getAttributeIntValue(String namespace, String attribute,
            int defaultValue) {
        int varA9705B02A7D9315B6178C1600A3F7939_670659172 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19046110 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19046110;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.798 -0400", hash_original_method = "6A2C36F5482C4EBD163273692E451C50", hash_generated_method = "7D7399C7CBF7EADABF35DE0F833D7B7B")
    public int getAttributeUnsignedIntValue(String namespace, String attribute,
            int defaultValue) {
        int varCE3F9DBD69572A69DFC24BFED7017E04_701936259 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(namespace, attribute), defaultValue));
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598442443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598442443;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.798 -0400", hash_original_method = "D502685784CC790809C97ABBA05A2BE9", hash_generated_method = "0A2CCEDE2C1CA00688DA280B38BAE6E6")
    public float getAttributeFloatValue(String namespace, String attribute,
            float defaultValue) {
        String s = getAttributeValue(namespace, attribute);
        {
            float var502301E3A4629072E930D323C47A3F08_1092801122 = (Float.parseFloat(s));
        } 
        addTaint(namespace.getTaint());
        addTaint(attribute.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_673634064 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_673634064;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.799 -0400", hash_original_method = "4662E8BE42C313C76CDB4789305F27BC", hash_generated_method = "51706552485C8964EBBB88F237C792A8")
    public int getAttributeListValue(int index,
            String[] options, int defaultValue) {
        int var4EC91EC07CA7157BDAA3C419E7A846E6_644580091 = (XmlUtils.convertValueToList(
            getAttributeValue(index), options, defaultValue));
        addTaint(index);
        addTaint(options[0].getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745826963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745826963;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.799 -0400", hash_original_method = "5307D0D140F223DF06C748E39BFCF6F9", hash_generated_method = "EA7FDD6EAA33744E0AEFA17C471814CE")
    public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
        boolean varD49E277DCF89E54EAC6AD0F7A669FCE1_834987178 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867679267 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867679267;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.800 -0400", hash_original_method = "13E9FD87B957377B70C3AD0477E922F3", hash_generated_method = "66DA6CDDB590B95DF175B271739AF3DC")
    public int getAttributeResourceValue(int index, int defaultValue) {
        int var9E5E2AF0AB6AB748E42DE75C1B4E07BB_494517405 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136814336 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136814336;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.800 -0400", hash_original_method = "139FB7EC46A06573986F935A6AB04CC8", hash_generated_method = "29AB844F2454876FB02369628099070E")
    public int getAttributeIntValue(int index, int defaultValue) {
        int var9E5E2AF0AB6AB748E42DE75C1B4E07BB_441357587 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135209758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135209758;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.801 -0400", hash_original_method = "078871C14853487C7F2D178FA05191E4", hash_generated_method = "10957143DE605329B1C97C35991B5825")
    public int getAttributeUnsignedIntValue(int index, int defaultValue) {
        int varBDA2420184B64FE38B062CC9A682A5E7_921784604 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(index), defaultValue));
        addTaint(index);
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684730753 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684730753;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.801 -0400", hash_original_method = "565BFCAA0E42C39EE8ABF3F09F50B574", hash_generated_method = "3DEA963AFFE7AAA0A707BE402CFFBF5A")
    public float getAttributeFloatValue(int index, float defaultValue) {
        String s = getAttributeValue(index);
        {
            float var502301E3A4629072E930D323C47A3F08_1266864343 = (Float.parseFloat(s));
        } 
        addTaint(index);
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1941240759 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1941240759;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.802 -0400", hash_original_method = "30F655EDD1D9E306F8BD8B4F098F75CB", hash_generated_method = "A6D2DEFC93BFD1A18B984DA4CE8B96D1")
    public String getIdAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_2127605146 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2127605146 = getAttributeValue(null, "id");
        varB4EAC82CA7396A68D541C85D26508E83_2127605146.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2127605146;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.802 -0400", hash_original_method = "07D690E8F20AB7BFDE3AB681FB8BA29B", hash_generated_method = "0661602442CBA40DDABE83FE882758FA")
    public String getClassAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_1890569847 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1890569847 = getAttributeValue(null, "class");
        varB4EAC82CA7396A68D541C85D26508E83_1890569847.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1890569847;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.802 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "7A48DAB0D8680EBDBA5DA82E24B49A08")
    public int getIdAttributeResourceValue(int defaultValue) {
        int var834619C47448B8325060A7C2F54A8B64_362686965 = (getAttributeResourceValue(null, "id", defaultValue));
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556120823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556120823;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.802 -0400", hash_original_method = "47F1D8ADCD04851946BC9C0B882261EE", hash_generated_method = "108DD060AE30BB2166801851F9BF3558")
    public int getStyleAttribute() {
        int var78D595595E9DBE14DC15098C8C968D18_1396550962 = (getAttributeResourceValue(null, "style", 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728154581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728154581;
        
        
    }

    
}

