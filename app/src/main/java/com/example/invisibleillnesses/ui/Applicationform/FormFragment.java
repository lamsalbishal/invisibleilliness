package com.example.invisibleillnesses.ui.Applicationform;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.invisibleillnesses.R;
import com.example.invisibleillnesses.databinding.FragmentFormBinding;
import com.example.invisibleillnesses.dataholder;
import com.example.invisibleillnesses.ui.Contactus.ContactusFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class FormFragment extends Fragment implements View.OnClickListener {

    private FragmentFormBinding binding;

   FirebaseFirestore firebaseFirestore;
   EditText form_first, form_last, ph_no, form_email, form_residential1, form_residential2, form_birth, cause;
   Button btn_submit;
   TextView formcontact;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


         firebaseFirestore= FirebaseFirestore.getInstance();

        FormViewModel formViewModel =
                new ViewModelProvider(this).get(FormViewModel.class);

        binding = FragmentFormBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        btn_submit  =  view.findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);

        formcontact = view.findViewById(R.id.formcontact);
        formcontact.setOnClickListener(this);

        return view;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }


    @Override
    public void onClick(View view) {
       switch (view.getId()) {
           case R.id.btn_submit: {


        form_first =  view.findViewById(R.id.form_first);
        form_last = view.findViewById(R.id.form_last);
        form_email =  view.findViewById(R.id.form_email);
        form_residential1 =  view.findViewById(R.id.form_residential1);
        form_residential2 =view.findViewById(R.id.form_residential2);
        ph_no = view.findViewById(R.id.ph_no);
        cause = view.findViewById(R.id.cause);
        form_birth =  view.findViewById(R.id.form_birth);


        String FirstName = form_first.getText().toString().trim();
        String Email = form_email.getText().toString().trim();String LastName = form_last.getText().toString().trim();
        String Residential1 = form_residential1.getText().toString().trim();
        String Residential2 = form_residential2.getText().toString().trim();
        String PhoneNumber = ph_no.getText().toString().trim();
        String ReasonForApplication = cause.getText().toString().trim();
        String BirthDate = form_birth.getText().toString().trim();


        dataholder obj = new dataholder(FirstName,Email,LastName,Residential1,Residential2,PhoneNumber,BirthDate,ReasonForApplication);

        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node = db.getReference("Applicants");

        node.child(Email).setValue(obj);

        form_first.setText("");
        form_last.setText("");
        form_email.setText("");
        form_residential1.setText("");
        form_residential2.setText("");
        ph_no.setText("");
        cause.setText("");
        form_birth.setText("");

        Toast.makeText(getActivity(),"Thank you for submitting an application",Toast.LENGTH_LONG).show();

    }
           case R.id.formcontact:{
               Intent intent = new Intent(getContext(), ContactusFragment.class);
               startActivity(intent);
           }

       }

    }
}


