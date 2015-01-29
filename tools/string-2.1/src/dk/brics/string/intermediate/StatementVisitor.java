package dk.brics.string.intermediate;

/**
 * A visitor pattern for statements.
 * <p/>
 * A visitor is invoked by passing it to the
 * {@link dk.brics.string.intermediate.Statement#visitBy visitBy}
 * method of the statement to visit. This will invoke the corresponding
 * method in the visitor.
 */
public interface StatementVisitor {

    /**
     * Visit an {@link dk.brics.string.intermediate.ArrayAssignment} statement.
     *
     * @param s the visited statement.
     */
    public void visitArrayAssignment(ArrayAssignment s);
    
    /**
     * Visit an {@link dk.brics.string.intermediate.ArrayAddAll} statement.
     *
     * @param s the visited statement.
     */
    public void visitArrayAddAll(ArrayAddAll s);

    /**
     * Visit an {@link dk.brics.string.intermediate.ArrayCorrupt} statement.
     *
     * @param s the visited statement.
     */
    public void visitArrayCorrupt(ArrayCorrupt s);

    /**
     * Visit an {@link dk.brics.string.intermediate.ArrayFromArray} statement.
     *
     * @param s the visited statement.
     */
    public void visitArrayFromArray(ArrayFromArray s);

    /**
     * Visit an {@link dk.brics.string.intermediate.ArrayNew} statement.
     *
     * @param s the visited statement.
     */
    public void visitArrayNew(ArrayNew s);

    /**
     * Visit an {@link dk.brics.string.intermediate.ArrayWriteArray} statement.
     *
     * @param s the visited statement.
     */
    public void visitArrayWriteArray(ArrayWriteArray s);

    /**
     * Visit an {@link dk.brics.string.intermediate.ArrayWriteElement} statement.
     *
     * @param s the visited statement.
     */
    public void visitArrayWriteElement(ArrayWriteElement s);

    /**
     * Visit a {@link dk.brics.string.intermediate.Call} statement.
     *
     * @param s the visited statement.
     */
    public void visitCall(Call s);

    /**
     * Visit a {@link dk.brics.string.intermediate.MethodHead} statement.
     *
     * @param s the visited statement.
     */
    public void visitMethodHead(MethodHead s);

    /**
     * Visit a {@link dk.brics.string.intermediate.Nop} statement.
     *
     * @param s the visited statement.
     */
    public void visitNop(Nop s);

    /**
     * Visit a {@link dk.brics.string.intermediate.Return} statement.
     *
     * @param s the visited statement.
     */
    public void visitReturn(Return s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringAssignment} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringAssignment(StringAssignment s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringBufferAppend} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringBufferAppend(StringBufferAppend s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringBufferAssignment} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringBufferAssignment(StringBufferAssignment s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringBufferBinaryOp} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringBufferBinaryOp(StringBufferBinaryOp s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringBufferCorrupt} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringBufferCorrupt(StringBufferCorrupt s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringBufferInit} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringBufferInit(StringBufferInit s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringBufferPrepend} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringBufferPrepend(StringBufferPrepend s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringBufferUnaryOp} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringBufferUnaryOp(StringBufferUnaryOp s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringConcat} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringConcat(StringConcat s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringFromArray} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringFromArray(StringFromArray s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringFromStringBuffer} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringFromStringBuffer(StringFromStringBuffer s);

    /**
     * Visit a {@link dk.brics.string.intermediate.StringInit} statement.
     *
     * @param s the visited statement.
     */
    public void visitStringInit(StringInit s);
    
    /**
     * Visit a {@link ObjectAssignment} statement.
     * 
     * @param s the visited statement.
     */
    public void visitObjectAssignment(ObjectAssignment s);
    
    /**
     * Visit a {@link ObjectCorrupt} statement.
     * 
     * @param s the visited statement.
     */
    public void visitObjectCorrupt(ObjectCorrupt s);
    
    /**
     * Visit a {@link Hotspot} statement.
     * 
     * @param s the visited statement.
     */
    public void visitHotspot(Hotspot s);
    
    /**
     * Visit a {@link FieldAssignment} statement.
     * 
     * @param s the visited statement.
     */
    public void visitFieldAssignment(FieldAssignment s);
    
    /**
     * Visit a {@link FieldReference} statement.
     * 
     * @param s the visited statement.
     */
    public void visitFieldReference(FieldReference s);

    /**
     * Visit a {@link ExceptionalReturn} statement.
     * 
     * @param s the visited statement.
     */
    public void visitExceptionalReturn(ExceptionalReturn s);
    
    /**
     * Visit a {@link Catch} statement.
     * 
     * @param s the visited statement.
     */
    public void visitCatch(Catch s);

    void visitPrimitiveAssignment(PrimitiveAssignment s);

    void visitPrimitiveInit(PrimitiveInit s);

    void visitStringBufferAppendChar(StringBufferAppendChar s);

    void visitBasicUnaryOp(BasicUnaryOp s);

    void visitBasicBinaryOp(BasicBinaryOp s);

    void visitAssertBinaryOp(AssertBinaryOp s);
    
    void visitAssertUnaryOp(AssertUnaryOp s);

    void visitPrimitiveFromArray(PrimitiveFromArray s);
    
	void visitAssertAliases(AssertAliases s);
}
