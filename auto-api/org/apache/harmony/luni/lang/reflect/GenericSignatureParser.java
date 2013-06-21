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
    public ListOfTypes exceptionTypes;
    public ListOfTypes parameterTypes;
    public TypeVariable[] formalTypeParameters;
    public Type returnType;
    public Type fieldType;
    public ListOfTypes interfaceTypes;
    public Type superclassType;
    public ClassLoader loader;
    GenericDeclaration genericDecl;
    char symbol;
    String identifier;
    private boolean eof;
    char[] buffer;
    int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.809 -0400", hash_original_method = "B4AF29B80F8E14619B64C65F02963718", hash_generated_method = "B68D0C387F4540F0D10AC94FCCF7A2A2")
    @DSModeled(DSC.BAN)
    public GenericSignatureParser(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        // ---------- Original Method ----------
        //this.loader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.809 -0400", hash_original_method = "6F9101760876DEB9422AEF7944CF1BF2", hash_generated_method = "94D85AB9D6DF7D1DB94FA1307B65F320")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setInput(GenericDeclaration genericDecl, String input) {
        dsTaint.addTaint(input);
        dsTaint.addTaint(genericDecl.dsTaint);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.810 -0400", hash_original_method = "408B9941E0DDFF19B1C3AECDF838B6FF", hash_generated_method = "2BCF983B8A901F8E63656BA4AA1FE8B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parseForClass(GenericDeclaration genericDecl,
            String signature) {
        dsTaint.addTaint(genericDecl.dsTaint);
        dsTaint.addTaint(signature);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.810 -0400", hash_original_method = "15DFE7F1F24F7739B7BEC1E53A5655D9", hash_generated_method = "6B5A63A8697FB5F9A45F57BB3D15F7D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parseForMethod(GenericDeclaration genericDecl,
            String signature, Class<?>[] rawExceptionTypes) {
        dsTaint.addTaint(rawExceptionTypes[0].dsTaint);
        dsTaint.addTaint(genericDecl.dsTaint);
        dsTaint.addTaint(signature);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.811 -0400", hash_original_method = "0C9CA8BB038974E4A40BF19F7EB72426", hash_generated_method = "6B237DC3CD5D7B0A8079F447648A9B03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parseForConstructor(GenericDeclaration genericDecl,
            String signature, Class<?>[] rawExceptionTypes) {
        dsTaint.addTaint(rawExceptionTypes[0].dsTaint);
        dsTaint.addTaint(genericDecl.dsTaint);
        dsTaint.addTaint(signature);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.811 -0400", hash_original_method = "F697D7E02D0C8DEEF4B0854E9491CC15", hash_generated_method = "3DC3916E7F85DD61AC9EAF31C15C0F45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parseForField(GenericDeclaration genericDecl,
            String signature) {
        dsTaint.addTaint(genericDecl.dsTaint);
        dsTaint.addTaint(signature);
        setInput(genericDecl, signature);
        {
            this.fieldType = parseFieldTypeSignature();
        } //End block
        // ---------- Original Method ----------
        //setInput(genericDecl, signature);
        //if (!eof) {
            //this.fieldType = parseFieldTypeSignature();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.811 -0400", hash_original_method = "2A6822DB636AAE3DC282A54EED7D514D", hash_generated_method = "6AD39E41A42F3007E3245DCC8D631ADD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.811 -0400", hash_original_method = "F25135739D6C61926B7C7AB20920C0C3", hash_generated_method = "FC8572DC0B7CE0E4159E608A5A30484D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.812 -0400", hash_original_method = "8E4B54F231B830B261D22AAC458F74D2", hash_generated_method = "79049915EE58EE838F540BC908E9367F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ImplForVariable<GenericDeclaration> parseFormalTypeParameter() {
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
        ImplForVariable<GenericDeclaration> var3194557A4F60DB80FA624EBDEA93957D_597422728 = (new ImplForVariable<GenericDeclaration>(genericDecl, name, bounds));
        return (ImplForVariable<GenericDeclaration>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.812 -0400", hash_original_method = "39858CB077F5F270CB13BCD8F5E588C4", hash_generated_method = "5AD4F9824DDAD0F23A8974CC6E3BCD2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Type parseFieldTypeSignature() {
        //Begin case 'L' 
        Type var5460A2FAE8640DF5F08CAD751C28BF41_870236702 = (parseClassTypeSignature());
        //End case 'L' 
        //Begin case '[' 
        scanSymbol();
        //End case '[' 
        //Begin case '[' 
        Type varE0105E0B7469BF82F3833ADD7D72B480_197774045 = (new ImplForArray(parseTypeSignature()));
        //End case '[' 
        //Begin case 'T' 
        Type var783AD106C3F71B5D9E2DF55ADC7F6053_896562063 = (parseTypeVariableSignature());
        //End case 'T' 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new GenericSignatureFormatError();
        //End case default 
        return (Type)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.812 -0400", hash_original_method = "0940B5693D1CE1CEA33652B7603676B3", hash_generated_method = "74FCC752A8619C367EAAFACA2D04033F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Type parseClassTypeSignature() {
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
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.812 -0400", hash_original_method = "FCA6C6C42F8D0470CBF5F70C4C8E2247", hash_generated_method = "8F3FFD1C25FB45B3BE1602BC51877E13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ListOfTypes parseOptTypeArguments() {
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
        return (ListOfTypes)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.813 -0400", hash_original_method = "C611A5720E520CD6B6248914D1F9FF4D", hash_generated_method = "04A8959ED7A0E5FD7643AEE866EDECFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Type parseTypeArgument() {
        ListOfTypes extendsBound;
        extendsBound = new ListOfTypes(1);
        ListOfTypes superBound;
        superBound = new ListOfTypes(1);
        {
            scanSymbol();
            extendsBound.add(Object.class);
            Type var87EF2698D1B001F25D7A0B7A38EB02F8_784529415 = (new ImplForWildcard(extendsBound, superBound));
        } //End block
        {
            scanSymbol();
            extendsBound.add(parseFieldTypeSignature());
            Type var87EF2698D1B001F25D7A0B7A38EB02F8_765948739 = (new ImplForWildcard(extendsBound, superBound));
        } //End block
        {
            scanSymbol();
            superBound.add(parseFieldTypeSignature());
            extendsBound.add(Object.class);
            Type var87EF2698D1B001F25D7A0B7A38EB02F8_1344826983 = (new ImplForWildcard(extendsBound, superBound));
        } //End block
        {
            Type var9BB984CA430AD56F579C91DF8CC58D02_2073837359 = (parseFieldTypeSignature());
        } //End block
        return (Type)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.813 -0400", hash_original_method = "FF6DECA5851C272F523D7639C2D071BC", hash_generated_method = "73AF1B6376815B51B10EA89AC04476BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ImplForVariable<GenericDeclaration> parseTypeVariableSignature() {
        expect('T');
        scanIdentifier();
        expect(';');
        ImplForVariable<GenericDeclaration> varA8EC0715DCBF47B2D5D489E65A8E56FB_555177984 = (new ImplForVariable<GenericDeclaration>(genericDecl, identifier));
        return (ImplForVariable<GenericDeclaration>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //expect('T');
        //scanIdentifier();
        //expect(';');
        //return new ImplForVariable<GenericDeclaration>(genericDecl, identifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.813 -0400", hash_original_method = "ABCBB21DD03AAC76512AB0248A5CE39A", hash_generated_method = "5058AFEF106D16859C42C7ABC564F597")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Type parseTypeSignature() {
        //Begin case 'B' 
        scanSymbol();
        //End case 'B' 
        //Begin case 'C' 
        scanSymbol();
        //End case 'C' 
        //Begin case 'D' 
        scanSymbol();
        //End case 'D' 
        //Begin case 'F' 
        scanSymbol();
        //End case 'F' 
        //Begin case 'I' 
        scanSymbol();
        //End case 'I' 
        //Begin case 'J' 
        scanSymbol();
        //End case 'J' 
        //Begin case 'S' 
        scanSymbol();
        //End case 'S' 
        //Begin case 'Z' 
        scanSymbol();
        //End case 'Z' 
        //Begin case default 
        Type var92DBC4FA4E2487BA403973D096E12584_184367688 = (parseFieldTypeSignature());
        //End case default 
        return (Type)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.814 -0400", hash_original_method = "BD4178EAA9E41C4057CACEBF28047848", hash_generated_method = "E6804DD3832DBEAAA50412B0D66CF500")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void parseMethodTypeSignature(Class<?>[] rawExceptionTypes) {
        dsTaint.addTaint(rawExceptionTypes[0].dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.814 -0400", hash_original_method = "6FEAF434B1E5FC2FC9EAA724A7A39FCB", hash_generated_method = "E588A8396DBE537DF31011ADDFB4233E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Type parseReturnType() {
        {
            Type varA139ADE5D63D4A5EA488BE81839B440A_394791317 = (parseTypeSignature());
        } //End block
        {
            scanSymbol();
        } //End block
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (symbol != 'V') { return parseTypeSignature(); }
        //else { scanSymbol(); return void.class; }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.814 -0400", hash_original_method = "CAE4999AD72CF442B6BBF401B7699A36", hash_generated_method = "2AEB0226C7D192BA1030997411AB9788")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.815 -0400", hash_original_method = "D25C52D6AA7AD670E052B9729E548EBD", hash_generated_method = "CA42F1EEBDA534E592C531B8A746F671")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void expect(char c) {
        dsTaint.addTaint(c);
        {
            scanSymbol();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new GenericSignatureFormatError();
        } //End block
        // ---------- Original Method ----------
        //if (symbol == c) {
            //scanSymbol();
        //} else {
            //throw new GenericSignatureFormatError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.815 -0400", hash_original_method = "1CE8B25C92A2D6D9FB5D5E3D923D48F0", hash_generated_method = "AC5F9F5ACD01EE87E6EFCF6DBC29F410")
    @DSModeled(DSC.SAFE)
     boolean isStopSymbol(char ch) {
        dsTaint.addTaint(ch);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.815 -0400", hash_original_method = "A47433FA08CE7DFA194FC642B799E216", hash_generated_method = "F2B939163B60E6B1C0E4523AFFC90DA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scanIdentifier() {
        {
            StringBuilder identBuf;
            identBuf = new StringBuilder(32);
            {
                boolean varBA8951A438FB95E4147857CD77D7FDCF_284834498 = (!isStopSymbol(symbol));
                {
                    identBuf.append(symbol);
                    {
                        char ch;
                        ch = buffer[pos];
                        {
                            boolean varC7ECC067547E5D886884C9CD83B3361C_1692233383 = ((ch >= 'a') && (ch <= 'z') || (ch >= 'A') && (ch <= 'Z')
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

