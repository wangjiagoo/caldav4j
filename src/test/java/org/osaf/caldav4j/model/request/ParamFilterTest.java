package org.osaf.caldav4j.model.request;

import org.osaf.caldav4j.BaseTestCase;
import org.osaf.caldav4j.CalDAVConstants;
import org.osaf.caldav4j.DOMValidationException;
import org.osaf.caldav4j.util.XMLUtils;

public class ParamFilterTest extends BaseTestCase {

        public void testSimpleConstructor() {
                ParamFilter p = new ParamFilter("C");
                try {
                        //This won't work because name will be null
                        p.validate();
                        fail("should fail if no name specified");
                } catch (DOMValidationException e) {
                        assertNotNull("Ok, doesn't accept null name", e);
                }
        }

        public void testName() {
                ParamFilter p = new ParamFilter("C");
                p.setName("newname");
                assertEquals(p.getName(), "newname");
                try {
                        p.validate();
                        log.info(XMLUtils.prettyPrint(p));
                } catch (DOMValidationException e) {
                        fail("Should have a valid ParamFilter");
                }
                
                p.setDefined(false);
        }
        
        public void testDefined() {
            ParamFilter p = new ParamFilter("C");
            p.setName("testDefined");
            assertEquals(p.getName(), "testDefined");
            p.setDefined(true);

            try {
                    p.validate();
                    log.info(XMLUtils.prettyPrint(p));
            } catch (DOMValidationException e) {
                    fail("Should have a valid ParamFilter");
            }
            
    }
        public void testTextMatch() {
            ParamFilter p = new ParamFilter("C");
            p.setName("testDefined");
            assertEquals(p.getName(), "testDefined");
            p.setTextMatch(new TextMatch(CalDAVConstants.NS_QUAL_CALDAV,null,null,null,"testTextMatch"));
            try {
                    p.validate();
                    log.info(XMLUtils.prettyPrint(p));
            } catch (DOMValidationException e) {
                    fail("Should have a valid ParamFilter");
            }
            
    }
}