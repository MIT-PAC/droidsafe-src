package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class GenericSignatureParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "2CD56E5B83C33F80B2D25820C51596A0", hash_generated_field = "3A123DBAC2896D22118ACC4A0DBF2815")

    public ListOfTypes exceptionTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "11427856321C6E9F5321CA879704C8FE", hash_generated_field = "755AC25C18AC88DD7B505952EB00E2FC")

    public ListOfTypes parameterTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "898BB6A86E0DA433332CBC4F55D3E967", hash_generated_field = "96CAE8588B8CB92AE83279FEB36F4121")

    public TypeVariable[] formalTypeParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "9CD6843F4536590CD86F933708C7371E", hash_generated_field = "8FCAB3423DB3533C393A75EA17B6B1D8")

    public Type returnType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "833750AC635FCC57DC33ECAFE365F9A7", hash_generated_field = "7BF0B57018D92E424F704D1E59B55203")

    public Type fieldType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "2E8612447B369F7E0D27C66E9273CB06", hash_generated_field = "0A3DD769080BC24A9D258283D7D7DC30")

    public ListOfTypes interfaceTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "2DC4A623293420174B22464D58B6A831", hash_generated_field = "2B6C083B05F286DFD7F93749F54AF5DA")

    public Type superclassType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "4A527F83A3A4CA7E1D70ADB26A35B72E", hash_generated_field = "34AC02C91B7B47224132768354947AB0")

    public ClassLoader loader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "AA84DC6545C7C550F5338E00F04FD372", hash_generated_field = "4BEC95563D8D0B015ABDE90FC2F1C6AF")

    GenericDeclaration genericDecl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.264 -0400", hash_original_field = "97BFF26855A8BFA63E05D5477E794B24", hash_generated_field = "4D622F1F51FE2777B0E8D81C997E113C")

    char symbol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.265 -0400", hash_original_field = "F393F3F5E496869A15BC72CBFD56F541", hash_generated_field = "67D18ED1400CD458B308847E018D0637")

    String identifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.265 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.265 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "AF37951EAE101F357ACAF48FB7E85D88")

    char[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.265 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

    int pos;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.265 -0400", hash_original_method = "B4AF29B80F8E14619B64C65F02963718", hash_generated_method = "C049BAD034A575B3E9230CA1104DE603")
    public  GenericSignatureParser(ClassLoader loader) {
        this.loader = loader;
        // ---------- Original Method ----------
        //this.loader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.266 -0400", hash_original_method = "6F9101760876DEB9422AEF7944CF1BF2", hash_generated_method = "3C1396EEA2BF2CE3E7EB55D972F5D289")
     void setInput(GenericDeclaration genericDecl, String input) {
    if(input != null)        
        {
            this.genericDecl = genericDecl;
            this.buffer = input.toCharArray();
            this.eof = false;
            scanSymbol();
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.267 -0400", hash_original_method = "408B9941E0DDFF19B1C3AECDF838B6FF", hash_generated_method = "80986255CAC1AC03631EA5FEF448E577")
    public void parseForClass(GenericDeclaration genericDecl,
            String signature) {
        addTaint(signature.getTaint());
        addTaint(genericDecl.getTaint());
        setInput(genericDecl, signature);
    if(!eof)        
        {
            parseClassSignature();
        } //End block
        else
        {
    if(genericDecl instanceof Class)            
            {
                Class c = (Class) genericDecl;
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.superclassType = c.getSuperclass();
                this.interfaceTypes = new ListOfTypes(c.getInterfaces());
            } //End block
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.269 -0400", hash_original_method = "15DFE7F1F24F7739B7BEC1E53A5655D9", hash_generated_method = "563AB087B6DA97B0E6A38EB2360EC998")
    public void parseForMethod(GenericDeclaration genericDecl,
            String signature, Class<?>[] rawExceptionTypes) {
        addTaint(rawExceptionTypes[0].getTaint());
        addTaint(signature.getTaint());
        addTaint(genericDecl.getTaint());
        setInput(genericDecl, signature);
    if(!eof)        
        {
            parseMethodTypeSignature(rawExceptionTypes);
        } //End block
        else
        {
    if(genericDecl instanceof Method)            
            {
                Method m = (Method) genericDecl;
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = new ListOfTypes(m.getParameterTypes());
                this.exceptionTypes = new ListOfTypes(m.getExceptionTypes());
                this.returnType = m.getReturnType();
            } //End block
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.271 -0400", hash_original_method = "0C9CA8BB038974E4A40BF19F7EB72426", hash_generated_method = "6000E3D80E377B42BB430C2FBD99EE3F")
    public void parseForConstructor(GenericDeclaration genericDecl,
            String signature, Class<?>[] rawExceptionTypes) {
        addTaint(rawExceptionTypes[0].getTaint());
        addTaint(signature.getTaint());
        addTaint(genericDecl.getTaint());
        setInput(genericDecl, signature);
    if(!eof)        
        {
            parseMethodTypeSignature(rawExceptionTypes);
        } //End block
        else
        {
    if(genericDecl instanceof Constructor)            
            {
                Constructor c = (Constructor) genericDecl;
                this.formalTypeParameters = ListOfVariables.EMPTY;
                this.parameterTypes = new ListOfTypes(c.getParameterTypes());
                this.exceptionTypes = new ListOfTypes(c.getExceptionTypes());
            } //End block
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.271 -0400", hash_original_method = "F697D7E02D0C8DEEF4B0854E9491CC15", hash_generated_method = "14A999D722B6CCF0178DCC4DAA758E34")
    public void parseForField(GenericDeclaration genericDecl,
            String signature) {
        addTaint(signature.getTaint());
        addTaint(genericDecl.getTaint());
        setInput(genericDecl, signature);
    if(!eof)        
        {
            this.fieldType = parseFieldTypeSignature();
        } //End block
        // ---------- Original Method ----------
        //setInput(genericDecl, signature);
        //if (!eof) {
            //this.fieldType = parseFieldTypeSignature();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.272 -0400", hash_original_method = "2A6822DB636AAE3DC282A54EED7D514D", hash_generated_method = "C9B3DB0B00931E7106253CD061EB31DD")
     void parseClassSignature() {
        parseOptFormalTypeParameters();
        this.superclassType = parseClassTypeSignature();
        interfaceTypes = new ListOfTypes(16);
        while
(symbol > 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.273 -0400", hash_original_method = "F25135739D6C61926B7C7AB20920C0C3", hash_generated_method = "24317D1D2603A28105AC58F4B5AC796E")
     void parseOptFormalTypeParameters() {
        ListOfVariables typeParams = new ListOfVariables();
    if(symbol == '<')        
        {
            scanSymbol();
            typeParams.add(parseFormalTypeParameter());
            while
((symbol != '>') && (symbol > 0))            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.273 -0400", hash_original_method = "8E4B54F231B830B261D22AAC458F74D2", hash_generated_method = "393CE70D84CC83028D6FBA5338A53E26")
     ImplForVariable<GenericDeclaration> parseFormalTypeParameter() {
        scanIdentifier();
        String name = identifier.intern();
        ListOfTypes bounds = new ListOfTypes(8);
        expect(':');
    if(symbol == 'L' || symbol == '[' || symbol == 'T')        
        {
            bounds.add(parseFieldTypeSignature());
        } //End block
        while
(symbol == ':')        
        {
            scanSymbol();
            bounds.add(parseFieldTypeSignature());
        } //End block
ImplForVariable<GenericDeclaration> varFE48EB0E9D8E615343B2B93E7D7C303E_1189300873 =         new ImplForVariable<GenericDeclaration>(genericDecl, name, bounds);
        varFE48EB0E9D8E615343B2B93E7D7C303E_1189300873.addTaint(taint);
        return varFE48EB0E9D8E615343B2B93E7D7C303E_1189300873;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.276 -0400", hash_original_method = "39858CB077F5F270CB13BCD8F5E588C4", hash_generated_method = "F8698A61BA490121F71224F26A581471")
     Type parseFieldTypeSignature() {
switch(symbol){
        case 'L':
Type varA92B96499451606A054C62E696E03ADD_610097373 =         parseClassTypeSignature();
        varA92B96499451606A054C62E696E03ADD_610097373.addTaint(taint);
        return varA92B96499451606A054C62E696E03ADD_610097373;
        case '[':
        scanSymbol();
Type var3DABF64A327C422FA9A01DD83CE315F8_1698707082 =         new ImplForArray(parseTypeSignature());
        var3DABF64A327C422FA9A01DD83CE315F8_1698707082.addTaint(taint);
        return var3DABF64A327C422FA9A01DD83CE315F8_1698707082;
        case 'T':
Type varC598CFD9A43D0422EA3785D4E145264E_1606529167 =         parseTypeVariableSignature();
        varC598CFD9A43D0422EA3785D4E145264E_1606529167.addTaint(taint);
        return varC598CFD9A43D0422EA3785D4E145264E_1606529167;
        default:
        GenericSignatureFormatError var0D16374D19AD0EA9C4CDB5D4A79B250E_1025707578 = new GenericSignatureFormatError();
        var0D16374D19AD0EA9C4CDB5D4A79B250E_1025707578.addTaint(taint);
        throw var0D16374D19AD0EA9C4CDB5D4A79B250E_1025707578;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.277 -0400", hash_original_method = "0940B5693D1CE1CEA33652B7603676B3", hash_generated_method = "B5C0CBFFBF36B194D2FDED5C4B530D5E")
     Type parseClassTypeSignature() {
        expect('L');
        StringBuilder qualIdent = new StringBuilder();
        scanIdentifier();
        while
(symbol == '/')        
        {
            scanSymbol();
            qualIdent.append(identifier).append(".");
            scanIdentifier();
        } //End block
        qualIdent.append(this.identifier);
        ListOfTypes typeArgs = parseOptTypeArguments();
        ImplForType parentType = new ImplForType(null, qualIdent.toString(), typeArgs, loader);
        ImplForType type = parentType;
        while
(symbol == '.')        
        {
            scanSymbol();
            scanIdentifier();
            qualIdent.append("$").append(identifier);
            typeArgs = parseOptTypeArguments();
            type = new ImplForType(parentType, qualIdent.toString(), typeArgs,
                    loader);
        } //End block
        expect(';');
Type varC5B9F25B4EEAD3E8E2C33F9429204397_846800345 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_846800345.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_846800345;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.277 -0400", hash_original_method = "FCA6C6C42F8D0470CBF5F70C4C8E2247", hash_generated_method = "C1583B50C9ED2AC13C5BEF30D5F192C6")
     ListOfTypes parseOptTypeArguments() {
        ListOfTypes typeArgs = new ListOfTypes(8);
    if(symbol == '<')        
        {
            scanSymbol();
            typeArgs.add(parseTypeArgument());
            while
((symbol != '>') && (symbol > 0))            
            {
                typeArgs.add(parseTypeArgument());
            } //End block
            expect('>');
        } //End block
ListOfTypes var67FC647329A9DDFB24CE97A62A874292_2066952947 =         typeArgs;
        var67FC647329A9DDFB24CE97A62A874292_2066952947.addTaint(taint);
        return var67FC647329A9DDFB24CE97A62A874292_2066952947;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.278 -0400", hash_original_method = "C611A5720E520CD6B6248914D1F9FF4D", hash_generated_method = "DF64F377F9DF554B0D4B68A193AB7EA8")
     Type parseTypeArgument() {
        ListOfTypes extendsBound = new ListOfTypes(1);
        ListOfTypes superBound = new ListOfTypes(1);
    if(symbol == '*')        
        {
            scanSymbol();
            extendsBound.add(Object.class);
Type var0412122CA12E6ABA5C904031D4DDE7CB_733032698 =             new ImplForWildcard(extendsBound, superBound);
            var0412122CA12E6ABA5C904031D4DDE7CB_733032698.addTaint(taint);
            return var0412122CA12E6ABA5C904031D4DDE7CB_733032698;
        } //End block
        else
    if(symbol == '+')        
        {
            scanSymbol();
            extendsBound.add(parseFieldTypeSignature());
Type var0412122CA12E6ABA5C904031D4DDE7CB_43817594 =             new ImplForWildcard(extendsBound, superBound);
            var0412122CA12E6ABA5C904031D4DDE7CB_43817594.addTaint(taint);
            return var0412122CA12E6ABA5C904031D4DDE7CB_43817594;
        } //End block
        else
    if(symbol == '-')        
        {
            scanSymbol();
            superBound.add(parseFieldTypeSignature());
            extendsBound.add(Object.class);
Type var0412122CA12E6ABA5C904031D4DDE7CB_1693061627 =             new ImplForWildcard(extendsBound, superBound);
            var0412122CA12E6ABA5C904031D4DDE7CB_1693061627.addTaint(taint);
            return var0412122CA12E6ABA5C904031D4DDE7CB_1693061627;
        } //End block
        else
        {
Type varADF305843879946E21E3B89E908DB518_1441647195 =             parseFieldTypeSignature();
            varADF305843879946E21E3B89E908DB518_1441647195.addTaint(taint);
            return varADF305843879946E21E3B89E908DB518_1441647195;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.279 -0400", hash_original_method = "FF6DECA5851C272F523D7639C2D071BC", hash_generated_method = "BF00778659F0D0263446DD7E4C748E88")
     ImplForVariable<GenericDeclaration> parseTypeVariableSignature() {
        expect('T');
        scanIdentifier();
        expect(';');
ImplForVariable<GenericDeclaration> var11CAA50B324ECC031E42B5B587147EE2_1686301105 =         new ImplForVariable<GenericDeclaration>(genericDecl, identifier);
        var11CAA50B324ECC031E42B5B587147EE2_1686301105.addTaint(taint);
        return var11CAA50B324ECC031E42B5B587147EE2_1686301105;
        // ---------- Original Method ----------
        //expect('T');
        //scanIdentifier();
        //expect(';');
        //return new ImplForVariable<GenericDeclaration>(genericDecl, identifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.279 -0400", hash_original_method = "ABCBB21DD03AAC76512AB0248A5CE39A", hash_generated_method = "533B3369171F90FBBBD184FBCF76CB3C")
     Type parseTypeSignature() {
switch(symbol){
        case 'B':
        scanSymbol();
Type var7C0ACE62D963137DF2E56A3AE1830737_1812470578 =         byte.class;
        var7C0ACE62D963137DF2E56A3AE1830737_1812470578.addTaint(taint);
        return var7C0ACE62D963137DF2E56A3AE1830737_1812470578;
        case 'C':
        scanSymbol();
Type var021069F65BBE9A67357BF60BD5069AD9_333211018 =         char.class;
        var021069F65BBE9A67357BF60BD5069AD9_333211018.addTaint(taint);
        return var021069F65BBE9A67357BF60BD5069AD9_333211018;
        case 'D':
        scanSymbol();
Type varB1058CC7814EF2B7D2C1906F75D80941_2014904556 =         double.class;
        varB1058CC7814EF2B7D2C1906F75D80941_2014904556.addTaint(taint);
        return varB1058CC7814EF2B7D2C1906F75D80941_2014904556;
        case 'F':
        scanSymbol();
Type var62B620E9FEA9AE784921F21A57CA37EF_1592876971 =         float.class;
        var62B620E9FEA9AE784921F21A57CA37EF_1592876971.addTaint(taint);
        return var62B620E9FEA9AE784921F21A57CA37EF_1592876971;
        case 'I':
        scanSymbol();
Type var985DB82401C248C5D9E18F7141DEF72B_2147070682 =         int.class;
        var985DB82401C248C5D9E18F7141DEF72B_2147070682.addTaint(taint);
        return var985DB82401C248C5D9E18F7141DEF72B_2147070682;
        case 'J':
        scanSymbol();
Type var5B79E8CD9A56F609FB5546A9D74A8875_393361361 =         long.class;
        var5B79E8CD9A56F609FB5546A9D74A8875_393361361.addTaint(taint);
        return var5B79E8CD9A56F609FB5546A9D74A8875_393361361;
        case 'S':
        scanSymbol();
Type var2978261C2ED1639B358207B56E910496_167832324 =         short.class;
        var2978261C2ED1639B358207B56E910496_167832324.addTaint(taint);
        return var2978261C2ED1639B358207B56E910496_167832324;
        case 'Z':
        scanSymbol();
Type var71787BF0A5FAFF61DD7FBBF958D99F8A_1605141402 =         boolean.class;
        var71787BF0A5FAFF61DD7FBBF958D99F8A_1605141402.addTaint(taint);
        return var71787BF0A5FAFF61DD7FBBF958D99F8A_1605141402;
        default:
Type varADF305843879946E21E3B89E908DB518_449270589 =         parseFieldTypeSignature();
        varADF305843879946E21E3B89E908DB518_449270589.addTaint(taint);
        return varADF305843879946E21E3B89E908DB518_449270589;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.280 -0400", hash_original_method = "BD4178EAA9E41C4057CACEBF28047848", hash_generated_method = "CE4162C1BE76ABEACEE6DAAC2C3EEB3D")
     void parseMethodTypeSignature(Class<?>[] rawExceptionTypes) {
        parseOptFormalTypeParameters();
        parameterTypes = new ListOfTypes(16);
        expect('(');
        while
(symbol != ')' && (symbol > 0))        
        {
            parameterTypes.add(parseTypeSignature());
        } //End block
        expect(')');
        returnType = parseReturnType();
    if(symbol == '^')        
        {
            exceptionTypes = new ListOfTypes(8);
            do {
                {
                    scanSymbol();
    if(symbol == 'T')                    
                    {
                        exceptionTypes.add(parseTypeVariableSignature());
                    } //End block
                    else
                    {
                        exceptionTypes.add(parseClassTypeSignature());
                    } //End block
                } //End block
} while (symbol == '^');
        } //End block
        else
    if(rawExceptionTypes != null)        
        {
            exceptionTypes = new ListOfTypes(rawExceptionTypes);
        } //End block
        else
        {
            exceptionTypes = new ListOfTypes(0);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.281 -0400", hash_original_method = "6FEAF434B1E5FC2FC9EAA724A7A39FCB", hash_generated_method = "EE0B72FDE4DDDEA6FDA69DAF75B42588")
     Type parseReturnType() {
    if(symbol != 'V')        
        {
Type var77094595A08D3EE3929C4F8BA32E5839_532966142 =             parseTypeSignature();
            var77094595A08D3EE3929C4F8BA32E5839_532966142.addTaint(taint);
            return var77094595A08D3EE3929C4F8BA32E5839_532966142;
        } //End block
        else
        {
            scanSymbol();
Type var3C5CC6CDB919ACDAB4FA656C419DF43D_1682622244 =             void.class;
            var3C5CC6CDB919ACDAB4FA656C419DF43D_1682622244.addTaint(taint);
            return var3C5CC6CDB919ACDAB4FA656C419DF43D_1682622244;
        } //End block
        // ---------- Original Method ----------
        //if (symbol != 'V') { return parseTypeSignature(); }
        //else { scanSymbol(); return void.class; }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.282 -0400", hash_original_method = "CAE4999AD72CF442B6BBF401B7699A36", hash_generated_method = "06CA0B88F345E851901132718351F865")
     void scanSymbol() {
    if(!eof)        
        {
    if(pos < buffer.length)            
            {
                symbol = buffer[pos];
                pos++;
            } //End block
            else
            {
                symbol = 0;
                eof = true;
            } //End block
        } //End block
        else
        {
            GenericSignatureFormatError var0D16374D19AD0EA9C4CDB5D4A79B250E_1473950833 = new GenericSignatureFormatError();
            var0D16374D19AD0EA9C4CDB5D4A79B250E_1473950833.addTaint(taint);
            throw var0D16374D19AD0EA9C4CDB5D4A79B250E_1473950833;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.282 -0400", hash_original_method = "D25C52D6AA7AD670E052B9729E548EBD", hash_generated_method = "FE7E1CF15CEA6DA9EC3074E72C6E6773")
     void expect(char c) {
        addTaint(c);
    if(symbol == c)        
        {
            scanSymbol();
        } //End block
        else
        {
            GenericSignatureFormatError var0D16374D19AD0EA9C4CDB5D4A79B250E_1188455901 = new GenericSignatureFormatError();
            var0D16374D19AD0EA9C4CDB5D4A79B250E_1188455901.addTaint(taint);
            throw var0D16374D19AD0EA9C4CDB5D4A79B250E_1188455901;
        } //End block
        // ---------- Original Method ----------
        //if (symbol == c) {
            //scanSymbol();
        //} else {
            //throw new GenericSignatureFormatError();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.283 -0400", hash_original_method = "1CE8B25C92A2D6D9FB5D5E3D923D48F0", hash_generated_method = "29CE80D93744498FF172EF6606EB70B0")
     boolean isStopSymbol(char ch) {
        addTaint(ch);
switch(ch){
        case ':':
        case '/':
        case ';':
        case '<':
        case '.':
        boolean varB326B5062B2F0E69046810717534CB09_1090539191 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_797261532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_797261532;
}        boolean var68934A3E9455FA72420237EB05902327_512571725 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1860602374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1860602374;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.284 -0400", hash_original_method = "A47433FA08CE7DFA194FC642B799E216", hash_generated_method = "34781D8845BD1E5ADB37D9F0CE057E97")
     void scanIdentifier() {
    if(!eof)        
        {
            StringBuilder identBuf = new StringBuilder(32);
    if(!isStopSymbol(symbol))            
            {
                identBuf.append(symbol);
                do {
                    {
                        char ch = buffer[pos];
    if((ch >= 'a') && (ch <= 'z') || (ch >= 'A') && (ch <= 'Z')
                            || !isStopSymbol(ch))                        
                        {
                            identBuf.append(buffer[pos]);
                            pos++;
                        } //End block
                        else
                        {
                            identifier = identBuf.toString();
                            scanSymbol();
                            return;
                        } //End block
                    } //End block
} while (pos != buffer.length);
                identifier = identBuf.toString();
                symbol = 0;
                eof = true;
            } //End block
            else
            {
                symbol = 0;
                eof = true;
                GenericSignatureFormatError var0D16374D19AD0EA9C4CDB5D4A79B250E_1099180616 = new GenericSignatureFormatError();
                var0D16374D19AD0EA9C4CDB5D4A79B250E_1099180616.addTaint(taint);
                throw var0D16374D19AD0EA9C4CDB5D4A79B250E_1099180616;
            } //End block
        } //End block
        else
        {
            GenericSignatureFormatError var0D16374D19AD0EA9C4CDB5D4A79B250E_212187024 = new GenericSignatureFormatError();
            var0D16374D19AD0EA9C4CDB5D4A79B250E_212187024.addTaint(taint);
            throw var0D16374D19AD0EA9C4CDB5D4A79B250E_212187024;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

