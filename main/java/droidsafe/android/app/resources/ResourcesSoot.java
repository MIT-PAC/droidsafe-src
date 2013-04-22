/*
 * This class contains soot objects that will be used in XML replacement 
 */
package droidsafe.android.app.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.speclang.ArgumentValue;
import droidsafe.speclang.Method;
import droidsafe.speclang.TypeValue;

import soot.AnySubType;
import soot.ArrayType;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.Hierarchy;
import soot.IntType;
import soot.LongType;
import soot.NullType;
import soot.PrimType;
import soot.Printer;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.Modifier;
import soot.SootField;
import soot.Scene;
import soot.Local;
import soot.RefType;
import soot.jimple.NewExpr;
import soot.jimple.Constant;
import soot.jimple.StringConstant;
import soot.jimple.IdentityStmt;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.JasminClass;
import soot.jimple.Jimple;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.JimpleBody;
import soot.tagkit.LineNumberTag;
import soot.util.Chain;
import soot.util.JasminOutputStream;


import droidsafe.utils.SootUtils;

public class ResourcesSoot {

	public class UISootObject {
		public int       numericId;
		public String    stringId;
		public String    text;
		public SootField sootField;
		public UISootObject(int numId, String strId, String text, SootField sf) {
			numericId = numId;
			stringId  = strId;
			this.text = text;
			sootField = sf;
		}
	}

  	private final static Logger logger = LoggerFactory.getLogger(ResourcesSoot.class);	

	/* Object factory */
	private static  ResourcesSoot instance = new ResourcesSoot();
	public static ResourcesSoot v() { return instance; }

	private SootClass  mSootClass;
	private SootMethod mClinitMethod;
	private JimpleBody mClinitBody;

	private ResourcesSoot() {
		mSootClass = new SootClass("ResourcesSoot", Modifier.PUBLIC);
		mSootClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
		Scene.v().addClass(mSootClass);
		mClinitMethod = new SootMethod("<clinit>", new LinkedList(), VoidType.v(), Modifier.STATIC);
		mSootClass.addMethod(mClinitMethod);

		/*
		 * adding clinit method for the class
		 */
		mClinitBody = Jimple.v().newBody(mClinitMethod);

		/* The active body to work on is mClinitBody */
		mClinitMethod.setActiveBody(mClinitBody);
	}

	/* Add a view (create new object associated with these properties) " */
	public void addTextView(String type, int numId, String strId, String text) {

		String   idName    = makeIdName(type, numId); 
		String   localIdName = "tmp" + idName;
		String   className = makeClassName(type);
		RefType  classType = RefType.v(className); 

		Chain units = mClinitBody.getUnits();

		/* Steps to add an class member instantiation:
			1. Add a field to the class
			2. Add a local variable (typed) with coresponding name
			3. Set attributes of created local variable
			4. Assign local variable to the class member
		*/
		
		// step 1: create sootfield for member variable
		SootField sf = new SootField(idName, classType, Modifier.PUBLIC | Modifier.STATIC);
		mSootClass.addField(sf);

		// step 2: create local variable
		// Button tmpBotton; 
		Local arg;
		arg = Jimple.v().newLocal(localIdName, classType);
		mClinitBody.getLocals().add(arg);

		LinkedList<Constant> list = new LinkedList();
		list.add(NullConstant.v());


		try {

			RefType btnRef = RefType.v("android.widget.Button");

			NewExpr newExpr = Jimple.v().newNewExpr(btnRef);

			units.add(Jimple.v().newAssignStmt(
					 arg, newExpr));

			if (newExpr == null) {
				logger.warn("newExpr is NULL ");
			}
			// button constructor method
			SootMethod btnInitMethod = Scene.v().getMethod("<android.widget.Button: void <init>(android.content.Context)>");
			if (btnInitMethod  == null) {
				logger.warn("bntInitMethod is NULL ");
			}

			// For now we are just passing EMPTY as context
			units.add(Jimple.v().newInvokeStmt(
						Jimple.v().newVirtualInvokeExpr(arg, btnInitMethod.makeRef(), 
								list))); 
								//Collections.EMPTY_LIST ))); 

			SootMethod setTextMethod = Scene.v().getMethod("<android.widget.TextView: void setText(java.lang.CharSequence)>");

			units.add(Jimple.v().newInvokeStmt(
						Jimple.v().newVirtualInvokeExpr(arg, setTextMethod.makeRef(), 
								StringConstant.v(text)))); 
				

		}
		catch (Exception ex) {
			logger.warn(ex.toString());
		}

		// adding a new statement
		// units.add(Jimple.v().newIdentityStmt(arg, Jimple.v().newStaticFieldRef(sf.makeRef()))); 
		// step 3: instatiate 

		// step 4: assign statement: Button = tmpButton
		// units.add(Jimple.v().newAssignStmt(

		
/*
		Chain units = mClinitBody.getUnits();
		Local arg, tmpRef;
		String localType = "local" + className; 
*/
	}

	public String makeIdName(String type, int numId) {
		StringBuilder builder = new StringBuilder(type);
		builder.append("_").append(numId);
		return builder.toString();
	}

	public String makeClassName(String clsName) {
		StringBuilder builder = new StringBuilder("android.widget");
		return builder.append(".").append(clsName).toString();
	}

	public SootField getFieldByNumericId(int numId) {
		return null;
	}

	public void writeFile(String dir)  {
		String filePath = dir + File.separator + mSootClass.toString();
		SootUtils.writeByteCodeAndJimple(filePath, mSootClass);
	}
}
