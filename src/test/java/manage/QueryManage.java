package manage;

public class QueryManage {

    private String query01 = "SELECT user_id FROM u168183796_qaloantec.deposits WHERE amount BETWEEN 100 AND 500;";
    private String query02 = "SELECT name FROM u168183796_qaloantec.cron_schedules LIMIT 2;";
    private String query03 = "SELECT firstname, lastname FROM u168183796_qaloantec.users WHERE country_code NOT LIKE 'TR' AND id= '11';";
    private String query04 = "SELECT user_id, group_concat(browser, ' - ', os) AS browser_os FROM u168183796_qaloantec.user_logins GROUP BY user_id;";
    private String updateQuery05 = "UPDATE users SET mobile = 232323 WHERE username LIKE '%e_';";
    private String preparedQuery05 = "UPDATE users SET mobile = ? WHERE username LIKE ?";
    private String preparedQuery06 = "INSERT INTO admin_password_resets (id, email, token, status) VALUES (?, ?, ?, ?);";
    private String preparedQuery08 = "UPDATE u168183796_qaloantec.admin_notifications SET is_read = ? WHERE id = ?;";
    private String preparedQuery09 = "INSERT INTO u168183796_qaloantec.update_logs (id, version, update_log, created_at, updated_at) VALUES (?,?,?,?,?)";
    private String preparedQuery09Update = "UPDATE u168183796_qaloantec.update_logs SET update_log =? WHERE version =?, id =?";
    private String preparedQuery10 = "DELETE FROM u168183796_qaloantec.update_logs WHERE id =?;";

    private String preparedQueryInsert11 = "insert into u168183796_qaloantec.support_attachments (id, support_message_id, attachment, created_at) values (?,?,?,?);";
    private String preparedQueryDelete11 = "delete from u168183796_qaloantec.support_attachments where support_message_id = ?;";

    private String query_001 = "SELECT support_ticket_id FROM support_messages WHERE message = 'Tickett';";




    // --------- GETTER --------- //

    public String getQuery01() {return query01; }
    public String getQuery02() {return query02;}
    public String getQuery03() {return query03;}
    public String getQuery04() {return query04;}
    public String getUpdateQuery05() {return updateQuery05;}
    public String getPreparedQuery05() {return preparedQuery05;}
    public String getPreparedQuery06() {return preparedQuery06;}
    public String getPreparedQuery08() {return preparedQuery08;}
    public String getPreparedQuery09() {return preparedQuery09;}
    public String getPreparedQuery09Update() {return preparedQuery09Update;}
    public String getPreparedQuery10() {return preparedQuery10;}
    public String getPreparedQueryInsert11() {return preparedQueryInsert11;}
    public String getPreparedQueryDelete11() {return preparedQueryDelete11;}

    public String getQuery_001() {
        return query_001;
    }
}

