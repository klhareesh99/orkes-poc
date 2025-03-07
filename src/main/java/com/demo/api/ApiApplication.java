package com.demo.api;

import static com.demo.api.utils.Constants.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.conductor.sdk.workflow.executor.WorkflowExecutor;
import io.orkes.conductor.client.ApiClient;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			ApiClient apiClient = ApiClient.builder()
					.basePath(ORKES_URL)
					.credentials(KEY, SECRET)
					.build();
			WorkflowExecutor exceutor = new WorkflowExecutor(apiClient, 3000);
			executor.initWorkers("com.demo.api.workers");
		} catch (Exception e) {
			logger.error("Error: {}", e.getMessage());
		}
	}

}
