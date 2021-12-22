package demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {
	private static final String MICKEY_MOUSE_JSON = "{\"firstName\":\"Mickey\",\"lastName\":\"Mouse\"}";
	@Autowired
	private MockMvc mvc;

	@Test
	void getAll() throws Exception {
		getRestResultAndAssert("Donald", "Duck");
	}

	@Test
	void addMickeyMouse() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/") //
						.content(MICKEY_MOUSE_JSON) //
						.contentType(MediaType.APPLICATION_JSON) //
						.accept(MediaType.APPLICATION_JSON)) //
				.andExpect(MockMvcResultMatchers.status().isCreated());

		getRestResultAndAssert("Mickey", "Mouse");
	}

	private void getRestResultAndAssert(String firstName, String lastName) throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/all") //
						.accept(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(content().string(containsString(firstName))) //
				.andExpect(content().string(containsString(lastName)));
	}
}
