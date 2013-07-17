package droidsafe.analyses.value.modelgen;

import japa.parser.ASTHelper;
import japa.parser.JavaParser;
import japa.parser.ast.BlockComment;
import japa.parser.ast.Comment;
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
import japa.parser.ast.body.VariableDeclaratorId;
import japa.parser.ast.expr.BooleanLiteralExpr;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.FieldAccessExpr;
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
import japa.parser.ast.type.PrimitiveType.Primitive;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.Type;
import japa.parser.ast.type.VoidType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.G;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.options.Options;
import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.main.Config;

public class ModelCodeGenerator {

    public static final String MODEL_PACKAGE = "droidsafe.analyses.value.models";
    public static final String MODEL_PACKAGE_PREFIX = MODEL_PACKAGE + ".";
    
    public static final List<String> PRIMITIVE_WRAPPER_CLASS_NAMES = Arrays.asList(new String[]{"Boolean",
                                                                                                "Character",
                                                                                                "Byte",
                                                                                                "Short",
                                                                                                "Integer",
                                                                                                "Long",
                                                                                                "Float",
                                                                                                "Double"});
    public static final List<String> COLLECTION_CLASS_NAMES =
            Arrays.asList(new String[]{"BlockingDeque", "BlockingQueue", "Collection", "Deque", "List",
                                       "NavigableSet", "Queue", "Set", "SortedSet", "AbstractCollection",
                                       "AbstractList", "AbstractQueue", "AbstractSequentialList", "AbstractSet",
                                       "ArrayBlockingQueue", "ArrayDeque", "ArrayList", "AttributeList",
                                       "ConcurrentLinkedQueue", "ConcurrentSkipListSet", "CopyOnWriteArrayList",
                                       "CopyOnWriteArraySet", "DelayQueue", "EnumSet", "HashSet", "LinkedBlockingDeque",
                                       "LinkedBlockingQueue", "LinkedHashSet", "LinkedList", "PriorityBlockingQueue",
                                       "PriorityQueue", "Stack", "SynchronousQueue", "TreeSet", "Vector"});
    
    private Map<PrimitiveType.Primitive, Type> primitiveTypeConversionMap;
    
    private Map<String, Type> classTypeConversionMap;

    private static final Logger logger = LoggerFactory.getLogger(ModelCodeGenerator.class);

    private static final Expression NULL = new NullLiteralExpr();

    private static final Expression ZERO = new IntegerLiteralExpr("0");

    private static final Expression FALSE = new BooleanLiteralExpr(false);

    private static Set<String> classesAlreadyModeled;

    private static Set<String> classesCurrentlyModeled = new HashSet<String>();

    private static List<String> classesToBeModeled = new ArrayList<String>();

    private String classToModel;

    private String[] sourceDirs;

    private Set<String> fieldsToModel;

    private String unqualifiedClassName;

    private String packageName;
    
    private Set<String> imports;

    private SootClass sootClass;

    private String apacHome;

    private File androidImplJar;
    
    private Set<String> importsProcessed;
    private Map<BodyDeclaration, String> methodCodeMap;
    private int nextLine;

