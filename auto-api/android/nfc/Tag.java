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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.873 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "81204E2516309774DDE98BCC95D4D337")

    byte[] mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.874 -0400", hash_original_field = "ED0C37574A71E31009E6BAC4C65FADD1", hash_generated_field = "0DB184F1652D71E136D886FBACFA9D55")

    int[] mTechList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.874 -0400", hash_original_field = "4E650265F80DA408E0A91929BFDAFC60", hash_generated_field = "0A081329FBF347BBA8CA3CE5FE7B2456")

    String[] mTechStringList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.874 -0400", hash_original_field = "8663114DCB1828187003F31E6C7AC81D", hash_generated_field = "F97EAF8BD7993C915DB2079CA2A6444E")

    Bundle[] mTechExtras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.874 -0400", hash_original_field = "2C5FEB0198F897EC9ED4F5F58999D842", hash_generated_field = "6F0A5804F925E3493BDF27F4D6450311")

    int mServiceHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.874 -0400", hash_original_field = "C4F66777987458EB95FEC3CBFE87E71B", hash_generated_field = "E7BFA6F23523ACB74649DA6B13E29836")

    INfcTag mTagService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.874 -0400", hash_original_field = "824FFD6D91C3217E3C5250F0EF6A1CF5", hash_generated_field = "CE330E3DB3AFE653E7D80FC8FC48F20D")

    int mConnectedTechnology;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.892 -0400", hash_original_method = "AAC199A9C4358959332D7A7260D2B126", hash_generated_method = "ECF94C4315A91B94468F250CE3B48BE4")
    public  Tag(byte[] id, int[] techList, Bundle[] techListExtras, int serviceHandle,
            INfcTag tagService) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("rawTargets cannot be null");
        } //End block
        mId = id;
        mTechList = Arrays.copyOf(techList, techList.length);
        mTechStringList = generateTechStringList(techList);
        mTechExtras = Arrays.copyOf(techListExtras, techList.length);
        mServiceHandle = serviceHandle;
        mTagService = tagService;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.915 -0400", hash_original_method = "AA46592E4023484A1FFE154B94A62E4A", hash_generated_method = "EC531C428EF6DA64D38FB30CBE579020")
    private String[] generateTechStringList(int[] techList) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1274261828 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1274261828 = strings;
        addTaint(techList[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1274261828.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1274261828;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.915 -0400", hash_original_method = "89421ECB0C954DB9BA373A13BA3FAA83", hash_generated_method = "3FBC082A59FD1AEEE397A719A84D6109")
    public int getServiceHandle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920358578 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920358578;
        // ---------- Original Method ----------
        //return mServiceHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.916 -0400", hash_original_method = "119449B9FCBA8EB72735DF05D41F23E7", hash_generated_method = "FF8FDF73204C69FF053C91EE08CADBF2")
    public byte[] getId() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2098543729 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2098543729;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.916 -0400", hash_original_method = "ED11FAFB07CA3B90E3FEDDA21BAFA279", hash_generated_method = "6CCCB6440C0DE59A8DB329CF54B81565")
    public String[] getTechList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_851604568 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_851604568 = mTechStringList;
        varB4EAC82CA7396A68D541C85D26508E83_851604568.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_851604568;
        // ---------- Original Method ----------
        //return mTechStringList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.917 -0400", hash_original_method = "4E5CB2043A65C51A8349137C18388B2C", hash_generated_method = "C66EA7A102A5E6118D77B461805C0D33")
    public Tag rediscover() throws IOException {
        Tag varB4EAC82CA7396A68D541C85D26508E83_2058979572 = null; //Variable for return #1
        {
            boolean varEBFAF4397126CBA96A40D8CC684FB913_761760754 = (getConnectedTechnology() != -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Close connection to the technology first!");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            Tag newTag;
            newTag = mTagService.rediscover(getServiceHandle());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2058979572 = newTag;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Failed to rediscover tag");
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("NFC service dead");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2058979572.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2058979572;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.968 -0400", hash_original_method = "066FD8962F433FECE6D4FD3B60FADEA0", hash_generated_method = "1617CEFF6A308470D6E4130FA2BC5D46")
    public boolean hasTech(int techType) {
        {
            int tech = mTechList[0];
        } //End collapsed parenthetic
        addTaint(techType);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565286860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_565286860;
        // ---------- Original Method ----------
        //for (int tech : mTechList) {
            //if (tech == techType) return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.986 -0400", hash_original_method = "31360E4A8CC1CC354A13744DCF6ABA65", hash_generated_method = "06D4E6BB2D99D9EE1C1A73F7F7784C4E")
    public Bundle getTechExtras(int tech) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1143391189 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_49763821 = null; //Variable for return #2
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_1143391189 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_49763821 = mTechExtras[pos];
        addTaint(tech);
        Bundle varA7E53CE21691AB073D9660D615818899_2002275010; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2002275010 = varB4EAC82CA7396A68D541C85D26508E83_1143391189;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2002275010 = varB4EAC82CA7396A68D541C85D26508E83_49763821;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2002275010.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2002275010;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.987 -0400", hash_original_method = "67284B405524DECAA6F6D36DFD293E76", hash_generated_method = "D8337BAC6C302222E92C0C077AE4DCC3")
    public INfcTag getTagService() {
        INfcTag varB4EAC82CA7396A68D541C85D26508E83_1937984157 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1937984157 = mTagService;
        varB4EAC82CA7396A68D541C85D26508E83_1937984157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1937984157;
        // ---------- Original Method ----------
        //return mTagService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.991 -0400", hash_original_method = "DF673271FDC7A52A9E2682FF9A4E5D76", hash_generated_method = "3CD8F7DD26401C7CB8003017483B54EE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1270582406 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1270582406 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1270582406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1270582406;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.007 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D8090BF786B40B6B014025616181C079")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309183950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309183950;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.024 -0400", hash_original_method = "B1506093B1A3D95B1E6C500EDA575BD4", hash_generated_method = "E396537DE0894B06934B7069FD0B2FDD")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
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
        addTaint(dest.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.026 -0400", hash_original_method = "5C3F1EA15BE184F081C4AA8C7B39A394", hash_generated_method = "BBC7664A12EF363FDA3A403E4CF26E5E")
    public synchronized void setConnectedTechnology(int technology) {
        {
            mConnectedTechnology = technology;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.026 -0400", hash_original_method = "B7538F13EF8EEF4B4D475104909015D7", hash_generated_method = "5EF5A52CC5EAA21171D2B5EB80568FB9")
    public int getConnectedTechnology() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386918924 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386918924;
        // ---------- Original Method ----------
        //return mConnectedTechnology;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.027 -0400", hash_original_method = "4FE592F130B2AB198D9A9024B7A375C0", hash_generated_method = "CDDFA9CDCDA74E225B20B2008ED8B5D1")
    public void setTechnologyDisconnected() {
        mConnectedTechnology = -1;
        // ---------- Original Method ----------
        //mConnectedTechnology = -1;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.027 -0400", hash_original_field = "B7CF6CEBA53F7894015357BCDA86AD40", hash_generated_field = "5753E43B3B6E37C6E072C87A5DFEC09F")

    public static final Parcelable.Creator<Tag> CREATOR =
            new Parcelable.Creator<Tag>() {
        @Override
        public Tag createFromParcel(Parcel in) {
            INfcTag tagService;

            
            byte[] id = Tag.readBytesWithNull(in);
            int[] techList = new int[in.readInt()];
            in.readIntArray(techList);
            Bundle[] techExtras = in.createTypedArray(Bundle.CREATOR);
            int serviceHandle = in.readInt();
            int isMock = in.readInt();
            if (isMock == 0) {
                tagService = INfcTag.Stub.asInterface(in.readStrongBinder());
            }
            else {
                tagService = null;
            }

            return new Tag(id, techList, techExtras, serviceHandle, tagService);
        }

        @Override
        public Tag[] newArray(int size) {
            return new Tag[size];
        }
    };
}

