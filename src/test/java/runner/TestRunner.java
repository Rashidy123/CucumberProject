package runner;

import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.lang.invoke.StringConcatFactory;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",
        dryRun =false,
        tags = "@rashid2",
        plugin ={"pretty"}
)
public class TestRunner {
}
