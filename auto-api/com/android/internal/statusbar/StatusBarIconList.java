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
    private String[] mSlots;
    private StatusBarIcon[] mIcons;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.523 -0400", hash_original_method = "AE97EF368FDECF0406590DF857395AB5", hash_generated_method = "3C82B70756425BA4C061A618891AA5A0")
    @DSModeled(DSC.SAFE)
    public StatusBarIconList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.523 -0400", hash_original_method = "309DCC37A238920B85D54C3574B56DDE", hash_generated_method = "AE28F9FAB1A3AA8548BF8925E417AE6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusBarIconList(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.523 -0400", hash_original_method = "0EC7FD83FC46EFCC709C5A111EEA0E42", hash_generated_method = "7EB1827516A9860D03411D6D41EAF0EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
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
                        boolean varD162EE4369D7CB8E98B458E3838F8A63_1225552548 = (in.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.523 -0400", hash_original_method = "65DAF69F4AC762C1C1797457361FBB3F", hash_generated_method = "1D9C80AA1D801A2B4A150B2162C40099")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.524 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.533 -0400", hash_original_method = "0586E09C5C5185E1B5D07A28F24AD5B7", hash_generated_method = "DC3B1687F66EBF19081783DC3670F16E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void defineSlots(String[] slots) {
        dsTaint.addTaint(slots[0]);
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
        // ---------- Original Method ----------
        //final int N = slots.length;
        //String[] s = mSlots = new String[N];
        //for (int i=0; i<N; i++) {
            //s[i] = slots[i];
        //}
        //mIcons = new StatusBarIcon[N];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.533 -0400", hash_original_method = "8024CC157D8FAF0FCD4261460DE3C083", hash_generated_method = "51900E1A0B2B9DE09631A570A4C78835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSlotIndex(String slot) {
        dsTaint.addTaint(slot);
        int N;
        N = mSlots.length;
        {
            int i;
            i = 0;
            {
                {
                    boolean varDA2112855640F5DF68D5231FB240552B_441760266 = (slot.equals(mSlots[i]));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int N = mSlots.length;
        //for (int i=0; i<N; i++) {
            //if (slot.equals(mSlots[i])) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.536 -0400", hash_original_method = "18E8290E0FC9CEC842564D5A893D75F8", hash_generated_method = "E3030E5051D5673B349BE8EFC08EF04F")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSlots.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.536 -0400", hash_original_method = "F5C28F866C5BC55B13E5B475658140A5", hash_generated_method = "3BFC56D0548276EF03CC9781A20031F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIcon(int index, StatusBarIcon icon) {
        dsTaint.addTaint(icon.dsTaint);
        dsTaint.addTaint(index);
        mIcons[index] = icon.clone();
        // ---------- Original Method ----------
        //mIcons[index] = icon.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.536 -0400", hash_original_method = "5EB075B9B4A8FCAA3C94C3EC3DFC81DD", hash_generated_method = "4C26CC3E1FFE862AF2D0D0919FA307EB")
    @DSModeled(DSC.SAFE)
    public void removeIcon(int index) {
        dsTaint.addTaint(index);
        mIcons[index] = null;
        // ---------- Original Method ----------
        //mIcons[index] = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.537 -0400", hash_original_method = "28B506564CF04E7E4762309FF5F1124B", hash_generated_method = "63CB8DDB2F6000E35609E0245D9B57BE")
    @DSModeled(DSC.SAFE)
    public String getSlot(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSlots[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.537 -0400", hash_original_method = "6B1D8C3B652540022F161D426C6FAB9E", hash_generated_method = "6A398740DBAC266F1AF6F2B0BFB11670")
    @DSModeled(DSC.SAFE)
    public StatusBarIcon getIcon(int index) {
        dsTaint.addTaint(index);
        return (StatusBarIcon)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIcons[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.537 -0400", hash_original_method = "3DC98D18577B41896086CB1A25B66967", hash_generated_method = "BE8250E405B08542C13C3CAF1814372E")
    @DSModeled(DSC.SAFE)
    public int getViewIndex(int index) {
        dsTaint.addTaint(index);
        int count;
        count = 0;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = 0;
        //for (int i=0; i<index; i++) {
            //if (mIcons[i] != null) {
                //count++;
            //}
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.538 -0400", hash_original_method = "2696800C6093D03F49CA8649D9AB9ADB", hash_generated_method = "C66D426CE1866F8CB3EC12AF39A79ACB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void copyFrom(StatusBarIconList that) {
        dsTaint.addTaint(that.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.538 -0400", hash_original_method = "CDB2EE3714C17FCEED2F6D337D2E6DCE", hash_generated_method = "EB36E44EB4328DE63290C722ADCA511F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
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
        // ---------- Original Method ----------
        //final int N = mSlots.length;
        //pw.println("Icon list:");
        //for (int i=0; i<N; i++) {
            //pw.printf("  %2d: (%s) %s\n", i, mSlots[i], mIcons[i]);
        //}
    }

    
    public static final Parcelable.Creator<StatusBarIconList> CREATOR = new Parcelable.Creator<StatusBarIconList>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.539 -0400", hash_original_method = "354247A1AB69D42F488E328F6D061A81", hash_generated_method = "37E7A0CA431B460B5E5A6247322963D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StatusBarIconList createFromParcel(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            StatusBarIconList varA8819C7F4811741B20DD19AFF28D01C0_1845933808 = (new StatusBarIconList(parcel));
            return (StatusBarIconList)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StatusBarIconList(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.539 -0400", hash_original_method = "47A24E9B64B7E6C26051215BF5A6760B", hash_generated_method = "5D2C783C234217B78C61DC0C0EA7BBFC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StatusBarIconList[] newArray(int size) {
            dsTaint.addTaint(size);
            StatusBarIconList[] varE416A0D3290623BF14A2E9A9DA4CCB8F_293281745 = (new StatusBarIconList[size]);
            return (StatusBarIconList[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StatusBarIconList[size];
        }

        
}; //Transformed anonymous class
}

