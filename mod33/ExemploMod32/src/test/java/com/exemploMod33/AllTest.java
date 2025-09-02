package com.exemploMod33;

import com.exemploMod33.controller.CursoController;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CursoController.class,
})
public class AllTest {
    public void allTest(){}
}
