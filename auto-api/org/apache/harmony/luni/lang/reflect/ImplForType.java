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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.896 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "22B7A856AFAF9B03C52198C74550F785")

    private ListOfTypes args;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.896 -0400", hash_original_field = "572B7D2404F6CE93B66098D06D2AF03F", hash_generated_field = "E62DDD05FB8DDFF2C9E5C831739CC012")

    private ImplForType ownerType0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.896 -0400", hash_original_field = "21B074348F4FC75916B998F4BB324939", hash_generated_field = "C3BFD692F6CB73635125C60E59B255FE")

    private Type ownerTypeRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.896 -0400", hash_original_field = "8F1D7FF479440B0DBA160755D4F5AE82", hash_generated_field = "8834091542F8527562CD5739509025DB")

    private Class rawType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.897 -0400", hash_original_field = "2F5C1B86D6EE2103E9655EB1656E3392", hash_generated_field = "7AA47D60CFFACFECE0651E3279DC0A79")

    private String rawTypeName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.897 -0400", hash_original_field = "4A527F83A3A4CA7E1D70ADB26A35B72E", hash_generated_field = "628BC99287A8F7D9E696F2E87A1B1CC4")

    private ClassLoader loader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.897 -0400", hash_original_method = "23B26279F59FD2756996C3E4E28C143C", hash_generated_method = "2AC9C0D81F36FAF383FEAA341A36E39B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.898 -0400", hash_original_method = "467C0CA3F26F8ADD49B2C117FFDDE5B5", hash_generated_method = "3A08754235B97D06A90DD9027EF58607")
    public Type[] getActualTypeArguments() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_12447620 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_12447620 = args.getResolvedTypes().clone();
        varB4EAC82CA7396A68D541C85D26508E83_12447620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_12447620;
        // ---------- Original Method ----------
        //return args.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.905 -0400", hash_original_method = "607EB162392181215E5C2613EAFAE402", hash_generated_method = "343BD08AA942728B12174F72DA670CD6")
    public Type getOwnerType() {
        Type varB4EAC82CA7396A68D541C85D26508E83_196805545 = null; //Variable for return #1
        {
            {
                ownerTypeRes = ownerType0.getResolvedType();
            } //End block
            {
                ownerTypeRes = getRawType().getDeclaringClass();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_196805545 = ownerTypeRes;
        varB4EAC82CA7396A68D541C85D26508E83_196805545.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_196805545;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.905 -0400", hash_original_method = "8C14A8DC9EE4FE0D18F10F9D13D7DE4A", hash_generated_method = "E0BC5AF2291771F19FCEFAC5103F55FE")
    public Class getRawType() {
        Class varB4EAC82CA7396A68D541C85D26508E83_1946053658 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1946053658 = rawType;
        varB4EAC82CA7396A68D541C85D26508E83_1946053658.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1946053658;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.911 -0400", hash_original_method = "62DEF1F574FB703889CA718D111580A0", hash_generated_method = "C76CE5C3C49086E27C3D506F260CDB91")
     Type getResolvedType() {
        Type varB4EAC82CA7396A68D541C85D26508E83_230918715 = null; //Variable for return #1
        Type varB4EAC82CA7396A68D541C85D26508E83_1069836994 = null; //Variable for return #2
        {
            boolean var929871B706FD9E4989BB25B3C30DCC87_2040854361 = (args.getResolvedTypes().length == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_230918715 = getRawType();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1069836994 = this;
            } //End block
        } //End collapsed parenthetic
        Type varA7E53CE21691AB073D9660D615818899_2062816324; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2062816324 = varB4EAC82CA7396A68D541C85D26508E83_230918715;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2062816324 = varB4EAC82CA7396A68D541C85D26508E83_1069836994;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2062816324.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2062816324;
        // ---------- Original Method ----------
        //if (args.getResolvedTypes().length == 0) {
            //return getRawType();
        //} else {
            //return this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.919 -0400", hash_original_method = "6D877CB8043423D6A95AF1E4F8482A09", hash_generated_method = "46C7EE1772126E8EC127EAB04CD38594")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1228002991 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(rawTypeName);
        {
            boolean var08E1C62E694B95B78F2DB7BD9F1145A0_2025598511 = (args.length() > 0);
            {
                sb.append("<").append(args).append(">");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1228002991 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1228002991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1228002991;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append(rawTypeName);
        //if (args.length() > 0) {
            //sb.append("<").append(args).append(">");
        //}
        //return sb.toString();
    }

    
}

