package com.google.test;

import com.google.config.TestInitializer;
import com.google.page.ResultPage;
import org.junit.jupiter.api.Test;

import static com.google.config.PropertiesHolder.USERINFO_PROPERTIES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class TestGoogleTranslator extends TestInitializer {

    @Test
    void testTranslator() {
        String query = USERINFO_PROPERTIES.getProperty("test.text");
        String initialText = USERINFO_PROPERTIES.getProperty("test.pharse");
        String expectedTranslatedText = USERINFO_PROPERTIES.getProperty("test.translatedphrase");
        String language = USERINFO_PROPERTIES.getProperty("test.language");

        ResultPage resultPage = getMainPage()
                .searchByText(query)
                .selectSearchResultElement()
                .translateText(initialText, language);

        String actualTranslatedText = resultPage.getTranslatedText();

        //Check translated text
        assertTrue(actualTranslatedText.contains(expectedTranslatedText));
    }
}