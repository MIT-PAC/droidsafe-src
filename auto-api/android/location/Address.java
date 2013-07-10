package android.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "8937E233714B037ECE45D23AA79BE19E", hash_generated_field = "885B87E22D2EF7CC7C342A420B72EF3E")

    private String mFeatureName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "36BE4E7B894E1FE49E224E15F4F09E30", hash_generated_field = "267F6B9285B603FF477C20775D29AA60")

    private HashMap<Integer, String> mAddressLines;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "5B6E8EDDE261396A90E6DE4AA7DED93C", hash_generated_field = "61A068F86D173398FFF3F86ABD61DF78")

    private int mMaxAddressLineIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "AE9759C687BF60F269594A7976FFE5FE", hash_generated_field = "9E4BAF383B0085BDBE33EFF069DD6A8A")

    private String mAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "8D06393B99CFCE4BBDB353A8B6ED85AA", hash_generated_field = "5914F416D26BAEA83D36B07CC8123017")

    private String mSubAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "5AD01704F5F406F72AF7849956EE8F0F", hash_generated_field = "B27EC088B31F0C4F3FC5FD8261A96829")

    private String mLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "D392069C4E4C8DE4BDCF9B1203629260", hash_generated_field = "54AA36C926071A6092BD97F68F4B1C69")

    private String mSubLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "AEFA91646A44DC198B507332D2E5632B", hash_generated_field = "572923B079894AE27884BBD950702954")

    private String mThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "AB0822CC993C6AEFD95D7EC721C6A3A0", hash_generated_field = "01630869675F1DA42810C4AF0E092889")

    private String mSubThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "013B63ACAA6366BEADD9080708AB0FB5", hash_generated_field = "CF559618A1D4E648B6B2F354F5258741")

    private String mPremises;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "29C6E2F3AB8D31B2C3BE92645A419B42", hash_generated_field = "C69EE2CA15E3AA7242875015CFA55C01")

    private String mPostalCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "F28ADBF1524A97CDC354A7ABA882BC81", hash_generated_field = "9C7911CE25730D113ABA8C07F7DE1F24")

    private String mCountryCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "CBAEF129D89ADC31EA2120243155BCD3", hash_generated_field = "4CCD8712180BD60CFDB41FE6E2DEDB0D")

    private String mCountryName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "F9F903C408E7A13A84941FB6656F8EFD", hash_generated_field = "9EF15EBC1351E9950D0EE5BCAD1038B0")

    private double mLatitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "7C3CBAEC265653C71D6DB9C159F9C831", hash_generated_field = "5D603DAFF57AB40C16D9A89FCAF92AF2")

    private double mLongitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "471874D7C9D518F9BA7E6BD4710C5328", hash_generated_field = "92513C87CE591BDB601C26AA959D3DE3")

    private boolean mHasLatitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "27A42338E7E0A24D070C5E815602253C", hash_generated_field = "4581B045B6697DC4EF5E7E35CB7E72AE")

    private boolean mHasLongitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "1D4D63140ABF8732CCB2AA5286B163C3")

    private String mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.042 -0400", hash_original_field = "7AC7A3C81EDFAF4AE16351926EDACBA4", hash_generated_field = "F67EBBE51D94FDD3154517E86441117D")

    private Bundle mExtras = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.043 -0400", hash_original_method = "8C8D8A006008D0E9588030A46EE6B5B9", hash_generated_method = "8FD930FF34428F79FC4B7AEC5627420E")
    public  Address(Locale locale) {
        mLocale = locale;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.043 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "583A1DFAF8BEA0E16BDAD2325E13062D")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_1892572234 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1892572234 = mLocale;
        varB4EAC82CA7396A68D541C85D26508E83_1892572234.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1892572234;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.044 -0400", hash_original_method = "E1E6237F606789C7A5294059179DF025", hash_generated_method = "FA97E55A4BCAC0A65D70D7CE81BFC464")
    public int getMaxAddressLineIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1308890304 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1308890304;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.044 -0400", hash_original_method = "D824FE2CFE40DB25058DC1465F2D4439", hash_generated_method = "AA11704757D7CA3180FA6456EAD094EA")
    public String getAddressLine(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_772512934 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("index = " + index + " < 0");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_772512934 = mAddressLines == null? null :  mAddressLines.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_772512934.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_772512934;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.051 -0400", hash_original_method = "5C23144E8A22EAB5D8930884A1255DAC", hash_generated_method = "FE1090E8276321BC8410A0BF9CE65617")
    public void setAddressLine(int index, String line) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("index = " + index + " < 0");
        } 
        {
            mAddressLines = new HashMap<Integer, String>();
        } 
        mAddressLines.put(index, line);
        {
            mMaxAddressLineIndex = -1;
            {
                Iterator<Integer> var11CB2090D7C1AE4D5F6497E3F769BE3A_1735295294 = (mAddressLines.keySet()).iterator();
                var11CB2090D7C1AE4D5F6497E3F769BE3A_1735295294.hasNext();
                Integer i = var11CB2090D7C1AE4D5F6497E3F769BE3A_1735295294.next();
                {
                    mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, i);
                } 
            } 
        } 
        {
            mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, index);
        } 
        addTaint(line.getTaint());
        
        
            
        
        
            
        
        
        
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.052 -0400", hash_original_method = "D108F727B4ED1E44A68F4DDDAA8864A4", hash_generated_method = "4348A2575492890C5BC181D3A743CA01")
    public String getFeatureName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2091858008 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2091858008 = mFeatureName;
        varB4EAC82CA7396A68D541C85D26508E83_2091858008.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2091858008;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.052 -0400", hash_original_method = "49225B599976EB86160DDAF83CE5BC7F", hash_generated_method = "1D26184E4D899C0F02D8A649DE7F872A")
    public void setFeatureName(String featureName) {
        mFeatureName = featureName;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.053 -0400", hash_original_method = "EDE4D65E7936029E84B8376D150F4DDE", hash_generated_method = "53896020E7C505BD34F5E4C99DBD42E3")
    public String getAdminArea() {
        String varB4EAC82CA7396A68D541C85D26508E83_1389697085 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1389697085 = mAdminArea;
        varB4EAC82CA7396A68D541C85D26508E83_1389697085.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1389697085;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.053 -0400", hash_original_method = "C8D449D9A4FBB2AF83806F488A8CAC1C", hash_generated_method = "40C7CFB20A367AD4F7EDC68C1A3AAE86")
    public void setAdminArea(String adminArea) {
        this.mAdminArea = adminArea;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.054 -0400", hash_original_method = "84D73E83BF1D1209648491141222963A", hash_generated_method = "7D6ECD4A7756C8C87A0E3DEDEE7A0170")
    public String getSubAdminArea() {
        String varB4EAC82CA7396A68D541C85D26508E83_797919420 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_797919420 = mSubAdminArea;
        varB4EAC82CA7396A68D541C85D26508E83_797919420.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_797919420;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.054 -0400", hash_original_method = "4DF91F489D35ACCA2DC2AF8A5398BD9E", hash_generated_method = "10C6DC9E5F0955108CDE6840819AD482")
    public void setSubAdminArea(String subAdminArea) {
        this.mSubAdminArea = subAdminArea;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.055 -0400", hash_original_method = "3743C626E0A5809CC359BBE60C0BEF8D", hash_generated_method = "25BF1B64BD1EFA7E7700CC90AE5B7308")
    public String getLocality() {
        String varB4EAC82CA7396A68D541C85D26508E83_2019560404 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2019560404 = mLocality;
        varB4EAC82CA7396A68D541C85D26508E83_2019560404.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2019560404;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.055 -0400", hash_original_method = "E848A60937105A6FB0F90F11784FAFAB", hash_generated_method = "09FAEAEF3CAB423AAFFFED8A05988A88")
    public void setLocality(String locality) {
        mLocality = locality;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.056 -0400", hash_original_method = "4565445A715D9E082E3330822780EE14", hash_generated_method = "72758C8363185923F5FED9989F63A7EF")
    public String getSubLocality() {
        String varB4EAC82CA7396A68D541C85D26508E83_1039512067 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1039512067 = mSubLocality;
        varB4EAC82CA7396A68D541C85D26508E83_1039512067.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1039512067;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.056 -0400", hash_original_method = "FBC28BB3F834CBCC388544379D8FF1EB", hash_generated_method = "88524407E6F13730692BB0EC0929F8BE")
    public void setSubLocality(String sublocality) {
        mSubLocality = sublocality;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.057 -0400", hash_original_method = "1512262039F5521B933A04882815530C", hash_generated_method = "8425E4752DD2BF4D3814B5A75DF431D7")
    public String getThoroughfare() {
        String varB4EAC82CA7396A68D541C85D26508E83_45765256 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_45765256 = mThoroughfare;
        varB4EAC82CA7396A68D541C85D26508E83_45765256.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_45765256;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.059 -0400", hash_original_method = "30509B10242C2769144E7C2C070721FD", hash_generated_method = "4924718659371C7461941D134860D04A")
    public void setThoroughfare(String thoroughfare) {
        this.mThoroughfare = thoroughfare;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.060 -0400", hash_original_method = "8EFF44F66BA44D813DFBCA9FC34B8EF5", hash_generated_method = "6A6E7C949FAA5978AF74859FD5B2BD37")
    public String getSubThoroughfare() {
        String varB4EAC82CA7396A68D541C85D26508E83_895390590 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_895390590 = mSubThoroughfare;
        varB4EAC82CA7396A68D541C85D26508E83_895390590.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_895390590;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.061 -0400", hash_original_method = "ED99ECE32AF3E65AA637AE926CEFB8FE", hash_generated_method = "58B1784B4A68782244F8452AC42B65F4")
    public void setSubThoroughfare(String subthoroughfare) {
        this.mSubThoroughfare = subthoroughfare;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.062 -0400", hash_original_method = "C1BF40685BD6E248364BFB485F611555", hash_generated_method = "C96B947FDD52AC20ECEB50DB8AC5AC3D")
    public String getPremises() {
        String varB4EAC82CA7396A68D541C85D26508E83_1138712909 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1138712909 = mPremises;
        varB4EAC82CA7396A68D541C85D26508E83_1138712909.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1138712909;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.063 -0400", hash_original_method = "C9E9B1B8FA21E47AD4B139D64075E36A", hash_generated_method = "2B0B3FE07B8F5EE8C21070FE09BD962A")
    public void setPremises(String premises) {
        mPremises = premises;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.063 -0400", hash_original_method = "9B5379769D21EFABDDB2785674C4DE4D", hash_generated_method = "407A4374F075718503289C7D34A8A909")
    public String getPostalCode() {
        String varB4EAC82CA7396A68D541C85D26508E83_753764440 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_753764440 = mPostalCode;
        varB4EAC82CA7396A68D541C85D26508E83_753764440.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_753764440;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.064 -0400", hash_original_method = "21CF31250DB9EF4FD9B8F171A3FE8B16", hash_generated_method = "E8E05B86D22C4A96EB105D8DBDEA25E7")
    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.064 -0400", hash_original_method = "E8D66F74FB4E1AF79CCB258931950FBE", hash_generated_method = "33DDAAF6AAD307BFEA144C7600C5DC1A")
    public String getCountryCode() {
        String varB4EAC82CA7396A68D541C85D26508E83_589988971 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_589988971 = mCountryCode;
        varB4EAC82CA7396A68D541C85D26508E83_589988971.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_589988971;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.065 -0400", hash_original_method = "DD5F97427C040B47F9123BA4F8DC93A2", hash_generated_method = "10F64B2D94AD623FDE15BD4D4699264C")
    public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.065 -0400", hash_original_method = "A82A5DCEE67796EF014C1F79656EFD25", hash_generated_method = "8DC4DC7FA77FC95A7038B1F1CAE40017")
    public String getCountryName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1554775331 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1554775331 = mCountryName;
        varB4EAC82CA7396A68D541C85D26508E83_1554775331.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1554775331;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.066 -0400", hash_original_method = "F7767E8D2EF25B1D1399497900992B14", hash_generated_method = "5F6A05EA0BAE2D22145C166C84A758DE")
    public void setCountryName(String countryName) {
        mCountryName = countryName;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.066 -0400", hash_original_method = "AB4D7FB4B745E9B023209032D37DF18F", hash_generated_method = "9DD03650A29573F637D1DDCFDF1DAD86")
    public boolean hasLatitude() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979497311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979497311;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.068 -0400", hash_original_method = "74A963FE4AC8482F316E1B3E19ABA2D8", hash_generated_method = "8DFF31FE7E2CB7F8108E10D0672F7B74")
    public double getLatitude() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        double varE8CD7DA078A86726031AD64F35F5A6C0_382214457 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_382214457;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.069 -0400", hash_original_method = "E7EB84DA300898C528161A7CBF9FB7F9", hash_generated_method = "4ABFA5E2D8A978A1DF296206A6637849")
    public void setLatitude(double latitude) {
        mLatitude = latitude;
        mHasLatitude = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.070 -0400", hash_original_method = "4BCAF53DCD4CF7BB362561C1B9A79F13", hash_generated_method = "A8538AF0D6CB924252483A3546F1E7D2")
    public void clearLatitude() {
        mHasLatitude = false;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.070 -0400", hash_original_method = "44F26BDA1ACBDD9862A3D8D8968B3507", hash_generated_method = "BE5C2EC9433082EAD54B03FE90DA3BBA")
    public boolean hasLongitude() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_582084041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_582084041;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.071 -0400", hash_original_method = "90E38F72A8C0EDFD5CFCC6EABD3BD432", hash_generated_method = "25768A4D121A4F9CFB6BEBF5CFEB3BF2")
    public double getLongitude() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        double varE8CD7DA078A86726031AD64F35F5A6C0_1591624335 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1591624335;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.071 -0400", hash_original_method = "C4D556739F3557653F6C8D616289AA29", hash_generated_method = "C5F4A24BBD737E53F906B0B4B1241A26")
    public void setLongitude(double longitude) {
        mLongitude = longitude;
        mHasLongitude = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.071 -0400", hash_original_method = "D5786F30716C18CE0A0AB74556D12A22", hash_generated_method = "72D8B7051AF8F5D8AF738740565981D0")
    public void clearLongitude() {
        mHasLongitude = false;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.072 -0400", hash_original_method = "EB9EE516F482EB01602422E9FA56CA5C", hash_generated_method = "66942A445FBD0EB0672AFD74C8E1D489")
    public String getPhone() {
        String varB4EAC82CA7396A68D541C85D26508E83_2140135837 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2140135837 = mPhone;
        varB4EAC82CA7396A68D541C85D26508E83_2140135837.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2140135837;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.072 -0400", hash_original_method = "5023DDC820B0F6BE06303CFCE3A71EDF", hash_generated_method = "DE0BAA2F1475B12EBE7D57B9B6E7D336")
    public void setPhone(String phone) {
        mPhone = phone;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.073 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "8915952DE1BEE4801EFB9D5D8B49BD58")
    public String getUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_263987308 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_263987308 = mUrl;
        varB4EAC82CA7396A68D541C85D26508E83_263987308.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_263987308;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.073 -0400", hash_original_method = "A94A57C3BD4A508E7FC3D69DE1774EEC", hash_generated_method = "4D2F926217B6FA5CE5A195400B3E7118")
    public void setUrl(String Url) {
        mUrl = Url;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.074 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "0FE4EE274FF4B86EBE30D5980EA4C54F")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_526724047 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_526724047 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_526724047.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_526724047;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.075 -0400", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "9B56A595B86963DFD04070AE7AE28FC1")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? null : new Bundle(extras);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.077 -0400", hash_original_method = "F2CDEB7D6ECCED8CC4C514EA700B26BB", hash_generated_method = "2BE88F9BB07E8B894F5949D2A8E45026")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1002172619 = null; 
        StringBuilder sb = new StringBuilder();
        sb.append("Address[addressLines=[");
        {
            int i = 0;
            {
                {
                    sb.append(',');
                } 
                sb.append(i);
                sb.append(':');
                String line = mAddressLines.get(i);
                {
                    sb.append("null");
                } 
                {
                    sb.append('\"');
                    sb.append(line);
                    sb.append('\"');
                } 
            } 
        } 
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
        varB4EAC82CA7396A68D541C85D26508E83_1002172619 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1002172619.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1002172619;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.079 -0400", hash_original_method = "2C347F4A4F86FFA77F246DC5FD21E5D6", hash_generated_method = "CD7399D1853A4A27C0E5A50C9D064AC4")
    public int describeContents() {
        {
            Object varE627D80D86B1145CFBB6F925B58A1813_1703662743 = (mExtras.describeContents());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247525471 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247525471;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.090 -0400", hash_original_method = "609BCF0D5B324DA0FE8A594DDD7486F2", hash_generated_method = "BF7E54F02FD384C10BC2E8272DAB137F")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mLocale.getLanguage());
        parcel.writeString(mLocale.getCountry());
        {
            parcel.writeInt(0);
        } 
        {
            Set<Map.Entry<Integer, String>> entries = mAddressLines.entrySet();
            parcel.writeInt(entries.size());
            {
                Iterator<Map.Entry<Integer, String>> var4B488CD82431A24A9834E463DFD78A58_1840015275 = (entries).iterator();
                var4B488CD82431A24A9834E463DFD78A58_1840015275.hasNext();
                Map.Entry<Integer, String> e = var4B488CD82431A24A9834E463DFD78A58_1840015275.next();
                {
                    parcel.writeInt(e.getKey());
                    parcel.writeString(e.getValue());
                } 
            } 
        } 
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
        } 
        parcel.writeInt(mHasLongitude ? 1 : 0);
        {
            parcel.writeDouble(mLongitude);
        } 
        parcel.writeString(mPhone);
        parcel.writeString(mUrl);
        parcel.writeBundle(mExtras);
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.090 -0400", hash_original_field = "34AF13FB5BC8BAFBEC9B029562C77C94", hash_generated_field = "B4FB2F104B558E1CA23D02F180C08BB7")

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
    
}

