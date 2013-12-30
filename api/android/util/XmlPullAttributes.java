package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.xmlpull.v1.XmlPullParser;

import com.android.internal.util.XmlUtils;






class XmlPullAttributes implements AttributeSet {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.026 -0500", hash_original_field = "7492C3C299D1412332C93303F683B706", hash_generated_field = "7492C3C299D1412332C93303F683B706")
 XmlPullParser mParser;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.952 -0500", hash_original_method = "46700DF76961858760F1F54A77DCF120", hash_generated_method = "75A5BAB989E114D629C7145D135A0A0F")
    
public XmlPullAttributes(XmlPullParser parser) {
        mParser = parser;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.954 -0500", hash_original_method = "AC633D604462F0666116EB932D89F378", hash_generated_method = "33B9AE34C1290A413EA84144E33AD86E")
    
public int getAttributeCount() {
        return mParser.getAttributeCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.956 -0500", hash_original_method = "BEE4E7A446CC9E8B5C15985188859485", hash_generated_method = "5D5A443A820452D60AB04D997E5E531B")
    
public String getAttributeName(int index) {
        return mParser.getAttributeName(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.958 -0500", hash_original_method = "A5436A02B7CB2BE76E834F087F6ECBA1", hash_generated_method = "92C896FB021164F335BD14C8BEECAE4D")
    
public String getAttributeValue(int index) {
        return mParser.getAttributeValue(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.961 -0500", hash_original_method = "0F6DE45848B198201E8558211308FA90", hash_generated_method = "2513DF4668E27008F10BE75A19CABAA0")
    
public String getAttributeValue(String namespace, String name) {
        return mParser.getAttributeValue(namespace, name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.963 -0500", hash_original_method = "D18F44DE17503E98739B2795B002BD8F", hash_generated_method = "016D6C66B316E6F83720EF4A41A9A943")
    
public String getPositionDescription() {
        return mParser.getPositionDescription();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.965 -0500", hash_original_method = "367A5DCA84F3DB949AE42F70B52DA04A", hash_generated_method = "7C8187B1F1ABBA3C52A1B6CF0220C00D")
    
public int getAttributeNameResource(int index) {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.967 -0500", hash_original_method = "4E31AE9A9364AB1AB86A7E4A35CF8815", hash_generated_method = "D3FE2C2F45B1D79A945AF1D8DA1EEAD6")
    
public int getAttributeListValue(String namespace, String attribute,
            String[] options, int defaultValue) {
        return XmlUtils.convertValueToList(
            getAttributeValue(namespace, attribute), options, defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.969 -0500", hash_original_method = "CB59BE8B074EA88200C6D038DF92BCD2", hash_generated_method = "BFDBFA717285BF4BDEEE396CCFE04A4F")
    
public boolean getAttributeBooleanValue(String namespace, String attribute,
            boolean defaultValue) {
        return XmlUtils.convertValueToBoolean(
            getAttributeValue(namespace, attribute), defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.972 -0500", hash_original_method = "B72C52627D560B7B2B8F954C65A581EF", hash_generated_method = "E1F19C0E927FD2690F3276E3737E092E")
    
public int getAttributeResourceValue(String namespace, String attribute,
            int defaultValue) {
        return XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.976 -0500", hash_original_method = "449DD6F89BAD60DF7A85871E701FCB24", hash_generated_method = "FE2F499A04F5639FFB731833605EEB22")
    
public int getAttributeIntValue(String namespace, String attribute,
            int defaultValue) {
        return XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.980 -0500", hash_original_method = "6A2C36F5482C4EBD163273692E451C50", hash_generated_method = "A32ED48D021D644DA48465D6F2CA0227")
    
public int getAttributeUnsignedIntValue(String namespace, String attribute,
            int defaultValue) {
        return XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(namespace, attribute), defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.983 -0500", hash_original_method = "D502685784CC790809C97ABBA05A2BE9", hash_generated_method = "A56C190708C9BE2FC641DB8D2A8378F7")
    
public float getAttributeFloatValue(String namespace, String attribute,
            float defaultValue) {
        String s = getAttributeValue(namespace, attribute);
        if (s != null) {
            return Float.parseFloat(s);
        }
        return defaultValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.987 -0500", hash_original_method = "4662E8BE42C313C76CDB4789305F27BC", hash_generated_method = "407D6D8090772E18E20BF4BCEBF315E4")
    
public int getAttributeListValue(int index,
            String[] options, int defaultValue) {
        return XmlUtils.convertValueToList(
            getAttributeValue(index), options, defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.991 -0500", hash_original_method = "5307D0D140F223DF06C748E39BFCF6F9", hash_generated_method = "BF6C4A67CE705BC8CE4F71A4A92E5640")
    
public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
        return XmlUtils.convertValueToBoolean(
            getAttributeValue(index), defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.995 -0500", hash_original_method = "13E9FD87B957377B70C3AD0477E922F3", hash_generated_method = "7D8CAC6604CBCA057C7CDA5FC88F9BFB")
    
public int getAttributeResourceValue(int index, int defaultValue) {
        return XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.998 -0500", hash_original_method = "139FB7EC46A06573986F935A6AB04CC8", hash_generated_method = "24CD78B39A63AA71D693332D3E5ED896")
    
public int getAttributeIntValue(int index, int defaultValue) {
        return XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.002 -0500", hash_original_method = "078871C14853487C7F2D178FA05191E4", hash_generated_method = "EC2A63D334E1A8B909CAB170DA733562")
    
public int getAttributeUnsignedIntValue(int index, int defaultValue) {
        return XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(index), defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.007 -0500", hash_original_method = "565BFCAA0E42C39EE8ABF3F09F50B574", hash_generated_method = "0F6DCA953FDB0588DE1056BC14F119E9")
    
public float getAttributeFloatValue(int index, float defaultValue) {
        String s = getAttributeValue(index);
        if (s != null) {
            return Float.parseFloat(s);
        }
        return defaultValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.011 -0500", hash_original_method = "30F655EDD1D9E306F8BD8B4F098F75CB", hash_generated_method = "5E09C6F3A8D97244ACFEDE52CB3B36E0")
    
public String getIdAttribute() {
        return getAttributeValue(null, "id");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.014 -0500", hash_original_method = "07D690E8F20AB7BFDE3AB681FB8BA29B", hash_generated_method = "C74F0B4720C35B4AC3357BAB8220DEBE")
    
public String getClassAttribute() {
        return getAttributeValue(null, "class");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.018 -0500", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "AD0E78A12043BCE7B42AA1C6170AAB78")
    
public int getIdAttributeResourceValue(int defaultValue) {
        return getAttributeResourceValue(null, "id", defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:21.022 -0500", hash_original_method = "47F1D8ADCD04851946BC9C0B882261EE", hash_generated_method = "E05D2B9883B7CF50D9C869E7E32B82C1")
    
public int getStyleAttribute() {
        return getAttributeResourceValue(null, "style", 0);
    }

    
}

