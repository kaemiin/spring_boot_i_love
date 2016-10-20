package net.patisco.password.util;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class SnowflakeGeneratorTests {
	
	@Test
	@Ignore
    public void nextIdTest() throws Exception {
		
		long id = new SnowflakeGenerator().nextId();
		
		assertThat(id).isNotNull();
		
		System.out.println(id);
		
	}

}
