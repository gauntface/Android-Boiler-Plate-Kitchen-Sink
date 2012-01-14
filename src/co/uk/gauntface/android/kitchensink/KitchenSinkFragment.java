package co.uk.gauntface.android.kitchensink;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class KitchenSinkFragment extends Fragment {

	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		return initViews(inflater, container, savedInstanceState);
    }
	
	public abstract View initViews(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState);
	
}
