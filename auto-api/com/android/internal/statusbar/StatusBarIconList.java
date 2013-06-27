package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;

public class StatusBarIconList implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.961 -0400", hash_original_field = "A8104D9970F89F82B51523D6732BC037", hash_generated_field = "385D0638CA3622C5900FB3D35D66BE26")

    private String[] mSlots;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.961 -0400", hash_original_field = "213712FA71FBBB4A6F7F5D2B8377C377", hash_generated_field = "8E755F370D8D50D38975B364D45EED13")

    private StatusBarIcon[] mIcons;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.962 -0400", hash_original_method = "AE97EF368FDECF0406590DF857395AB5", hash_generated_method = "3C82B70756425BA4C061A618891AA5A0")
    public  StatusBarIconList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.962 -0400", hash_original_method = "309DCC37A238920B85D54C3574B56DDE", hash_generated_method = "20A094A266476A3FD6F407D0C2916616")
    public  StatusBarIconList(Parcel in) {
        readFromParcel(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.970 -0400", hash_original_method = "0EC7FD83FC46EFCC709C5A111EEA0E42", hash_generated_method = "8F4482700EB917C467BFB01C14DA3CC5")
    public void readFromParcel(Parcel in) {
        this.mSlots = in.readStringArray();
        int N;
        N = in.readInt();
        {
            mIcons = null;
        } //End block
        {
            mIcons = new StatusBarIcon[N];
            {
                int i;
                i = 0;
                {
                    {
                        boolean varD162EE4369D7CB8E98B458E3838F8A63_516703908 = (in.readInt() != 0);
                        {
                            mIcons[i] = new StatusBarIcon(in);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //this.mSlots = in.readStringArray();
        //final int N = in.readInt();
        //if (N < 0) {
            //mIcons = null;
        //} else {
            //mIcons = new StatusBarIcon[N];
            //for (int i=0; i<N; i++) {
                //if (in.readInt() != 0) {
                    //mIcons[i] = new StatusBarIcon(in);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.971 -0400", hash_original_method = "65DAF69F4AC762C1C1797457361FBB3F", hash_generated_method = "5AA6CA111CDB38D274DC13CE8F9305D9")
    public void writeToParcel(Parcel out, int flags) {
        out.writeStringArray(mSlots);
        {
            out.writeInt(-1);
        } //End block
        {
            int N;
            N = mIcons.length;
            out.writeInt(N);
            {
                int i;
                i = 0;
                {
                    StatusBarIcon ic;
                    ic = mIcons[i];
                    {
                        out.writeInt(0);
                    } //End block
                    {
                        out.writeInt(1);
                        ic.writeToParcel(out, flags);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeStringArray(mSlots);
        //if (mIcons == null) {
            //out.writeInt(-1);
        //} else {
            //final int N = mIcons.length;
            //out.writeInt(N);
            //for (int i=0; i<N; i++) {
                //StatusBarIcon ic = mIcons[i];
                //if (ic == null) {
                    //out.writeInt(0);
                //} else {
                    //out.writeInt(1);
                    //ic.writeToParcel(out, flags);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.971 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F1B4B3BA03BBCDA3BFA49A0C82254E2B")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727034574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727034574;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.972 -0400", hash_original_method = "0586E09C5C5185E1B5D07A28F24AD5B7", hash_generated_method = "84C8A9475D4E4C29C225462F90D2F0A4")
    public void defineSlots(String[] slots) {
        int N;
        N = slots.length;
        String[] s;
        s = mSlots = new String[N];
        {
            int i;
            i = 0;
            {
                s[i] = slots[i];
            } //End block
        } //End collapsed parenthetic
        mIcons = new StatusBarIcon[N];
        addTaint(slots[0].getTaint());
        // ---------- Original Method ----------
        //final int N = slots.length;
        //String[] s = mSlots = new String[N];
        //for (int i=0; i<N; i++) {
            //s[i] = slots[i];
        //}
        //mIcons = new StatusBarIcon[N];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.975 -0400", hash_original_method = "8024CC157D8FAF0FCD4261460DE3C083", hash_generated_method = "38011051EF0369A2CF0BD99CB8339227")
    public int getSlotIndex(String slot) {
        int N;
        N = mSlots.length;
        {
            int i;
            i = 0;
            {
                {
                    boolean varDA2112855640F5DF68D5231FB240552B_1363781504 = (slot.equals(mSlots[i]));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(slot.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570351547 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570351547;
        // ---------- Original Method ----------
        //final int N = mSlots.length;
        //for (int i=0; i<N; i++) {
            //if (slot.equals(mSlots[i])) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.979 -0400", hash_original_method = "18E8290E0FC9CEC842564D5A893D75F8", hash_generated_method = "A745D4771DE2CA141A7A6D29794DF08B")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1776106719 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1776106719;
        // ---------- Original Method ----------
        //return mSlots.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.980 -0400", hash_original_method = "F5C28F866C5BC55B13E5B475658140A5", hash_generated_method = "AC62024623008080371D9E7FBC0FCB36")
    public void setIcon(int index, StatusBarIcon icon) {
        mIcons[index] = icon.clone();
        // ---------- Original Method ----------
        //mIcons[index] = icon.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.980 -0400", hash_original_method = "5EB075B9B4A8FCAA3C94C3EC3DFC81DD", hash_generated_method = "84A66CD0BE0474DA3AABDED324FB9352")
    public void removeIcon(int index) {
        mIcons[index] = null;
        // ---------- Original Method ----------
        //mIcons[index] = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.980 -0400", hash_original_method = "28B506564CF04E7E4762309FF5F1124B", hash_generated_method = "7DB2A5E4E8931065007635F6546A940B")
    public String getSlot(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_190760755 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_190760755 = mSlots[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_190760755.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_190760755;
        // ---------- Original Method ----------
        //return mSlots[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.985 -0400", hash_original_method = "6B1D8C3B652540022F161D426C6FAB9E", hash_generated_method = "99C4AEA9C15C234E265DB5DA32B656FF")
    public StatusBarIcon getIcon(int index) {
        StatusBarIcon varB4EAC82CA7396A68D541C85D26508E83_1302078555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1302078555 = mIcons[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1302078555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1302078555;
        // ---------- Original Method ----------
        //return mIcons[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.987 -0400", hash_original_method = "3DC98D18577B41896086CB1A25B66967", hash_generated_method = "84006797B832FF3C32DAF878FF7970DA")
    public int getViewIndex(int index) {
        int count;
        count = 0;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209317579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209317579;
        // ---------- Original Method ----------
        //int count = 0;
        //for (int i=0; i<index; i++) {
            //if (mIcons[i] != null) {
                //count++;
            //}
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.992 -0400", hash_original_method = "2696800C6093D03F49CA8649D9AB9ADB", hash_generated_method = "7F62248FFEA401CD31A6CB1E24E9048E")
    public void copyFrom(StatusBarIconList that) {
        {
            this.mSlots = null;
            this.mIcons = null;
        } //End block
        {
            int N;
            N = that.mSlots.length;
            this.mSlots = new String[N];
            this.mIcons = new StatusBarIcon[N];
            {
                int i;
                i = 0;
                {
                    this.mSlots[i] = that.mSlots[i];
                    this.mIcons[i] = that.mIcons[i] != null ? that.mIcons[i].clone() : null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (that.mSlots == null) {
            //this.mSlots = null;
            //this.mIcons = null;
        //} else {
            //final int N = that.mSlots.length;
            //this.mSlots = new String[N];
            //this.mIcons = new StatusBarIcon[N];
            //for (int i=0; i<N; i++) {
                //this.mSlots[i] = that.mSlots[i];
                //this.mIcons[i] = that.mIcons[i] != null ? that.mIcons[i].clone() : null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.005 -0400", hash_original_method = "CDB2EE3714C17FCEED2F6D337D2E6DCE", hash_generated_method = "A1905F493C45C6323AD7E5F84733110A")
    public void dump(PrintWriter pw) {
        int N;
        N = mSlots.length;
        pw.println("Icon list:");
        {
            int i;
            i = 0;
            {
                pw.printf("  %2d: (%s) %s\n", i, mSlots[i], mIcons[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(pw.getTaint());
        // ---------- Original Method ----------
        //final int N = mSlots.length;
        //pw.println("Icon list:");
        //for (int i=0; i<N; i++) {
            //pw.printf("  %2d: (%s) %s\n", i, mSlots[i], mIcons[i]);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.005 -0400", hash_original_field = "BF60B0A5C3E61C77F35261BE495B6655", hash_generated_field = "05AD09550D387B8CDEADEA4178378B19")

    public static final Parcelable.Creator<StatusBarIconList> CREATOR
            = new Parcelable.Creator<StatusBarIconList>()
    {
        public StatusBarIconList createFromParcel(Parcel parcel)
        {
            return new StatusBarIconList(parcel);
        }

        public StatusBarIconList[] newArray(int size)
        {
            return new StatusBarIconList[size];
        }
    };
}

