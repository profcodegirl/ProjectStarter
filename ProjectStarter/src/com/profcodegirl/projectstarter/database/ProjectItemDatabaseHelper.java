package com.profcodegirl.projectstarter.database;

/*Instead of copy and paste the source of the vogella tutorial,
I have let Eclipse generate most of this class for me by
utlizing the create class wizard and putting in SQLiteOpenHelper 
as the parent class, I then let the IDE generate the constructor
to correct an error, and I did add a few lines of codes and the
necessary constants.*/


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProjectItemDatabaseHelper extends SQLiteOpenHelper
{
	private static final String DATABASE_NAME = "ProjectStarter.db";
	private static final int DATABASE_VERSION = 1;
	
	
	public ProjectItemDatabaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		ProjectItemTable.onCreate(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		ProjectItemTable.onCreate(db);
	}

}
