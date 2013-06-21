package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class ImplForVariable<D extends GenericDeclaration> implements TypeVariable<D> {
    private ImplForVariable<D> formalVar;
    private GenericDeclaration declOfVarUser;
    private String name;
    private D genericDeclaration;
    private ListOfTypes bounds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.830 -0400", hash_original_method = "B3D8A7562CD7005AEC4EC7212BF5C48A", hash_generated_method = "1EE83D36420506C80A5FEDF10F823B12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ImplForVariable(D genericDecl, String name, ListOfTypes bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(genericDecl.dsTaint);
        dsTaint.addTaint(name);
        this.formalVar = this;
        this.declOfVarUser = null;
        // ---------- Original Method ----------
        //this.genericDeclaration = genericDecl;
        //this.name = name;
        //this.bounds = bounds;
        //this.formalVar = this;
        //this.declOfVarUser = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.830 -0400", hash_original_method = "65407CBB14414F74E97F8F69661C31EA", hash_generated_method = "11C2E6551D909457D524ACBF64AA38A1")
    @DSModeled(DSC.SAFE)
     ImplForVariable(D genericDecl, String name) {
        dsTaint.addTaint(genericDecl.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
        //this.name = name;
        //this.declOfVarUser = genericDecl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.830 -0400", hash_original_method = "1E5AB95BB29F6C6E7982DF5E5FB9856A", hash_generated_method = "06B9689181A6C2FD2804E2E358B421F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        TypeVariable<?> that;
        that = (TypeVariable<?>) o;
        boolean varE2B19B1045942F8A2657211D9CE2E8EE_2110373233 = (getName().equals(that.getName()) &&
                getGenericDeclaration().equals(that.getGenericDeclaration()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if(!(o instanceof TypeVariable)) {
            //return false;
        //}
        //TypeVariable<?> that = (TypeVariable<?>) o;
        //return getName().equals(that.getName()) &&
                //getGenericDeclaration().equals(that.getGenericDeclaration());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.830 -0400", hash_original_method = "7D0F85484BF18E8882B18922DC61C5E2", hash_generated_method = "F3C76A871647A895A23E7DB633258179")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var81743D2FAB9555FFF19EA3830889F54F_1799109195 = (31 * getName().hashCode() + getGenericDeclaration().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 31 * getName().hashCode() + getGenericDeclaration().hashCode();
    }

    
        static TypeVariable findFormalVar(GenericDeclaration layer, String name) {
        TypeVariable[] formalVars = layer.getTypeParameters();
        for (TypeVariable var : formalVars) {
            if (name.equals(var.getName())) {
                return var;
            }
        }
        return null;
    }

    
        private static GenericDeclaration nextLayer(GenericDeclaration decl) {
        if (decl instanceof Class) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.831 -0400", hash_original_method = "295DDC7EA34C93EE6582DD0CD1BD5CCA", hash_generated_method = "C9936302BBF102143A66946FEF8E4422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void resolve() {
        GenericDeclaration curLayer;
        curLayer = declOfVarUser;
        TypeVariable var;
        {
            boolean varDB130F3F7B0D3409C8C84C263C726E15_443432333 = ((var = findFormalVar(curLayer, name)) == null);
            {
                curLayer = nextLayer(curLayer);
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError("illegal type variable reference");
                } //End block
            } //End block
        } //End collapsed parenthetic
        formalVar = (ImplForVariable<D>) var;
        this.genericDeclaration = formalVar.genericDeclaration;
        this.bounds = formalVar.bounds;
        // ---------- Original Method ----------
        //if (formalVar != null) {
            //return;
        //}
        //GenericDeclaration curLayer = declOfVarUser;
        //TypeVariable var;
        //while ((var = findFormalVar(curLayer, name)) == null) {
            //curLayer = nextLayer(curLayer);
            //if (curLayer == null) {
                //throw new AssertionError("illegal type variable reference");
            //}
        //}
        //formalVar = (ImplForVariable<D>) var;
        //this.genericDeclaration = formalVar.genericDeclaration;
        //this.bounds = formalVar.bounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.831 -0400", hash_original_method = "234813F4553928C427D0DF90A4217999", hash_generated_method = "9A0F16E87668687DEA94EE07D48D1ECD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getBounds() {
        resolve();
        Type[] varB58684D2CA53F67B61EF8B1A262D1ADA_1522705761 = (bounds.getResolvedTypes().clone());
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //resolve();
        //return bounds.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.832 -0400", hash_original_method = "DFDCD7E6E682AFE4AA9958AFD14EDF45", hash_generated_method = "99048F2F7815D99D25534D9ED5F1BDC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public D getGenericDeclaration() {
        resolve();
        return (D)dsTaint.getTaint();
        // ---------- Original Method ----------
        //resolve();
        //return genericDeclaration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.832 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.832 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "07B6DEDCDA0BCBF94ECA7AFA0C3C49FD")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
}

