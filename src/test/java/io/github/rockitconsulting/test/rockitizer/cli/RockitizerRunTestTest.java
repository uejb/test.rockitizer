package io.github.rockitconsulting.test.rockitizer.cli;

import io.github.rockitconsulting.test.rockitizer.configuration.TestObjectFactory;

import org.junit.Assert;
import org.junit.Test;

import com.rockit.common.blackboxtester.suite.configuration.Constants;

import picocli.CommandLine;

public class RockitizerRunTestTest  extends CommonCLITest {

	@Test
	public void testHelp() {
		TestObjectFactory.resetConfigurationToContextDemoPrj();
		System.out.println(new CommandLine(new RockitizerRunTest()).getUsageMessage());

	}

	@Test
	public void testRunTests() {
		TestObjectFactory.resetConfigurationToContextDemoPrj();
		Assert.assertEquals(new CommandLine(new RockitizerRunTest()).execute("all"), 0);

	}

	@Test
	public void testRunTestsParams() {
		System.setProperty(Constants.ENV_KEY, "devp");
		TestObjectFactory.resetConfigurationToContextDemoPrj(); 
		Assert.assertEquals( new CommandLine(new RockitizerRunTest()).execute("all","replay","devp"), 0);
		
		

	}
}
