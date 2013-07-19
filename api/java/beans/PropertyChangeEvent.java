package java.beans;

// Droidsafe Imports
import java.util.EventObject;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PropertyChangeEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.127 -0400", hash_original_field = "9190E95D1C478ACEB70AC5C82692A74C", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.127 -0400", hash_original_field = "0382B9FD9EF50B6A335F35E0AAAEBF99", hash_generated_field = "960A7902634592C07CD47A2F225C6AD8")

    Object oldValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.127 -0400", hash_original_field = "7F7CFDE5EC586119B48911A2C75851E5", hash_generated_field = "B1A1DE6E10506FDF1F20E177533AEE3E")

    Object newValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.127 -0400", hash_original_field = "395600DB5D6C7217F52C02B5FEE8B3FB", hash_generated_field = "C9CA963F2944CBDFFCE0DEC6BEFF8F88")

    Object propagationId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.128 -0400", hash_original_method = "6BC761D29E61B2DA2BCFDF9B41EBE38E", hash_generated_method = "79EA52EBA18099D1FB7ACA8506163AB9")
    public  PropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue) {
        super(source);
        addTaint(source.getTaint());
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        // ---------- Original Method ----------
        //this.propertyName = propertyName;
        //this.oldValue = oldValue;
        //this.newValue = newValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.129 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "A67BB6D4EA14F63DE4CE5458BBEB2D67")
    public String getPropertyName() {
String var3D632F0E4FFF94E691F92D3669CF1392_699480106 =         propertyName;
        var3D632F0E4FFF94E691F92D3669CF1392_699480106.addTaint(taint);
        return var3D632F0E4FFF94E691F92D3669CF1392_699480106;
        // ---------- Original Method ----------
        //return propertyName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.130 -0400", hash_original_method = "570268AC213ADE0DD8E583FF2E0DF2D9", hash_generated_method = "99F56DD866E50C8B6DA45D24B96D6C66")
    public void setPropagationId(Object propagationId) {
        this.propagationId = propagationId;
        // ---------- Original Method ----------
        //this.propagationId = propagationId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.130 -0400", hash_original_method = "B4EBBB8113E4594B079A51C3F9A7BBBF", hash_generated_method = "792555BA7D6B5FD0C7869CCBABECAC4C")
    public Object getPropagationId() {
Object varFF94D242D232A6C3EBF9D401FB06DA21_929825196 =         propagationId;
        varFF94D242D232A6C3EBF9D401FB06DA21_929825196.addTaint(taint);
        return varFF94D242D232A6C3EBF9D401FB06DA21_929825196;
        // ---------- Original Method ----------
        //return propagationId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.131 -0400", hash_original_method = "F6F859A65246176318D5EFB34CCA1A19", hash_generated_method = "0FAC6C9BE83CF74E91DE5359143C92AD")
    public Object getOldValue() {
Object var8CDBD2181CBEF5C2129AFFA68C014D4A_547734050 =         oldValue;
        var8CDBD2181CBEF5C2129AFFA68C014D4A_547734050.addTaint(taint);
        return var8CDBD2181CBEF5C2129AFFA68C014D4A_547734050;
        // ---------- Original Method ----------
        //return oldValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.131 -0400", hash_original_method = "623578C48E0252EB5211DBCA0AAE39FA", hash_generated_method = "8AAC65AF1A4F731F846BE705F52B8F38")
    public Object getNewValue() {
Object varB6587BDEA47787223F4D0D9CD73A12B5_1568668114 =         newValue;
        varB6587BDEA47787223F4D0D9CD73A12B5_1568668114.addTaint(taint);
        return varB6587BDEA47787223F4D0D9CD73A12B5_1568668114;
        // ---------- Original Method ----------
        //return newValue;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.131 -0400", hash_original_field = "82D11D8EBC6C3E983DD174677B6801AA", hash_generated_field = "E6562888893882FF6552413C35A8C7AF")

    private static final long serialVersionUID = 7042693688939648123L;
}

