# Hibernate *Curd Operation* With *Mysql*
---
##### This is basic hibernate project **From the scratch** with latest version of  Eclipse.


 In this project you need to dawnload latest version of [HIBERNATE JAR][df1] 

  - [hibernate.cfg.xml][df2] You must have use this configration file.
  - Inside this configuration file you need to set according to your envirnmet.
  ---
 SEE BELOW CODE
  ```
  <session-factory>
        <!-- JDBC Database connection settings -->
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false</property>
        <!--Your database user name-->
        <property name="connection.username">XXXXXX</property>
        <!--Your database user password-->
        <property name="connection.password">XXXXXXXXX</property>
        <!-- JDBC connection pool settings ... using built-in test pool -->
        <property name="connection.pool_size">1</property>
        <!-- Select our SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
        <!-- Echo the SQL to stdout -->
        <property name="show_sql">true</property>
		<!-- Set the current session context -->
		<property name="current_session_context_class">thread</property>
    </session-factory>
  ```
  - This is the basic configuration of hibernate project.
  
-Finally you can download this material and import in your **Eclipse IDE** and Enjoy with this  **HIBERNATE BASIC CURD OPERATION**.

#THANKS FOR YOUR PATIENCE.

   [df1]: <http://hibernate.org/orm/>
   [df2]: <https://github.com/shaileshkumarcs/hibernate-tutorial/tree/master/Hibernate-tutorial/bin/>

