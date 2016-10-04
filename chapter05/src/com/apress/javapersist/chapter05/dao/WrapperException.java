/*
 * WrapperException.java
 *
 * Created on September 18, 2002, 9:40 PM
 */

package com.apress.javapersist.chapter05.dao;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *
 * @author  rsperko
 */
public class WrapperException extends java.lang.Exception {
    Throwable wrapped;
    /**
     * Creates a new instance of <code>WrapperException</code> without detail message.
     */
    public WrapperException() {
    }
    
    
    /**
     * Constructs an instance of <code>WrapperException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public WrapperException(String msg) {
        super(msg);
    }
    
    /**
     * Constructs an instance of <code>WrapperException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public WrapperException(Throwable wrapped) {
        super(wrapped.getMessage());
        this.wrapped = wrapped;
    }
    
    /**
     * Constructs an instance of <code>WrapperException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public WrapperException(Throwable wrapped, String msg) {
        super(msg);
        this.wrapped = wrapped;
    }
    
    /** Prints this throwable and its backtrace to the
     * standard error stream. This method prints a stack trace for this
     * <code>Throwable</code> object on the error output stream that is
     * the value of the field <code>System.err</code>. The first line of
     * output contains the result of the {@link #toString()} method for
     * this object.  Remaining lines represent data previously recorded by
     * the method {@link #fillInStackTrace()}. The format of this
     * information depends on the implementation, but the following
     * example may be regarded as typical:
     * <blockquote><pre>
     * java.lang.NullPointerException
     *         at MyClass.mash(MyClass.java:9)
     *         at MyClass.crunch(MyClass.java:6)
     *         at MyClass.main(MyClass.java:3)
     * </pre></blockquote>
     * This example was produced by running the program:
     * <pre>
     * class MyClass {
     *     public static void main(String[] args) {
     *         crunch(null);
     *     }
     *     static void crunch(int[] a) {
     *         mash(a);
     *     }
     *     static void mash(int[] b) {
     *         System.out.println(b[0]);
     *     }
     * }
     * </pre>
     * The backtrace for a throwable with an initialized, non-null cause
     * should generally include the backtrace for the cause.  The format
     * of this information depends on the implementation, but the following
     * example may be regarded as typical:
     * <pre>
     * HighLevelException: MidLevelException: LowLevelException
     *         at Junk.a(Junk.java:13)
     *         at Junk.main(Junk.java:4)
     * Caused by: MidLevelException: LowLevelException
     *         at Junk.c(Junk.java:23)
     *         at Junk.b(Junk.java:17)
     *         at Junk.a(Junk.java:11)
     *         ... 1 more
     * Caused by: LowLevelException
     *         at Junk.e(Junk.java:30)
     *         at Junk.d(Junk.java:27)
     *         at Junk.c(Junk.java:21)
     *         ... 3 more
     * </pre>
     * Note the presence of lines containing the characters <tt>"..."</tt>.
     * These lines indicate that the remainder of the stack trace for this
     * exception matches the indicated number of frames from the bottom of the
     * stack trace of the exception that was caused by this exception (the
     * "enclosing" exception).  This shorthand can greatly reduce the length
     * of the output in the common case where a wrapped exception is thrown
     * from same method as the "causative exception" is caught.  The above
     * example was produced by running the program:
     * <pre>
     * public class Junk {
     *     public static void main(String args[]) {
     *         try {
     *             a();
     *         } catch(HighLevelException e) {
     *             e.printStackTrace();
     *         }
     *     }
     *     static void a() throws HighLevelException {
     *         try {
     *             b();
     *         } catch(MidLevelException e) {
     *             throw new HighLevelException(e);
     *         }
     *     }
     *     static void b() throws MidLevelException {
     *         c();
     *     }
     *     static void c() throws MidLevelException {
     *         try {
     *             d();
     *         } catch(LowLevelException e) {
     *             throw new MidLevelException(e);
     *         }
     *     }
     *     static void d() throws LowLevelException {
     *        e();
     *     }
     *     static void e() throws LowLevelException {
     *         throw new LowLevelException();
     *     }
     * }
     *
     * class HighLevelException extends Exception {
     *     HighLevelException(Throwable cause) { super(cause); }
     * }
     *
     * class MidLevelException extends Exception {
     *     MidLevelException(Throwable cause)  { super(cause); }
     * }
     *
     * class LowLevelException extends Exception {
     * }
     * </pre>
     *
     */
    public void printStackTrace() {
        super.printStackTrace();
        wrapped.printStackTrace();
    }
    
    /** Prints this throwable and its backtrace to the specified print stream.
     *
     * @param s <code>PrintStream</code> to use for output
     *
     */
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
        wrapped.printStackTrace(s);
    }
    
    /** Prints this throwable and its backtrace to the specified
     * print writer.
     *
     * @param s <code>PrintWriter</code> to use for output
     * @since   JDK1.1
     *
     */
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
        wrapped.printStackTrace(s);
    }
    
}
