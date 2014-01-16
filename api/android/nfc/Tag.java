package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Arrays;

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

public final class Tag implements Parcelable {

    /**
     * Construct a mock Tag.
     * <p>This is an application constructed tag, so NfcAdapter methods on this Tag may fail
     * with {@link IllegalArgumentException} since it does not represent a physical Tag.
     * <p>This constructor might be useful for mock testing.
     * @param id The tag identifier, can be null
     * @param techList must not be null
     * @return freshly constructed tag
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.156 -0500", hash_original_method = "7E992DD8CAE9B813FC69544310B71068", hash_generated_method = "6E3E06C2476B2AB747D3DE64C1F6897A")
    
public static Tag createMockTag(byte[] id, int[] techList, Bundle[] techListExtras) {
        // set serviceHandle to 0 to indicate mock tag
        return new Tag(id, techList, techListExtras, 0, null);
    }

    /*package*/ @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.181 -0500", hash_original_method = "C242347B550488411F3501E51C751C46", hash_generated_method = "F876007B92E5D134943B17B413426925")
    
static byte[] readBytesWithNull(Parcel in) {
        int len = in.readInt();
        byte[] result = null;
        if (len >= 0) {
            result = new byte[len];
            in.readByteArray(result);
        }
        return result;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.183 -0500", hash_original_method = "98002DADC2AF2A7723A17AC5EA70B235", hash_generated_method = "A61FD11585982E78D3E77D0820B2076F")
    
static void writeBytesWithNull(Parcel out, byte[] b) {
        if (b == null) {
            out.writeInt(-1);
            return;
        }
        out.writeInt(b.length);
        out.writeByteArray(b);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.380 -0400", hash_original_field = "B7CF6CEBA53F7894015357BCDA86AD40", hash_generated_field = "5753E43B3B6E37C6E072C87A5DFEC09F")

    public static final Parcelable.Creator<Tag> CREATOR =
            new Parcelable.Creator<Tag>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.193 -0500", hash_original_method = "C00F8D9D166881C90A27311ADAB142C9", hash_generated_method = "EAC3D445FD95375F7D2FBC6BE96C1F95")
        
@Override
        public Tag createFromParcel(Parcel in) {
            INfcTag tagService;

            // Tag fields
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.197 -0500", hash_original_method = "C2E20987B78EDAE1EFF0E2E8A03B4F87", hash_generated_method = "69FFED310088742236400E550031F693")
        
@Override
        public Tag[] newArray(int size) {
            return new Tag[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.138 -0500", hash_original_field = "81204E2516309774DDE98BCC95D4D337", hash_generated_field = "81204E2516309774DDE98BCC95D4D337")
  byte[] mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.140 -0500", hash_original_field = "0DB184F1652D71E136D886FBACFA9D55", hash_generated_field = "0DB184F1652D71E136D886FBACFA9D55")
  int[] mTechList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.142 -0500", hash_original_field = "0A081329FBF347BBA8CA3CE5FE7B2456", hash_generated_field = "0A081329FBF347BBA8CA3CE5FE7B2456")
  String[] mTechStringList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.144 -0500", hash_original_field = "F97EAF8BD7993C915DB2079CA2A6444E", hash_generated_field = "F97EAF8BD7993C915DB2079CA2A6444E")
  Bundle[] mTechExtras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.146 -0500", hash_original_field = "6F0A5804F925E3493BDF27F4D6450311", hash_generated_field = "6F0A5804F925E3493BDF27F4D6450311")
  int mServiceHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.148 -0500", hash_original_field = "E7BFA6F23523ACB74649DA6B13E29836", hash_generated_field = "0936371ECDC5BA72C3D05A3BAD3062F3")

    /*package*/  INfcTag mTagService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.151 -0500", hash_original_field = "CE330E3DB3AFE653E7D80FC8FC48F20D", hash_generated_field = "CE330E3DB3AFE653E7D80FC8FC48F20D")
 int mConnectedTechnology;

    /**
     * Hidden constructor to be used by NFC service and internal classes.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.154 -0500", hash_original_method = "AAC199A9C4358959332D7A7260D2B126", hash_generated_method = "0317C5FF7700C01A5ED461533E87D576")
    
public Tag(byte[] id, int[] techList, Bundle[] techListExtras, int serviceHandle,
            INfcTag tagService) {
        if (techList == null) {
            throw new IllegalArgumentException("rawTargets cannot be null");
        }
        mId = id;
        mTechList = Arrays.copyOf(techList, techList.length);
        mTechStringList = generateTechStringList(techList);
        // Ensure mTechExtras is as long as mTechList
        mTechExtras = Arrays.copyOf(techListExtras, techList.length);
        mServiceHandle = serviceHandle;
        mTagService = tagService;

        mConnectedTechnology = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.159 -0500", hash_original_method = "AA46592E4023484A1FFE154B94A62E4A", hash_generated_method = "F90E49BAD838897D3148B283D7B64585")
    
private String[] generateTechStringList(int[] techList) {
        final int size = techList.length;
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            switch (techList[i]) {
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
                    throw new IllegalArgumentException("Unknown tech type " + techList[i]);
            }
        }
        return strings;
    }

    /**
     * For use by NfcService only.
     * @hide
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.161 -0500", hash_original_method = "89421ECB0C954DB9BA373A13BA3FAA83", hash_generated_method = "DFA2B11000CECA897C63467870C7FB77")
    
public int getServiceHandle() {
        return mServiceHandle;
    }

    /**
     * Get the Tag Identifier (if it has one).
     * <p>The tag identifier is a low level serial number, used for anti-collision
     * and identification.
     * <p> Most tags have a stable unique identifier
     * (UID), but some tags will generate a random ID every time they are discovered
     * (RID), and there are some tags with no ID at all (the byte array will be zero-sized).
     * <p> The size and format of an ID is specific to the RF technology used by the tag.
     * <p> This function retrieves the ID as determined at discovery time, and does not
     * perform any further RF communication or block.
     * @return ID as byte array, never null
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.164 -0500", hash_original_method = "119449B9FCBA8EB72735DF05D41F23E7", hash_generated_method = "FD0A4E2319898FFF940A45412E87A7D1")
    
public byte[] getId() {
        return mId;
    }

    /**
     * Get the technologies available in this tag, as fully qualified class names.
     * <p>
     * A technology is an implementation of the {@link TagTechnology} interface,
     * and can be instantiated by calling the static <code>get(Tag)</code>
     * method on the implementation with this Tag. The {@link TagTechnology}
     * object can then be used to perform advanced, technology-specific operations on a tag.
     * <p>
     * Android defines a mandatory set of technologies that must be correctly
     * enumerated by all Android NFC devices, and an optional
     * set of proprietary technologies.
     * See {@link TagTechnology} for more details.
     * <p>
     * The ordering of the returned array is undefined and should not be relied upon.
     * @return an array of fully-qualified {@link TagTechnology} class-names.
     */
    @DSComment("NFC Tag")
    @DSSpec(DSCat.NFC)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.167 -0500", hash_original_method = "ED11FAFB07CA3B90E3FEDDA21BAFA279", hash_generated_method = "377B8620F029252A423DDAF8AEB3C6EB")
    
public String[] getTechList() {
        return mTechStringList;
    }

    /**
     * Rediscover the technologies available on this tag.
     * <p>
     * The technologies that are available on a tag may change due to
     * operations being performed on a tag. For example, formatting a
     * tag as NDEF adds the {@link Ndef} technology. The {@link rediscover}
     * method reenumerates the available technologies on the tag
     * and returns a new {@link Tag} object containing these technologies.
     * <p>
     * You may not be connected to any of this {@link Tag}'s technologies
     * when calling this method.
     * This method guarantees that you will be returned the same Tag
     * if it is still in the field.
     * <p>May cause RF activity and may block. Must not be called
     * from the main application thread. A blocked call will be canceled with
     * {@link IOException} by calling {@link #close} from another thread.
     * <p>Does not remove power from the RF field, so a tag having a random
     * ID should not change its ID.
     * @return the rediscovered tag object.
     * @throws IOException if the tag cannot be rediscovered
     * @hide
     */
    // TODO See if we need TagLostException
    // TODO Unhide for ICS
    // TODO Update documentation to make sure it matches with the final
    //      implementation.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.169 -0500", hash_original_method = "4E5CB2043A65C51A8349137C18388B2C", hash_generated_method = "3E537B895F03E43577FBE2EDFCCF7106")
    
public Tag rediscover() throws IOException {
        if (getConnectedTechnology() != -1) {
            throw new IllegalStateException("Close connection to the technology first!");
        }

        try {
            Tag newTag = mTagService.rediscover(getServiceHandle());
            if (newTag != null) {
                return newTag;
            } else {
                throw new IOException("Failed to rediscover tag");
            }
        } catch (RemoteException e) {
            throw new IOException("NFC service dead");
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.171 -0500", hash_original_method = "066FD8962F433FECE6D4FD3B60FADEA0", hash_generated_method = "3F71DBE8B0805DF1BA0EDFDF39CFED70")
    
public boolean hasTech(int techType) {
        for (int tech : mTechList) {
            if (tech == techType) return true;
        }
        return false;
    }

    /** @hide */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.173 -0500", hash_original_method = "31360E4A8CC1CC354A13744DCF6ABA65", hash_generated_method = "15CC7ED32290C9D9A38A33F4C04E361E")
    
public Bundle getTechExtras(int tech) {
        int pos = -1;
        for (int idx = 0; idx < mTechList.length; idx++) {
          if (mTechList[idx] == tech) {
              pos = idx;
              break;
          }
        }
        if (pos < 0) {
            return null;
        }

        return mTechExtras[pos];
    }

    /** @hide */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.175 -0500", hash_original_method = "67284B405524DECAA6F6D36DFD293E76", hash_generated_method = "B758E777D2688E4E4599BE219B7969AA")
    
public INfcTag getTagService() {
        return mTagService;
    }

    /**
     * Human-readable description of the tag, for debugging.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.178 -0500", hash_original_method = "DF673271FDC7A52A9E2682FF9A4E5D76", hash_generated_method = "200394C1FB9082BF2C7BD4C762E7152E")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TAG: Tech [");
        String[] techList = getTechList();
        int length = techList.length;
        for (int i = 0; i < length; i++) {
            sb.append(techList[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.185 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.188 -0500", hash_original_method = "B1506093B1A3D95B1E6C500EDA575BD4", hash_generated_method = "F36653C94F01518C72563792A096D133")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        // Null mTagService means this is a mock tag
        int isMock = (mTagService == null)?1:0;

        writeBytesWithNull(dest, mId);
        dest.writeInt(mTechList.length);
        dest.writeIntArray(mTechList);
        dest.writeTypedArray(mTechExtras, 0);
        dest.writeInt(mServiceHandle);
        dest.writeInt(isMock);
        if (isMock == 0) {
            dest.writeStrongBinder(mTagService.asBinder());
        }
    }

    /**
     * For internal use only.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.207 -0500", hash_original_method = "5C3F1EA15BE184F081C4AA8C7B39A394", hash_generated_method = "E087C31C6C5FD3454BA5176C483FDFA8")
    
public synchronized void setConnectedTechnology(int technology) {
        if (mConnectedTechnology == -1) {
            mConnectedTechnology = technology;
        } else {
            throw new IllegalStateException("Close other technology first!");
        }
    }

    /**
     * For internal use only.
     *
     * @hide
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.211 -0500", hash_original_method = "B7538F13EF8EEF4B4D475104909015D7", hash_generated_method = "AAFB7BA0116C4622C7944A48C6ABD11B")
    
public int getConnectedTechnology() {
        return mConnectedTechnology;
    }

    /**
     * For internal use only.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.214 -0500", hash_original_method = "4FE592F130B2AB198D9A9024B7A375C0", hash_generated_method = "C1582B949DC3C83B3D2F04C8FBD0C5A1")
    
public void setTechnologyDisconnected() {
        mConnectedTechnology = -1;
    }
}

