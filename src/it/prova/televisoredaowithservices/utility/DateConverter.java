package it.prova.televisoredaowithservices.utility;

public class DateConverter {
	public static java.sql.Date fromUtilToSql(java.util.Date data) {
		return new java.sql.Date(data.getTime());
	}

	public static java.util.Date fromSqlToUtil(java.sql.Date data) {
		return new java.util.Date(data.getTime());
	}
}
