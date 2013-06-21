package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class ImplForType implements ParameterizedType {
    private ListOfTypes args;
    private ImplForType ownerType0;
    private Type ownerTypeRes;
    private Class rawType;
    private String rawTypeName;
    private ClassLoader loader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.822 -0400", hash_original_method = "23B26279F59FD2756996C3E4E28C143C", hash_generated_method = "626A3C74229D722CA8755672454EB560")
    @DSModeled(DSC.BAN)
    public ImplForType(ImplForType ownerType, String rawTypeName,
            ListOfTypes args, ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(ownerType.dsTaint);
        dsTaint.addTaint(rawTypeName);
        // ---------- Original Method ----------
        //this.ownerType0 = ownerType;
        //this.rawTypeName = rawTypeName;
        //this.args = args;
        //this.loader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.822 -0400", hash_original_method = "467C0CA3F26F8ADD49B2C117FFDDE5B5", hash_generated_method = "F63A2B0C15A0BBB1543CAC62D746E3CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getActualTypeArguments() {
        Type[] var0A06E709C4A35D4A295569497166016F_1346780106 = (args.getResolvedTypes().clone());
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return args.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.822 -0400", hash_original_method = "607EB162392181215E5C2613EAFAE402", hash_generated_method = "1147D447181BFD97893A0D05BDE3C56E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type getOwnerType() {
        {
            {
                ownerTypeRes = ownerType0.getResolvedType();
            } //End block
            {
                ownerTypeRes = getRawType().getDeclaringClass();
            } //End block
        } //End block
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (ownerTypeRes == null) {
            //if (ownerType0 != null) {
                //ownerTypeRes = ownerType0.getResolvedType();
            //} else {
                //ownerTypeRes = getRawType().getDeclaringClass();
            //}
        //}
        //return ownerTypeRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.822 -0400", hash_original_method = "8C14A8DC9EE4FE0D18F10F9D13D7DE4A", hash_generated_method = "13A345A82880B5314DBD0758FF961B18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class getRawType() {
        {
            try 
            {
                rawType = Class.forName(rawTypeName, false, loader);
            } //End block
            catch (ClassNotFoundException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new TypeNotPresentException(rawTypeName, e);
            } //End block
        } //End block
        return (Class)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (rawType == null) {
            //try {
                //rawType = Class.forName(rawTypeName, false, loader);
            //} catch (ClassNotFoundException e) {
                //throw new TypeNotPresentException(rawTypeName, e);
            //}
        //}
        //return rawType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.822 -0400", hash_original_method = "62DEF1F574FB703889CA718D111580A0", hash_generated_method = "E2649A1874477F73A3D3E851D46C9C9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Type getResolvedType() {
        {
            boolean var929871B706FD9E4989BB25B3C30DCC87_1499530930 = (args.getResolvedTypes().length == 0);
            {
                Type var59413A4E0D1CAD34B2CFE39A1944E292_2048729608 = (getRawType());
            } //End block
        } //End collapsed parenthetic
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (args.getResolvedTypes().length == 0) {
            //return getRawType();
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.823 -0400", hash_original_method = "6D877CB8043423D6A95AF1E4F8482A09", hash_generated_method = "80DAC7B2C7E9B413ABE56643DA791611")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(rawTypeName);
        {
            boolean var08E1C62E694B95B78F2DB7BD9F1145A0_1606454260 = (args.length() > 0);
            {
                sb.append("<").append(args).append(">");
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_1344971285 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append(rawTypeName);
        //if (args.length() > 0) {
            //sb.append("<").append(args).append(">");
        //}
        //return sb.toString();
    }

    
}

