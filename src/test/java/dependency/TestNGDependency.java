package dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDependency

{
	@Test(priority = 1, dependsOnMethods = { "advacnedsearch", "logout" })
	void openapp() {
		Assert.assertTrue(true);
	}

	@Test(priority = 2, dependsOnMethods = { "openapp" })
	void login() {
		Assert.assertTrue(false);
	}

	@Test(priority = 3, dependsOnMethods = { "openapp", "login" })
	void search() {
		Assert.assertTrue(true);
	}

	@Test(priority = 4, dependsOnMethods = { "login" })
	void advacnedsearch() {
		Assert.assertTrue(true);
	}

	@Test(priority = 5, dependsOnMethods = { "login" })
	void logout() {
		Assert.assertTrue(true);
	}
}
