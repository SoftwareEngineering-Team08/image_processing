package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class IPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // 전역변수 가져옴.
        ImageProcessor imageProcessor = (ImageProcessor) getApplication() ;

        setContentView(R.layout.tfe_od_choose_camera);

        Switch cameraSwitch = findViewById(R.id.cameraSwitch);
        cameraSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    imageProcessor.setIsBack(true);
                }
                else{
                    imageProcessor.setIsBack(false);
                }
            }
        });

        Switch entranceSwitch = findViewById(R.id.entranceSwitch);
        entranceSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    imageProcessor.setIsRight(true);
                }
                else{
                    imageProcessor.setIsRight(false);
                }
            }
        });

        Button countButton = findViewById(R.id.StartCounting);
        countButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), DetectorActivity.class);
                startActivity(intent);
            }
        });
    }
}
