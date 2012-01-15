package co.uk.gauntface.android.kitchensink;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class KitchenSinkFragment extends Fragment {

	private Context mContext;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity().getApplicationContext();
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		View v = inflater.inflate(setFragmentContentView(), null);
		
		initViews(v, container, savedInstanceState);
		
		return v;
    }
	
	public abstract int setFragmentContentView();
	
	public abstract void initViews(View view, ViewGroup container,
            Bundle savedInstanceState);
	
	public Context getApplicationContext() {
		return mContext;
	}
	
}
