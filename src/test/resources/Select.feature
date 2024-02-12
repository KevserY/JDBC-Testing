Feature: SELECT QUERY EXECUTE

  Background: Database baglantisi
    * Database baglantisi kurulur.
  @query01
  Scenario: deposits toblosunda "amount" değeri doğrulama.
    # Databasedeki "deposits" toblosunda "amount" değeri 100$ - 500$ arası olan user_id’leri doğrulayınız.

    * Query01 hazirlanir ve Execute edilir.
    * ResultSet01 sonucları islenir.
    * Database baglantisi kapatilir.

  @query02
  Scenario: "cron_schedules" tablosu "name" bilgisi doğrulama.
    # Databasedeki "cron_schedules" tablosunda ilk 2 kaydın "name" bilgisini doğrulayınız

    * Query02 hazirlanir ve Execute edilir.
    * ResultSet02 sonucları islenir.
    * Database baglantisi kapatilir.

  @query03
  Scenario: "users" tablosunda  "firstname" ve "lastname" bilgileri doğrulama.
    # Databasede "Users" tablosunda "country_code=TR" olmayan
    # ve "id=11" olan datanın "firstname" ve "lastname" bilgilerini doğrulayınız.

    * Query03 hazirlanir ve Execute edilir.
    * ResultSet03 sonucları islenir.
    * Database baglantisi kapatilir.

  @query04
  Scenario: "browser" ve "os" leri gruplayıp, yazdırma.
    #"user_logins" tablosunda "user_id" lere gore sisteme giris yapilan
    # "browser" ve "os" leri gruplayip ekrana yazdiriniz.

    * Query04 hazirlanir ve Execute edilir.
    * ResultSet04 sonucları islenir.
    * Database baglantisi kapatilir.






