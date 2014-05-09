package com.example.telecombretagne;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	System.out.println ("execution de la methode onCreate de MainActivity");
        
    	super.onCreate(savedInstanceState);
        
    	setContentView(R.layout.activity_main);
        System.out.println ("execution de la methode onCreate de MainActivity : ContentView set");

        if (savedInstanceState == null) {
        	System.out.println ("execution onCreate MainActivity : savedInstanceState == null");
        	
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
//	    // Make sure we're running on Honeycomb or higher to use ActionBar APIs
//	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//	        // For the main activity, make sure the app icon in the action bar
//	        // does not behave as a button
//	        android.app.ActionBar actionBar = getActionBar();
//	        System.out.println ("execution onCreate MainActivity : actionBar got");
//	        actionBar.setHomeButtonEnabled(false);
//	    }
	    
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        System.out.println ("execution de la methode onCreateOptionsMenu de MainActivity : menuInflater get");

        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	// Handle presses on the action bar items
    	
        switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
            case android.R.id.home:
            	Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;


            case R.id.contacts:
                Intent contacts = new Intent(this, Contacts.class);
                
                System.out.println ("lancement de l activite Contacts");
                startActivity(contacts);
                return true;
            
            case R.id.gerer_notifications:
                Intent gerer_notifications = new Intent(this, GererNotifications.class);
                
                System.out.println ("lancement de l activite Contacts");
                startActivity(gerer_notifications);
                return true;
            
            case R.id.formations_debouches:
                Intent formations_debouches = new Intent(this, FormationsDebouches.class);
                
                System.out.println ("lancement de l activite FormationsDebouches");
                startActivity(formations_debouches);
                return true;
            
            case R.id.formations_fig:
                Intent formations_fig = new Intent(this, FormationsFIG.class);
                
                System.out.println ("lancement de l activite FormationsFIG");
                startActivity(formations_fig);
                return true;
            
            case R.id.formations_fip:
                Intent formations_fip = new Intent(this, FormationsFIP.class);
                
                System.out.println ("lancement de l activite FormationsFIP");
                startActivity(formations_fip);
                return true;
            
            case R.id.accueil:
                Intent main_activity = new Intent(this, MainActivity.class);
                
                System.out.println ("lancement de l activite MainActivity");
                startActivity(main_activity);
                return true;
            
            case R.id.procedure_ast:
                Intent procedure_ast = new Intent(this, ProcedureAST.class);
                
                System.out.println ("lancement de l activite ProcedureAST");
                startActivity(procedure_ast);
                return true;
            
            case R.id.procedure_fip:
                Intent procedure_fip = new Intent(this, ProcedureFIP.class);
                
                System.out.println ("lancement de l activite ProcedureFIP");
                startActivity(procedure_fip);
                return true;
            
            case R.id.procedure_prepa:
                Intent procedure_prepa = new Intent(this, ProcedurePrepa.class);
                
                System.out.println ("lancement de l activite ProcedurePrepa");
                startActivity(procedure_prepa);
                return true;
            
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
//
//    public void accueil (View view){
//    	Intent intent = new Intent(this, MainActivity.class);
//    	//TODO : manque peut etre des trucs : cf tuto
//    	startActivity(intent);
//    }
//    public void formationsFIG (View view){
//    	Intent intent = new Intent(this, FormationsFIG.class);
//    	//TODO : manque peut etre des trucs : cf tuto
//    	startActivity(intent);
//    }
//    
//    public void formationsFIP (View view){
//    	Intent intent = new Intent(this, FormationsFIP.class);
//    	//TODO : manque peut etre des trucs : cf tuto
//    	startActivity(intent);
//    }
//       
//    public void formationsDebouches (View view){
//    	Intent intent = new Intent(this, FormationsDebouches.class);
//    	//TODO : manque peut etre des trucs : cf tuto
//    	startActivity(intent);
//    }
//    
//    public void procedurePrepa (View view){
//    	Intent intent = new Intent(this, ProcedurePrepa.class);
//    	//TODO : manque peut etre des trucs : cf tuto
//    	startActivity(intent);
//    }
//    
//    public void procedureAST (View view){
//    	Intent intent = new Intent(this, ProcedureAST.class);
//    	//TODO : manque peut etre des trucs : cf tuto
//    	startActivity(intent);
//    }
//    
//    public void procedureFIP (View view){
//    	Intent intent = new Intent(this, ProcedureFIP.class);
//    	//TODO : manque peut etre des trucs : cf tuto
//    	startActivity(intent);
//    }
//    
//    public void contacts (View view){
//    	Intent intent = new Intent(this, Contacts.class);
//    	System.out.println ("execution de la methode contacts");
//    	//TODO : manque peut etre des trucs : cf tuto
//    	startActivity(intent);
//    }
//    public void gererNotifications (View view){
//    	Intent intent = new Intent(this, GererNotifications.class);
//    	//TODO : manque peut etre des trucs : cf tuto
//    	startActivity(intent);
//    }
    
    public void lienLexians (View view) {
    	 Uri webpage = Uri.parse("http://www.telecom-bretagne.eu/lexians/");
         Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

         // Verify it resolves
         PackageManager packageManager = getPackageManager();
         List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
         boolean isIntentSafe = activities.size() > 0;

         // Start an activity if it's safe
         if (isIntentSafe) {
         	startActivity(webIntent);
         }
    }
    
    public void lienCampuschannel (View view) {
    	Uri webpage = Uri.parse("http://www.campus-channel.com/telecom-bretagne-programme-ingenieur-prepas.html");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
        	startActivity(webIntent);
        }
   }

}
