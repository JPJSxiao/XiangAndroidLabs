package algonquin.cst2355.torunse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import algonquin.cst2355.torunse.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
        TextView mytext = variableBinding.textview;

//        TextView mytext = findViewById(R.id.textview);
//        Button button = findViewById(R.id.mybutton);
//        EditText myedit = findViewById(R.id.myedittext);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//               String editString = myedit.getText().toString();
//                mytext.setText( "Your edit text has: " + editString);
          variableBinding.mybutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
               String editString = variableBinding.myedittext.getText().toString();
                mytext.setText( "Your edit text has: " + editString);

            }
        });

    }

}