package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;





public final class SmsBroadcastConfigInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.686 -0400", hash_original_field = "6CB791FB42180E76757B8CE655EA63BC", hash_generated_field = "333B1EBCCD576A11F3929B04C911A0CC")

    private int fromServiceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.686 -0400", hash_original_field = "78C07AB482FAE915C24343F7756E27DF", hash_generated_field = "21D520383BDB72483F46B478E9E8442E")

    private int toServiceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.686 -0400", hash_original_field = "45B1CAD460DB900C18FFF089139DC888", hash_generated_field = "1C45CBAE9BFCDDAE4B54CFFD731AE53A")

    private int fromCodeScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.686 -0400", hash_original_field = "E65C94DD69C903E23E4B04500887A5B3", hash_generated_field = "6C4271AD3AC2111E09C7BAF5CEECEDA7")

    private int toCodeScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.686 -0400", hash_original_field = "EF7DE3F485174FF47F061AD27D83D0EE", hash_generated_field = "63F1085A29CC1E5353801D8BBF9C9BF5")

    private boolean selected;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.687 -0400", hash_original_method = "9D05E73016D00F2A428351060541CD33", hash_generated_method = "24427794CEEB7051C06B777AC42D0B80")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.688 -0400", hash_original_method = "EC03A9EAB74ED9CD08C5E767148A9E3D", hash_generated_method = "496707E01480A77738DBF7D33FB881B0")
    public void setFromServiceId(int fromServiceId) {
        this.fromServiceId = fromServiceId;
        // ---------- Original Method ----------
        //this.fromServiceId = fromServiceId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.688 -0400", hash_original_method = "000CFE123E4AC86430B83F6EA13C644C", hash_generated_method = "848802170709138487047663CD8FC0A5")
    public int getFromServiceId() {
        int var6CB791FB42180E76757B8CE655EA63BC_2013821683 = (fromServiceId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146770818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146770818;
        // ---------- Original Method ----------
        //return fromServiceId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.689 -0400", hash_original_method = "C662FD0745B0F3A8663C07D8F01AF54F", hash_generated_method = "9127DC336ABDEEC77E06814D5ECDD0CD")
    public void setToServiceId(int toServiceId) {
        this.toServiceId = toServiceId;
        // ---------- Original Method ----------
        //this.toServiceId = toServiceId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.689 -0400", hash_original_method = "708E088605DA57A3DA16BEEB2BE47BA2", hash_generated_method = "1B090507A7CD60F861AE49F99ADE64E0")
    public int getToServiceId() {
        int var78C07AB482FAE915C24343F7756E27DF_154141170 = (toServiceId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270052243 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270052243;
        // ---------- Original Method ----------
        //return toServiceId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.689 -0400", hash_original_method = "0A2734671D04AE4B45C1C1B3377422E5", hash_generated_method = "CC8CD577D428ADAA8EA094CC4841F1E7")
    public void setFromCodeScheme(int fromCodeScheme) {
        this.fromCodeScheme = fromCodeScheme;
        // ---------- Original Method ----------
        //this.fromCodeScheme = fromCodeScheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.690 -0400", hash_original_method = "7AEC5FB7E81910AF5A7A8C716EA8E7A5", hash_generated_method = "592C235FD9F7D406DBA5F2DC3855B846")
    public int getFromCodeScheme() {
        int var45B1CAD460DB900C18FFF089139DC888_663777220 = (fromCodeScheme);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36127555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36127555;
        // ---------- Original Method ----------
        //return fromCodeScheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.690 -0400", hash_original_method = "33ACE8C1E6B66F0AD44209B7329819FD", hash_generated_method = "E3018D7A149FE0867ABD4D0307C6F9A0")
    public void setToCodeScheme(int toCodeScheme) {
        this.toCodeScheme = toCodeScheme;
        // ---------- Original Method ----------
        //this.toCodeScheme = toCodeScheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.691 -0400", hash_original_method = "70F3C47437BA22E7BE36EFF6F1AA8F5B", hash_generated_method = "421C2637AE605146927B457E38229520")
    public int getToCodeScheme() {
        int varE65C94DD69C903E23E4B04500887A5B3_657111602 = (toCodeScheme);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935754011 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935754011;
        // ---------- Original Method ----------
        //return toCodeScheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.691 -0400", hash_original_method = "F22B16E73947604A26216421AD1B5C38", hash_generated_method = "6A3776683D035BBD3F20B198F2F711A3")
    public void setSelected(boolean selected) {
        this.selected = selected;
        // ---------- Original Method ----------
        //this.selected = selected;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.691 -0400", hash_original_method = "4072656BD90ABB561422ECCC238321A3", hash_generated_method = "04D831576E96C5F6186349C6DD577EDB")
    public boolean isSelected() {
        boolean varEF7DE3F485174FF47F061AD27D83D0EE_1408026181 = (selected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984890254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984890254;
        // ---------- Original Method ----------
        //return selected;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.692 -0400", hash_original_method = "7023ED8B006DA79CC4837559B31EDFCC", hash_generated_method = "E6648AD9AE7EE5C62A2F085E77EAD875")
    @Override
    public String toString() {
String var50EAF3103BF752B9B6100D7A179A216D_382728201 =         "SmsBroadcastConfigInfo: Id [" +
                fromServiceId + ',' + toServiceId + "] Code [" +
                fromCodeScheme + ',' + toCodeScheme + "] " +
            (selected ? "ENABLED" : "DISABLED");
        var50EAF3103BF752B9B6100D7A179A216D_382728201.addTaint(taint);
        return var50EAF3103BF752B9B6100D7A179A216D_382728201;
        // ---------- Original Method ----------
        //return "SmsBroadcastConfigInfo: Id [" +
                //fromServiceId + ',' + toServiceId + "] Code [" +
                //fromCodeScheme + ',' + toCodeScheme + "] " +
            //(selected ? "ENABLED" : "DISABLED");
    }

    
}

