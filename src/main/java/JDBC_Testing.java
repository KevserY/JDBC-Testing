import java.sql.*;

public class JDBC_Testing {
    /* Sizden JDBC sorgusu yapmanız istendiğinde yapacağınız ilk iş;
       DataBasa yöneticisi ile iletişime geçerek Access Information'ları almak.

type: jdbc:mysql
host/ip: 45.87.83.5
port: 3306
database_name: u168183796_qaloantec
username: u168183796_qaloantecuser
password: 0&vG1A/MuWN

url = jdbc:mysql://45.87.83.5/u168183796_qaloantec
username: u168183796_qaloantecuser
password: 0&vG1A/MuWN          */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. ADIM: Doğru sürücüyü yükle.
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. ADIM: Veri tabanı ile iletişimi başlat.
        Connection connection = DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qaloantec",
                                                            "u168183796_qaloantecuser",
                                                            "0&vG1A/MuWN");

        // 3. ADIM: SQL Query'leri oluştur.
        String query = "SELECT * FROM u168183796_qaloantec.users";
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // Statement oluşturmak için mutlaka bir connection olması gerekli.
        // create edilen statement bir query çalıştıracaksa, atama yapılmadan kullanılabilir.
        // Ancak, defalarca kullanılmak isteniliyorsa atama yapılması gerekir.

        // 4. ADIM: Query Execute et.
        ResultSet resultSet = statement.executeQuery(query);

        // 5. ADIM: Sonuçları işle.
        resultSet.next(); // resultSet, iterator mantığı ile çalışır.
                        // Bu satırda, iterator'ı ilk satıra koymuş olduk.

        System.out.println(resultSet.getString("firstname"));
        // Mehmet

        resultSet.next();
        System.out.println(resultSet.getString("firstname"));
        //Test

        resultSet.next();
        System.out.println(resultSet.getString("lastname"));
        // Genç  ---> 3. satır'ın lastname'i geldi.

        System.out.println(resultSet.getString("email"));
        // mcenkk@gmail.com --->>  iterator en son 3. satırdaydı. 3. satırdaki email bilgisini getirdi.

        resultSet.absolute(10); // 10. satırdan data almak stediğimizde
        System.out.println(resultSet.getString("firstname"));
        // 10. satırdaki isim : Ahmet

        // en son 10. satırdayım, 1. satıra tekrar nasıl dönerim?
        System.out.println(resultSet.first()); // iterator şimdi ilk satırda.sonuç boolean döner -- > true

        System.out.println(resultSet.getString("email"));
        // 1. satırdaki email geldi --> elff931@gmail.com

    }
}
