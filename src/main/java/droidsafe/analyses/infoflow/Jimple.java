package droidsafe.analyses.infoflow;

import soot.Local;
import soot.jimple.AbstractExprSwitch;
import soot.jimple.AbstractJimpleValueSwitch;
import soot.jimple.AbstractRefSwitch;
import soot.jimple.AddExpr;
import soot.jimple.AndExpr;
import soot.jimple.ArrayRef;
import soot.jimple.BinopExpr;
import soot.jimple.CastExpr;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.ClassConstant;
import soot.jimple.CmpExpr;
import soot.jimple.CmpgExpr;
import soot.jimple.CmplExpr;
import soot.jimple.Constant;
import soot.jimple.DivExpr;
import soot.jimple.DoubleConstant;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.EqExpr;
import soot.jimple.FloatConstant;
import soot.jimple.GeExpr;
import soot.jimple.GtExpr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceOfExpr;
import soot.jimple.IntConstant;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.LeExpr;
import soot.jimple.LengthExpr;
import soot.jimple.LongConstant;
import soot.jimple.LtExpr;
import soot.jimple.MulExpr;
import soot.jimple.NeExpr;
import soot.jimple.NegExpr;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.NullConstant;
import soot.jimple.OrExpr;
import soot.jimple.ParameterRef;
import soot.jimple.RemExpr;
import soot.jimple.ShlExpr;
import soot.jimple.ShrExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.StringConstant;
import soot.jimple.SubExpr;
import soot.jimple.ThisRef;
import soot.jimple.UnopExpr;
import soot.jimple.UshrExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.XorExpr;

// variable = array_ref | instance_field_ref | static_field_ref | local;
abstract class MyAbstractVariableSwitch extends AbstractJimpleValueSwitch {
    // variable = array_ref | ...;
    @Override
    abstract public void caseArrayRef(ArrayRef v);

    // variable = ... | instance_field_ref | ...;
    @Override
    abstract public void caseInstanceFieldRef(InstanceFieldRef v);

    // variable = ... | static_field_ref | ...;
    @Override
    abstract public void caseStaticFieldRef(StaticFieldRef v);

    // variable = ... | local;
    @Override
    abstract public void caseLocal(Local v);

    @Override
    final public void defaultCase(Object v) {
        // This should not happen
        throw new RuntimeException(v.toString());
    }
}

// rvalue = array_ref | constant | expr | instance_field_ref | local | next_next_stmt_address | static_field_ref;
abstract class MyAbstractRValueSwitch extends AbstractJimpleValueSwitch {
    // rvalue = array_ref | ...;
    @Override
    abstract public void caseArrayRef(ArrayRef v);

    // rvalue = ... | constant | double_constant | float_constant | int_constant | long_constant | string_constant | null_constant;
    abstract public void caseConstant(Constant constant);

    // rvalue = ... | expr | ...;
    // expr = binop_expr | ...;
    // binop_expr = add_expr | and_expr | cmp_expr | cmpg_expr | cmpl_expr | div_expr | eq_expr | ge_expr | gt_expr | le_expr | lt_expr | mul_expr | ne_expr | or_expr | rem_expr | shl_expr | shr_expr | sub_expr | ushr_expr | xor_expr;
    abstract public void caseBinopExpr(BinopExpr v);

    // rvalue = ... | expr | ...;
    // expr = ... | cast_expr | ...;
    @Override
    abstract public void caseCastExpr(CastExpr v);

    // rvalue = ... | expr | ...;
    // expr = ... | instance_of_expr | ...;
    @Override
    abstract public void caseInstanceOfExpr(InstanceOfExpr v);

    // rvalue = ... | expr | ...;
    // expr = ... | invoke_expr | ...;
    // invoke_expr = interface_invoke_expr | special_invoke_expr |
    // static_invoke_expr | virtual_invoke_expr;
    abstract public void caseInvokeExpr(InvokeExpr v);

    // rvalue = ... | expr | ...;
    // expr = ... | new_array_expr | ...;
    @Override
    abstract public void caseNewArrayExpr(NewArrayExpr v);

    // rvalue = ... | expr | ...;
    // expr = ... | new_expr | ...;
    @Override
    abstract public void caseNewExpr(NewExpr newExpr);

    // rvalue = ... | expr | ...;
    // expr = ... | new_multi_array_expr | ...;
    @Override
    abstract public void caseNewMultiArrayExpr(NewMultiArrayExpr v);

    // rvalue = ... | expr | ...;
    // expr = ... | unop_expr;
    // unop_expr = length_expr | neg_expr;
    abstract public void caseUnopExpr(UnopExpr unopExpr);

    // rvalue = ... | instance_field_ref | ...;
    @Override
    abstract public void caseInstanceFieldRef(InstanceFieldRef v);

    // rvalue = ... | local | ...;
    @Override
    abstract public void caseLocal(Local v);

    // rvalue = ... | static_field_ref;
    @Override
    abstract public void caseStaticFieldRef(StaticFieldRef v);

