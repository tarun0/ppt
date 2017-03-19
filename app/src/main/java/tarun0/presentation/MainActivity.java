package tarun0.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import static tarun0.presentation.R.*;

public class MainActivity extends AppCompatActivity {
    String name;
    String rollno;
    String gender;
    String language1;
    String language2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button button= (Button) findViewById(id.submitButton);
        final EditText nameInput= (EditText) findViewById(id.et_name);
        final EditText rollnoInput= (EditText) findViewById(id.et_roll);
        final Spinner genderInput= (Spinner) findViewById(id.sp_gender);
        final CheckBox languageC= (CheckBox) findViewById(id.cb_c);
        final CheckBox languageJava= (CheckBox) findViewById(id.cb_java);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=nameInput.getText().toString();
                rollno=rollnoInput.getText().toString();
                gender=genderInput.getSelectedItem().toString();
                if(languageC.hasSelection()){
                    language1="C";
                }
                else
                language1=null;
                if(languageJava.hasSelection()){
                    language2="Java";
                }
                else
                    language2=null;

                Intent i=new Intent(MainActivity.this,Details.class);
                i.putExtra("Name",name);
                i.putExtra("Rollno",rollno);
                i.putExtra("Gender",gender);
                i.putExtra("language1",language1);
                i.putExtra("language2",language2);
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
