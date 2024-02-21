package util;

import Pages.PageObjectManager;

public class TestContextSetup {
    public Base base;
    public PageObjectManager pom;

    public TestContextSetup() {
        base = new Base();
        pom = new PageObjectManager(base.initializeDriver());
    }

    public PageObjectManager Setup() {
        return pom;
    }
}

