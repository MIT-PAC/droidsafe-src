package com.android.internal.statusbar;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;

public class StatusBarIconList implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.086 -0400", hash_original_field = "A8104D9970F89F82B51523D6732BC037", hash_generated_field = "385D0638CA3622C5900FB3D35D66BE26")

    private String[] mSlots;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.086 -0400", hash_original_field = "213712FA71FBBB4A6F7F5D2B8377C377", hash_generated_field = "8E755F370D8D50D38975B364D45EED13")

    private StatusBarIcon[] mIcons;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.087 -0400", hash_original_method = "AE97EF368FDECF0406590DF857395AB5", hash_generated_method = "3C82B70756425BA4C061A618891AA5A0")
    public  StatusBarIconList() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.087 -0400", hash_original_method = "309DCC37A238920B85D54C3574B56DDE", hash_generated_method = "20A094A266476A3FD6F407D0C2916616")
    public  StatusBarIconList(Parcel in) {
        readFromParcel(in);
        addTaint(in.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.087 -0400", hash_original_method = "0EC7FD83FC46EFCC709C5A111EEA0E42", hash_generated_method = "7D2322AC1CB5F58B3EEC9E37C5B4F6BE")
    public void readFromParcel(Parcel in) {
        this.mSlots = in.readStringArray();
        final int N = in.readInt();
        {
            mIcons = null;
        } 
        {
            mIcons = new StatusBarIcon[N];
            {
                int i = 0;
                {
                    {
                        boolean varD162EE4369D7CB8E98B458E3838F8A63_1592869494 = (in.readInt() != 0);
                        {
                            mIcons[i] = new StatusBarIcon(in);
                        } 
                    } 
                } 
            } 
        } 
        
        
        
        
            
        
            
            
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.088 -0400", hash_original_method = "65DAF69F4AC762C1C1797457361FBB3F", hash_generated_method = "38DCEFE700E44575F5D2CFCE8FB79442")
    public void writeToParcel(Parcel out, int flags) {
        out.writeStringArray(mSlots);
        {
            out.writeInt(-1);
        } 
        {
            final int N = mIcons.length;
            out.writeInt(N);
            {
                int i = 0;
                {
                    StatusBarIcon ic = mIcons[i];
                    {
                        out.writeInt(0);
                    } 
                    {
                        out.writeInt(1);
                        ic.writeToParcel(out, flags);
                    } 
                } 
            } 
        } 
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
            
        
            
            
            
                
                
                    
                
                    
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.088 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6E6393EDE0EB395C5E7DF8A7B06ADAD2")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250380587 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250380587;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.089 -0400", hash_original_method = "0586E09C5C5185E1B5D07A28F24AD5B7", hash_generated_method = "02BE0730BB5FE5EF997E9B542A38FCA1")
    public void defineSlots(String[] slots) {
        final int N = slots.length;
        String[] s = mSlots = new String[N];
        {
            int i = 0;
            {
                s[i] = slots[i];
            } 
        } 
        mIcons = new StatusBarIcon[N];
        addTaint(slots[0].getTaint());
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.089 -0400", hash_original_method = "8024CC157D8FAF0FCD4261460DE3C083", hash_generated_method = "F8A2F24F40F1E334FFDAA3F890B32585")
    public int getSlotIndex(String slot) {
        final int N = mSlots.length;
        {
            int i = 0;
            {
                {
                    boolean varDA2112855640F5DF68D5231FB240552B_1834400094 = (slot.equals(mSlots[i]));
                } 
            } 
        } 
        addTaint(slot.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692733223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692733223;
        
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.089 -0400", hash_original_method = "18E8290E0FC9CEC842564D5A893D75F8", hash_generated_method = "86A5742C1C2DA354E2B7AD236D111C6A")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720134170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720134170;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.090 -0400", hash_original_method = "F5C28F866C5BC55B13E5B475658140A5", hash_generated_method = "AC62024623008080371D9E7FBC0FCB36")
    public void setIcon(int index, StatusBarIcon icon) {
        mIcons[index] = icon.clone();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.090 -0400", hash_original_method = "5EB075B9B4A8FCAA3C94C3EC3DFC81DD", hash_generated_method = "84A66CD0BE0474DA3AABDED324FB9352")
    public void removeIcon(int index) {
        mIcons[index] = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.091 -0400", hash_original_method = "28B506564CF04E7E4762309FF5F1124B", hash_generated_method = "F492D242D4F2426E1C808F3305687BDC")
    public String getSlot(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_89955962 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_89955962 = mSlots[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_89955962.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_89955962;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.091 -0400", hash_original_method = "6B1D8C3B652540022F161D426C6FAB9E", hash_generated_method = "1A455A2246BAE3A6E7B389AA809B404C")
    public StatusBarIcon getIcon(int index) {
        StatusBarIcon varB4EAC82CA7396A68D541C85D26508E83_1284863368 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1284863368 = mIcons[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1284863368.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1284863368;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.091 -0400", hash_original_method = "3DC98D18577B41896086CB1A25B66967", hash_generated_method = "6FF3612A6623385CD006ECDA2168ABA5")
    public int getViewIndex(int index) {
        int count = 0;
        {
            int i = 0;
        } 
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939461464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939461464;
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.092 -0400", hash_original_method = "2696800C6093D03F49CA8649D9AB9ADB", hash_generated_method = "43010A6420695787C297B74D461CFE98")
    public void copyFrom(StatusBarIconList that) {
        {
            this.mSlots = null;
            this.mIcons = null;
        } 
        {
            final int N = that.mSlots.length;
            this.mSlots = new String[N];
            this.mIcons = new StatusBarIcon[N];
            {
                int i = 0;
                {
                    this.mSlots[i] = that.mSlots[i];
                    this.mIcons[i] = that.mIcons[i] != null ? that.mIcons[i].clone() : null;
                } 
            } 
        } 
        
        
            
            
        
            
            
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.092 -0400", hash_original_method = "CDB2EE3714C17FCEED2F6D337D2E6DCE", hash_generated_method = "25FCAC181F41877B8AE9B1A9CFA48336")
    public void dump(PrintWriter pw) {
        final int N = mSlots.length;
        pw.println("Icon list:");
        {
            int i = 0;
            {
                pw.printf("  %2d: (%s) %s\n", i, mSlots[i], mIcons[i]);
            } 
        } 
        addTaint(pw.getTaint());
        
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.092 -0400", hash_original_field = "BF60B0A5C3E61C77F35261BE495B6655", hash_generated_field = "05AD09550D387B8CDEADEA4178378B19")

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
    
    public StatusBarIconList createFromParcel(Parcel parcel)
        {
            return new StatusBarIconList(parcel);
        }
    
    
    public StatusBarIconList[] newArray(int size)
        {
            return new StatusBarIconList[size];
        }
    
}

