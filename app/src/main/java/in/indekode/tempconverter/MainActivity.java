package in.indekode.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner unit1, unit2;
    TextView cresult;
    EditText fvalue;
    Button calculate;
    String uservalue, res1;
    double calresult;

    String[] units = {"Celsius (°C)","kelvin (K)","Fahrenheit (°F)","Rankine (°R)"};

    static String u1, u2;

    private Firebase mFirebase;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebase = new Firebase("https://tempconvertor.firebaseio.com/");

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("TempConverter");

        unit1 = findViewById(R.id.unit1);
        unit1.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, units);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit1.setAdapter(aa);
        unit1.setOnItemSelectedListener(new SpinnerOneClass());

        unit2 = findViewById(R.id.unit2);
        unit2.setOnItemSelectedListener(this);
        ArrayAdapter<String> bb = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, units);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit2.setAdapter(bb);
        unit2.setOnItemSelectedListener(new SpinnerTwoClass());


        cresult = findViewById(R.id.result);
        fvalue = findViewById(R.id.et_unit1);
        calculate = findViewById(R.id.bt_calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uservalue = fvalue.getText().toString();
                if ( u1.equals("Celsius (°C)") && u2.equals("Celsius (°C)")){
                    cresult.setText("Conversion is: " + uservalue);
                    TempConverter tempConverter = new TempConverter("Celsius (°C)", uservalue, "Celsius (°C)", uservalue);
                    mDatabaseReference.setValue(tempConverter);

                }
                else if ( u1.equals("kelvin (K)") && u2.equals("kelvin (K)")){
                    cresult.setText("Conversion is: " + uservalue);
                }
                else if ( u1.equals("Fahrenheit (°F)") && u2.equals("Fahrenheit (°F)")){
                    cresult.setText("Conversion is: " + uservalue);
                }
                else if ( u1.equals("Rankine (°R)") && u2.equals("Rankine (°R)")){
                    cresult.setText("Conversion is: " + uservalue);
                }
                else if ( u1.equals("Celsius (°C)") && u2.equals("kelvin (K)")){
                    calresult = Double.parseDouble(uservalue)  + 273.15;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("Celsius (°C)") && u2.equals("Fahrenheit (°F)")){
                    calresult = ((Double.parseDouble(uservalue) * 1.8) + 32);
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("Celsius (°C)") && u2.equals("Rankine (°R)")){
                    calresult = Double.parseDouble(uservalue) * 1.8 + 32 + 459.67;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("kelvin (K)") && u2.equals("Celsius (°C)")){
                    calresult = Double.parseDouble(uservalue) - 273.15;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("kelvin (K)") && u2.equals("Fahrenheit (°F)")){
                    calresult = Double.parseDouble(uservalue) * 1.8 - 459.67;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("kelvin (K)") && u2.equals("Rankine (°R)")){
                    calresult = Double.parseDouble(uservalue) * 1.8;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("Fahrenheit (°F)") && u2.equals("Celsius (°C)")){
                    calresult = ((Double.parseDouble(uservalue) - 32) / 1.8);
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("Fahrenheit (°F)") && u2.equals("kelvin (K)")){
                    calresult =  ( Double.parseDouble(uservalue) + 459.67) / 1.8;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("Fahrenheit (°F)") && u2.equals("Rankine (°R)")){
                    calresult = Double.parseDouble(uservalue)  + 273.15;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("Rankine (°R)") && u2.equals("Celsius (°C)")){
                    calresult = (Double.parseDouble(uservalue) - 32 - 459.67) / 1.8;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("Rankine (°R)") && u2.equals("Fahrenheit (°F)")){
                    calresult = Double.parseDouble(uservalue)   - 459.67;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
                else if ( u1.equals("Rankine (°R)") && u2.equals("kelvin (K)")){
                    calresult = Double.parseDouble(uservalue)  / 1.8;
                    res1 = String.valueOf(calresult);
                    cresult.setText("Conversion is: " + res1);
                }
            }
        });



    }

    class SpinnerOneClass implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
        {
            u1 = units[position];
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    class SpinnerTwoClass implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
        {
            u2 = units[position];
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String unitf = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
