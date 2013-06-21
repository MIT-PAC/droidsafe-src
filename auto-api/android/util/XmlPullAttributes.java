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
    XmlPullParser mParser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.429 -0400", hash_original_method = "46700DF76961858760F1F54A77DCF120", hash_generated_method = "7A9D1FF18F0EB4DA41FBCFE169E89590")
    @DSModeled(DSC.SAFE)
    public XmlPullAttributes(XmlPullParser parser) {
        dsTaint.addTaint(parser.dsTaint);
        // ---------- Original Method ----------
        //mParser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.429 -0400", hash_original_method = "AC633D604462F0666116EB932D89F378", hash_generated_method = "5F690EC8BDB16F39FBF0E1F26444B3AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttributeCount() {
        int varF72DC07A82EAB97ADB3C3B546A9DB653_1665418514 = (mParser.getAttributeCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mParser.getAttributeCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.429 -0400", hash_original_method = "BEE4E7A446CC9E8B5C15985188859485", hash_generated_method = "153A8725DDA6001E23C80B0B5924E6B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAttributeName(int index) {
        dsTaint.addTaint(index);
        String var842CF5960F0E9F4E89BAEA918E1D5537_1990683848 = (mParser.getAttributeName(index));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mParser.getAttributeName(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.429 -0400", hash_original_method = "A5436A02B7CB2BE76E834F087F6ECBA1", hash_generated_method = "64FBC2D16C20C343695347D8230EC2F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAttributeValue(int index) {
        dsTaint.addTaint(index);
        String var1A8AEB70E0810C323E0ECDB1EB38CB40_887032728 = (mParser.getAttributeValue(index));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.430 -0400", hash_original_method = "0F6DE45848B198201E8558211308FA90", hash_generated_method = "C4FCC6D55226CE2A2260A286778FF300")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAttributeValue(String namespace, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(namespace);
        String varF4FD469095E7824A7DC2ECF9B567AEB7_518490607 = (mParser.getAttributeValue(namespace, name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(namespace, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.430 -0400", hash_original_method = "D18F44DE17503E98739B2795B002BD8F", hash_generated_method = "C60A5BE37010822378E0EA4ED771E3D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositionDescription() {
        String var1FA72E5C663BB78CE38D78F58D1667E5_1614307690 = (mParser.getPositionDescription());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mParser.getPositionDescription();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.430 -0400", hash_original_method = "367A5DCA84F3DB949AE42F70B52DA04A", hash_generated_method = "FE077CE1981CE6B35D23E3B9D055456F")
    @DSModeled(DSC.SAFE)
    public int getAttributeNameResource(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.430 -0400", hash_original_method = "4E31AE9A9364AB1AB86A7E4A35CF8815", hash_generated_method = "15BE563998A1F97D33118871E0AFCCF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttributeListValue(String namespace, String attribute,
            String[] options, int defaultValue) {
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(options[0]);
        dsTaint.addTaint(namespace);
        int var715EB671317F6D9184C790D39DEF00A8_1897311491 = (XmlUtils.convertValueToList(
            getAttributeValue(namespace, attribute), options, defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(namespace, attribute), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.430 -0400", hash_original_method = "CB59BE8B074EA88200C6D038DF92BCD2", hash_generated_method = "FB0698A732164345428C336766A1010A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getAttributeBooleanValue(String namespace, String attribute,
            boolean defaultValue) {
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(namespace);
        boolean var250FF62F8D3921AC8272255A24D76A37_83419796 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(namespace, attribute), defaultValue));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.431 -0400", hash_original_method = "B72C52627D560B7B2B8F954C65A581EF", hash_generated_method = "7A0FA57616A19C390D3A2037C0AAA0FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttributeResourceValue(String namespace, String attribute,
            int defaultValue) {
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(namespace);
        int varA9705B02A7D9315B6178C1600A3F7939_81750060 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.431 -0400", hash_original_method = "449DD6F89BAD60DF7A85871E701FCB24", hash_generated_method = "7D0ABA04BA8F12E58B2F59901F1913E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttributeIntValue(String namespace, String attribute,
            int defaultValue) {
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(namespace);
        int varA9705B02A7D9315B6178C1600A3F7939_282803333 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.431 -0400", hash_original_method = "6A2C36F5482C4EBD163273692E451C50", hash_generated_method = "ED34070A572AC29210EBB9F1A7707BBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttributeUnsignedIntValue(String namespace, String attribute,
            int defaultValue) {
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(namespace);
        int varCE3F9DBD69572A69DFC24BFED7017E04_1575879792 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(namespace, attribute), defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.431 -0400", hash_original_method = "D502685784CC790809C97ABBA05A2BE9", hash_generated_method = "AFEB58821259D5800C533FF12A61EF59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getAttributeFloatValue(String namespace, String attribute,
            float defaultValue) {
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(namespace);
        String s;
        s = getAttributeValue(namespace, attribute);
        {
            float var502301E3A4629072E930D323C47A3F08_2031185592 = (Float.parseFloat(s));
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //String s = getAttributeValue(namespace, attribute);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.431 -0400", hash_original_method = "4662E8BE42C313C76CDB4789305F27BC", hash_generated_method = "ECB6ABCB40159594411DE5914314AF40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttributeListValue(int index,
            String[] options, int defaultValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(options[0]);
        int var4EC91EC07CA7157BDAA3C419E7A846E6_1306568619 = (XmlUtils.convertValueToList(
            getAttributeValue(index), options, defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(index), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.432 -0400", hash_original_method = "5307D0D140F223DF06C748E39BFCF6F9", hash_generated_method = "91379826E9DEF3299698400B1BC92312")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(defaultValue);
        boolean varD49E277DCF89E54EAC6AD0F7A669FCE1_240983531 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(index), defaultValue));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.432 -0400", hash_original_method = "13E9FD87B957377B70C3AD0477E922F3", hash_generated_method = "41A97D63A14B8923C9ECF03EC6F1C98F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttributeResourceValue(int index, int defaultValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(defaultValue);
        int var9E5E2AF0AB6AB748E42DE75C1B4E07BB_1201990303 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.432 -0400", hash_original_method = "139FB7EC46A06573986F935A6AB04CC8", hash_generated_method = "BABD1D51C279C0F0ADF4D51D3815B219")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttributeIntValue(int index, int defaultValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(defaultValue);
        int var9E5E2AF0AB6AB748E42DE75C1B4E07BB_1836195945 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.432 -0400", hash_original_method = "078871C14853487C7F2D178FA05191E4", hash_generated_method = "797024E28E7439A07160EE7271021441")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttributeUnsignedIntValue(int index, int defaultValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(defaultValue);
        int varBDA2420184B64FE38B062CC9A682A5E7_1374454924 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(index), defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.433 -0400", hash_original_method = "565BFCAA0E42C39EE8ABF3F09F50B574", hash_generated_method = "969EAE309C827AC5172DE6945072C206")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getAttributeFloatValue(int index, float defaultValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(defaultValue);
        String s;
        s = getAttributeValue(index);
        {
            float var502301E3A4629072E930D323C47A3F08_2411838 = (Float.parseFloat(s));
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //String s = getAttributeValue(index);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.433 -0400", hash_original_method = "30F655EDD1D9E306F8BD8B4F098F75CB", hash_generated_method = "9BEC4C018E0B8611AC2C8D5B0F70822D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIdAttribute() {
        String var1F019799DA6105DF4C1D87604A23F406_1994898274 = (getAttributeValue(null, "id"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getAttributeValue(null, "id");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.433 -0400", hash_original_method = "07D690E8F20AB7BFDE3AB681FB8BA29B", hash_generated_method = "0CDFA6FA5AA74628A0E9692CD020D831")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getClassAttribute() {
        String var950FDF2ACEA72A4FBB25694789DDE3B7_189729565 = (getAttributeValue(null, "class"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getAttributeValue(null, "class");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.433 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "5E6F1CF6CD4276589AF689BCFF2A905C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIdAttributeResourceValue(int defaultValue) {
        dsTaint.addTaint(defaultValue);
        int var834619C47448B8325060A7C2F54A8B64_1142241189 = (getAttributeResourceValue(null, "id", defaultValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "id", defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.434 -0400", hash_original_method = "47F1D8ADCD04851946BC9C0B882261EE", hash_generated_method = "F6599B108078C352A5A74DF61F3E16E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStyleAttribute() {
        int var78D595595E9DBE14DC15098C8C968D18_1891477547 = (getAttributeResourceValue(null, "style", 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "style", 0);
    }

    
}

