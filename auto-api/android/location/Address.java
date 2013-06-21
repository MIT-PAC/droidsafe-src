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
    private Locale mLocale;
    private String mFeatureName;
    private HashMap<Integer, String> mAddressLines;
    private int mMaxAddressLineIndex = -1;
    private String mAdminArea;
    private String mSubAdminArea;
    private String mLocality;
    private String mSubLocality;
    private String mThoroughfare;
    private String mSubThoroughfare;
    private String mPremises;
    private String mPostalCode;
    private String mCountryCode;
    private String mCountryName;
    private double mLatitude;
    private double mLongitude;
    private boolean mHasLatitude = false;
    private boolean mHasLongitude = false;
    private String mPhone;
    private String mUrl;
    private Bundle mExtras = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.468 -0400", hash_original_method = "8C8D8A006008D0E9588030A46EE6B5B9", hash_generated_method = "2FD64ED0E7D16B33D1008EF7C141A5F5")
    @DSModeled(DSC.SAFE)
    public Address(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        // ---------- Original Method ----------
        //mLocale = locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.469 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "86D85F4533F23F6C8349F9F12D00A3F1")
    @DSModeled(DSC.SAFE)
    public Locale getLocale() {
        return (Locale)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.470 -0400", hash_original_method = "E1E6237F606789C7A5294059179DF025", hash_generated_method = "60B6F0AC5CDF08DA2B92EC64630DC6BD")
    @DSModeled(DSC.SAFE)
    public int getMaxAddressLineIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaxAddressLineIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.471 -0400", hash_original_method = "D824FE2CFE40DB25058DC1465F2D4439", hash_generated_method = "BFDFB2EB3F14719595E5BA44754019AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAddressLine(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("index = " + index + " < 0");
        } //End block
        {
            Object var3BA249A0FC4112AF0254AAFDDC1CEA6C_116731691 = (mAddressLines.get(index));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IllegalArgumentException("index = " + index + " < 0");
        //}
        //return mAddressLines == null? null :  mAddressLines.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.476 -0400", hash_original_method = "5C23144E8A22EAB5D8930884A1255DAC", hash_generated_method = "FD0BE91DE3292F48D13BEFA1BFCE6FE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAddressLine(int index, String line) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(line);
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
                Iterator<Integer> var11CB2090D7C1AE4D5F6497E3F769BE3A_1732228209 = (mAddressLines.keySet()).iterator();
                var11CB2090D7C1AE4D5F6497E3F769BE3A_1732228209.hasNext();
                Integer i = var11CB2090D7C1AE4D5F6497E3F769BE3A_1732228209.next();
                {
                    mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, i);
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.476 -0400", hash_original_method = "D108F727B4ED1E44A68F4DDDAA8864A4", hash_generated_method = "EF7C33DE539918C211FE96E91C370D18")
    @DSModeled(DSC.SAFE)
    public String getFeatureName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFeatureName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.477 -0400", hash_original_method = "49225B599976EB86160DDAF83CE5BC7F", hash_generated_method = "0A9C34C76C50F3CAC12F34E4BC6AFEAF")
    @DSModeled(DSC.SAFE)
    public void setFeatureName(String featureName) {
        dsTaint.addTaint(featureName);
        // ---------- Original Method ----------
        //mFeatureName = featureName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.477 -0400", hash_original_method = "EDE4D65E7936029E84B8376D150F4DDE", hash_generated_method = "26FF4A684286564AB4CE8C381CFC70BA")
    @DSModeled(DSC.SAFE)
    public String getAdminArea() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAdminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.477 -0400", hash_original_method = "C8D449D9A4FBB2AF83806F488A8CAC1C", hash_generated_method = "1AF73FEF3E71DA77E211D56800858BC6")
    @DSModeled(DSC.SAFE)
    public void setAdminArea(String adminArea) {
        dsTaint.addTaint(adminArea);
        // ---------- Original Method ----------
        //this.mAdminArea = adminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.477 -0400", hash_original_method = "84D73E83BF1D1209648491141222963A", hash_generated_method = "709A450D55E54A4B8AE56F2B2CE3AA55")
    @DSModeled(DSC.SAFE)
    public String getSubAdminArea() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubAdminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.478 -0400", hash_original_method = "4DF91F489D35ACCA2DC2AF8A5398BD9E", hash_generated_method = "2141D8FAED19732DDF286675F5C792BF")
    @DSModeled(DSC.SAFE)
    public void setSubAdminArea(String subAdminArea) {
        dsTaint.addTaint(subAdminArea);
        // ---------- Original Method ----------
        //this.mSubAdminArea = subAdminArea;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.478 -0400", hash_original_method = "3743C626E0A5809CC359BBE60C0BEF8D", hash_generated_method = "0C19ABF697DC344769F4C4C5B1144201")
    @DSModeled(DSC.SAFE)
    public String getLocality() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLocality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.478 -0400", hash_original_method = "E848A60937105A6FB0F90F11784FAFAB", hash_generated_method = "2C083FEC3E183523C6D3B646296C0738")
    @DSModeled(DSC.SAFE)
    public void setLocality(String locality) {
        dsTaint.addTaint(locality);
        // ---------- Original Method ----------
        //mLocality = locality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.478 -0400", hash_original_method = "4565445A715D9E082E3330822780EE14", hash_generated_method = "41FCFADE5E40B610DD7D4E545D674C73")
    @DSModeled(DSC.SAFE)
    public String getSubLocality() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubLocality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.479 -0400", hash_original_method = "FBC28BB3F834CBCC388544379D8FF1EB", hash_generated_method = "77432C72956D3A6231B55B6BC22B5ED4")
    @DSModeled(DSC.SAFE)
    public void setSubLocality(String sublocality) {
        dsTaint.addTaint(sublocality);
        // ---------- Original Method ----------
        //mSubLocality = sublocality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.479 -0400", hash_original_method = "1512262039F5521B933A04882815530C", hash_generated_method = "AC620796545E27FA4AC8A295C413A80C")
    @DSModeled(DSC.SAFE)
    public String getThoroughfare() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mThoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.480 -0400", hash_original_method = "30509B10242C2769144E7C2C070721FD", hash_generated_method = "78614BCCD126468ED91CFA4D6BA7AF40")
    @DSModeled(DSC.SAFE)
    public void setThoroughfare(String thoroughfare) {
        dsTaint.addTaint(thoroughfare);
        // ---------- Original Method ----------
        //this.mThoroughfare = thoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.480 -0400", hash_original_method = "8EFF44F66BA44D813DFBCA9FC34B8EF5", hash_generated_method = "38C52D662C9C1A68FFF19BCDA5AF8E00")
    @DSModeled(DSC.SAFE)
    public String getSubThoroughfare() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubThoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.480 -0400", hash_original_method = "ED99ECE32AF3E65AA637AE926CEFB8FE", hash_generated_method = "98C9041C468EFD78A047AC6C54A14ECB")
    @DSModeled(DSC.SAFE)
    public void setSubThoroughfare(String subthoroughfare) {
        dsTaint.addTaint(subthoroughfare);
        // ---------- Original Method ----------
        //this.mSubThoroughfare = subthoroughfare;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.480 -0400", hash_original_method = "C1BF40685BD6E248364BFB485F611555", hash_generated_method = "C5D79A587137731ABDBBCE34EC140132")
    @DSModeled(DSC.SAFE)
    public String getPremises() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPremises;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.481 -0400", hash_original_method = "C9E9B1B8FA21E47AD4B139D64075E36A", hash_generated_method = "AF81974F86CDCA2E6EF701851728AE1B")
    @DSModeled(DSC.SAFE)
    public void setPremises(String premises) {
        dsTaint.addTaint(premises);
        // ---------- Original Method ----------
        //mPremises = premises;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.481 -0400", hash_original_method = "9B5379769D21EFABDDB2785674C4DE4D", hash_generated_method = "DFE01BD1A671E2B1B97AAB81110857C6")
    @DSModeled(DSC.SAFE)
    public String getPostalCode() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPostalCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.481 -0400", hash_original_method = "21CF31250DB9EF4FD9B8F171A3FE8B16", hash_generated_method = "13FB3BCA0C4BF571DA95ACA5F5E795A7")
    @DSModeled(DSC.SAFE)
    public void setPostalCode(String postalCode) {
        dsTaint.addTaint(postalCode);
        // ---------- Original Method ----------
        //mPostalCode = postalCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.481 -0400", hash_original_method = "E8D66F74FB4E1AF79CCB258931950FBE", hash_generated_method = "3E1625D5D96F5FC49FEA4C417BCCBB73")
    @DSModeled(DSC.SAFE)
    public String getCountryCode() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCountryCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.482 -0400", hash_original_method = "DD5F97427C040B47F9123BA4F8DC93A2", hash_generated_method = "FEDABC787AEF39C61C6362DD2899907F")
    @DSModeled(DSC.SAFE)
    public void setCountryCode(String countryCode) {
        dsTaint.addTaint(countryCode);
        // ---------- Original Method ----------
        //mCountryCode = countryCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.482 -0400", hash_original_method = "A82A5DCEE67796EF014C1F79656EFD25", hash_generated_method = "3A202333AA0475AAF961FE719F8E3C96")
    @DSModeled(DSC.SAFE)
    public String getCountryName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCountryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.482 -0400", hash_original_method = "F7767E8D2EF25B1D1399497900992B14", hash_generated_method = "E3B854FF4E008D1F3E17A227738020A4")
    @DSModeled(DSC.SAFE)
    public void setCountryName(String countryName) {
        dsTaint.addTaint(countryName);
        // ---------- Original Method ----------
        //mCountryName = countryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.482 -0400", hash_original_method = "AB4D7FB4B745E9B023209032D37DF18F", hash_generated_method = "1AEE71E10DF7184B9E154D6EAE38693A")
    @DSModeled(DSC.SAFE)
    public boolean hasLatitude() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasLatitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.483 -0400", hash_original_method = "74A963FE4AC8482F316E1B3E19ABA2D8", hash_generated_method = "9A2B519536AE666AD203918EB51E4F1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getLatitude() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //if (mHasLatitude) {
            //return mLatitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.483 -0400", hash_original_method = "E7EB84DA300898C528161A7CBF9FB7F9", hash_generated_method = "BF19988BD060473C13A2E4A901B377AE")
    @DSModeled(DSC.SAFE)
    public void setLatitude(double latitude) {
        dsTaint.addTaint(latitude);
        mHasLatitude = true;
        // ---------- Original Method ----------
        //mLatitude = latitude;
        //mHasLatitude = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.483 -0400", hash_original_method = "4BCAF53DCD4CF7BB362561C1B9A79F13", hash_generated_method = "A8538AF0D6CB924252483A3546F1E7D2")
    @DSModeled(DSC.SAFE)
    public void clearLatitude() {
        mHasLatitude = false;
        // ---------- Original Method ----------
        //mHasLatitude = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.483 -0400", hash_original_method = "44F26BDA1ACBDD9862A3D8D8968B3507", hash_generated_method = "B85DCD917462B43358FB04558581F2B1")
    @DSModeled(DSC.SAFE)
    public boolean hasLongitude() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.484 -0400", hash_original_method = "90E38F72A8C0EDFD5CFCC6EABD3BD432", hash_generated_method = "D1FF9258EBD7492C05E79EF3F9AE9A93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getLongitude() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //if (mHasLongitude) {
            //return mLongitude;
        //} else {
            //throw new IllegalStateException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.484 -0400", hash_original_method = "C4D556739F3557653F6C8D616289AA29", hash_generated_method = "931920685792086380BC8F9C31DA2D60")
    @DSModeled(DSC.SAFE)
    public void setLongitude(double longitude) {
        dsTaint.addTaint(longitude);
        mHasLongitude = true;
        // ---------- Original Method ----------
        //mLongitude = longitude;
        //mHasLongitude = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.486 -0400", hash_original_method = "D5786F30716C18CE0A0AB74556D12A22", hash_generated_method = "72D8B7051AF8F5D8AF738740565981D0")
    @DSModeled(DSC.SAFE)
    public void clearLongitude() {
        mHasLongitude = false;
        // ---------- Original Method ----------
        //mHasLongitude = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.487 -0400", hash_original_method = "EB9EE516F482EB01602422E9FA56CA5C", hash_generated_method = "AFF2A2880018FCE3471F4331AC7308C9")
    @DSModeled(DSC.SAFE)
    public String getPhone() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.487 -0400", hash_original_method = "5023DDC820B0F6BE06303CFCE3A71EDF", hash_generated_method = "835AAFB78E777F8893076749B11319E9")
    @DSModeled(DSC.SAFE)
    public void setPhone(String phone) {
        dsTaint.addTaint(phone);
        // ---------- Original Method ----------
        //mPhone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.488 -0400", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "ACFE25042C24F54739138D52C59239EC")
    @DSModeled(DSC.SAFE)
    public String getUrl() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.488 -0400", hash_original_method = "A94A57C3BD4A508E7FC3D69DE1774EEC", hash_generated_method = "762569607F1F6BEB00BC9EF792917C27")
    @DSModeled(DSC.SAFE)
    public void setUrl(String Url) {
        dsTaint.addTaint(Url);
        // ---------- Original Method ----------
        //mUrl = Url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.488 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "5467DB301C93271E15B2B85B3DDE4C93")
    @DSModeled(DSC.SAFE)
    public Bundle getExtras() {
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.488 -0400", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "A3FFA91E304602A791B523817C96CBA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        mExtras = (extras == null) ? null : new Bundle(extras);
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? null : new Bundle(extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.489 -0400", hash_original_method = "F2CDEB7D6ECCED8CC4C514EA700B26BB", hash_generated_method = "EAB6CE459A92EFBC804B5507879A8C5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String var806458D832AB974D230FEE4CBBDBD390_891020483 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.490 -0400", hash_original_method = "2C347F4A4F86FFA77F246DC5FD21E5D6", hash_generated_method = "9D42B7B24BEBEB17C71108C3205EDC42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int describeContents() {
        {
            Object varE627D80D86B1145CFBB6F925B58A1813_1769251790 = (mExtras.describeContents());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mExtras != null) ? mExtras.describeContents() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.501 -0400", hash_original_method = "609BCF0D5B324DA0FE8A594DDD7486F2", hash_generated_method = "1346ABBCB1BED90D86757F5082E25AE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
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
                Iterator<Map.Entry<Integer, String>> var4B488CD82431A24A9834E463DFD78A58_392561965 = (entries).iterator();
                var4B488CD82431A24A9834E463DFD78A58_392561965.hasNext();
                Map.Entry<Integer, String> e = var4B488CD82431A24A9834E463DFD78A58_392561965.next();
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.503 -0400", hash_original_method = "9DD3D24D0AAD4627E69FB2E9DF778B8A", hash_generated_method = "6B3BD944FBD59800EC9E716DC1E29A14")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Address createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            String language;
            language = in.readString();
            String country;
            country = in.readString();
            Locale locale;
            boolean varD5F83AB8F574BF3D8582B345A3B7E8E0_66273986 = (country.length() > 0);
            locale = new Locale(language, country);
            locale = new Locale(language);
            Address a;
            a = new Address(locale);
            int N;
            N = in.readInt();
            {
                a.mAddressLines = new HashMap<Integer, String>(N);
                {
                    int i;
                    i = 0;
                    {
                        int index;
                        index = in.readInt();
                        String line;
                        line = in.readString();
                        a.mAddressLines.put(index, line);
                        a.mMaxAddressLineIndex =
                        Math.max(a.mMaxAddressLineIndex, index);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                a.mAddressLines = null;
                a.mMaxAddressLineIndex = -1;
            } //End block
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
            {
                a.mLatitude = in.readDouble();
            } //End block
            a.mHasLongitude = in.readInt() == 0 ? false : true;
            {
                a.mLongitude = in.readDouble();
            } //End block
            a.mPhone = in.readString();
            a.mUrl = in.readString();
            a.mExtras = in.readBundle();
            return (Address)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.503 -0400", hash_original_method = "814279382DFD395E3EB63F703FD02AFD", hash_generated_method = "294F342EC86681B0C4BCBFE681EDDB53")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Address[] newArray(int size) {
            dsTaint.addTaint(size);
            Address[] var99F32363C9344C97C6FA1CA5070CD3BE_2127008422 = (new Address[size]);
            return (Address[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Address[size];
        }

        
}; //Transformed anonymous class
}

