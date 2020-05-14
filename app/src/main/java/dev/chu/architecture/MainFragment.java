package dev.chu.architecture;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import dev.chu.architecture.java.p87.MainFragmentModule;

public class MainFragment extends Fragment {
    private String TAG = MainFragment.class.getSimpleName();

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    String activityName;

    @Inject
    int randomNumber;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).getComponent()
                    .mainFragmentComponentBuilder()
                    .setModule(new MainFragmentModule())
                    .setFragment(this)
                    .build()
                    .inject(this);
        }

        Log.i(TAG, "onAttach");
        Log.i(TAG, "activityName = "+activityName);
        Log.i(TAG, "randomNumber = "+randomNumber);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
