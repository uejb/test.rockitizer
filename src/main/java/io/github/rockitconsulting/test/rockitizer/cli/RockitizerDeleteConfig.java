package io.github.rockitconsulting.test.rockitizer.cli;

import static io.github.rockitconsulting.test.rockitizer.configuration.Configuration.configuration;

import java.io.File;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "delete-env",
sortOptions = false,
headerHeading = "@|bold,underline Benutzung:|@%n%n",
synopsisHeading = "%n",
descriptionHeading = "%n@|bold,underline Description:|@%n%n",
parameterListHeading = "%n@|bold,underline Parameters:|@%n",
optionListHeading = "%n@|bold,underline Options:|@%n",
header = "cli delete-env <env>",
description = "Stores the current contents of the index in a new commit " +
		"along with a log message from the user describing the changes.")

public class RockitizerDeleteConfig implements Runnable {
	
	@Parameters(index = "0", arity = "0..1", description = ": env = dev => deletion of resources-dev.yaml")
    public String env;
	
	public String path;
	
	@Override
	public void run() {
		
		
	
		if (env != null){
			
			path = configuration().getFullPath() + "resources-" + env + ".yaml";
			
		}else{

			path = configuration().getFullPath() + "resources.yaml";

		}
		
		deleteConfig(path);
		
		
		
	}
	
	

	public void deleteConfig(String path) {


		if (new File(path).delete()) {
			System.out.println(" Configuration deleted successfully: " + path);
		} else {
			System.err.println(" Failed to delete the file: " + path);
		}

	}

}
