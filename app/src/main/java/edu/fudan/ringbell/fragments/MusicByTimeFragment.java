package edu.fudan.ringbell.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.fudan.ringbell.R;

/**
 * Created by niuzhenghao on 2017/11/27.
 */

public class MusicByTimeFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflater.inflate(resource, null);
        return inflater.inflate(R.layout.fragment_mr_time, container, false);
    }
}
