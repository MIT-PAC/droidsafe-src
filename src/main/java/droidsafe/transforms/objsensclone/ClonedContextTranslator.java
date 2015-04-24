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

package droidsafe.transforms.objsensclone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.SootMethod;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AnyNewExpr;
import soot.jimple.ClassConstant;
import soot.jimple.StringConstant;
import droidsafe.main.Config;

public class ClonedContextTranslator {
    /** logger object */
    private static final Logger logger = LoggerFactory.getLogger(ClonedContextTranslator.class);

    private Map<Value, Value> newExprMap;

    public ClonedContextTranslator() {
        newExprMap = new HashMap<Value, Value>();
        createNewExprMap();
    }

    //all reachable

    /**
     * Create a map of values from the original method, to the corresponding values in all
     * the context clones (including the original method if it is still reachable).
     *
     */
    public Map<Value, Set<Value>> getValueMap(SootMethod orig, boolean origReachable) {

        Map<Value, Set<Value>> valueMap = new HashMap<Value, Set<Value>>();
        Set<SootMethod> clones = ObjectSensitivityCloner.v().getClonedContextMethods(orig);

        List<ValueBox> origVBs = null;

        try {
        	origVBs = orig.retrieveActiveBody().getUseAndDefBoxes();
        }
        catch (Exception ex) {
        	return valueMap;
        }

        List<ValueBox>[] cloneVBs = new List[clones.size()];

        int i = 0;
        for (SootMethod clone : clones) {
        	try {
        		cloneVBs[i] = clone.retrieveActiveBody().getUseAndDefBoxes();
        	}
        	catch (Exception ex) {
        		logger.info("Exception retrieving method body {}", ex);
        		continue;
        	}

            if (cloneVBs[i].size() != origVBs.size()) {
                logger.error("Clone and orig have def / use boxes that do not correspond! {} {}", clone, orig);
                droidsafe.main.Main.exit(1);
            }
            i++;
        }

        for (i = 0; i < origVBs.size(); i++) {
            valueMap.put(origVBs.get(i).getValue(), new HashSet<Value>());
            //add the value from the original if it is reachable
            if (origReachable)
                valueMap.get(origVBs.get(i).getValue()).add(origVBs.get(i).getValue());
            //add the values from all the clones!
            for (int c = 0; c < cloneVBs.length; c++) {
                valueMap.get(origVBs.get(i).getValue()).add(cloneVBs[c].get(i).getValue());
            }
            
        }
        return valueMap;
    }

    private void createNewExprMap() {
        for (SootMethod orig : ObjectSensitivityCloner.v().getMethodsThatWereCloned()) {

            Set<SootMethod> clones = ObjectSensitivityCloner.v().getClonedContextMethods(orig);
            Body activeBody = null;
            try {
            	activeBody = orig.retrieveActiveBody();
            }
            catch (Exception ex) {
            	logger.info("Exception retrieving method body {}", ex);
            	continue;
            }

            List<ValueBox> origVBs = activeBody.getUseAndDefBoxes();

            List<ValueBox>[] cloneVBs = new List[clones.size()];

            int i = 0;
            for (SootMethod clone : clones) {
                cloneVBs[i] = clone.retrieveActiveBody().getUseAndDefBoxes();
                if (cloneVBs[i].size() != origVBs.size()) {
                    logger.error("Clone and orig have def / use boxes that do not correspond! {} {}", clone, orig);
                    droidsafe.main.Main.exit(1);
                }
                i++;
            }

            for (i = 0; i < origVBs.size(); i++) {
                for (int c = 0; c < cloneVBs.length; c++) {
                    if (!(cloneVBs[c].get(i).getValue().getClass().equals(origVBs.get(i).getValue().getClass()))) {
                        logger.error("Clone and orig have def / use boxes that do not correspond! {} {}", 
                            cloneVBs[c].get(i).getValue(),
                            origVBs.get(i).getValue().getClass());
                        droidsafe.main.Main.exit(1);
                    }

                    if (origVBs.get(i).getValue() instanceof AnyNewExpr ||
                            origVBs.get(i).getValue() instanceof StringConstant ||
                            origVBs.get(i).getValue() instanceof ClassConstant ) {
                        newExprMap.put(cloneVBs[c].get(i).getValue(),origVBs.get(i).getValue());
                    }

                }
            }
        }
    }

    /**
     * This can be a NewExpr, ClassConstant, or StringConstant
     * 
     * @param value
     * @return
     */
    public boolean isClonedNewExpr(Value value) {
        return newExprMap.containsKey(value); 
    }

    /**
     * This can be a NewExpr, ClassConstant, or StringConstant
     * 
     */
    public Value getOrigNewExpr(Value newExpr) {
        if (!newExprMap.containsKey(newExpr)) {
            logger.error("Not a cloned new expr: {}", newExpr);
            droidsafe.main.Main.exit(1);
        }

        return newExprMap.get(newExpr);
    }

    //pta query


}
