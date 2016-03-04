package com.example.snowdark.menu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.snowdark.menu.R;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by SnowDark on 1/24/2016.
 */
public class ProfileFragment extends Fragment {

    @InjectView(R.id.iv_profile)
    ImageView ivPicture;

    @InjectView(R.id.tv_name)
    TextView tvName;

    @InjectView(R.id.tv_email)
    TextView tvEmail;

    @InjectView(R.id.tv_phone)
    TextView tvPhone;

    @InjectView(R.id.tv_birthday)
    TextView tvBirthday;

    public static ProfileFragment newInstance() {

        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        ButterKnife.inject(this, view);
        Profile profile = Profile.getCurrentProfile();
        Picasso.with(getContext()).load(profile.getProfilePictureUri(144, 144)).into(ivPicture);
        tvName.setText(profile.getName());
        return view;
    }
    @OnClick(R.id.img_logout)
    public void onLogout(View v)
    {
        LoginManager.getInstance().logOut();
        Intent i = getActivity().getPackageManager()
                .getLaunchIntentForPackage( getActivity().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getActivity().finish();
        startActivity(i);
    }
}
