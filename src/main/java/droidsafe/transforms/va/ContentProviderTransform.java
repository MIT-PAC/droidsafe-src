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

package droidsafe.transforms.va;

import java.net.URI;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.app.Project;
import droidsafe.android.app.resources.AndroidManifest.Provider;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.system.AndroidComponents;
import droidsafe.reports.AnalysisReport;
import droidsafe.reports.UnresolvedICC;
import droidsafe.stats.IntentResolutionStats;
import soot.Body;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.toolkits.pta.IAllocNode;

/**
 * Value analysis to conservatively model the common usage of a content provider.
 * 
 * Calls to getContentResolver().<action>(args)
 * trigger the insertion of calls to <action>(args) on all ContentProvider fields
 * in the harness for ContentProvider objects defined in the manifest.
 * 
 * <action> = insert, update, delete, query 
 * 
 * Each ContentProvider field will be 
 * 
 * @author mgordon
 *
 */
public class ContentProviderTransform implements VATransform {
    public static int localID = 0;
    /** logger field */
    private final Logger logger = LoggerFactory.getLogger(ContentProviderTransform.class);
    /** signatures of methods to transform */
    private Set<String> sigsOfInvokesToTransform;
    /** All fields of harness for content providers */
    private Set<SootField> allHarnessCPFlds = new LinkedHashSet<SootField>();
    private Set<Stmt> modified = new HashSet<Stmt>();

    public ContentProviderTransform() {
        // init set of all content provider harness fields
        for (SootClass clz : Harness.v().getCreatedClasses()) {
            if (Hierarchy.inheritsFromAndroidComponent(AndroidComponents.CONTENT_PROVIDER, clz)) {
                allHarnessCPFlds.add(Harness.v().getFieldForCreatedClass(clz));
            }
        }        
    }

    /**
     * For a Uri alloc node, try to find the set of target content providers targeted by the 
     * resolved va values for the uri.  If invalidated or unresolved, then target all providers.
     */
    private boolean addToTargets(IAllocNode node, Set<SootField> targetCPFields, Stmt stmt) {
        try {
            Set<String> uriValues = new HashSet<String>(); 

            SootField field = ((RefType)node.getType()).getSootClass().getFieldByName("uriString");

            boolean isResolved = ValueAnalysis.v().getStringFieldValues(node, field, uriValues);

            if (isResolved) {
                for (String uriString : uriValues) {                    
                    URI uri = new URI(uriString); 
                    String authority = uri.getAuthority();
                    
                    for (Provider p : Resources.v().getManifest().providers) {
                        if (p.definesAuthority(authority)) {
                            //this provider is a target for the uri, 
                            //so find the field for it
                            
                            SootClass pClass = p.getSootClass();
                            targetCPFields.add(Harness.v().getFieldForCreatedClass(pClass));
                            logger.info("Found target for Content Provider stmt {}, uri {}, target {}", stmt, uriString, pClass);
                        }
                    }
                }
                return true;
            } else {
            	AnalysisReport.v().addEntry("Unresolved Uri used on ICC call for ContentProvider.", 
            			stmt, AnalysisReport.Level.ELEVATED);
                targetCPFields.addAll(allHarnessCPFlds);
                return false;
            }    
        } catch (Exception e) {
            //just in case anything goes wrong with va resolution
            targetCPFields.addAll(allHarnessCPFlds);
            AnalysisReport.v().addEntry("Unresolved Uri used on ICC call for ContentProvider.", 
        			stmt, AnalysisReport.Level.ELEVATED);
            return false;
        }
    }

