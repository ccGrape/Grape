package com.doubleC.grape.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "grape.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "grape_table";
	public static final String GRAPE_ID = "grape_id";
	public static final String GRAPE_NAME = "grape_name";
	public static final String GRAPE_DESCRIPTION = "grape_description";

	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// create table
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table " + TABLE_NAME + " (" + GRAPE_ID
				+ " INTEGER primary key autoincrement,"
				+ GRAPE_NAME + " text,"
				+ GRAPE_DESCRIPTION + " text);";
		Log.d("fcc", sql);
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROPE TABLE IF EXISTS" + TABLE_NAME;
		db.execSQL(sql);
		onCreate(db);
	}

	public Cursor select() {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db
				.query(TABLE_NAME, null, null, null, null, null, null);
		return cursor;
	}

	public long insert(String grapeName, String grapeDescription) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(GRAPE_NAME, grapeName);
		contentValues.put(GRAPE_DESCRIPTION, grapeDescription);
		long num = db.insert(TABLE_NAME, null, contentValues);
		return num;
	}

	public void delete(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		String where = GRAPE_ID + "=?";
		String[] whereValues = { String.valueOf(id) };

		db.delete(TABLE_NAME, where, whereValues);
	}

	public void update(int id, String grapeName, String grapeDescription) {
		SQLiteDatabase db = this.getWritableDatabase();
		String where = GRAPE_ID + "=?";

		String[] whereValues = { String.valueOf(id) };

		ContentValues contentValues = new ContentValues();
		contentValues.put(GRAPE_NAME, grapeName);
		contentValues.put(GRAPE_DESCRIPTION, grapeDescription);

		db.update(TABLE_NAME, contentValues, where, whereValues);
	}
}
