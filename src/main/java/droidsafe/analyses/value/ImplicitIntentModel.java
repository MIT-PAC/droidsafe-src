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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.utils.GsonExclude;
import soot.RefType;
import soot.jimple.toolkits.pta.IAllocNode;

public class ImplicitIntentModel extends IntentModel {
    private static final Logger logger = LoggerFactory.getLogger(ImplicitIntentModel.class);
    /** Alloc Node corresponding to this implicit intent model */
    @GsonExclude
    private IAllocNode node;
    @GsonExclude
    private RefVAModel vaModel;

    private boolean[] isInvalidated;

    private Set<String>[] values;

    private static final int nFields = ImplicitIntentFields.values().length;

    /**
     * Try to create an implicit intent model for the given Intent alloc node and va model.  This assumes
     * that the node / va model is not an explicit intent; this has already been tested elsewhere.
     * 
     * If all fields are invalidated, then just return an UnresolvedIntent.
     */
    public static IntentModel createModelForImplicitIntent(IAllocNode node, RefVAModel intentRefVAModel) {
        ImplicitIntentModel rii = new ImplicitIntentModel(node, intentRefVAModel);

        //action
        Set<String> intentActions = new HashSet<String>();

        if (IntentUtils.v().getFieldFromImplicitIntent("mAction", RefType.v("java.lang.String"), 
            intentRefVAModel, intentActions)) {
            for (String intentAction : intentActions) {
                rii.addValue(ImplicitIntentFields.ACTION, intentAction);
            }
        } else {
            rii.invalidateField(ImplicitIntentFields.ACTION);
        }

        //categories
        Set<String> intentCategories = new HashSet<String>();
        if (IntentUtils.v().getFieldFromImplicitIntent("DSmCategories", RefType.v("java.lang.String"), 
            intentRefVAModel, intentCategories)) {
            for (String cat : intentCategories) {
                rii.addValue(ImplicitIntentFields.CATEGORY, cat);
            }
        } else {
            rii.invalidateField(ImplicitIntentFields.CATEGORY);
        }

        //type
        Set<String> intenttypes = new HashSet<String>();
        if (IntentUtils.v().getFieldFromImplicitIntent("mType", RefType.v("java.lang.String"), 
            intentRefVAModel, intenttypes)) {
            for (String type : intenttypes) {
                rii.addValue(ImplicitIntentFields.TYPE, type);
            }
        } else {
            rii.invalidateField(ImplicitIntentFields.TYPE);
        }

        //data
        Set<String> intentDatas = new HashSet<String>();
        if (IntentUtils.v().getDataFieldForIntent(intentRefVAModel, intentDatas)) {            
            for (String intentData : intentDatas) {
                try {
                    URI parsedIntentData = new URI(intentData);
                    rii.addValue(ImplicitIntentFields.DATA, intentData);
                } catch (URISyntaxException e) {
                    //some issue 
                    rii.invalidateField(ImplicitIntentFields.DATA);
                    break;
                }
            }
        } else {
            rii.invalidateField(ImplicitIntentFields.DATA);
        }

        //if all fields invalidated, then just return an unresolved intent, nothing to be gleemed
        boolean anyFieldValid = false;
        for (ImplicitIntentFields field : ImplicitIntentFields.values()) {
            if (!rii.isFieldInvalidated(field)) {
                anyFieldValid = true;
                break;
            }
        }

        if (anyFieldValid)        
            return rii;
        else 
            return UnresolvedIntent.v();
    }

    private ImplicitIntentModel(IAllocNode node, RefVAModel vaModel) {
        this.node = node;
        this.vaModel = vaModel;

        isInvalidated = new boolean[nFields];
        Arrays.fill(isInvalidated, false);

        values = (Set<String>[])new LinkedHashSet[nFields];
        for (int i = 0; i < nFields; i++) {
            values[i] = new LinkedHashSet<String>();
        }

    }

    public void addValue(ImplicitIntentFields field, String value) {
        values[field.i()].add(value);
    }

    /**
     * Get resolved values of field, use only for fields that are not invalidated.
     */
    public Set<String> getValues(ImplicitIntentFields field) {
        if (isFieldInvalidated(field)) {
            logger.error("Trying to get value of invalidated field for implicit intent: {}", node);
        }

        return values[field.i()];
    }

    /**
     * Return true if field is invalidated.
     */
    public boolean isFieldInvalidated(ImplicitIntentFields field) {
        return isInvalidated[field.i()];
    }

    /**
     * If any fields of the Intent are invalidated, return false.  Otherwise return true.
     * Just because an implicit intent is unresolved, does not mean it might not be useful 
     * for ruling out some component destinations.
     */
    public boolean isResolved() {        
        for (ImplicitIntentFields field : ImplicitIntentFields.values()) {
            if (isInvalidated[field.i()])
                return false;
        }

        return true;
    }

    /**
     * Mark field as invalidated, meaning that for some reason, the value is anything.
     */
    public void invalidateField(ImplicitIntentFields field) {
        isInvalidated[field.i()] = true;
    }

    public enum ImplicitIntentFields {
        ACTION(0), CATEGORY(1), TYPE(2), DATA(3);

        private int index;

        private ImplicitIntentFields(int i) {
            this.index = i;
        }

        public int i() {
            return index;
        }
    }

    @Override
    public String toString() {
        return "ImplicitIntentModel [isInvalidated=" + Arrays.toString(isInvalidated) + ", values="
                + Arrays.toString(values) + "]";
    }    
}
