package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IccIoResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.540 -0400", hash_original_field = "CF7AB46209C6D3BE84FA81C940CD6249", hash_generated_field = "605D00358F6732BF4A4D044EA247A970")

    public int sw1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.540 -0400", hash_original_field = "9EEA8D4260140900C6819477BB4E6D89", hash_generated_field = "3291FE8B1F0E4F6843EB8729B855E0A4")

    public int sw2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.540 -0400", hash_original_field = "321C3CF486ED509164EDEC1E1981FEC8", hash_generated_field = "85C99161735D908FB014CA702C49895B")

    public byte[] payload;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.541 -0400", hash_original_method = "FC114C268C65B1E20AA18C3590A39E31", hash_generated_method = "C79C721930FC7A3D7D5BF6B30DC8FA95")
    public  IccIoResult(int sw1, int sw2, byte[] payload) {
        this.sw1 = sw1;
        this.sw2 = sw2;
        this.payload = payload;
        // ---------- Original Method ----------
        //this.sw1 = sw1;
        //this.sw2 = sw2;
        //this.payload = payload;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.541 -0400", hash_original_method = "ECAE0DFB5EB8DE1F7EC625CCCC39CE4E", hash_generated_method = "61F02DB6780F5F498BA14BC02DA0F5D6")
    public  IccIoResult(int sw1, int sw2, String hexString) {
        this(sw1, sw2, IccUtils.hexStringToBytes(hexString));
        addTaint(hexString.getTaint());
        addTaint(sw2);
        addTaint(sw1);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.541 -0400", hash_original_method = "C2E2D21A49FBAEB09CAD48E279230B17", hash_generated_method = "14CD06AE99D1090EC6B4C0899237A089")
    public String toString() {
String varE49F1C2CA3932E94AEDB8A58B7457D2E_492476169 =         "IccIoResponse sw1:0x" + Integer.toHexString(sw1) + " sw2:0x"
                + Integer.toHexString(sw2);
        varE49F1C2CA3932E94AEDB8A58B7457D2E_492476169.addTaint(taint);
        return varE49F1C2CA3932E94AEDB8A58B7457D2E_492476169;
        // ---------- Original Method ----------
        //return "IccIoResponse sw1:0x" + Integer.toHexString(sw1) + " sw2:0x"
                //+ Integer.toHexString(sw2);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.542 -0400", hash_original_method = "E45E4CA02C1498571B14F8EF02CBA542", hash_generated_method = "C2A0EF16EB598FC7249AE24A7AB8551E")
    public boolean success() {
        boolean var6542F7F14374E68C5016419CC02AA14E_1144593969 = (sw1 == 0x90 || sw1 == 0x91 || sw1 == 0x9e || sw1 == 0x9f);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663824373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663824373;
        // ---------- Original Method ----------
        //return sw1 == 0x90 || sw1 == 0x91 || sw1 == 0x9e || sw1 == 0x9f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.542 -0400", hash_original_method = "6314A49369EA2E2C83A84515E57327FB", hash_generated_method = "2F985EFF719F5CDE1DAD4AE03DC9BC0D")
    public IccException getException() {
    if(success())        
        {
IccException var540C13E9E156B687226421B24F2DF178_1307169091 =         null;
        var540C13E9E156B687226421B24F2DF178_1307169091.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1307169091;
        }
switch(sw1){
        case 0x94:
    if(sw2 == 0x08)        
        {
IccException varAFB9C09DEC4FB830E1678213BAA51DD0_1249360502 =             new IccFileTypeMismatch();
            varAFB9C09DEC4FB830E1678213BAA51DD0_1249360502.addTaint(taint);
            return varAFB9C09DEC4FB830E1678213BAA51DD0_1249360502;
        } //End block
        else
        {
IccException var0F208294AB5728199CC9C0792CD88155_1944440951 =             new IccFileNotFound();
            var0F208294AB5728199CC9C0792CD88155_1944440951.addTaint(taint);
            return var0F208294AB5728199CC9C0792CD88155_1944440951;
        } //End block
        default:
IccException var15BBD07E330DFE30352C79F17F24ADE9_1186035638 =         new IccException("sw1:" + sw1 + " sw2:" + sw2);
        var15BBD07E330DFE30352C79F17F24ADE9_1186035638.addTaint(taint);
        return var15BBD07E330DFE30352C79F17F24ADE9_1186035638;
}
        // ---------- Original Method ----------
        //if (success()) return null;
        //switch (sw1) {
            //case 0x94:
                //if (sw2 == 0x08) {
                    //return new IccFileTypeMismatch();
                //} else {
                    //return new IccFileNotFound();
                //}
            //default:
                //return new IccException("sw1:" + sw1 + " sw2:" + sw2);
        //}
    }

    
}

