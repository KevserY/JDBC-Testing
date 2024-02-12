package stepDefinitions;

import com.github.javafaker.Faker;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
import io.cucumber.java.JavaBackendProviderService;
import io.cucumber.java.en.Given;
import manage.QueryManage;
import org.junit.Assert.*;
import utilities.JDBCReusableMethods;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefinition {
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    int rowCount;
    String query;
    QueryManage queryManage = new QueryManage();
    Faker faker = new Faker();
    //id, version, update_log, created_at, updated_at
    int id;
    String version;
    String update_log;
    int support_message_id;
    String attachment;



    // --- QUERY01 -----//
    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {
        JDBCReusableMethods.getConnection();
    }

    @Given("Query01 hazirlanir ve Execute edilir.")
    public void query01_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery01();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }

    @Given("ResultSet01 sonucları islenir.")
    public void result_set01_sonucları_islenir() throws SQLException {
        resultSet.next();  // iterator'ı 1. satıra koyduk
        int actualUserID = resultSet.getInt("user_id"); // 1. satırdaki bilgiyi aldık, actual'a atama yaptık.
        int expectedUserID = 1;
        assertEquals(actualUserID, expectedUserID);
    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {
        JDBCReusableMethods.closeConnection();
    }

    // --- QUERY02 -----//
    @Given("Query02 hazirlanir ve Execute edilir.")
    public void query02_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery02();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }

    @Given("ResultSet02 sonucları islenir.")
    public void result_set02_sonucları_islenir() throws SQLException {
        List<String> isimler = new ArrayList<>();
        while (resultSet.next()) {
            String isim = resultSet.getString("name");
            isimler.add(isim);
        }

        List<String> expectedName = new ArrayList<>();
        expectedName.add("5 Minutes");
        expectedName.add("10 Minutes");

        for (int i = 0; i < isimler.size(); i++) {
            assertEquals(expectedName.get(i), isimler.get(i));
        }
    }

    // --- QUERY03 -----//
    @Given("Query03 hazirlanir ve Execute edilir.")
    public void query03_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery03();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }

    @Given("ResultSet03 sonucları islenir.")
    public void result_set03_sonucları_islenir() throws SQLException {

        String expectedName = "Mehmet Genç";
        resultSet.next();
        String actualName = resultSet.getString("firstname") + " " + resultSet.getString("lastname");

        assertEquals(actualName, expectedName);
        System.out.println("expected= " + expectedName);
        System.out.println("actual= " + actualName);
    }

    // --- QUERY04-----//
    @Given("Query04 hazirlanir ve Execute edilir.")
    public void query04_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery04();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }

    @Given("ResultSet04 sonucları islenir.")
    public void result_set04_sonucları_islenir() throws SQLException {

        while (resultSet.next()) {
            String kullaniciID = resultSet.getString("user_id");
            String browserOS = resultSet.getString("browser_os");

            System.out.println("kullanici_id " + kullaniciID);
            System.out.println("Browser & OS " + browserOS);
        }
    }
    //-------- UPDATE QUERY 01 ---------//

    @Given("Update query01 hazirlanir ve Execute edilir.")
    public void update_query01_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getUpdateQuery05();
        rowCount = JDBCReusableMethods.getStatement().executeUpdate(query);
    }

    @Given("sonucları islenir.")
    public void sonucları_islenir() {
        assertEquals(18, rowCount);
        System.out.println(rowCount);
    }

    // ------- UPDATE QUERY 02 ---------//

    @Given("Prepared query02 hazirlanir ve Execute edilir.")
    public void prepared_query02_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getPreparedQuery05();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 333);
        preparedStatement.setString(2, "%e_");// dinamik
        rowCount = preparedStatement.executeUpdate();
    }

    @Given("Prepared query02 sonucları islenir.")
    public void prepared_query02_sonucları_islenir() {

        assertEquals(18, rowCount); // bu update işlemiyle kaç satır etkilenir:18
    }

    //-------- UPDATE QUERY 01 ---------//
    @Given("Prepared query03 hazirlanir ve Execute edilir.")
    public void prepared_query03_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getPreparedQuery06();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        // (id, email, token, status) veri girişi yapınız.
        preparedStatement.setInt(1, 887);
        preparedStatement.setString(2, "imail@gimail.com");
        preparedStatement.setString(3, "007JB");
        preparedStatement.setInt(4, 0);
        rowCount = preparedStatement.executeUpdate();
    }

    @Given("Prepared query03 sonucları islenir.")
    public void prepared_query03_sonucları_islenir() {
        assertEquals(1, rowCount);
    }

    // UPDATE and VERIFY QUERY 04

    @Given("Prepared query04 hazirlanir ve Execute edilir.")
    public void prepared_query04_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getPreparedQuery08();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 1);
        preparedStatement.setInt(2, 774);
        rowCount = preparedStatement.executeUpdate();
    }
    @Given("Prepared query04 sonucları doğrulanır.")
    public void prepared_query04_sonucları_doğrulanır() {
        assertEquals(1, rowCount);
    }


    // UPDATE QUERY 05
    @Given("update_logs tablosuna insert query hazirlanir ve calistirilir")
    public void update_logs_tablosuna_insert_query_hazirlanir_ve_calistirilir() throws SQLException {
        query = queryManage.getPreparedQuery09();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        id = faker.number().numberBetween(450,550);
        version = faker.options().option("windows 11", "MacOS Ventura","Linux");
        update_log = faker.lorem().sentence(1);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, version);
        preparedStatement.setString(3, update_log);
        preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
        preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
        //insert işlemini hazırladık.
        rowCount = preparedStatement.executeUpdate(); // execute edip, sonucu rowCount'a atadık.

        int flag = 0;
        if (rowCount > 0) {
            flag++;
        }
        rowCount = 0;
        assertEquals(1,flag);       //doğrulama yaptık
    }

    @Given("update_logs tablosuna insert edilen datanin update_log degeri degistirilir")
    public void update_logs_tablosuna_insert_edilen_datanin_update_log_degeri_degistirilir() throws SQLException {
        query = queryManage.getPreparedQuery09Update();
        String update_logYeni = "yeni girilen log degeri";

        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1, update_logYeni);
        preparedStatement.setString(2, version);
        preparedStatement.setInt(3, id);


        rowCount = preparedStatement.executeUpdate();

        System.out.printf("id: " + id);
    }

    @Given("update_log degerinin degistigi dogrulanir")
    public void update_log_degerinin_degistigi_dogrulanir() {
        assertEquals(1, rowCount);
    }

    // ---QUERY 10
    // insert data --> delete data --> verify data

    @Given("update_logs tablosuna insert edilen data silinir.")
    public void update_logs_tablosuna_insert_edilen_data_silinir() throws SQLException {
        query = queryManage.getPreparedQuery10();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        rowCount = preparedStatement.executeUpdate();
    }

    @Given("datanın silindigi dogrulanir")
    public void datanın_silindigi_dogrulanir() {
        assertEquals(1,rowCount);
    }

    // ---INSERT QUERY - DELETE QUERY


    @Given("support_attachments tablosuna insert query hazirlanir ve calistirilir")
    public void support_attachments_tablosuna_insert_query_hazirlanir_ve_calistirilir() throws SQLException {
        query = queryManage.getPreparedQueryInsert11();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        // yeni bir data ekleyelim
        // id, support_message_id, attachment, created_at
        id = faker.number().numberBetween(400,600);
        support_message_id = faker.number().numberBetween(50,60);
        attachment = faker.lorem().word();

        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2,support_message_id);
        preparedStatement.setString(3,attachment);
        preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));

        rowCount = preparedStatement.executeUpdate(); // execute edip, sonucu rowCount'a atadık.
        System.out.println("id: " + id);
        System.out.println("support_message_id: " + support_message_id);

        assertEquals(1,rowCount);

    }
    @Given("support_attachments tablosuna insert edilen data silinir.")
    public void support_attachments_tablosuna_insert_edilen_data_silinir() throws SQLException {

        query = queryManage.getPreparedQueryDelete11();
        preparedStatement= JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,support_message_id);

        rowCount = preparedStatement.executeUpdate();

        System.out.println("silinen datanın support_message_id' si : " + support_message_id);

    }
    @Given("Prepare the query001 and Execute.")
    public void prepare_the_query001_and_execute() throws SQLException {
        query = queryManage.getQuery_001();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

    }
    @Given("The results of ResultSet001 are processed.")
    public void the_results_of_result_set001_are_processed() throws SQLException {
        resultSet.next();

        int actualID = resultSet.getInt("support_ticket_id");
        int expectedID = 2;
        assertEquals(actualID,expectedID);

    }
}
