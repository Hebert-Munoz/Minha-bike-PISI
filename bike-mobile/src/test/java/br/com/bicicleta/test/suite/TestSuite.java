package br.com.bicicleta.test.suite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "classpath:peca",
		glue = "br.com.bicicleta.test"
		)
public class TestSuite {

}
