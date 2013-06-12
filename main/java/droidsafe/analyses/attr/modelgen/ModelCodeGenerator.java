package droidsafe.analyses.attr.modelgen;

import japa.parser.ASTHelper;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.BooleanLiteralExpr;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.IntegerLiteralExpr;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.NullLiteralExpr;
import japa.parser.ast.expr.ObjectCreationExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExplicitConstructorInvocationStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.type.PrimitiveType;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.Type;
import japa.parser.ast.type.VoidType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.options.Options;
import droidsafe.analyses.attr.AttrModeledClass;
import droidsafe.main.Config;

public class ModelCodeGenerator {

    public static final String MODEL_PACKAGE = "droidsafe.analyses.attr.models";
    public static final String MODEL_PACKAGE_PREFIX = MODEL_PACKAGE + ".";
    
    public static final ReferenceType SET_OF_STRING_TYPE = makeGenericReferenceType("Set", "String");
    
    public static final ReferenceType SET_OF_BOOLEAN_TYPE = makeGenericReferenceType("Set", "Boolean");
    
    public static final ReferenceType SET_OF_CHARACTER_TYPE = makeGenericReferenceType("Set", "Character");
    
    public static final ReferenceType SET_OF_BYTE_TYPE = makeGenericReferenceType("Set", "Byte");
    
    public static final ReferenceType SET_OF_SHORT_TYPE = makeGenericReferenceType("Set", "Short");
    
    public static final ReferenceType SET_OF_INTEGER_TYPE = makeGenericReferenceType("Set", "Integer");
    
    public static final ReferenceType SET_OF_LONG_TYPE = makeGenericReferenceType("Set", "Long");
    
    public static final ReferenceType SET_OF_DOUBLE_TYPE = makeGenericReferenceType("Set", "Double");
    
    public static final ReferenceType SET_OF_FLOAT_TYPE = makeGenericReferenceType("Set", "Float");
    
    public static final Expression SET_OF_STRING_INIT = makeGenericObjectCreationExpr("AttrModelingSet", "String");
    
    public static final Expression SET_OF_BOOLEAN_INIT = makeGenericObjectCreationExpr("AttrModelingSet", "Boolean");
    
    public static final Expression SET_OF_CHARACTER_INIT = makeGenericObjectCreationExpr("AttrModelingSet", "Character");
    
    public static final Expression SET_OF_BYTE_INIT = makeGenericObjectCreationExpr("AttrModelingSet", "Byte");
    
    public static final Expression SET_OF_SHORT_INIT = makeGenericObjectCreationExpr("AttrModelingSet", "Short");
    
    public static final Expression SET_OF_INTEGER_INIT = makeGenericObjectCreationExpr("AttrModelingSet", "Integer");
    
    public static final Expression SET_OF_LONG_INIT = makeGenericObjectCreationExpr("AttrModelingSet", "Long");
    
    public static final Expression SET_OF_DOUBLE_INIT = makeGenericObjectCreationExpr("AttrModelingSet", "Double");
    
    public static final Expression SET_OF_FLOAT_INIT = makeGenericObjectCreationExpr("AttrModelingSet", "Float");
    
    private static final Logger logger = LoggerFactory.getLogger(ModelCodeGenerator.class);

    private static final Expression NULL = new NullLiteralExpr();

    private static final Expression ZERO = new IntegerLiteralExpr("0");

    private static final Expression FALSE = new BooleanLiteralExpr(false);

    private static Set<String> modeledClassNames;

    private String className;

    private String sourcePath;

    private Set<String> fieldNames;

    private String unqualifiedClassName;

    private String packageName;
    
    private Set<String> imports = new TreeSet<String>();

    private SootClass sootClass;

    private String apacHome;

    private File androidImplJar;
    
    private Set<String> importsProcessed = new HashSet<String>();

