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


    // TODO '?' is used instead of whole values but column name is needed so: column_2 = ?, ...
    public static String createUpdateStatement(String tableName, String constraint, String ...columns) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE " + tableName);
        sb.append(" SET ");

        for(String column: columns) {
            sb.append(column + " = ?, ");
        }

        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append(" " + constraint);
        sb.append(";");
        return sb.toString();
    }

    public static String createDeleteStatement(String tableName, String constraint) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM " + tableName + " " + constraint + ";");
        return sb.toString();
    }

    public static class Set{
        private boolean isString;
        private String value;
        private String columnName;

        
        public Set(boolean isString, String value, String columnName) {
            this.isString = isString;
            this.value = value;
            this.columnName = columnName;
        }

        public boolean isString() {
            return isString;
        }
        public void setString(boolean isString) {
            this.isString = isString;
        }
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getColumnName() {
            return columnName;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
    }
}
