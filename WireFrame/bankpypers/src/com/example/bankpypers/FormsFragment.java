package com.example.bankpypers;


import java.util.ArrayList;
import java.util.List;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class FormsFragment extends Fragment{
	
	ListView list;
	List<String> form_items=new ArrayList<String>();
	
	
	
		//{"Withdrawal","Deposit","Money Transfer","Demand Draft","Loan Application"};
	
	//Mandatory Constructor
    public FormsFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.home, container, false);
		
		list=(ListView)rootView.findViewById(R.id.list);
		form_items.add("Withdrawl");
		form_items.add("Deposit");
		form_items.add("Money Transfer");
		form_items.add("Loan Application");
		form_items.add("Demand Draft");
	
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,form_items);
		list.setAdapter(adapter);
		 	
	    list.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> adapter, View arg1, int pos,
						long arg3) {
					
					
				}
		    	 
		     });
	    
	    	
	    	
		
		 
		 
		 
		return rootView; 
	
	}

}
