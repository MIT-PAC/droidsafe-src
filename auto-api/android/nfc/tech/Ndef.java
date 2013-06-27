package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.nfc.ErrorCodes;
import android.nfc.FormatException;
import android.nfc.INfcTag;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class Ndef extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.609 -0400", hash_original_field = "86DEF057D6C153F9465C3DFD099AF5F7", hash_generated_field = "147ADCC633068E8F332A302E1540AD62")

    private int mMaxNdefSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.609 -0400", hash_original_field = "B5278EC7E3332C34F3E9480E899A5F4E", hash_generated_field = "C0E8A71CC004D481AAC21A06997161CB")

    private int mCardState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.609 -0400", hash_original_field = "BB0E2A602300B19A643B3ECA78FFBDB4", hash_generated_field = "B3FEA61CE75C91D3B77101D5899B2CCA")

    private NdefMessage mNdefMsg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.609 -0400", hash_original_field = "1831557E43D4B2CB9A9C35FD125E5D44", hash_generated_field = "5C9298B1E249A04AB9B947E9A8D2BBE2")

    private int mNdefType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.616 -0400", hash_original_method = "F00E44EC8DF6B41B74270E57D440DE27", hash_generated_method = "BD45BD76C6E5B59D54415EA0D4EAFCEA")
    public  Ndef(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NDEF);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.NDEF);
        {
            mMaxNdefSize = extras.getInt(EXTRA_NDEF_MAXLENGTH);
            mCardState = extras.getInt(EXTRA_NDEF_CARDSTATE);
            mNdefMsg = extras.getParcelable(EXTRA_NDEF_MSG);
            mNdefType = extras.getInt(EXTRA_NDEF_TYPE);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("NDEF tech extras are null.");
        } //End block
        addTaint(tag.getTaint());
        // ---------- Original Method ----------
        //Bundle extras = tag.getTechExtras(TagTechnology.NDEF);
        //if (extras != null) {
            //mMaxNdefSize = extras.getInt(EXTRA_NDEF_MAXLENGTH);
            //mCardState = extras.getInt(EXTRA_NDEF_CARDSTATE);
            //mNdefMsg = extras.getParcelable(EXTRA_NDEF_MSG);
            //mNdefType = extras.getInt(EXTRA_NDEF_TYPE);
        //} else {
            //throw new NullPointerException("NDEF tech extras are null.");
        //}
    }

    
        public static Ndef get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NDEF)) return null;
        try {
            return new Ndef(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.618 -0400", hash_original_method = "522E1BD05C0F58597909DF2D37B1E51E", hash_generated_method = "1E429593892791AB549F977BA40048CC")
    public NdefMessage getCachedNdefMessage() {
        NdefMessage varB4EAC82CA7396A68D541C85D26508E83_531363291 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_531363291 = mNdefMsg;
        varB4EAC82CA7396A68D541C85D26508E83_531363291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_531363291;
        // ---------- Original Method ----------
        //return mNdefMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.636 -0400", hash_original_method = "A8A4A8CA63E3E206537FB1A4A1A58DE6", hash_generated_method = "FE7F1047316C8FA8E9399239C680D284")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1771659667 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1862283709 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_494665140 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1933200158 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_880004114 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_828717453 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_647935445 = null; //Variable for return #7
        //Begin case TYPE_1 
        varB4EAC82CA7396A68D541C85D26508E83_1771659667 = NFC_FORUM_TYPE_1;
        //End case TYPE_1 
        //Begin case TYPE_2 
        varB4EAC82CA7396A68D541C85D26508E83_1862283709 = NFC_FORUM_TYPE_2;
        //End case TYPE_2 
        //Begin case TYPE_3 
        varB4EAC82CA7396A68D541C85D26508E83_494665140 = NFC_FORUM_TYPE_3;
        //End case TYPE_3 
        //Begin case TYPE_4 
        varB4EAC82CA7396A68D541C85D26508E83_1933200158 = NFC_FORUM_TYPE_4;
        //End case TYPE_4 
        //Begin case TYPE_MIFARE_CLASSIC 
        varB4EAC82CA7396A68D541C85D26508E83_880004114 = MIFARE_CLASSIC;
        //End case TYPE_MIFARE_CLASSIC 
        //Begin case TYPE_ICODE_SLI 
        varB4EAC82CA7396A68D541C85D26508E83_828717453 = ICODE_SLI;
        //End case TYPE_ICODE_SLI 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_647935445 = UNKNOWN;
        //End case default 
        String varA7E53CE21691AB073D9660D615818899_193826603; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_193826603 = varB4EAC82CA7396A68D541C85D26508E83_1771659667;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_193826603 = varB4EAC82CA7396A68D541C85D26508E83_1862283709;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_193826603 = varB4EAC82CA7396A68D541C85D26508E83_494665140;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_193826603 = varB4EAC82CA7396A68D541C85D26508E83_1933200158;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_193826603 = varB4EAC82CA7396A68D541C85D26508E83_880004114;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_193826603 = varB4EAC82CA7396A68D541C85D26508E83_828717453;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_193826603 = varB4EAC82CA7396A68D541C85D26508E83_647935445;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_193826603.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_193826603;
        // ---------- Original Method ----------
        //switch (mNdefType) {
            //case TYPE_1:
                //return NFC_FORUM_TYPE_1;
            //case TYPE_2:
                //return NFC_FORUM_TYPE_2;
            //case TYPE_3:
                //return NFC_FORUM_TYPE_3;
            //case TYPE_4:
                //return NFC_FORUM_TYPE_4;
            //case TYPE_MIFARE_CLASSIC:
                //return MIFARE_CLASSIC;
            //case TYPE_ICODE_SLI:
                //return ICODE_SLI;
            //default:
                //return UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.637 -0400", hash_original_method = "4EADEE4A8AA14EA957D69BF1EB117D34", hash_generated_method = "E779D2303587F181E062B45B45898ED8")
    public int getMaxSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143565645 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143565645;
        // ---------- Original Method ----------
        //return mMaxNdefSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.637 -0400", hash_original_method = "9C15355B29C0704385FAC8BA222CAFE7", hash_generated_method = "4D37A99592313220C2C6643CAD7395D4")
    public boolean isWritable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1594470533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1594470533;
        // ---------- Original Method ----------
        //return (mCardState == NDEF_MODE_READ_WRITE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.646 -0400", hash_original_method = "A26F5401571035886FCD1ABC90F65CF6", hash_generated_method = "79AB36A859E903903B16561D255B67E0")
    public NdefMessage getNdefMessage() throws IOException, FormatException {
        NdefMessage varB4EAC82CA7396A68D541C85D26508E83_307239795 = null; //Variable for return #1
        NdefMessage varB4EAC82CA7396A68D541C85D26508E83_1156729514 = null; //Variable for return #2
        NdefMessage varB4EAC82CA7396A68D541C85D26508E83_1190369833 = null; //Variable for return #3
        checkConnected();
        try 
        {
            INfcTag tagService;
            tagService = mTag.getTagService();
            int serviceHandle;
            serviceHandle = mTag.getServiceHandle();
            {
                boolean var9E38A8733EA654A0B89FA7D8640BC718_1919624599 = (tagService.isNdef(serviceHandle));
                {
                    NdefMessage msg;
                    msg = tagService.ndefRead(serviceHandle);
                    {
                        int errorCode;
                        errorCode = tagService.getLastError(serviceHandle);
                        //Begin case ErrorCodes.ERROR_IO 
                        if (DroidSafeAndroidRuntime.control) throw new IOException();
                        //End case ErrorCodes.ERROR_IO 
                        //Begin case ErrorCodes.ERROR_INVALID_PARAM 
                        if (DroidSafeAndroidRuntime.control) throw new FormatException();
                        //End case ErrorCodes.ERROR_INVALID_PARAM 
                        //Begin case default 
                        if (DroidSafeAndroidRuntime.control) throw new IOException();
                        //End case default 
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_307239795 = msg;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1156729514 = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1190369833 = null;
        } //End block
        NdefMessage varA7E53CE21691AB073D9660D615818899_1716918138; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1716918138 = varB4EAC82CA7396A68D541C85D26508E83_307239795;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1716918138 = varB4EAC82CA7396A68D541C85D26508E83_1156729514;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1716918138 = varB4EAC82CA7396A68D541C85D26508E83_1190369833;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1716918138.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1716918138;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.647 -0400", hash_original_method = "A66DE5F0B266681092CD198588C2EDA0", hash_generated_method = "1745467C5217C2DE3FCA248353C94448")
    public void writeNdefMessage(NdefMessage msg) throws IOException, FormatException {
        checkConnected();
        try 
        {
            INfcTag tagService;
            tagService = mTag.getTagService();
            int serviceHandle;
            serviceHandle = mTag.getServiceHandle();
            {
                boolean var9E38A8733EA654A0B89FA7D8640BC718_48466968 = (tagService.isNdef(serviceHandle));
                {
                    int errorCode;
                    errorCode = tagService.ndefWrite(serviceHandle, msg);
                    //Begin case ErrorCodes.ERROR_IO 
                    if (DroidSafeAndroidRuntime.control) throw new IOException();
                    //End case ErrorCodes.ERROR_IO 
                    //Begin case ErrorCodes.ERROR_INVALID_PARAM 
                    if (DroidSafeAndroidRuntime.control) throw new FormatException();
                    //End case ErrorCodes.ERROR_INVALID_PARAM 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new IOException();
                    //End case default 
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Tag is not ndef");
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        { }
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.648 -0400", hash_original_method = "7292FD9562AEE851073EE82DFE58EB20", hash_generated_method = "4DA6D0FDC180F9765C8705D56B281F53")
    public boolean canMakeReadOnly() {
        INfcTag tagService;
        tagService = mTag.getTagService();
        try 
        {
            boolean var23592AA0406DB9179A6CBAB847B3EF44_975804153 = (tagService.canMakeReadOnly(mNdefType));
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_420277667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_420277667;
        // ---------- Original Method ----------
        //INfcTag tagService = mTag.getTagService();
        //try {
            //return tagService.canMakeReadOnly(mNdefType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.664 -0400", hash_original_method = "4D610B9041279D39FD5203194F60B421", hash_generated_method = "E28F09106A2F39F287C38962D9F13FEB")
    public boolean makeReadOnly() throws IOException {
        checkConnected();
        try 
        {
            INfcTag tagService;
            tagService = mTag.getTagService();
            {
                boolean var38FC7228924773AA962BF2A0475BE6CE_1144666761 = (tagService.isNdef(mTag.getServiceHandle()));
                {
                    int errorCode;
                    errorCode = tagService.ndefMakeReadOnly(mTag.getServiceHandle());
                    //Begin case ErrorCodes.ERROR_IO 
                    if (DroidSafeAndroidRuntime.control) throw new IOException();
                    //End case ErrorCodes.ERROR_IO 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new IOException();
                    //End case default 
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Tag is not ndef");
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241597094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241597094;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.667 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "75254E4C21911FCCBBD25490236328DA")

    private static String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.667 -0400", hash_original_field = "A2AB745B5F82024F458B901908B3AD29", hash_generated_field = "5DBF9CCE6E13B976C8A1637F644EF8AF")

    public static final int NDEF_MODE_READ_ONLY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.667 -0400", hash_original_field = "CA9A1EADBFD22C8FAE378F77A7CB2989", hash_generated_field = "9AF473C2877E6CEDA9FDC11F4F5C6B13")

    public static final int NDEF_MODE_READ_WRITE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.667 -0400", hash_original_field = "6C6D6C827464E7E412E528EAE110B2F2", hash_generated_field = "5D6A58E2CFE31E870DD9ECCB6CB28BCF")

    public static final int NDEF_MODE_UNKNOWN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.667 -0400", hash_original_field = "A80C5A2169A823A76B5297F5B7A3A355", hash_generated_field = "03D3BAE1BAECD74B0536623170B60435")

    public static final String EXTRA_NDEF_MSG = "ndefmsg";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.667 -0400", hash_original_field = "C1C8E08A49E499FB0F9157AAB747D827", hash_generated_field = "E9849B00182607135A66EA385BB6EEDF")

    public static final String EXTRA_NDEF_MAXLENGTH = "ndefmaxlength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.667 -0400", hash_original_field = "5D4D94FD01B74D1E9CDF93DD8A7C687D", hash_generated_field = "E60DC935E7366BEE7CB8A6BCC1E76C3F")

    public static final String EXTRA_NDEF_CARDSTATE = "ndefcardstate";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.667 -0400", hash_original_field = "620DE4DC73F430C98FD76B469B906C93", hash_generated_field = "3A731748AEA21BE10691299B82543FC6")

    public static final String EXTRA_NDEF_TYPE = "ndeftype";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.667 -0400", hash_original_field = "76B8E577CDF0E4314525263EBE608297", hash_generated_field = "F774A018B9285EC5E477028D8C8B18CA")

    public static final int TYPE_OTHER = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "7ED15780FBDABAC9B4D00BFBAB6D8CF5", hash_generated_field = "B90833880EBD1E3B8DB2C377F2218D95")

    public static final int TYPE_1 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "153D4AF99233EC46E1E73381EC15C999", hash_generated_field = "C4A935A2405F790089A3222823FA06C8")

    public static final int TYPE_2 = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "AC1F32ED62BED4E288C26AA357AAACD8", hash_generated_field = "F9DB7252B6E07488AFF6CA7F881E590E")

    public static final int TYPE_3 = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "CCF4F969EA4D5F0D5DC1974FBFC0C183", hash_generated_field = "DC39DE3899327A06A0E797E04D33EFA7")

    public static final int TYPE_4 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "9822D19D7570EBC046555B8BB26BA41F", hash_generated_field = "9C9138A0D6504FF2ED079C833E453D03")

    public static final int TYPE_MIFARE_CLASSIC = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "11DF5D2A73843DEBFEF76B7157D177B1", hash_generated_field = "768AA5E4F024C71B498BC3C645A3E062")

    public static final int TYPE_ICODE_SLI = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "008A8C15155D31F7C7D1AE86B1F2FA29", hash_generated_field = "573D864C4DBFA5B4A14D7BB89E1DF434")

    public static final String UNKNOWN = "android.ndef.unknown";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "4758EEF791762C7159E997E8C1E7FD6C", hash_generated_field = "9B9B0F5F8E000574CA0476F14E8B8681")

    public static final String NFC_FORUM_TYPE_1 = "org.nfcforum.ndef.type1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "2A4999ED5F3A871D53C75BF6A2161EF1", hash_generated_field = "186E8B71C431D1BE39AB10B1D3DC67AE")

    public static final String NFC_FORUM_TYPE_2 = "org.nfcforum.ndef.type2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "46EAD74D936578FAA3C8368CBFDA6533", hash_generated_field = "6E8100A3CE039AF9F49634A53A4AD1BE")

    public static final String NFC_FORUM_TYPE_3 = "org.nfcforum.ndef.type3";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "2ACB073EDAA925440530D1F892D9F95E", hash_generated_field = "3C7054635E2F21BC87F3876F24A2784B")

    public static final String NFC_FORUM_TYPE_4 = "org.nfcforum.ndef.type4";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "335AA93DFAF0D225EE1D42A3C77E9853", hash_generated_field = "E94250C73C997BF5AFE2384A69E09FFD")

    public static final String MIFARE_CLASSIC = "com.nxp.ndef.mifareclassic";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_field = "C54ABBC6D6D93C755C3D3F58C45A2C0E", hash_generated_field = "586FB5EAC65F9D040431B061ED147A30")

    public static final String ICODE_SLI = "com.nxp.ndef.icodesli";
}

