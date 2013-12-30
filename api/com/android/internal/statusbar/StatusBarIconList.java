package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;

import android.os.Parcel;
import android.os.Parcelable;





public class StatusBarIconList implements Parcelable {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.216 -0400", hash_original_field = "BF60B0A5C3E61C77F35261BE495B6655", hash_generated_field = "05AD09550D387B8CDEADEA4178378B19")

    public static final Parcelable.Creator<StatusBarIconList> CREATOR
            = new Parcelable.Creator<StatusBarIconList>()
    {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.347 -0500", hash_original_method = "354247A1AB69D42F488E328F6D061A81", hash_generated_method = "EDC3BABD4CACD72FBDF34205B19397E4")
        
public StatusBarIconList createFromParcel(Parcel parcel)
        {
            return new StatusBarIconList(parcel);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.350 -0500", hash_original_method = "47A24E9B64B7E6C26051215BF5A6760B", hash_generated_method = "DB21311B2410F1200E9CD817D926B83A")
        
public StatusBarIconList[] newArray(int size)
        {
            return new StatusBarIconList[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.330 -0500", hash_original_field = "3544E697BD59263465F3572E76248FF8", hash_generated_field = "385D0638CA3622C5900FB3D35D66BE26")

    private String[] mSlots;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.332 -0500", hash_original_field = "155CF15E85B1127EFA064012523A39BF", hash_generated_field = "8E755F370D8D50D38975B364D45EED13")

    private StatusBarIcon[] mIcons;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.334 -0500", hash_original_method = "AE97EF368FDECF0406590DF857395AB5", hash_generated_method = "EF7F956843935C6E574AB062FB991A25")
    
public StatusBarIconList() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.337 -0500", hash_original_method = "309DCC37A238920B85D54C3574B56DDE", hash_generated_method = "A304DC4D1495EA5167EF661E16052E40")
    
public StatusBarIconList(Parcel in) {
        readFromParcel(in);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.339 -0500", hash_original_method = "0EC7FD83FC46EFCC709C5A111EEA0E42", hash_generated_method = "6E77911930D224B16FEC921C9CA677B4")
    
public void readFromParcel(Parcel in) {
        this.mSlots = in.readStringArray();
        final int N = in.readInt();
        if (N < 0) {
            mIcons = null;
        } else {
            mIcons = new StatusBarIcon[N];
            for (int i=0; i<N; i++) {
                if (in.readInt() != 0) {
                    mIcons[i] = new StatusBarIcon(in);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.342 -0500", hash_original_method = "65DAF69F4AC762C1C1797457361FBB3F", hash_generated_method = "01C81874D4F50459888BB3EFC45F1F84")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeStringArray(mSlots);
        if (mIcons == null) {
            out.writeInt(-1);
        } else {
            final int N = mIcons.length;
            out.writeInt(N);
            for (int i=0; i<N; i++) {
                StatusBarIcon ic = mIcons[i];
                if (ic == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    ic.writeToParcel(out, flags);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.344 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.354 -0500", hash_original_method = "0586E09C5C5185E1B5D07A28F24AD5B7", hash_generated_method = "35F9198138734BC461E2C528402666D6")
    
public void defineSlots(String[] slots) {
        final int N = slots.length;
        String[] s = mSlots = new String[N];
        for (int i=0; i<N; i++) {
            s[i] = slots[i];
        }
        mIcons = new StatusBarIcon[N];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.356 -0500", hash_original_method = "8024CC157D8FAF0FCD4261460DE3C083", hash_generated_method = "4314FCC74F7582E002F42C4C0A1A564A")
    
public int getSlotIndex(String slot) {
        final int N = mSlots.length;
        for (int i=0; i<N; i++) {
            if (slot.equals(mSlots[i])) {
                return i;
            }
        }
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.359 -0500", hash_original_method = "18E8290E0FC9CEC842564D5A893D75F8", hash_generated_method = "A3CF8AA65C55ECFAA1F5192B38A6C7C7")
    
public int size() {
        return mSlots.length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.361 -0500", hash_original_method = "F5C28F866C5BC55B13E5B475658140A5", hash_generated_method = "97A2FE35DE66E9EA4C096B83F572B6F8")
    
public void setIcon(int index, StatusBarIcon icon) {
        mIcons[index] = icon.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.364 -0500", hash_original_method = "5EB075B9B4A8FCAA3C94C3EC3DFC81DD", hash_generated_method = "15B89D56BFCEC28C01EE0BAFE72FEDD6")
    
public void removeIcon(int index) {
        mIcons[index] = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.366 -0500", hash_original_method = "28B506564CF04E7E4762309FF5F1124B", hash_generated_method = "A60B3AB2417208200723EE294F60C28E")
    
public String getSlot(int index) {
        return mSlots[index];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.368 -0500", hash_original_method = "6B1D8C3B652540022F161D426C6FAB9E", hash_generated_method = "F97DBB74E33C6A227E09F73DB1FDC795")
    
public StatusBarIcon getIcon(int index) {
        return mIcons[index];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.370 -0500", hash_original_method = "3DC98D18577B41896086CB1A25B66967", hash_generated_method = "A22F67BD4610295A9B443E7F5CD2CB19")
    
public int getViewIndex(int index) {
        int count = 0;
        for (int i=0; i<index; i++) {
            if (mIcons[i] != null) {
                count++;
            }
        }
        return count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.373 -0500", hash_original_method = "2696800C6093D03F49CA8649D9AB9ADB", hash_generated_method = "C2E1D02B98B6EA77CB3450F3C0C469A4")
    
public void copyFrom(StatusBarIconList that) {
        if (that.mSlots == null) {
            this.mSlots = null;
            this.mIcons = null;
        } else {
            final int N = that.mSlots.length;
            this.mSlots = new String[N];
            this.mIcons = new StatusBarIcon[N];
            for (int i=0; i<N; i++) {
                this.mSlots[i] = that.mSlots[i];
                this.mIcons[i] = that.mIcons[i] != null ? that.mIcons[i].clone() : null;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.375 -0500", hash_original_method = "CDB2EE3714C17FCEED2F6D337D2E6DCE", hash_generated_method = "E9725B37F93016162A00BD8F3959BB96")
    
public void dump(PrintWriter pw) {
        final int N = mSlots.length;
        pw.println("Icon list:");
        for (int i=0; i<N; i++) {
            pw.printf("  %2d: (%s) %s\n", i, mSlots[i], mIcons[i]);
        }
    }
    // orphaned legacy method
    public StatusBarIconList createFromParcel(Parcel parcel)
        {
            return new StatusBarIconList(parcel);
        }
    
    // orphaned legacy method
    public StatusBarIconList[] newArray(int size)
        {
            return new StatusBarIconList[size];
        }
    
}

