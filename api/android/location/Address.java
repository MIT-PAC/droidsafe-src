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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.569 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.569 -0400", hash_original_field = "8937E233714B037ECE45D23AA79BE19E", hash_generated_field = "885B87E22D2EF7CC7C342A420B72EF3E")

    private String mFeatureName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.569 -0400", hash_original_field = "36BE4E7B894E1FE49E224E15F4F09E30", hash_generated_field = "267F6B9285B603FF477C20775D29AA60")

    private HashMap<Integer, String> mAddressLines;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.569 -0400", hash_original_field = "5B6E8EDDE261396A90E6DE4AA7DED93C", hash_generated_field = "61A068F86D173398FFF3F86ABD61DF78")

    private int mMaxAddressLineIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "AE9759C687BF60F269594A7976FFE5FE", hash_generated_field = "9E4BAF383B0085BDBE33EFF069DD6A8A")

    private String mAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "8D06393B99CFCE4BBDB353A8B6ED85AA", hash_generated_field = "5914F416D26BAEA83D36B07CC8123017")

    private String mSubAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "5AD01704F5F406F72AF7849956EE8F0F", hash_generated_field = "B27EC088B31F0C4F3FC5FD8261A96829")

    private String mLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "D392069C4E4C8DE4BDCF9B1203629260", hash_generated_field = "54AA36C926071A6092BD97F68F4B1C69")

    private String mSubLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "AEFA91646A44DC198B507332D2E5632B", hash_generated_field = "572923B079894AE27884BBD950702954")

    private String mThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "AB0822CC993C6AEFD95D7EC721C6A3A0", hash_generated_field = "01630869675F1DA42810C4AF0E092889")

    private String mSubThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "013B63ACAA6366BEADD9080708AB0FB5", hash_generated_field = "CF559618A1D4E648B6B2F354F5258741")

    private String mPremises;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "29C6E2F3AB8D31B2C3BE92645A419B42", hash_generated_field = "C69EE2CA15E3AA7242875015CFA55C01")

    private String mPostalCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "F28ADBF1524A97CDC354A7ABA882BC81", hash_generated_field = "9C7911CE25730D113ABA8C07F7DE1F24")

    private String mCountryCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "CBAEF129D89ADC31EA2120243155BCD3", hash_generated_field = "4CCD8712180BD60CFDB41FE6E2DEDB0D")

    private String mCountryName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "F9F903C408E7A13A84941FB6656F8EFD", hash_generated_field = "9EF15EBC1351E9950D0EE5BCAD1038B0")

    private double mLatitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "7C3CBAEC265653C71D6DB9C159F9C831", hash_generated_field = "5D603DAFF57AB40C16D9A89FCAF92AF2")

    private double mLongitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "471874D7C9D518F9BA7E6BD4710C5328", hash_generated_field = "92513C87CE591BDB601C26AA959D3DE3")

    private boolean mHasLatitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "27A42338E7E0A24D070C5E815602253C", hash_generated_field = "4581B045B6697DC4EF5E7E35CB7E72AE")

    private boolean mHasLongitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.570 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "1D4D63140ABF8732CCB2AA5286B163C3")

    private String mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.571 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.571 -0400", hash_original_field = "7AC7A3C81EDFAF4AE16351926EDACBA4", hash_generated_field = "F67EBBE51D94FDD3154517E86441117D")

    private Bundle mExtras = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.571 -0400", hash_original_method = "8C8D8A006008D0E9588030A46EE6B5B9", hash_generated_method = "8FD930FF34428F79FC4B7AEC5627420E")
    public  Address(Locale locale) {
        mLocale = locale;
        // ---------- Original Method ----------
        //mLocale = locale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.571 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "10EF5FAE7CA3FE5AB493A65825CACCF3")
    public Locale getLocale() {
Locale varD4470AF088C85BDC4D13A941A003DD34_1586046080 =         mLocale;
        varD4470AF088C85BDC4D13A941A003DD34_1586046080.addTaint(taint);
        return varD4470AF088C85BDC4D13A941A003DD34_1586046080;
        // ---------- Original Method ----------
        //return mLocale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.571 -0400", hash_original_method = "E1E6237F606789C7A5294059179DF025", hash_generated_method = "C44B7DAE44F0D81B38C3BE2A260DB423")
    public int getMaxAddressLineIndex() {
        int var762CC270A4744104782379DEFC1AD876_331337944 = (mMaxAddressLineIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1033409500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1033409500;
        // ---------- Original Method ----------
        //return mMaxAddressLineIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.572 -0400", hash_original_method = "D824FE2CFE40DB25058DC1465F2D4439", hash_generated_method = "9DD70E957D2A1107CE4222BC4649C8DD")
    public String getAddressLine(int index) {
        addTaint(index);
    if(index < 0)        
        {
            IllegalArgumentException var1F4FF4DE7EE82827B9658A9EA407E9B8_119246896 = new IllegalArgumentException("index = " + index + " < 0");
            var1F4FF4DE7EE82827B9658A9EA407E9B8_119246896.addTaint(taint);
            throw var1F4FF4DE7EE82827B9658A9EA407E9B8_119246896;
        } //End block
String var8F52A3584A08AAA3EC3C8E4490F64BF1_951804538 =         mAddressLines == null? null :  mAddressLines.get(index);
        var8F52A3584A08AAA3EC3C8E4490F64BF1_951804538.addTaint(taint);
        return var8F52A3584A08AAA3EC3C8E4490F64BF1_951804538;
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IllegalArgumentException("index = " + index + " < 0");
        //}
        //return mAddressLines == null? null :  mAddressLines.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.573 -0400", hash_original_method = "5C23144E8A22EAB5D8930884A1255DAC", hash_generated_method = "7830F275D258C3E2D907AE80F39D6424")
    public void setAddressLine(int index, String line) {
        addTaint(line.getTaint());
    if(index < 0)        
        {
            IllegalArgumentException var1F4FF4DE7EE82827B9658A9EA407E9B8_1956502501 = new IllegalArgumentException("index = " + index + " < 0");
            var1F4FF4DE7EE82827B9658A9EA407E9B8_1956502501.addTaint(taint);
            throw var1F4FF4DE7EE82827B9658A9EA407E9B8_1956502501;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.573 -0400", hash_original_method = "D108F727B4ED1E44A68F4DDDAA8864A4", hash_generated_method = "2533D409DB355BE86BD9F38E41EB3A0A")
    public String getFeatureName() {
String varF7A5AFB4D1EE52961A7B38E15120ABDE_1290554332 =         mFeatureName;
        varF7A5AFB4D1EE52961A7B38E15120ABDE_1290554332.addTaint(taint);
        return varF7A5AFB4D1EE52961A7B38E15120ABDE_1290554332;
        // ---------- Original Method ----------
        //return mFeatureName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.574 -0400", hash_original_method = "49225B599976EB86160DDAF83CE5BC7F", hash_generated_method = "1D26184E4D899C0F02D8A649DE7F872A")
    public void setFeatureName(String featureName) {
        mFeatureName = featureName;
        // ---------- Original Method ----------
        //mFeatureName = featureName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.574 -0400", hash_original_method = "EDE4D65E7936029E84B8376D150F4DDE", hash_generated_method = "21B7D6A85C705288277AE7C2E09CF462")
    public String getAdminArea() {
String var91E7EFC6A55EB1496E7047B6173BA618_242537384 =         mAdminArea;
        var91E7EFC6A55EB1496E7047B6173BA618_242537384.addTaint(taint);
        return var91E7EFC6A55EB1496E7047B6173BA618_242537384;
        // ---------- Original Method ----------
        //return mAdminArea;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.575 -0400", hash_original_method = "C8D449D9A4FBB2AF83806F488A8CAC1C", hash_generated_method = "40C7CFB20A367AD4F7EDC68C1A3AAE86")
    public void setAdminArea(String adminArea) {
        this.mAdminArea = adminArea;
        // ---------- Original Method ----------
        //this.mAdminArea = adminArea;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.575 -0400", hash_original_method = "84D73E83BF1D1209648491141222963A", hash_generated_method = "9FD5E24A57D1F831C33B6F7918DDC65A")
    public String getSubAdminArea() {
String varA3DCCD1EC01210B6CF0EC83E90F79A22_619812418 =         mSubAdminArea;
        varA3DCCD1EC01210B6CF0EC83E90F79A22_619812418.addTaint(taint);
        return varA3DCCD1EC01210B6CF0EC83E90F79A22_619812418;
        // ---------- Original Method ----------
        //return mSubAdminArea;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.575 -0400", hash_original_method = "4DF91F489D35ACCA2DC2AF8A5398BD9E", hash_generated_method = "10C6DC9E5F0955108CDE6840819AD482")
    public void setSubAdminArea(String subAdminArea) {
        this.mSubAdminArea = subAdminArea;
        // ---------- Original Method ----------
        //this.mSubAdminArea = subAdminArea;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.575 -0400", hash_original_method = "3743C626E0A5809CC359BBE60C0BEF8D", hash_generated_method = "89B7FA4DEDC6B1B122B91F75EEF060DB")
    public String getLocality() {
String varB7B79BF2DA4FF4A6C180FBD5B661B23A_194578714 =         mLocality;
        varB7B79BF2DA4FF4A6C180FBD5B661B23A_194578714.addTaint(taint);
        return varB7B79BF2DA4FF4A6C180FBD5B661B23A_194578714;
        // ---------- Original Method ----------
        //return mLocality;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.576 -0400", hash_original_method = "E848A60937105A6FB0F90F11784FAFAB", hash_generated_method = "09FAEAEF3CAB423AAFFFED8A05988A88")
    public void setLocality(String locality) {
        mLocality = locality;
        // ---------- Original Method ----------
        //mLocality = locality;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.576 -0400", hash_original_method = "4565445A715D9E082E3330822780EE14", hash_generated_method = "A974D417783E35E5758BB177994A54A3")
    public String getSubLocality() {
String varF5741EE7521AF8C87706F872F400820D_885609280 =         mSubLocality;
        varF5741EE7521AF8C87706F872F400820D_885609280.addTaint(taint);
        return varF5741EE7521AF8C87706F872F400820D_885609280;
        // ---------- Original Method ----------
        //return mSubLocality;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.576 -0400", hash_original_method = "FBC28BB3F834CBCC388544379D8FF1EB", hash_generated_method = "88524407E6F13730692BB0EC0929F8BE")
    public void setSubLocality(String sublocality) {
        mSubLocality = sublocality;
        // ---------- Original Method ----------
        //mSubLocality = sublocality;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.577 -0400", hash_original_method = "1512262039F5521B933A04882815530C", hash_generated_method = "9AF3228AD47A5151B2C37FA0A6178304")
    public String getThoroughfare() {
String var4A2F779844D3CAEF589AA39F1538A5F5_875401863 =         mThoroughfare;
        var4A2F779844D3CAEF589AA39F1538A5F5_875401863.addTaint(taint);
        return var4A2F779844D3CAEF589AA39F1538A5F5_875401863;
        // ---------- Original Method ----------
        //return mThoroughfare;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.577 -0400", hash_original_method = "30509B10242C2769144E7C2C070721FD", hash_generated_method = "4924718659371C7461941D134860D04A")
    public void setThoroughfare(String thoroughfare) {
        this.mThoroughfare = thoroughfare;
        // ---------- Original Method ----------
        //this.mThoroughfare = thoroughfare;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.577 -0400", hash_original_method = "8EFF44F66BA44D813DFBCA9FC34B8EF5", hash_generated_method = "5774F2E1B60245857C9C8C2BBF67D4E6")
    public String getSubThoroughfare() {
String varE6F08835740F5BE05D61BBE5DA6AE0F8_884831117 =         mSubThoroughfare;
        varE6F08835740F5BE05D61BBE5DA6AE0F8_884831117.addTaint(taint);
        return varE6F08835740F5BE05D61BBE5DA6AE0F8_884831117;
        // ---------- Original Method ----------
        //return mSubThoroughfare;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.578 -0400", hash_original_method = "ED99ECE32AF3E65AA637AE926CEFB8FE", hash_generated_method = "58B1784B4A68782244F8452AC42B65F4")
    public void setSubThoroughfare(String subthoroughfare) {
        this.mSubThoroughfare = subthoroughfare;
        // ---------- Original Method ----------
        //this.mSubThoroughfare = subthoroughfare;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.578 -0400", hash_original_method = "C1BF40685BD6E248364BFB485F611555", hash_generated_method = "161A97C04282D4F07F207E27FA728FC7")
    public String getPremises() {
String var43932448830E6B96A882F87012E60811_45320546 =         mPremises;
        var43932448830E6B96A882F87012E60811_45320546.addTaint(taint);
        return var43932448830E6B96A882F87012E60811_45320546;
        // ---------- Original Method ----------
        //return mPremises;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.578 -0400", hash_original_method = "C9E9B1B8FA21E47AD4B139D64075E36A", hash_generated_method = "2B0B3FE07B8F5EE8C21070FE09BD962A")
    public void setPremises(String premises) {
        mPremises = premises;
        // ---------- Original Method ----------
        //mPremises = premises;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.578 -0400", hash_original_method = "9B5379769D21EFABDDB2785674C4DE4D", hash_generated_method = "4C81ECC637D8378EBE87C55198C6F598")
    public String getPostalCode() {
String varB177689E8C39CC402F4DF29F8A634D1E_37757682 =         mPostalCode;
        varB177689E8C39CC402F4DF29F8A634D1E_37757682.addTaint(taint);
        return varB177689E8C39CC402F4DF29F8A634D1E_37757682;
        // ---------- Original Method ----------
        //return mPostalCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.579 -0400", hash_original_method = "21CF31250DB9EF4FD9B8F171A3FE8B16", hash_generated_method = "E8E05B86D22C4A96EB105D8DBDEA25E7")
    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
        // ---------- Original Method ----------
        //mPostalCode = postalCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.579 -0400", hash_original_method = "E8D66F74FB4E1AF79CCB258931950FBE", hash_generated_method = "1267812F50BB3F6E824940D4592FC271")
    public String getCountryCode() {
String varF8C591CBE522BD074E2255B8C3D81562_66985197 =         mCountryCode;
        varF8C591CBE522BD074E2255B8C3D81562_66985197.addTaint(taint);
        return varF8C591CBE522BD074E2255B8C3D81562_66985197;
        // ---------- Original Method ----------
        //return mCountryCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.579 -0400", hash_original_method = "DD5F97427C040B47F9123BA4F8DC93A2", hash_generated_method = "10F64B2D94AD623FDE15BD4D4699264C")
    public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
        // ---------- Original Method ----------
        //mCountryCode = countryCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.580 -0400", hash_original_method = "A82A5DCEE67796EF014C1F79656EFD25", hash_generated_method = "2539FEA4B6AA3A33AE915250BBBBE89F")
    public String getCountryName() {
String var2458595564A156466F479EBF50DC6884_842555643 =         mCountryName;
        var2458595564A156466F479EBF50DC6884_842555643.addTaint(taint);
        return var2458595564A156466F479EBF50DC6884_842555643;
        // ---------- Original Method ----------
        //return mCountryName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.580 -0400", hash_original_method = "F7767E8D2EF25B1D1399497900992B14", hash_generated_method = "5F6A05EA0BAE2D22145C166C84A758DE")
    public void setCountryName(String countryName) {
        mCountryName = countryName;
        // ---------- Original Method ----------
        //mCountryName = countryName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.580 -0400", hash_original_method = "AB4D7FB4B745E9B023209032D37DF18F", hash_generated_method = "1C2D90AE7C43DB867D0A265C9B6B9913")
    public boolean hasLatitude() {
        boolean var8A2123D57155A8AC9188865299099687_856548317 = (mHasLatitude);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25163850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25163850;
        // ---------- Original Method ----------
        //return mHasLatitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.581 -0400", hash_original_method = "74A963FE4AC8482F316E1B3E19ABA2D8", hash_generated_method = "1EE8D30436E328DA36EA6C61D6182365")
    public double getLatitude() {
    if(mHasLatitude)        
        {
            double varF9F903C408E7A13A84941FB6656F8EFD_342033588 = (mLatitude);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_627944117 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_627944117;
        } //End block
        else
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_690904522 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_690904522.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_690904522;
        } //End block
        // ---------- Original Method ----------
        //if (mHasLatitude) {
            //return mLatitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.581 -0400", hash_original_method = "E7EB84DA300898C528161A7CBF9FB7F9", hash_generated_method = "4ABFA5E2D8A978A1DF296206A6637849")
    public void setLatitude(double latitude) {
        mLatitude = latitude;
        mHasLatitude = true;
        // ---------- Original Method ----------
        //mLatitude = latitude;
        //mHasLatitude = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.581 -0400", hash_original_method = "4BCAF53DCD4CF7BB362561C1B9A79F13", hash_generated_method = "A8538AF0D6CB924252483A3546F1E7D2")
    public void clearLatitude() {
        mHasLatitude = false;
        // ---------- Original Method ----------
        //mHasLatitude = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.582 -0400", hash_original_method = "44F26BDA1ACBDD9862A3D8D8968B3507", hash_generated_method = "D52219E979EDD1FB277B541976648E0B")
    public boolean hasLongitude() {
        boolean varBE8E4545DFD36BA893A70116C905DDC4_1096275823 = (mHasLongitude);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89843448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_89843448;
        // ---------- Original Method ----------
        //return mHasLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.582 -0400", hash_original_method = "90E38F72A8C0EDFD5CFCC6EABD3BD432", hash_generated_method = "4501EBB1D8F3D39BFFD4A3C600E11353")
    public double getLongitude() {
    if(mHasLongitude)        
        {
            double var7C3CBAEC265653C71D6DB9C159F9C831_777365227 = (mLongitude);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_797973929 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_797973929;
        } //End block
        else
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1295075615 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1295075615.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1295075615;
        } //End block
        // ---------- Original Method ----------
        //if (mHasLongitude) {
            //return mLongitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.582 -0400", hash_original_method = "C4D556739F3557653F6C8D616289AA29", hash_generated_method = "C5F4A24BBD737E53F906B0B4B1241A26")
    public void setLongitude(double longitude) {
        mLongitude = longitude;
        mHasLongitude = true;
        // ---------- Original Method ----------
        //mLongitude = longitude;
        //mHasLongitude = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.583 -0400", hash_original_method = "D5786F30716C18CE0A0AB74556D12A22", hash_generated_method = "72D8B7051AF8F5D8AF738740565981D0")
    public void clearLongitude() {
        mHasLongitude = false;
        // ---------- Original Method ----------
        //mHasLongitude = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.583 -0400", hash_original_method = "EB9EE516F482EB01602422E9FA56CA5C", hash_generated_method = "9BC53B0E0342E05B61343CFA7C4F3182")
    public String getPhone() {
String var07C8F1FD81103AEB314B290597870F83_969555824 =         mPhone;
        var07C8F1FD81103AEB314B290597870F83_969555824.addTaint(taint);
        return var07C8F1FD81103AEB314B290597870F83_969555824;
        // ---------- Original Method ----------
        //return mPhone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.583 -0400", hash_original_method = "5023DDC820B0F6BE06303CFCE3A71EDF", hash_generated_method = "DE0BAA2F1475B12EBE7D57B9B6E7D336")
    public void setPhone(String phone) {
        mPhone = phone;
        // ---------- Original Method ----------
        //mPhone = phone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.584 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "53BA0CBAD2052BCE1CE12AF53BFA5456")
    public String getUrl() {
String varF1E91891753CD7C4305CCDECB60B9DDF_2026083837 =         mUrl;
        varF1E91891753CD7C4305CCDECB60B9DDF_2026083837.addTaint(taint);
        return varF1E91891753CD7C4305CCDECB60B9DDF_2026083837;
        // ---------- Original Method ----------
        //return mUrl;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.584 -0400", hash_original_method = "A94A57C3BD4A508E7FC3D69DE1774EEC", hash_generated_method = "4D2F926217B6FA5CE5A195400B3E7118")
    public void setUrl(String Url) {
        mUrl = Url;
        // ---------- Original Method ----------
        //mUrl = Url;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.584 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "B7E346AB2B09B51ABC4B648EB65D3E28")
    public Bundle getExtras() {
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_1528662815 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_1528662815.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_1528662815;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.585 -0400", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "9B56A595B86963DFD04070AE7AE28FC1")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? null : new Bundle(extras);
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? null : new Bundle(extras);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.585 -0400", hash_original_method = "F2CDEB7D6ECCED8CC4C514EA700B26BB", hash_generated_method = "B1E4C3A92B0B1F3038542DE0DDE1B771")
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
String var2460B846747F8B22185AD8BE722266A5_290559347 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_290559347.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_290559347;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.586 -0400", hash_original_method = "2C347F4A4F86FFA77F246DC5FD21E5D6", hash_generated_method = "CFDA3B515E712E55C1A0D47CEB72FD53")
    public int describeContents() {
        int var9C9C6B08C78648CC48F8AF69F3FE8C32_494209134 = ((mExtras != null) ? mExtras.describeContents() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489058798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489058798;
        // ---------- Original Method ----------
        //return (mExtras != null) ? mExtras.describeContents() : 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.608 -0400", hash_original_method = "609BCF0D5B324DA0FE8A594DDD7486F2", hash_generated_method = "224F627DBC4A775676A43924958A5EC6")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.609 -0400", hash_original_field = "34AF13FB5BC8BAFBEC9B029562C77C94", hash_generated_field = "B4FB2F104B558E1CA23D02F180C08BB7")

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

