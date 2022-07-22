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

public class Login extends AppCompatActivity {
    TextView createacc;
    EditText enteremail,enterpassword;
    Button btn ;
    FirebaseAuth firebaseAuth;
    //String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        createacc=(TextView) findViewById(R.id.textViewSignUp);
        enteremail=findViewById(R.id.inputEmail);
        enterpassword=findViewById(R.id.inputPass);
        btn=findViewById(R.id.btnLogin);
        progressDialog= new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perfromlogin();

            }
        });
    }
    private void perfromlogin(){
        String email=enteremail.getText().toString();
        String password=enterpassword.getText().toString();
            progressDialog.setMessage("Please Wait While Login");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}
