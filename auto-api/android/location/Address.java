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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.717 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.717 -0400", hash_original_field = "8937E233714B037ECE45D23AA79BE19E", hash_generated_field = "885B87E22D2EF7CC7C342A420B72EF3E")

    private String mFeatureName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.717 -0400", hash_original_field = "36BE4E7B894E1FE49E224E15F4F09E30", hash_generated_field = "267F6B9285B603FF477C20775D29AA60")

    private HashMap<Integer, String> mAddressLines;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.717 -0400", hash_original_field = "5B6E8EDDE261396A90E6DE4AA7DED93C", hash_generated_field = "61A068F86D173398FFF3F86ABD61DF78")

    private int mMaxAddressLineIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.717 -0400", hash_original_field = "AE9759C687BF60F269594A7976FFE5FE", hash_generated_field = "9E4BAF383B0085BDBE33EFF069DD6A8A")

    private String mAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.717 -0400", hash_original_field = "8D06393B99CFCE4BBDB353A8B6ED85AA", hash_generated_field = "5914F416D26BAEA83D36B07CC8123017")

    private String mSubAdminArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.717 -0400", hash_original_field = "5AD01704F5F406F72AF7849956EE8F0F", hash_generated_field = "B27EC088B31F0C4F3FC5FD8261A96829")

    private String mLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.717 -0400", hash_original_field = "D392069C4E4C8DE4BDCF9B1203629260", hash_generated_field = "54AA36C926071A6092BD97F68F4B1C69")

    private String mSubLocality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.718 -0400", hash_original_field = "AEFA91646A44DC198B507332D2E5632B", hash_generated_field = "572923B079894AE27884BBD950702954")

    private String mThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.731 -0400", hash_original_field = "AB0822CC993C6AEFD95D7EC721C6A3A0", hash_generated_field = "01630869675F1DA42810C4AF0E092889")

    private String mSubThoroughfare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.731 -0400", hash_original_field = "013B63ACAA6366BEADD9080708AB0FB5", hash_generated_field = "CF559618A1D4E648B6B2F354F5258741")

    private String mPremises;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.732 -0400", hash_original_field = "29C6E2F3AB8D31B2C3BE92645A419B42", hash_generated_field = "C69EE2CA15E3AA7242875015CFA55C01")

    private String mPostalCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.732 -0400", hash_original_field = "F28ADBF1524A97CDC354A7ABA882BC81", hash_generated_field = "9C7911CE25730D113ABA8C07F7DE1F24")

    private String mCountryCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.732 -0400", hash_original_field = "CBAEF129D89ADC31EA2120243155BCD3", hash_generated_field = "4CCD8712180BD60CFDB41FE6E2DEDB0D")

    private String mCountryName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.732 -0400", hash_original_field = "F9F903C408E7A13A84941FB6656F8EFD", hash_generated_field = "9EF15EBC1351E9950D0EE5BCAD1038B0")

    private double mLatitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.732 -0400", hash_original_field = "7C3CBAEC265653C71D6DB9C159F9C831", hash_generated_field = "5D603DAFF57AB40C16D9A89FCAF92AF2")

    private double mLongitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.732 -0400", hash_original_field = "471874D7C9D518F9BA7E6BD4710C5328", hash_generated_field = "92513C87CE591BDB601C26AA959D3DE3")

    private boolean mHasLatitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.732 -0400", hash_original_field = "27A42338E7E0A24D070C5E815602253C", hash_generated_field = "4581B045B6697DC4EF5E7E35CB7E72AE")

    private boolean mHasLongitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.732 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "1D4D63140ABF8732CCB2AA5286B163C3")

    private String mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.733 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.733 -0400", hash_original_field = "7AC7A3C81EDFAF4AE16351926EDACBA4", hash_generated_field = "F67EBBE51D94FDD3154517E86441117D")

    private Bundle mExtras = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.734 -0400", hash_original_method = "8C8D8A006008D0E9588030A46EE6B5B9", hash_generated_method = "8FD930FF34428F79FC4B7AEC5627420E")
    public  Address(Locale locale) {
        mLocale = locale;
        // ---------- Original Method ----------
        //mLocale = locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.741 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "C95B04DED824BF569BEEEFCB8A59C737")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_609261968 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_609261968 = mLocale;
        varB4EAC82CA7396A68D541C85D26508E83_609261968.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_609261968;
        // ---------- Original Method ----------
        //return mLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.741 -0400", hash_original_method = "E1E6237F606789C7A5294059179DF025", hash_generated_method = "818E2280A2180C6BCEBFFC8C912A7171")
    public int getMaxAddressLineIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950805035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950805035;
        // ---------- Original Method ----------
        //return mMaxAddressLineIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.743 -0400", hash_original_method = "D824FE2CFE40DB25058DC1465F2D4439", hash_generated_method = "EA13B0160393FA2A8C15009B81998766")
    public String getAddressLine(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1079227475 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("index = " + index + " < 0");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1079227475 = mAddressLines == null? null :  mAddressLines.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1079227475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1079227475;
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IllegalArgumentException("index = " + index + " < 0");
        //}
        //return mAddressLines == null? null :  mAddressLines.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.822 -0400", hash_original_method = "5C23144E8A22EAB5D8930884A1255DAC", hash_generated_method = "024ECC176956656B6D88B5C1AA0A5542")
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
                Iterator<Integer> var11CB2090D7C1AE4D5F6497E3F769BE3A_1218804450 = (mAddressLines.keySet()).iterator();
                var11CB2090D7C1AE4D5F6497E3F769BE3A_1218804450.hasNext();
                Integer i = var11CB2090D7C1AE4D5F6497E3F769BE3A_1218804450.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.834 -0400", hash_original_method = "D108F727B4ED1E44A68F4DDDAA8864A4", hash_generated_method = "038E6C1CA133CF41C1348A25CA25E143")
    public String getFeatureName() {
        String varB4EAC82CA7396A68D541C85D26508E83_684954870 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_684954870 = mFeatureName;
        varB4EAC82CA7396A68D541C85D26508E83_684954870.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_684954870;
        // ---------- Original Method ----------
        //return mFeatureName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.835 -0400", hash_original_method = "49225B599976EB86160DDAF83CE5BC7F", hash_generated_method = "1D26184E4D899C0F02D8A649DE7F872A")
    public void setFeatureName(String featureName) {
        mFeatureName = featureName;
        // ---------- Original Method ----------
        //mFeatureName = featureName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.836 -0400", hash_original_method = "EDE4D65E7936029E84B8376D150F4DDE", hash_generated_method = "8238A821E73760096FED9E86703A408A")
    public String getAdminArea() {
        String varB4EAC82CA7396A68D541C85D26508E83_1618275087 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1618275087 = mAdminArea;
        varB4EAC82CA7396A68D541C85D26508E83_1618275087.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1618275087;
        // ---------- Original Method ----------
        //return mAdminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.927 -0400", hash_original_method = "C8D449D9A4FBB2AF83806F488A8CAC1C", hash_generated_method = "40C7CFB20A367AD4F7EDC68C1A3AAE86")
    public void setAdminArea(String adminArea) {
        this.mAdminArea = adminArea;
        // ---------- Original Method ----------
        //this.mAdminArea = adminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.928 -0400", hash_original_method = "84D73E83BF1D1209648491141222963A", hash_generated_method = "763AF7224DDFF07E235354837DE4CD81")
    public String getSubAdminArea() {
        String varB4EAC82CA7396A68D541C85D26508E83_119070676 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_119070676 = mSubAdminArea;
        varB4EAC82CA7396A68D541C85D26508E83_119070676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_119070676;
        // ---------- Original Method ----------
        //return mSubAdminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.929 -0400", hash_original_method = "4DF91F489D35ACCA2DC2AF8A5398BD9E", hash_generated_method = "10C6DC9E5F0955108CDE6840819AD482")
    public void setSubAdminArea(String subAdminArea) {
        this.mSubAdminArea = subAdminArea;
        // ---------- Original Method ----------
        //this.mSubAdminArea = subAdminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.933 -0400", hash_original_method = "3743C626E0A5809CC359BBE60C0BEF8D", hash_generated_method = "9504E77489E19B576832270452B2AE79")
    public String getLocality() {
        String varB4EAC82CA7396A68D541C85D26508E83_542730425 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_542730425 = mLocality;
        varB4EAC82CA7396A68D541C85D26508E83_542730425.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_542730425;
        // ---------- Original Method ----------
        //return mLocality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.937 -0400", hash_original_method = "E848A60937105A6FB0F90F11784FAFAB", hash_generated_method = "09FAEAEF3CAB423AAFFFED8A05988A88")
    public void setLocality(String locality) {
        mLocality = locality;
        // ---------- Original Method ----------
        //mLocality = locality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.938 -0400", hash_original_method = "4565445A715D9E082E3330822780EE14", hash_generated_method = "10A3CBD7299F9CEDC56D77C45FA54C27")
    public String getSubLocality() {
        String varB4EAC82CA7396A68D541C85D26508E83_1139899759 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1139899759 = mSubLocality;
        varB4EAC82CA7396A68D541C85D26508E83_1139899759.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1139899759;
        // ---------- Original Method ----------
        //return mSubLocality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.940 -0400", hash_original_method = "FBC28BB3F834CBCC388544379D8FF1EB", hash_generated_method = "88524407E6F13730692BB0EC0929F8BE")
    public void setSubLocality(String sublocality) {
        mSubLocality = sublocality;
        // ---------- Original Method ----------
        //mSubLocality = sublocality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.955 -0400", hash_original_method = "1512262039F5521B933A04882815530C", hash_generated_method = "BF11B1472DBEC549CB15EBE4FC1BF3EF")
    public String getThoroughfare() {
        String varB4EAC82CA7396A68D541C85D26508E83_2004579947 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2004579947 = mThoroughfare;
        varB4EAC82CA7396A68D541C85D26508E83_2004579947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2004579947;
        // ---------- Original Method ----------
        //return mThoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.956 -0400", hash_original_method = "30509B10242C2769144E7C2C070721FD", hash_generated_method = "4924718659371C7461941D134860D04A")
    public void setThoroughfare(String thoroughfare) {
        this.mThoroughfare = thoroughfare;
        // ---------- Original Method ----------
        //this.mThoroughfare = thoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.978 -0400", hash_original_method = "8EFF44F66BA44D813DFBCA9FC34B8EF5", hash_generated_method = "30BA54B3429D516B4A73F50933F61F7B")
    public String getSubThoroughfare() {
        String varB4EAC82CA7396A68D541C85D26508E83_1943688317 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1943688317 = mSubThoroughfare;
        varB4EAC82CA7396A68D541C85D26508E83_1943688317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1943688317;
        // ---------- Original Method ----------
        //return mSubThoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.978 -0400", hash_original_method = "ED99ECE32AF3E65AA637AE926CEFB8FE", hash_generated_method = "58B1784B4A68782244F8452AC42B65F4")
    public void setSubThoroughfare(String subthoroughfare) {
        this.mSubThoroughfare = subthoroughfare;
        // ---------- Original Method ----------
        //this.mSubThoroughfare = subthoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.979 -0400", hash_original_method = "C1BF40685BD6E248364BFB485F611555", hash_generated_method = "9D73853150813977E0A86944D1BB836B")
    public String getPremises() {
        String varB4EAC82CA7396A68D541C85D26508E83_1357326369 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1357326369 = mPremises;
        varB4EAC82CA7396A68D541C85D26508E83_1357326369.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1357326369;
        // ---------- Original Method ----------
        //return mPremises;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.980 -0400", hash_original_method = "C9E9B1B8FA21E47AD4B139D64075E36A", hash_generated_method = "2B0B3FE07B8F5EE8C21070FE09BD962A")
    public void setPremises(String premises) {
        mPremises = premises;
        // ---------- Original Method ----------
        //mPremises = premises;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.981 -0400", hash_original_method = "9B5379769D21EFABDDB2785674C4DE4D", hash_generated_method = "E3CC29E4B01D505D1AB300F0C7259B66")
    public String getPostalCode() {
        String varB4EAC82CA7396A68D541C85D26508E83_51213380 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_51213380 = mPostalCode;
        varB4EAC82CA7396A68D541C85D26508E83_51213380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_51213380;
        // ---------- Original Method ----------
        //return mPostalCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.981 -0400", hash_original_method = "21CF31250DB9EF4FD9B8F171A3FE8B16", hash_generated_method = "E8E05B86D22C4A96EB105D8DBDEA25E7")
    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
        // ---------- Original Method ----------
        //mPostalCode = postalCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.009 -0400", hash_original_method = "E8D66F74FB4E1AF79CCB258931950FBE", hash_generated_method = "5B48A0BE72AD527FAAB576931440A3EC")
    public String getCountryCode() {
        String varB4EAC82CA7396A68D541C85D26508E83_761405310 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_761405310 = mCountryCode;
        varB4EAC82CA7396A68D541C85D26508E83_761405310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_761405310;
        // ---------- Original Method ----------
        //return mCountryCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.010 -0400", hash_original_method = "DD5F97427C040B47F9123BA4F8DC93A2", hash_generated_method = "10F64B2D94AD623FDE15BD4D4699264C")
    public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
        // ---------- Original Method ----------
        //mCountryCode = countryCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.011 -0400", hash_original_method = "A82A5DCEE67796EF014C1F79656EFD25", hash_generated_method = "C5E2DCE0F03E0D124B4B36B7CF979BA3")
    public String getCountryName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1185587307 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1185587307 = mCountryName;
        varB4EAC82CA7396A68D541C85D26508E83_1185587307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1185587307;
        // ---------- Original Method ----------
        //return mCountryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.012 -0400", hash_original_method = "F7767E8D2EF25B1D1399497900992B14", hash_generated_method = "5F6A05EA0BAE2D22145C166C84A758DE")
    public void setCountryName(String countryName) {
        mCountryName = countryName;
        // ---------- Original Method ----------
        //mCountryName = countryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.013 -0400", hash_original_method = "AB4D7FB4B745E9B023209032D37DF18F", hash_generated_method = "C04D13897D20903759184454880679A2")
    public boolean hasLatitude() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1272682332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1272682332;
        // ---------- Original Method ----------
        //return mHasLatitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.013 -0400", hash_original_method = "74A963FE4AC8482F316E1B3E19ABA2D8", hash_generated_method = "2DD9D4823A90E46F1AEDCDBD9C16B0F3")
    public double getLatitude() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        double varE8CD7DA078A86726031AD64F35F5A6C0_1790598956 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1790598956;
        // ---------- Original Method ----------
        //if (mHasLatitude) {
            //return mLatitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.033 -0400", hash_original_method = "E7EB84DA300898C528161A7CBF9FB7F9", hash_generated_method = "4ABFA5E2D8A978A1DF296206A6637849")
    public void setLatitude(double latitude) {
        mLatitude = latitude;
        mHasLatitude = true;
        // ---------- Original Method ----------
        //mLatitude = latitude;
        //mHasLatitude = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.033 -0400", hash_original_method = "4BCAF53DCD4CF7BB362561C1B9A79F13", hash_generated_method = "A8538AF0D6CB924252483A3546F1E7D2")
    public void clearLatitude() {
        mHasLatitude = false;
        // ---------- Original Method ----------
        //mHasLatitude = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.034 -0400", hash_original_method = "44F26BDA1ACBDD9862A3D8D8968B3507", hash_generated_method = "5C274098CD083A49F448EE8B593CAEC8")
    public boolean hasLongitude() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274790033 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_274790033;
        // ---------- Original Method ----------
        //return mHasLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.034 -0400", hash_original_method = "90E38F72A8C0EDFD5CFCC6EABD3BD432", hash_generated_method = "5780A14185F473EF0D5F18F5BC4D5A47")
    public double getLongitude() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        double varE8CD7DA078A86726031AD64F35F5A6C0_125556737 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_125556737;
        // ---------- Original Method ----------
        //if (mHasLongitude) {
            //return mLongitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.035 -0400", hash_original_method = "C4D556739F3557653F6C8D616289AA29", hash_generated_method = "C5F4A24BBD737E53F906B0B4B1241A26")
    public void setLongitude(double longitude) {
        mLongitude = longitude;
        mHasLongitude = true;
        // ---------- Original Method ----------
        //mLongitude = longitude;
        //mHasLongitude = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.049 -0400", hash_original_method = "D5786F30716C18CE0A0AB74556D12A22", hash_generated_method = "72D8B7051AF8F5D8AF738740565981D0")
    public void clearLongitude() {
        mHasLongitude = false;
        // ---------- Original Method ----------
        //mHasLongitude = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.051 -0400", hash_original_method = "EB9EE516F482EB01602422E9FA56CA5C", hash_generated_method = "9B38BD0E78B2A38D76AC11C0CFE4DD7B")
    public String getPhone() {
        String varB4EAC82CA7396A68D541C85D26508E83_1450565387 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1450565387 = mPhone;
        varB4EAC82CA7396A68D541C85D26508E83_1450565387.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1450565387;
        // ---------- Original Method ----------
        //return mPhone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.064 -0400", hash_original_method = "5023DDC820B0F6BE06303CFCE3A71EDF", hash_generated_method = "DE0BAA2F1475B12EBE7D57B9B6E7D336")
    public void setPhone(String phone) {
        mPhone = phone;
        // ---------- Original Method ----------
        //mPhone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.065 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "50AE007279F2D4B0979710E70B7FCB29")
    public String getUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_116842466 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_116842466 = mUrl;
        varB4EAC82CA7396A68D541C85D26508E83_116842466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_116842466;
        // ---------- Original Method ----------
        //return mUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.066 -0400", hash_original_method = "A94A57C3BD4A508E7FC3D69DE1774EEC", hash_generated_method = "4D2F926217B6FA5CE5A195400B3E7118")
    public void setUrl(String Url) {
        mUrl = Url;
        // ---------- Original Method ----------
        //mUrl = Url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.086 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "5BD31DE03138A1F35758ADD0E2CDEAB9")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_364733438 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_364733438 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_364733438.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_364733438;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.087 -0400", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "9B56A595B86963DFD04070AE7AE28FC1")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? null : new Bundle(extras);
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? null : new Bundle(extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.117 -0400", hash_original_method = "F2CDEB7D6ECCED8CC4C514EA700B26BB", hash_generated_method = "48DA6AFFC50FAFC533C683A944DD1259")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_327463031 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_327463031 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_327463031.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_327463031;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.119 -0400", hash_original_method = "2C347F4A4F86FFA77F246DC5FD21E5D6", hash_generated_method = "CF56AA5110D9651553E89D40B484340B")
    public int describeContents() {
        {
            Object varE627D80D86B1145CFBB6F925B58A1813_1827638160 = (mExtras.describeContents());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636954700 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636954700;
        // ---------- Original Method ----------
        //return (mExtras != null) ? mExtras.describeContents() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.399 -0400", hash_original_method = "609BCF0D5B324DA0FE8A594DDD7486F2", hash_generated_method = "31C37C294F291E7ED9130DC5CD39DE05")
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
                Iterator<Map.Entry<Integer, String>> var4B488CD82431A24A9834E463DFD78A58_111641459 = (entries).iterator();
                var4B488CD82431A24A9834E463DFD78A58_111641459.hasNext();
                Map.Entry<Integer, String> e = var4B488CD82431A24A9834E463DFD78A58_111641459.next();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.400 -0400", hash_original_field = "34AF13FB5BC8BAFBEC9B029562C77C94", hash_generated_field = "B4FB2F104B558E1CA23D02F180C08BB7")

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

