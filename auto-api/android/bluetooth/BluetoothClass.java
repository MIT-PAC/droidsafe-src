package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;

public final class BluetoothClass implements Parcelable {
    public static final int ERROR = 0xFF000000;
    private final int mClass;
    public static final Parcelable.Creator<BluetoothClass> CREATOR = new Parcelable.Creator<BluetoothClass>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.089 -0400", hash_original_method = "B44CE55AFB9D52E11C79A0FBA01F5306", hash_generated_method = "87885394D7FA89B22173343B801DE987")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BluetoothClass createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            BluetoothClass varA83476DE8780365ABFB306206A67DD4B_1613727056 = (new BluetoothClass(in.readInt()));
            return (BluetoothClass)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BluetoothClass(in.readInt());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.089 -0400", hash_original_method = "6DF43DA1CA065C9A6D59AF5E5C74F432", hash_generated_method = "06173B2FDEBC187D046BDE6EE1FC4014")
        @DSModeled(DSC.SAFE)
        public BluetoothClass[] newArray(int size) {
            dsTaint.addTaint(size);
            return (BluetoothClass[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BluetoothClass[size];
        }

        
}; //Transformed anonymous class
    public static final int PROFILE_HEADSET = 0;
    public static final int PROFILE_A2DP = 1;
    public static final int PROFILE_OPP = 2;
    public static final int PROFILE_HID = 3;
    public static final int PROFILE_PANU = 4;
    public static final int PROFILE_NAP = 5;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.090 -0400", hash_original_method = "3018CA2607FD366405F97E43B06E77B3", hash_generated_method = "0E39B3EC4B0B6D0B525B76340DF47A01")
    @DSModeled(DSC.SAFE)
    public BluetoothClass(int classInt) {
        dsTaint.addTaint(classInt);
        mClass = classInt;
        // ---------- Original Method ----------
        //mClass = classInt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.090 -0400", hash_original_method = "217E4DCE2F47DBEE08566901FB7CC9C3", hash_generated_method = "9A4E1DA4CC8FB1CA2CD6558C9C659B7E")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o instanceof BluetoothClass) {
            //return mClass == ((BluetoothClass)o).mClass;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.090 -0400", hash_original_method = "874CCBA476992320BB2BF01B58BECDFE", hash_generated_method = "2988A8BE93C3C6E4ABD31B1F5D8DBA77")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.091 -0400", hash_original_method = "E65C8DBAA86595E02DE1992FA15205E3", hash_generated_method = "B19B3AA64E39F30D89B3C618A20EFC98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varBE27F4A29446CCCA08E8F9A0C1290748_1764144993 = (Integer.toHexString(mClass));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toHexString(mClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.091 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.091 -0400", hash_original_method = "E9C9429EDCD73ADBF440E8A3499B15C0", hash_generated_method = "A95C7FA07467AB35D002B4D7E46CDB5C")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(mClass);
        // ---------- Original Method ----------
        //out.writeInt(mClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.091 -0400", hash_original_method = "A40FEF9DD742C9180312A83CC46BA74D", hash_generated_method = "EE66DE5FF3E295247E937C9264367098")
    @DSModeled(DSC.SAFE)
    public boolean hasService(int service) {
        dsTaint.addTaint(service);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((mClass & Service.BITMASK & service) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.092 -0400", hash_original_method = "3B15E8C4111EC35F10AF5C168F9A121C", hash_generated_method = "442CD8DC152D6F36F52CAB95B03E6326")
    @DSModeled(DSC.SAFE)
    public int getMajorDeviceClass() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mClass & Device.Major.BITMASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.092 -0400", hash_original_method = "BA237D1BE1EA8EE11A66DDAAF0ED747D", hash_generated_method = "7337CD9FDE39022F59805415D2C93063")
    @DSModeled(DSC.SAFE)
    public int getDeviceClass() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mClass & Device.BITMASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.093 -0400", hash_original_method = "21B6C08F5C9193686AC48EB890043753", hash_generated_method = "4211D74F3DE3688BDDB8E6CE0512C1A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean doesClassMatch(int profile) {
        dsTaint.addTaint(profile);
        {
            {
                boolean var1518D4E88F6EB41C53E9DE44FD4AB61C_296928552 = (hasService(Service.RENDER));
            } //End collapsed parenthetic
            {
                Object var17F81B521E368BAE2E74CCA8AC416FC5_1649357054 = (getDeviceClass());
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var1518D4E88F6EB41C53E9DE44FD4AB61C_1389777538 = (hasService(Service.RENDER));
            } //End collapsed parenthetic
            {
                Object var17F81B521E368BAE2E74CCA8AC416FC5_2126445126 = (getDeviceClass());
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varCE399214172FB5FC9D7D96FD6420BABC_2037507862 = (hasService(Service.OBJECT_TRANSFER));
            } //End collapsed parenthetic
            {
                Object var17F81B521E368BAE2E74CCA8AC416FC5_152510226 = (getDeviceClass());
            } //End collapsed parenthetic
        } //End block
        {
            boolean var2A0838C829B833A3CFC4FC68AE91705C_507132287 = ((getDeviceClass() & Device.Major.PERIPHERAL) == Device.Major.PERIPHERAL);
        } //End block
        {
            {
                boolean var7A28A07EE95956CED6932313A971D58F_236197708 = (hasService(Service.NETWORKING));
            } //End collapsed parenthetic
            boolean var14B6554B931E9C4DE28D461A70148A43_1097171154 = ((getDeviceClass() & Device.Major.NETWORKING) == Device.Major.NETWORKING);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final class Service {
        private static final int BITMASK                 = 0xFFE000;
        public static final int LIMITED_DISCOVERABILITY = 0x002000;
        public static final int POSITIONING             = 0x010000;
        public static final int NETWORKING              = 0x020000;
        public static final int RENDER                  = 0x040000;
        public static final int CAPTURE                 = 0x080000;
        public static final int OBJECT_TRANSFER         = 0x100000;
        public static final int AUDIO                   = 0x200000;
        public static final int TELEPHONY               = 0x400000;
        public static final int INFORMATION             = 0x800000;
        
    }


    
    public static class Device {
        private static final int BITMASK               = 0x1FFC;
        public static final int COMPUTER_UNCATEGORIZED              = 0x0100;
        public static final int COMPUTER_DESKTOP                    = 0x0104;
        public static final int COMPUTER_SERVER                     = 0x0108;
        public static final int COMPUTER_LAPTOP                     = 0x010C;
        public static final int COMPUTER_HANDHELD_PC_PDA            = 0x0110;
        public static final int COMPUTER_PALM_SIZE_PC_PDA           = 0x0114;
        public static final int COMPUTER_WEARABLE                   = 0x0118;
        public static final int PHONE_UNCATEGORIZED                 = 0x0200;
        public static final int PHONE_CELLULAR                      = 0x0204;
        public static final int PHONE_CORDLESS                      = 0x0208;
        public static final int PHONE_SMART                         = 0x020C;
        public static final int PHONE_MODEM_OR_GATEWAY              = 0x0210;
        public static final int PHONE_ISDN                          = 0x0214;
        public static final int AUDIO_VIDEO_UNCATEGORIZED           = 0x0400;
        public static final int AUDIO_VIDEO_WEARABLE_HEADSET        = 0x0404;
        public static final int AUDIO_VIDEO_HANDSFREE               = 0x0408;
        public static final int AUDIO_VIDEO_MICROPHONE              = 0x0410;
        public static final int AUDIO_VIDEO_LOUDSPEAKER             = 0x0414;
        public static final int AUDIO_VIDEO_HEADPHONES              = 0x0418;
        public static final int AUDIO_VIDEO_PORTABLE_AUDIO          = 0x041C;
        public static final int AUDIO_VIDEO_CAR_AUDIO               = 0x0420;
        public static final int AUDIO_VIDEO_SET_TOP_BOX             = 0x0424;
        public static final int AUDIO_VIDEO_HIFI_AUDIO              = 0x0428;
        public static final int AUDIO_VIDEO_VCR                     = 0x042C;
        public static final int AUDIO_VIDEO_VIDEO_CAMERA            = 0x0430;
        public static final int AUDIO_VIDEO_CAMCORDER               = 0x0434;
        public static final int AUDIO_VIDEO_VIDEO_MONITOR           = 0x0438;
        public static final int AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER = 0x043C;
        public static final int AUDIO_VIDEO_VIDEO_CONFERENCING      = 0x0440;
        public static final int AUDIO_VIDEO_VIDEO_GAMING_TOY        = 0x0448;
        public static final int WEARABLE_UNCATEGORIZED              = 0x0700;
        public static final int WEARABLE_WRIST_WATCH                = 0x0704;
        public static final int WEARABLE_PAGER                      = 0x0708;
        public static final int WEARABLE_JACKET                     = 0x070C;
        public static final int WEARABLE_HELMET                     = 0x0710;
        public static final int WEARABLE_GLASSES                    = 0x0714;
        public static final int TOY_UNCATEGORIZED                   = 0x0800;
        public static final int TOY_ROBOT                           = 0x0804;
        public static final int TOY_VEHICLE                         = 0x0808;
        public static final int TOY_DOLL_ACTION_FIGURE              = 0x080C;
        public static final int TOY_CONTROLLER                      = 0x0810;
        public static final int TOY_GAME                            = 0x0814;
        public static final int HEALTH_UNCATEGORIZED                = 0x0900;
        public static final int HEALTH_BLOOD_PRESSURE               = 0x0904;
        public static final int HEALTH_THERMOMETER                  = 0x0908;
        public static final int HEALTH_WEIGHING                     = 0x090C;
        public static final int HEALTH_GLUCOSE                      = 0x0910;
        public static final int HEALTH_PULSE_OXIMETER               = 0x0914;
        public static final int HEALTH_PULSE_RATE                   = 0x0918;
        public static final int HEALTH_DATA_DISPLAY                 = 0x091C;
        public static final int PERIPHERAL_NON_KEYBOARD_NON_POINTING = 0x0500;
        public static final int PERIPHERAL_KEYBOARD                  = 0x0540;
        public static final int PERIPHERAL_POINTING                  = 0x0580;
        public static final int PERIPHERAL_KEYBOARD_POINTING         = 0x05C0;
        
        public static class Major {
            private static final int BITMASK           = 0x1F00;
            public static final int MISC              = 0x0000;
            public static final int COMPUTER          = 0x0100;
            public static final int PHONE             = 0x0200;
            public static final int NETWORKING        = 0x0300;
            public static final int AUDIO_VIDEO       = 0x0400;
            public static final int PERIPHERAL        = 0x0500;
            public static final int IMAGING           = 0x0600;
            public static final int WEARABLE          = 0x0700;
            public static final int TOY               = 0x0800;
            public static final int HEALTH            = 0x0900;
            public static final int UNCATEGORIZED     = 0x1F00;
            
        }


        
    }


    
}


