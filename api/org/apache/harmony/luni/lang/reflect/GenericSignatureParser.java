package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class GenericSignatureParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.706 -0500", hash_original_field = "CFAD442F68872B441545BF2444D3B382", hash_generated_field = "3A123DBAC2896D22118ACC4A0DBF2815")

    public ListOfTypes exceptionTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.708 -0500", hash_original_field = "2B1160BC05B17B2F612FCC97C50D31BF", hash_generated_field = "755AC25C18AC88DD7B505952EB00E2FC")

    public ListOfTypes parameterTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.711 -0500", hash_original_field = "33A2C8784709802EC7A40CDF9B6AE2DB", hash_generated_field = "96CAE8588B8CB92AE83279FEB36F4121")

    public TypeVariable[] formalTypeParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.713 -0500", hash_original_field = "8BCD0D224F325C451D6C6DDB956B5694", hash_generated_field = "8FCAB3423DB3533C393A75EA17B6B1D8")

    public Type returnType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.716 -0500", hash_original_field = "47B66CA80CC7DEE9F895492665B2D008", hash_generated_field = "7BF0B57018D92E424F704D1E59B55203")

    public Type fieldType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.718 -0500", hash_original_field = "3B5A3A8022068B466CECACC2E030EB68", hash_generated_field = "0A3DD769080BC24A9D258283D7D7DC30")

    public ListOfTypes interfaceTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.720 -0500", hash_original_field = "3CEEC1A0188837DFD81B65BD68E93524", hash_generated_field = "2B6C083B05F286DFD7F93749F54AF5DA")

    public Type superclassType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.722 -0500", hash_original_field = "50E7BE27A72C15B735AFB72AFA6F9C78", hash_generated_field = "34AC02C91B7B47224132768354947AB0")

    public ClassLoader loader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.724 -0500", hash_original_field = "4BEC95563D8D0B015ABDE90FC2F1C6AF", hash_generated_field = "4BEC95563D8D0B015ABDE90FC2F1C6AF")

    GenericDeclaration genericDecl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.726 -0500", hash_original_field = "4D622F1F51FE2777B0E8D81C997E113C", hash_generated_field = "4D622F1F51FE2777B0E8D81C997E113C")

    char symbol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.728 -0500", hash_original_field = "67D18ED1400CD458B308847E018D0637", hash_generated_field = "67D18ED1400CD458B308847E018D0637")

    String identifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.730 -0500", hash_original_field = "F63D5C2A3218247517725999753A7A52", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.732 -0500", hash_original_field = "AF37951EAE101F357ACAF48FB7E85D88", hash_generated_field = "AF37951EAE101F357ACAF48FB7E85D88")

    char[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.734 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

    int pos;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.737 -0500", hash_original_method = "B4AF29B80F8E14619B64C65F02963718", hash_generated_method = "A4FEA1D1C7ADAECBAFEB4D7D86554B9B")
    
public GenericSignatureParser(ClassLoader loader) {
        this.loader = loader;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.740 -0500", hash_original_method = "6F9101760876DEB9422AEF7944CF1BF2", hash_generated_method = "6F9101760876DEB9422AEF7944CF1BF2")
    
void setInput(GenericDeclaration genericDecl, String input) {
        if (input != null) {
            this.genericDecl = genericDecl;
            this.buffer = input.toCharArray();
            this.eof = false;
            scanSymbol();
        }
        else {
            this.eof = true;
        }
    }

    /**
     * Parses the generic signature of a class and creates the data structure
     * representing the signature.
     *
     * @param genericDecl the GenericDeclaration calling this method
     * @param signature the generic signature of the class
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.742 -0500", hash_original_method = "408B9941E0DDFF19B1C3AECDF838B6FF", hash_generated_method = "FF386E3A416C3838A3DAC22428C1495D")
    
public void parseForClass(GenericDeclaration genericDecl,
            String signature) {
        setInput(genericDecl, signature);
        if (!eof) {
            parseClassSignature();
        } else {
            if(genericDecl instanceof Class) {
                Class c = (Class) genericDecl;
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.superclassType = c.getSuperclass();
                this.interfaceTypes = new ListOfTypes(c.getInterfaces());
            } else {
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.superclassType = Object.class;
                this.interfaceTypes = ListOfTypes.EMPTY;
            }
        }
    }

    /**
     * Parses the generic signature of a method and creates the data structure
     * representing the signature.
     *
     * @param genericDecl the GenericDeclaration calling this method
     * @param signature the generic signature of the class
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.745 -0500", hash_original_method = "15DFE7F1F24F7739B7BEC1E53A5655D9", hash_generated_method = "A51DBBACDC7D08538567B9F2381DBF56")
    
public void parseForMethod(GenericDeclaration genericDecl,
            String signature, Class<?>[] rawExceptionTypes) {
        setInput(genericDecl, signature);
        if (!eof) {
            parseMethodTypeSignature(rawExceptionTypes);
        } else {
            if(genericDecl instanceof Method) {
                Method m = (Method) genericDecl;
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = new ListOfTypes(m.getParameterTypes());
                this.exceptionTypes = new ListOfTypes(m.getExceptionTypes());
                this.returnType = m.getReturnType();
            } else {
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = ListOfTypes.EMPTY;
                this.exceptionTypes = ListOfTypes.EMPTY;
                this.returnType = void.class;
            }
        }
    }

    /**
     * Parses the generic signature of a constructor and creates the data
     * structure representing the signature.
     *
     * @param genericDecl the GenericDeclaration calling this method
     * @param signature the generic signature of the class
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.747 -0500", hash_original_method = "0C9CA8BB038974E4A40BF19F7EB72426", hash_generated_method = "40F90509E67B2A9E8DF42F5E3890F864")
    
public void parseForConstructor(GenericDeclaration genericDecl,
            String signature, Class<?>[] rawExceptionTypes) {
        setInput(genericDecl, signature);
        if (!eof) {
            parseMethodTypeSignature(rawExceptionTypes);
        } else {
            if(genericDecl instanceof Constructor) {
                Constructor c = (Constructor) genericDecl;
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = new ListOfTypes(c.getParameterTypes());
                this.exceptionTypes = new ListOfTypes(c.getExceptionTypes());
            } else {
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = ListOfTypes.EMPTY;
                this.exceptionTypes = ListOfTypes.EMPTY;
            }
        }
    }

    /**
     * Parses the generic signature of a field and creates the data structure
     * representing the signature.
     *
     * @param genericDecl the GenericDeclaration calling this method
     * @param signature the generic signature of the class
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.750 -0500", hash_original_method = "F697D7E02D0C8DEEF4B0854E9491CC15", hash_generated_method = "0985E3F05C2C68525EE88590F9B35C21")
    
public void parseForField(GenericDeclaration genericDecl,
            String signature) {
        setInput(genericDecl, signature);
        if (!eof) {
            this.fieldType = parseFieldTypeSignature();
        }
    }

    //
    // Parser:
    //

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.752 -0500", hash_original_method = "2A6822DB636AAE3DC282A54EED7D514D", hash_generated_method = "453C8D2DC4372B03FDA8DB150393473B")
    
void parseClassSignature() {
        // ClassSignature ::=
        // OptFormalTypeParameters SuperclassSignature {SuperinterfaceSignature}.

        parseOptFormalTypeParameters();

        // SuperclassSignature ::= ClassTypeSignature.
        this.superclassType = parseClassTypeSignature();

        interfaceTypes = new ListOfTypes(16);
        while (symbol > 0) {
            // SuperinterfaceSignature ::= ClassTypeSignature.
            interfaceTypes.add(parseClassTypeSignature());
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.754 -0500", hash_original_method = "F25135739D6C61926B7C7AB20920C0C3", hash_generated_method = "14F1112A2442477667925E7AE96F8DD7")
    
void parseOptFormalTypeParameters() {
        // OptFormalTypeParameters ::=
        // ["<" FormalTypeParameter {FormalTypeParameter} ">"].

        ListOfVariables typeParams = new ListOfVariables();

        if (symbol == '<') {
            scanSymbol();
            typeParams.add(parseFormalTypeParameter());
            while ((symbol != '>') && (symbol > 0)) {
                typeParams.add(parseFormalTypeParameter());
            }
            expect('>');
        }
        this.formalTypeParameters = typeParams.getArray();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.757 -0500", hash_original_method = "8E4B54F231B830B261D22AAC458F74D2", hash_generated_method = "96C880D70312CBC139B8AB98DD0B326F")
    
ImplForVariable<GenericDeclaration> parseFormalTypeParameter() {
        // FormalTypeParameter ::= Ident ClassBound {InterfaceBound}.

        scanIdentifier();
        String name = identifier.intern(); // FIXME: is this o.k.?

        ListOfTypes bounds = new ListOfTypes(8);

        // ClassBound ::= ":" [FieldTypeSignature].
        expect(':');
        if (symbol == 'L' || symbol == '[' || symbol == 'T') {
            bounds.add(parseFieldTypeSignature());
        }

        while (symbol == ':') {
            // InterfaceBound ::= ":" FieldTypeSignature.
            scanSymbol();
            bounds.add(parseFieldTypeSignature());
        }

        return new ImplForVariable<GenericDeclaration>(genericDecl, name, bounds);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.759 -0500", hash_original_method = "39858CB077F5F270CB13BCD8F5E588C4", hash_generated_method = "749D357A47B23FA0DE78104098A8175B")
    
Type parseFieldTypeSignature() {
        // FieldTypeSignature ::= ClassTypeSignature | ArrayTypeSignature
        //         | TypeVariableSignature.

        switch (symbol) {
        case 'L':
            return parseClassTypeSignature();
        case '[':
            // ArrayTypeSignature ::= "[" TypSignature.
            scanSymbol();
            return new ImplForArray(parseTypeSignature());
        case 'T':
            return parseTypeVariableSignature();
        default:
            throw new GenericSignatureFormatError();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.762 -0500", hash_original_method = "0940B5693D1CE1CEA33652B7603676B3", hash_generated_method = "9DEC9521CE81C4D55CD8C59983880962")
    
Type parseClassTypeSignature() {
        // ClassTypeSignature ::= "L" {Ident "/"} Ident
        //         OptTypeArguments {"." Ident OptTypeArguments} ";".

        expect('L');

        StringBuilder qualIdent = new StringBuilder();
        scanIdentifier();
        while (symbol == '/') {
            scanSymbol();
            qualIdent.append(identifier).append(".");
            scanIdentifier();
        }

        qualIdent.append(this.identifier);

        ListOfTypes typeArgs = parseOptTypeArguments();
        ImplForType parentType =
                new ImplForType(null, qualIdent.toString(), typeArgs, loader);
        ImplForType type = parentType;

        while (symbol == '.') {
            // Deal with Member Classes:
            scanSymbol();
            scanIdentifier();
            qualIdent.append("$").append(identifier); // FIXME: is "$" correct?
            typeArgs = parseOptTypeArguments();
            type = new ImplForType(parentType, qualIdent.toString(), typeArgs,
                    loader);
        }

        expect(';');

        return type;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.764 -0500", hash_original_method = "FCA6C6C42F8D0470CBF5F70C4C8E2247", hash_generated_method = "DCE856EEF4A95EB7BE5BE42CAE12797A")
    
ListOfTypes parseOptTypeArguments() {
        // OptTypeArguments ::= "<" TypeArgument {TypeArgument} ">".

        ListOfTypes typeArgs = new ListOfTypes(8);
        if (symbol == '<') {
            scanSymbol();

            typeArgs.add(parseTypeArgument());
            while ((symbol != '>') && (symbol > 0)) {
                typeArgs.add(parseTypeArgument());
            }
            expect('>');
        }
        return typeArgs;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.766 -0500", hash_original_method = "C611A5720E520CD6B6248914D1F9FF4D", hash_generated_method = "847D5827D690F284FB834E8421F50C8E")
    
Type parseTypeArgument() {
        // TypeArgument ::= (["+" | "-"] FieldTypeSignature) | "*".
        ListOfTypes extendsBound = new ListOfTypes(1);
        ListOfTypes superBound = new ListOfTypes(1);
        if (symbol == '*') {
            scanSymbol();
            extendsBound.add(Object.class);
            return new ImplForWildcard(extendsBound, superBound);
        }
        else if (symbol == '+') {
            scanSymbol();
            extendsBound.add(parseFieldTypeSignature());
            return new ImplForWildcard(extendsBound, superBound);
        }
        else if (symbol == '-') {
            scanSymbol();
            superBound.add(parseFieldTypeSignature());
            extendsBound.add(Object.class);
            return new ImplForWildcard(extendsBound, superBound);
        }
        else {
            return parseFieldTypeSignature();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.768 -0500", hash_original_method = "FF6DECA5851C272F523D7639C2D071BC", hash_generated_method = "8ADC92F2BC521F13815E267CE99829F3")
    
ImplForVariable<GenericDeclaration> parseTypeVariableSignature() {
        // TypeVariableSignature ::= "T" Ident ";".
        expect('T');
        scanIdentifier();
        expect(';');
        // Reference to type variable:
        // Note: we don't know the declaring GenericDeclaration yet.
        return new ImplForVariable<GenericDeclaration>(genericDecl, identifier);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.770 -0500", hash_original_method = "ABCBB21DD03AAC76512AB0248A5CE39A", hash_generated_method = "D5145821AA502497BF8C3C8E07217636")
    
Type parseTypeSignature() {
        switch (symbol) {
        case 'B': scanSymbol(); return byte.class;
        case 'C': scanSymbol(); return char.class;
        case 'D': scanSymbol(); return double.class;
        case 'F': scanSymbol(); return float.class;
        case 'I': scanSymbol(); return int.class;
        case 'J': scanSymbol(); return long.class;
        case 'S': scanSymbol(); return short.class;
        case 'Z': scanSymbol(); return boolean.class;
        default:
            // Not an elementary type, but a FieldTypeSignature.
            return parseFieldTypeSignature();
        }
    }

    /**
     * @param rawExceptionTypes the non-generic exceptions. This is necessary
     *     because the signature may omit the exceptions when none are generic.
     *     May be null for methods that declare no exceptions.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.773 -0500", hash_original_method = "BD4178EAA9E41C4057CACEBF28047848", hash_generated_method = "B9D25BB4D17A2AA456779F79CBF8756A")
    
void parseMethodTypeSignature(Class<?>[] rawExceptionTypes) {
        // MethodTypeSignature ::= [FormalTypeParameters]
        //         "(" {TypeSignature} ")" ReturnType {ThrowsSignature}.

        parseOptFormalTypeParameters();

        parameterTypes = new ListOfTypes(16);
        expect('(');
        while (symbol != ')' && (symbol > 0)) {
            parameterTypes.add(parseTypeSignature());
        }
        expect(')');

        returnType = parseReturnType();

        if (symbol == '^') {
            exceptionTypes = new ListOfTypes(8);
            do {
                scanSymbol();

                // ThrowsSignature ::= ("^" ClassTypeSignature) |
                //     ("^" TypeVariableSignature).
                if (symbol == 'T') {
                    exceptionTypes.add(parseTypeVariableSignature());
                } else {
                    exceptionTypes.add(parseClassTypeSignature());
                }
            } while (symbol == '^');
        } else if (rawExceptionTypes != null) {
            exceptionTypes = new ListOfTypes(rawExceptionTypes);
        } else {
            exceptionTypes = new ListOfTypes(0);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.776 -0500", hash_original_method = "6FEAF434B1E5FC2FC9EAA724A7A39FCB", hash_generated_method = "879B662B2A1DB1FA2733B83159E41A05")
    
Type parseReturnType() {
        // ReturnType ::= TypeSignature | "V".
        if (symbol != 'V') { return parseTypeSignature(); }
        else { scanSymbol(); return void.class; }
    }

    //
    // Scanner:
    //

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.779 -0500", hash_original_method = "CAE4999AD72CF442B6BBF401B7699A36", hash_generated_method = "CAE4999AD72CF442B6BBF401B7699A36")
    
void scanSymbol() {
        if (!eof) {
            if (pos < buffer.length) {
                symbol = buffer[pos];
                pos++;
            } else {
                symbol = 0;
                eof = true;
            }
        } else {
            throw new GenericSignatureFormatError();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.781 -0500", hash_original_method = "D25C52D6AA7AD670E052B9729E548EBD", hash_generated_method = "D25C52D6AA7AD670E052B9729E548EBD")
    
void expect(char c) {
        if (symbol == c) {
            scanSymbol();
        } else {
            throw new GenericSignatureFormatError();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.783 -0500", hash_original_method = "1CE8B25C92A2D6D9FB5D5E3D923D48F0", hash_generated_method = "1CE8B25C92A2D6D9FB5D5E3D923D48F0")
    
boolean isStopSymbol(char ch) {
        switch (ch) {
        case ':':
        case '/':
        case ';':
        case '<':
        case '.':
            return true;
        }
        return false;
    }

    // PRE: symbol is the first char of the identifier.
    // POST: symbol = the next symbol AFTER the identifier.
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.785 -0500", hash_original_method = "A47433FA08CE7DFA194FC642B799E216", hash_generated_method = "5C3CF2A8B89A4104A3955E6247375751")
    
void scanIdentifier() {
        if (!eof) {
            StringBuilder identBuf = new StringBuilder(32);
            if (!isStopSymbol(symbol)) {
                identBuf.append(symbol);
                do {
                    char ch = buffer[pos];
                    if ((ch >= 'a') && (ch <= 'z') || (ch >= 'A') && (ch <= 'Z')
                            || !isStopSymbol(ch)) {
                        identBuf.append(buffer[pos]);
                        pos++;
                    } else {
                        identifier = identBuf.toString();
                        scanSymbol();
                        return;
                    }
                } while (pos != buffer.length);
                identifier = identBuf.toString();
                symbol = 0;
                eof = true;
            } else {
                // Ident starts with incorrect char.
                symbol = 0;
                eof = true;
                throw new GenericSignatureFormatError();
            }
        } else {
            throw new GenericSignatureFormatError();
        }
    }
    
}

