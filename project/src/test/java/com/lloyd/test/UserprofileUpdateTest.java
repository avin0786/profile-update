package com.lloyd.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.lloyd.service.constants.Constants;
import com.lloyd.utils.Log;

/**
 * The Class UserprofileUpdateTest.
 *
 * @author aku279
 */
@WebAppConfiguration
public class UserprofileUpdateTest extends BaseTest {

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mock mvc. */
	private MockMvc mockMvc;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		Log.info("Test class started");

	}

	/**
	 * Testform.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testform() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"));

	}

	/**
	 * Test profile success.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testProfileSuccess() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/profileupdate").param("userId", "23456543").param("firstName", "dummy")
				.param("lastName", "dummy").param("email", "dummy@email.com").param("phone", "1234567890"))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute(Constants.MESSAGE, equalTo(Constants.PROFILE_UPDATE_SUCCESS)));
	}

	/**
	 * Test updation unsuccess.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testUpdationUnsuccess() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/profileupdate").param("userId", "23456543").param("firstName", "dummy")
				.param("lastName", "dummy").param("email", "dummy@email.com")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute(Constants.MESSAGE, equalTo(Constants.PROFILE_UPDATE_FAILURE)));
	}

	/**
	 * Test business exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testBusinessException() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/profileupdate").param("firstName", "dummy").param("lastName", "dummy")
				.param("email", "dummy@email.com").param("phone", "1234567890")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute(Constants.MESSAGE, equalTo("L200")));
	}

	/**
	 * Test valid first name.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testValidFirstName() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/profileupdate").param(Constants.INPUT_FIRST_NAME, "").param("email", "dummy@email.com"))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute(Constants.INPUT_FIRST_NAME, equalTo(Constants.FIRST_NAME_BLANK)));
	}

	/**
	 * Test email address.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testEmailAddress() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/profileupdate").param(Constants.INPUT_FIRST_NAME, "dummy").param("email", ""))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute(Constants.INPUT_EMAIL, equalTo(Constants.EMAIL_BLANK)));
	}

	/**
	 * Test valid email address.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testValidEmailAddress() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/profileupdate").param(Constants.INPUT_FIRST_NAME, "dummy").param("email", "dummy"))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute(Constants.INPUT_EMAIL, equalTo(Constants.VALID_EMAIL)));
	}

	/**
	 * Test valid email address and first name.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testValidEmailAddressAndFirstName() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/profileupdate").param(Constants.INPUT_FIRST_NAME, "").param("email", "dummy"))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute(Constants.INPUT_EMAIL, equalTo(Constants.VALID_EMAIL)))
				.andExpect(model().attribute(Constants.INPUT_FIRST_NAME, equalTo(Constants.FIRST_NAME_BLANK)));
	}

	/**
	 * Test first name and email.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFirstNameAndEmail() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/profileupdate").param(Constants.INPUT_FIRST_NAME, "").param("email", ""))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute(Constants.INPUT_EMAIL, equalTo(Constants.EMAIL_BLANK)))
				.andExpect(model().attribute(Constants.INPUT_FIRST_NAME, equalTo(Constants.FIRST_NAME_BLANK)));
	}

}