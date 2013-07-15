package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventObject;

public class PropertyChangeEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.653 -0400", hash_original_field = "9190E95D1C478ACEB70AC5C82692A74C", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.654 -0400", hash_original_field = "0382B9FD9EF50B6A335F35E0AAAEBF99", hash_generated_field = "960A7902634592C07CD47A2F225C6AD8")

    Object oldValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.654 -0400", hash_original_field = "7F7CFDE5EC586119B48911A2C75851E5", hash_generated_field = "B1A1DE6E10506FDF1F20E177533AEE3E")

    Object newValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.654 -0400", hash_original_field = "395600DB5D6C7217F52C02B5FEE8B3FB", hash_generated_field = "C9CA963F2944CBDFFCE0DEC6BEFF8F88")

    Object propagationId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.658 -0400", hash_original_method = "6BC761D29E61B2DA2BCFDF9B41EBE38E", hash_generated_method = "79EA52EBA18099D1FB7ACA8506163AB9")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.659 -0400", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "97BCDA8FEA8AE171D683FB1CC883FC5B")
    public String getPropertyName() {
String var3D632F0E4FFF94E691F92D3669CF1392_1561233135 =         propertyName;
        var3D632F0E4FFF94E691F92D3669CF1392_1561233135.addTaint(taint);
        return var3D632F0E4FFF94E691F92D3669CF1392_1561233135;
        // ---------- Original Method ----------
        //return propertyName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.660 -0400", hash_original_method = "570268AC213ADE0DD8E583FF2E0DF2D9", hash_generated_method = "99F56DD866E50C8B6DA45D24B96D6C66")
    public void setPropagationId(Object propagationId) {
        this.propagationId = propagationId;
        // ---------- Original Method ----------
        //this.propagationId = propagationId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.660 -0400", hash_original_method = "B4EBBB8113E4594B079A51C3F9A7BBBF", hash_generated_method = "F405006F45D5DE583039FEA89AF75238")
    public Object getPropagationId() {
Object varFF94D242D232A6C3EBF9D401FB06DA21_1230802318 =         propagationId;
        varFF94D242D232A6C3EBF9D401FB06DA21_1230802318.addTaint(taint);
        return varFF94D242D232A6C3EBF9D401FB06DA21_1230802318;
        // ---------- Original Method ----------
        //return propagationId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.661 -0400", hash_original_method = "F6F859A65246176318D5EFB34CCA1A19", hash_generated_method = "9B3FE108A3373AE318209303886F75DF")
    public Object getOldValue() {
Object var8CDBD2181CBEF5C2129AFFA68C014D4A_17679504 =         oldValue;
        var8CDBD2181CBEF5C2129AFFA68C014D4A_17679504.addTaint(taint);
        return var8CDBD2181CBEF5C2129AFFA68C014D4A_17679504;
        // ---------- Original Method ----------
        //return oldValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.661 -0400", hash_original_method = "623578C48E0252EB5211DBCA0AAE39FA", hash_generated_method = "B7D14D88CA7200046116EAA07EB48D91")
    public Object getNewValue() {
Object varB6587BDEA47787223F4D0D9CD73A12B5_972867020 =         newValue;
        varB6587BDEA47787223F4D0D9CD73A12B5_972867020.addTaint(taint);
        return varB6587BDEA47787223F4D0D9CD73A12B5_972867020;
        // ---------- Original Method ----------
        //return newValue;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.661 -0400", hash_original_field = "82D11D8EBC6C3E983DD174677B6801AA", hash_generated_field = "E6562888893882FF6552413C35A8C7AF")

    private static final long serialVersionUID = 7042693688939648123L;
}

