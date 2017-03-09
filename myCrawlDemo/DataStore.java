package myCrawlDemo;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DataStore {

	public void store(List<Integer> list, List<String> list1, List<Double> list2) throws Exception {
		String driverClassName = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3306/douban";

		String username = "root";

		String password = "123";
		// ����������
		Class.forName(driverClassName);
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		// ����sql���ģ��
		String sql = "INSERT MOVIE VALUES(?,?,?)";
		// ����һ����������
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
		// ��ѭ����������ӵ�sqlģ����
		for (int i = 0; i < list.size(); i++) {
			pst.setInt(1, list.get(i));
			pst.setString(2, list1.get(i));
			pst.setDouble(3, list2.get(i));

			pst.addBatch();
		}
		// ��sql��䷢�͵�mysql��
		int[] res = pst.executeBatch();
		System.out.println(res);
		pst.close();
	}
}
