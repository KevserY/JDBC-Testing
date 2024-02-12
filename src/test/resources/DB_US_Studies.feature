Feature: UPDATE (update - delete - insert query)

  Background: Database connection
    * Database baglantisi kurulur.

    @query001
    Scenario: In the "Support_messages" table in the database,
              verify the "support_ticket_id" of the data
              whose "message" information is "Tickett".

      * Prepare the query001 and Execute.
      * The results of ResultSet001 are processed.
      * Database baglantisi kapatilir.