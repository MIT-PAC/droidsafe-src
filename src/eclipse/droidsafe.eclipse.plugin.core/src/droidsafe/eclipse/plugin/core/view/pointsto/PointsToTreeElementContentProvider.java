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

package droidsafe.eclipse.plugin.core.view.pointsto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.MethodInfoTreeElementContentProvider;
import droidsafe.speclang.model.AllocLocationModel;
import droidsafe.speclang.model.CallLocationModel;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;

/**
 * Content provider for the tree structure of the points-to outline view.
 * 
 * @author Limei Gilham (gilham@kestrel.edu)
 * 
 */
public class PointsToTreeElementContentProvider extends MethodInfoTreeElementContentProvider {

    /**
     * Populate the tree elements of the points-to outline view. Return the root elements.
     */
    protected Object[] initializeRoots() {
        MethodModel method = (MethodModel) fInput;
        if (!method.hasPointsToInfo())
            return NO_CHILDREN;
        List<MethodArgumentModel> methodArgs = new ArrayList<MethodArgumentModel>();
        for (int i = -1; i < method.getMethodArguments().size(); i++) {
            if (method.getArgumentAllocSources(i) != null)
                methodArgs.add(method.getArgumentModel(i));
        }
        Object[] roots = new Object[methodArgs.size()];
        for (int i = 0; i < methodArgs.size(); i++) {
            MethodArgumentModel methodArg = methodArgs.get(i);
            TreeElement<MethodArgumentModel, AllocLocationModel> root =
                    new TreeElement<MethodArgumentModel, AllocLocationModel>(methodArg.toString(),
                            methodArg, AllocLocationModel.class);
            roots[i] = root;
            List<AllocLocationModel> locs = methodArg.getAllocSources();
            for (AllocLocationModel loc : locs) {
                TreeElement<AllocLocationModel, CallLocationModel> locTreeElement =
                        new TreeElement<AllocLocationModel, CallLocationModel>(loc.toString(), loc, CallLocationModel.class);
                for (CallLocationModel call: loc.getCallsOnAlloc()) {
                    TreeElement<CallLocationModel, Object> callTreeElement =
                            new TreeElement<CallLocationModel, Object>(call.toString(), call, Object.class);
                    locTreeElement.addChild(callTreeElement);
                }
                root.addChild(locTreeElement);
            }
        }
        return roots;
    }

}
