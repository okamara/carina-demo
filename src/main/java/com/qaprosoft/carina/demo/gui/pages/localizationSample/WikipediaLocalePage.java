/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages.localizationSample;

import com.qaprosoft.carina.core.foundation.utils.resources.L10Nparser;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WikipediaLocalePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='{L10N:HomePage.welcomeTextId}' or @class='welcome-title']")
    private ExtendedWebElement welcomeText;

    @FindBy(id = "pt-anoncontribs")
    private ExtendedWebElement contribElem;

    @FindBy(id = "pt-createaccount")
    private ExtendedWebElement createAccountElem;

    @FindBy(id = "pt-anontalk")
    private ExtendedWebElement discussionElem;

    @FindBy(linkText = "{L10N:discussionElem}")
    private ExtendedWebElement discussionBtn;

    public String getDiscussionText(){
        if (discussionBtn.isPresent()) {
            return discussionBtn.getText();
        }
        return "";
    }

    public WikipediaLocalePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkMultipleLocalization() {
        ExtendedWebElement[] localizationCheckList = {discussionElem, createAccountElem, contribElem};
        return L10Nparser.checkMultipleLocalization(localizationCheckList);
    }

    public String getWelcomeText(){
        if (welcomeText.isPresent()) {
            return welcomeText.getText();
        }
        return "";
    }

    public void clickDiscussionBtn() {
        discussionElem.click();
    }
}
