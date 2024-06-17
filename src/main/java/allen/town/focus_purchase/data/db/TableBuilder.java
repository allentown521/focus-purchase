package allen.town.focus_purchase.data.db;

import java.util.List;

import allen.town.focus_common.util.Lists;

public class TableBuilder {
    public static final int FLAG_AUTOINCREMENT = 2;
    public static final int FLAG_COLLATE_NOCASE = 8;
    public static final int FLAG_NOT_NULL = 4;
    public static final int FLAG_PRIMARY_KEY = 1;
    public static final String FOREIGN_KEY_CASCADE = "CASCADE";
    public static final String FOREIGN_KEY_NO_ACTION = "NO ACTION";
    public static final String FOREIGN_KEY_RESTRICT = "RESTRICT";
    public static final String TYPE_BOOL = "INTEGER";
    public static final String TYPE_INTEGER = "INTEGER";
    public static final String TYPE_TEXT = "TEXT";
    private StringBuilder mBuilder;
    private List<String> mForeignKeys = Lists.emptyList();
    private List<String> mPrimaryKeyColumns = Lists.emptyList();
    private String mTableName;
    private List<String> mUniqueColumns = Lists.emptyList();

    public TableBuilder(String str) {
        this.mTableName = str;
    }

    public TableBuilder setTableName(String str) {
        this.mTableName = str;
        return this;
    }

    public TableBuilder addTextColumn(String str) {
        return addColumn(str, TYPE_TEXT, 0);
    }

    public TableBuilder addTextColumn(String str, int i) {
        return addColumn(str, TYPE_TEXT, i);
    }

    public TableBuilder addIntegerColumn(String str) {
        return addColumn(str, "INTEGER", 0);
    }

    public TableBuilder addIntegerColumn(String str, int i) {
        return addColumn(str, "INTEGER", i);
    }

    public TableBuilder addBooleanColumn(String str) {
        return addColumn(str, "INTEGER", 0);
    }

    public TableBuilder addBooleanColumn(String str, int i) {
        return addColumn(str, "INTEGER", i);
    }

    public TableBuilder addColumn(String str, String str2) {
        return addColumn(str, str2, 0);
    }

    public TableBuilder addColumn(String str, String str2, int i) {
        StringBuilder sb = this.mBuilder;
        if (sb == null) {
            this.mBuilder = new StringBuilder();
            StringBuilder sb2 = this.mBuilder;
            sb2.append("CREATE TABLE ");
            sb2.append(this.mTableName);
            sb2.append(" (");
        } else {
            sb.append(", ");
        }
        StringBuilder sb3 = this.mBuilder;
        sb3.append(str);
        sb3.append(" ");
        sb3.append(str2);
        if ((i & FLAG_PRIMARY_KEY) != 0) {
            this.mBuilder.append(" primary key ");
        }
        if ((i & FLAG_AUTOINCREMENT) != 0) {
            this.mBuilder.append(" autoincrement ");
        }
        if ((i & FLAG_NOT_NULL) != 0) {
            this.mBuilder.append(" not null ");
        }
        if ((i & FLAG_COLLATE_NOCASE) != 0) {
            this.mBuilder.append(" collate nocase ");
        }
        return this;
    }

    public TableBuilder addPrimaryKeyColumn(String str) {
        this.mPrimaryKeyColumns.add(str);
        return this;
    }

    public TableBuilder addForeignKey(String str, String str2, String str3, String str4) {
        this.mForeignKeys.add(String.format("FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE %s", str, str2, str3, str4));
        return this;
    }

    public TableBuilder addForeignKey(String[] strArr, String str, String[] strArr2, String str2) {
        int length = strArr.length;
        String str3 = "FOREIGN KEY(";
        for (int i = 0; i < length; i++) {
            str3 = str3 + strArr[i];
            if (i < strArr.length - 1) {
                str3 = str3 + ", ";
            }
        }
        String str4 = str3 + ") REFERENCES " + str + "(";
        int length2 = strArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            str4 = str4 + strArr2[i2];
            if (i2 < strArr2.length - 1) {
                str4 = str4 + ", ";
            }
        }
        this.mForeignKeys.add(str4 + ") ON DELETE " + str2);
        return this;
    }

    public TableBuilder addUniqueColumns(String... strArr) {
        for (String str : strArr) {
            this.mUniqueColumns.add(str);
        }
        return this;
    }

    public String build() {
        if (!this.mPrimaryKeyColumns.isEmpty()) {
            this.mBuilder.append(", PRIMARY KEY (");
            int size = this.mPrimaryKeyColumns.size();
            for (int i = 0; i < size; i++) {
                this.mBuilder.append(this.mPrimaryKeyColumns.get(i));
                if (i < this.mPrimaryKeyColumns.size() - 1) {
                    this.mBuilder.append(", ");
                }
            }
            this.mBuilder.append(")");
        }
        if (!this.mForeignKeys.isEmpty()) {
            this.mBuilder.append(", ");
            int size2 = this.mForeignKeys.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.mBuilder.append(this.mForeignKeys.get(i2));
                if (i2 < this.mForeignKeys.size() - 1) {
                    this.mBuilder.append(", ");
                }
            }
        }
        if (!this.mUniqueColumns.isEmpty()) {
            this.mBuilder.append(", UNIQUE (");
            int size3 = this.mUniqueColumns.size();
            for (int i3 = 0; i3 < size3; i3++) {
                this.mBuilder.append(this.mUniqueColumns.get(i3));
                if (i3 < this.mUniqueColumns.size() - 1) {
                    this.mBuilder.append(", ");
                }
            }
            this.mBuilder.append(")");
        }
        StringBuilder sb = this.mBuilder;
        sb.append(" ); ");
        return sb.toString();
    }
}
