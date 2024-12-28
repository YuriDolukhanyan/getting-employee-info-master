package com.epam.rd.autotasks;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class DbManager {

	private DbManager() {
		throw new UnsupportedOperationException();
	}

	public static int callCountDepartments(Connection connection) throws SQLException {
		String procedureCall = "{CALL COUNT_DEPARTMENTS(?)}";
		try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.execute();
			return callableStatement.getInt(1);
		}
	}

	public static int callCountEmployees(Connection connection) throws SQLException {
		String procedureCall = "{CALL COUNT_EMPLOYEES(?)}";
		try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.execute();
			return callableStatement.getInt(1);
		}
	}

	public static int callCountEmployeesByDepartmentId(Connection connection, int departmentId) throws SQLException {
		String procedureCall = "{CALL COUNT_EMPLOYEES_BY_DEPARTMENT_ID(?, ?)}";
		try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
			callableStatement.setInt(1, departmentId);
			callableStatement.registerOutParameter(2, Types.INTEGER);
			callableStatement.execute();
			return callableStatement.getInt(2);
		}
	}
}