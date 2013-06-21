package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Printer;

public class EditorInfo implements InputType, Parcelable {
    public int inputType = TYPE_NULL;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.289 -0400", hash_original_method = "22B35467D359BDE3D3089C864C46305C", hash_generated_method = "22B35467D359BDE3D3089C864C46305C")
        public EditorInfo ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.290 -0400", hash_original_method = "3C6DC9D32EA44A62EDD92C5C9BF78DEF", hash_generated_method = "EAA0B2DFD8F877014A5A4BAF1205798B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.291 -0400", hash_original_method = "52E48D457BDB05F3C0DFF77F15A840F2", hash_generated_method = "DEDBE4B97CEA6995A35EEA9A598D3644")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.291 -0400", hash_original_method = "0DCEB67BA2166B08F017930A62049273", hash_generated_method = "F031C640A1AA5D4CCD0DC16EE5E303F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.292 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
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
    public static final Parcelable.Creator<EditorInfo> CREATOR = new Parcelable.Creator<EditorInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.292 -0400", hash_original_method = "AD6DC78DBEA1B193A565639E1F90B5B3", hash_generated_method = "EC1FC941E3929979759BD04A10C4225F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.292 -0400", hash_original_method = "E8A969BD7C499BCF878E62F3B3C9E071", hash_generated_method = "D7239620ADA9FDBCB026F45F846E1D94")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public EditorInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            EditorInfo[] varBEEA9F0CA37B4A74BDD928E161D1FBC0_1596723029 = (new EditorInfo[size]);
            return (EditorInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new EditorInfo[size];
        }

        
}; //Transformed anonymous class
}

