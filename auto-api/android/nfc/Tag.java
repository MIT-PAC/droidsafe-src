package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.230 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "81204E2516309774DDE98BCC95D4D337")

    byte[] mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.230 -0400", hash_original_field = "ED0C37574A71E31009E6BAC4C65FADD1", hash_generated_field = "0DB184F1652D71E136D886FBACFA9D55")

    int[] mTechList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.230 -0400", hash_original_field = "4E650265F80DA408E0A91929BFDAFC60", hash_generated_field = "0A081329FBF347BBA8CA3CE5FE7B2456")

    String[] mTechStringList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.230 -0400", hash_original_field = "8663114DCB1828187003F31E6C7AC81D", hash_generated_field = "F97EAF8BD7993C915DB2079CA2A6444E")

    Bundle[] mTechExtras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.230 -0400", hash_original_field = "2C5FEB0198F897EC9ED4F5F58999D842", hash_generated_field = "6F0A5804F925E3493BDF27F4D6450311")

    int mServiceHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.230 -0400", hash_original_field = "C4F66777987458EB95FEC3CBFE87E71B", hash_generated_field = "E7BFA6F23523ACB74649DA6B13E29836")

    INfcTag mTagService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.231 -0400", hash_original_field = "824FFD6D91C3217E3C5250F0EF6A1CF5", hash_generated_field = "CE330E3DB3AFE653E7D80FC8FC48F20D")

    int mConnectedTechnology;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.231 -0400", hash_original_method = "AAC199A9C4358959332D7A7260D2B126", hash_generated_method = "ECF94C4315A91B94468F250CE3B48BE4")
    public  Tag(byte[] id, int[] techList, Bundle[] techListExtras, int serviceHandle,
            INfcTag tagService) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("rawTargets cannot be null");
        } 
        mId = id;
        mTechList = Arrays.copyOf(techList, techList.length);
        mTechStringList = generateTechStringList(techList);
        mTechExtras = Arrays.copyOf(techListExtras, techList.length);
        mServiceHandle = serviceHandle;
        mTagService = tagService;
        mConnectedTechnology = -1;
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Tag createMockTag(byte[] id, int[] techList, Bundle[] techListExtras) {
        return new Tag(id, techList, techListExtras, 0, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.232 -0400", hash_original_method = "AA46592E4023484A1FFE154B94A62E4A", hash_generated_method = "245DD2ACC9A24066D534765B42D9B75D")
    private String[] generateTechStringList(int[] techList) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_33935191 = null; 
        final int size = techList.length;
        String[] strings = new String[size];
        {
            int i = 0;
            {
                
                strings[i] = IsoDep.class.getName();
                
                
                strings[i] = MifareClassic.class.getName();
                
                
                strings[i] = MifareUltralight.class.getName();
                
                
                strings[i] = Ndef.class.getName();
                
                
                strings[i] = NdefFormatable.class.getName();
                
                
                strings[i] = NfcA.class.getName();
                
                
                strings[i] = NfcB.class.getName();
                
                
                strings[i] = NfcF.class.getName();
                
                
                strings[i] = NfcV.class.getName();
                
                
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown tech type " + techList[i]);
                
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_33935191 = strings;
        addTaint(techList[0]);
        varB4EAC82CA7396A68D541C85D26508E83_33935191.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_33935191;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.233 -0400", hash_original_method = "89421ECB0C954DB9BA373A13BA3FAA83", hash_generated_method = "C3777B9B0A824A3A1B83D2DC7FB890BE")
    public int getServiceHandle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557283844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557283844;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.234 -0400", hash_original_method = "119449B9FCBA8EB72735DF05D41F23E7", hash_generated_method = "7C7A77A8900EEE7489D9A8FBFE4040ED")
    public byte[] getId() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_611959888 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_611959888;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.235 -0400", hash_original_method = "ED11FAFB07CA3B90E3FEDDA21BAFA279", hash_generated_method = "6C02D4CDDCD57028879ED15E49C806BA")
    public String[] getTechList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1791328737 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1791328737 = mTechStringList;
        varB4EAC82CA7396A68D541C85D26508E83_1791328737.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1791328737;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.235 -0400", hash_original_method = "4E5CB2043A65C51A8349137C18388B2C", hash_generated_method = "222A7B4D2F2D43DD2D851F54B4301C53")
    public Tag rediscover() throws IOException {
        Tag varB4EAC82CA7396A68D541C85D26508E83_1735457640 = null; 
        {
            boolean varEBFAF4397126CBA96A40D8CC684FB913_1192296125 = (getConnectedTechnology() != -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Close connection to the technology first!");
            } 
        } 
        try 
        {
            Tag newTag = mTagService.rediscover(getServiceHandle());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1735457640 = newTag;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Failed to rediscover tag");
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("NFC service dead");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1735457640.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1735457640;
        
        
            
        
        
            
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.240 -0400", hash_original_method = "066FD8962F433FECE6D4FD3B60FADEA0", hash_generated_method = "F609EA755209533605F00917236195A6")
    public boolean hasTech(int techType) {
        {
            int tech = mTechList[0];
        } 
        addTaint(techType);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_127117436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_127117436;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.241 -0400", hash_original_method = "31360E4A8CC1CC354A13744DCF6ABA65", hash_generated_method = "025764FF6E73A922F8ADDA6C2BE1E033")
    public Bundle getTechExtras(int tech) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_229435396 = null; 
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1749043718 = null; 
        int pos = -1;
        {
            int idx = 0;
            {
                {
                    pos = idx;
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_229435396 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1749043718 = mTechExtras[pos];
        addTaint(tech);
        Bundle varA7E53CE21691AB073D9660D615818899_13328231; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_13328231 = varB4EAC82CA7396A68D541C85D26508E83_229435396;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_13328231 = varB4EAC82CA7396A68D541C85D26508E83_1749043718;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_13328231.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_13328231;
        
        
        
          
              
              
          
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.241 -0400", hash_original_method = "67284B405524DECAA6F6D36DFD293E76", hash_generated_method = "EC63E0092D135C5202D68BFFC657A0F8")
    public INfcTag getTagService() {
        INfcTag varB4EAC82CA7396A68D541C85D26508E83_88362613 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_88362613 = mTagService;
        varB4EAC82CA7396A68D541C85D26508E83_88362613.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_88362613;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.242 -0400", hash_original_method = "DF673271FDC7A52A9E2682FF9A4E5D76", hash_generated_method = "76AF958079BD4FBEDE0BD1A543DFBE27")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_429671731 = null; 
        StringBuilder sb = new StringBuilder("TAG: Tech [");
        String[] techList = getTechList();
        int length = techList.length;
        {
            int i = 0;
            {
                sb.append(techList[i]);
                {
                    sb.append(", ");
                } 
            } 
        } 
        sb.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_429671731 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_429671731.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_429671731;
        
        
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static byte[] readBytesWithNull(Parcel in) {
        int len = in.readInt();
        byte[] result = null;
        if (len >= 0) {
            result = new byte[len];
            in.readByteArray(result);
        }
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    static void writeBytesWithNull(Parcel out, byte[] b) {
        if (b == null) {
            out.writeInt(-1);
            return;
        }
        out.writeInt(b.length);
        out.writeByteArray(b);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.244 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "772AF6641B79A5C2D6BE503156C86BEE")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722389648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722389648;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.244 -0400", hash_original_method = "B1506093B1A3D95B1E6C500EDA575BD4", hash_generated_method = "E396537DE0894B06934B7069FD0B2FDD")
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
        } 
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.245 -0400", hash_original_method = "5C3F1EA15BE184F081C4AA8C7B39A394", hash_generated_method = "BBC7664A12EF363FDA3A403E4CF26E5E")
    public synchronized void setConnectedTechnology(int technology) {
        {
            mConnectedTechnology = technology;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Close other technology first!");
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.246 -0400", hash_original_method = "B7538F13EF8EEF4B4D475104909015D7", hash_generated_method = "5E190FB5624D8D4C6455BCB78DF4EF6C")
    public int getConnectedTechnology() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459285693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459285693;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.247 -0400", hash_original_method = "4FE592F130B2AB198D9A9024B7A375C0", hash_generated_method = "CDDFA9CDCDA74E225B20B2008ED8B5D1")
    public void setTechnologyDisconnected() {
        mConnectedTechnology = -1;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.247 -0400", hash_original_field = "B7CF6CEBA53F7894015357BCDA86AD40", hash_generated_field = "5753E43B3B6E37C6E072C87A5DFEC09F")

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

