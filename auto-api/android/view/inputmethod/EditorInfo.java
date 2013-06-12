package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Printer;

public class EditorInfo implements InputType, Parcelable {
    public int inputType = TYPE_NULL;
    public static final int IME_MASK_ACTION = 0x000000ff;
    public static final int IME_ACTION_UNSPECIFIED = 0x00000000;
    public static final int IME_ACTION_NONE = 0x00000001;
    public static final int IME_ACTION_GO = 0x00000002;
    public static final int IME_ACTION_SEARCH = 0x00000003;
    public static final int IME_ACTION_SEND = 0x00000004;
    public static final int IME_ACTION_NEXT = 0x00000005;
    public static final int IME_ACTION_DONE = 0x00000006;
    public static final int IME_ACTION_PREVIOUS = 0x00000007;
    public static final int IME_FLAG_NO_FULLSCREEN = 0x2000000;
    public static final int IME_FLAG_NAVIGATE_PREVIOUS = 0x4000000;
    public static final int IME_FLAG_NAVIGATE_NEXT = 0x8000000;
    public static final int IME_FLAG_NO_EXTRACT_UI = 0x10000000;
    public static final int IME_FLAG_NO_ACCESSORY_ACTION = 0x20000000;
    public static final int IME_FLAG_NO_ENTER_ACTION = 0x40000000;
    public static final int IME_NULL = 0x00000000;
    public int imeOptions = IME_NULL;
    public String privateImeOptions = null;
    public CharSequence actionLabel = null;
    public int actionId = 0;
    public int initialSelStart = -1;
    public int initialSelEnd = -1;
    public int initialCapsMode = 0;
    public CharSequence hintText;
    public CharSequence label;
    public String packageName;
    public int fieldId;
    public String fieldName;
    public Bundle extras;
    public static final Parcelable.Creator<EditorInfo> CREATOR = new Parcelable.Creator<EditorInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.075 -0400", hash_original_method = "AD6DC78DBEA1B193A565639E1F90B5B3", hash_generated_method = "0F25D0BDA141B101C01A724956112049")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public EditorInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            EditorInfo res;
            res = new EditorInfo();
            res.inputType = source.readInt();
            res.imeOptions = source.readInt();
            res.privateImeOptions = source.readString();
            res.actionLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.actionId = source.readInt();
            res.initialSelStart = source.readInt();
            res.initialSelEnd = source.readInt();
            res.initialCapsMode = source.readInt();
            res.hintText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.label = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.packageName = source.readString();
            res.fieldId = source.readInt();
            res.fieldName = source.readString();
            res.extras = source.readBundle();
            return (EditorInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.075 -0400", hash_original_method = "E8A969BD7C499BCF878E62F3B3C9E071", hash_generated_method = "0D07D9C92AA303A513839156A5B396DE")
        @DSModeled(DSC.SAFE)
        public EditorInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (EditorInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new EditorInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.075 -0400", hash_original_method = "3C6DC9D32EA44A62EDD92C5C9BF78DEF", hash_generated_method = "65373E1B1BEA161F7D8BAD62750AEFE7")
    @DSModeled(DSC.SAFE)
    public final void makeCompatible(int targetSdkVersion) {
        dsTaint.addTaint(targetSdkVersion);
        {
            //Begin case TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS 
            inputType = TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                            | (inputType&TYPE_MASK_FLAGS);
            //End case TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS 
            //Begin case TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_WEB_PASSWORD 
            inputType = TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_PASSWORD
                            | (inputType&TYPE_MASK_FLAGS);
            //End case TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_WEB_PASSWORD 
            //Begin case TYPE_CLASS_NUMBER|TYPE_NUMBER_VARIATION_NORMAL TYPE_CLASS_NUMBER|TYPE_NUMBER_VARIATION_PASSWORD 
            inputType = TYPE_CLASS_NUMBER
                            | (inputType&TYPE_MASK_FLAGS);
            //End case TYPE_CLASS_NUMBER|TYPE_NUMBER_VARIATION_NORMAL TYPE_CLASS_NUMBER|TYPE_NUMBER_VARIATION_PASSWORD 
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.075 -0400", hash_original_method = "52E48D457BDB05F3C0DFF77F15A840F2", hash_generated_method = "530856637886A9CB1C0462168BEF46E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        pw.println(prefix + "inputType=0x" + Integer.toHexString(inputType)
                + " imeOptions=0x" + Integer.toHexString(imeOptions)
                + " privateImeOptions=" + privateImeOptions);
        pw.println(prefix + "actionLabel=" + actionLabel
                + " actionId=" + actionId);
        pw.println(prefix + "initialSelStart=" + initialSelStart
                + " initialSelEnd=" + initialSelEnd
                + " initialCapsMode=0x"
                + Integer.toHexString(initialCapsMode));
        pw.println(prefix + "hintText=" + hintText
                + " label=" + label);
        pw.println(prefix + "packageName=" + packageName
                + " fieldId=" + fieldId
                + " fieldName=" + fieldName);
        pw.println(prefix + "extras=" + extras);
        // ---------- Original Method ----------
        //pw.println(prefix + "inputType=0x" + Integer.toHexString(inputType)
                //+ " imeOptions=0x" + Integer.toHexString(imeOptions)
                //+ " privateImeOptions=" + privateImeOptions);
        //pw.println(prefix + "actionLabel=" + actionLabel
                //+ " actionId=" + actionId);
        //pw.println(prefix + "initialSelStart=" + initialSelStart
                //+ " initialSelEnd=" + initialSelEnd
                //+ " initialCapsMode=0x"
                //+ Integer.toHexString(initialCapsMode));
        //pw.println(prefix + "hintText=" + hintText
                //+ " label=" + label);
        //pw.println(prefix + "packageName=" + packageName
                //+ " fieldId=" + fieldId
                //+ " fieldName=" + fieldName);
        //pw.println(prefix + "extras=" + extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.076 -0400", hash_original_method = "0DCEB67BA2166B08F017930A62049273", hash_generated_method = "8BD965F5FDFA5B0EAE4EB9828035AF81")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(inputType);
        dest.writeInt(imeOptions);
        dest.writeString(privateImeOptions);
        TextUtils.writeToParcel(actionLabel, dest, flags);
        dest.writeInt(actionId);
        dest.writeInt(initialSelStart);
        dest.writeInt(initialSelEnd);
        dest.writeInt(initialCapsMode);
        TextUtils.writeToParcel(hintText, dest, flags);
        TextUtils.writeToParcel(label, dest, flags);
        dest.writeString(packageName);
        dest.writeInt(fieldId);
        dest.writeString(fieldName);
        dest.writeBundle(extras);
        // ---------- Original Method ----------
        //dest.writeInt(inputType);
        //dest.writeInt(imeOptions);
        //dest.writeString(privateImeOptions);
        //TextUtils.writeToParcel(actionLabel, dest, flags);
        //dest.writeInt(actionId);
        //dest.writeInt(initialSelStart);
        //dest.writeInt(initialSelEnd);
        //dest.writeInt(initialCapsMode);
        //TextUtils.writeToParcel(hintText, dest, flags);
        //TextUtils.writeToParcel(label, dest, flags);
        //dest.writeString(packageName);
        //dest.writeInt(fieldId);
        //dest.writeString(fieldName);
        //dest.writeBundle(extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.076 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
}


