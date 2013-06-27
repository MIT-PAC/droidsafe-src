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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.918 -0400", hash_original_field = "C21C5A7DA2DB0FAEF0BF3875ED1F55A6", hash_generated_field = "DF50F8CC44C9A6C55B93B98D6924A459")

    private ImplForVariable<D> formalVar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.918 -0400", hash_original_field = "C5C6A8265660B70AF03B3C3F750F960C", hash_generated_field = "7035CFC4FC43B968B950AEFCB822630E")

    private GenericDeclaration declOfVarUser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.918 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.929 -0400", hash_original_field = "B12FF05E5FD699082DF3F643E50ECA52", hash_generated_field = "66EEA92F56A8153726A1268F7B72CD36")

    private D genericDeclaration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.929 -0400", hash_original_field = "EB49194CCCC646FC8E93A368301834EA", hash_generated_field = "E9827BD1F130318D20BAF26AD7BAAAFA")

    private ListOfTypes bounds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.930 -0400", hash_original_method = "B3D8A7562CD7005AEC4EC7212BF5C48A", hash_generated_method = "E8631B1CAC0FA9A3276D2C091011B265")
      ImplForVariable(D genericDecl, String name, ListOfTypes bounds) {
        this.genericDeclaration = genericDecl;
        this.name = name;
        this.bounds = bounds;
        this.formalVar = this;
        this.declOfVarUser = null;
        // ---------- Original Method ----------
        //this.genericDeclaration = genericDecl;
        //this.name = name;
        //this.bounds = bounds;
        //this.formalVar = this;
        //this.declOfVarUser = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.930 -0400", hash_original_method = "65407CBB14414F74E97F8F69661C31EA", hash_generated_method = "9DCD27E147432DCB3E884717AE64C2A4")
      ImplForVariable(D genericDecl, String name) {
        this.name = name;
        this.declOfVarUser = genericDecl;
        // ---------- Original Method ----------
        //this.name = name;
        //this.declOfVarUser = genericDecl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.931 -0400", hash_original_method = "1E5AB95BB29F6C6E7982DF5E5FB9856A", hash_generated_method = "F4EB5F5DBB172FE3CA56B7AC17B71E83")
    @Override
    public boolean equals(Object o) {
        TypeVariable<?> that;
        that = (TypeVariable<?>) o;
        boolean varE2B19B1045942F8A2657211D9CE2E8EE_1444701764 = (getName().equals(that.getName()) &&
                getGenericDeclaration().equals(that.getGenericDeclaration()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1881786716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1881786716;
        // ---------- Original Method ----------
        //if(!(o instanceof TypeVariable)) {
            //return false;
        //}
        //TypeVariable<?> that = (TypeVariable<?>) o;
        //return getName().equals(that.getName()) &&
                //getGenericDeclaration().equals(that.getGenericDeclaration());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.931 -0400", hash_original_method = "7D0F85484BF18E8882B18922DC61C5E2", hash_generated_method = "91E0FA482B5D2B72641808FCA38C5D7C")
    @Override
    public int hashCode() {
        int var81743D2FAB9555FFF19EA3830889F54F_1334354570 = (31 * getName().hashCode() + getGenericDeclaration().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690535800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690535800;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.936 -0400", hash_original_method = "295DDC7EA34C93EE6582DD0CD1BD5CCA", hash_generated_method = "FA11CCF90D6C8D65D3AAAD916AF36468")
     void resolve() {
        GenericDeclaration curLayer;
        curLayer = declOfVarUser;
        TypeVariable var;
        {
            boolean varDB130F3F7B0D3409C8C84C263C726E15_524825087 = ((var = findFormalVar(curLayer, name)) == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.943 -0400", hash_original_method = "234813F4553928C427D0DF90A4217999", hash_generated_method = "7A5BFD4F54FEDFCF13AD10395885BD96")
    public Type[] getBounds() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_2047545360 = null; //Variable for return #1
        resolve();
        varB4EAC82CA7396A68D541C85D26508E83_2047545360 = bounds.getResolvedTypes().clone();
        varB4EAC82CA7396A68D541C85D26508E83_2047545360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047545360;
        // ---------- Original Method ----------
        //resolve();
        //return bounds.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.943 -0400", hash_original_method = "DFDCD7E6E682AFE4AA9958AFD14EDF45", hash_generated_method = "6A536B0175E89C3F19BC74958A157F41")
    public D getGenericDeclaration() {
        D varB4EAC82CA7396A68D541C85D26508E83_340814264 = null; //Variable for return #1
        resolve();
        varB4EAC82CA7396A68D541C85D26508E83_340814264 = genericDeclaration;
        varB4EAC82CA7396A68D541C85D26508E83_340814264.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_340814264;
        // ---------- Original Method ----------
        //resolve();
        //return genericDeclaration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.947 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "11290EFBA677F610812D1266D1D7CDE6")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_292980183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_292980183 = name;
        varB4EAC82CA7396A68D541C85D26508E83_292980183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_292980183;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.947 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "77516A6F58E9B642447DFCD9733BA885")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1016660048 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1016660048 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1016660048.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1016660048;
        // ---------- Original Method ----------
        //return name;
    }

    
}

