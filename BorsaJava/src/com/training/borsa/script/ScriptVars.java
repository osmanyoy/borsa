package com.training.borsa.script;

import java.io.File;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.training.borsa.newfeatures.Person;

public class ScriptVars {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        File f = new File("test.txt");
		Person person = new Person();
		person.setName("osman");
		person.setSurname("yay");
		person.setBoltest(true);
        
        System.out.println(f.getAbsolutePath());
        
        // expose File object as variable to script
        engine.put("file", f);
        engine.put("person", person);

        // evaluate a script string. The script accesses "file"
        // variable and calls method on it
        engine.eval("print(file.getAbsolutePath());print(person.getName() + ' ' + person.getSurname());");
    }
}