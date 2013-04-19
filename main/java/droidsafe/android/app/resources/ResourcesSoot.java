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
		mClinitMethod.setActiveBody(mClinitBody);
	}

	/* Add a view (create new object associated with these properties) " */
	public void addTextView(String type, int numId, String strId, String text) {

		String   idName    = makeIdName(type, numId); 
		String   className = makeClassName(type);
		RefType  classType = RefType.v(className); 
		SootField sf = new SootField(idName, classType, Modifier.PUBLIC | Modifier.STATIC);
		mSootClass.addField(sf);

/*
		Chain units = mClinitBody.getUnits();
		Local arg, tmpRef;
		String localType = "local" + className; 
		arg = Jimple.v().newLocal(localType, classType);
		mClinitBody.getLocals().add(arg);
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
