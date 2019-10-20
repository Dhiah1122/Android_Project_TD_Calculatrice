package com.example.td_calculatrice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private EditText txtprix,res;
    private RadioGroup rdg;
    private RadioButton rd1,rd2;
    private CheckBox chk;
    private Button btncal,btnraz;
    private FloatingActionButton ftq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtprix= (EditText) this.findViewById(R.id.txtprix);
        this.rdg = (RadioGroup) this.findViewById(R.id.rdg);
        this.rd1=(RadioButton) this.findViewById(R.id.rd1);
        this.rd2=(RadioButton) this.findViewById(R.id.rd2);
        this.chk=(CheckBox) this.findViewById(R.id.chk1);
        this.btncal=(Button) this.findViewById(R.id.btncal);
        this.btnraz=(Button) this.findViewById(R.id.btnraz);
        this.res=(EditText) this.findViewById(R.id.res);
        this.ftq=(FloatingActionButton) this.findViewById(R.id.faqt);

        this.ftq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });


        this.btnraz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtprix.setText("");
                rdg.clearCheck();
                chk.setChecked(false);
                res.setText("");
            }
        });

        this.btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtprix.getText().length()==0) {

                    Toast.makeText(MainActivity.this, "S'il vous plait saisie la prix", Toast.LENGTH_LONG).show();

                }
                try {
                    float x;
                    x = Float.parseFloat(txtprix.getText().toString());

                        if (rd1.isChecked())
                        {
                            float tva = x*19/100;
                            float T = tva+x;
                            res.setText(T+" Dt");

                            if (chk.isChecked())
                            {
                                float remise = T*10/100;
                                float Tremise = T-remise;
                                res.setText(Tremise+" Dt");

                            }
                        }
                    if (rd2.isChecked())
                    {
                        float tva = x*12/100;
                        float T = tva+x;
                        res.setText(T+" Dt");

                        if (chk.isChecked())
                        {
                            float remise = T*10/100;
                            float Tremise = T-remise;
                            res.setText(Tremise+" Dt");
                        }
                    }



                } catch (NumberFormatException e) {

                        Toast.makeText(MainActivity.this, "" + e, Toast.LENGTH_LONG).show();
                    }
                }

        });



    }
}
