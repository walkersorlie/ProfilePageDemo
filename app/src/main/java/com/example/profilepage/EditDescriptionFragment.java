package com.example.profilepage;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditDescriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditDescriptionFragment extends Fragment {

    private EditText editDescription;
    private FragmentViewModel viewModel;

    public EditDescriptionFragment() {
        // Required empty public constructor
    }

    public static EditDescriptionFragment newInstance() {
        EditDescriptionFragment fragment = new EditDescriptionFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_description, container, false);

        Button button = (Button) view.findViewById(R.id.button);
        editDescription = (EditText) view.findViewById(R.id.editTextDescription);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setDescription(editDescription.getText().toString());

                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_editDescriptionFragment_to_homeFragment);
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                viewModel.setDescription(editDescription.getText().toString());

                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_editDescriptionFragment_to_homeFragment);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(FragmentViewModel.class);
        viewModel.getDescription().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                editDescription.setText(viewModel.getDescription().getValue());
            }
        });
    }
}