package com.example.profilepage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    public static final int GET_FROM_GALLERY = 99;

    private static final String TAG = "Home Fragment";

    private FragmentViewModel viewModel;
    private ImageView imageView;
    private FloatingActionButton fab;
    private TextInputEditText editNameTextView;
    private TextInputEditText editPhoneView;
    private TextInputEditText editEmailView;
    private TextInputEditText editDescriptionView;

    private EditText editTextTextPersonName;


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

        imageView = view.findViewById(R.id.imageView);
        fab = view.findViewById(R.id.floatingIcon);
        editNameTextView = view.findViewById(R.id.editNameTextView);
        editPhoneView = view.findViewById(R.id.editPhoneView);
        editEmailView = view.findViewById(R.id.editEmailView);
        editDescriptionView = view.findViewById(R.id.editDescriptionView);

//        editTextTextPersonName = view.findViewById(R.id.editTextTextPersonName);
//        KeyListener mKeyListener = editTextTextPersonName.getKeyListener();
//        editTextTextPersonName.setKeyListener(null);

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewModel.setImage(imageView.get)
//            }
//         }

        final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewModel.setImage(imageView.getDrawable());
//                navController.navigate(R.id.action_homeFragment_to_editImageFragment);
                startActivityForResult(new Intent(Intent.ACTION_GET_CONTENT, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GET_FROM_GALLERY);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_GET_CONTENT, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GET_FROM_GALLERY);
            }
        });

        editNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setName(editNameTextView.getText().toString());

                navController.navigate(R.id.action_homeFragment_to_editNameFragment);
            }
        });

        editPhoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setPhone(editPhoneView.getText().toString());

                navController.navigate(R.id.action_homeFragment_to_editPhoneFragment);
            }
        });

       editEmailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setEmail(editEmailView.getText().toString());

                navController.navigate(R.id.action_homeFragment_to_editEmailFragment);
            }
        });

       editDescriptionView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               viewModel.setDescription(editDescriptionView.getText().toString());

               navController.navigate(R.id.action_homeFragment_to_editDescriptionFragment);
           }
       });

//        editTextTextPersonName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewModel.setName(nameTextView.getText().toString());
//
//                navController.navigate(R.id.action_homeFragment_to_editNameFragment);
//            }
//        });



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(FragmentViewModel.class);

//        viewModel.getImage().observe(getViewLifecycleOwner(), new Observer<Drawable>() {
//            @Override
//            public void onChanged(Drawable drawable) {
//                imageView.setImageDrawable(drawable);
//            }
//        });

        viewModel.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextInputLayout layout = requireView().findViewById(R.id.nameTextView);
                if (s.trim().isEmpty()) {
                    layout.setHintEnabled(true);
                    layout.setHint(layout.getHint());
                }
                else {
                    layout.setHintEnabled(false);
                    editNameTextView.setText(s);
                }
            }
        });

        viewModel.getPhone().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextInputLayout layout = requireView().findViewById(R.id.phoneView);
                if (s.trim().isEmpty()) {
                    layout.setHintEnabled(true);
                    layout.setHint(layout.getHint());
                }
                else {
                    layout.setHintEnabled(false);
                    editPhoneView.setText(s);
                }
            }
        });

        viewModel.getEmail().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextInputLayout layout = requireView().findViewById(R.id.emailView);
                if (s.trim().isEmpty()) {
                    layout.setHintEnabled(true);
                    layout.setHint(layout.getHint());
                }
                else {
                    layout.setHintEnabled(false);
                    editEmailView.setText(s);
                }
            }
        });

        viewModel.getDescription().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextInputLayout layout = requireView().findViewById(R.id.descriptionView);
                if (s.trim().isEmpty()) {
                    layout.setHintEnabled(true);
                    layout.setHint(layout.getHint());
                }
                else {
                    layout.setHintEnabled(false);
                    editDescriptionView.setText(s);
                }
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case GET_FROM_GALLERY:
                    if (resultCode == Activity.RESULT_OK) {
                        Uri image = data.getData();

                        imageView.setImageURI(image);
                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Log.e(TAG, "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception in onActivityResult : " + e.getMessage());
        }

    }
}