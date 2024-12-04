package com.example.btl.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_database.db";
    private static final int DATABASE_VERSION = 1;

    // Tên bảng và cột cho người dùng
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    // Câu lệnh SQL để tạo bảng người dùng
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_USERNAME + " TEXT PRIMARY KEY, " +
                    COLUMN_PASSWORD + " TEXT" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng người dùng
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng cũ và tạo lại bảng mới nếu cần nâng cấp cơ sở dữ liệu
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Thêm người dùng vào cơ sở dữ liệu
    public boolean addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Kiểm tra xem tên người dùng đã tồn tại chưa
        if (checkUsernameExists(username)) {
            return false; // Tên người dùng đã tồn tại
        }

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_USERS, null, values);
        return result != -1; // Trả về true nếu thêm thành công
    }

    // Kiểm tra thông tin đăng nhập của người dùng
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);

        boolean userExists = (cursor.getCount() > 0);
        cursor.close();
        return userExists;
    }

    // Kiểm tra xem tên người dùng đã tồn tại chưa (để dùng cho đăng ký)
    public boolean checkUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = { username };
        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);

        boolean usernameExists = (cursor.getCount() > 0);
        cursor.close();
        return usernameExists;
    }
}
