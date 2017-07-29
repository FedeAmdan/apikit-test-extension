package org.mule.extension.some.api;

import org.mule.runtime.api.meta.Category;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Export;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

@Extension(name = "Test Extension", vendor = "MuleSoft Inc.", category = Category.SELECT)
@Configurations({ConfigOne.class})
@Export(classes = ConfigOne.class)
@Xml(prefix = "apikit-test")
public class TestExtension {
}
