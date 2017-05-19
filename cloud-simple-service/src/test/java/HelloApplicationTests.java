import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cloud.simple.service.SimpleApplication;
import cloud.simple.service.web.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimpleApplication.class)
@WebAppConfiguration
public class HelloApplicationTests {

	private MockMvc mvc;
	@Autowired
	UserController userController;// 不能new出来，通过注入可以获取到真实的实例

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void hello() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/user").accept(
						org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
