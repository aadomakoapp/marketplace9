package edu.msu.cse476.adomakoa.projectmarketplace;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// Import Google Sign-In packages as needed
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import edu.msu.cse476.adomakoa.projectmarketplace.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    // Declare UI elements
    private EditText etFirstName, etLastName, etUsername, etPassword;
    private Button btnCreateAccount;
    private TextView tvSignIn;
    // Google Sign-In client
    private GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Bind UI elements
        etFirstName = findViewById(R.id.editTextFirstName);
        etLastName = findViewById(R.id.editTextLastName);
        etUsername = findViewById(R.id.editTextUsername);
        etPassword = findViewById(R.id.editTextPassword);
        btnCreateAccount = findViewById(R.id.buttonCreateAccount);
        tvSignIn = findViewById(R.id.textViewSignIn);

        // Set up Google Sign-In options
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()  // Request email; add more scopes if needed.
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        // Handle Create Account button click
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Basic validation (expand as necessary)
                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if(firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Proceed with account creation logic
                    Toast.makeText(RegisterActivity.this, "Account Created Successfully!", Toast.LENGTH_SHORT).show();
                    // Redirect to login screen or main app screen as required
                }
            }
        });

        // Handle Google Sign-In button click (assuming the SignInButton from XML works as a normal view)
        findViewById(R.id.googleSignInButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch Google Sign-In intent (integration requires additional handling)
                Intent signInIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 100); // Request code 100
            }
        });

        // Handle navigation to Login screen
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                // Optionally finish the current activity if you don't want to allow back navigation.
            }
        });
    }

    // Handle Google Sign-In result (expand this method with your own handling logic)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            // Process Google Sign-In result here
            Toast.makeText(this, "Google Sign-In clicked!", Toast.LENGTH_SHORT).show();
        }
    }
}