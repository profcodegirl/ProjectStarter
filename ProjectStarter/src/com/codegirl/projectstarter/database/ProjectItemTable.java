


package com.codegirl.projectstarter.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author Jennifer Bailey
 * This class was written to represent the 
 * 
 */
public class ProjectItemTable
{

	// Database table
	public static final String TABLE_PROJECT_ITEM = "projectitem";
	public static final String PROJECT_ITEM_ID = "ProjectItemID";
	public static final String PROJECT_ITEM_PARENT_ID = "ProjectItemParentID";
	public static final String PROJECT_ITEM_TITLE = "ProjectItemTitle";
	public static final String PROJECT_ITEM_DESCRIPTION = "ProjectItemDescription";
	public static final String PROJECT_ITEM_CREATION_DATE_TIME = "ProjectItemCreationDateTime";
	public static final String PROJECT_ITEM_START_DATE_TIME = "ProjectItemStartDateTime";
	public static final String PROJECT_ITEM_ICON = "ProjectItemIcon";

	// Database creation SQL statement
	private static final String DATABASE_CREATE = "create table " + TABLE_PROJECT_ITEM
			+ "(" 
			+ PROJECT_ITEM_ID + " integer primary key autoincrement, "
			+ PROJECT_ITEM_PARENT_ID + " integer default 0, " 
			+ PROJECT_ITEM_TITLE + " text, " 
			+ PROJECT_ITEM_DESCRIPTION + " text, " 
			+ PROJECT_ITEM_CREATION_DATE_TIME + " text, " 
			+ PROJECT_ITEM_START_DATE_TIME + " text, " 
			+ PROJECT_ITEM_ICON + " blob);";

	public static void onCreate(SQLiteDatabase database)
	{
		database.execSQL(DATABASE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion)
	{
		Log.w(ProjectItemTable.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECT_ITEM);
		onCreate(database);
	}
}