package org.apache.harmony.luni.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class ImplForType implements ParameterizedType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.296 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "22B7A856AFAF9B03C52198C74550F785")

    private ListOfTypes args;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.296 -0400", hash_original_field = "572B7D2404F6CE93B66098D06D2AF03F", hash_generated_field = "E62DDD05FB8DDFF2C9E5C831739CC012")

    private ImplForType ownerType0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.297 -0400", hash_original_field = "21B074348F4FC75916B998F4BB324939", hash_generated_field = "C3BFD692F6CB73635125C60E59B255FE")

    private Type ownerTypeRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.297 -0400", hash_original_field = "8F1D7FF479440B0DBA160755D4F5AE82", hash_generated_field = "8834091542F8527562CD5739509025DB")

    private Class rawType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.297 -0400", hash_original_field = "2F5C1B86D6EE2103E9655EB1656E3392", hash_generated_field = "7AA47D60CFFACFECE0651E3279DC0A79")

    private String rawTypeName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.297 -0400", hash_original_field = "4A527F83A3A4CA7E1D70ADB26A35B72E", hash_generated_field = "628BC99287A8F7D9E696F2E87A1B1CC4")

    private ClassLoader loader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.298 -0400", hash_original_method = "23B26279F59FD2756996C3E4E28C143C", hash_generated_method = "2AC9C0D81F36FAF383FEAA341A36E39B")
    public  ImplForType(ImplForType ownerType, String rawTypeName,
            ListOfTypes args, ClassLoader loader) {
        this.ownerType0 = ownerType;
        this.rawTypeName = rawTypeName;
        this.args = args;
        this.loader = loader;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.298 -0400", hash_original_method = "467C0CA3F26F8ADD49B2C117FFDDE5B5", hash_generated_method = "B81BA8E52E19F6BA31F7A6942466E127")
    public Type[] getActualTypeArguments() {
Type[] var9FC3950091FC8332FF1BE9E5D6665212_861170897 =         args.getResolvedTypes().clone();
        var9FC3950091FC8332FF1BE9E5D6665212_861170897.addTaint(taint);
        return var9FC3950091FC8332FF1BE9E5D6665212_861170897;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.299 -0400", hash_original_method = "607EB162392181215E5C2613EAFAE402", hash_generated_method = "D0BC06A41DF02C061575F1D6FB17ACDA")
    public Type getOwnerType() {
    if(ownerTypeRes == null)        
        {
    if(ownerType0 != null)            
            {
                ownerTypeRes = ownerType0.getResolvedType();
            } 
            else
            {
                ownerTypeRes = getRawType().getDeclaringClass();
            } 
        } 
Type var2E759B0D704D63E52781F7C5ADA34E62_926041259 =         ownerTypeRes;
        var2E759B0D704D63E52781F7C5ADA34E62_926041259.addTaint(taint);
        return var2E759B0D704D63E52781F7C5ADA34E62_926041259;
        
        
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.300 -0400", hash_original_method = "8C14A8DC9EE4FE0D18F10F9D13D7DE4A", hash_generated_method = "727BECF53B698412781FD7CAA036484D")
    public Class getRawType() {
    if(rawType == null)        
        {
            try 
            {
                rawType = Class.forName(rawTypeName, false, loader);
            } 
            catch (ClassNotFoundException e)
            {
                TypeNotPresentException var18BFD5723B1BAEA7E9D2A84B6D99D61D_1125168709 = new TypeNotPresentException(rawTypeName, e);
                var18BFD5723B1BAEA7E9D2A84B6D99D61D_1125168709.addTaint(taint);
                throw var18BFD5723B1BAEA7E9D2A84B6D99D61D_1125168709;
            } 
        } 
Class var8EA1D50767FFA9660A4E248B29D3B6ED_1035820156 =         rawType;
        var8EA1D50767FFA9660A4E248B29D3B6ED_1035820156.addTaint(taint);
        return var8EA1D50767FFA9660A4E248B29D3B6ED_1035820156;
        
        
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.300 -0400", hash_original_method = "62DEF1F574FB703889CA718D111580A0", hash_generated_method = "DCC51F3456FB40075C84D1FA06602F79")
     Type getResolvedType() {
    if(args.getResolvedTypes().length == 0)        
        {
Type var6043A7A211C85485D101BDD222E9392C_624195214 =             getRawType();
            var6043A7A211C85485D101BDD222E9392C_624195214.addTaint(taint);
            return var6043A7A211C85485D101BDD222E9392C_624195214;
        } 
        else
        {
Type var72A74007B2BE62B849F475C7BDA4658B_820715527 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_820715527.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_820715527;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.301 -0400", hash_original_method = "6D877CB8043423D6A95AF1E4F8482A09", hash_generated_method = "A781AC746C574DC96B722439A024F318")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(rawTypeName);
    if(args.length() > 0)        
        {
            sb.append("<").append(args).append(">");
        } 
String var2460B846747F8B22185AD8BE722266A5_1845843437 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1845843437.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1845843437;
        
        
        
        
            
        
        
    }

    
}

