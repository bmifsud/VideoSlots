package com.videoslots.ui.steps;

import com.videoslots.ui.model.Notes;
import com.videoslots.ui.steps.base.BaseStep;
import com.videoslots.ui.steps.commons.StepContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(classes= StepContext.class)
public class NotesSteps extends BaseStep {

    @Autowired
    private StepContext stepContext;

    private UUID uuid = UUID.randomUUID();
    private Notes note = new Notes("Title: "+ uuid,"Content: "+ uuid);

    public NotesSteps(StepContext stepContext) {
        super(stepContext.getDriver());
    }

    @And("^the user starts creating a new Note$")
    public void theUserStartsCreatingANewNote() throws Throwable {
        try {
            findElement("#qa-CREATE_NOTE",
                    Pather.cssSelector,TimeOut.MIDDLE);
            findElementClick("#qa-CREATE_NOTE",
                    Pather.cssSelector);
            findElementClick("#ActionMenu > ul> li:nth-child(1) > button > span",
                    Pather.cssSelector);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @When("^the user fills in the random title and random content of the note$")
    public void theUserFillsInTheRandomTitleAndRandomContentOfTheNote() throws Throwable {
        try {

            //Waits for Iframe to load
            waitForIFrameToLoad("#qa-COMMON_EDITOR_IFRAME",
                    Pather.cssSelector,
                    TimeOut.MIDDLE);
            //Select note frame
            SelectFrame("#qa-COMMON_EDITOR_IFRAME",
                    Pather.cssSelector);

            //Fills note
            findElement("/html/body/en-noteheader/div/div[2]/textarea",
                    Pather.xPath,
                    TimeOut.MIDDLE).sendKeys(note.getTitle());

            findElement("/html/body/en-note",
                    Pather.xPath,
                    TimeOut.MIDDLE).sendKeys(note.getContent());

            //Selects default frame to resume steps
            stepContext.getDriver().switchTo().defaultContent();

            //Navigates to notes
            findElementClick("#qa-NAV_ALL_NOTES > div > span",
                    Pather.cssSelector);


            //Waits for Evernote to sync. It waits for text to show up within the list element before test resumes
            waitForTextToBePresentInElement("(//div[1]/div[2]/div/span)[1]",
                    Pather.xPath,
                    TimeOut.HIGH,
                    note.getContent());


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @When("the user view notes from the side menu")
    public void the_user_view_notes_from_the_side_menu() {
        //Navigates to notes
        findElementClick("#qa-NAV_ALL_NOTES > div > span",
                Pather.cssSelector);
    }

    @Then("the note is still visible and available.")
    public void the_note_is_still_visible_and_available() {
        //Waits for Iframe to load
        waitForIFrameToLoad("#qa-COMMON_EDITOR_IFRAME",
                Pather.cssSelector,
                TimeOut.HIGH);
        //Select note frame
        SelectFrame("#qa-COMMON_EDITOR_IFRAME",
                Pather.cssSelector);

        //Confirms Title and Note Content
        if(!findElement("body > en-noteheader > div > div.P0rnC > textarea",
                Pather.cssSelector,
                TimeOut.MIDDLE).getAttribute("value").equals(note.getTitle())
           || !findElement("#en-note > div",
                Pather.cssSelector,
                TimeOut.MIDDLE).getText().equals(note.getContent())){
            Assert.fail();
            DriverQuit();
        }

        //Selects default frame to resume steps
        stepContext.getDriver().switchTo().defaultContent();
    }

    @And("^the user deletes the note$")
    public void theUserDeletesTheNote() throws Throwable {
        try {
            findElementClick("#qa-NOTE_ACTIONS",
                    Pather.cssSelector);
            findElementClick("#qa-ACTION_DELETE > div > span > span",
                    Pather.cssSelector);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
