package com.example.bankpypers;


import java.util.ArrayList;
import java.util.List;




import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class FormsFragment extends Fragment{
	
	ListView items;
	ArrayList<String> form_items=new ArrayList<String>();
	
	//Mandatory Constructor
    public FormsFragment() {
    	form_items.add("Withdrawal");
		form_items.add("Deposit");
		form_items.add("Money Transfer");
		form_items.add("Loan Application");
		form_items.add("Demand Draft");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.forms, container, false);
		
		items=(ListView)rootView.findViewById(R.id.list);
		
	    items.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> adapter, View arg1, int pos,
						long arg3) {
					switch(pos)
					{
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					
					}
					
				}
		    	 
		     });
	    items.setAdapter(new FormAdapter(getActivity(),form_items));

		return rootView; 
	
	}
    
   /* public void withdraw_dialog(String type)
	{
    	final Dialog dialog = new Dialog(getActivity());
		dialog.setContentView(R.layout.withdrawal_form);
		dialog.setTitle(type);


		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		dialog.show();
	}
    
    */
}
