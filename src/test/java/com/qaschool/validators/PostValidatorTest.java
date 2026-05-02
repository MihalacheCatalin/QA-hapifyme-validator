package com.qaschool.validators;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostValidatorTest {

    private PostValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new PostValidator();
    }

    @DataProvider(name = "postDataProvider")
    public Object[][] postDataProvider() {
        return new Object[][]{
                {"Acesta este un post valid.", "POST_VALID"},
                {null, "ERROR_EMPTY"},
                {"", "ERROR_EMPTY"},
                {"Acest post vorbește despre politică.", "ERROR_FORBIDDEN"},
                {"A".repeat(251), "ERROR_TOO_LONG"} // Generează un string de 251 caractere
        };
    }

    @Test(dataProvider = "postDataProvider")
    public void testPostValidationScenarios(String postBody, String expectedStatus) {
        String actualStatus = validator.getPostStatus(postBody);
        Assert.assertEquals(actualStatus, expectedStatus, "Statusul returnat nu corespunde așteptărilor pentru input: " + postBody);
    }
}
