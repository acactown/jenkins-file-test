package org.acactown.test.impl;

import org.acactown.test.Service;

/**
 * Created by aamadoc on 2/1/17.
 */
public final class DefaultService implements Service {

    @Override
    public String sayHello(final String name) {
        return "Hello " + name + "!";
    }

}
