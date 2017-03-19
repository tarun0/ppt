package tarun0.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    String name;
    String rollno;
    String gender;
    String language1;
    String language2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TextView details= (TextView) findViewById(R.id.detailsView);
        Bundle extras=getIntent().getExtras();
        name= (String) extras.get("Name");
        rollno= (String) extras.get("Rollno");
        gender= (String) extras.get("Gender");
        language1= (String) extras.get("language1");
        language2= (String) extras.get("language2");
        CharSequence det;
        if(language1!=null&&language2!=null){
            det="Name: "+name+"\nRoll Number: "+rollno+"\nGender: "+gender+"\nProgramming Languages known:\n"+language1+"\n"+language2;

        }
        else if(language1==null&&language2==null){
            det="Name: "+name+"\nRoll Number: "+rollno+"\nGender: "+gender+"\nNo Programming Languages known\n";
        }
        else if(language1==null){
            det="Name: "+name+"\nRoll Number: "+rollno+"\nGender: "+gender+"\nProgramming Languages known:\n"+language1;

        }
        else{
            det="Name: "+name+"\nRoll Number: "+rollno+"\nGender: "+gender+"\nProgramming Languages known:\n"+language2;

        }
            details.setText(det);

    }

}
