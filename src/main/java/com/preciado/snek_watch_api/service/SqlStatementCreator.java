package com.preciado.snek_watch_api.service;

public class SqlStatementCreator {
    public static String createInsertStatement(String tableName, String ...columns) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(tableName);
        sb.append(" (");
        for (String string : columns) {
            sb.append(string + ", ");
        }
        sb = sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append(") VALUES (");
        
        for(int i = 0; i <= columns.length - 1; i++) {
            sb.append("?, ");
        }

        sb = sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append(");");

        return sb.toString();
    }


    public static String createSelectStatement(String tableName, String constraint, String ...columns) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT ");
        if (columns.length == 0) {
            sb.append("*");
        } else {
            for (String column: columns) {
                sb.append(column + ", ");
            }

            sb = new StringBuilder(sb.substring(0, sb.length() - 2));

            sb.append(" FROM " + tableName);
            if (!constraint.equals("")) {
                sb.append(" " + constraint);
            }
            sb.append(";");
        }
        return sb.toString();
    }
}
