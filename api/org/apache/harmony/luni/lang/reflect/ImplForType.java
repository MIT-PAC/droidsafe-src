package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;






public final class ImplForType implements ParameterizedType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.935 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "22B7A856AFAF9B03C52198C74550F785")

    private ListOfTypes args;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.935 -0400", hash_original_field = "572B7D2404F6CE93B66098D06D2AF03F", hash_generated_field = "E62DDD05FB8DDFF2C9E5C831739CC012")

    private ImplForType ownerType0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.935 -0400", hash_original_field = "21B074348F4FC75916B998F4BB324939", hash_generated_field = "C3BFD692F6CB73635125C60E59B255FE")

    private Type ownerTypeRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.935 -0400", hash_original_field = "8F1D7FF479440B0DBA160755D4F5AE82", hash_generated_field = "8834091542F8527562CD5739509025DB")

    private Class rawType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.935 -0400", hash_original_field = "2F5C1B86D6EE2103E9655EB1656E3392", hash_generated_field = "7AA47D60CFFACFECE0651E3279DC0A79")

    private String rawTypeName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.935 -0400", hash_original_field = "4A527F83A3A4CA7E1D70ADB26A35B72E", hash_generated_field = "628BC99287A8F7D9E696F2E87A1B1CC4")

    private ClassLoader loader;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.936 -0400", hash_original_method = "23B26279F59FD2756996C3E4E28C143C", hash_generated_method = "2AC9C0D81F36FAF383FEAA341A36E39B")
    public  ImplForType(ImplForType ownerType, String rawTypeName,
            ListOfTypes args, ClassLoader loader) {
        this.ownerType0 = ownerType;
        this.rawTypeName = rawTypeName;
        this.args = args;
        this.loader = loader;
        // ---------- Original Method ----------
        //this.ownerType0 = ownerType;
        //this.rawTypeName = rawTypeName;
        //this.args = args;
        //this.loader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.936 -0400", hash_original_method = "467C0CA3F26F8ADD49B2C117FFDDE5B5", hash_generated_method = "50BFE54AABDD5C5DE7E89574F53E7BAD")
    public Type[] getActualTypeArguments() {
Type[] var9FC3950091FC8332FF1BE9E5D6665212_1641498403 =         args.getResolvedTypes().clone();
        var9FC3950091FC8332FF1BE9E5D6665212_1641498403.addTaint(taint);
        return var9FC3950091FC8332FF1BE9E5D6665212_1641498403;
        // ---------- Original Method ----------
        //return args.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.936 -0400", hash_original_method = "607EB162392181215E5C2613EAFAE402", hash_generated_method = "B9CF8C3141D74534A131A4635DF54599")
    public Type getOwnerType() {
        if(ownerTypeRes == null)        
        {
            if(ownerType0 != null)            
            {
                ownerTypeRes = ownerType0.getResolvedType();
            } //End block
            else
            {
                ownerTypeRes = getRawType().getDeclaringClass();
            } //End block
        } //End block
Type var2E759B0D704D63E52781F7C5ADA34E62_1787275570 =         ownerTypeRes;
        var2E759B0D704D63E52781F7C5ADA34E62_1787275570.addTaint(taint);
        return var2E759B0D704D63E52781F7C5ADA34E62_1787275570;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.937 -0400", hash_original_method = "8C14A8DC9EE4FE0D18F10F9D13D7DE4A", hash_generated_method = "B83DE2FAA11754831FBB897F8FA19D45")
    public Class getRawType() {
        if(rawType == null)        
        {
            try 
            {
                rawType = Class.forName(rawTypeName, false, loader);
            } //End block
            catch (ClassNotFoundException e)
            {
                TypeNotPresentException var18BFD5723B1BAEA7E9D2A84B6D99D61D_226757373 = new TypeNotPresentException(rawTypeName, e);
                var18BFD5723B1BAEA7E9D2A84B6D99D61D_226757373.addTaint(taint);
                throw var18BFD5723B1BAEA7E9D2A84B6D99D61D_226757373;
            } //End block
        } //End block
Class var8EA1D50767FFA9660A4E248B29D3B6ED_1094618833 =         rawType;
        var8EA1D50767FFA9660A4E248B29D3B6ED_1094618833.addTaint(taint);
        return var8EA1D50767FFA9660A4E248B29D3B6ED_1094618833;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.937 -0400", hash_original_method = "62DEF1F574FB703889CA718D111580A0", hash_generated_method = "28492AC8C744658B8485C10CAB782263")
     Type getResolvedType() {
        if(args.getResolvedTypes().length == 0)        
        {
Type var6043A7A211C85485D101BDD222E9392C_1229643148 =             getRawType();
            var6043A7A211C85485D101BDD222E9392C_1229643148.addTaint(taint);
            return var6043A7A211C85485D101BDD222E9392C_1229643148;
        } //End block
        else
        {
Type var72A74007B2BE62B849F475C7BDA4658B_536701584 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_536701584.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_536701584;
        } //End block
        // ---------- Original Method ----------
        //if (args.getResolvedTypes().length == 0) {
            //return getRawType();
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.937 -0400", hash_original_method = "6D877CB8043423D6A95AF1E4F8482A09", hash_generated_method = "EB666C10D82C713596B22AA66D6B1CA6")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(rawTypeName);
        if(args.length() > 0)        
        {
            sb.append("<").append(args).append(">");
        } //End block
String var2460B846747F8B22185AD8BE722266A5_1350246117 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1350246117.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1350246117;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append(rawTypeName);
        //if (args.length() > 0) {
            //sb.append("<").append(args).append(">");
        //}
        //return sb.toString();
    }

    
}