    public ModelCodeGenerator(String sourcePath) {
        this.sourceDirs = sourcePath.split(":");
        this.apacHome = System.getenv("APAC_HOME");
        logger.debug("APAC_HOME = {}", apacHome);
        if (this.apacHome == null) {
          logger.error("Environment variable $APAC_HOME not set!");
          droidsafe.main.Main.exit(1);
        }
        androidImplJar = constructFile(this.apacHome, Config.ANDROID_LIB_DIR_REL, "android-impl.jar");
   }

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            logger.error("Usage: ModelCodeGen <source path> <class name> <field1 name> <field2 name> ...");
            droidsafe.main.Main.exit(1);
        } else {
            Reflections reflections = new Reflections(MODEL_PACKAGE);
            Set<Class<? extends ValueAnalysisModeledObject>> modeledClasses = 
                    reflections.getSubTypesOf(ValueAnalysisModeledObject.class);
            classesAlreadyModeled = new HashSet<String>();
            for (Class<? extends ValueAnalysisModeledObject> modeledClass: modeledClasses)
                classesAlreadyModeled.add(modeledClass.getName());
            String sourcePath = args[0];
            String className = args[1];
            Set<String> fieldNames = new HashSet<String>();
            for (int i = 2; i < args.length; i++) {
                fieldNames.add(args[i]);
            }
            ModelCodeGenerator modelGen = new ModelCodeGenerator(sourcePath);
            modelGen.generate(className, fieldNames);
            while (!classesToBeModeled.isEmpty()) {
                className = classesToBeModeled.remove(0);
                fieldNames.clear();
                modelGen.generate(className, fieldNames);
            }
            logger.info("Done.");
        }
    }

    private void generate(String classToModel, Set<String> fieldsToModel) {
        this.classToModel = classToModel;
        this.fieldsToModel = fieldsToModel;
        this.packageName = getQualifier(classToModel);
        this.unqualifiedClassName = getUnqualifiedName(classToModel);
        this.imports = new TreeSet<String>();
        this.imports.add("soot.jimple.spark.pag.AllocNode");
        this.imports.add("droidsafe.analyses.value.ValueAnalysisModeledObject");
        this.imports.add("droidsafe.analyses.value.ValueAnalysisModelingSet");
        this.importsProcessed = new HashSet<String>();
        this.importsProcessed.add(classToModel);
        this.primitiveTypeConversionMap = new HashMap<PrimitiveType.Primitive, Type>();
        this.classTypeConversionMap = new HashMap<String, Type>();
        classesCurrentlyModeled.add(classToModel);
        loadSootClass();
        CompilationUnit cu;
        try {
            File javaFile = getJavaSourceFile(sourceDirs, classToModel);
            cu = parseJavaSource(javaFile);
            CompilationUnit model = generateModel(cu);
            writeModel(model);
        } catch (Exception e) {
            logger.error("Failed to generate model for " + classToModel, e);
        }
    }

    private void loadSootClass() {
        G.reset();
        logger.info("Loadinging Soot class " + classToModel + "...");
        String[] args = {classToModel};
        Options.v().parse(args);
        soot.options.Options.v().set_keep_line_number(true);
        soot.options.Options.v().set_whole_program(true);
        // allow for the absence of some classes
        soot.options.Options.v().set_allow_phantom_refs(true);
        // set soot classpath to android-impl.jar
        if (!androidImplJar.exists()) {
            logger.error("android-impl.jar does not exist");
            droidsafe.main.Main.exit(1);
        }
        String cp = androidImplJar.getPath();
        soot.options.Options.v().set_soot_classpath(cp);
        System.setProperty("soot.class.path", cp);
        Scene.v().loadNecessaryClasses();
        sootClass = Scene.v().getSootClass(classToModel);
        // If no field is specified in the command arguments, model all the non-constant fields.
        if (fieldsToModel.isEmpty()) {
            for (SootField field: sootClass.getFields()) {
                if (!field.isStatic() || !field.isFinal())
                fieldsToModel.add(field.getName());
            }
        }
        // TODO: set up soot so we can deduce subtypes of java.util.Collection
        // Scene.v().loadClass("java.util.Collection", SootClass.SIGNATURES);
        // hierarchy = new Hierarchy();
    }

    private CompilationUnit parseJavaSource(File javaFile) throws Exception {
        logger.info("Parsing Java source " + javaFile + "...");
        FileInputStream in = null;
        CompilationUnit cu = null;
        in = new FileInputStream(javaFile);
        cu = JavaParser.parse(in);
        nextLine = 1;
        computeMethodCodeMap(cu, javaFile);
        return cu;
    }

    private File getJavaSourceFile(String[] dirs, String className) throws IOException {
        for (String sourceDir: sourceDirs) {
            File javaFile = getJavaSourceFile(sourceDir, className);
            if (javaFile != null)
                return javaFile;
        }
        throw new IOException("Failed to find Java source file for " + className);

    }
    
    private File getJavaSourceFile(String sourceDir, String className) {
        File javaFile = constructFile(sourceDir, className.replace(".", File.separator) + ".java");
        return (javaFile.exists()) ? javaFile : null;
    }
    
    private void computeMethodCodeMap(CompilationUnit cu, File javaFile) throws IOException {
        methodCodeMap = new HashMap<BodyDeclaration, String>();
        BufferedReader reader = null;
        List<TypeDeclaration> types = cu.getTypes();
        reader = new BufferedReader(new FileReader(javaFile));
        nextLine = 1;
        for (TypeDeclaration type : types) {
            if (type instanceof ClassOrInterfaceDeclaration) {
                for (BodyDeclaration member: ((ClassOrInterfaceDeclaration)type).getMembers()) {
                    if (member instanceof ConstructorDeclaration) {
                        String code = getMethodCode(reader, ((ConstructorDeclaration) member).getBlock());
                        methodCodeMap.put(member, code);
                    }
                    if (member instanceof MethodDeclaration) {
                        BlockStmt body = ((MethodDeclaration) member).getBody();
                        if (body != null) {
                            String code = getMethodCode(reader, body);
                            methodCodeMap.put(member, code);
                        }
                    }
                }
            }
        }
        if (reader != null) 
            reader.close();
    }
    
    private String getMethodCode(BufferedReader reader, BlockStmt block) throws IOException {
        List<Statement> stmts = block.getStmts();
        if (stmts == null || stmts.isEmpty())
            return "";
        Statement firstStmt = stmts.get(0);
        Statement lastStmt = stmts.get(stmts.size() - 1);
        Comment leadingComment = firstStmt.getComment();
        int beginLine = (leadingComment != null) ? leadingComment.getBeginLine() : firstStmt.getBeginLine();
        int beginColumn = firstStmt.getBeginColumn();
        int endLine = lastStmt.getEndLine();
        return getMethodCode(reader, beginLine, beginColumn, endLine);
    }

    private String getMethodCode(BufferedReader reader, int beginLine, int beginColumn, int endLine) throws IOException {
        StringBuffer buf = new StringBuffer("\n");
        while (nextLine < beginLine)
            readLine(reader);
        while (nextLine < endLine + 1) {
            String line = readLine(reader);
            // TODO: convert block comment to line comments
            buf.append(line);
            buf.append("\n");
        }
        for (int i = 0; i < beginColumn - 1; i++) {
            buf.append(' ');
        }
        return buf.toString();
    }

    private String readLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line != null) nextLine++;
        return line;
    }

    private CompilationUnit generateModel(CompilationUnit cu) throws Exception {
        logger.info("Generating model for " + classToModel + "...");
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

    private void generateClassOrInterface(CompilationUnit model, ClassOrInterfaceDeclaration coi) throws Exception {
        int modifiers = coi.getModifiers();
        boolean isInterface = coi.isInterface();
        String name = coi.getName();
        ClassOrInterfaceDeclaration modelCoi = new ClassOrInterfaceDeclaration(modifiers, isInterface, name);
        List<ClassOrInterfaceType> extendsList = null;
        if (!isInterface) {
            extendsList = new ArrayList<ClassOrInterfaceType>();
            extendsList.add(new ClassOrInterfaceType("ValueAnalysisModeledObject"));
        }
        modelCoi.setExtends(extendsList);
        ASTHelper.addTypeDeclaration(model, modelCoi);
        List<BodyDeclaration> members = coi.getMembers();
        for (BodyDeclaration member : members) {
            if (member instanceof FieldDeclaration) {
                FieldDeclaration field = (FieldDeclaration) member;
                generateFields(modelCoi, field);                
            }
        }
        if (!isInterface) {
            generateConstructor(modelCoi);
        }
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
                String oldCode = (sootMethod.isConcrete()) ? methodCodeMap.get(method) : null;
                method.setThrows(null);
                convertMethod(modelCoi, method, sootMethod, oldCode);
            }
        }
    }

    private void generateFields(ClassOrInterfaceDeclaration modelCoi, FieldDeclaration field) {
        List<VariableDeclarator> vars = field.getVariables();
        List<VariableDeclarator> modelVars = new ArrayList<VariableDeclarator>();
        for (VariableDeclarator var: vars) {
            if (fieldsToModel.contains(var.getId().getName()))
                 modelVars.add(var);   
        }
        if (!modelVars.isEmpty()) {
            SootField sootField = sootClass.getFieldByName(modelVars.get(0).getId().getName());
            int modifiers = makePublic(field.getModifiers());
            Type type = field.getType();
            soot.Type sootType = sootField.getType();
            Type modelType = convertType(type, sootType);
            if (modelType != type)
                convertInit(modelVars, (ReferenceType) modelType);
            FieldDeclaration modelField = new FieldDeclaration(modifiers, modelType, modelVars);
            modelField.setJavaDoc(field.getJavaDoc());
            ASTHelper.addMember(modelCoi, modelField);
        }
    }

    private void convertInit(List<VariableDeclarator> modelVars, ReferenceType modelType) {
        Expression init = initForSetOfValues(modelType);
        for (VariableDeclarator modelVar: modelVars)
            modelVar.setInit(init);
    }

    private Expression initForSetOfValues(ReferenceType modelType) {
        ClassOrInterfaceType coi = (ClassOrInterfaceType) modelType.getType();
        Type argType = coi.getTypeArgs().get(0);
        return makeModelingSetCreationExpr(argType);
    }

    private Type convertType(Type type, soot.Type sootType) {
        if (type instanceof ReferenceType) {
            ReferenceType refType = (ReferenceType) type;
            if (refType.getArrayCount() == 0 && refType.getType() instanceof ClassOrInterfaceType) {
                ClassOrInterfaceType coi = (ClassOrInterfaceType)refType.getType();
                String coiName = coi.getName();
                if (coiName.equals("String") || PRIMITIVE_WRAPPER_CLASS_NAMES.contains(coiName)) {
                    return convertStringOrPrimitiveWrapperType(coiName);
                } else if (COLLECTION_CLASS_NAMES.contains(coiName)){
                    // SootClass sootClass = ((RefType)sootType).getSootClass();
                    // if (isSubtypeOf(sootClass, Scene.v().getSootClass("java.util.Collection"))) {
                    List<Type> typeArgs = coi.getTypeArgs();
                    if (typeArgs != null && typeArgs.size() == 1) {
                        Type argType = typeArgs.get(0);
                        if (PRIMITIVE_WRAPPER_CLASS_NAMES.contains(argType.toString()))
                            imports.add(((RefType)sootType).getClassName());
                        return makeSetOfType(type);
                    }
                }
                collectImports(sootType);
            }
        } else if (type instanceof PrimitiveType) {
            PrimitiveType primType = (PrimitiveType) type;
            return convertPrimitive(primType.getType());
        }
        return type;
    }
    
    
    private Type convertStringOrPrimitiveWrapperType(String clsName) {
        Type type = classTypeConversionMap.get(clsName);
        if (type == null) {
            type = makeSetOfType(clsName);
            classTypeConversionMap.put(clsName, type);
        }
        return type;
    }

    private Type convertPrimitive(Primitive prim) {
        Type type = primitiveTypeConversionMap.get(prim);
        if (type == null) {
            imports.add("droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysis" + prim);
            type = makeSetOfType("ValueAnalysis" + prim);
            primitiveTypeConversionMap.put(prim, type);
        }
        return type;
    }

    private void collectImports(soot.Type sootType) {
        if (sootType instanceof ArrayType) {
            collectImports(((ArrayType)sootType).baseType);
        } else if (sootType instanceof RefType) {
            String clsName = ((RefType)sootType).getClassName();
            collectImports(clsName);
        }
    }

    private void collectImports(String clsName) {
        if (!importsProcessed.contains(clsName)) {
            String modelClsName = MODEL_PACKAGE_PREFIX + clsName;
            if (!getQualifier(clsName).equals("java.lang")) {
                if (clsName.startsWith("android")) {
                    if (!clsName.contains("$") && 
                            !classesAlreadyModeled.contains(modelClsName) &&
                            !classesCurrentlyModeled.contains(clsName) &&
                            !classesToBeModeled.contains(clsName)) {
                        classesToBeModeled.add(clsName);
                    }
                    imports.add(modelClsName);
                } else {
                    imports.add(clsName);
                }
            }
            importsProcessed.add(clsName);
        }
    }
    
    private void generateConstructor(ClassOrInterfaceDeclaration modelCoi) {
        ConstructorDeclaration modelConstr = new ConstructorDeclaration(Modifier.PUBLIC, unqualifiedClassName);
        Parameter parameter = ASTHelper.createParameter(makeReferenceType("AllocNode"), "allocNode");
        modelConstr.setParameters(makeParameterList(parameter));
        Statement stmt = new ExplicitConstructorInvocationStmt(false, null, makeExprList(new NameExpr("allocNode")));
        modelConstr.setBlock(makeBlockStmt(stmt));
        ASTHelper.addMember(modelCoi, modelConstr);
    }

    private void generateInitMethod(ClassOrInterfaceDeclaration modelCoi,
                                    ConstructorDeclaration constr) throws Exception {
        List<Parameter> params = constr.getParameters();
        int modifiers = makePublic(constr.getModifiers());
        MethodDeclaration method = new MethodDeclaration(modifiers, ASTHelper.VOID_TYPE, "_init_", params);
        method.setJavaDoc(constr.getJavaDoc());
        method.setComment(constr.getComment());
        method.setBody(constr.getBlock());
        SootMethod sootMethod = getSootMethod("<init>", params);
        String oldCode = methodCodeMap.get(constr);
        convertMethod(modelCoi, method, sootMethod, oldCode);                       
    }

    private SootMethod getSootMethod(String name, List<Parameter> parameters) throws Exception {
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
                StringBuffer buf = new StringBuffer(name);
                buf.append('(');
                for (int i = 0; i < paramCount; i++) {
                    if (i > 0)
                        buf.append(",");
                    buf.append(parameters.get(i));
                }
                buf.append(')');
                throw new Exception("Failed to find soot method " + buf);
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

    private void convertMethod(ClassOrInterfaceDeclaration modelCoi, MethodDeclaration method, SootMethod sootMethod, String oldCode) {
        method.setModifiers(makePublic(method.getModifiers()));
        Type returnType = method.getType();
        soot.Type sootReturnType = sootMethod.getReturnType();
        collectImports(sootReturnType);
        List<Parameter> params = method.getParameters();
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                Parameter param = params.get(i);
                Type type = param.getType();
                soot.Type sootType = sootMethod.getParameterType(i);
                Type newType = convertType(type, sootType);
                param.setType(newType);
                if (isSetOfType(newType) && !isSetOfType(type)) {
                    String name = param.getId().getName();
                    if (!name.endsWith("s"))
                        param.setId(new VariableDeclaratorId(name+"s"));
                }
            }
        }
        if (oldCode != null) {
            if (isGetterMethodForModeledField(method)) {
                method.setType(convertType(returnType, sootReturnType));
            } else {
                List<Statement> newStmts = new ArrayList<Statement>();
                if (!sootMethod.isStatic()) {
                    Statement invalidateStmt = new ExpressionStmt(new MethodCallExpr(null, "__ds__invalidate"));
                    newStmts.add(invalidateStmt);
                }
                if (!(returnType instanceof VoidType)) {
                    Expression returnExpr = defaultInitValue(returnType);
                    Statement returnStmt = new ReturnStmt(returnExpr);
                    newStmts.add(returnStmt);
                }
                BlockStmt newBody = new BlockStmt(newStmts);
                if (!oldCode.isEmpty())
                    newBody.setEndComment(new BlockComment(oldCode));
                method.setBody(newBody);
            }
        }
        ASTHelper.addMember(modelCoi, method);
    }
    
    private boolean isGetterMethodForModeledField(MethodDeclaration method) {
        if (method.getName().startsWith("get"))
            System.out.print("");
        BlockStmt body = method.getBody();
        List<Statement> stmts = body.getStmts();
        if (stmts != null && stmts.size() == 1) {
            Statement stmt = stmts.get(0);
            if (stmt instanceof ReturnStmt) {
                Expression returnExpr = ((ReturnStmt)stmt).getExpr();
                if (returnExpr instanceof FieldAccessExpr) {
                    String field = ((FieldAccessExpr)returnExpr).getField();
                    return fieldsToModel.contains(field);
                } else if (returnExpr instanceof NameExpr) {
                    String field = ((NameExpr)returnExpr).getName();
                    return fieldsToModel.contains(field);
                }
            }
        }
        return false;
    }

    private int makePublic(int modifiers) {
        modifiers = ModifierSet.removeModifier(modifiers, Modifier.PROTECTED);
        modifiers = ModifierSet.removeModifier(modifiers, Modifier.PRIVATE);
        return ModifierSet.addModifier(modifiers, Modifier.PUBLIC);
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

    private void writeModel(CompilationUnit cu) {
        String modelPackageName = MODEL_PACKAGE_PREFIX + packageName;
        File dir = constructFile("generated", modelPackageName.replace(".", File.separator));
        dir.mkdirs();
        PrintWriter out = null;
        File outFile = new File(dir, unqualifiedClassName + ".java");
        logger.info("Writing model code to " + outFile.getPath() + "...");
        try {
            out = new PrintWriter(outFile);
            out.print(cu.toString());
        } catch (FileNotFoundException e) {
            logger.error("generateCodeForModeledClass failed", e);
            droidsafe.main.Main.exit(1);
        } finally {
            if (out != null)
                out.close();
        }
    }

    private boolean isSetOfType(Type type) {
        if (type instanceof ReferenceType) {
            type = ((ReferenceType) type).getType();
            return type instanceof ClassOrInterfaceType && ((ClassOrInterfaceType)type).getName().equals("Set");
        }
        return false;
    }

    private ReferenceType makeSetOfType(String className) {
        return makeSetOfType(new ClassOrInterfaceType(className));
    }

    private ReferenceType makeSetOfType(Type type) {
        imports.add("java.util.Set");
        return makeGenericReferenceType("Set", type);
    }

    private static ReferenceType makeReferenceType(String className) {
        return new ReferenceType(new ClassOrInterfaceType(className));
    }
    
    private static ReferenceType makeGenericReferenceType(String genericClassName, Type ... typeArgs) {
        ClassOrInterfaceType genericType = makeGenericType(genericClassName, typeArgs);
        return new ReferenceType(genericType);
    }
    
    private static ClassOrInterfaceType makeGenericType(String genericClassName, Type ... typeArgs) {
        ClassOrInterfaceType genericType = new ClassOrInterfaceType(genericClassName);
        genericType.setTypeArgs(Arrays.asList(typeArgs));
        return genericType;
    }
    
    private static Expression makeModelingSetCreationExpr(Type typeArg) {
        return makeGenericObjectCreationExpr("ValueAnalysisModelingSet", typeArg);
    }

    private static Expression makeGenericObjectCreationExpr(String genericClassName, Type ... typeArgs) {
        ClassOrInterfaceType genericType = makeGenericType(genericClassName, typeArgs);
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
        if (index >= 0)
            name = name.substring(index + 1);
        index = name.lastIndexOf('$');
        if (index >= 0)
            name = name.substring(index + 1);
        return name;
    }

    private String getQualifier(String name) {
        int index = name.lastIndexOf('.');
        return (index < 0) ? "" : name.substring(0, index);
    }

    private File constructFile(String ...comps) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < comps.length; i++) {
            if (i > 0)
                buf.append(File.separator);
            buf.append(comps[i]);
        }
        return new File(buf.toString());        
    }

    /*
    public boolean isSubtypeOf(SootClass a, SootClass b) {
        if (a.equals(b))
            return true;
        if (b.getType().equals(RefType.v("java.lang.Object")))
            return true;
        if (a.isInterface()) {
            return b.isInterface() && hierarchy.isInterfaceSubinterfaceOf(a, b);
        }
        if (b.isInterface()) {
            return hierarchy.getImplementersOf(b).contains(a);
        }
        return hierarchy.isClassSubclassOf(a, b);
    }
    */
}
