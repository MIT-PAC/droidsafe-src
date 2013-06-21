package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.nfc.tech.TagTechnology;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.io.IOException;
import java.util.Arrays;

public final class Tag implements Parcelable {
    byte[] mId;
    int[] mTechList;
    String[] mTechStringList;
    Bundle[] mTechExtras;
    int mServiceHandle;
    INfcTag mTagService;
    int mConnectedTechnology;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.090 -0400", hash_original_method = "AAC199A9C4358959332D7A7260D2B126", hash_generated_method = "356B323664A8C389A6146D29B61E1DB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Tag(byte[] id, int[] techList, Bundle[] techListExtras, int serviceHandle,
            INfcTag tagService) {
        dsTaint.addTaint(id[0]);
        dsTaint.addTaint(tagService.dsTaint);
        dsTaint.addTaint(techList[0]);
        dsTaint.addTaint(serviceHandle);
        dsTaint.addTaint(techListExtras[0].dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("rawTargets cannot be null");
        } //End block
        mTechList = Arrays.copyOf(techList, techList.length);
        mTechStringList = generateTechStringList(techList);
        mTechExtras = Arrays.copyOf(techListExtras, techList.length);
        mConnectedTechnology = -1;
        // ---------- Original Method ----------
        //if (techList == null) {
            //throw new IllegalArgumentException("rawTargets cannot be null");
        //}
        //mId = id;
        //mTechList = Arrays.copyOf(techList, techList.length);
        //mTechStringList = generateTechStringList(techList);
        //mTechExtras = Arrays.copyOf(techListExtras, techList.length);
        //mServiceHandle = serviceHandle;
        //mTagService = tagService;
        //mConnectedTechnology = -1;
    }

    
        public static Tag createMockTag(byte[] id, int[] techList, Bundle[] techListExtras) {
        return new Tag(id, techList, techListExtras, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.091 -0400", hash_original_method = "AA46592E4023484A1FFE154B94A62E4A", hash_generated_method = "0888EAB1D1F080A844048007E86749F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] generateTechStringList(int[] techList) {
        dsTaint.addTaint(techList[0]);
        int size;
        size = techList.length;
        String[] strings;
        strings = new String[size];
        {
            int i;
            i = 0;
            {
                //Begin case TagTechnology.ISO_DEP 
                strings[i] = IsoDep.class.getName();
                //End case TagTechnology.ISO_DEP 
                //Begin case TagTechnology.MIFARE_CLASSIC 
                strings[i] = MifareClassic.class.getName();
                //End case TagTechnology.MIFARE_CLASSIC 
                //Begin case TagTechnology.MIFARE_ULTRALIGHT 
                strings[i] = MifareUltralight.class.getName();
                //End case TagTechnology.MIFARE_ULTRALIGHT 
                //Begin case TagTechnology.NDEF 
                strings[i] = Ndef.class.getName();
                //End case TagTechnology.NDEF 
                //Begin case TagTechnology.NDEF_FORMATABLE 
                strings[i] = NdefFormatable.class.getName();
                //End case TagTechnology.NDEF_FORMATABLE 
                //Begin case TagTechnology.NFC_A 
                strings[i] = NfcA.class.getName();
                //End case TagTechnology.NFC_A 
                //Begin case TagTechnology.NFC_B 
                strings[i] = NfcB.class.getName();
                //End case TagTechnology.NFC_B 
                //Begin case TagTechnology.NFC_F 
                strings[i] = NfcF.class.getName();
                //End case TagTechnology.NFC_F 
                //Begin case TagTechnology.NFC_V 
                strings[i] = NfcV.class.getName();
                //End case TagTechnology.NFC_V 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown tech type " + techList[i]);
                //End case default 
            } //End block
        } //End collapsed parenthetic
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.092 -0400", hash_original_method = "89421ECB0C954DB9BA373A13BA3FAA83", hash_generated_method = "DA351054133898929D2FB477DC920D8B")
    @DSModeled(DSC.SAFE)
    public int getServiceHandle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mServiceHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.092 -0400", hash_original_method = "119449B9FCBA8EB72735DF05D41F23E7", hash_generated_method = "810A2C5F66EB970795CB54D5A6DE34C9")
    @DSModeled(DSC.SAFE)
    public byte[] getId() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.092 -0400", hash_original_method = "ED11FAFB07CA3B90E3FEDDA21BAFA279", hash_generated_method = "78E048F7855DC2BED8A9952190F9946D")
    @DSModeled(DSC.SAFE)
    public String[] getTechList() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mTechStringList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.092 -0400", hash_original_method = "4E5CB2043A65C51A8349137C18388B2C", hash_generated_method = "C07E364DAF806B79CA822F0E8B6F8984")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Tag rediscover() throws IOException {
        {
            boolean varEBFAF4397126CBA96A40D8CC684FB913_2075615819 = (getConnectedTechnology() != -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Close connection to the technology first!");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            Tag newTag;
            newTag = mTagService.rediscover(getServiceHandle());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Failed to rediscover tag");
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("NFC service dead");
        } //End block
        return (Tag)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (getConnectedTechnology() != -1) {
            //throw new IllegalStateException("Close connection to the technology first!");
        //}
        //try {
            //Tag newTag = mTagService.rediscover(getServiceHandle());
            //if (newTag != null) {
                //return newTag;
            //} else {
                //throw new IOException("Failed to rediscover tag");
            //}
        //} catch (RemoteException e) {
            //throw new IOException("NFC service dead");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.095 -0400", hash_original_method = "066FD8962F433FECE6D4FD3B60FADEA0", hash_generated_method = "26F7154DBBEA9A3BFE2FE46DAEC51E19")
    @DSModeled(DSC.SAFE)
    public boolean hasTech(int techType) {
        dsTaint.addTaint(techType);
        {
            int tech = mTechList[0];
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (int tech : mTechList) {
            //if (tech == techType) return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.096 -0400", hash_original_method = "31360E4A8CC1CC354A13744DCF6ABA65", hash_generated_method = "6FB506E77F889D792877085CAA92CB4B")
    @DSModeled(DSC.SAFE)
    public Bundle getTechExtras(int tech) {
        dsTaint.addTaint(tech);
        int pos;
        pos = -1;
        {
            int idx;
            idx = 0;
            {
                {
                    pos = idx;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int pos = -1;
        //for (int idx = 0; idx < mTechList.length; idx++) {
          //if (mTechList[idx] == tech) {
              //pos = idx;
              //break;
          //}
        //}
        //if (pos < 0) {
            //return null;
        //}
        //return mTechExtras[pos];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.096 -0400", hash_original_method = "67284B405524DECAA6F6D36DFD293E76", hash_generated_method = "8D53EE637E395B4536319296740481EE")
    @DSModeled(DSC.SAFE)
    public INfcTag getTagService() {
        return (INfcTag)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTagService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.096 -0400", hash_original_method = "DF673271FDC7A52A9E2682FF9A4E5D76", hash_generated_method = "25E220FD00929CFB1F669A56554D21CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder("TAG: Tech [");
        String[] techList;
        techList = getTechList();
        int length;
        length = techList.length;
        {
            int i;
            i = 0;
            {
                sb.append(techList[i]);
                {
                    sb.append(", ");
                } //End block
            } //End block
        } //End collapsed parenthetic
        sb.append("]");
        String var806458D832AB974D230FEE4CBBDBD390_391916855 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder("TAG: Tech [");
        //String[] techList = getTechList();
        //int length = techList.length;
        //for (int i = 0; i < length; i++) {
            //sb.append(techList[i]);
            //if (i < length - 1) {
                //sb.append(", ");
            //}
        //}
        //sb.append("]");
        //return sb.toString();
    }

    
        static byte[] readBytesWithNull(Parcel in) {
        int len = in.readInt();
        byte[] result = null;
        if (len >= 0) {
            result = new byte[len];
            in.readByteArray(result);
        }
        return result;
    }

    
        static void writeBytesWithNull(Parcel out, byte[] b) {
        if (b == null) {
            out.writeInt(-1);
            return;
        }
        out.writeInt(b.length);
        out.writeByteArray(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.097 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.097 -0400", hash_original_method = "B1506093B1A3D95B1E6C500EDA575BD4", hash_generated_method = "DE64E44EB6250A81387317CA57BD03C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        int isMock;
        isMock = 1;
        isMock = 0;
        writeBytesWithNull(dest, mId);
        dest.writeInt(mTechList.length);
        dest.writeIntArray(mTechList);
        dest.writeTypedArray(mTechExtras, 0);
        dest.writeInt(mServiceHandle);
        dest.writeInt(isMock);
        {
            dest.writeStrongBinder(mTagService.asBinder());
        } //End block
        // ---------- Original Method ----------
        //int isMock = (mTagService == null)?1:0;
        //writeBytesWithNull(dest, mId);
        //dest.writeInt(mTechList.length);
        //dest.writeIntArray(mTechList);
        //dest.writeTypedArray(mTechExtras, 0);
        //dest.writeInt(mServiceHandle);
        //dest.writeInt(isMock);
        //if (isMock == 0) {
            //dest.writeStrongBinder(mTagService.asBinder());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.097 -0400", hash_original_method = "5C3F1EA15BE184F081C4AA8C7B39A394", hash_generated_method = "2862C4CBAD065A0369EF6C515E8D087C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setConnectedTechnology(int technology) {
        dsTaint.addTaint(technology);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Close other technology first!");
        } //End block
        // ---------- Original Method ----------
        //if (mConnectedTechnology == -1) {
            //mConnectedTechnology = technology;
        //} else {
            //throw new IllegalStateException("Close other technology first!");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.097 -0400", hash_original_method = "B7538F13EF8EEF4B4D475104909015D7", hash_generated_method = "A7ACA3DBAEF40B60586D2EB00EA1162E")
    @DSModeled(DSC.SAFE)
    public int getConnectedTechnology() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mConnectedTechnology;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.098 -0400", hash_original_method = "4FE592F130B2AB198D9A9024B7A375C0", hash_generated_method = "CDDFA9CDCDA74E225B20B2008ED8B5D1")
    @DSModeled(DSC.SAFE)
    public void setTechnologyDisconnected() {
        mConnectedTechnology = -1;
        // ---------- Original Method ----------
        //mConnectedTechnology = -1;
    }

    
    public static final Parcelable.Creator<Tag> CREATOR = new Parcelable.Creator<Tag>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.098 -0400", hash_original_method = "C00F8D9D166881C90A27311ADAB142C9", hash_generated_method = "A7FB5EF578D7D1602840409A49EBBC8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tag createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            INfcTag tagService;
            byte[] id;
            id = Tag.readBytesWithNull(in);
            int[] techList;
            techList = new int[in.readInt()];
            in.readIntArray(techList);
            Bundle[] techExtras;
            techExtras = in.createTypedArray(Bundle.CREATOR);
            int serviceHandle;
            serviceHandle = in.readInt();
            int isMock;
            isMock = in.readInt();
            {
                tagService = INfcTag.Stub.asInterface(in.readStrongBinder());
            } //End block
            {
                tagService = null;
            } //End block
            Tag var8A1857BBB51D140686F76998E3CAD07C_36851671 = (new Tag(id, techList, techExtras, serviceHandle, tagService));
            return (Tag)dsTaint.getTaint();
            // ---------- Original Method ----------
            //INfcTag tagService;
            //byte[] id = Tag.readBytesWithNull(in);
            //int[] techList = new int[in.readInt()];
            //in.readIntArray(techList);
            //Bundle[] techExtras = in.createTypedArray(Bundle.CREATOR);
            //int serviceHandle = in.readInt();
            //int isMock = in.readInt();
            //if (isMock == 0) {
                //tagService = INfcTag.Stub.asInterface(in.readStrongBinder());
            //}
            //else {
                //tagService = null;
            //}
            //return new Tag(id, techList, techExtras, serviceHandle, tagService);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.098 -0400", hash_original_method = "C2E20987B78EDAE1EFF0E2E8A03B4F87", hash_generated_method = "F2C25AEC25392014CB184653806F0550")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Tag[] newArray(int size) {
            dsTaint.addTaint(size);
            Tag[] var2CA1F1B772DD749871AA52A82A487701_477122457 = (new Tag[size]);
            return (Tag[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Tag[size];
        }

        
}; //Transformed anonymous class
}

