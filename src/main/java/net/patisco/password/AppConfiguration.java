package net.patisco.password;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableWebMvc
@EnableAsync
public class AppConfiguration extends AsyncConfigurerSupport {
	
	public static void main(String[] args) {
		
		SpringApplication.run(AppConfiguration.class, args);
		
	}
	
	@Override
    public Executor getAsyncExecutor() {
		
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("Password-");
        executor.initialize();
        return executor;
        
    }

}
