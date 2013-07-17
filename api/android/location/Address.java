package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.869 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.869 -0400", hash_original_field = "8937E233714B037ECE45D23AA79BE19E", hash_generated_field = "885B87E22D2EF7CC7C342A420B72EF3E")

    private String mFeatureName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.869 -0400", hash_original_field = "36BE4E7B894E1FE49E224E15F4F09E30", hash_generated_field = "267F6B9285B603FF477C20775D29AA60")

    private HashMap<Integer, String> mAddressLines;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "5B6E8EDDE261396A90E6DE4AA7DED93C", hash_generated_field = "61A068F86D173398FFF3F86ABD61DF78")

    private int mMaxAddressLineIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "AE9759C687BF60F269594A7976FFE5FE", hash_generated_field = "9E4BAF383B0085BDBE33EFF069DD6A8A")

    private String mAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "8D06393B99CFCE4BBDB353A8B6ED85AA", hash_generated_field = "5914F416D26BAEA83D36B07CC8123017")

    private String mSubAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "5AD01704F5F406F72AF7849956EE8F0F", hash_generated_field = "B27EC088B31F0C4F3FC5FD8261A96829")

    private String mLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "D392069C4E4C8DE4BDCF9B1203629260", hash_generated_field = "54AA36C926071A6092BD97F68F4B1C69")

    private String mSubLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "AEFA91646A44DC198B507332D2E5632B", hash_generated_field = "572923B079894AE27884BBD950702954")

    private String mThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "AB0822CC993C6AEFD95D7EC721C6A3A0", hash_generated_field = "01630869675F1DA42810C4AF0E092889")

    private String mSubThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "013B63ACAA6366BEADD9080708AB0FB5", hash_generated_field = "CF559618A1D4E648B6B2F354F5258741")

    private String mPremises;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "29C6E2F3AB8D31B2C3BE92645A419B42", hash_generated_field = "C69EE2CA15E3AA7242875015CFA55C01")

    private String mPostalCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "F28ADBF1524A97CDC354A7ABA882BC81", hash_generated_field = "9C7911CE25730D113ABA8C07F7DE1F24")

    private String mCountryCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "CBAEF129D89ADC31EA2120243155BCD3", hash_generated_field = "4CCD8712180BD60CFDB41FE6E2DEDB0D")

    private String mCountryName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.870 -0400", hash_original_field = "F9F903C408E7A13A84941FB6656F8EFD", hash_generated_field = "9EF15EBC1351E9950D0EE5BCAD1038B0")

    private double mLatitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.871 -0400", hash_original_field = "7C3CBAEC265653C71D6DB9C159F9C831", hash_generated_field = "5D603DAFF57AB40C16D9A89FCAF92AF2")

    private double mLongitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.871 -0400", hash_original_field = "471874D7C9D518F9BA7E6BD4710C5328", hash_generated_field = "92513C87CE591BDB601C26AA959D3DE3")

    private boolean mHasLatitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.871 -0400", hash_original_field = "27A42338E7E0A24D070C5E815602253C", hash_generated_field = "4581B045B6697DC4EF5E7E35CB7E72AE")

    private boolean mHasLongitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.871 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "1D4D63140ABF8732CCB2AA5286B163C3")

    private String mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.871 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.871 -0400", hash_original_field = "7AC7A3C81EDFAF4AE16351926EDACBA4", hash_generated_field = "F67EBBE51D94FDD3154517E86441117D")

    private Bundle mExtras = null;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.872 -0400", hash_original_method = "8C8D8A006008D0E9588030A46EE6B5B9", hash_generated_method = "8FD930FF34428F79FC4B7AEC5627420E")
    public  Address(Locale locale) {
        mLocale = locale;
        // ---------- Original Method ----------
        //mLocale = locale;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.873 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "6D987F2A4BEB3826B00F128FF6E24E9A")
    public Locale getLocale() {
Locale varD4470AF088C85BDC4D13A941A003DD34_39582234 =         mLocale;
        varD4470AF088C85BDC4D13A941A003DD34_39582234.addTaint(taint);
        return varD4470AF088C85BDC4D13A941A003DD34_39582234;
        // ---------- Original Method ----------
        //return mLocale;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.873 -0400", hash_original_method = "E1E6237F606789C7A5294059179DF025", hash_generated_method = "38ECDAEC818C6F2D7D9BC4B9392D1540")
    public int getMaxAddressLineIndex() {
        int var762CC270A4744104782379DEFC1AD876_965215953 = (mMaxAddressLineIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671537331 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671537331;
        // ---------- Original Method ----------
        //return mMaxAddressLineIndex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.874 -0400", hash_original_method = "D824FE2CFE40DB25058DC1465F2D4439", hash_generated_method = "30CBCE366C18F3430797EBF7B2764C48")
    public String getAddressLine(int index) {
        addTaint(index);
        if(index < 0)        
        {
            IllegalArgumentException var1F4FF4DE7EE82827B9658A9EA407E9B8_867128761 = new IllegalArgumentException("index = " + index + " < 0");
            var1F4FF4DE7EE82827B9658A9EA407E9B8_867128761.addTaint(taint);
            throw var1F4FF4DE7EE82827B9658A9EA407E9B8_867128761;
        } //End block
String var8F52A3584A08AAA3EC3C8E4490F64BF1_148325760 =         mAddressLines == null? null :  mAddressLines.get(index);
        var8F52A3584A08AAA3EC3C8E4490F64BF1_148325760.addTaint(taint);
        return var8F52A3584A08AAA3EC3C8E4490F64BF1_148325760;
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IllegalArgumentException("index = " + index + " < 0");
        //}
        //return mAddressLines == null? null :  mAddressLines.get(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.875 -0400", hash_original_method = "5C23144E8A22EAB5D8930884A1255DAC", hash_generated_method = "F54ECA42827EB9D430E1E81B7B61A1A3")
    public void setAddressLine(int index, String line) {
        addTaint(line.getTaint());
        if(index < 0)        
        {
            IllegalArgumentException var1F4FF4DE7EE82827B9658A9EA407E9B8_202281179 = new IllegalArgumentException("index = " + index + " < 0");
            var1F4FF4DE7EE82827B9658A9EA407E9B8_202281179.addTaint(taint);
            throw var1F4FF4DE7EE82827B9658A9EA407E9B8_202281179;
        } //End block
        if(mAddressLines == null)        
        {
            mAddressLines = new HashMap<Integer, String>();
        } //End block
        mAddressLines.put(index, line);
        if(line == null)        
        {
            mMaxAddressLineIndex = -1;
for(Integer i : mAddressLines.keySet())
            {
                mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, i);
            } //End block
        } //End block
        else
        {
            mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, index);
        } //End block
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IllegalArgumentException("index = " + index + " < 0");
        //}
        //if (mAddressLines == null) {
            //mAddressLines = new HashMap<Integer, String>();
        //}
        //mAddressLines.put(index, line);
        //if (line == null) {
            //mMaxAddressLineIndex = -1;
            //for (Integer i : mAddressLines.keySet()) {
                //mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, i);
            //}
        //} else {
            //mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, index);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.876 -0400", hash_original_method = "D108F727B4ED1E44A68F4DDDAA8864A4", hash_generated_method = "F6537CC35A59742995D00E639B11B860")
    public String getFeatureName() {
String varF7A5AFB4D1EE52961A7B38E15120ABDE_1290209964 =         mFeatureName;
        varF7A5AFB4D1EE52961A7B38E15120ABDE_1290209964.addTaint(taint);
        return varF7A5AFB4D1EE52961A7B38E15120ABDE_1290209964;
        // ---------- Original Method ----------
        //return mFeatureName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.877 -0400", hash_original_method = "49225B599976EB86160DDAF83CE5BC7F", hash_generated_method = "1D26184E4D899C0F02D8A649DE7F872A")
    public void setFeatureName(String featureName) {
        mFeatureName = featureName;
        // ---------- Original Method ----------
        //mFeatureName = featureName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.877 -0400", hash_original_method = "EDE4D65E7936029E84B8376D150F4DDE", hash_generated_method = "63A108233DD01AF203E7F4CAA5328AB9")
    public String getAdminArea() {
String var91E7EFC6A55EB1496E7047B6173BA618_970702781 =         mAdminArea;
        var91E7EFC6A55EB1496E7047B6173BA618_970702781.addTaint(taint);
        return var91E7EFC6A55EB1496E7047B6173BA618_970702781;
        // ---------- Original Method ----------
        //return mAdminArea;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.878 -0400", hash_original_method = "C8D449D9A4FBB2AF83806F488A8CAC1C", hash_generated_method = "40C7CFB20A367AD4F7EDC68C1A3AAE86")
    public void setAdminArea(String adminArea) {
        this.mAdminArea = adminArea;
        // ---------- Original Method ----------
        //this.mAdminArea = adminArea;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.878 -0400", hash_original_method = "84D73E83BF1D1209648491141222963A", hash_generated_method = "1E6EB7AE48B72AB5855672D8E95E8EE1")
    public String getSubAdminArea() {
String varA3DCCD1EC01210B6CF0EC83E90F79A22_1683276696 =         mSubAdminArea;
        varA3DCCD1EC01210B6CF0EC83E90F79A22_1683276696.addTaint(taint);
        return varA3DCCD1EC01210B6CF0EC83E90F79A22_1683276696;
        // ---------- Original Method ----------
        //return mSubAdminArea;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.879 -0400", hash_original_method = "4DF91F489D35ACCA2DC2AF8A5398BD9E", hash_generated_method = "10C6DC9E5F0955108CDE6840819AD482")
    public void setSubAdminArea(String subAdminArea) {
        this.mSubAdminArea = subAdminArea;
        // ---------- Original Method ----------
        //this.mSubAdminArea = subAdminArea;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.879 -0400", hash_original_method = "3743C626E0A5809CC359BBE60C0BEF8D", hash_generated_method = "2348E45B2E4BCB6763D0758DD9CDAA25")
    public String getLocality() {
String varB7B79BF2DA4FF4A6C180FBD5B661B23A_30252170 =         mLocality;
        varB7B79BF2DA4FF4A6C180FBD5B661B23A_30252170.addTaint(taint);
        return varB7B79BF2DA4FF4A6C180FBD5B661B23A_30252170;
        // ---------- Original Method ----------
        //return mLocality;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.880 -0400", hash_original_method = "E848A60937105A6FB0F90F11784FAFAB", hash_generated_method = "09FAEAEF3CAB423AAFFFED8A05988A88")
    public void setLocality(String locality) {
        mLocality = locality;
        // ---------- Original Method ----------
        //mLocality = locality;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.880 -0400", hash_original_method = "4565445A715D9E082E3330822780EE14", hash_generated_method = "E6A919B76E8239FB6322E48545A451AF")
    public String getSubLocality() {
String varF5741EE7521AF8C87706F872F400820D_426201000 =         mSubLocality;
        varF5741EE7521AF8C87706F872F400820D_426201000.addTaint(taint);
        return varF5741EE7521AF8C87706F872F400820D_426201000;
        // ---------- Original Method ----------
        //return mSubLocality;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.881 -0400", hash_original_method = "FBC28BB3F834CBCC388544379D8FF1EB", hash_generated_method = "88524407E6F13730692BB0EC0929F8BE")
    public void setSubLocality(String sublocality) {
        mSubLocality = sublocality;
        // ---------- Original Method ----------
        //mSubLocality = sublocality;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.881 -0400", hash_original_method = "1512262039F5521B933A04882815530C", hash_generated_method = "39242E79B635F8CD80BA02A52F656399")
    public String getThoroughfare() {
String var4A2F779844D3CAEF589AA39F1538A5F5_1961958909 =         mThoroughfare;
        var4A2F779844D3CAEF589AA39F1538A5F5_1961958909.addTaint(taint);
        return var4A2F779844D3CAEF589AA39F1538A5F5_1961958909;
        // ---------- Original Method ----------
        //return mThoroughfare;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.882 -0400", hash_original_method = "30509B10242C2769144E7C2C070721FD", hash_generated_method = "4924718659371C7461941D134860D04A")
    public void setThoroughfare(String thoroughfare) {
        this.mThoroughfare = thoroughfare;
        // ---------- Original Method ----------
        //this.mThoroughfare = thoroughfare;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.883 -0400", hash_original_method = "8EFF44F66BA44D813DFBCA9FC34B8EF5", hash_generated_method = "FCAC5CD92AC6E57CE69D0D26759CAE4E")
    public String getSubThoroughfare() {
String varE6F08835740F5BE05D61BBE5DA6AE0F8_234288504 =         mSubThoroughfare;
        varE6F08835740F5BE05D61BBE5DA6AE0F8_234288504.addTaint(taint);
        return varE6F08835740F5BE05D61BBE5DA6AE0F8_234288504;
        // ---------- Original Method ----------
        //return mSubThoroughfare;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.883 -0400", hash_original_method = "ED99ECE32AF3E65AA637AE926CEFB8FE", hash_generated_method = "58B1784B4A68782244F8452AC42B65F4")
    public void setSubThoroughfare(String subthoroughfare) {
        this.mSubThoroughfare = subthoroughfare;
        // ---------- Original Method ----------
        //this.mSubThoroughfare = subthoroughfare;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.884 -0400", hash_original_method = "C1BF40685BD6E248364BFB485F611555", hash_generated_method = "24AE146CB2F69E095C288052E7CEC1DC")
    public String getPremises() {
String var43932448830E6B96A882F87012E60811_94303504 =         mPremises;
        var43932448830E6B96A882F87012E60811_94303504.addTaint(taint);
        return var43932448830E6B96A882F87012E60811_94303504;
        // ---------- Original Method ----------
        //return mPremises;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.884 -0400", hash_original_method = "C9E9B1B8FA21E47AD4B139D64075E36A", hash_generated_method = "2B0B3FE07B8F5EE8C21070FE09BD962A")
    public void setPremises(String premises) {
        mPremises = premises;
        // ---------- Original Method ----------
        //mPremises = premises;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.885 -0400", hash_original_method = "9B5379769D21EFABDDB2785674C4DE4D", hash_generated_method = "4A9CB2C3731307F0D9B9A7CB36AD2172")
    public String getPostalCode() {
String varB177689E8C39CC402F4DF29F8A634D1E_494822673 =         mPostalCode;
        varB177689E8C39CC402F4DF29F8A634D1E_494822673.addTaint(taint);
        return varB177689E8C39CC402F4DF29F8A634D1E_494822673;
        // ---------- Original Method ----------
        //return mPostalCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.885 -0400", hash_original_method = "21CF31250DB9EF4FD9B8F171A3FE8B16", hash_generated_method = "E8E05B86D22C4A96EB105D8DBDEA25E7")
    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
        // ---------- Original Method ----------
        //mPostalCode = postalCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.886 -0400", hash_original_method = "E8D66F74FB4E1AF79CCB258931950FBE", hash_generated_method = "997FEFBC9FC0FC1980FF8FE2F7DBF1ED")
    public String getCountryCode() {
String varF8C591CBE522BD074E2255B8C3D81562_469692489 =         mCountryCode;
        varF8C591CBE522BD074E2255B8C3D81562_469692489.addTaint(taint);
        return varF8C591CBE522BD074E2255B8C3D81562_469692489;
        // ---------- Original Method ----------
        //return mCountryCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.886 -0400", hash_original_method = "DD5F97427C040B47F9123BA4F8DC93A2", hash_generated_method = "10F64B2D94AD623FDE15BD4D4699264C")
    public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
        // ---------- Original Method ----------
        //mCountryCode = countryCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.887 -0400", hash_original_method = "A82A5DCEE67796EF014C1F79656EFD25", hash_generated_method = "51E8A7974B1DEF1D0725656DB8BB5D68")
    public String getCountryName() {
String var2458595564A156466F479EBF50DC6884_1427306653 =         mCountryName;
        var2458595564A156466F479EBF50DC6884_1427306653.addTaint(taint);
        return var2458595564A156466F479EBF50DC6884_1427306653;
        // ---------- Original Method ----------
        //return mCountryName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.887 -0400", hash_original_method = "F7767E8D2EF25B1D1399497900992B14", hash_generated_method = "5F6A05EA0BAE2D22145C166C84A758DE")
    public void setCountryName(String countryName) {
        mCountryName = countryName;
        // ---------- Original Method ----------
        //mCountryName = countryName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.887 -0400", hash_original_method = "AB4D7FB4B745E9B023209032D37DF18F", hash_generated_method = "5561E8B653EB25BBFD8AD521F1B1FCC7")
    public boolean hasLatitude() {
        boolean var8A2123D57155A8AC9188865299099687_830827517 = (mHasLatitude);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291285481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291285481;
        // ---------- Original Method ----------
        //return mHasLatitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.887 -0400", hash_original_method = "74A963FE4AC8482F316E1B3E19ABA2D8", hash_generated_method = "BE2B0DDF4F531185086F491465E2242C")
    public double getLatitude() {
        if(mHasLatitude)        
        {
            double varF9F903C408E7A13A84941FB6656F8EFD_1903421389 = (mLatitude);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1560569135 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1560569135;
        } //End block
        else
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_444376816 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_444376816.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_444376816;
        } //End block
        // ---------- Original Method ----------
        //if (mHasLatitude) {
            //return mLatitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.888 -0400", hash_original_method = "E7EB84DA300898C528161A7CBF9FB7F9", hash_generated_method = "4ABFA5E2D8A978A1DF296206A6637849")
    public void setLatitude(double latitude) {
        mLatitude = latitude;
        mHasLatitude = true;
        // ---------- Original Method ----------
        //mLatitude = latitude;
        //mHasLatitude = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.888 -0400", hash_original_method = "4BCAF53DCD4CF7BB362561C1B9A79F13", hash_generated_method = "A8538AF0D6CB924252483A3546F1E7D2")
    public void clearLatitude() {
        mHasLatitude = false;
        // ---------- Original Method ----------
        //mHasLatitude = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.889 -0400", hash_original_method = "44F26BDA1ACBDD9862A3D8D8968B3507", hash_generated_method = "686F8CD53A7EDECAE0FAD202CAE2429D")
    public boolean hasLongitude() {
        boolean varBE8E4545DFD36BA893A70116C905DDC4_1233404165 = (mHasLongitude);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026775063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026775063;
        // ---------- Original Method ----------
        //return mHasLongitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.889 -0400", hash_original_method = "90E38F72A8C0EDFD5CFCC6EABD3BD432", hash_generated_method = "2965F048E97C234973BB82BF7F08CA10")
    public double getLongitude() {
        if(mHasLongitude)        
        {
            double var7C3CBAEC265653C71D6DB9C159F9C831_1451633070 = (mLongitude);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1850124523 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1850124523;
        } //End block
        else
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1829256539 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1829256539.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1829256539;
        } //End block
        // ---------- Original Method ----------
        //if (mHasLongitude) {
            //return mLongitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.889 -0400", hash_original_method = "C4D556739F3557653F6C8D616289AA29", hash_generated_method = "C5F4A24BBD737E53F906B0B4B1241A26")
    public void setLongitude(double longitude) {
        mLongitude = longitude;
        mHasLongitude = true;
        // ---------- Original Method ----------
        //mLongitude = longitude;
        //mHasLongitude = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.889 -0400", hash_original_method = "D5786F30716C18CE0A0AB74556D12A22", hash_generated_method = "72D8B7051AF8F5D8AF738740565981D0")
    public void clearLongitude() {
        mHasLongitude = false;
        // ---------- Original Method ----------
        //mHasLongitude = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.890 -0400", hash_original_method = "EB9EE516F482EB01602422E9FA56CA5C", hash_generated_method = "9B8342A127B20ED72363B46834D7E4C1")
    public String getPhone() {
String var07C8F1FD81103AEB314B290597870F83_646546581 =         mPhone;
        var07C8F1FD81103AEB314B290597870F83_646546581.addTaint(taint);
        return var07C8F1FD81103AEB314B290597870F83_646546581;
        // ---------- Original Method ----------
        //return mPhone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.890 -0400", hash_original_method = "5023DDC820B0F6BE06303CFCE3A71EDF", hash_generated_method = "DE0BAA2F1475B12EBE7D57B9B6E7D336")
    public void setPhone(String phone) {
        mPhone = phone;
        // ---------- Original Method ----------
        //mPhone = phone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.890 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "9C8EACEF955AB6BCA9D56176C029151A")
    public String getUrl() {
String varF1E91891753CD7C4305CCDECB60B9DDF_1668830816 =         mUrl;
        varF1E91891753CD7C4305CCDECB60B9DDF_1668830816.addTaint(taint);
        return varF1E91891753CD7C4305CCDECB60B9DDF_1668830816;
        // ---------- Original Method ----------
        //return mUrl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.890 -0400", hash_original_method = "A94A57C3BD4A508E7FC3D69DE1774EEC", hash_generated_method = "4D2F926217B6FA5CE5A195400B3E7118")
    public void setUrl(String Url) {
        mUrl = Url;
        // ---------- Original Method ----------
        //mUrl = Url;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.890 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "805B95C02D696D096E6B94CA143147D6")
    public Bundle getExtras() {
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_694902151 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_694902151.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_694902151;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.891 -0400", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "9B56A595B86963DFD04070AE7AE28FC1")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? null : new Bundle(extras);
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? null : new Bundle(extras);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.892 -0400", hash_original_method = "F2CDEB7D6ECCED8CC4C514EA700B26BB", hash_generated_method = "44A04A7E97AFD6ACB1A86725C5035A98")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address[addressLines=[");
for(int i = 0;i <= mMaxAddressLineIndex;i++)
        {
            if(i > 0)            
            {
                sb.append(',');
            } //End block
            sb.append(i);
            sb.append(':');
            String line = mAddressLines.get(i);
            if(line == null)            
            {
                sb.append("null");
            } //End block
            else
            {
                sb.append('\"');
                sb.append(line);
                sb.append('\"');
            } //End block
        } //End block
        sb.append(']');
        sb.append(",feature=");
        sb.append(mFeatureName);
        sb.append(",admin=");
        sb.append(mAdminArea);
        sb.append(",sub-admin=");
        sb.append(mSubAdminArea);
        sb.append(",locality=");
        sb.append(mLocality);
        sb.append(",thoroughfare=");
        sb.append(mThoroughfare);
        sb.append(",postalCode=");
        sb.append(mPostalCode);
        sb.append(",countryCode=");
        sb.append(mCountryCode);
        sb.append(",countryName=");
        sb.append(mCountryName);
        sb.append(",hasLatitude=");
        sb.append(mHasLatitude);
        sb.append(",latitude=");
        sb.append(mLatitude);
        sb.append(",hasLongitude=");
        sb.append(mHasLongitude);
        sb.append(",longitude=");
        sb.append(mLongitude);
        sb.append(",phone=");
        sb.append(mPhone);
        sb.append(",url=");
        sb.append(mUrl);
        sb.append(",extras=");
        sb.append(mExtras);
        sb.append(']');
String var2460B846747F8B22185AD8BE722266A5_736558689 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_736558689.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_736558689;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.892 -0400", hash_original_method = "2C347F4A4F86FFA77F246DC5FD21E5D6", hash_generated_method = "3924FBC40FAE4B2E024EABAE4CF43338")
    public int describeContents() {
        int var9C9C6B08C78648CC48F8AF69F3FE8C32_1902681726 = ((mExtras != null) ? mExtras.describeContents() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737460740 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737460740;
        // ---------- Original Method ----------
        //return (mExtras != null) ? mExtras.describeContents() : 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.893 -0400", hash_original_method = "609BCF0D5B324DA0FE8A594DDD7486F2", hash_generated_method = "224F627DBC4A775676A43924958A5EC6")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeString(mLocale.getLanguage());
        parcel.writeString(mLocale.getCountry());
        if(mAddressLines == null)        
        {
            parcel.writeInt(0);
        } //End block
        else
        {
            Set<Map.Entry<Integer, String>> entries = mAddressLines.entrySet();
            parcel.writeInt(entries.size());
for(Map.Entry<Integer, String> e : entries)
            {
                parcel.writeInt(e.getKey());
                parcel.writeString(e.getValue());
            } //End block
        } //End block
        parcel.writeString(mFeatureName);
        parcel.writeString(mAdminArea);
        parcel.writeString(mSubAdminArea);
        parcel.writeString(mLocality);
        parcel.writeString(mSubLocality);
        parcel.writeString(mThoroughfare);
        parcel.writeString(mSubThoroughfare);
        parcel.writeString(mPremises);
        parcel.writeString(mPostalCode);
        parcel.writeString(mCountryCode);
        parcel.writeString(mCountryName);
        parcel.writeInt(mHasLatitude ? 1 : 0);
        if(mHasLatitude)        
        {
            parcel.writeDouble(mLatitude);
        } //End block
        parcel.writeInt(mHasLongitude ? 1 : 0);
        if(mHasLongitude)        
        {
            parcel.writeDouble(mLongitude);
        } //End block
        parcel.writeString(mPhone);
        parcel.writeString(mUrl);
        parcel.writeBundle(mExtras);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.894 -0400", hash_original_field = "34AF13FB5BC8BAFBEC9B029562C77C94", hash_generated_field = "B4FB2F104B558E1CA23D02F180C08BB7")

    public static final Parcelable.Creator<Address> CREATOR =
        new Parcelable.Creator<Address>() {
        public Address createFromParcel(Parcel in) {
            String language = in.readString();
            String country = in.readString();
            Locale locale = country.length() > 0 ?
                new Locale(language, country) :
                new Locale(language);
            Address a = new Address(locale);

            int N = in.readInt();
            if (N > 0) {
                a.mAddressLines = new HashMap<Integer, String>(N);
                for (int i = 0; i < N; i++) {
                    int index = in.readInt();
                    String line = in.readString();
                    a.mAddressLines.put(index, line);
                    a.mMaxAddressLineIndex =
                        Math.max(a.mMaxAddressLineIndex, index);
                }
            } else {
                a.mAddressLines = null;
                a.mMaxAddressLineIndex = -1;
            }
            a.mFeatureName = in.readString();
            a.mAdminArea = in.readString();
            a.mSubAdminArea = in.readString();
            a.mLocality = in.readString();
            a.mSubLocality = in.readString();
            a.mThoroughfare = in.readString();
            a.mSubThoroughfare = in.readString();
            a.mPremises = in.readString();
            a.mPostalCode = in.readString();
            a.mCountryCode = in.readString();
            a.mCountryName = in.readString();
            a.mHasLatitude = in.readInt() == 0 ? false : true;
            if (a.mHasLatitude) {
                a.mLatitude = in.readDouble();
            }
            a.mHasLongitude = in.readInt() == 0 ? false : true;
            if (a.mHasLongitude) {
                a.mLongitude = in.readDouble();
            }
            a.mPhone = in.readString();
            a.mUrl = in.readString();
            a.mExtras = in.readBundle();
            return a;
        }

        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
    // orphaned legacy method
    public Address createFromParcel(Parcel in) {
            String language = in.readString();
            String country = in.readString();
            Locale locale = country.length() > 0 ?
                new Locale(language, country) :
                new Locale(language);
            Address a = new Address(locale);

            int N = in.readInt();
            if (N > 0) {
                a.mAddressLines = new HashMap<Integer, String>(N);
                for (int i = 0; i < N; i++) {
                    int index = in.readInt();
                    String line = in.readString();
                    a.mAddressLines.put(index, line);
                    a.mMaxAddressLineIndex =
                        Math.max(a.mMaxAddressLineIndex, index);
                }
            } else {
                a.mAddressLines = null;
                a.mMaxAddressLineIndex = -1;
            }
            a.mFeatureName = in.readString();
            a.mAdminArea = in.readString();
            a.mSubAdminArea = in.readString();
            a.mLocality = in.readString();
            a.mSubLocality = in.readString();
            a.mThoroughfare = in.readString();
            a.mSubThoroughfare = in.readString();
            a.mPremises = in.readString();
            a.mPostalCode = in.readString();
            a.mCountryCode = in.readString();
            a.mCountryName = in.readString();
            a.mHasLatitude = in.readInt() == 0 ? false : true;
            if (a.mHasLatitude) {
                a.mLatitude = in.readDouble();
            }
            a.mHasLongitude = in.readInt() == 0 ? false : true;
            if (a.mHasLongitude) {
                a.mLongitude = in.readDouble();
            }
            a.mPhone = in.readString();
            a.mUrl = in.readString();
            a.mExtras = in.readBundle();
            return a;
        }
    
    // orphaned legacy method
    public Address[] newArray(int size) {
            return new Address[size];
        }
    
}

