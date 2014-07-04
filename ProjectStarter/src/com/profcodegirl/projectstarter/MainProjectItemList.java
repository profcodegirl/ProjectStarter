package com.profcodegirl.projectstarter;

import com.profcodegirl.projectstarter.contentprovider.ProjectItemContentProvider;
import com.profcodegirl.projectstarter.database.ProjectItemTable;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.os.Build;
import android.database.Cursor;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;

public class MainProjectItemList extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_project_item_list);

		if (savedInstanceState == null)
		{
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_project_item_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		 switch (item.getItemId()) {
			    case R.id.insert:
			    	Intent i = new Intent(this, ProjectItemDetail.class);
			        startActivity(i);
			      return true;
			    }
			    return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends ListFragment implements
    LoaderManager.LoaderCallbacks<Cursor>
	{

		public PlaceholderFragment()
		{
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			View rootView = inflater.inflate(
					R.layout.fragment_main_project_item_list, container, false);
			return rootView;
		}
		
		//Happens on a long click to the list
		@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
				ContextMenuInfo menuInfo)
		{
			// TODO Auto-generated method stub
			super.onCreateContextMenu(menu, v, menuInfo);
			menu.add(0, Menu.FIRST + 1, 0, R.string.menu_delete);
		}
		
		
		@Override
		public void onListItemClick(ListView l, View v, int position, long id)
		{
			// TODO Auto-generated method stub
			super.onListItemClick(l, v, position, id);
		}

		@Override
		public Loader<Cursor> onCreateLoader(int id, Bundle args)
		{
			String[] projection = { ProjectItemTable.PROJECT_ITEM_ID, 
					                ProjectItemTable.PROJECT_ITEM_TITLE,
					                ProjectItemTable.PROJECT_ITEM_DESCRIPTION,
					                ProjectItemTable.PROJECT_ITEM_ICON,
					                ProjectItemTable.PROJECT_ITEM_START_DATE_TIME};
		    CursorLoader cursorLoader = new CursorLoader(this.getActivity(),ProjectItemContentProvider.CONTENT_URI,projection,null,null,null);
	
		    return cursorLoader;
		}

		@Override
		public void onLoadFinished(Loader<Cursor> loader, Cursor data)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onLoaderReset(Loader<Cursor> loader)
		{
			// TODO Auto-generated method stub
			
		}
	}

}
