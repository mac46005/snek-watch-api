package com.preciado.snek_watch_api.service;

public class SqlStatementCreator {
    public static String InsertStatement(String tableName, String ...columns) {
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
}
