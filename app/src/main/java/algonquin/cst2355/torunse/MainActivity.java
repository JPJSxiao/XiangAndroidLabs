package algonquin.cst2355.torunse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2355.torunse.data.MainActivityViewModel;
import algonquin.cst2355.torunse.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    private MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        //setContentView(R.layout.activity_main);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
       // TextView mytext = variableBinding.textview;
        viewModel.isSelected.observe(this, newBooleanValue ->{
            variableBinding.switch1.setChecked(newBooleanValue);
            variableBinding.checkBox.setChecked(newBooleanValue);
            variableBinding.radioButton.setChecked(newBooleanValue);
        });
        variableBinding.radioButton.setChecked(viewModel.isSelected.getValue());
        variableBinding.switch1.setChecked(viewModel.isSelected.getValue());
        variableBinding.checkBox .setChecked(viewModel.isSelected.getValue());


       variableBinding.switch1.setOnCheckedChangeListener((whichButton, isChecked)->{
           viewModel.isSelected.postValue(isChecked);

           Toast
                   .makeText(MainActivity.this, "the boolean is now:" +isChecked, Toast.LENGTH_SHORT)
                   .show();
        });

        variableBinding.radioButton.setOnCheckedChangeListener((whichButton, isChecked)->{
            viewModel.isSelected.postValue(isChecked);

            Toast
                    .makeText(MainActivity.this, "the boolean is now:" +isChecked, Toast.LENGTH_SHORT)
                    .show();
        });

        variableBinding.checkBox.setOnCheckedChangeListener((whichButton, isChecked)->{
            viewModel.isSelected.postValue(isChecked);

            Toast
                    .makeText(MainActivity.this, "the boolean is now:" +isChecked, Toast.LENGTH_SHORT)
                    .show();
        });

        variableBinding.textview.setText("Your edit text has: " + viewModel.editTextContents);

//        TextView mytext = findViewById(R.id.textview);
//        Button button = findViewById(R.id.mybutton);
//        EditText myedit = findViewById(R.id.myedittext);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//               String editString = myedit.getText().toString();
//                mytext.setText( "Your edit text has: " + editString);
//          variableBinding.mybutton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
        variableBinding.mybutton.setOnClickListener( click -> {
                // Code here executes on main thread after user presses button
//               String editString = variableBinding.myedittext.getText().toString();
//                mytext.setText( "Your edit text has: " + editString);
               // viewModel.editTextContents = variableBinding.myedittext.getText().toString();
               // variableBinding.textview.setText("Your edit text has: " + viewModel.editTextContents);
        //    }
            viewModel.editTextContents.postValue(variableBinding.myedittext.getText().toString());
        });

        variableBinding.myimagebutton.setOnClickListener(imageBtn -> {
            Toast
                    .makeText(MainActivity.this,  "The width = " + variableBinding.myimagebutton.getWidth() + " and height = " + variableBinding.myimagebutton.getHeight(), Toast.LENGTH_SHORT)
                    .show();
        });
    }

}