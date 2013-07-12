package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public enum Tone implements Parcelable {
    DIAL(0x01),
    BUSY(0x02),
    CONGESTION(0x03),
    RADIO_PATH_ACK(0x04),
    RADIO_PATH_NOT_AVAILABLE(0x05),
    ERROR_SPECIAL_INFO(0x06),
    CALL_WAITING(0x07),
    RINGING(0x08),
    GENERAL_BEEP(0x10),
    POSITIVE_ACK(0x11),
    NEGATIVE_ACK(0x12),
    INCOMING_SPEECH_CALL(0x13),
    INCOMING_SMS(0x14),
    CRITICAL_ALERT(0x15),
    VIBRATE_ONLY(0x20),
    HAPPY(0x30),
    SAD(0x31),
    URGENT(0x32),
    QUESTION(0x33),
    MESSAGE_RECEIVED(0x34),
    MELODY_1(0x40),
    MELODY_2(0x41),
    MELODY_3(0x42),
    MELODY_4(0x43),
    MELODY_5(0x44),
    MELODY_6(0x45),
    MELODY_7(0x46),
    MELODY_8(0x47);
    private int mValue;
    Tone(int value) {
        mValue = value;
    }
    public static Tone fromInt(int value) {
        for (Tone e : Tone.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
    Tone(Parcel in) {
        mValue = in.readInt();
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return 0;
    }
    public static final Parcelable.Creator<Tone> CREATOR = new Parcelable.Creator<Tone>() {
        public Tone createFromParcel(Parcel in) {
            return Tone.values()[in.readInt()];
        }
        public Tone[] newArray(int size) {
            return new Tone[size];
        }
    };
}