    public ModelCodeGenerator(String sourcePath, String className, Set<String> fieldNames) {
        this.className = className;
        this.sourcePath = sourcePath;
        this.fieldNames = fieldNames;
        this.packageName = getQualifier(className);
        this.unqualifiedClassName = getUnqualifiedName(className);
        this.imports.add("soot.jimple.spark.pag.AllocNode");
        this.imports.add("droidsafe.analyses.attr.AttrModeledClass");
        this.imports.add("droidsafe.analyses.attr.AttrModelingSet");
        this.apacHome = System.getenv("APAC_HOME");
        logger.debug("APAC_HOME = {}", apacHome);
        if (this.apacHome == null) {
          logger.error("Environment variable $APAC_HOME not set!");
          System.exit(1);
        }
        androidImplJar = new File(constructPath(this.apacHome, Config.ANDROID_LIB_DIR_REL, "android-impl.jar"));
   }

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            logger.error("Usage: ModelCodeGen <source path> <class name> <field1 name> <field2 name> ...");
            System.exit(1);
        } else {
            Reflections reflections = new Reflections(MODEL_PACKAGE);
            Set<Class<? extends AttrModeledClass>> modeledClasses = 
                    reflections.getSubTypesOf(AttrModeledClass.class);
            modeledClassNames = new HashSet<String>();
            for (Class<? extends AttrModeledClass> modeledClass: modeledClasses)
                modeledClassNames.add(modeledClass.getName());
            String sourcePath = args[0];
            String className = args[1];
            Set<String> fieldNames = new HashSet<String>();
            for (int i = 2; i < args.length; i++) {
                fieldNames.add(args[i]);
            }
            ModelCodeGenerator modelGen = new ModelCodeGenerator(sourcePath, className, fieldNames);
            modelGen.loadSootClass();
            modelGen.generate();
            logger.info("Done.");
        }
    }

    private void loadSootClass() {
        logger.info("Loadinging Soot class " + className + "...");
        String[] args = {className};
        Options.v().parse(args);
        soot.options.Options.v().set_keep_line_number(true);
        soot.options.Options.v().set_whole_program(true);
        // allow for the absence of some classes
        soot.options.Options.v().set_allow_phantom_refs(true);
        // set soot classpath to android-impl.jar
        if (!androidImplJar.exists()) {
            logger.error("android-impl.jar does not exist");
            System.exit(1);
        }
        String cp = androidImplJar.getPath();
        soot.options.Options.v().set_soot_classpath(cp);
        System.setProperty("soot.class.path", cp);
        Scene.v().loadNecessaryClasses();
        sootClass = Scene.v().getSootClass(className);
        // If no field is specified in the command arguments, model all the fields.
//        if (fieldNames.isEmpty()) {
//            for (SootField field: sootClass.getFields())
//                fieldNames.add(field.getName());
//        }
    }

    private void generate() {
        CompilationUnit cu = parseJavaSource();
        CompilationUnit model = generateModel(cu);
        writeModel(model);
    }

    private CompilationUnit generateModel(CompilationUnit cu) {
        logger.info("Generating model...");
        CompilationUnit model = new CompilationUnit();

        String modelPackageName = MODEL_PACKAGE_PREFIX + packageName;
        PackageDeclaration modelPkg = new PackageDeclaration(new NameExpr(modelPackageName));
        model.setPackage(modelPkg);

        List<TypeDeclaration> types = cu.getTypes();
        for (TypeDeclaration type : types) {
            if (type instanceof ClassOrInterfaceDeclaration) {
                generateClassOrInterface(model, (ClassOrInterfaceDeclaration)type);
            }
        }
        List<ImportDeclaration> importDecls = new ArrayList<ImportDeclaration>();
        for (String imp: imports) {
            importDecls.add(new ImportDeclaration(new NameExpr(imp), false, false));
        }
        model.setImports(importDecls);
        return model;
    }

    private void generateClassOrInterface(CompilationUnit model, ClassOrInterfaceDeclaration coi) {
        int modifiers = coi.getModifiers();
        boolean isInterface = coi.isInterface();
        String name = coi.getName();
        ClassOrInterfaceDeclaration modelCoi = new ClassOrInterfaceDeclaration(modifiers, isInterface, name);
        List<ClassOrInterfaceType> extendsList = new ArrayList<ClassOrInterfaceType>();
        extendsList.add(new ClassOrInterfaceType("AttrModeledClass"));
        modelCoi.setExtends(extendsList);
        ASTHelper.addTypeDeclaration(model, modelCoi);
        List<BodyDeclaration> members = coi.getMembers();
        for (BodyDeclaration member : members) {
            if (member instanceof FieldDeclaration) {
                FieldDeclaration field = (FieldDeclaration) member;
                generateFields(modelCoi, field);                
            }
        }
        generateConstructor(modelCoi);
        for (BodyDeclaration member : members) {
            if (member instanceof ConstructorDeclaration) {
                ConstructorDeclaration constr = (ConstructorDeclaration) member;
                generateInitMethod(modelCoi, constr);
            }
        }
        for (BodyDeclaration member : members) {
            if (member instanceof MethodDeclaration) {
                MethodDeclaration method = (MethodDeclaration) member;
                SootMethod sootMethod = getSootMethod(method.getName(), method.getParameters());
                convertMethod(modelCoi, method, sootMethod);
            }
        }
    }

    private void generateFields(ClassOrInterfaceDeclaration modelCoi, FieldDeclaration field) {
        List<VariableDeclarator> vars = field.getVariables();
        List<VariableDeclarator> modelVars = new ArrayList<VariableDeclarator>();
        for (VariableDeclarator var: vars) {
            if (fieldNames.contains(var.getId().getName()))
                 modelVars.add(var);   
        }
        if (!modelVars.isEmpty()) {
            SootField sootField = sootClass.getFieldByName(modelVars.get(0).getId().getName());
            int modifiers = field.getModifiers();
            Type type = field.getType();
            soot.Type sootType = sootField.getType();
            Type modelType = convertType(type, sootType, true);
            convertInit(modelVars, modelType);
            FieldDeclaration modelField = new FieldDeclaration(modifiers, modelType, modelVars);
            modelField.setJavaDoc(field.getJavaDoc());
            ASTHelper.addMember(modelCoi, modelField);
        }
    }

    private void convertInit(List<VariableDeclarator> modelVars, Type modelType) {
        Expression init = initForSetOfValues(modelType);
        if (init != null)
            for (VariableDeclarator modelVar: modelVars)
                modelVar.setInit(init);
    }

    private Expression initForSetOfValues(Type modelType) {
        if (modelType == SET_OF_STRING_TYPE)
            return SET_OF_STRING_INIT;
        if (modelType == SET_OF_BOOLEAN_TYPE)
            return SET_OF_BOOLEAN_INIT;
        if (modelType == SET_OF_CHARACTER_TYPE)
            return SET_OF_CHARACTER_INIT;
        if (modelType == SET_OF_BYTE_TYPE)
            return SET_OF_BYTE_INIT;
        if (modelType == SET_OF_SHORT_TYPE)
            return SET_OF_SHORT_INIT;
        if (modelType == SET_OF_INTEGER_TYPE)
            return SET_OF_INTEGER_INIT;
        if (modelType == SET_OF_LONG_TYPE)
            return SET_OF_LONG_INIT;
        if (modelType == SET_OF_FLOAT_TYPE)
            return SET_OF_FLOAT_INIT;
        if (modelType == SET_OF_DOUBLE_TYPE)
            return SET_OF_DOUBLE_INIT;
        return null;
    }

    private Type convertType(Type type, soot.Type sootType, boolean isFieldType) {
        if (type instanceof ReferenceType) {
            ReferenceType refType = (ReferenceType) type;
            if (refType.getArrayCount() == 0 && refType.getType() instanceof ClassOrInterfaceType) {
                String name = ((ClassOrInterfaceType) refType.getType()).getName();
                if (name.equals("String"))
                    return SET_OF_STRING_TYPE;
                collectImports(sootType, isFieldType);
           }
            return type;
        }
        if (type instanceof PrimitiveType) {
            PrimitiveType primType = (PrimitiveType) type;
            switch (primType.getType()) {
                case Boolean: return SET_OF_BOOLEAN_TYPE;
                case Char: return SET_OF_CHARACTER_TYPE;
                case Byte: return SET_OF_BYTE_TYPE;
                case Short: return SET_OF_SHORT_TYPE;
                case Int: return SET_OF_INTEGER_TYPE;
                case Long: return SET_OF_LONG_TYPE;
                case Float: return SET_OF_FLOAT_TYPE;
                case Double: return SET_OF_DOUBLE_TYPE;
            }
        }
        return type;
    }

    private void collectImports(List<SootClass> sootClasses) {
        for (SootClass sootClass: sootClasses)
            collectImports(sootClass.getName(), false);
    }

    private void collectImports(soot.Type sootType, boolean isFieldType) {
        if (sootType instanceof ArrayType) {
            collectImports(((ArrayType)sootType).baseType, isFieldType);
        } else if (sootType instanceof RefType) {
            String clsName = ((RefType)sootType).getClassName();
            collectImports(clsName, isFieldType);
        }
    }

    private void collectImports(String clsName, boolean isFieldType) {
        if (!importsProcessed.contains(clsName)) {
            String modeledClsName = MODEL_PACKAGE_PREFIX + clsName;
            if (modeledClassNames.contains(modeledClsName) ||
                    (isFieldType && clsName.startsWith("android."))) {
                imports.add(modeledClsName);
            } else if (!getQualifier(clsName).equals("java.lang"))
                imports.add(clsName);
            importsProcessed.add(clsName);
        }
    }
    private void generateConstructor(ClassOrInterfaceDeclaration modelCoi) {
        ConstructorDeclaration modelConstr = new ConstructorDeclaration(ModifierSet.PUBLIC, unqualifiedClassName);
        Parameter parameter = ASTHelper.createParameter(makeReferenceType("AllocNode"), "allocNode");
        modelConstr.setParameters(makeParameterList(parameter));
        Statement stmt = new ExplicitConstructorInvocationStmt(false, null, makeExprList(new NameExpr("allocNode")));
        modelConstr.setBlock(makeBlockStmt(stmt));
        ASTHelper.addMember(modelCoi, modelConstr);
    }

    private void generateInitMethod(ClassOrInterfaceDeclaration modelCoi,
                                    ConstructorDeclaration constr) {
        List<Parameter> params = constr.getParameters();
        MethodDeclaration method = new MethodDeclaration(constr.getModifiers(), ASTHelper.VOID_TYPE, "_init_", params);
        method.setJavaDoc(constr.getJavaDoc());
        method.setThrows(constr.getThrows());
        method.setBody(constr.getBlock());
        SootMethod sootMethod = getSootMethod("<init>", params);
        convertMethod(modelCoi, method, sootMethod);                       
    }

    private SootMethod getSootMethod(String name, List<Parameter> parameters) {
        SootMethod sootMethod = null;
        try {
            sootMethod = sootClass.getMethodByName(name);
        } catch (RuntimeException e) {
            int paramCount = (parameters == null) ? 0 : parameters.size();
            for (SootMethod m: sootClass.getMethods()) {
                if (m.getName().equals(name)) {
                    boolean match = true;
                    if (m.getParameterCount() == paramCount) {
                        for (int i = 0; i < paramCount; i++) {
                            Type type = parameters.get(i).getType();
                            soot.Type sootType = m.getParameterType(i);
                            if (!typeMatch(type, sootType)) {
                                match = false;
                                break;
                            }
                        }
                        if (match)
                            sootMethod = m;
                    }
                }
            }
            if (sootMethod == null) {
                StringBuffer sb = new StringBuffer(name);
                sb.append('(');
                for (int i = 0; i < paramCount; i++) {
                    if (i > 0)
                        sb.append(",");
                    sb.append(parameters.get(i));
                }
                sb.append(')');
                logger.error("Failed to find soot method " + sb);
                System.exit(1);
            }
       }
        return sootMethod;
    }

    private boolean typeMatch(Type type, soot.Type sootType) {
        if (type instanceof ReferenceType) {
            ReferenceType refType = (ReferenceType) type;
            int dim = refType.getArrayCount();
            Type baseType = refType.getType();
            if (sootType instanceof ArrayType) {
                ArrayType arrType = (ArrayType) sootType;
                return (dim == arrType.numDimensions && 
                        typeMatch(baseType, arrType.baseType));
            } else
                return dim == 0 && typeMatch(baseType, sootType);
        } else if (type instanceof ClassOrInterfaceType) {
            ClassOrInterfaceType coiType = (ClassOrInterfaceType) type;
            if (sootType instanceof RefType) {
                RefType sootRefType = (RefType) sootType;
                String clsName = coiType.getName();
                String sootClsName = sootRefType.getClassName();
                if (clsName.contains("."))
                    return clsName.equals(sootClsName);
                else
                    return clsName.equals(getUnqualifiedName(sootClsName));
            } else
                return false;
        } else
            return type.toString().equals(sootType.toString());
    }

    private void convertMethod(ClassOrInterfaceDeclaration modelCoi, MethodDeclaration method, SootMethod sootMethod) {
        collectImports(sootMethod.getExceptions());
        collectImports(sootMethod.getReturnType(), false);
        List<Parameter> params = method.getParameters();
        if (params != null)
            for (int i = 0; i < params.size(); i++) {
                Parameter param = params.get(i);
                Type type = param.getType();
                soot.Type sootType = sootMethod.getParameterType(i);
                Type newType = convertType(type, sootType, false);
                param.setType(newType);
            }
        List<Statement> oldStmts = method.getBody().getStmts();
        List<Statement> newStmts = new ArrayList<Statement>();
        Type returnType = method.getType();
        if (!sootMethod.isStatic()) {
            Statement invalidateStmt = new ExpressionStmt(new MethodCallExpr(null, "invalidate"));
            newStmts.add(invalidateStmt);
        }
        if (!(returnType instanceof VoidType)) {
            Expression returnExpr = defaultInitValue(returnType);
            Statement returnStmt = new ReturnStmt(returnExpr);
            newStmts.add(returnStmt);
        }
        BlockStmt newBody = new BlockStmt(newStmts);
        if (oldStmts != null && !oldStmts.isEmpty())
            newBody.setCommentedOutStmts(oldStmts);
        method.setBody(newBody);
        ASTHelper.addMember(modelCoi, method);
    }

    private Expression defaultInitValue(Type type) {
       if (type instanceof ReferenceType)
           return NULL;
       if (type instanceof PrimitiveType) {
           switch (((PrimitiveType) type).getType()) {
               case Boolean: return FALSE;
               default: return ZERO;
           }
       }
       return null;
    }

    private CompilationUnit parseJavaSource() {
        String javaFileName = constructPath(sourcePath, className.replace(".", File.separator)) + ".java";
        logger.info("Parsing Java source " + javaFileName + "...");
        FileInputStream in = null;
        CompilationUnit cu;
        try {
            in = new FileInputStream(javaFileName);
            cu = JavaParser.parse(in);
            return cu;
        } catch (Exception e) {
            logger.error("parseClass() failed", e);
            System.exit(1);
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("Failed to close the Java source file", e);
                    System.exit(1);
                }
        }
        return null;
    }

    private void writeModel(CompilationUnit cu) {
        String modelPackageName = MODEL_PACKAGE_PREFIX + packageName;
        File dir = new File(constructPath("generated", modelPackageName.replace(".", File.separator)));
        dir.mkdirs();
        PrintWriter out = null;
        File outFile = new File(dir, unqualifiedClassName + ".java");
        logger.info("Writing model code to " + outFile.getPath() + "...");
        try {
            out = new PrintWriter(outFile);
            out.print(cu.toString());
        } catch (FileNotFoundException e) {
            logger.error("generateCodeForModeledClass failed", e);
            System.exit(1);
        } finally {
            if (out != null)
                out.close();
        }
    }

    private static ReferenceType makeReferenceType(String className) {
        return new ReferenceType(new ClassOrInterfaceType(className));
    }
    
    private static ReferenceType makeGenericReferenceType(String genericClassName, String ... typeArgClassNames) {
        ClassOrInterfaceType genericType = makeGenericType(genericClassName, typeArgClassNames);
        return new ReferenceType(genericType);
    }
    
    private static ClassOrInterfaceType makeGenericType(String genericClassName, String ... typeArgClassNames) {
        ClassOrInterfaceType genericType = new ClassOrInterfaceType(genericClassName);
        List<Type> typeArgs = new ArrayList<Type>();
        for (String typeArgClassName: typeArgClassNames) {
            typeArgs.add(new ClassOrInterfaceType(typeArgClassName));
        }
        genericType.setTypeArgs(typeArgs);
        return genericType;
    }
    
    private static Expression makeGenericObjectCreationExpr(String genericClassName, String ... typeArgClassNames) {
        ClassOrInterfaceType genericType = makeGenericType(genericClassName, typeArgClassNames);
        return new ObjectCreationExpr(null, genericType, null);
    }

    private static List<Parameter> makeParameterList(Parameter ...parameters) {
        List<Parameter> params = new ArrayList<Parameter>();
        for (Parameter param: parameters)
            params.add(param);
        return params;
    }
    
    private static List<Expression> makeExprList(Expression ...expressions) {
        List<Expression> exprs = new ArrayList<Expression>();
        for (Expression expr: expressions)
            exprs.add(expr);
        return exprs;
    }
    
    private static BlockStmt makeBlockStmt(Statement ...statements) {
        List<Statement> stmts = new ArrayList<Statement>();
        for (Statement stmt: statements)
            stmts.add(stmt);
        BlockStmt block = new BlockStmt(stmts);
        return block;
    }

    private String getUnqualifiedName(String name) {
        int index = name.lastIndexOf('.');
        return name.substring(index + 1);
    }

    private String getQualifier(String name) {
        int index = name.lastIndexOf('.');
        return name.substring(0, index);
    }

    private String constructPath(String ...comps) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < comps.length; i++) {
            if (i > 0)
                sb.append(File.separator);
            sb.append(comps[i]);
        }
        return sb.toString();        
    }

}
