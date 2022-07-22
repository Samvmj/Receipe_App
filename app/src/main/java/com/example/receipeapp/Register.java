package com.example.receipeapp;



import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    TextView already;
    EditText meditTextTextEmailAddress,meditTextTextPassword,meditTextTextPassword1;
    Button btn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        already = (TextView) findViewById(R.id.textViewSignUp);
        meditTextTextEmailAddress = findViewById(R.id.inputEmail);
        meditTextTextPassword = findViewById(R.id.inputPassword);
        meditTextTextPassword1 = findViewById(R.id.inputConformPassword);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        progressDialog= new ProgressDialog(this);
        btn = findViewById(R.id.btnRegister);
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAuth();
            }
        });
    }
    private void checkAuth(){
        String email=meditTextTextEmailAddress.getText().toString();
        String password=meditTextTextPassword.getText().toString();
        String confirmpassword=meditTextTextPassword1.getText().toString();
        if (!email.matches(emailPattern)||email.isEmpty()) {
            meditTextTextEmailAddress.setError("Enter Connect Email");

        }
        else if(password.isEmpty()||password.length()<6) {
            meditTextTextPassword.setError("Enter Proper password");


        }else if (!password.equals(confirmpassword)) {
            meditTextTextPassword1.setError("Password do not Match");

        }else{

            progressDialog.setMessage("Please Wait While Registartion");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        Intent intent = new Intent(Register.this,Login.class);
                        startActivity(intent);
                        Toast.makeText(Register.this, "Registration Succesful", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(Register.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    }

}
