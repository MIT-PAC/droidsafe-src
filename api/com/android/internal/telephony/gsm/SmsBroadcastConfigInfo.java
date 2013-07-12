package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class SmsBroadcastConfigInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.657 -0400", hash_original_field = "6CB791FB42180E76757B8CE655EA63BC", hash_generated_field = "333B1EBCCD576A11F3929B04C911A0CC")

    private int fromServiceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.657 -0400", hash_original_field = "78C07AB482FAE915C24343F7756E27DF", hash_generated_field = "21D520383BDB72483F46B478E9E8442E")

    private int toServiceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.657 -0400", hash_original_field = "45B1CAD460DB900C18FFF089139DC888", hash_generated_field = "1C45CBAE9BFCDDAE4B54CFFD731AE53A")

    private int fromCodeScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.657 -0400", hash_original_field = "E65C94DD69C903E23E4B04500887A5B3", hash_generated_field = "6C4271AD3AC2111E09C7BAF5CEECEDA7")

    private int toCodeScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.657 -0400", hash_original_field = "EF7DE3F485174FF47F061AD27D83D0EE", hash_generated_field = "63F1085A29CC1E5353801D8BBF9C9BF5")

    private boolean selected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.659 -0400", hash_original_method = "9D05E73016D00F2A428351060541CD33", hash_generated_method = "24427794CEEB7051C06B777AC42D0B80")
    public  SmsBroadcastConfigInfo(int fromId, int toId, int fromScheme,
            int toScheme, boolean selected) {
        fromServiceId = fromId;
        toServiceId = toId;
        fromCodeScheme = fromScheme;
        toCodeScheme = toScheme;
        this.selected = selected;
        // ---------- Original Method ----------
        //fromServiceId = fromId;
        //toServiceId = toId;
        //fromCodeScheme = fromScheme;
        //toCodeScheme = toScheme;
        //this.selected = selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.661 -0400", hash_original_method = "EC03A9EAB74ED9CD08C5E767148A9E3D", hash_generated_method = "496707E01480A77738DBF7D33FB881B0")
    public void setFromServiceId(int fromServiceId) {
        this.fromServiceId = fromServiceId;
        // ---------- Original Method ----------
        //this.fromServiceId = fromServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.661 -0400", hash_original_method = "000CFE123E4AC86430B83F6EA13C644C", hash_generated_method = "BC559D1F4888B8E0FDE80E89C6FB05BA")
    public int getFromServiceId() {
        int var6CB791FB42180E76757B8CE655EA63BC_163402435 = (fromServiceId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396954230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396954230;
        // ---------- Original Method ----------
        //return fromServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.662 -0400", hash_original_method = "C662FD0745B0F3A8663C07D8F01AF54F", hash_generated_method = "9127DC336ABDEEC77E06814D5ECDD0CD")
    public void setToServiceId(int toServiceId) {
        this.toServiceId = toServiceId;
        // ---------- Original Method ----------
        //this.toServiceId = toServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.662 -0400", hash_original_method = "708E088605DA57A3DA16BEEB2BE47BA2", hash_generated_method = "CE68E151B5F605E0F946B4D9C86FA2CD")
    public int getToServiceId() {
        int var78C07AB482FAE915C24343F7756E27DF_843032713 = (toServiceId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_780565115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_780565115;
        // ---------- Original Method ----------
        //return toServiceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.663 -0400", hash_original_method = "0A2734671D04AE4B45C1C1B3377422E5", hash_generated_method = "CC8CD577D428ADAA8EA094CC4841F1E7")
    public void setFromCodeScheme(int fromCodeScheme) {
        this.fromCodeScheme = fromCodeScheme;
        // ---------- Original Method ----------
        //this.fromCodeScheme = fromCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.663 -0400", hash_original_method = "7AEC5FB7E81910AF5A7A8C716EA8E7A5", hash_generated_method = "1E1866308A387DBF716BBCB83117D14B")
    public int getFromCodeScheme() {
        int var45B1CAD460DB900C18FFF089139DC888_346437160 = (fromCodeScheme);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019302369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019302369;
        // ---------- Original Method ----------
        //return fromCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.664 -0400", hash_original_method = "33ACE8C1E6B66F0AD44209B7329819FD", hash_generated_method = "E3018D7A149FE0867ABD4D0307C6F9A0")
    public void setToCodeScheme(int toCodeScheme) {
        this.toCodeScheme = toCodeScheme;
        // ---------- Original Method ----------
        //this.toCodeScheme = toCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.664 -0400", hash_original_method = "70F3C47437BA22E7BE36EFF6F1AA8F5B", hash_generated_method = "0AADD95F04784753215A6C0BC38FBE58")
    public int getToCodeScheme() {
        int varE65C94DD69C903E23E4B04500887A5B3_658600001 = (toCodeScheme);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220419362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220419362;
        // ---------- Original Method ----------
        //return toCodeScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.664 -0400", hash_original_method = "F22B16E73947604A26216421AD1B5C38", hash_generated_method = "6A3776683D035BBD3F20B198F2F711A3")
    public void setSelected(boolean selected) {
        this.selected = selected;
        // ---------- Original Method ----------
        //this.selected = selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.664 -0400", hash_original_method = "4072656BD90ABB561422ECCC238321A3", hash_generated_method = "233D4202693D917EE406117A7D6E6BFF")
    public boolean isSelected() {
        boolean varEF7DE3F485174FF47F061AD27D83D0EE_1306066204 = (selected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_186023511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_186023511;
        // ---------- Original Method ----------
        //return selected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.665 -0400", hash_original_method = "7023ED8B006DA79CC4837559B31EDFCC", hash_generated_method = "359C0F25FA54F56C3909C167B95FB9EF")
    @Override
    public String toString() {
String var50EAF3103BF752B9B6100D7A179A216D_2071585419 =         "SmsBroadcastConfigInfo: Id [" +
                fromServiceId + ',' + toServiceId + "] Code [" +
                fromCodeScheme + ',' + toCodeScheme + "] " +
            (selected ? "ENABLED" : "DISABLED");
        var50EAF3103BF752B9B6100D7A179A216D_2071585419.addTaint(taint);
        return var50EAF3103BF752B9B6100D7A179A216D_2071585419;
        // ---------- Original Method ----------
        //return "SmsBroadcastConfigInfo: Id [" +
                //fromServiceId + ',' + toServiceId + "] Code [" +
                //fromCodeScheme + ',' + toCodeScheme + "] " +
            //(selected ? "ENABLED" : "DISABLED");
    }

    
}

