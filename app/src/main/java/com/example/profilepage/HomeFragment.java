package com.example.profilepage;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private FragmentViewModel viewModel;
    private ImageView imageView;
    private TextView nameTextView;
    private TextView phoneView;
    private TextView emailView;
    private TextView descriptionView;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        phoneView = (TextView) view.findViewById(R.id.phoneView);
        emailView = (TextView) view.findViewById(R.id.emailView);
        descriptionView = (TextView) view.findViewById(R.id.descriptionView);

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewModel.setImage(imageView.get)
//            }
//         }

        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setName(nameTextView.getText().toString());

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_homeFragment_to_editNameFragment);
            }
        });

        phoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setPhone(phoneView.getText().toString());

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_homeFragment_to_editPhoneFragment);
            }
        });

       emailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setEmail(emailView.getText().toString());

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_homeFragment_to_editEmailFragment);
            }
        });

       descriptionView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               viewModel.setDescription(descriptionView.getText().toString());

               NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
               navController.navigate(R.id.action_homeFragment_to_editDescriptionFragment);
           }
       });



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(FragmentViewModel.class);

//        viewModel.getImage().observe(getViewLifecycleOwner(), new Observer<Image>() {
//            @Override
//            public void onChanged(Image image) {
//
//            }
//        });

        viewModel.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                nameTextView.setText(s);
            }
        });

        viewModel.getEmail().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                emailView.setText(s);
            }
        });

        viewModel.getPhone().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                phoneView.setText(s);
            }
        });

        viewModel.getDescription().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                descriptionView.setText(s);
            }
        });
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        Button button = (Button) view.findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
//                navController.navigate(R.id.action_homeFragment_to_editNameFragment);
//
//            }
//        });
//
//        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
//        nameTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewModel.setName(nameTextView.getText().toString());
//
//                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
//                navController.navigate(R.id.action_homeFragment_to_editNameFragment);
//            }
//        });
//    }
}