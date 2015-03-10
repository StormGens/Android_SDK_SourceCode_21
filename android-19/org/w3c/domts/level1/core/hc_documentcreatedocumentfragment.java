
/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:


Copyright (c) 2001 World Wide Web Consortium,
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University). All
Rights Reserved. This program is distributed under the W3C's Software
Intellectual Property License. This program is distributed in the
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
PURPOSE.
See W3C License http://www.w3.org/Consortium/Legal/ for more details.

*/

package org.w3c.domts.level1.core;

import org.w3c.dom.*;


import org.w3c.domts.DOMTestCase;
import org.w3c.domts.DOMTestDocumentBuilderFactory;



/**
 *     The "createDocumentFragment()" method creates an empty 
 *    DocumentFragment object.
 *    Retrieve the entire DOM document and invoke its 
 *    "createDocumentFragment()" method.  The content, name, 
 *    type and value of the newly created object are output.
* @author Curt Arnold
* @see <a href="http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-35CB04B5">http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-core#ID-35CB04B5</a>
*/
public final class hc_documentcreatedocumentfragment extends DOMTestCase {

   /**
    * Constructor.
    * @param factory document factory, may not be null
    * @throws org.w3c.domts.DOMTestIncompatibleException Thrown if test is not compatible with parser configuration
    */
   public hc_documentcreatedocumentfragment(final DOMTestDocumentBuilderFactory factory)  throws org.w3c.domts.DOMTestIncompatibleException {
      super(factory);

    //
    //   check if loaded documents are supported for content type
    //
    String contentType = getContentType();
    preload(contentType, "hc_staff", true);
    }

   /**
    * Runs the test case.
    * @throws Throwable Any uncaught exception causes test to fail
    */
   public void runTest() throws Throwable {
      Document doc;
      DocumentFragment newDocFragment;
      NodeList children;
      int length;
      String newDocFragmentName;
      int newDocFragmentType;
      String newDocFragmentValue;
      doc = (Document) load("hc_staff", true);
      newDocFragment = doc.createDocumentFragment();
      children = newDocFragment.getChildNodes();
      length = (int) children.getLength();
      assertEquals("length", 0, length);
      newDocFragmentName = newDocFragment.getNodeName();
      assertEquals("strong", "#document-fragment", newDocFragmentName);
      newDocFragmentType = (int) newDocFragment.getNodeType();
      assertEquals("type", 11, newDocFragmentType);
      newDocFragmentValue = newDocFragment.getNodeValue();
      assertNull("value", newDocFragmentValue);
      }
   /**
    *  Gets URI that identifies the test.
    *  @return uri identifier of test
    */
   public String getTargetURI() {
      return "http://www.w3.org/2001/DOM-Test-Suite/level1/core/hc_documentcreatedocumentfragment";
   }
   /**
    * Runs this test from the command line.
    * @param args command line arguments
    */
   public static void main(final String[] args) {
        DOMTestCase.doMain(hc_documentcreatedocumentfragment.class, args);
   }
}