    @Override
    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee,
                                InvokeExpr invokeExpr, Stmt stmt, Body body) {
        
        if(!Project.v().isSrcClass(containingMthd.getDeclaringClass())){
            return;
        }

        if (modified.contains(stmt)) {
            return;
        }
        modified.add(stmt);

        IntentResolutionStats.v().contentProviderOps++;
        
        Value lvalue = null;
        if (stmt instanceof AssignStmt) {
            lvalue = ((AssignStmt)stmt).getLeftOp();
        }

        Set<SootField> targetCPFields = new LinkedHashSet<SootField>();

        boolean resolved = true;
        
        for (IAllocNode node : PTABridge.v().getPTSetIns(invokeExpr.getArg(0))) {
            resolved = addToTargets(node, targetCPFields, stmt);

            if (!resolved) {
                UnresolvedICC.v().addInfo(stmt, callee, "Unresolved URI for Content Provider");
                //can break here because we added all possible content provider destinations
                AnalysisReport.v().addEntry("Unresolved Uri used on ICC call for ContentProvider.", 
            			stmt, AnalysisReport.Level.ELEVATED);
                IntentResolutionStats.v().contentProviderOpsUnresolvedUri++;
                break;
            }
        }
               

        //for each field of harness that is a content provider
        for (SootField cpField : targetCPFields) {
        	SootClass cpClass = ((RefType)cpField.getType()).getSootClass();
        	//the content provide may not declare all methods 
        	if (!cpClass.declaresMethod(callee.getSubSignature()))
        		continue;

        	SootMethod target = cpClass.getMethod(callee.getSubSignature());

        	//create local and add to body
        	Local local = Jimple.v().newLocal("_$contentprovider_local_" + localID++, cpField.getType());
        	body.getLocals().add(local);

        	//set field of cp to local [local = harness.contentproviderfield]
        	//set local to field
        	Stmt localAssign = Jimple.v().newAssignStmt
        			(local, Jimple.v().newStaticFieldRef(cpField.makeRef()));
        	//insert before original statement
        	body.getUnits().insertBefore(localAssign, stmt);

        	InvokeExpr newInvoke = Jimple.v().newVirtualInvokeExpr(local, target.makeRef(), invokeExpr.getArgs());

        	//create statement to invoke
        	Stmt toInsert = null; 
        	if (lvalue == null) {
        		//original call not in an assign;
        		toInsert = Jimple.v().newInvokeStmt(newInvoke);
        	} else {    
        		//original call in an assign
        		toInsert = Jimple.v().newAssignStmt(lvalue, newInvoke);
        	}
        	//insert after original statement just to have all locals assigned in a block
        	body.getUnits().insertAfter(toInsert, stmt);
        	logger.info("Adding {} call to ContentProvider {} in method {}", 
        			callee.getSubSignature(), cpClass, containingMthd);

        	//ignore generated calls in rcfg
        	RCFG.v().ignoreInvokeForOutputEvents(toInsert);
        }
        
        //if resolved and in app target, then don't report
        if (resolved) {
            IntentResolutionStats.v().contentProviderOpsResolvedUri++;
            if (targetCPFields.size() > 0) {           
                RCFG.v().ignoreInvokeForOutputEvents(stmt);       
                IntentResolutionStats.v().contentProviderOpsInAppTotalTargets += targetCPFields.size();
            } else {
                IntentResolutionStats.v().contentProviderOpsInterAppTarget++;
            }
        }
        
        
	}

    @Override
    public Set<String> sigsOfInvokesToTransform() {
        if (sigsOfInvokesToTransform == null) {
            sigsOfInvokesToTransform = new HashSet<String>();
            sigsOfInvokesToTransform.add("<android.content.ContentResolver: int delete(android.net.Uri,java.lang.String,java.lang.String[])>");
            sigsOfInvokesToTransform.add("<android.content.ContentResolver: int update(android.net.Uri,android.content.ContentValues,java.lang.String,java.lang.String[])>");
            sigsOfInvokesToTransform.add("<android.content.ContentResolver: android.database.Cursor query(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String)>");
            sigsOfInvokesToTransform.add("<android.content.ContentResolver: android.net.Uri insert(android.net.Uri,android.content.ContentValues)>");
        }

        // TODO Auto-generated method stub
        return sigsOfInvokesToTransform;
    }

}
