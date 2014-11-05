package droidsafe.transforms.va;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.rcfg.RCFG;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.system.AndroidComponents;
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

    public ContentProviderTransform() {
        // init set of all content provider harness fields
        for (SootClass clz : Harness.v().getCreatedClasses()) {
            if (Hierarchy.inheritsFromAndroidComponent(AndroidComponents.CONTENT_PROVIDER, clz)) {
                allHarnessCPFlds.add(Harness.v().getFieldForCreatedClass(clz));
            }
        }        
    }

    @Override
    public void tranformsInvoke(SootMethod containingMthd, SootMethod callee,
                                InvokeExpr invokeExpr, Stmt stmt, Body body) {
        Value lvalue = null;
        if (stmt instanceof AssignStmt) {
            lvalue = ((AssignStmt)stmt).getLeftOp();
        }
        
        //for each field of harness that is a content provider
        for (SootField cpField : allHarnessCPFlds) {
            SootClass cpClass = ((RefType)cpField.getType()).getSootClass();
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
