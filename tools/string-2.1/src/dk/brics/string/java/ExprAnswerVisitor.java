package dk.brics.string.java;

import soot.Local;
import soot.jimple.AddExpr;
import soot.jimple.AndExpr;
import soot.jimple.ArrayRef;
import soot.jimple.CastExpr;
import soot.jimple.CaughtExceptionRef;
import soot.jimple.ClassConstant;
import soot.jimple.CmpExpr;
import soot.jimple.CmpgExpr;
import soot.jimple.CmplExpr;
import soot.jimple.DivExpr;
import soot.jimple.DoubleConstant;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.EqExpr;
import soot.jimple.ExprSwitch;
import soot.jimple.FloatConstant;
import soot.jimple.GeExpr;
import soot.jimple.GtExpr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InstanceOfExpr;
import soot.jimple.IntConstant;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.JimpleValueSwitch;
import soot.jimple.LeExpr;
import soot.jimple.LengthExpr;
import soot.jimple.LongConstant;
import soot.jimple.LtExpr;
import soot.jimple.MethodHandle;
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
import soot.jimple.UshrExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.XorExpr;
import soot.util.Switchable;

/**
 * Jimple visitor pattern that takes an auxillary parameter and has a return value.
 * <p/>
 * To use it, a class should extend this and override the desired <tt>case</tt> methods.
 * The visitor can then be applied with the {@link #applyTo(Switchable, Object)} method.
 * 
 * @author Asger
 *
 * @param <Q> the visit method's auxillary parameter type
 * @param <A> the visit method's return type
 */
public abstract class ExprAnswerVisitor<Q, A> {
	
	private A answer;
	private Q question;
	private MiddleMan middle = new MiddleMan();
	
	/**
	 * Applies the visitor to the specified Jimple object.
	 * @param sw a Jimple object to visit.
	 * @param question argument to pass as <tt>question</tt> to the corresponding <tt>caseXXX</tt> implementation.
	 * @return value returned by the corresponding <tt>caseXXX</tt> implementation, or <tt>null</tt> if
	 * 	the subclass did not override it.
	 */
	public final A applyTo(Switchable sw, Q question) {
		this.question = question;
		sw.apply(middle);
		return answer;
	}
	
	// this was awful to write
	
	private class MiddleMan implements ExprSwitch, JimpleValueSwitch {
	    
        public void caseAddExpr(AddExpr v) {
            answer = ExprAnswerVisitor.this.caseAddExpr(v, question);
        }
        
        public void caseAndExpr(AndExpr v) {
            answer = ExprAnswerVisitor.this.caseAndExpr(v, question);
        }

        public void caseCastExpr(CastExpr v) {
            answer = ExprAnswerVisitor.this.caseCastExpr(v, question);
        }

        public void caseCmpExpr(CmpExpr v) {
            answer = ExprAnswerVisitor.this.caseCmpExpr(v, question);
        }

        public void caseCmpgExpr(CmpgExpr v) {
            answer = ExprAnswerVisitor.this.caseCmpgExpr(v, question);
        }

        public void caseCmplExpr(CmplExpr v) {
            answer = ExprAnswerVisitor.this.caseCmplExpr(v, question);
        }

        public void caseDivExpr(DivExpr v) {
            answer = ExprAnswerVisitor.this.caseDivExpr(v, question);
        }

        public void caseEqExpr(EqExpr v) {
            answer = ExprAnswerVisitor.this.caseEqExpr(v, question);
        }

        public void caseGeExpr(GeExpr v) {
            answer = ExprAnswerVisitor.this.caseGeExpr(v, question);
        }

        public void caseGtExpr(GtExpr v) {
            answer = ExprAnswerVisitor.this.caseGtExpr(v, question);
        }

        public void caseInstanceOfExpr(InstanceOfExpr v) {
            answer = ExprAnswerVisitor.this.caseInstanceOfExpr(v, question);
        }

        public void caseInterfaceInvokeExpr(InterfaceInvokeExpr v) {
            answer = ExprAnswerVisitor.this.caseInterfaceInvokeExpr(v, question);
        }

        public void caseLeExpr(LeExpr v) {
            answer = ExprAnswerVisitor.this.caseLeExpr(v, question);
        }

        public void caseLengthExpr(LengthExpr v) {
            answer = ExprAnswerVisitor.this.caseLengthExpr(v, question);
        }

        public void caseLtExpr(LtExpr v) {
            answer = ExprAnswerVisitor.this.caseLtExpr(v, question);
        }

        public void caseMulExpr(MulExpr v) {
            answer = ExprAnswerVisitor.this.caseMulExpr(v, question);
        }

        public void caseNeExpr(NeExpr v) {
            answer = ExprAnswerVisitor.this.caseNeExpr(v, question);
        }

        public void caseNegExpr(NegExpr v) {
            answer = ExprAnswerVisitor.this.caseNegExpr(v, question);
        }

        public void caseNewArrayExpr(NewArrayExpr v) {
            answer = ExprAnswerVisitor.this.caseNewArrayExpr(v, question);
        }

        public void caseNewExpr(NewExpr v) {
            answer = ExprAnswerVisitor.this.caseNewExpr(v, question);
        }

        public void caseNewMultiArrayExpr(NewMultiArrayExpr v) {
            answer = ExprAnswerVisitor.this.caseNewMultiArrayExpr(v, question);
        }

        public void caseOrExpr(OrExpr v) {
            answer = ExprAnswerVisitor.this.caseOrExpr(v, question);
        }

        public void caseRemExpr(RemExpr v) {
            answer = ExprAnswerVisitor.this.caseRemExpr(v, question);
        }

