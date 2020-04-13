package com.device.aquafox.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.device.aquafox.R;
import com.device.aquafox.ui.login.LoginActivity;
import com.device.aquafox.ui.login.MainActivity;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    ListView simpleList;
    String countryList[] = {"India", "China", "australia", "Portugle"};
    int flags[] = {R.drawable.ic_dashboard_black_24dp, R.drawable.ibytes, R.drawable.ic_dashboard_black_24dp, R.drawable.ibytes};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        /*
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */
        simpleList = (ListView) root.findViewById(R.id.simpleListView);
        //CustomAdapter customAdapter = new CustomAdapter(root.getApplicationContext(), countryList, flags);
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("POSITION::"+position);
                System.out.println(countryList[position]);
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });

        return root;
    }
}
