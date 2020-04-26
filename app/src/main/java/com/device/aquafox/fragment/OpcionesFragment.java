package com.device.aquafox.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.device.aquafox.R;
import com.device.aquafox.ui.login.LoginActivity;
import com.device.aquafox.ui.notifications.CustomAdapter;
import com.device.aquafox.ui.notifications.NotificationsViewModel;


public class OpcionesFragment extends Fragment {

    ListView simpleList;
    String countryList[] = {"Perfil", "China", "australia", "Salir"};
    int flags[] = {R.drawable.ic_dashboard_black_24dp, R.drawable.ibytes, R.drawable.ic_dashboard_black_24dp, R.drawable.ibytes};

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_opciones, container, false);
    }
*/
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        System.out.println("::::::FRAGMENT OpcionesFragment:::::");

        View root = inflater.inflate(R.layout.fragment_opciones, container, false);

        simpleList = (ListView) root.findViewById(R.id.simpleListView);
        //CustomAdapter customAdapter = new CustomAdapter(root.getApplicationContext(), countryList, flags);
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);


        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("POSITION::"+position);
                System.out.println(countryList[position]);
                if(countryList[position].equals("Salir")) {
                    Intent i = new Intent(getActivity(), LoginActivity.class);
                    startActivity(i);
                }
                if(countryList[position].equals("Perfil")) {
                    //Intent i = new Intent(getActivity(), LoginActivity.class);
                    //startActivity(i);
                    System.out.println("Profile");
                    //Fragment fragmentProfile = new ProfileFragment();
                    //FragmentTransaction transaction =  getActivity().getSupportFragmentManager().beginTransaction();
                    //FragmentTransaction transaction =  getChildFragmentManager().beginTransaction();

                    //getFragmentManager().popBackStack();

                    Navigation.findNavController(view).navigate(R.id.action_navigation_notifications_to_profileFragment);
                    /*
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    //FragmentTransaction transaction =  getChildFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, fragmentProfile);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    */

                }


            }
        });

        return root;
    }

}
