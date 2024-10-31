package com.example.btcn_tablayout_bottomnavigation.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.btcn_tablayout_bottomnavigation.Bank.AccountAdapterViewPager;
import com.example.btcn_tablayout_bottomnavigation.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class AccountFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private AccountAdapterViewPager accountAdapterViewPager;
    private View mView;

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_account, container, false);

        tabLayout = mView.findViewById(R.id.tab_layout);
        viewPager2 = mView.findViewById(R.id.account_viewpager);

        // Sử dụng requireActivity() để lấy Activity
        accountAdapterViewPager = new AccountAdapterViewPager(requireActivity());
        viewPager2.setAdapter(accountAdapterViewPager); // Thiết lập adapter cho ViewPager2

        // Sử dụng TabLayoutMediator để kết nối TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Tab 1"); // Đặt tiêu đề cho Tab 1
                        break;
                    case 1:
                        tab.setText("Tab 2"); // Đặt tiêu đề cho Tab 2
                        break;
                    case 2:
                        tab.setText("Tab 3"); // Đặt tiêu đề cho Tab 2
                        break;
                    case 3:
                         // Đặt tiêu đề cho Tab 2
                        break;
                    // Thêm các tab khác nếu cần
                }
            }
        }).attach(); // Kết nối TabLayout với ViewPager2

        return mView;
    }
}
