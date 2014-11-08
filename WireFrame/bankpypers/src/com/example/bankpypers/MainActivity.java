package com.example.bankpypers;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {

	private String[] tabs = {"Home","Forms","Portfolio"};
	 static Context m;
	
	ImageButton voice;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private String mTitle;
	FragmentManager fragmentManager;
	Fragment fragment;
	
	private static final int REQUEST_CODE = 1234;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        m=getApplicationContext();
        
        fragmentManager=getSupportFragmentManager();
		fragment = new HomeFragment();
		Bundle args = new Bundle();
		//args.putInt(AboutUs.ARG_TAB_NUMBER, 1);
		fragment.setArguments(args);
		fragmentManager.beginTransaction()
		.replace(R.id.content_frame, fragment)
		.commit();
		
		voice=(ImageButton)findViewById(R.id.voice);
		voice.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(!checkVoiceRecognition()) Toast.makeText(getApplicationContext(),
						"No voice recogniton software",Toast.LENGTH_SHORT).show();
				else
					startVoiceRecognitionActivity();
			}
				
			
		});

  
    
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	mDrawerList = (ListView) findViewById(R.id.left_drawer);
	mTitle = "BankPypers";
	getActionBar().setTitle(mTitle);
	mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
			R.drawable.ic_sidebar, 0, 0 ) {

		/** Called when a drawer has settled in a completely closed state. */
		public void onDrawerClosed(View view) {
			super.onDrawerClosed(view);
			invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
		}

		/** Called when a drawer has settled in a completely open state. */
		public void onDrawerOpened(View drawerView) {
			super.onDrawerOpened(drawerView);
			invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
		}
	};

	// Set the drawer toggle as the DrawerListener
	mDrawerLayout.setDrawerListener(mDrawerToggle);
	getActionBar().setDisplayHomeAsUpEnabled(true);
	getActionBar().setHomeButtonEnabled(true);
	// Set the adapter for the list view
	mDrawerList.setAdapter(new ArrayAdapter<String>(this,
			R.layout.navigation_layout, tabs));
	// Set the list's click listener
	mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


}

public boolean checkVoiceRecognition() {
	  // Check if voice recognition is present
	  PackageManager pm = getPackageManager();
	  List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
	    RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
	  if (activities.size() == 0) return false;
	  else return true;
	 
	 }

private void startVoiceRecognitionActivity()
{
	  Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	 
	  // Specify the calling package to identify your application
	  intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass()
	    .getPackage().getName());
	 
	  
	  
	  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	 
	  startActivityForResult(intent, REQUEST_CODE);
}

	 
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
  if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
  {
      // Populate the wordsList with the String values the recognition engine thought it heard
      ArrayList<String> matches = data.getStringArrayListExtra(
              RecognizerIntent.EXTRA_RESULTS);
     // Toast.makeText(m, "yo",Toast.LENGTH_SHORT).show();
     if(matches.equals(null))
    	  Toast.makeText(m, "null",Toast.LENGTH_SHORT).show();
      else
    	  Toast.makeText(m, matches.get(0),Toast.LENGTH_SHORT).show();
    	 
      //wordsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        //      matches));
  }
  super.onActivityResult(requestCode, resultCode, data);
}


/** Swaps fragments in the main content view */
private void selectItem(int position) {
	// Create a new fragment and specify the planet to show based on position
	Fragment fragment = null ;
	Bundle args = new Bundle();
	switch(position)
	{
	case 0:
		fragment = new HomeFragment();
		fragment.setArguments(args);
		break;
		
	case 1:fragment = new FormsFragment();
	fragment.setArguments(args);
	break;
		
	case 2:
		
	case 3:

	}


	// Insert the fragment by replacing any existing fragment
	fragmentManager.beginTransaction()
	.replace(R.id.content_frame, fragment)
	.commit();

	// Highlight the selected item, update the title, and close the drawer
	mDrawerList.setItemChecked(position, true);
	mDrawerLayout.closeDrawer(mDrawerList);
}

@Override
protected void onPostCreate(Bundle savedInstanceState) {
	super.onPostCreate(savedInstanceState);
	// Sync the toggle state after onRestoreInstanceState has occurred.
	mDrawerToggle.syncState();
}

@Override
public void onConfigurationChanged(Configuration newConfig) {
	super.onConfigurationChanged(newConfig);
	mDrawerToggle.onConfigurationChanged(newConfig);
}

public class DrawerItemClickListener implements ListView.OnItemClickListener {
	@Override
	public void onItemClick(AdapterView parent, View view, int position, long id) {
		selectItem(position);
	}
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
    

