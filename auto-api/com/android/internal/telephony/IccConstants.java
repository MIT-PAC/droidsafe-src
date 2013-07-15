package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface IccConstants {
    
    static final int EF_ADN = 0x6F3A;
    static final int EF_FDN = 0x6F3B;
    static final int EF_SDN = 0x6F49;
    static final int EF_EXT1 = 0x6F4A;
    static final int EF_EXT2 = 0x6F4B;
    static final int EF_EXT3 = 0x6F4C;
    static final int EF_EXT6 = 0x6fc8;   
    static final int EF_MWIS = 0x6FCA;
    static final int EF_MBDN = 0x6fc7;
    static final int EF_PNN = 0x6fc5;
    static final int EF_SPN = 0x6F46;
    static final int EF_SMS = 0x6F3C;
    static final int EF_ICCID = 0x2fe2;
    static final int EF_AD = 0x6FAD;
    static final int EF_MBI = 0x6fc9;
    static final int EF_MSISDN = 0x6f40;
    static final int EF_SPDI = 0x6fcd;
    static final int EF_SST = 0x6f38;
    static final int EF_CFIS = 0x6FCB;
    static final int EF_IMG = 0x4f20;

    
    public static final int EF_PBR = 0x4F30;

    
    static final int EF_MAILBOX_CPHS = 0x6F17;
    static final int EF_VOICE_MAIL_INDICATOR_CPHS = 0x6F11;
    static final int EF_CFF_CPHS = 0x6F13;
    static final int EF_SPN_CPHS = 0x6f14;
    static final int EF_SPN_SHORT_CPHS = 0x6f18;
    static final int EF_INFO_CPHS = 0x6f16;
    static final int EF_CSP_CPHS = 0x6f15;

    
    static final int EF_CST = 0x6f32;
    static final int EF_RUIM_SPN =0x6F41;

    
    static final int EF_PL = 0x2F05;
    
    static final int EF_CSIM_LI = 0x6F3A;
    static final int EF_CSIM_SPN =0x6F41;
    static final int EF_CSIM_MDN = 0x6F44;
    static final int EF_CSIM_IMSIM = 0x6F22;
    static final int EF_CSIM_CDMAHOME = 0x6F28;
    static final int EF_CSIM_EPRL = 0x6F5A;

    
    static final int EF_IMPU = 0x6f04;
    static final int EF_IMPI = 0x6f02;
    static final int EF_DOMAIN = 0x6f03;
    static final int EF_IST = 0x6f07;
    static final int EF_PCSCF = 0x6f09;

    
    static public final int SMS_RECORD_LENGTH = 176;

    static final String MF_SIM = "3F00";
    static final String DF_TELECOM = "7F10";
    static final String DF_PHONEBOOK = "5F3A";
    static final String DF_GRAPHICS = "5F50";
    static final String DF_GSM = "7F20";
    static final String DF_CDMA = "7F25";

    
    static final String DF_ADFISIM = "7FFF";
}
