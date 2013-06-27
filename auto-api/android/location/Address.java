package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.127 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.127 -0400", hash_original_field = "8937E233714B037ECE45D23AA79BE19E", hash_generated_field = "885B87E22D2EF7CC7C342A420B72EF3E")

    private String mFeatureName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.127 -0400", hash_original_field = "36BE4E7B894E1FE49E224E15F4F09E30", hash_generated_field = "267F6B9285B603FF477C20775D29AA60")

    private HashMap<Integer, String> mAddressLines;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.127 -0400", hash_original_field = "5B6E8EDDE261396A90E6DE4AA7DED93C", hash_generated_field = "61A068F86D173398FFF3F86ABD61DF78")

    private int mMaxAddressLineIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.127 -0400", hash_original_field = "AE9759C687BF60F269594A7976FFE5FE", hash_generated_field = "9E4BAF383B0085BDBE33EFF069DD6A8A")

    private String mAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.127 -0400", hash_original_field = "8D06393B99CFCE4BBDB353A8B6ED85AA", hash_generated_field = "5914F416D26BAEA83D36B07CC8123017")

    private String mSubAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.127 -0400", hash_original_field = "5AD01704F5F406F72AF7849956EE8F0F", hash_generated_field = "B27EC088B31F0C4F3FC5FD8261A96829")

    private String mLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.128 -0400", hash_original_field = "D392069C4E4C8DE4BDCF9B1203629260", hash_generated_field = "54AA36C926071A6092BD97F68F4B1C69")

    private String mSubLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.128 -0400", hash_original_field = "AEFA91646A44DC198B507332D2E5632B", hash_generated_field = "572923B079894AE27884BBD950702954")

    private String mThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.128 -0400", hash_original_field = "AB0822CC993C6AEFD95D7EC721C6A3A0", hash_generated_field = "01630869675F1DA42810C4AF0E092889")

    private String mSubThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.128 -0400", hash_original_field = "013B63ACAA6366BEADD9080708AB0FB5", hash_generated_field = "CF559618A1D4E648B6B2F354F5258741")

    private String mPremises;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.128 -0400", hash_original_field = "29C6E2F3AB8D31B2C3BE92645A419B42", hash_generated_field = "C69EE2CA15E3AA7242875015CFA55C01")

    private String mPostalCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.128 -0400", hash_original_field = "F28ADBF1524A97CDC354A7ABA882BC81", hash_generated_field = "9C7911CE25730D113ABA8C07F7DE1F24")

    private String mCountryCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.129 -0400", hash_original_field = "CBAEF129D89ADC31EA2120243155BCD3", hash_generated_field = "4CCD8712180BD60CFDB41FE6E2DEDB0D")

    private String mCountryName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.129 -0400", hash_original_field = "F9F903C408E7A13A84941FB6656F8EFD", hash_generated_field = "9EF15EBC1351E9950D0EE5BCAD1038B0")

    private double mLatitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.129 -0400", hash_original_field = "7C3CBAEC265653C71D6DB9C159F9C831", hash_generated_field = "5D603DAFF57AB40C16D9A89FCAF92AF2")

    private double mLongitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.129 -0400", hash_original_field = "471874D7C9D518F9BA7E6BD4710C5328", hash_generated_field = "92513C87CE591BDB601C26AA959D3DE3")

    private boolean mHasLatitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.129 -0400", hash_original_field = "27A42338E7E0A24D070C5E815602253C", hash_generated_field = "4581B045B6697DC4EF5E7E35CB7E72AE")

    private boolean mHasLongitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.129 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "1D4D63140ABF8732CCB2AA5286B163C3")

    private String mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.129 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.129 -0400", hash_original_field = "7AC7A3C81EDFAF4AE16351926EDACBA4", hash_generated_field = "F67EBBE51D94FDD3154517E86441117D")

    private Bundle mExtras = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.130 -0400", hash_original_method = "8C8D8A006008D0E9588030A46EE6B5B9", hash_generated_method = "8FD930FF34428F79FC4B7AEC5627420E")
    public  Address(Locale locale) {
        mLocale = locale;
        // ---------- Original Method ----------
        //mLocale = locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.136 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "1438F5BCEB355A1DF45CC22D4F5357CC")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_808539504 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_808539504 = mLocale;
        varB4EAC82CA7396A68D541C85D26508E83_808539504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_808539504;
        // ---------- Original Method ----------
        //return mLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.138 -0400", hash_original_method = "E1E6237F606789C7A5294059179DF025", hash_generated_method = "402DD32A4904178F55106646F55172FC")
    public int getMaxAddressLineIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650574661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650574661;
        // ---------- Original Method ----------
        //return mMaxAddressLineIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.145 -0400", hash_original_method = "D824FE2CFE40DB25058DC1465F2D4439", hash_generated_method = "10192A2C5809B5E6E75DE5D8A7327576")
    public String getAddressLine(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_856887642 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("index = " + index + " < 0");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_856887642 = mAddressLines == null? null :  mAddressLines.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_856887642.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_856887642;
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IllegalArgumentException("index = " + index + " < 0");
        //}
        //return mAddressLines == null? null :  mAddressLines.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.246 -0400", hash_original_method = "5C23144E8A22EAB5D8930884A1255DAC", hash_generated_method = "99334E634B3AC5BE4D75D040472C26FF")
    public void setAddressLine(int index, String line) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("index = " + index + " < 0");
        } //End block
        {
            mAddressLines = new HashMap<Integer, String>();
        } //End block
        mAddressLines.put(index, line);
        {
            mMaxAddressLineIndex = -1;
            {
                Iterator<Integer> var11CB2090D7C1AE4D5F6497E3F769BE3A_1340857859 = (mAddressLines.keySet()).iterator();
                var11CB2090D7C1AE4D5F6497E3F769BE3A_1340857859.hasNext();
                Integer i = var11CB2090D7C1AE4D5F6497E3F769BE3A_1340857859.next();
                {
                    mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, i);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, index);
        } //End block
        addTaint(line.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.264 -0400", hash_original_method = "D108F727B4ED1E44A68F4DDDAA8864A4", hash_generated_method = "D4F73FB87BA8D3F127CA2CD1E5B62195")
    public String getFeatureName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1239935113 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1239935113 = mFeatureName;
        varB4EAC82CA7396A68D541C85D26508E83_1239935113.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1239935113;
        // ---------- Original Method ----------
        //return mFeatureName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.265 -0400", hash_original_method = "49225B599976EB86160DDAF83CE5BC7F", hash_generated_method = "1D26184E4D899C0F02D8A649DE7F872A")
    public void setFeatureName(String featureName) {
        mFeatureName = featureName;
        // ---------- Original Method ----------
        //mFeatureName = featureName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.265 -0400", hash_original_method = "EDE4D65E7936029E84B8376D150F4DDE", hash_generated_method = "6D58D4A89ECAD99B22CC924CD1D3A461")
    public String getAdminArea() {
        String varB4EAC82CA7396A68D541C85D26508E83_1802831655 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1802831655 = mAdminArea;
        varB4EAC82CA7396A68D541C85D26508E83_1802831655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1802831655;
        // ---------- Original Method ----------
        //return mAdminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.266 -0400", hash_original_method = "C8D449D9A4FBB2AF83806F488A8CAC1C", hash_generated_method = "40C7CFB20A367AD4F7EDC68C1A3AAE86")
    public void setAdminArea(String adminArea) {
        this.mAdminArea = adminArea;
        // ---------- Original Method ----------
        //this.mAdminArea = adminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.270 -0400", hash_original_method = "84D73E83BF1D1209648491141222963A", hash_generated_method = "520945EAE26FFC3278301BE9947040E6")
    public String getSubAdminArea() {
        String varB4EAC82CA7396A68D541C85D26508E83_1719101783 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1719101783 = mSubAdminArea;
        varB4EAC82CA7396A68D541C85D26508E83_1719101783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1719101783;
        // ---------- Original Method ----------
        //return mSubAdminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.270 -0400", hash_original_method = "4DF91F489D35ACCA2DC2AF8A5398BD9E", hash_generated_method = "10C6DC9E5F0955108CDE6840819AD482")
    public void setSubAdminArea(String subAdminArea) {
        this.mSubAdminArea = subAdminArea;
        // ---------- Original Method ----------
        //this.mSubAdminArea = subAdminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.271 -0400", hash_original_method = "3743C626E0A5809CC359BBE60C0BEF8D", hash_generated_method = "D82731FE750BDA7F5A99D38FE37BA3E7")
    public String getLocality() {
        String varB4EAC82CA7396A68D541C85D26508E83_93920463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_93920463 = mLocality;
        varB4EAC82CA7396A68D541C85D26508E83_93920463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93920463;
        // ---------- Original Method ----------
        //return mLocality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.271 -0400", hash_original_method = "E848A60937105A6FB0F90F11784FAFAB", hash_generated_method = "09FAEAEF3CAB423AAFFFED8A05988A88")
    public void setLocality(String locality) {
        mLocality = locality;
        // ---------- Original Method ----------
        //mLocality = locality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.284 -0400", hash_original_method = "4565445A715D9E082E3330822780EE14", hash_generated_method = "73C4B5E579116D5DAEB04DCA20245954")
    public String getSubLocality() {
        String varB4EAC82CA7396A68D541C85D26508E83_1094973696 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1094973696 = mSubLocality;
        varB4EAC82CA7396A68D541C85D26508E83_1094973696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1094973696;
        // ---------- Original Method ----------
        //return mSubLocality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.293 -0400", hash_original_method = "FBC28BB3F834CBCC388544379D8FF1EB", hash_generated_method = "88524407E6F13730692BB0EC0929F8BE")
    public void setSubLocality(String sublocality) {
        mSubLocality = sublocality;
        // ---------- Original Method ----------
        //mSubLocality = sublocality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.294 -0400", hash_original_method = "1512262039F5521B933A04882815530C", hash_generated_method = "A363398F91BBAC40AC8A3693DC312120")
    public String getThoroughfare() {
        String varB4EAC82CA7396A68D541C85D26508E83_1308451038 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1308451038 = mThoroughfare;
        varB4EAC82CA7396A68D541C85D26508E83_1308451038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1308451038;
        // ---------- Original Method ----------
        //return mThoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.295 -0400", hash_original_method = "30509B10242C2769144E7C2C070721FD", hash_generated_method = "4924718659371C7461941D134860D04A")
    public void setThoroughfare(String thoroughfare) {
        this.mThoroughfare = thoroughfare;
        // ---------- Original Method ----------
        //this.mThoroughfare = thoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.302 -0400", hash_original_method = "8EFF44F66BA44D813DFBCA9FC34B8EF5", hash_generated_method = "5D9075E3CA73E980CC8ADA36C5A485E5")
    public String getSubThoroughfare() {
        String varB4EAC82CA7396A68D541C85D26508E83_1532096000 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1532096000 = mSubThoroughfare;
        varB4EAC82CA7396A68D541C85D26508E83_1532096000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1532096000;
        // ---------- Original Method ----------
        //return mSubThoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.317 -0400", hash_original_method = "ED99ECE32AF3E65AA637AE926CEFB8FE", hash_generated_method = "58B1784B4A68782244F8452AC42B65F4")
    public void setSubThoroughfare(String subthoroughfare) {
        this.mSubThoroughfare = subthoroughfare;
        // ---------- Original Method ----------
        //this.mSubThoroughfare = subthoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.318 -0400", hash_original_method = "C1BF40685BD6E248364BFB485F611555", hash_generated_method = "4E19A80CCC05AF55313B5D93D53159D2")
    public String getPremises() {
        String varB4EAC82CA7396A68D541C85D26508E83_2053179128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2053179128 = mPremises;
        varB4EAC82CA7396A68D541C85D26508E83_2053179128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2053179128;
        // ---------- Original Method ----------
        //return mPremises;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.320 -0400", hash_original_method = "C9E9B1B8FA21E47AD4B139D64075E36A", hash_generated_method = "2B0B3FE07B8F5EE8C21070FE09BD962A")
    public void setPremises(String premises) {
        mPremises = premises;
        // ---------- Original Method ----------
        //mPremises = premises;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.320 -0400", hash_original_method = "9B5379769D21EFABDDB2785674C4DE4D", hash_generated_method = "8E79ECCE05E767D94E63F72053D21149")
    public String getPostalCode() {
        String varB4EAC82CA7396A68D541C85D26508E83_2010448395 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2010448395 = mPostalCode;
        varB4EAC82CA7396A68D541C85D26508E83_2010448395.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2010448395;
        // ---------- Original Method ----------
        //return mPostalCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.325 -0400", hash_original_method = "21CF31250DB9EF4FD9B8F171A3FE8B16", hash_generated_method = "E8E05B86D22C4A96EB105D8DBDEA25E7")
    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
        // ---------- Original Method ----------
        //mPostalCode = postalCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.334 -0400", hash_original_method = "E8D66F74FB4E1AF79CCB258931950FBE", hash_generated_method = "BCE370C73760F2E8739BEB3B7CECFA1B")
    public String getCountryCode() {
        String varB4EAC82CA7396A68D541C85D26508E83_647582141 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_647582141 = mCountryCode;
        varB4EAC82CA7396A68D541C85D26508E83_647582141.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_647582141;
        // ---------- Original Method ----------
        //return mCountryCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.337 -0400", hash_original_method = "DD5F97427C040B47F9123BA4F8DC93A2", hash_generated_method = "10F64B2D94AD623FDE15BD4D4699264C")
    public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
        // ---------- Original Method ----------
        //mCountryCode = countryCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.338 -0400", hash_original_method = "A82A5DCEE67796EF014C1F79656EFD25", hash_generated_method = "0530A41B9FA506420ED8F02F7E8A3637")
    public String getCountryName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1205046537 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1205046537 = mCountryName;
        varB4EAC82CA7396A68D541C85D26508E83_1205046537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1205046537;
        // ---------- Original Method ----------
        //return mCountryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.345 -0400", hash_original_method = "F7767E8D2EF25B1D1399497900992B14", hash_generated_method = "5F6A05EA0BAE2D22145C166C84A758DE")
    public void setCountryName(String countryName) {
        mCountryName = countryName;
        // ---------- Original Method ----------
        //mCountryName = countryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.345 -0400", hash_original_method = "AB4D7FB4B745E9B023209032D37DF18F", hash_generated_method = "7F5B754AC15F67733E456CC932AD4E46")
    public boolean hasLatitude() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_344644487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_344644487;
        // ---------- Original Method ----------
        //return mHasLatitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.345 -0400", hash_original_method = "74A963FE4AC8482F316E1B3E19ABA2D8", hash_generated_method = "F60C38A7CBB9CBF4C6017B4E74C0FE79")
    public double getLatitude() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        double varE8CD7DA078A86726031AD64F35F5A6C0_1889571403 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1889571403;
        // ---------- Original Method ----------
        //if (mHasLatitude) {
            //return mLatitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.354 -0400", hash_original_method = "E7EB84DA300898C528161A7CBF9FB7F9", hash_generated_method = "4ABFA5E2D8A978A1DF296206A6637849")
    public void setLatitude(double latitude) {
        mLatitude = latitude;
        mHasLatitude = true;
        // ---------- Original Method ----------
        //mLatitude = latitude;
        //mHasLatitude = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.355 -0400", hash_original_method = "4BCAF53DCD4CF7BB362561C1B9A79F13", hash_generated_method = "A8538AF0D6CB924252483A3546F1E7D2")
    public void clearLatitude() {
        mHasLatitude = false;
        // ---------- Original Method ----------
        //mHasLatitude = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.355 -0400", hash_original_method = "44F26BDA1ACBDD9862A3D8D8968B3507", hash_generated_method = "3A78CA79AE04D6D15117A49AB8E095D0")
    public boolean hasLongitude() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852165794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852165794;
        // ---------- Original Method ----------
        //return mHasLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.356 -0400", hash_original_method = "90E38F72A8C0EDFD5CFCC6EABD3BD432", hash_generated_method = "01DA09BD0323BD48D8F2C58F6C2484B1")
    public double getLongitude() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        double varE8CD7DA078A86726031AD64F35F5A6C0_62029314 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_62029314;
        // ---------- Original Method ----------
        //if (mHasLongitude) {
            //return mLongitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.365 -0400", hash_original_method = "C4D556739F3557653F6C8D616289AA29", hash_generated_method = "C5F4A24BBD737E53F906B0B4B1241A26")
    public void setLongitude(double longitude) {
        mLongitude = longitude;
        mHasLongitude = true;
        // ---------- Original Method ----------
        //mLongitude = longitude;
        //mHasLongitude = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.366 -0400", hash_original_method = "D5786F30716C18CE0A0AB74556D12A22", hash_generated_method = "72D8B7051AF8F5D8AF738740565981D0")
    public void clearLongitude() {
        mHasLongitude = false;
        // ---------- Original Method ----------
        //mHasLongitude = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.366 -0400", hash_original_method = "EB9EE516F482EB01602422E9FA56CA5C", hash_generated_method = "1637118195019D3D1109F29B9745AF1E")
    public String getPhone() {
        String varB4EAC82CA7396A68D541C85D26508E83_1539897683 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1539897683 = mPhone;
        varB4EAC82CA7396A68D541C85D26508E83_1539897683.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539897683;
        // ---------- Original Method ----------
        //return mPhone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.391 -0400", hash_original_method = "5023DDC820B0F6BE06303CFCE3A71EDF", hash_generated_method = "DE0BAA2F1475B12EBE7D57B9B6E7D336")
    public void setPhone(String phone) {
        mPhone = phone;
        // ---------- Original Method ----------
        //mPhone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.392 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "73931EE5ED13BED695E6AE22034AF691")
    public String getUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_51684894 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_51684894 = mUrl;
        varB4EAC82CA7396A68D541C85D26508E83_51684894.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_51684894;
        // ---------- Original Method ----------
        //return mUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.393 -0400", hash_original_method = "A94A57C3BD4A508E7FC3D69DE1774EEC", hash_generated_method = "4D2F926217B6FA5CE5A195400B3E7118")
    public void setUrl(String Url) {
        mUrl = Url;
        // ---------- Original Method ----------
        //mUrl = Url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.394 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "3AD1079C6D8941683CB5868537FB7878")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_295237778 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_295237778 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_295237778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_295237778;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.395 -0400", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "9B56A595B86963DFD04070AE7AE28FC1")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? null : new Bundle(extras);
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? null : new Bundle(extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.404 -0400", hash_original_method = "F2CDEB7D6ECCED8CC4C514EA700B26BB", hash_generated_method = "A030220A826E7450567E8AA766147BAE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_899857906 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Address[addressLines=[");
        {
            int i;
            i = 0;
            {
                {
                    sb.append(',');
                } //End block
                sb.append(i);
                sb.append(':');
                String line;
                line = mAddressLines.get(i);
                {
                    sb.append("null");
                } //End block
                {
                    sb.append('\"');
                    sb.append(line);
                    sb.append('\"');
                } //End block
            } //End block
        } //End collapsed parenthetic
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
        varB4EAC82CA7396A68D541C85D26508E83_899857906 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_899857906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_899857906;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.439 -0400", hash_original_method = "2C347F4A4F86FFA77F246DC5FD21E5D6", hash_generated_method = "416BD1C8A7EF0FA838D2524FDCC414E3")
    public int describeContents() {
        {
            Object varE627D80D86B1145CFBB6F925B58A1813_387450659 = (mExtras.describeContents());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_404178952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_404178952;
        // ---------- Original Method ----------
        //return (mExtras != null) ? mExtras.describeContents() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.651 -0400", hash_original_method = "609BCF0D5B324DA0FE8A594DDD7486F2", hash_generated_method = "8327B501CDF4A84AEB4494C5F16D0A47")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mLocale.getLanguage());
        parcel.writeString(mLocale.getCountry());
        {
            parcel.writeInt(0);
        } //End block
        {
            Set<Map.Entry<Integer, String>> entries;
            entries = mAddressLines.entrySet();
            parcel.writeInt(entries.size());
            {
                Iterator<Map.Entry<Integer, String>> var4B488CD82431A24A9834E463DFD78A58_1835249897 = (entries).iterator();
                var4B488CD82431A24A9834E463DFD78A58_1835249897.hasNext();
                Map.Entry<Integer, String> e = var4B488CD82431A24A9834E463DFD78A58_1835249897.next();
                {
                    parcel.writeInt(e.getKey());
                    parcel.writeString(e.getValue());
                } //End block
            } //End collapsed parenthetic
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
        {
            parcel.writeDouble(mLatitude);
        } //End block
        parcel.writeInt(mHasLongitude ? 1 : 0);
        {
            parcel.writeDouble(mLongitude);
        } //End block
        parcel.writeString(mPhone);
        parcel.writeString(mUrl);
        parcel.writeBundle(mExtras);
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.663 -0400", hash_original_field = "34AF13FB5BC8BAFBEC9B029562C77C94", hash_generated_field = "B4FB2F104B558E1CA23D02F180C08BB7")

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
}

