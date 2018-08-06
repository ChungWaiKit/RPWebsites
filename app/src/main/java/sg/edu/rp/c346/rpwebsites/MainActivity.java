package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvCategory;
    TextView tvSub;
    Spinner spn1;
    Spinner spn2;
    Button btnGO;
    ArrayList alCategory;
    ArrayAdapter aaCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCategory = findViewById(R.id.textViewCategory);
        tvSub = findViewById(R.id.textViewSub);
        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);
        btnGO = findViewById(R.id.buttonGo);




        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                alCategory.clear();
                switch (i){
                    case 0:
                        String[] strNumbers = getResources().getStringArray(R.array.RP_category);
                        alCategory.addAll(Arrays.asList(strNumbers));
                        aaCategory.notifyDataSetChanged();
                        spn2.setSelection(3);
                        break;
                    case 1:
                        String[] oddNumbers = getResources().getStringArray(R.array.SOI_category);
                        alCategory.addAll(Arrays.asList(oddNumbers));
                        aaCategory.notifyDataSetChanged();
                        spn2.setSelection(2);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos1 = spn1.getSelectedItemPosition();
                int pos2 = spn2.getSelectedItemPosition();


                //if(pos1 == 0){
                   // if(pos2==0){
                      //  Intent intent = new Intent(getBaseContext(), website.class);
                        //intent.putExtra("url", "https://www.rp.edu.sg");
                        //startActivity(intent);
                    //}else {
                      //  Intent intent = new Intent(getBaseContext(), website.class);
                        //intent.putExtra("url", "https://www.rp.edu.sg/student-life");
                        //startActivity(intent);

                    //}


               // }else {
                   // if(pos2 == 0){
                       // Intent intent = new Intent(getBaseContext(), website.class);
                       // intent.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                       // startActivity(intent);
                    //}else{
                        //Intent intent = new Intent(getBaseContext(), website.class);
                        //intent.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                        //startActivity(intent);
                    //}

                //}

                String[][] sites ={{"https://www.rp.edu.sg","https://www.rp.edu.sg/student-life"},{"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47","https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"}};
                String url = sites[spn1.getSelectedItemPosition()][spn2.getSelectedItemPosition()];
                Intent intent = new Intent(getBaseContext(), website.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });


        alCategory = new ArrayList<>();


        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCategory);

        spn2.setAdapter(aaCategory);

    }
}
