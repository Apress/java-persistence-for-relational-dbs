/*
 * TestSampleServlet.java
 *
 * Created on November 3, 2002, 9:46 PM
 */

package com.centare.strongbrownbag.cactus;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.cactus.ServletTestCase;
import org.apache.cactus.WebRequest;

public class TestSampleServlet extends ServletTestCase
{
    public TestSampleServlet(String theName)
    {
        super(theName);
    }

    public static Test suite()
    {
        return new TestSuite(TestSampleServlet.class);
    }

    public void beginSaveToSessionOK(WebRequest webRequest)
    {
        webRequest.addParameter("testparam", "it works!");
    }

    public void testSaveToSessionOK()
    {
        SampleServlet servlet = new SampleServlet();
        servlet.saveToSession(request);
        assertEquals("it works!", session.getAttribute("testAttribute"));
    }

    public static void main(String[] theArgs)
    {
        junit.swingui.TestRunner.main(new String[] {TestSampleServlet.class.getName()});
    }
}
