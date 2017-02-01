package org.acactown.test.impl;

import org.acactown.test.Service;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aamadoc on 2/1/17.
 */
public class DefaultServiceTest {

    private Service service;

    private String name;
    private String result;

    @Before
    public void setUp() throws Exception {
        service = new DefaultService();
    }

    @Test
    public void doWork() throws Exception {
        // Given
        name = "Andrés";

        // When
        result = service.sayHello(name);

        // Then
        assertEquals("Hello Andrés!", result);
    }

}