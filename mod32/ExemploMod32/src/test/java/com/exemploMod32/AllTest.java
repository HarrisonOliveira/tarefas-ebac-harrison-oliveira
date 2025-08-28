package com.exemploMod32;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CursoTest.class,
        MatriculaTest.class
})
public class AllTest {
    public void allTest(){

    }
}