    @Override
    public void caseDoubleConstant(DoubleConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseFloatConstant(FloatConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseIntConstant(IntConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseLongConstant(LongConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseNullConstant(NullConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseStringConstant(StringConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseClassConstant(ClassConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseAddExpr(AddExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseAndExpr(AndExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseCmpExpr(CmpExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseCmpgExpr(CmpgExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseCmplExpr(CmplExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseDivExpr(DivExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseEqExpr(EqExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseGeExpr(GeExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseGtExpr(GtExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseLeExpr(LeExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseLtExpr(LtExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseMulExpr(MulExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseNeExpr(NeExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseOrExpr(OrExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseRemExpr(RemExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseShlExpr(ShlExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseShrExpr(ShrExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseSubExpr(SubExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseUshrExpr(UshrExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseXorExpr(XorExpr v) {
        caseBinopExpr(v);
    }

    @Override
    public void caseInterfaceInvokeExpr(InterfaceInvokeExpr v) {
        caseInvokeExpr(v);
    }

    @Override
    public void caseSpecialInvokeExpr(SpecialInvokeExpr v) {
        caseInvokeExpr(v);
    }

    @Override
    public void caseStaticInvokeExpr(StaticInvokeExpr v) {
        caseInvokeExpr(v);
    }

    @Override
    public void caseVirtualInvokeExpr(VirtualInvokeExpr v) {
        caseInvokeExpr(v);
    }

    @Override
    public void caseLengthExpr(LengthExpr v) {
        caseUnopExpr(v);
    }

    @Override
    public void caseNegExpr(NegExpr v) {
        caseUnopExpr(v);
    }

    @Override
    final public void defaultCase(Object v) {
        // TODO: rvalue may be next_next_stmt_address, but I do not know what soot class it corresponds to yet.
        throw new UnsupportedOperationException(v.toString());
    }
}

// immediate = constant | local;
abstract class MyAbstractImmediateSwitch extends AbstractJimpleValueSwitch {
    // immediate = constant | ...;
    // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant
    abstract public void caseConstant(Constant v);

    // immediate = ... | local;
    @Override
    abstract public void caseLocal(Local v);

    @Override
    public void caseDoubleConstant(DoubleConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseFloatConstant(FloatConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseIntConstant(IntConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseLongConstant(LongConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseNullConstant(NullConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseStringConstant(StringConstant v) {
        caseConstant(v);
    }

    @Override
    public void caseClassConstant(ClassConstant v) {
        caseConstant(v);
    }

    @Override
    final public void defaultCase(Object v) {
        // This should not happen
        throw new RuntimeException(v.toString());
    }
}

// identity_value = caught_exception_ref | parameter_ref | this_ref;
abstract class MyAbstractIdentityValueSwitch extends AbstractJimpleValueSwitch {
    // identity_value = caught_exception_ref | ...;
    @Override
    abstract public void caseCaughtExceptionRef(CaughtExceptionRef v);

    // identity_value = ... | parameter_ref | ...;
    @Override
    abstract public void caseParameterRef(ParameterRef v);

    // identity_value = ... | this_ref;
    @Override
    abstract public void caseThisRef(ThisRef v);

    @Override
    final public void defaultCase(Object v) {
        // This should not happen
        throw new RuntimeException(v.toString());
    }
}

// invoke_expr = interface_invoke_expr | special_invoke_expr | static_invoke_expr | virtual_invoke_expr | dynamic_invoke_expr;
abstract class MyAbstractInvokeExprSwitch extends AbstractExprSwitch {
    // invoke_expr = interface_invoke_expr | ...
    @Override
    abstract public void caseInterfaceInvokeExpr(InterfaceInvokeExpr e);

    // invoke_expr = ... | special_invoke_expr | ...
    @Override
    abstract public void caseSpecialInvokeExpr(SpecialInvokeExpr e);

    // invoke_expr = ... | static_invoke_expr | ...
    @Override
    abstract public void caseStaticInvokeExpr(StaticInvokeExpr e);

    // invoke_expr = ... | virtual_invoke_expr
    @Override
    abstract public void caseVirtualInvokeExpr(VirtualInvokeExpr e);

    // invoke_expr = ... | dynamic_invoke_expr;
    @Override
    abstract public void caseDynamicInvokeExpr(DynamicInvokeExpr e);

    @Override
    final public void defaultCase(Object e) {
        // This should not happen
        throw new RuntimeException(e.toString());
    }
}

// unop_expr = length_expr | neg_expr
abstract class MyAbstractUnopExprSwitch extends AbstractExprSwitch {
    // unop_expr = length_expr
    @Override
    abstract public void caseLengthExpr(LengthExpr e);

    // unop_expr = neg_expr
    @Override
    abstract public void caseNegExpr(NegExpr e);

    final public void caseDynamicInvokeExpr(DynamicInvokeExpr e) {
        defaultCase(e);
    }

    @Override
    final public void defaultCase(Object e) {
        // This should not happen
        throw new RuntimeException(e.toString());
    }
}

// concrete_ref = instace_field_ref | static_field_ref | array_ref
abstract class MyAbstractConcreteRefSwitch extends AbstractRefSwitch {
    Object result;

    @Override
    final public void caseCaughtExceptionRef(CaughtExceptionRef e) {
        defaultCase(e);
    }

    @Override
    final public void caseParameterRef(ParameterRef e) {
        defaultCase(e);
    }

    @Override
    final public void caseThisRef(ThisRef e) {
        defaultCase(e);
    }

    @Override
    final public void defaultCase(Object e) {
        // This should not happen
        throw new RuntimeException(e.toString());
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}
