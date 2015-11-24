package br.com.bicicleta.test.add.peca;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (		features = "classpath:peca/add-peca.feature",
		glue = "br.com.bicicleta.test.add.peca"

		)
public class AddPecaFeature {

}
