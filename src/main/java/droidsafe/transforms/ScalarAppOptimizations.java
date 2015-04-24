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

package droidsafe.transforms;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Project;
import droidsafe.main.Config;
import soot.Body;
import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

public class ScalarAppOptimizations {
    private final static Logger logger = LoggerFactory.getLogger(ScalarAppOptimizations.class);

    public static void run() {
        //don't run for error handling analysis
        if (Config.v().target.equals("errorhandling")) {
            return;
        }
        
        for (SootClass clz : Scene.v().getClasses()) {
            if (Project.v().isSrcClass(clz.toString())) {
                for (SootMethod meth : clz.getMethods()) {
                    if (!meth.isConcrete())
                        continue;
                    try {
                        logger.debug("Calling Constant Prop and folding on {}", meth);
                        G.v().soot_jimple_toolkits_scalar_ConstantPropagatorAndFolder().
                        transform(meth.retrieveActiveBody());

                        logger.debug("Calling CSE on {}", meth);
                        G.v().soot_jimple_toolkits_scalar_CommonSubexpressionEliminator().
                        transform(meth.retrieveActiveBody());
                    } catch (Exception e) {
                        logger.debug("Error in ScalarAppOptimizations. Ignoring...", e);
                    }
                }
            }
        }
    }
}
