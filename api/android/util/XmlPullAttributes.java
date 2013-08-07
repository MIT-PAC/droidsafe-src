package android.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.xmlpull.v1.XmlPullParser;

import com.android.internal.util.XmlUtils;






class XmlPullAttributes implements AttributeSet {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.364 -0400", hash_original_field = "BADDC1E0767DE74C04327A058F5013C3", hash_generated_field = "7492C3C299D1412332C93303F683B706")

    XmlPullParser mParser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.364 -0400", hash_original_method = "46700DF76961858760F1F54A77DCF120", hash_generated_method = "9596B1361EACD78292EF670433107D82")
    @DSModeled(DSC.SAFE)
    public  XmlPullAttributes(XmlPullParser parser) {
        mParser = parser;
        // ---------- Original Method ----------
        //mParser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.365 -0400", hash_original_method = "AC633D604462F0666116EB932D89F378", hash_generated_method = "2C7603344D8181C9FA721763DDC8DB69")
    public int getAttributeCount() {
        int var4A6D3039205D454979F4204E3D71ACF5_1296470188 = (mParser.getAttributeCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954423889 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954423889;
        // ---------- Original Method ----------
        //return mParser.getAttributeCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.365 -0400", hash_original_method = "BEE4E7A446CC9E8B5C15985188859485", hash_generated_method = "73E99974C8BBD9407E3A85C8BCF7F2BC")
    public String getAttributeName(int index) {
        addTaint(index);
String varF5672C26923E2F45F96CB3B67BAAA038_859756131 =         mParser.getAttributeName(index);
        varF5672C26923E2F45F96CB3B67BAAA038_859756131.addTaint(taint);
        return varF5672C26923E2F45F96CB3B67BAAA038_859756131;
        // ---------- Original Method ----------
        //return mParser.getAttributeName(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.365 -0400", hash_original_method = "A5436A02B7CB2BE76E834F087F6ECBA1", hash_generated_method = "21850E07DE003853C744D8FE11A9EFC0")
    public String getAttributeValue(int index) {
        addTaint(index);
String var59EDCB0BCEB8C287722A2D6BDEEBA88E_485140957 =         mParser.getAttributeValue(index);
        var59EDCB0BCEB8C287722A2D6BDEEBA88E_485140957.addTaint(taint);
        return var59EDCB0BCEB8C287722A2D6BDEEBA88E_485140957;
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.366 -0400", hash_original_method = "0F6DE45848B198201E8558211308FA90", hash_generated_method = "3ECDD32C12931A77C7AD302EE671DBD7")
    public String getAttributeValue(String namespace, String name) {
        addTaint(name.getTaint());
        addTaint(namespace.getTaint());
String var25E6A9EF046C0193A13410F438672137_1606689160 =         mParser.getAttributeValue(namespace, name);
        var25E6A9EF046C0193A13410F438672137_1606689160.addTaint(taint);
        return var25E6A9EF046C0193A13410F438672137_1606689160;
        // ---------- Original Method ----------
        //return mParser.getAttributeValue(namespace, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.366 -0400", hash_original_method = "D18F44DE17503E98739B2795B002BD8F", hash_generated_method = "67B270CF7CED0825B2B2C0E760F0B2BF")
    public String getPositionDescription() {
String var0CAF51F9DBF27494419FBD21322156ED_2031498517 =         mParser.getPositionDescription();
        var0CAF51F9DBF27494419FBD21322156ED_2031498517.addTaint(taint);
        return var0CAF51F9DBF27494419FBD21322156ED_2031498517;
        // ---------- Original Method ----------
        //return mParser.getPositionDescription();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.366 -0400", hash_original_method = "367A5DCA84F3DB949AE42F70B52DA04A", hash_generated_method = "DB22F40142AC0BA150A29C7CE34481DE")
    public int getAttributeNameResource(int index) {
        addTaint(index);
        int varCFCD208495D565EF66E7DFF9F98764DA_1992303760 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_708054489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_708054489;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.367 -0400", hash_original_method = "4E31AE9A9364AB1AB86A7E4A35CF8815", hash_generated_method = "CF595320F5FE6FB0B7D291D1EF754D3D")
    public int getAttributeListValue(String namespace, String attribute,
            String[] options, int defaultValue) {
        addTaint(defaultValue);
        addTaint(options[0].getTaint());
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        int var9D74860A948A48945C9DE96CF0DB70F5_1710270434 = (XmlUtils.convertValueToList(
            getAttributeValue(namespace, attribute), options, defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504900387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504900387;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(namespace, attribute), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.367 -0400", hash_original_method = "CB59BE8B074EA88200C6D038DF92BCD2", hash_generated_method = "97902013591346CF99E079007399127A")
    public boolean getAttributeBooleanValue(String namespace, String attribute,
            boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        boolean var806017EBCF6408C0D3889FBD33907FF1_436473542 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(namespace, attribute), defaultValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796345004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_796345004;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.368 -0400", hash_original_method = "B72C52627D560B7B2B8F954C65A581EF", hash_generated_method = "0A5E9A8BF79EA6AE07F42A512D670632")
    public int getAttributeResourceValue(String namespace, String attribute,
            int defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        int var9395C37AF994D99D971AE8B5B62B5440_1709103345 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609960533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609960533;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.368 -0400", hash_original_method = "449DD6F89BAD60DF7A85871E701FCB24", hash_generated_method = "C689EE580542D6229B71157470D56D72")
    public int getAttributeIntValue(String namespace, String attribute,
            int defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        int var9395C37AF994D99D971AE8B5B62B5440_1870305583 = (XmlUtils.convertValueToInt(
            getAttributeValue(namespace, attribute), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003269731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003269731;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.368 -0400", hash_original_method = "6A2C36F5482C4EBD163273692E451C50", hash_generated_method = "DB0C8858E5C03DD6D9BE14A42261E5AC")
    public int getAttributeUnsignedIntValue(String namespace, String attribute,
            int defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        int var86179AA923BC31F304D2A9FCD06A12AD_720902008 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(namespace, attribute), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389101742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389101742;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(namespace, attribute), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.369 -0400", hash_original_method = "D502685784CC790809C97ABBA05A2BE9", hash_generated_method = "174D24110BC2DD8659DD5C382F087294")
    public float getAttributeFloatValue(String namespace, String attribute,
            float defaultValue) {
        addTaint(defaultValue);
        addTaint(attribute.getTaint());
        addTaint(namespace.getTaint());
        String s = getAttributeValue(namespace, attribute);
        if(s != null)        
        {
            float varC895301DE2F78953F2C82FE15543D719_872896403 = (Float.parseFloat(s));
                        float var546ADE640B6EDFBC8A086EF31347E768_1244460384 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1244460384;
        } //End block
        float var16830A58E1E33A4163524366BA7B701B_1708543307 = (defaultValue);
                float var546ADE640B6EDFBC8A086EF31347E768_1196510953 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1196510953;
        // ---------- Original Method ----------
        //String s = getAttributeValue(namespace, attribute);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.370 -0400", hash_original_method = "4662E8BE42C313C76CDB4789305F27BC", hash_generated_method = "D6ABF4756D81A8DB99B5EBC87063D565")
    public int getAttributeListValue(int index,
            String[] options, int defaultValue) {
        addTaint(defaultValue);
        addTaint(options[0].getTaint());
        addTaint(index);
        int var99E27D241A5987ED767B51093932ED72_399340473 = (XmlUtils.convertValueToList(
            getAttributeValue(index), options, defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131085292 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131085292;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToList(
            //getAttributeValue(index), options, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.370 -0400", hash_original_method = "5307D0D140F223DF06C748E39BFCF6F9", hash_generated_method = "07E59E7932AB66B5CE7E8F021B5283CD")
    public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        boolean varADED708EB4A08189F4D0AC95543C7E92_1332594013 = (XmlUtils.convertValueToBoolean(
            getAttributeValue(index), defaultValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1320722574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1320722574;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToBoolean(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.371 -0400", hash_original_method = "13E9FD87B957377B70C3AD0477E922F3", hash_generated_method = "F1DAA2AA7088B63AEC0BC9B01EF0712F")
    public int getAttributeResourceValue(int index, int defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        int varAC0147FEE2C9EB268EF549D8D002AD25_1334523491 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126128358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126128358;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.371 -0400", hash_original_method = "139FB7EC46A06573986F935A6AB04CC8", hash_generated_method = "C5531E4293C9A18D555C43AB88FED801")
    public int getAttributeIntValue(int index, int defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        int varAC0147FEE2C9EB268EF549D8D002AD25_1301725090 = (XmlUtils.convertValueToInt(
            getAttributeValue(index), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_676695421 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_676695421;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.372 -0400", hash_original_method = "078871C14853487C7F2D178FA05191E4", hash_generated_method = "7391FFB2207064C6A6290E19EA6F22EE")
    public int getAttributeUnsignedIntValue(int index, int defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        int var44F8653FE78EBF14A9A534546AF3F5AD_1762473284 = (XmlUtils.convertValueToUnsignedInt(
            getAttributeValue(index), defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876070615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876070615;
        // ---------- Original Method ----------
        //return XmlUtils.convertValueToUnsignedInt(
            //getAttributeValue(index), defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.373 -0400", hash_original_method = "565BFCAA0E42C39EE8ABF3F09F50B574", hash_generated_method = "373E314CA54CDEE7BC93A06C60E24DAB")
    public float getAttributeFloatValue(int index, float defaultValue) {
        addTaint(defaultValue);
        addTaint(index);
        String s = getAttributeValue(index);
        if(s != null)        
        {
            float varC895301DE2F78953F2C82FE15543D719_605412685 = (Float.parseFloat(s));
                        float var546ADE640B6EDFBC8A086EF31347E768_1470095415 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1470095415;
        } //End block
        float var16830A58E1E33A4163524366BA7B701B_1730166541 = (defaultValue);
                float var546ADE640B6EDFBC8A086EF31347E768_2114995895 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2114995895;
        // ---------- Original Method ----------
        //String s = getAttributeValue(index);
        //if (s != null) {
            //return Float.parseFloat(s);
        //}
        //return defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.373 -0400", hash_original_method = "30F655EDD1D9E306F8BD8B4F098F75CB", hash_generated_method = "3C41C0D93D147C948B28A982F80BAD85")
    public String getIdAttribute() {
String varA4BFF0A08B5991425453CC5F81821C8F_1142462674 =         getAttributeValue(null, "id");
        varA4BFF0A08B5991425453CC5F81821C8F_1142462674.addTaint(taint);
        return varA4BFF0A08B5991425453CC5F81821C8F_1142462674;
        // ---------- Original Method ----------
        //return getAttributeValue(null, "id");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.373 -0400", hash_original_method = "07D690E8F20AB7BFDE3AB681FB8BA29B", hash_generated_method = "A765877B7AB30C5509FCB6891ABB6EFC")
    public String getClassAttribute() {
String varE16E70835600F1AEF3E518ED615E409D_1181623676 =         getAttributeValue(null, "class");
        varE16E70835600F1AEF3E518ED615E409D_1181623676.addTaint(taint);
        return varE16E70835600F1AEF3E518ED615E409D_1181623676;
        // ---------- Original Method ----------
        //return getAttributeValue(null, "class");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.374 -0400", hash_original_method = "BE1A0DA79A6356AD791A8CD183D22590", hash_generated_method = "0D44E07BA2D4497845A36D6DC8B438A0")
    public int getIdAttributeResourceValue(int defaultValue) {
        addTaint(defaultValue);
        int varCD137CD47DD67CEDD2FB3C345949E98D_1648069478 = (getAttributeResourceValue(null, "id", defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548368012 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548368012;
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "id", defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.374 -0400", hash_original_method = "47F1D8ADCD04851946BC9C0B882261EE", hash_generated_method = "AF64114BFD82E2D9FC3E3D9013B20326")
    public int getStyleAttribute() {
        int var76395DB4CC2974D505F0D3330E7FF713_1661422074 = (getAttributeResourceValue(null, "style", 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106927118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106927118;
        // ---------- Original Method ----------
        //return getAttributeResourceValue(null, "style", 0);
    }

    
}

