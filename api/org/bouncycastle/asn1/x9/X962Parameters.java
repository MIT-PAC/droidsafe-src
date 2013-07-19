package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class X962Parameters extends ASN1Encodable implements ASN1Choice {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.452 -0400", hash_original_field = "A6C77BE84AFCCC19083483EC0528378B", hash_generated_field = "E86090F478AFA9B23CA08BF4EF7AF349")

    private DERObject params = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.452 -0400", hash_original_method = "1397E8178C44E6DF45387B6B68418706", hash_generated_method = "B453EAFBCA88EA248BC259CAFD7FF735")
    public  X962Parameters(
        X9ECParameters      ecParameters) {
        this.params = ecParameters.getDERObject();
        // ---------- Original Method ----------
        //this.params = ecParameters.getDERObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.452 -0400", hash_original_method = "E0388E86E3A80BEB8232173BF59EDA72", hash_generated_method = "0410E9418C009E7503558DCFFFD64184")
    public  X962Parameters(
        DERObjectIdentifier  namedCurve) {
        this.params = namedCurve;
        // ---------- Original Method ----------
        //this.params = namedCurve;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.452 -0400", hash_original_method = "5A42A0C55CC0229CDC548581C7883253", hash_generated_method = "D413F1A132C0D46DA390CB21FC163766")
    public  X962Parameters(
        DERObject           obj) {
        this.params = obj;
        // ---------- Original Method ----------
        //this.params = obj;
    }

    
        public static X962Parameters getInstance(
        Object obj) {
        if (obj == null || obj instanceof X962Parameters) 
        {
            return (X962Parameters)obj;
        }
        if (obj instanceof DERObject) 
        {
            return new X962Parameters((DERObject)obj);
        }
        throw new IllegalArgumentException("unknown object in getInstance()");
    }

    
        @DSModeled(DSC.SPEC)
    public static X962Parameters getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(obj.getObject());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.452 -0400", hash_original_method = "1C39324908CB279AE84BA869E213B319", hash_generated_method = "1A4F2914343C7F3A24D57ED902EA13E1")
    public boolean isNamedCurve() {
        boolean varCC13642C5FED417B9FCE9EF3642230AD_1241275064 = ((params instanceof DERObjectIdentifier));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920380325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920380325;
        // ---------- Original Method ----------
        //return (params instanceof DERObjectIdentifier);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.453 -0400", hash_original_method = "475403761996D653CB6A92100ADDE6B9", hash_generated_method = "F652234D766D9BFD74BE4C9488580023")
    public boolean isImplicitlyCA() {
        boolean varCFE7CCBAFFCA97FC47C2B1E1CB22A937_1406385149 = ((params instanceof ASN1Null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1437598131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1437598131;
        // ---------- Original Method ----------
        //return (params instanceof ASN1Null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.453 -0400", hash_original_method = "43CDC3C01D01649D40574BDD3C664EE0", hash_generated_method = "B6F48A1048823EE50564EF1040CD15EB")
    public DERObject getParameters() {
DERObject varD15CEB6F45B18F7EB233792D020C6115_1983846232 =         params;
        varD15CEB6F45B18F7EB233792D020C6115_1983846232.addTaint(taint);
        return varD15CEB6F45B18F7EB233792D020C6115_1983846232;
        // ---------- Original Method ----------
        //return params;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.453 -0400", hash_original_method = "C7E96020927A19D3FB38FF97469ACE2C", hash_generated_method = "E1CA69BCD761E2F166CB5F0ECC773EE3")
    public DERObject toASN1Object() {
DERObject varD15CEB6F45B18F7EB233792D020C6115_511662193 =         params;
        varD15CEB6F45B18F7EB233792D020C6115_511662193.addTaint(taint);
        return varD15CEB6F45B18F7EB233792D020C6115_511662193;
        // ---------- Original Method ----------
        //return params;
    }

    
}

