package co.uk.gauntface.android.kitchensink.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import co.uk.gauntface.android.kitchensink.C;
import co.uk.gauntface.android.kitchensink.KitchenSinkFragment;
import co.uk.gauntface.android.kitchensink.R;
import co.uk.gauntface.android.kitchensink.adapter.GroupAdapter;

public class FormWidgetFragment extends KitchenSinkFragment{
	
	@Override
	public int setFragmentContentView() {
		return R.layout.fragment_form_widget;
	}
	
	@Override
	public void initViews(View v, ViewGroup container,
			Bundle savedInstanceState) {
		
		Spinner disabledSpinner = (Spinner) v.findViewById(R.id.form_widget_spinner_normal_disabled);
		disabledSpinner.setEnabled(false);
	}

}
