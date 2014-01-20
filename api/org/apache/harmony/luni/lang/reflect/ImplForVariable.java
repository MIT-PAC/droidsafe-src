package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class ImplForVariable<D extends GenericDeclaration> implements TypeVariable<D> {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.231 -0500", hash_original_method = "D221C8A1B569E1806838DFC95ACABA4D", hash_generated_method = "62BA4A52D51025362248E21AAD3D7B07")
    
static TypeVariable findFormalVar(GenericDeclaration layer, String name) {
        TypeVariable[] formalVars = layer.getTypeParameters();
        for (TypeVariable var : formalVars) {
            if (name.equals(var.getName())) {
                return var;
            }
        }
        // resolve() looks up the next level only, if null is returned
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.234 -0500", hash_original_method = "39EFECC73CF5D127083D3BC71C87A926", hash_generated_method = "BDC29D66C62A40ED8D984E5D79ABFC24")
    
private static GenericDeclaration nextLayer(GenericDeclaration decl) {
        if (decl instanceof Class) {
            // FIXME: Is the following hierarchy correct?:
            Class cl = (Class)decl;
            decl = cl.getEnclosingMethod();
            if (decl != null) {
                return decl;
            }
            decl = cl.getEnclosingConstructor();
            if (decl != null) {
                return decl;
            }
            return cl.getEnclosingClass();
        } else if (decl instanceof Method) {
            return ((Method)decl).getDeclaringClass();
        } else if (decl instanceof Constructor) {
            return ((Constructor)decl).getDeclaringClass();
        } else {
            throw new AssertionError();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.209 -0500", hash_original_field = "9D17C71A4E0210EC938787CDBE83B4DB", hash_generated_field = "DF50F8CC44C9A6C55B93B98D6924A459")

    private ImplForVariable<D> formalVar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.212 -0500", hash_original_field = "C1C0677D5E0FAEC19F513414D0A08EF8", hash_generated_field = "7035CFC4FC43B968B950AEFCB822630E")

    private  GenericDeclaration declOfVarUser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.214 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.216 -0500", hash_original_field = "F436CDAF715318EF72CA135B8411491D", hash_generated_field = "66EEA92F56A8153726A1268F7B72CD36")

    private D genericDeclaration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.218 -0500", hash_original_field = "3855AA2BF5AD0164D799C809958B7ACE", hash_generated_field = "E9827BD1F130318D20BAF26AD7BAAAFA")

    private ListOfTypes bounds;

    /**
     * @param genericDecl declaration where a type variable is declared
     * @param name type variable name
     * @param bounds class and interface bounds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.226 -0500", hash_original_method = "B3D8A7562CD7005AEC4EC7212BF5C48A", hash_generated_method = "B3D8A7562CD7005AEC4EC7212BF5C48A")
    
ImplForVariable(D genericDecl, String name, ListOfTypes bounds) {
        this.genericDeclaration = genericDecl;
        this.name = name;
        this.bounds = bounds;
        this.formalVar = this;
        this.declOfVarUser = null;
    }

    /**
     * @param genericDecl declaration where a type variable is used
     * @param name type variable name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.229 -0500", hash_original_method = "65407CBB14414F74E97F8F69661C31EA", hash_generated_method = "65407CBB14414F74E97F8F69661C31EA")
    
ImplForVariable(D genericDecl, String name) {
        this.name = name;
        this.declOfVarUser = genericDecl;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.221 -0500", hash_original_method = "1E5AB95BB29F6C6E7982DF5E5FB9856A", hash_generated_method = "C53D1FC2244C3A4E92457E5A7811D82D")
    
@Override
    public boolean equals(Object o) {
        if(!(o instanceof TypeVariable)) {
            return false;
        }
        TypeVariable<?> that = (TypeVariable<?>) o;
        return getName().equals(that.getName()) &&
                getGenericDeclaration().equals(that.getGenericDeclaration());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.223 -0500", hash_original_method = "7D0F85484BF18E8882B18922DC61C5E2", hash_generated_method = "23EB5A1B17C6903E249FA43F8F4A367D")
    
@Override
    public int hashCode() {
        return 31 * getName().hashCode() + getGenericDeclaration().hashCode();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.236 -0500", hash_original_method = "295DDC7EA34C93EE6582DD0CD1BD5CCA", hash_generated_method = "295DDC7EA34C93EE6582DD0CD1BD5CCA")
    
void resolve() {
        if (formalVar != null) {
            return;
        }
        GenericDeclaration curLayer = declOfVarUser;
        TypeVariable var;
        while ((var = findFormalVar(curLayer, name)) == null) {
            curLayer = nextLayer(curLayer);
            if (curLayer == null) {
                throw new AssertionError("illegal type variable reference");
            }
        }
        formalVar = (ImplForVariable<D>) var;
        this.genericDeclaration = formalVar.genericDeclaration;
        this.bounds = formalVar.bounds;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.238 -0500", hash_original_method = "234813F4553928C427D0DF90A4217999", hash_generated_method = "C56F23EB4401D7687760D536E5D5C3A8")
    
public Type[] getBounds() {
        resolve();
        return bounds.getResolvedTypes().clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.241 -0500", hash_original_method = "DFDCD7E6E682AFE4AA9958AFD14EDF45", hash_generated_method = "1AFC71142008203AC2E64A1DDC7843F6")
    
public D getGenericDeclaration() {
        resolve();
        return genericDeclaration;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.243 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:26.245 -0500", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "0D841C721535905DD0E9F7FAE6757EB9")
    
@Override
    public String toString() {
        return name;
    }
    
}

