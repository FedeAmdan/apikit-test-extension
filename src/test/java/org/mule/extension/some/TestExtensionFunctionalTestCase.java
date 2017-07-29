package org.mule.extension.some;

import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.junit.Test;

public class TestExtensionFunctionalTestCase extends MuleArtifactFunctionalTestCase {

    @Override
    protected String getConfigFile() {
        return "test-extension-mule-app.xml";
    }

    @Test
    public void test() throws Exception {
        flowRunner("flowtest").run();
    }

}
