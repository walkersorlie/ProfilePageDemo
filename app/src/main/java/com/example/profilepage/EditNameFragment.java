package com.example.profilepage;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditNameFragment extends Fragment {

    private EditText editName;
    private FragmentViewModel viewModel;

    public EditNameFragment() {
        // Required empty public constructor
    }

    public static EditNameFragment newInstance() {
        EditNameFragment fragment = new EditNameFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_name, container, false);

        final  NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        Button button = view.findViewById(R.id.button);
        editName = view.findViewById(R.id.editTextName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setName(editName.getText().toString());

                navController.navigate(R.id.action_editNameFragment_to_homeFragment);

            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                viewModel.setName(editName.getText().toString());

                navController.navigate(R.id.action_editNameFragment_to_homeFragment);
//                navController.navigateUp();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

//        MenuItem back = view.findViewById(android.R.id.home);
//
//        back.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                viewModel.setName(editName.getText().toString());
//                return true;
//            }
//        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(FragmentViewModel.class);
        viewModel.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                editName.setText(viewModel.getName().getValue());
            }
        });
    }
}