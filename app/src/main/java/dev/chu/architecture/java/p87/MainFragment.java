package dev.chu.architecture.java.p87;

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
import javax.inject.Named;

import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;
import dev.chu.architecture.R;

//public class MainFragment extends Fragment {

// 2. ContributesAndroidInjector 사용
public class MainFragment extends DaggerFragment {

    private String TAG = MainFragment.class.getSimpleName();

//    @Inject
//    SharedPreferences sharedPreferences;
//
//    @Inject
//    String activityName;
//
//    @Inject
//    int randomNumber;
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if(getActivity() instanceof MainActivity) {
//            ((MainActivity) getActivity()).getComponent()
//                    .mainFragmentComponentBuilder()
//                    .setModule(new MainFragmentModule())
//                    .setFragment(this)
//                    .build()
//                    .inject(this);
//        }
//
//        Log.i(TAG, "onAttach");
//        Log.i(TAG, "activityName = "+activityName);
//        Log.i(TAG, "randomNumber = "+randomNumber);
//
//    }

    // 1. 보일러 플레이트 코드 제거

    @Inject
    @Named("app")
    String appString;

    @Inject
    @Named("activity")
    String activityString;

    @Inject
    @Named("fragment")
    String fragmentString;

    @Override
    public void onAttach(@NonNull Context context) {
        Log.e("MainFragment", appString);
        Log.e("MainFragment", activityString);
        Log.e("MainFragment", fragmentString);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
