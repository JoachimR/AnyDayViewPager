package de.reiss.anydayviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.reiss.anydayviewpager.util.TimeUtils;
import reiss.de.anydayviewpager.R;

public class FragmentContent extends Fragment {

    private String tvContentValue;

    private TextView tvContent;

    private static final String KEY_DATE = "date";

    public static FragmentContent newInstance(long date) {
        FragmentContent fragmentFirst = new FragmentContent();
        Bundle args = new Bundle();
        args.putLong(KEY_DATE, date);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final long millis = getArguments().getLong(KEY_DATE);
        if (millis > 0) {
            final Context context = getActivity();
            if (context != null) {
                tvContentValue = "This is the content for the date " +
                        TimeUtils.getFormattedDate(context, millis);
                return;
            }
        }

        tvContentValue = "";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        tvContent = (TextView) view.findViewById(R.id.tvContent);
        tvContent.setText(tvContentValue);
        return view;
    }

}