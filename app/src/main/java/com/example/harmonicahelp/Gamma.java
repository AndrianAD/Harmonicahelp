package com.example.harmonicahelp;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.ArrayList;
import static com.example.harmonicahelp.MainActivity.noteList;
import static com.example.harmonicahelp.MainActivity.noteList2;
import static com.example.harmonicahelp.MainActivity.temp;

public class Gamma extends Activity {
    public static TextView major, minor, blues, penta_minor;
    static String gammaview = " ";
    private Button button_ton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamma);


        major = (TextView) findViewById(R.id.gamma_major);
        minor = (TextView) findViewById(R.id.gamma_minor);
        blues = (TextView) findViewById(R.id.gamma_blues);
        penta_minor = (TextView) findViewById(R.id.penta_minor);

        button_ton = (Button) findViewById(R.id.button_ton);
        button_ton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        // Чекбокс мажор
        CheckBox switchCheckBox_major = (CheckBox) findViewById(R.id.switch_check_box_major);
        switchCheckBox_major.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList2.isEmpty()) {
                    return;
                }
                if (noteList.isEmpty()) {
                    noteList = (ArrayList) noteList2.clone();
                }
                getGamma_major(isChecked);
            }
        });

// Чекбокс мінор
        CheckBox switchCheckBox_minor = (CheckBox) findViewById(R.id.switch_check_box_minor);
        switchCheckBox_minor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList2.isEmpty()) {
                    return;
                }
                if (noteList.isEmpty()) {
                    noteList = (ArrayList) noteList2.clone();
                }
                getGamma_minor(isChecked);
            }
        });

// Чекбокс блюз
        CheckBox switchCheckBox_blues = (CheckBox) findViewById(R.id.switch_check_box_blues);
        switchCheckBox_blues.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList2.isEmpty()) {
                    return;
                }
                if (noteList.isEmpty()) {
                    noteList = (ArrayList) noteList2.clone();
                }
                getGamma_blues(isChecked);
            }
        });

        // Чекбокс минорная пентатоника
        CheckBox switchCheckBox_penta_minor = (CheckBox) findViewById(R.id.checkBox_penta_minor);
        switchCheckBox_penta_minor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (noteList2.isEmpty()) {
                    return;
                }
                if (noteList.isEmpty()) {
                    noteList = (ArrayList) noteList2.clone();
                }
                get_minor_pentatonic(isChecked);
            }
        });




}
    public static void getGamma_major(boolean isChecked) {
        int j = 0;
        int int_masiv = 0;
        final int[] masiv = {2, 2, 1, 2, 2, 2, 1};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Hole nots = (Hole) noteList2.get(i);
            Hole tabs = (Hole) noteList2.get(i + temp);
            j++;
            if (j == 7) {
                j = 0;
            }
            gammaview += isChecked ? nots.getNote() + " " : tabs.getTabs() + " ";
        }
        major.setText(gammaview);
        gammaview = "";
    }

    public static void getGamma_minor(boolean isChecked) {
        int j = 0;
        int int_masiv = 0;
        final int[] masiv = {2, 1, 2, 2, 1, 2, 2};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Hole nots = (Hole) noteList2.get(i);
            Hole tabs = (Hole) noteList2.get(i + temp);
            j++;
            if (j == 7) {
                j = 0;
            }
            gammaview += isChecked ? nots.getNote() + " " : tabs.getTabs() + " ";
        }
        minor.setText(gammaview);
        gammaview = "";
    }

    public static void getGamma_blues(boolean isChecked) {
        int j = 0;
        int int_masiv = 0;
        final int[] masiv = {3, 2, 1, 1, 3, 2};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Hole nots = (Hole) noteList2.get(i);
            Hole tabs = (Hole) noteList2.get(i + temp);
            j++;
            if (j == 6) {
                j = 0;
            }
            gammaview += isChecked ? nots.getNote() + " " : tabs.getTabs() + " ";
        }
        blues.setText(gammaview);
        gammaview = "";
    }

    public static void get_minor_pentatonic(boolean isChecked) {
        int j = 0;
        int int_masiv = 0;
        final int[] masiv = {3, 2, 2, 3, 2};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Hole nots = (Hole) noteList2.get(i);
            Hole tabs = (Hole) noteList2.get(i + temp);
            j++;
            if (j == 5) {
                j = 0;
            }
            gammaview += isChecked ? nots.getNote() + " " : tabs.getTabs() + " ";
        }
        penta_minor.setText(gammaview);
        gammaview = "";
    }

    public static void get_major_pentatonic(boolean isChecked) {
        int j = 0;
        int int_masiv = 0;
        final int[] masiv = {2, 2, 3, 2, 3};
        for (int i = 0; i < 37 - temp; i = i + int_masiv) {
            int_masiv = masiv[j];
            Hole nots = (Hole) noteList2.get(i);
            Hole tabs = (Hole) noteList2.get(i + temp);
            j++;
            if (j == 5) {
                j = 0;
            }
            gammaview += isChecked ? nots.getNote() + " " : tabs.getTabs() + " ";
        }
        blues.setText(gammaview);
        gammaview = "";
    }

    }

