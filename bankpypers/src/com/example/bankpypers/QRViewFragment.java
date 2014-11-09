package com.example.bankpypers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class QRViewFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.code_view, container, false);
		
		ImageView i=(ImageView)rootView.findViewById(R.id.imageView1);
		//if(MainActivity.flag)
		//i.setVisibility(1);
		//else
		//	i.setVisibility(1);
		
		return rootView; 
	
	}

}
