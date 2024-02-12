Feature: UPDATE (update delete insert queryleri)

  Background: Database baglantisi
        * Database baglantisi kurulur.
    @update_query05
    Scenario: "mobile" numarası update etme
        # "users" tablosunda sondan bir önceki harfi e olan "usernamelerin"
        # "mobile" numarasını update ediniz

        * Update query01 hazirlanir ve Execute edilir.
        * sonucları islenir.
        * Database baglantisi kapatilir.


    @update_query06
    Scenario: "mobile" numarası update etme
        # "users" tablosunda sondan bir önceki harfi e olan "usernamelerin"
        # "mobile" numarasını update ediniz

        * Prepared query02 hazirlanir ve Execute edilir.
        * Prepared query02 sonucları islenir.
        * Database baglantisi kapatilir.

    @insert_query07
    Scenario: admin_password_resets tablosuna veri girişi
         # admin_password_resets tablosuna yeni
         # (id, email, token, status) veri girişi yapınız.

        * Prepared query03 hazirlanir ve Execute edilir.
        * Prepared query03 sonucları islenir.
        * Database baglantisi kapatilir.

    @update_query08
    Scenario: "is_read=0" Update etme
         # "id=?" olan kullanıcının "is_read=0" olan bildirimlerini
         # '1' Olarak Update edip doğrulayınız.

         * Prepared query04 hazirlanir ve Execute edilir.
         * Prepared query04 sonucları doğrulanır.
         * Database baglantisi kapatilir.

    @query09
    Scenario: "update_log" değeri Update etme
        # "update_logs" tablosunda "version=? " ve "id=?" olan datanın
        # "update_log" değerini update edip, doğrulayınız.

        * update_logs tablosuna insert query hazirlanir ve calistirilir
        * update_logs tablosuna insert edilen datanin update_log degeri degistirilir
        * update_log degerinin degistigi dogrulanir
        * Database baglantisi kapatilir.

      @query10
      Scenario: Update_logs tablosunda "id=?" değerine göre bir datayı siliniz ve silindiğini doğrulayınız

        * update_logs tablosuna insert query hazirlanir ve calistirilir
        * update_logs tablosuna insert edilen data silinir.
        * datanın silindigi dogrulanir
        * Database baglantisi kapatilir.

      @query11
      Scenario: "support_attachments" delete
        # "support_attachments" tablosunda "support_message_id=?" değerine göre
        # bir dosyayı siliniz ve silindiğini doğrulayınız.

        * support_attachments tablosuna insert query hazirlanir ve calistirilir
        * support_attachments tablosuna insert edilen data silinir.
        * datanın silindigi dogrulanir
        * Database baglantisi kapatilir.












