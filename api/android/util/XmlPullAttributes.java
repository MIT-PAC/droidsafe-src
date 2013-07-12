package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.xmlpull.v1.XmlPullParser;
import android.util.AttributeSet;
import com.android.internal.util.XmlUtils;

class XmlPullAttributes implements AttributeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.481 -0400", hash_original_field = "BADDC1E0767DE74C04327A058F5013C3", hash_generated_field = "7492C3C299D1412332C93303F683B706")

    XmlPullParser mParser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.481 -0400", hash_original_method = "46700DF76961858760F1F54A77DCF120", hash_generated_method = "9596B1361EACD78292EF670433107D82")
    public  XmlPullAttributes(XmlPullParser parser) {
        mParser = parser;
        // ---------- Original Method ----------
        //mParser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.481 -0400", hash_original_method = "AC633D604462F0666116EB932D89F378", hash_generated_method = "013CC12873CC4DE97E59B3B69B58292A")
    public int getAttributeCount() {
        int var4A6D3039205D454979F4204E3D71ACF5_366363643 = (mParser.getAttributeCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558237716 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558237716;
        // ---------- Original Method ----------
        //return mParser.getAttributeCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.482 -0400", hash_original_method = "BEE4E7A446CC9E8B5C15985188859485", hash_generated_method = "528F14A477071127083DBA06A5523097")
    public String getAttributeName(int index) {
        addTaint(index);
String varF5672C26923E2F45F96CB3B67BAAA038_306612029 =         mParser.getAttributeName(index);
        varF5672C26923E2F45F96CB3B67BAAA038_306612029.addTaint(taint);
        return varF5672C26923E2F45F96CB3B67BAAA038_306612029;
        // ---------- Original Method ----------
        //return mParser.getAttributeName(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.482 -0400", hash_original_method = "A5436A02B7CB2BE76E834F087F6ECBA1", hash_generated_method = "9FB741CC8DF106449BEF556918E5F23F")
    public String getAttributeValue(int index) {
        addTaint(index);
String var59EDCB0BCEB8C287722A2D6BDEEBA88E_1784942807 =         mParser.getAttributeValue(index);
        var59EDCB0BCEB8C287722A2D6BDEEBA88E_1784942807.addTaint(taint);
        return var59EDCB0BCEB8C287722A2D6BDEEBA88E_1784942807;
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.482 -0400", hash_original_method = "0F6DE45848B198201E8558211308FA90", hash_generated_method = "C42FDA01C2176C8E108EB5183D95F28B")
    public String getAttributeValue(String namespace, String name) {
        addTaint(name.getTaint());
        addTaint(namespace.getTaint());
String var25E6A9EF046C0193A13410F438672137_1566997583 =         mParser.getAttributeValue(namespace, name);
        var25E6A9EF046C0193A13410F438672137_1566997583.addTaint(taint);
        return var25E6A9EF046C0193A13410F438672137_1566997583;
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(namespace, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.482 -0400", hash_original_method = "D18F44DE17503E98739B2795B002BD8F", hash_generated_method = "D28334890825EDB5BD65688175494163")
    public String getPositionDescription() {
String var0CAF51F9DBF27494419FBD21322156ED_1297979630 =         mParser.getPositionDescription();
        var0CAF51F9DBF27494419FBD21322156ED_1297979630.addTaint(taint);
        return var0CAF51F9DBF27494419FBD21322156ED_1297979630;
        // ---------- Original Method ----------
        //return mParser.getPositionDescription();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.483 -0400", hash_original_method = "367A5DCA84F3DB949AE42F70B52DA04A", hash_generated_method = "3BD8A206112429E6892273E0ADE5C7D5")
    public int getAttributeNameResource(int index) {
        addTaint(index);
        int varCFCD208495D565EF66E7DFF9F98764DA_1875641050 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670598931 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670598931;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.483 -0400", hash_original_method = "4E31AE9A9364AB1AB86A7E4A35CF8815", hash_generated_method = "6AFB0524796CF31841105AAE56CB3DFF")
    public int getAttributeListValue(String namespace, String attribute,
            String[] options, int defaultValue) {
        addTaint(defaultValue);
        addTaint(options[0].getTaint());
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        int var9D74860A948A48945C9DE96CF0DB70F5_2135559480 = (XmlUtils.convertValueToList(
            getAttributeValue(namespace, attribute), options, defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085955377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085955377;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(namespace, attribute), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.483 -0400", hash_original_method = "CB59BE8B074EA88200C6D038DF92BCD2", hash_generated_method = "19911EACBADB7E65A7A5E3EADD24702C")
    public boolean getAttributeBooleanValue(String namespace, String attribute,
            boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        boolean var806017EBCF6408C0D3889FBD33907FF1_2026651102 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(namespace, attribute), defaultValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819259687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819259687;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.484 -0400", hash_original_method = "B72C52627D560B7B2B8F954C65A581EF", hash_generated_method = "5C6765793737C75395AC66588FC52603")
    public int getAttributeResourceValue(String namespace, String attribute,
            int defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        int var9395C37AF994D99D971AE8B5B62B5440_1315066219 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484181219 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484181219;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.484 -0400", hash_original_method = "449DD6F89BAD60DF7A85871E701FCB24", hash_generated_method = "7B4C53A94E728C6D422EECB9FD579300")
    public int getAttributeIntValue(String namespace, String attribute,
            int defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        int var9395C37AF994D99D971AE8B5B62B5440_979135194 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155984237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155984237;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.485 -0400", hash_original_method = "6A2C36F5482C4EBD163273692E451C50", hash_generated_method = "7719F52504087BF1F7471A55F3DDC419")
    public int getAttributeUnsignedIntValue(String namespace, String attribute,
            int defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        int var86179AA923BC31F304D2A9FCD06A12AD_104731187 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(namespace, attribute), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348047027 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348047027;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.485 -0400", hash_original_method = "D502685784CC790809C97ABBA05A2BE9", hash_generated_method = "B2D7FC0CD1B6E0CF6A90B79080926691")
    public float getAttributeFloatValue(String namespace, String attribute,
            float defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        String s = getAttributeValue(namespace, attribute);
    if(s != null)        
        {
            float varC895301DE2F78953F2C82FE15543D719_391197658 = (Float.parseFloat(s));
                        float var546ADE640B6EDFBC8A086EF31347E768_1865639206 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1865639206;
        } //End block
        float var16830A58E1E33A4163524366BA7B701B_545312820 = (defaultValue);
                float var546ADE640B6EDFBC8A086EF31347E768_1351828896 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1351828896;
        // ---------- Original Method ----------
        //String s = getAttributeValue(namespace, attribute);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.485 -0400", hash_original_method = "4662E8BE42C313C76CDB4789305F27BC", hash_generated_method = "711E0AA69553473D9B3462E74B41914B")
    public int getAttributeListValue(int index,
            String[] options, int defaultValue) {
        addTaint(defaultValue);
        addTaint(options[0].getTaint());
        addTaint(index);
        int var99E27D241A5987ED767B51093932ED72_1425506667 = (XmlUtils.convertValueToList(
            getAttributeValue(index), options, defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173833933 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173833933;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(index), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.486 -0400", hash_original_method = "5307D0D140F223DF06C748E39BFCF6F9", hash_generated_method = "10335A560FB3F642E00F385A843CF777")
    public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        boolean varADED708EB4A08189F4D0AC95543C7E92_1656179315 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(index), defaultValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178556487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_178556487;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.486 -0400", hash_original_method = "13E9FD87B957377B70C3AD0477E922F3", hash_generated_method = "A637E3286F6942679C5B31A28539FA64")
    public int getAttributeResourceValue(int index, int defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        int varAC0147FEE2C9EB268EF549D8D002AD25_306566061 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_609418905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_609418905;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.487 -0400", hash_original_method = "139FB7EC46A06573986F935A6AB04CC8", hash_generated_method = "AE0FF1B433B399DE01E0763104CD6689")
    public int getAttributeIntValue(int index, int defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        int varAC0147FEE2C9EB268EF549D8D002AD25_1574380892 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331863832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331863832;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.487 -0400", hash_original_method = "078871C14853487C7F2D178FA05191E4", hash_generated_method = "E2DCE45089FF70B85EDD741CD7F3B6C8")
    public int getAttributeUnsignedIntValue(int index, int defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        int var44F8653FE78EBF14A9A534546AF3F5AD_1005137491 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(index), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710267454 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710267454;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.487 -0400", hash_original_method = "565BFCAA0E42C39EE8ABF3F09F50B574", hash_generated_method = "E781197476015963AB2F1EBEBEABC261")
    public float getAttributeFloatValue(int index, float defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        String s = getAttributeValue(index);
    if(s != null)        
        {
            float varC895301DE2F78953F2C82FE15543D719_528409454 = (Float.parseFloat(s));
                        float var546ADE640B6EDFBC8A086EF31347E768_1999136515 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1999136515;
        } //End block
        float var16830A58E1E33A4163524366BA7B701B_1045194054 = (defaultValue);
                float var546ADE640B6EDFBC8A086EF31347E768_363998193 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_363998193;
        // ---------- Original Method ----------
        //String s = getAttributeValue(index);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.488 -0400", hash_original_method = "30F655EDD1D9E306F8BD8B4F098F75CB", hash_generated_method = "922233764448CA6799CB93ADFC8C2DC2")
    public String getIdAttribute() {
String varA4BFF0A08B5991425453CC5F81821C8F_349106982 =         getAttributeValue(null, "id");
        varA4BFF0A08B5991425453CC5F81821C8F_349106982.addTaint(taint);
        return varA4BFF0A08B5991425453CC5F81821C8F_349106982;
        // ---------- Original Method ----------
        //return getAttributeValue(null, "id");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.488 -0400", hash_original_method = "07D690E8F20AB7BFDE3AB681FB8BA29B", hash_generated_method = "C78D2D72E639AB2A5BAFD85CF8B8792C")
    public String getClassAttribute() {
String varE16E70835600F1AEF3E518ED615E409D_103444761 =         getAttributeValue(null, "class");
        varE16E70835600F1AEF3E518ED615E409D_103444761.addTaint(taint);
        return varE16E70835600F1AEF3E518ED615E409D_103444761;
        // ---------- Original Method ----------
        //return getAttributeValue(null, "class");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.488 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "59C0BC0FC1DA87E682BF612D37338823")
    public int getIdAttributeResourceValue(int defaultValue) {
        addTaint(defaultValue);
        int varCD137CD47DD67CEDD2FB3C345949E98D_1297100996 = (getAttributeResourceValue(null, "id", defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974730564 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974730564;
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "id", defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.489 -0400", hash_original_method = "47F1D8ADCD04851946BC9C0B882261EE", hash_generated_method = "E27419547CA737B06382084E2010AFBA")
    public int getStyleAttribute() {
        int var76395DB4CC2974D505F0D3330E7FF713_2050213364 = (getAttributeResourceValue(null, "style", 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514848822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514848822;
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "style", 0);
    }

    
}

