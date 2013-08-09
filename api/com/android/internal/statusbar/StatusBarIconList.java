package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.PrintWriter;

import android.os.Parcel;
import android.os.Parcelable;





public class StatusBarIconList implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.196 -0400", hash_original_field = "A8104D9970F89F82B51523D6732BC037", hash_generated_field = "385D0638CA3622C5900FB3D35D66BE26")

    private String[] mSlots;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.196 -0400", hash_original_field = "213712FA71FBBB4A6F7F5D2B8377C377", hash_generated_field = "8E755F370D8D50D38975B364D45EED13")

    private StatusBarIcon[] mIcons;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.196 -0400", hash_original_method = "AE97EF368FDECF0406590DF857395AB5", hash_generated_method = "3C82B70756425BA4C061A618891AA5A0")
    public  StatusBarIconList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.197 -0400", hash_original_method = "309DCC37A238920B85D54C3574B56DDE", hash_generated_method = "27534C1FD522CD2308C2B658992046AF")
    public  StatusBarIconList(Parcel in) {
        addTaint(in.getTaint());
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.198 -0400", hash_original_method = "0EC7FD83FC46EFCC709C5A111EEA0E42", hash_generated_method = "92BFAAE77352478DAF50A241651F863D")
    public void readFromParcel(Parcel in) {
        this.mSlots = in.readStringArray();
        final int N = in.readInt();
        if(N < 0)        
        {
            mIcons = null;
        } //End block
        else
        {
            mIcons = new StatusBarIcon[N];
for(int i=0;i<N;i++)
            {
                if(in.readInt() != 0)                
                {
                    mIcons[i] = new StatusBarIcon(in);
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.199 -0400", hash_original_method = "65DAF69F4AC762C1C1797457361FBB3F", hash_generated_method = "02BEFEDA806A49DF5F1A6C2D78732652")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeStringArray(mSlots);
        if(mIcons == null)        
        {
            out.writeInt(-1);
        } //End block
        else
        {
            final int N = mIcons.length;
            out.writeInt(N);
for(int i=0;i<N;i++)
            {
                StatusBarIcon ic = mIcons[i];
                if(ic == null)                
                {
                    out.writeInt(0);
                } //End block
                else
                {
                    out.writeInt(1);
                    ic.writeToParcel(out, flags);
                } //End block
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.199 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "CD47698C1822C3C4D43FF94ED7107AC1")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_967881348 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450862982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450862982;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.200 -0400", hash_original_method = "0586E09C5C5185E1B5D07A28F24AD5B7", hash_generated_method = "94E99048B859037175F7694D7CCE7F8B")
    public void defineSlots(String[] slots) {
        addTaint(slots[0].getTaint());
        final int N = slots.length;
        String[] s = mSlots = new String[N];
for(int i=0;i<N;i++)
        {
            s[i] = slots[i];
        } //End block
        mIcons = new StatusBarIcon[N];
        // ---------- Original Method ----------
        //final int N = slots.length;
        //String[] s = mSlots = new String[N];
        //for (int i=0; i<N; i++) {
            //s[i] = slots[i];
        //}
        //mIcons = new StatusBarIcon[N];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.202 -0400", hash_original_method = "8024CC157D8FAF0FCD4261460DE3C083", hash_generated_method = "DB4EF2DFB121DCA94C75DA44B3E1E610")
    public int getSlotIndex(String slot) {
        addTaint(slot.getTaint());
        final int N = mSlots.length;
for(int i=0;i<N;i++)
        {
            if(slot.equals(mSlots[i]))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1950533994 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698454640 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698454640;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1421735624 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229715622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229715622;
        // ---------- Original Method ----------
        //final int N = mSlots.length;
        //for (int i=0; i<N; i++) {
            //if (slot.equals(mSlots[i])) {
                //return i;
            //}
        //}
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.203 -0400", hash_original_method = "18E8290E0FC9CEC842564D5A893D75F8", hash_generated_method = "D94C200073C2476907144BAB4F19DE96")
    public int size() {
        int var7FEA67C242D34EE38B78C60F1C771922_1902681312 = (mSlots.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708802730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708802730;
        // ---------- Original Method ----------
        //return mSlots.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.204 -0400", hash_original_method = "F5C28F866C5BC55B13E5B475658140A5", hash_generated_method = "AC62024623008080371D9E7FBC0FCB36")
    public void setIcon(int index, StatusBarIcon icon) {
        mIcons[index] = icon.clone();
        // ---------- Original Method ----------
        //mIcons[index] = icon.clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.205 -0400", hash_original_method = "5EB075B9B4A8FCAA3C94C3EC3DFC81DD", hash_generated_method = "84A66CD0BE0474DA3AABDED324FB9352")
    public void removeIcon(int index) {
        mIcons[index] = null;
        // ---------- Original Method ----------
        //mIcons[index] = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.205 -0400", hash_original_method = "28B506564CF04E7E4762309FF5F1124B", hash_generated_method = "86751BF68DB6F5D6A610C34B756BBA4B")
    public String getSlot(int index) {
        addTaint(index);
String varAF217A4CA52EBC3C66857A54F12B3111_1024640163 =         mSlots[index];
        varAF217A4CA52EBC3C66857A54F12B3111_1024640163.addTaint(taint);
        return varAF217A4CA52EBC3C66857A54F12B3111_1024640163;
        // ---------- Original Method ----------
        //return mSlots[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.205 -0400", hash_original_method = "6B1D8C3B652540022F161D426C6FAB9E", hash_generated_method = "DCD917BE3644863868317B7A78F916D0")
    public StatusBarIcon getIcon(int index) {
        addTaint(index);
StatusBarIcon var8139DC844EAAE707D899B460381F3A2F_18171099 =         mIcons[index];
        var8139DC844EAAE707D899B460381F3A2F_18171099.addTaint(taint);
        return var8139DC844EAAE707D899B460381F3A2F_18171099;
        // ---------- Original Method ----------
        //return mIcons[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.205 -0400", hash_original_method = "3DC98D18577B41896086CB1A25B66967", hash_generated_method = "51795A0ACAAD793850AA6D518265FF75")
    public int getViewIndex(int index) {
        addTaint(index);
        int count = 0;
for(int i=0;i<index;i++)
        {
            if(mIcons[i] != null)            
            {
                count++;
            } //End block
        } //End block
        int varE2942A04780E223B215EB8B663CF5353_883487487 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228308696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228308696;
        // ---------- Original Method ----------
        //int count = 0;
        //for (int i=0; i<index; i++) {
            //if (mIcons[i] != null) {
                //count++;
            //}
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.215 -0400", hash_original_method = "2696800C6093D03F49CA8649D9AB9ADB", hash_generated_method = "D82F341A3DCEADA9FB585ED78B08AAC0")
    public void copyFrom(StatusBarIconList that) {
        if(that.mSlots == null)        
        {
            this.mSlots = null;
            this.mIcons = null;
        } //End block
        else
        {
            final int N = that.mSlots.length;
            this.mSlots = new String[N];
            this.mIcons = new StatusBarIcon[N];
for(int i=0;i<N;i++)
            {
                this.mSlots[i] = that.mSlots[i];
                this.mIcons[i] = that.mIcons[i] != null ? that.mIcons[i].clone() : null;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.216 -0400", hash_original_method = "CDB2EE3714C17FCEED2F6D337D2E6DCE", hash_generated_method = "F239414EA1AE8DF0FD02480EC210817F")
    public void dump(PrintWriter pw) {
        addTaint(pw.getTaint());
        final int N = mSlots.length;
        pw.println("Icon list:");
for(int i=0;i<N;i++)
        {
            pw.printf("  %2d: (%s) %s\n", i, mSlots[i], mIcons[i]);
        } //End block
        // ---------- Original Method ----------
        //final int N = mSlots.length;
        //pw.println("Icon list:");
        //for (int i=0; i<N; i++) {
            //pw.printf("  %2d: (%s) %s\n", i, mSlots[i], mIcons[i]);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.216 -0400", hash_original_field = "BF60B0A5C3E61C77F35261BE495B6655", hash_generated_field = "05AD09550D387B8CDEADEA4178378B19")

    public static final Parcelable.Creator<StatusBarIconList> CREATOR
            = new Parcelable.Creator<StatusBarIconList>()
    {
        public StatusBarIconList createFromParcel(Parcel parcel)
        {
            return new StatusBarIconList(parcel);
        }

        @DSModeled(DSC.SAFE)
        public StatusBarIconList[] newArray(int size)
        {
            return new StatusBarIconList[size];
        }
    };
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