        public void caseShlExpr(ShlExpr v) {
            answer = ExprAnswerVisitor.this.caseShlExpr(v, question);
        }

        public void caseShrExpr(ShrExpr v) {
            answer = ExprAnswerVisitor.this.caseShrExpr(v, question);
        }

        public void caseSpecialInvokeExpr(SpecialInvokeExpr v) {
            answer = ExprAnswerVisitor.this.caseSpecialInvokeExpr(v, question);
        }

        public void caseStaticInvokeExpr(StaticInvokeExpr v) {
            answer = ExprAnswerVisitor.this.caseStaticInvokeExpr(v, question);
        }

        public void caseSubExpr(SubExpr v) {
            answer = ExprAnswerVisitor.this.caseSubExpr(v, question);
        }

        public void caseUshrExpr(UshrExpr v) {
            answer = ExprAnswerVisitor.this.caseUshrExpr(v, question);
        }

        public void caseVirtualInvokeExpr(VirtualInvokeExpr v) {
            answer = ExprAnswerVisitor.this.caseVirtualInvokeExpr(v, question);
        }

        public void caseXorExpr(XorExpr v) {
            answer = ExprAnswerVisitor.this.caseXorExpr(v, question);
        }

        public void defaultCase(Object obj) {
            answer = ExprAnswerVisitor.this.defaultExpr(obj, question);
        }

        public void caseLocal(Local l) {
            answer = ExprAnswerVisitor.this.caseLocal(l, question);
        }

        public void caseClassConstant(ClassConstant v) {
            answer = ExprAnswerVisitor.this.caseClassConstant(v, question);
        }

        public void caseDoubleConstant(DoubleConstant v) {
            answer = ExprAnswerVisitor.this.caseDoubleConstant(v, question);
        }

        public void caseFloatConstant(FloatConstant v) {
            answer = ExprAnswerVisitor.this.caseFloatConstant(v, question);
        }

        public void caseIntConstant(IntConstant v) {
            answer = ExprAnswerVisitor.this.caseIntConstant(v, question);
        }

        public void caseLongConstant(LongConstant v) {
            answer = ExprAnswerVisitor.this.caseLongConstant(v, question);
        }

        public void caseNullConstant(NullConstant v) {
            answer = ExprAnswerVisitor.this.caseNullConstant(v, question);
        }

        public void caseStringConstant(StringConstant v) {
            answer = ExprAnswerVisitor.this.caseStringConstant(v, question);
        }

        public void caseArrayRef(ArrayRef v) {
            answer = ExprAnswerVisitor.this.caseArrayRef(v, question);
        }

        public void caseCaughtExceptionRef(CaughtExceptionRef v) {
            answer = ExprAnswerVisitor.this.caseCaughtExceptionRef(v, question);
        }

        public void caseInstanceFieldRef(InstanceFieldRef v) {
            answer = ExprAnswerVisitor.this.caseInstanceFieldRef(v, question);
        }

        public void caseParameterRef(ParameterRef v) {
            answer = ExprAnswerVisitor.this.caseParameterRef(v, question);
        }

        public void caseStaticFieldRef(StaticFieldRef v) {
            answer = ExprAnswerVisitor.this.caseStaticFieldRef(v, question);
        }

        public void caseThisRef(ThisRef v) {
            answer = ExprAnswerVisitor.this.caseThisRef(v, question);
        }
	    
        // LWG: soot 2.5.0
        public void caseDynamicInvokeExpr(DynamicInvokeExpr v) {
    		throw new UnsupportedOperationException();
        }

        // LWG: soot develop
		public void caseMethodHandle(MethodHandle handle) {
    		throw new UnsupportedOperationException();
			
		}
	}
	
	public A caseArrayRef(ArrayRef v, Q question)
    {
        return defaultExpr(v, question);
    }
	
    public A caseDoubleConstant(DoubleConstant v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseFloatConstant(FloatConstant v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseIntConstant(IntConstant v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseLongConstant(LongConstant v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseNullConstant(NullConstant v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseStringConstant(StringConstant v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseClassConstant(ClassConstant v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseAddExpr(AddExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseAndExpr(AndExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseCmpExpr(CmpExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseCmpgExpr(CmpgExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseCmplExpr(CmplExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseDivExpr(DivExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseEqExpr(EqExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseGeExpr(GeExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseGtExpr(GtExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseLeExpr(LeExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseLtExpr(LtExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseMulExpr(MulExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseNeExpr(NeExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseOrExpr(OrExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseRemExpr(RemExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseShlExpr(ShlExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseShrExpr(ShrExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseSubExpr(SubExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseUshrExpr(UshrExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseXorExpr(XorExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseInterfaceInvokeExpr(InterfaceInvokeExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseSpecialInvokeExpr(SpecialInvokeExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseStaticInvokeExpr(StaticInvokeExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseVirtualInvokeExpr(VirtualInvokeExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseCastExpr(CastExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseInstanceOfExpr(InstanceOfExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseNewArrayExpr(NewArrayExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseNewMultiArrayExpr(NewMultiArrayExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseNewExpr(NewExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseLengthExpr(LengthExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseNegExpr(NegExpr v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseInstanceFieldRef(InstanceFieldRef v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseLocal(Local v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseParameterRef(ParameterRef v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseCaughtExceptionRef(CaughtExceptionRef v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseThisRef(ThisRef v, Q question)
    {
        return defaultExpr(v, question);
    }

    public A caseStaticFieldRef(StaticFieldRef v, Q question)
    {
        return defaultExpr(v, question);
    }
    
    public A defaultExpr(Object v, Q question)
    {
    	return null;
    }
	
}
