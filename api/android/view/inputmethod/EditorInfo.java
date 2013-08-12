package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Printer;





public class EditorInfo implements InputType, Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "846B06570EEBF02095D14F70E00224BE", hash_generated_field = "7A2525786FE6C2DC62A764834F216E95")

    public int inputType = TYPE_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "465BEB38845C2EA2DC5B833FDF9CFE8C", hash_generated_field = "B9721B4D0F8040EBEAFBDFD37833BD8A")

    public int imeOptions = IME_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "6B16DD61C043F1ABF04B3CA202C11042", hash_generated_field = "3D48A13615BEBAA577D3FC5619F56EAF")

    public String privateImeOptions = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "F0A18F181C3C17D69ED77897770C5DDC", hash_generated_field = "D6DC37304F82459EA8A6E2799E09D2F6")

    public CharSequence actionLabel = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "2E5B47205DFF7CB9851E161B5B39559D", hash_generated_field = "20C71B0087691E387C1AEDDC8E93E894")

    public int actionId = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "77F3458BE8E55993F071FFCC9D4221F4", hash_generated_field = "DCCD366C9A643215784258494A09792D")

    public int initialSelStart = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "42FE8B099E4B0639FA87EBAFA535F7DC", hash_generated_field = "C0C725B87DAD0525A96223FD3E49C578")

    public int initialSelEnd = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "C04A6E5228B9F86A4E9B16EB942BA76B", hash_generated_field = "CAEE083DDC412DC62EA0FC894E282993")

    public int initialCapsMode = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "BF076EF0259D98DFE4708348C517B931", hash_generated_field = "A8B74B40ED191D33A95BDDAAA2524E33")

    public CharSequence hintText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "D6BF9CF13073D3E7F28EBF190C9E996E")

    public CharSequence label;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "945100186B119048837B9859C2C46410", hash_generated_field = "BFAFEA72A8555503FBB4009F1BC7143B")

    public int fieldId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "972BF3F05D14FFBDB817BEF60638FF00", hash_generated_field = "439706DC030051976D6434490CA8908C")

    public String fieldName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

    public Bundle extras;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_method = "B9ADFD40DF801C34FF4D54782A68254E", hash_generated_method = "B9ADFD40DF801C34FF4D54782A68254E")
    public EditorInfo ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.353 -0400", hash_original_method = "3C6DC9D32EA44A62EDD92C5C9BF78DEF", hash_generated_method = "2E5A3009BA164BFB29FC5F9C34C9386D")
    public final void makeCompatible(int targetSdkVersion) {
        addTaint(targetSdkVersion);
        if(targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB)        
        {
switch(inputType&(TYPE_MASK_CLASS|TYPE_MASK_VARIATION)){
            case TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS:
            inputType = TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                            | (inputType&TYPE_MASK_FLAGS);
            break;
            case TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_WEB_PASSWORD:
            inputType = TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_PASSWORD
                            | (inputType&TYPE_MASK_FLAGS);
            break;
            case TYPE_CLASS_NUMBER|TYPE_NUMBER_VARIATION_NORMAL:
            case TYPE_CLASS_NUMBER|TYPE_NUMBER_VARIATION_PASSWORD:
            inputType = TYPE_CLASS_NUMBER
                            | (inputType&TYPE_MASK_FLAGS);
            break;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.354 -0400", hash_original_method = "52E48D457BDB05F3C0DFF77F15A840F2", hash_generated_method = "E80738BFFA87E4730747BCB67479186F")
    public void dump(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.355 -0400", hash_original_method = "0DCEB67BA2166B08F017930A62049273", hash_generated_method = "076D6EC104E83FBADF0F6938689FEE39")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.356 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4B0E9B46D8D3C5AA51BB42214F7F982A")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1711784384 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208736543 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208736543;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.356 -0400", hash_original_field = "5FD78E2C383B06167B26BAA8DEEC4F4E", hash_generated_field = "A9521826A0927A20AC089A01E6C4AF30")

    public static final int IME_MASK_ACTION = 0x000000ff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.356 -0400", hash_original_field = "B539D8FCD6980880D4365CECB9FA5302", hash_generated_field = "9BE4BD94ACB2423749B8E8051B7934F0")

    public static final int IME_ACTION_UNSPECIFIED = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.356 -0400", hash_original_field = "87FE49F92FE20E29A7BF8E23BC137273", hash_generated_field = "5A2F1C9F852DE43BD8B39570039086CD")

    public static final int IME_ACTION_NONE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.356 -0400", hash_original_field = "18AA5F35341E33780FBA4EC306708AA1", hash_generated_field = "6721350DD9F9DE697F392C5CA60BD321")

    public static final int IME_ACTION_GO = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.356 -0400", hash_original_field = "593177E453BEC10A692E5368A9DB8A3B", hash_generated_field = "A1475BB88746B9DC84FAE52A4FDFDAF5")

    public static final int IME_ACTION_SEARCH = 0x00000003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.356 -0400", hash_original_field = "4167E9B55CF63DFFCA9075D887E2B5AC", hash_generated_field = "05D8BA2A5D8C324C1C0E564DBA9CB823")

    public static final int IME_ACTION_SEND = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.356 -0400", hash_original_field = "FE77BE0D02CC591B35F0869ED8732BF4", hash_generated_field = "AF60C5287F9CFBB66AC8C023716DD5B3")

    public static final int IME_ACTION_NEXT = 0x00000005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.356 -0400", hash_original_field = "7BB60197BB5437BDB719F7BD899BFF97", hash_generated_field = "0C062F9E7A31E16074611D935372DAF6")

    public static final int IME_ACTION_DONE = 0x00000006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.357 -0400", hash_original_field = "6278BC058144A970D42194687460D290", hash_generated_field = "603FE0A6E9B8A3B4F0E3190179EA48BE")

    public static final int IME_ACTION_PREVIOUS = 0x00000007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.357 -0400", hash_original_field = "7AC9926669E99CE01F8348DB2213270B", hash_generated_field = "5FB13DC64A388E4F89C833A83CCE154C")

    public static final int IME_FLAG_NO_FULLSCREEN = 0x2000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.357 -0400", hash_original_field = "F155F11FD53FE3FB5285444C28191107", hash_generated_field = "3953A6A9F2FC4D29B446D76D0C347487")

    public static final int IME_FLAG_NAVIGATE_PREVIOUS = 0x4000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.357 -0400", hash_original_field = "C56B8E42DE72B50F053DC2E8DB31DAEF", hash_generated_field = "36A3C12115D9205A4ADA3234E5262F97")

    public static final int IME_FLAG_NAVIGATE_NEXT = 0x8000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.357 -0400", hash_original_field = "B219F8A2C2E60AAF2B089AF1ED55B467", hash_generated_field = "0D02B28480AA061F9EE5B50ADE7FE2D3")

    public static final int IME_FLAG_NO_EXTRACT_UI = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.357 -0400", hash_original_field = "40153389C792C56404A2658067902B2F", hash_generated_field = "DEF326CADF8E3A836BEC5A1393696AC8")

    public static final int IME_FLAG_NO_ACCESSORY_ACTION = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.357 -0400", hash_original_field = "754F39708063A7E3C0444A19CB8336E2", hash_generated_field = "7EC82B768AAD56B70C10BA24CCA16D0B")

    public static final int IME_FLAG_NO_ENTER_ACTION = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.357 -0400", hash_original_field = "1B5F994B6B063210D7580CD88AEDAFA0", hash_generated_field = "3A3A251668E89CBD127D44D9756AEC66")

    public static final int IME_NULL = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.358 -0400", hash_original_field = "1571425679A71C2B4E211351FA79417D", hash_generated_field = "1554B4BEF2704B75DF5E855F87FA4685")

    public static final Parcelable.Creator<EditorInfo> CREATOR = new Parcelable.Creator<EditorInfo>() {
        @DSModeled(DSC.SAFE)
        public EditorInfo createFromParcel(Parcel source) {
            EditorInfo res = new EditorInfo();
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
            return res;
        }

        @DSModeled(DSC.SAFE)
        public EditorInfo[] newArray(int size) {
            return new EditorInfo[size];
        }
    };
    // orphaned legacy method
    public EditorInfo createFromParcel(Parcel source) {
            EditorInfo res = new EditorInfo();
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
            return res;
        }
    
    // orphaned legacy method
    public EditorInfo[] newArray(int size) {
            return new EditorInfo[size];
        }
    
}

