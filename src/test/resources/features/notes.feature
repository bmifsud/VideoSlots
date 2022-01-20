Feature: Notes
  @UI @notes
  Scenario: User attempt to a create note and reconfirming the note post logout.
    Given the user is logged in Evernote
    And the user starts creating a new Note
    When the user fills in the random title and random content of the note
    And the user logs out and back in again
    And the user view notes from the side menu
    Then the note is still visible and available.
    And the user deletes the note
    And the user exits with logout

