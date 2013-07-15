package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class ImplForVariable<D extends GenericDeclaration> implements TypeVariable<D> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.316 -0400", hash_original_field = "C21C5A7DA2DB0FAEF0BF3875ED1F55A6", hash_generated_field = "DF50F8CC44C9A6C55B93B98D6924A459")

    private ImplForVariable<D> formalVar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.316 -0400", hash_original_field = "C5C6A8265660B70AF03B3C3F750F960C", hash_generated_field = "7035CFC4FC43B968B950AEFCB822630E")

    private GenericDeclaration declOfVarUser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.316 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.316 -0400", hash_original_field = "B12FF05E5FD699082DF3F643E50ECA52", hash_generated_field = "66EEA92F56A8153726A1268F7B72CD36")

    private D genericDeclaration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.316 -0400", hash_original_field = "EB49194CCCC646FC8E93A368301834EA", hash_generated_field = "E9827BD1F130318D20BAF26AD7BAAAFA")

    private ListOfTypes bounds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.317 -0400", hash_original_method = "B3D8A7562CD7005AEC4EC7212BF5C48A", hash_generated_method = "E8631B1CAC0FA9A3276D2C091011B265")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.318 -0400", hash_original_method = "65407CBB14414F74E97F8F69661C31EA", hash_generated_method = "9DCD27E147432DCB3E884717AE64C2A4")
      ImplForVariable(D genericDecl, String name) {
        this.name = name;
        this.declOfVarUser = genericDecl;
        // ---------- Original Method ----------
        //this.name = name;
        //this.declOfVarUser = genericDecl;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.318 -0400", hash_original_method = "1E5AB95BB29F6C6E7982DF5E5FB9856A", hash_generated_method = "2130AFDB010D5546E64AE8C9693D009F")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(!(o instanceof TypeVariable))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1712218605 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_687013908 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_687013908;
        } //End block
        TypeVariable<?> that = (TypeVariable<?>) o;
        boolean var28F60F048D2660E5E234209FE6F3558A_1348335388 = (getName().equals(that.getName()) &&
                getGenericDeclaration().equals(that.getGenericDeclaration()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831506882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831506882;
        // ---------- Original Method ----------
        //if(!(o instanceof TypeVariable)) {
            //return false;
        //}
        //TypeVariable<?> that = (TypeVariable<?>) o;
        //return getName().equals(that.getName()) &&
                //getGenericDeclaration().equals(that.getGenericDeclaration());
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.319 -0400", hash_original_method = "7D0F85484BF18E8882B18922DC61C5E2", hash_generated_method = "388E3F3129F86C875579390386482B4A")
    @Override
    public int hashCode() {
        int var612E142C52816878DF7B2206464ECBB2_1104503757 = (31 * getName().hashCode() + getGenericDeclaration().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193374506 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193374506;
        // ---------- Original Method ----------
        //return 31 * getName().hashCode() + getGenericDeclaration().hashCode();
    }

    
        @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.320 -0400", hash_original_method = "295DDC7EA34C93EE6582DD0CD1BD5CCA", hash_generated_method = "12E5393FAC844E4285FA9B068964C774")
     void resolve() {
    if(formalVar != null)        
        {
            return;
        } //End block
        GenericDeclaration curLayer = declOfVarUser;
        TypeVariable var;
        while
((var = findFormalVar(curLayer, name)) == null)        
        {
            curLayer = nextLayer(curLayer);
    if(curLayer == null)            
            {
                AssertionError var1927BC3C0E63186AB163EB47890FC60D_316725171 = new AssertionError("illegal type variable reference");
                var1927BC3C0E63186AB163EB47890FC60D_316725171.addTaint(taint);
                throw var1927BC3C0E63186AB163EB47890FC60D_316725171;
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.321 -0400", hash_original_method = "234813F4553928C427D0DF90A4217999", hash_generated_method = "41A4D34CF3BFF437E8912C389E6F5FEB")
    public Type[] getBounds() {
        resolve();
Type[] varD218C9A70ACBE6735DB6C2DBDABF35B2_1213641096 =         bounds.getResolvedTypes().clone();
        varD218C9A70ACBE6735DB6C2DBDABF35B2_1213641096.addTaint(taint);
        return varD218C9A70ACBE6735DB6C2DBDABF35B2_1213641096;
        // ---------- Original Method ----------
        //resolve();
        //return bounds.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.321 -0400", hash_original_method = "DFDCD7E6E682AFE4AA9958AFD14EDF45", hash_generated_method = "BF8EB26A56D4D4DF42FA7502BF2B0040")
    public D getGenericDeclaration() {
        resolve();
D var409EE86EA9754D59CEC235E861B25783_1397923642 =         genericDeclaration;
        var409EE86EA9754D59CEC235E861B25783_1397923642.addTaint(taint);
        return var409EE86EA9754D59CEC235E861B25783_1397923642;
        // ---------- Original Method ----------
        //resolve();
        //return genericDeclaration;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.321 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "4E26347D1D250FA223E9ADDD26124BC7")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_825248104 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_825248104.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_825248104;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.322 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "F08E286C412EBCDF60E9DD262AC5C359")
    @Override
    public String toString() {
String varB017984728AC60AD1F0BF8734F33F15C_1646415731 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1646415731.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1646415731;
        // ---------- Original Method ----------
        //return name;
    }

    
}

