/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.analyses.value;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import droidsafe.analyses.value.primitives.ClassVAModel;
import droidsafe.transforms.objsensclone.ClassCloner;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.Type;
import soot.jimple.toolkits.pta.IAllocNode;


/**
 * Class containing attribute modeling utility methods 

 * @author dpetters
 */
public class VAUtils {
    /** 
     * Convert the string signature of a regular class to the string signature of the corresponding attr modeling model
     * class 
     */
    public static String toAttrModelingModelClass(String regularClass){
        return ValueAnalysis.MODEL_PACKAGE_PREFIX + regularClass;
    }

    /**
     * Convert the string signature of an attr modeling model class to a string signature of a regular class 
     */
    public static String fromAttrModelingModelClass(String vaModelClass){
        return vaModelClass.split(ValueAnalysis.MODEL_PACKAGE_PREFIX)[1];
    }

    /**
     * Helper method that convers a refType into the appropriate droidsafe.analyses.value.models.class
     *
     * @throws ClassNotFoundException if the correct class isn't modeled 
     */
    public static Class<?> getDroidsafeClass(RefType refType) throws ClassNotFoundException {
        return getDroidsafeClass(refType.getSootClass());
    }

    /**
     * wrapper around toAttrModelingModelClass 
     */
    public static Class<?> getDroidsafeClass(SootClass sootClass) throws ClassNotFoundException {
        return Class.forName(toAttrModelingModelClass(sootClass.getName()));
    }

    /**
     * Given a SootClass, return the corresponding va model SootClass
     */
    public static SootClass getDroidsafeSootClass(SootClass sootClass) throws ClassNotFoundException {
        return Scene.v().getSootClass(toAttrModelingModelClass(sootClass.getName()));
    }

    /**
     * Given a SootClass, return the corresponding va model SootClass
     */
    public static String indent(int level) {
        return (level <= 0) ? "" : String.format("%" + level * 2 + "s", "");
    }

    /**
     * For each node in nodes, find the VA result, and then find all primitive values of type T
     * of the field.  Does not report of any invalidations.
     */
    public static <T> boolean getAnyVAValuesForField(Set<IAllocNode> nodes, String field, Type fieldType, List<T> ret) {
        for (IAllocNode node : nodes) {
            VAModel vaModel = ValueAnalysis.v().getResult(node);
            
            if (vaModel == null)
            	return false;
            
            if (vaModel.invalidated())
                return false;
            
            if(vaModel instanceof RefVAModel) {
                RefVAModel refVAModel = (RefVAModel)vaModel;
                SootClass clonedSootClass = ((RefType)(refVAModel.getAllocNode().getType())).getSootClass();
                SootClass intentSootClass = ClassCloner.getClonedClassFromClone(clonedSootClass);

                //first check the cls constant field
                SootField mField = Scene.v().makeFieldRef(intentSootClass, field, 
                    fieldType, false).resolve();
                
                Set<VAModel> fieldVAModels = refVAModel.getFieldVAModels(mField);
                if (fieldVAModels.size() > 0) {
                    for (VAModel clz : fieldVAModels) {                        
                        if (clz instanceof PrimVAModel) {
                            PrimVAModel<T> clzModel = (PrimVAModel<T>)clz;
                            if (clzModel.invalidated())
                                return false;
                            
                            for (T value : clzModel.getValues()) {
                                ret.add(value);
                            }
                        } 
                    }
                }
            } else {
                return false;
            }            
        }
        return true;
    }
    
    /** 
     * Return true if the node is an android.content.Intent or subclass.
     */
    public static boolean isIntentType(IAllocNode node) {
        Type type = node.getType();
        return type instanceof RefType && 
                Scene.v().getActiveHierarchy().isClassSuperclassOfIncluding
                (Scene.v().getSootClass("android.content.Intent"), ((RefType)type).getSootClass());
    }
    
}
