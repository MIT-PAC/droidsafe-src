package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class GenericSignatureParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.938 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "3A123DBAC2896D22118ACC4A0DBF2815")

    public ListOfTypes exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.938 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "755AC25C18AC88DD7B505952EB00E2FC")

    public ListOfTypes parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.938 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "96CAE8588B8CB92AE83279FEB36F4121")

    public TypeVariable[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.938 -0400", hash_original_field = "9CD6843F4536590CD86F933708C7371E", hash_generated_field = "8FCAB3423DB3533C393A75EA17B6B1D8")

    public Type returnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.939 -0400", hash_original_field = "833750AC635FCC57DC33ECAFE365F9A7", hash_generated_field = "7BF0B57018D92E424F704D1E59B55203")

    public Type fieldType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.939 -0400", hash_original_field = "2E8612447B369F7E0D27C66E9273CB06", hash_generated_field = "0A3DD769080BC24A9D258283D7D7DC30")

    public ListOfTypes interfaceTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.939 -0400", hash_original_field = "2DC4A623293420174B22464D58B6A831", hash_generated_field = "2B6C083B05F286DFD7F93749F54AF5DA")

    public Type superclassType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.939 -0400", hash_original_field = "4A527F83A3A4CA7E1D70ADB26A35B72E", hash_generated_field = "34AC02C91B7B47224132768354947AB0")

    public ClassLoader loader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.940 -0400", hash_original_field = "AA84DC6545C7C550F5338E00F04FD372", hash_generated_field = "4BEC95563D8D0B015ABDE90FC2F1C6AF")

    GenericDeclaration genericDecl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.940 -0400", hash_original_field = "97BFF26855A8BFA63E05D5477E794B24", hash_generated_field = "4D622F1F51FE2777B0E8D81C997E113C")

    char symbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.940 -0400", hash_original_field = "F393F3F5E496869A15BC72CBFD56F541", hash_generated_field = "67D18ED1400CD458B308847E018D0637")

    String identifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.940 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.940 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "AF37951EAE101F357ACAF48FB7E85D88")

    char[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.940 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

    int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.949 -0400", hash_original_method = "B4AF29B80F8E14619B64C65F02963718", hash_generated_method = "C049BAD034A575B3E9230CA1104DE603")
    public  GenericSignatureParser(ClassLoader loader) {
        this.loader = loader;
        // ---------- Original Method ----------
        //this.loader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.952 -0400", hash_original_method = "6F9101760876DEB9422AEF7944CF1BF2", hash_generated_method = "7B98AFA204D8E0471A99B93A78803DD0")
     void setInput(GenericDeclaration genericDecl, String input) {
        {
            this.genericDecl = genericDecl;
            this.buffer = input.toCharArray();
            this.eof = false;
            scanSymbol();
        } //End block
        {
            this.eof = true;
        } //End block
        // ---------- Original Method ----------
        //if (input != null) {
            //this.genericDecl = genericDecl;
            //this.buffer = input.toCharArray();
            //this.eof = false;
            //scanSymbol();
        //}
        //else {
            //this.eof = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.957 -0400", hash_original_method = "408B9941E0DDFF19B1C3AECDF838B6FF", hash_generated_method = "4D664429977D8A6CA4313FB72A5EE2C0")
    public void parseForClass(GenericDeclaration genericDecl,
            String signature) {
        setInput(genericDecl, signature);
        {
            parseClassSignature();
        } //End block
        {
            {
                Class c;
                c = (Class) genericDecl;
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.superclassType = c.getSuperclass();
                this.interfaceTypes = new ListOfTypes(c.getInterfaces());
            } //End block
            {
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.superclassType = Object.class;
                this.interfaceTypes = ListOfTypes.EMPTY;
            } //End block
        } //End block
        addTaint(genericDecl.getTaint());
        addTaint(signature.getTaint());
        // ---------- Original Method ----------
        //setInput(genericDecl, signature);
        //if (!eof) {
            //parseClassSignature();
        //} else {
            //if(genericDecl instanceof Class) {
                //Class c = (Class) genericDecl;
                //this.formalTypeParameters = ListOfVariables.EMPTY;
                //this.superclassType = c.getSuperclass();
                //this.interfaceTypes = new ListOfTypes(c.getInterfaces());
            //} else {
                //this.formalTypeParameters = ListOfVariables.EMPTY;
                //this.superclassType = Object.class;
                //this.interfaceTypes = ListOfTypes.EMPTY;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.967 -0400", hash_original_method = "15DFE7F1F24F7739B7BEC1E53A5655D9", hash_generated_method = "4B3DF99849521C382E97C9315C5A6857")
    public void parseForMethod(GenericDeclaration genericDecl,
            String signature, Class<?>[] rawExceptionTypes) {
        setInput(genericDecl, signature);
        {
            parseMethodTypeSignature(rawExceptionTypes);
        } //End block
        {
            {
                Method m;
                m = (Method) genericDecl;
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = new ListOfTypes(m.getParameterTypes());
                this.exceptionTypes = new ListOfTypes(m.getExceptionTypes());
                this.returnType = m.getReturnType();
            } //End block
            {
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = ListOfTypes.EMPTY;
                this.exceptionTypes = ListOfTypes.EMPTY;
                this.returnType = void.class;
            } //End block
        } //End block
        addTaint(genericDecl.getTaint());
        addTaint(signature.getTaint());
        addTaint(rawExceptionTypes[0].getTaint());
        // ---------- Original Method ----------
        //setInput(genericDecl, signature);
        //if (!eof) {
            //parseMethodTypeSignature(rawExceptionTypes);
        //} else {
            //if(genericDecl instanceof Method) {
                //Method m = (Method) genericDecl;
                //this.formalTypeParameters = ListOfVariables.EMPTY;
                //this.parameterTypes = new ListOfTypes(m.getParameterTypes());
                //this.exceptionTypes = new ListOfTypes(m.getExceptionTypes());
                //this.returnType = m.getReturnType();
            //} else {
                //this.formalTypeParameters = ListOfVariables.EMPTY;
                //this.parameterTypes = ListOfTypes.EMPTY;
                //this.exceptionTypes = ListOfTypes.EMPTY;
                //this.returnType = void.class;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.972 -0400", hash_original_method = "0C9CA8BB038974E4A40BF19F7EB72426", hash_generated_method = "4B406DE06323DE28A856CE573F9C15A7")
    public void parseForConstructor(GenericDeclaration genericDecl,
            String signature, Class<?>[] rawExceptionTypes) {
        setInput(genericDecl, signature);
        {
            parseMethodTypeSignature(rawExceptionTypes);
        } //End block
        {
            {
                Constructor c;
                c = (Constructor) genericDecl;
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = new ListOfTypes(c.getParameterTypes());
                this.exceptionTypes = new ListOfTypes(c.getExceptionTypes());
            } //End block
            {
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = ListOfTypes.EMPTY;
                this.exceptionTypes = ListOfTypes.EMPTY;
            } //End block
        } //End block
        addTaint(genericDecl.getTaint());
        addTaint(signature.getTaint());
        addTaint(rawExceptionTypes[0].getTaint());
        // ---------- Original Method ----------
        //setInput(genericDecl, signature);
        //if (!eof) {
            //parseMethodTypeSignature(rawExceptionTypes);
        //} else {
            //if(genericDecl instanceof Constructor) {
                //Constructor c = (Constructor) genericDecl;
                //this.formalTypeParameters = ListOfVariables.EMPTY;
                //this.parameterTypes = new ListOfTypes(c.getParameterTypes());
                //this.exceptionTypes = new ListOfTypes(c.getExceptionTypes());
            //} else {
                //this.formalTypeParameters = ListOfVariables.EMPTY;
                //this.parameterTypes = ListOfTypes.EMPTY;
                //this.exceptionTypes = ListOfTypes.EMPTY;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.973 -0400", hash_original_method = "F697D7E02D0C8DEEF4B0854E9491CC15", hash_generated_method = "68F3BE0EC37F1E3A9FAF7D7E3911B166")
    public void parseForField(GenericDeclaration genericDecl,
            String signature) {
        setInput(genericDecl, signature);
        {
            this.fieldType = parseFieldTypeSignature();
        } //End block
        addTaint(genericDecl.getTaint());
        addTaint(signature.getTaint());
        // ---------- Original Method ----------
        //setInput(genericDecl, signature);
        //if (!eof) {
            //this.fieldType = parseFieldTypeSignature();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.974 -0400", hash_original_method = "2A6822DB636AAE3DC282A54EED7D514D", hash_generated_method = "6AD39E41A42F3007E3245DCC8D631ADD")
     void parseClassSignature() {
        parseOptFormalTypeParameters();
        this.superclassType = parseClassTypeSignature();
        interfaceTypes = new ListOfTypes(16);
        {
            interfaceTypes.add(parseClassTypeSignature());
        } //End block
        // ---------- Original Method ----------
        //parseOptFormalTypeParameters();
        //this.superclassType = parseClassTypeSignature();
        //interfaceTypes = new ListOfTypes(16);
        //while (symbol > 0) {
            //interfaceTypes.add(parseClassTypeSignature());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.974 -0400", hash_original_method = "F25135739D6C61926B7C7AB20920C0C3", hash_generated_method = "FC8572DC0B7CE0E4159E608A5A30484D")
     void parseOptFormalTypeParameters() {
        ListOfVariables typeParams;
        typeParams = new ListOfVariables();
        {
            scanSymbol();
            typeParams.add(parseFormalTypeParameter());
            {
                typeParams.add(parseFormalTypeParameter());
            } //End block
            expect('>');
        } //End block
        this.formalTypeParameters = typeParams.getArray();
        // ---------- Original Method ----------
        //ListOfVariables typeParams = new ListOfVariables();
        //if (symbol == '<') {
            //scanSymbol();
            //typeParams.add(parseFormalTypeParameter());
            //while ((symbol != '>') && (symbol > 0)) {
                //typeParams.add(parseFormalTypeParameter());
            //}
            //expect('>');
        //}
        //this.formalTypeParameters = typeParams.getArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.981 -0400", hash_original_method = "8E4B54F231B830B261D22AAC458F74D2", hash_generated_method = "18772702BAD7E5177BEC46E64F5C7BC3")
     ImplForVariable<GenericDeclaration> parseFormalTypeParameter() {
        ImplForVariable<GenericDeclaration> varB4EAC82CA7396A68D541C85D26508E83_1889432112 = null; //Variable for return #1
        scanIdentifier();
        String name;
        name = identifier.intern();
        ListOfTypes bounds;
        bounds = new ListOfTypes(8);
        expect(':');
        {
            bounds.add(parseFieldTypeSignature());
        } //End block
        {
            scanSymbol();
            bounds.add(parseFieldTypeSignature());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1889432112 = new ImplForVariable<GenericDeclaration>(genericDecl, name, bounds);
        varB4EAC82CA7396A68D541C85D26508E83_1889432112.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1889432112;
        // ---------- Original Method ----------
        //scanIdentifier();
        //String name = identifier.intern();
        //ListOfTypes bounds = new ListOfTypes(8);
        //expect(':');
        //if (symbol == 'L' || symbol == '[' || symbol == 'T') {
            //bounds.add(parseFieldTypeSignature());
        //}
        //while (symbol == ':') {
            //scanSymbol();
            //bounds.add(parseFieldTypeSignature());
        //}
        //return new ImplForVariable<GenericDeclaration>(genericDecl, name, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.988 -0400", hash_original_method = "39858CB077F5F270CB13BCD8F5E588C4", hash_generated_method = "C1CEEBC8493A43812B62D009371D2A46")
     Type parseFieldTypeSignature() {
        Type varB4EAC82CA7396A68D541C85D26508E83_1902491994 = null; //Variable for return #1
        Type varB4EAC82CA7396A68D541C85D26508E83_353134127 = null; //Variable for return #2
        Type varB4EAC82CA7396A68D541C85D26508E83_513737469 = null; //Variable for return #3
        //Begin case 'L' 
        varB4EAC82CA7396A68D541C85D26508E83_1902491994 = parseClassTypeSignature();
        //End case 'L' 
        //Begin case '[' 
        scanSymbol();
        //End case '[' 
        //Begin case '[' 
        varB4EAC82CA7396A68D541C85D26508E83_353134127 = new ImplForArray(parseTypeSignature());
        //End case '[' 
        //Begin case 'T' 
        varB4EAC82CA7396A68D541C85D26508E83_513737469 = parseTypeVariableSignature();
        //End case 'T' 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new GenericSignatureFormatError();
        //End case default 
        Type varA7E53CE21691AB073D9660D615818899_255791043; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_255791043 = varB4EAC82CA7396A68D541C85D26508E83_1902491994;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_255791043 = varB4EAC82CA7396A68D541C85D26508E83_353134127;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_255791043 = varB4EAC82CA7396A68D541C85D26508E83_513737469;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_255791043.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_255791043;
        // ---------- Original Method ----------
        //switch (symbol) {
        //case 'L':
            //return parseClassTypeSignature();
        //case '[':
            //scanSymbol();
            //return new ImplForArray(parseTypeSignature());
        //case 'T':
            //return parseTypeVariableSignature();
        //default:
            //throw new GenericSignatureFormatError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.996 -0400", hash_original_method = "0940B5693D1CE1CEA33652B7603676B3", hash_generated_method = "9A184780D4F71D58754B469DE99BC172")
     Type parseClassTypeSignature() {
        Type varB4EAC82CA7396A68D541C85D26508E83_483552147 = null; //Variable for return #1
        expect('L');
        StringBuilder qualIdent;
        qualIdent = new StringBuilder();
        scanIdentifier();
        {
            scanSymbol();
            qualIdent.append(identifier).append(".");
            scanIdentifier();
        } //End block
        qualIdent.append(this.identifier);
        ListOfTypes typeArgs;
        typeArgs = parseOptTypeArguments();
        ImplForType parentType;
        parentType = new ImplForType(null, qualIdent.toString(), typeArgs, loader);
        ImplForType type;
        type = parentType;
        {
            scanSymbol();
            scanIdentifier();
            qualIdent.append("$").append(identifier);
            typeArgs = parseOptTypeArguments();
            type = new ImplForType(parentType, qualIdent.toString(), typeArgs,
                    loader);
        } //End block
        expect(';');
        varB4EAC82CA7396A68D541C85D26508E83_483552147 = type;
        varB4EAC82CA7396A68D541C85D26508E83_483552147.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_483552147;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.005 -0400", hash_original_method = "FCA6C6C42F8D0470CBF5F70C4C8E2247", hash_generated_method = "FCFC6E0765B205D3C303D8AEC3F8BC77")
     ListOfTypes parseOptTypeArguments() {
        ListOfTypes varB4EAC82CA7396A68D541C85D26508E83_1793787153 = null; //Variable for return #1
        ListOfTypes typeArgs;
        typeArgs = new ListOfTypes(8);
        {
            scanSymbol();
            typeArgs.add(parseTypeArgument());
            {
                typeArgs.add(parseTypeArgument());
            } //End block
            expect('>');
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1793787153 = typeArgs;
        varB4EAC82CA7396A68D541C85D26508E83_1793787153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1793787153;
        // ---------- Original Method ----------
        //ListOfTypes typeArgs = new ListOfTypes(8);
        //if (symbol == '<') {
            //scanSymbol();
            //typeArgs.add(parseTypeArgument());
            //while ((symbol != '>') && (symbol > 0)) {
                //typeArgs.add(parseTypeArgument());
            //}
            //expect('>');
        //}
        //return typeArgs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.006 -0400", hash_original_method = "C611A5720E520CD6B6248914D1F9FF4D", hash_generated_method = "17C1D346BA4A5A2E383D85F3FE5EC030")
     Type parseTypeArgument() {
        Type varB4EAC82CA7396A68D541C85D26508E83_692164653 = null; //Variable for return #1
        Type varB4EAC82CA7396A68D541C85D26508E83_651423742 = null; //Variable for return #2
        Type varB4EAC82CA7396A68D541C85D26508E83_882471716 = null; //Variable for return #3
        Type varB4EAC82CA7396A68D541C85D26508E83_1559202423 = null; //Variable for return #4
        ListOfTypes extendsBound;
        extendsBound = new ListOfTypes(1);
        ListOfTypes superBound;
        superBound = new ListOfTypes(1);
        {
            scanSymbol();
            extendsBound.add(Object.class);
            varB4EAC82CA7396A68D541C85D26508E83_692164653 = new ImplForWildcard(extendsBound, superBound);
        } //End block
        {
            scanSymbol();
            extendsBound.add(parseFieldTypeSignature());
            varB4EAC82CA7396A68D541C85D26508E83_651423742 = new ImplForWildcard(extendsBound, superBound);
        } //End block
        {
            scanSymbol();
            superBound.add(parseFieldTypeSignature());
            extendsBound.add(Object.class);
            varB4EAC82CA7396A68D541C85D26508E83_882471716 = new ImplForWildcard(extendsBound, superBound);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1559202423 = parseFieldTypeSignature();
        } //End block
        Type varA7E53CE21691AB073D9660D615818899_1403126883; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1403126883 = varB4EAC82CA7396A68D541C85D26508E83_692164653;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1403126883 = varB4EAC82CA7396A68D541C85D26508E83_651423742;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1403126883 = varB4EAC82CA7396A68D541C85D26508E83_882471716;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1403126883 = varB4EAC82CA7396A68D541C85D26508E83_1559202423;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1403126883.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1403126883;
        // ---------- Original Method ----------
        //ListOfTypes extendsBound = new ListOfTypes(1);
        //ListOfTypes superBound = new ListOfTypes(1);
        //if (symbol == '*') {
            //scanSymbol();
            //extendsBound.add(Object.class);
            //return new ImplForWildcard(extendsBound, superBound);
        //}
        //else if (symbol == '+') {
            //scanSymbol();
            //extendsBound.add(parseFieldTypeSignature());
            //return new ImplForWildcard(extendsBound, superBound);
        //}
        //else if (symbol == '-') {
            //scanSymbol();
            //superBound.add(parseFieldTypeSignature());
            //extendsBound.add(Object.class);
            //return new ImplForWildcard(extendsBound, superBound);
        //}
        //else {
            //return parseFieldTypeSignature();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.010 -0400", hash_original_method = "FF6DECA5851C272F523D7639C2D071BC", hash_generated_method = "2F9B09C0665690EB40582F4C5C65798B")
     ImplForVariable<GenericDeclaration> parseTypeVariableSignature() {
        ImplForVariable<GenericDeclaration> varB4EAC82CA7396A68D541C85D26508E83_1481079153 = null; //Variable for return #1
        expect('T');
        scanIdentifier();
        expect(';');
        varB4EAC82CA7396A68D541C85D26508E83_1481079153 = new ImplForVariable<GenericDeclaration>(genericDecl, identifier);
        varB4EAC82CA7396A68D541C85D26508E83_1481079153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1481079153;
        // ---------- Original Method ----------
        //expect('T');
        //scanIdentifier();
        //expect(';');
        //return new ImplForVariable<GenericDeclaration>(genericDecl, identifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.012 -0400", hash_original_method = "ABCBB21DD03AAC76512AB0248A5CE39A", hash_generated_method = "509CF9417EC8181490B0F8725685157F")
     Type parseTypeSignature() {
        Type varB4EAC82CA7396A68D541C85D26508E83_151410952 = null; //Variable for return #1
        Type varB4EAC82CA7396A68D541C85D26508E83_1615805214 = null; //Variable for return #2
        Type varB4EAC82CA7396A68D541C85D26508E83_587960182 = null; //Variable for return #3
        Type varB4EAC82CA7396A68D541C85D26508E83_672350183 = null; //Variable for return #4
        Type varB4EAC82CA7396A68D541C85D26508E83_376072154 = null; //Variable for return #5
        Type varB4EAC82CA7396A68D541C85D26508E83_1953079427 = null; //Variable for return #6
        Type varB4EAC82CA7396A68D541C85D26508E83_1530296649 = null; //Variable for return #7
        Type varB4EAC82CA7396A68D541C85D26508E83_1559452551 = null; //Variable for return #8
        Type varB4EAC82CA7396A68D541C85D26508E83_1375432639 = null; //Variable for return #9
        //Begin case 'B' 
        scanSymbol();
        //End case 'B' 
        //Begin case 'B' 
        varB4EAC82CA7396A68D541C85D26508E83_151410952 = byte.class;
        //End case 'B' 
        //Begin case 'C' 
        scanSymbol();
        //End case 'C' 
        //Begin case 'C' 
        varB4EAC82CA7396A68D541C85D26508E83_1615805214 = char.class;
        //End case 'C' 
        //Begin case 'D' 
        scanSymbol();
        //End case 'D' 
        //Begin case 'D' 
        varB4EAC82CA7396A68D541C85D26508E83_587960182 = double.class;
        //End case 'D' 
        //Begin case 'F' 
        scanSymbol();
        //End case 'F' 
        //Begin case 'F' 
        varB4EAC82CA7396A68D541C85D26508E83_672350183 = float.class;
        //End case 'F' 
        //Begin case 'I' 
        scanSymbol();
        //End case 'I' 
        //Begin case 'I' 
        varB4EAC82CA7396A68D541C85D26508E83_376072154 = int.class;
        //End case 'I' 
        //Begin case 'J' 
        scanSymbol();
        //End case 'J' 
        //Begin case 'J' 
        varB4EAC82CA7396A68D541C85D26508E83_1953079427 = long.class;
        //End case 'J' 
        //Begin case 'S' 
        scanSymbol();
        //End case 'S' 
        //Begin case 'S' 
        varB4EAC82CA7396A68D541C85D26508E83_1530296649 = short.class;
        //End case 'S' 
        //Begin case 'Z' 
        scanSymbol();
        //End case 'Z' 
        //Begin case 'Z' 
        varB4EAC82CA7396A68D541C85D26508E83_1559452551 = boolean.class;
        //End case 'Z' 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_1375432639 = parseFieldTypeSignature();
        //End case default 
        Type varA7E53CE21691AB073D9660D615818899_2136738066; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2136738066 = varB4EAC82CA7396A68D541C85D26508E83_151410952;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2136738066 = varB4EAC82CA7396A68D541C85D26508E83_1615805214;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2136738066 = varB4EAC82CA7396A68D541C85D26508E83_587960182;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2136738066 = varB4EAC82CA7396A68D541C85D26508E83_672350183;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_2136738066 = varB4EAC82CA7396A68D541C85D26508E83_376072154;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_2136738066 = varB4EAC82CA7396A68D541C85D26508E83_1953079427;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_2136738066 = varB4EAC82CA7396A68D541C85D26508E83_1530296649;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_2136738066 = varB4EAC82CA7396A68D541C85D26508E83_1559452551;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2136738066 = varB4EAC82CA7396A68D541C85D26508E83_1375432639;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2136738066.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2136738066;
        // ---------- Original Method ----------
        //switch (symbol) {
        //case 'B': scanSymbol(); return byte.class;
        //case 'C': scanSymbol(); return char.class;
        //case 'D': scanSymbol(); return double.class;
        //case 'F': scanSymbol(); return float.class;
        //case 'I': scanSymbol(); return int.class;
        //case 'J': scanSymbol(); return long.class;
        //case 'S': scanSymbol(); return short.class;
        //case 'Z': scanSymbol(); return boolean.class;
        //default:
            //return parseFieldTypeSignature();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.014 -0400", hash_original_method = "BD4178EAA9E41C4057CACEBF28047848", hash_generated_method = "D2940C586D8ECAB409C65CAD07A93EAE")
     void parseMethodTypeSignature(Class<?>[] rawExceptionTypes) {
        parseOptFormalTypeParameters();
        parameterTypes = new ListOfTypes(16);
        expect('(');
        {
            parameterTypes.add(parseTypeSignature());
        } //End block
        expect(')');
        returnType = parseReturnType();
        {
            exceptionTypes = new ListOfTypes(8);
            {
                scanSymbol();
                {
                    exceptionTypes.add(parseTypeVariableSignature());
                } //End block
                {
                    exceptionTypes.add(parseClassTypeSignature());
                } //End block
            } //End block
        } //End block
        {
            exceptionTypes = new ListOfTypes(rawExceptionTypes);
        } //End block
        {
            exceptionTypes = new ListOfTypes(0);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.014 -0400", hash_original_method = "6FEAF434B1E5FC2FC9EAA724A7A39FCB", hash_generated_method = "CB696D48BC9F229EAD795CE718E7E5D1")
     Type parseReturnType() {
        Type varB4EAC82CA7396A68D541C85D26508E83_1170118375 = null; //Variable for return #1
        Type varB4EAC82CA7396A68D541C85D26508E83_437351726 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1170118375 = parseTypeSignature();
        } //End block
        {
            scanSymbol();
            varB4EAC82CA7396A68D541C85D26508E83_437351726 = void.class;
        } //End block
        Type varA7E53CE21691AB073D9660D615818899_410355648; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_410355648 = varB4EAC82CA7396A68D541C85D26508E83_1170118375;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_410355648 = varB4EAC82CA7396A68D541C85D26508E83_437351726;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_410355648.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_410355648;
        // ---------- Original Method ----------
        //if (symbol != 'V') { return parseTypeSignature(); }
        //else { scanSymbol(); return void.class; }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.019 -0400", hash_original_method = "CAE4999AD72CF442B6BBF401B7699A36", hash_generated_method = "2AEB0226C7D192BA1030997411AB9788")
     void scanSymbol() {
        {
            {
                symbol = buffer[pos];
            } //End block
            {
                symbol = 0;
                eof = true;
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new GenericSignatureFormatError();
        } //End block
        // ---------- Original Method ----------
        //if (!eof) {
            //if (pos < buffer.length) {
                //symbol = buffer[pos];
                //pos++;
            //} else {
                //symbol = 0;
                //eof = true;
            //}
        //} else {
            //throw new GenericSignatureFormatError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.020 -0400", hash_original_method = "D25C52D6AA7AD670E052B9729E548EBD", hash_generated_method = "6B1C782BE814EC3F9F505678FA0E48FD")
     void expect(char c) {
        {
            scanSymbol();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new GenericSignatureFormatError();
        } //End block
        addTaint(c);
        // ---------- Original Method ----------
        //if (symbol == c) {
            //scanSymbol();
        //} else {
            //throw new GenericSignatureFormatError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.020 -0400", hash_original_method = "1CE8B25C92A2D6D9FB5D5E3D923D48F0", hash_generated_method = "69693E0C61CF69E3F4852D44B27266C5")
     boolean isStopSymbol(char ch) {
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591981921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591981921;
        // ---------- Original Method ----------
        //switch (ch) {
        //case ':':
        //case '/':
        //case ';':
        //case '<':
        //case '.':
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.021 -0400", hash_original_method = "A47433FA08CE7DFA194FC642B799E216", hash_generated_method = "5BD5731933E48E6E26DBC4C16B2C9821")
     void scanIdentifier() {
        {
            StringBuilder identBuf;
            identBuf = new StringBuilder(32);
            {
                boolean varBA8951A438FB95E4147857CD77D7FDCF_1214940649 = (!isStopSymbol(symbol));
                {
                    identBuf.append(symbol);
                    {
                        char ch;
                        ch = buffer[pos];
                        {
                            boolean varC7ECC067547E5D886884C9CD83B3361C_361762293 = ((ch >= 'a') && (ch <= 'z') || (ch >= 'A') && (ch <= 'Z')
                            || !isStopSymbol(ch));
                            {
                                identBuf.append(buffer[pos]);
                            } //End block
                            {
                                identifier = identBuf.toString();
                                scanSymbol();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    identifier = identBuf.toString();
                    symbol = 0;
                    eof = true;
                } //End block
                {
                    symbol = 0;
                    eof = true;
                    if (DroidSafeAndroidRuntime.control) throw new GenericSignatureFormatError();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new GenericSignatureFormatError();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

