import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws Exception {
        // All the 7 steps
        // 1.import package that is  import java.sql.*;


        // 2.Load & Register Driver
        Class.forName("org.postgresql.Driver");

        //3. Create a Connection
        String url="jdbc:postgresql://localhost:5432/Demo";
        String Username="postgres";
        String pass="1234";

        int Sid=101;
        String Sname="Max";
        int Mark=78;

        String sql = "insert into student values (?,?,?)";

        Connection con=DriverManager.getConnection(url,Username,pass);
        System.out.println("Connection Established");

        PreparedStatement st= con.prepareStatement(sql);
        st.setInt(1,Sid);
        st.setString(2,Sname);
        st.setInt(3,Mark);
        st.execute();


        //ResultSet res=st.executeQuery(sql);
//        boolean status=st.execute(sql);
//        System.out.println(status);



//        res.next();
//        String name=res.getString("Sname");
//        System.out.println("name of a student is :"+name);

//        while (res.next()){
//            System.out.print(res.getInt(1)+" -");
//            System.out.print(res.getString(2)+" -");
//            System.out.println(res.getInt(3));
//        }


        con.close();


    }
}
