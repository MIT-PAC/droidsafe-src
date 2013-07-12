package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.740 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "81204E2516309774DDE98BCC95D4D337")

    byte[] mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.740 -0400", hash_original_field = "ED0C37574A71E31009E6BAC4C65FADD1", hash_generated_field = "0DB184F1652D71E136D886FBACFA9D55")

    int[] mTechList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.740 -0400", hash_original_field = "4E650265F80DA408E0A91929BFDAFC60", hash_generated_field = "0A081329FBF347BBA8CA3CE5FE7B2456")

    String[] mTechStringList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.740 -0400", hash_original_field = "8663114DCB1828187003F31E6C7AC81D", hash_generated_field = "F97EAF8BD7993C915DB2079CA2A6444E")

    Bundle[] mTechExtras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.740 -0400", hash_original_field = "2C5FEB0198F897EC9ED4F5F58999D842", hash_generated_field = "6F0A5804F925E3493BDF27F4D6450311")

    int mServiceHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.740 -0400", hash_original_field = "C4F66777987458EB95FEC3CBFE87E71B", hash_generated_field = "E7BFA6F23523ACB74649DA6B13E29836")

    INfcTag mTagService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.740 -0400", hash_original_field = "824FFD6D91C3217E3C5250F0EF6A1CF5", hash_generated_field = "CE330E3DB3AFE653E7D80FC8FC48F20D")

    int mConnectedTechnology;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.742 -0400", hash_original_method = "AAC199A9C4358959332D7A7260D2B126", hash_generated_method = "4238ABBF030BA3F39F38090E1B749372")
    public  Tag(byte[] id, int[] techList, Bundle[] techListExtras, int serviceHandle,
            INfcTag tagService) {
    if(techList == null)        
        {
            IllegalArgumentException varC58615044F1EEBC9993FC8DC55AC3544_543054676 = new IllegalArgumentException("rawTargets cannot be null");
            varC58615044F1EEBC9993FC8DC55AC3544_543054676.addTaint(taint);
            throw varC58615044F1EEBC9993FC8DC55AC3544_543054676;
        } 
        mId = id;
        mTechList = Arrays.copyOf(techList, techList.length);
        mTechStringList = generateTechStringList(techList);
        mTechExtras = Arrays.copyOf(techListExtras, techList.length);
        mServiceHandle = serviceHandle;
        mTagService = tagService;
        mConnectedTechnology = -1;
        
        
            
        
        
        
        
        
        
        
        
    }

    
        public static Tag createMockTag(byte[] id, int[] techList, Bundle[] techListExtras) {
        return new Tag(id, techList, techListExtras, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.744 -0400", hash_original_method = "AA46592E4023484A1FFE154B94A62E4A", hash_generated_method = "419AEAB188B3551D7F369959B47532E7")
    private String[] generateTechStringList(int[] techList) {
        addTaint(techList[0]);
        final int size = techList.length;
        String[] strings = new String[size];
for(int i = 0;i < size;i++)
        {
switch(techList[i]){
            case TagTechnology.ISO_DEP:
            strings[i] = IsoDep.class.getName();
            break;
            case TagTechnology.MIFARE_CLASSIC:
            strings[i] = MifareClassic.class.getName();
            break;
            case TagTechnology.MIFARE_ULTRALIGHT:
            strings[i] = MifareUltralight.class.getName();
            break;
            case TagTechnology.NDEF:
            strings[i] = Ndef.class.getName();
            break;
            case TagTechnology.NDEF_FORMATABLE:
            strings[i] = NdefFormatable.class.getName();
            break;
            case TagTechnology.NFC_A:
            strings[i] = NfcA.class.getName();
            break;
            case TagTechnology.NFC_B:
            strings[i] = NfcB.class.getName();
            break;
            case TagTechnology.NFC_F:
            strings[i] = NfcF.class.getName();
            break;
            case TagTechnology.NFC_V:
            strings[i] = NfcV.class.getName();
            break;
            default:
            IllegalArgumentException var256048EF6D22C5D5ECA9C9DAEA7110FA_1243036146 = new IllegalArgumentException("Unknown tech type " + techList[i]);
            var256048EF6D22C5D5ECA9C9DAEA7110FA_1243036146.addTaint(taint);
            throw var256048EF6D22C5D5ECA9C9DAEA7110FA_1243036146;
}
        } 
String[] var2E6885ACC179B2D302813BAD2D696933_1661297653 =         strings;
        var2E6885ACC179B2D302813BAD2D696933_1661297653.addTaint(taint);
        return var2E6885ACC179B2D302813BAD2D696933_1661297653;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.745 -0400", hash_original_method = "89421ECB0C954DB9BA373A13BA3FAA83", hash_generated_method = "071AA858788F65B8E707E1AEC550FEE7")
    public int getServiceHandle() {
        int var2C5FEB0198F897EC9ED4F5F58999D842_11636731 = (mServiceHandle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492107553 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492107553;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.745 -0400", hash_original_method = "119449B9FCBA8EB72735DF05D41F23E7", hash_generated_method = "C540352B390F2FD6B5A21B795B7CD7EE")
    public byte[] getId() {
        byte[] var6AC7F06B6413A1BE9C136DC7DF0D2B60_40871674 = (mId);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1032137386 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1032137386;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.745 -0400", hash_original_method = "ED11FAFB07CA3B90E3FEDDA21BAFA279", hash_generated_method = "64F72F7CF7851FEA63667A664127A116")
    public String[] getTechList() {
String[] varCD028AAF1881533C9F08026F039B4C4D_238755482 =         mTechStringList;
        varCD028AAF1881533C9F08026F039B4C4D_238755482.addTaint(taint);
        return varCD028AAF1881533C9F08026F039B4C4D_238755482;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.746 -0400", hash_original_method = "4E5CB2043A65C51A8349137C18388B2C", hash_generated_method = "4EF1CD5F533D14C5FE6F899610DE5F38")
    public Tag rediscover() throws IOException {
    if(getConnectedTechnology() != -1)        
        {
            IllegalStateException var984D8BA48DC48CBA090B19434FB7D408_126905137 = new IllegalStateException("Close connection to the technology first!");
            var984D8BA48DC48CBA090B19434FB7D408_126905137.addTaint(taint);
            throw var984D8BA48DC48CBA090B19434FB7D408_126905137;
        } 
        try 
        {
            Tag newTag = mTagService.rediscover(getServiceHandle());
    if(newTag != null)            
            {
Tag var9B601A3966D02397507C32AA33318068_526634755 =                 newTag;
                var9B601A3966D02397507C32AA33318068_526634755.addTaint(taint);
                return var9B601A3966D02397507C32AA33318068_526634755;
            } 
            else
            {
                IOException var902C48C8B5D62C3CB23219936FB8A620_548036142 = new IOException("Failed to rediscover tag");
                var902C48C8B5D62C3CB23219936FB8A620_548036142.addTaint(taint);
                throw var902C48C8B5D62C3CB23219936FB8A620_548036142;
            } 
        } 
        catch (RemoteException e)
        {
            IOException var85ABB819BF0F37D7F06E65856C8FB735_2852915 = new IOException("NFC service dead");
            var85ABB819BF0F37D7F06E65856C8FB735_2852915.addTaint(taint);
            throw var85ABB819BF0F37D7F06E65856C8FB735_2852915;
        } 
        
        
            
        
        
            
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.746 -0400", hash_original_method = "066FD8962F433FECE6D4FD3B60FADEA0", hash_generated_method = "49AA6C4E2B46C3496B69DA2176838E0C")
    public boolean hasTech(int techType) {
        addTaint(techType);
for(int tech : mTechList)
        {
    if(tech == techType)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1166091130 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_828123004 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_828123004;
            }
        } 
        boolean var68934A3E9455FA72420237EB05902327_1905618510 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1222854406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1222854406;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.747 -0400", hash_original_method = "31360E4A8CC1CC354A13744DCF6ABA65", hash_generated_method = "59571D9E3BD4E557F423FB3BAE1BC990")
    public Bundle getTechExtras(int tech) {
        addTaint(tech);
        int pos = -1;
for(int idx = 0;idx < mTechList.length;idx++)
        {
    if(mTechList[idx] == tech)            
            {
                pos = idx;
                break;
            } 
        } 
    if(pos < 0)        
        {
Bundle var540C13E9E156B687226421B24F2DF178_290353884 =             null;
            var540C13E9E156B687226421B24F2DF178_290353884.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_290353884;
        } 
Bundle var6543B1FECCBBFB52C39498A0EC7DCB0D_1781082447 =         mTechExtras[pos];
        var6543B1FECCBBFB52C39498A0EC7DCB0D_1781082447.addTaint(taint);
        return var6543B1FECCBBFB52C39498A0EC7DCB0D_1781082447;
        
        
        
          
              
              
          
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.747 -0400", hash_original_method = "67284B405524DECAA6F6D36DFD293E76", hash_generated_method = "ED754AB6ECE2BA2E40DD898AAFE628E7")
    public INfcTag getTagService() {
INfcTag varCEA41967F78A032165E0C3EE868F689A_556929694 =         mTagService;
        varCEA41967F78A032165E0C3EE868F689A_556929694.addTaint(taint);
        return varCEA41967F78A032165E0C3EE868F689A_556929694;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.747 -0400", hash_original_method = "DF673271FDC7A52A9E2682FF9A4E5D76", hash_generated_method = "00A68976C2D35BA46DD7175889A353D3")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TAG: Tech [");
        String[] techList = getTechList();
        int length = techList.length;
for(int i = 0;i < length;i++)
        {
            sb.append(techList[i]);
    if(i < length - 1)            
            {
                sb.append(", ");
            } 
        } 
        sb.append("]");
String var2460B846747F8B22185AD8BE722266A5_1890451433 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1890451433.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1890451433;
        
        
        
        
        
            
            
                
            
        
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.748 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C6133079B7CF5E9AF7C1836EB5266956")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2135647463 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381905873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381905873;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.749 -0400", hash_original_method = "B1506093B1A3D95B1E6C500EDA575BD4", hash_generated_method = "59789CF8B0A6463FE0433B8EF2DB4B96")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        int isMock = (mTagService == null)?1:0;
        writeBytesWithNull(dest, mId);
        dest.writeInt(mTechList.length);
        dest.writeIntArray(mTechList);
        dest.writeTypedArray(mTechExtras, 0);
        dest.writeInt(mServiceHandle);
        dest.writeInt(isMock);
    if(isMock == 0)        
        {
            dest.writeStrongBinder(mTagService.asBinder());
        } 
        
        
        
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.750 -0400", hash_original_method = "5C3F1EA15BE184F081C4AA8C7B39A394", hash_generated_method = "011240787B4AC83A265C32F73EEFC774")
    public synchronized void setConnectedTechnology(int technology) {
    if(mConnectedTechnology == -1)        
        {
            mConnectedTechnology = technology;
        } 
        else
        {
            IllegalStateException var268A1622F35E361EE39921151619CEFC_1733442464 = new IllegalStateException("Close other technology first!");
            var268A1622F35E361EE39921151619CEFC_1733442464.addTaint(taint);
            throw var268A1622F35E361EE39921151619CEFC_1733442464;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.750 -0400", hash_original_method = "B7538F13EF8EEF4B4D475104909015D7", hash_generated_method = "2475BD739BB9F2FDEDB63047DAF61090")
    public int getConnectedTechnology() {
        int var824FFD6D91C3217E3C5250F0EF6A1CF5_2056547954 = (mConnectedTechnology);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041989742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041989742;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.751 -0400", hash_original_method = "4FE592F130B2AB198D9A9024B7A375C0", hash_generated_method = "CDDFA9CDCDA74E225B20B2008ED8B5D1")
    public void setTechnologyDisconnected() {
        mConnectedTechnology = -1;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.751 -0400", hash_original_field = "B7CF6CEBA53F7894015357BCDA86AD40", hash_generated_field = "5753E43B3B6E37C6E072C87A5DFEC09F")

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

