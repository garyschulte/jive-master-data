package com.jivesoftware.community.cloudalytics.masterdata.jsonschema;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by gary.schulte on 4/22/16.
 *
 * this is a terrible idea.  but there don't seem to be any json schema doc fakers for java yet.
 */
public class NashornJsonGen {

    @Test
    public void generateDoc() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        URL wtf = this.getClass().getResource("jvm-npm.js");
        engine.eval("load('jvm-npm.js')");
        engine.eval("var x = require('json-schema-faker')");


    }
}
